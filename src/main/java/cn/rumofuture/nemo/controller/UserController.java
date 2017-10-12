package cn.rumofuture.nemo.controller;

import cn.rumofuture.nemo.model.domain.User;
import cn.rumofuture.nemo.model.dto.ResponseUser;
import cn.rumofuture.nemo.service.UserService;
import cn.rumofuture.nemo.util.utils.DataUtils;
import cn.rumofuture.nemo.util.utils.FilePathUtils;
import cn.rumofuture.nemo.util.utils.PromptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册方法，逻辑如下：
     * 1. 检查前端数据封装结果；检查姓名，手机号和密码是否为空；检查手机号格式是否正确；
     * 2. 根据用手机号查询用户数据，检查此用户是否已注册过；如果无法根据手机号查询到用户数据，
     * 则此用户未注册，可以开始注册操作，否则返回此用户已注册的提示信息；
     * 3. 将此用户信息对象保存到数据库中，并获取操作影响的数据库行数；
     * 4. 如果返回结果为1，则用户信息成功保存到数据库中，用户注册成功；
     * 如果返回结果为0，则用户信息保存失败，用户注册失败。
     *
     * @param user 前端数据封装成的User类对象
     * @return
     */
    @PostMapping(value = "/signup")
    public Object userSignUp(@RequestBody User user) {
        // 检查前端数据是否封装成功
        if (DataUtils.isDataEmpty(user)) {
            return new ResponseUser(false, PromptUtils.DATA_TRANSMISSION_FAILED, null);
        }

        // 检查姓名，手机号和密码是否不为空
        if (DataUtils.isStringDataEmpty(user.getName(), user.getMobilePhoneNumber(), user.getPassword())) {
            return new ResponseUser(false, PromptUtils.USER_SIGN_UP_INFORMATION_IMPROVE_REQUEST, null);
        }

        // 检查手机号格式是否正确
        if (!DataUtils.isMobilePhoneNumber(user.getMobilePhoneNumber())) {
            return new ResponseUser(false, PromptUtils.MOBILE_PHONE_NUMBER_FORMAT_ERROR, null);
        }

        // 检查此手机号是否已经注册过
        boolean result = userService.canUserSignUp(user.getMobilePhoneNumber());

        // 如果此手机号为注册过，执行如下操作
        if (result) {
            // 完善用户信息
            user.setAvatarUrl("");
            user.setPortraitUrl("");
            user.setMotto("");
            user.setEmail("");
            user.setLocation("");
            user.setProfession("");
            user.setProfile("");
            user.setGender("男");
            user.setAge(0);
            user.setBookTotal(0);
            user.setFollowTotal(0);
            user.setFollowerTotal(0);
            user.setFavoriteTotal(0);
            user.setBirthday(String.valueOf(LocalDate.now()));
            user.setCreateTime(LocalDateTime.now().withNano(0));
            user.setUpdateTime(LocalDateTime.now().withNano(0));
            // 将用户信息保存到数据库中
            int saveResult = userService.userSignUp(user);
            // 如果数据库操作影响行数为1，则用户信息保存成功，即注册成功
            if (1 == saveResult) {
                user.setCreateTime(null);
                user.setUpdateTime(null);
                return new ResponseUser(true, PromptUtils.USER_SIGN_UP_SUCCESS, user);
            } else {
                return new ResponseUser(false, PromptUtils.USER_SIGN_UP_FAILED, null);
            }
        }
        // 如果此手机号已注册过，执行如下操作
        else {
            return new ResponseUser(false, PromptUtils.USER_ALREADY_EXISTS, null);
        }
    }

    /**
     * 用户登录方法，逻辑如下：
     * 1. 检查前端数据封装结果；检查手机号和密码是否为空；检查手机号格式是否正确；
     * 2. 根据用手机号查询用户数据，返回查询到的具有完整用户信息的用户对象；
     * 3. 如果查询结果为空，则说名未存储当前手机号对应的用户信息，即当前手机号未注册；
     * 4. 如果查询不为空，且密码匹配成功，则用户登录成功；如果密码匹配失败，则密码错误，登录失败；
     *
     * @param user 前端数据封装成的User类对象
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseUser userLogIn(@RequestBody User user) {
        // 检查前端数据是否封装成功
        if (DataUtils.isDataEmpty(user))
            return new ResponseUser(false, PromptUtils.DATA_TRANSMISSION_FAILED, null);

        // 检查手机号和密码是否不为空
        if (DataUtils.isStringDataEmpty(user.getMobilePhoneNumber(), user.getPassword()))
            return new ResponseUser(false, PromptUtils.USER_LOG_IN_INFORMATION_IMPROVE_REQUEST, null);

        // 检查手机号格式是否正确
        if (!DataUtils.isMobilePhoneNumber(user.getMobilePhoneNumber()))
            return new ResponseUser(false, PromptUtils.MOBILE_PHONE_NUMBER_FORMAT_ERROR, null);

        // 根据手机号访问数据库，并返回查询结果
        User resultUser = userService.userLogIn(user.getMobilePhoneNumber());

        // 如果查询结果为空，则此手机号并未注册
        if (null == resultUser)
            return new ResponseUser(false, PromptUtils.USER_DOES_NOT_EXIST, null);
        else {
            // 如果密码匹配成功，则登录成功
            if (user.getPassword().equals(resultUser.getPassword())) {
                // 创建时间和更新时间前端不可见
                resultUser.setCreateTime(null);
                resultUser.setUpdateTime(null);
                return new ResponseUser(true, PromptUtils.USER_LOG_IN_SUCCESS, resultUser);
            }
            // 如果密码匹配失败，则登录失败
            else {
                return new ResponseUser(false, PromptUtils.PASSWORD_ERROR, null);
            }
        }
    }

    /**
     * 用户原密码和新密码方式修改密码的方法：逻辑如下：
     * 1. 根据前端提交的id获取具有完整信息的用户对象，校验原密码是否正确；
     * 2. 如果原密码正确，则为用户对象设置新密码，并更新数据库中的用户信息，返回影响的数据库记录数；
     * 3. 若影响的数据库记录数为1，则更新成功；否则更新失败；
     *
     * @param id          请求此操作的用户的id
     * @param oldPassword 用户原密码
     * @param newPassword 用户新密码
     * @return
     */
    @PutMapping(value = "/password/update")
    public ResponseUser userPasswordUpdate(
            @RequestParam("id") Integer id,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword
    ) {
        ResponseUser responseUser;

        // 根据前端提交的用户id获取具有完整信息的用户对象
        User targetUser = userService.findUserById(id);

        if (null != targetUser) {
            // 如果原密码输入正确，则执行如下操作
            if (targetUser.getPassword().equals(oldPassword)) {
                targetUser.setPassword(newPassword);  // 设置新密码
                // 更新用户信息，返回影响的数据库记录数
                int result = userService.updateUserPassword(targetUser);
                // 更新成功，执行如下操作
                if (1 == result) {
                    // 创建时间和更新时间前端不可见
                    targetUser.setCreateTime(null);
                    targetUser.setUpdateTime(null);
                    responseUser = new ResponseUser(true, PromptUtils.USER_PASSWORD_UPDATE_SUCCESS, targetUser);
                } else
                    responseUser = new ResponseUser(false, PromptUtils.USER_PASSWORD_UPDATE_FAILED, null);
            }
            // 原密码输入错误，则进行如下操作
            // * 前端应执行校验逻辑率先校验原密码是否正确，如果此操作执行，则说明前端界面被恶意修改
            else
                responseUser = new ResponseUser(false, PromptUtils.OLD_PASSWORD_ERROR, null);
        }
        // 因为没有获取数据库中的用户信息，所以无法执行校验，修改密码过程终止
        else
            responseUser = new ResponseUser(false, PromptUtils.DATA_TRANSMISSION_FAILED, null);

        return responseUser;
    }

    /**
     * 用户个人信息修改方法，逻辑如下：
     * 1. 检查前端数据封装结果；检查对象id是否为空；依次检查各项信息是否为null；
     * 2. 设置用户更新日期，并更新当前用户对象，获取更新影响的数据库记录的行数；
     * 3. 如果影响了一条数据库记录，则用户信息更新成功，获取最新的用户信息，并返回；
     * 4. 如果最新的用户信息获取失败，则返回更新成功提示信息，但不返回最新的用户信息对象；
     * 5. 如果用户信息更新失败，则返回更新失败提示消息；
     *
     * @param user 前端数据封装成的User类对象
     * @return responseEntity
     */
    @PutMapping(value = "/information/update")
    public ResponseUser userInformationUpdate(
            @RequestBody User user,
            @RequestParam("name") String name,
            @RequestParam("motto") String motto,
            @RequestParam("location") String location
    ) {
        ResponseUser responseUser;
        // 检查对象id是否为空
        if (DataUtils.isIdEmpty(user.getId()))
            return new ResponseUser(false, PromptUtils.DATA_TRANSMISSION_FAILED, null);

        // 检查数据是否为null，需要检查的数据有：姓名，座右铭，位置，职业，简介，性别，年龄，生日
        if (DataUtils.isDataNull(user.getName(), user.getMotto(), user.getLocation(), user.getProfession(),
                user.getProfile(), user.getGender(), user.getAge(), user.getBirthday()))
            return new ResponseUser(false, PromptUtils.DATA_TRANSMISSION_FAILED, null);

        // 设置更新时间为当前时间
        user.setUpdateTime(LocalDateTime.now().withNano(0));
        // 更新用户信息并返回数据库影响的行数
        int result = userService.updateUserInformation(user);

        // 如果数据更新成功，则执行如下操作
        if (1 == result) {
            // 获取最新的用户信息，并封装为User对象
            User targetUser = userService.findUserById(user.getId());
            if (targetUser != null) {
                // 创建时间和更新时间前端不可见
                targetUser.setCreateTime(null);
                targetUser.setUpdateTime(null);
                return new ResponseUser(true, PromptUtils.USER_INFORMATION_UPDATE_SUCCESS, targetUser);
            }
        }
        // 如果数据更新失败，则执行如下操作
        return new ResponseUser(true, PromptUtils.USER_INFORMATION_UPDATE_FAILED, null);
    }

    /**
     * 用户头像上传方法，逻辑如下：
     * 1. 首先判断id和头像文件是否为空，任何一项为空就返回文件上传失败提示信息；
     * 2. 获取文件保存路径，获取文件名称，创建文件对象，判断前端提交文件是否为图片；
     * 3. 根据文件保存路径创建文件目录对象，检查父级目录是否都已创建；
     * 4. 将文件保存到制定路径下，返回保存成功信息；若保存中产生异常，则说名保存失败；
     *
     * @param userId              目标用户id
     * @param avatarMultipartFile 前端提交的用户头像图片文件
     * @return
     */
    @PostMapping(value = "/avatar/upload")
    public ResponseUser userAvatarUpload(
            @RequestParam("id") Integer userId,
            @RequestParam("avatar") MultipartFile avatarMultipartFile
    ) {
        // 检查接受前端文件的对象和id是否为空
        if (!avatarMultipartFile.isEmpty() && !DataUtils.isIdEmpty(userId)) {
            String avatarSavePath = FilePathUtils.getUserAvatarPath(userId);
            String avatarFileName = avatarMultipartFile.getOriginalFilename();

            // 根据文件名的后缀检查文件是否为图片文件
            // ***** 此验证过程并不严谨 *****
            if (!DataUtils.isImage(avatarFileName)) {
                return new ResponseUser(false, PromptUtils.FILE_FORMAT_ERROR, null);
            }

            // 根据保存路径创建目录文件对象，检查保存文件的目录是否已经创建
            File avatarSavePathDir = new File(avatarSavePath, avatarFileName);
            if (!avatarSavePathDir.getParentFile().exists())
                avatarSavePathDir.getParentFile().mkdirs();

            try {
                // 将文件保存到指定路径下，如果保存过程中产生异常，则说明保存失败
                avatarMultipartFile.transferTo(new File(avatarSavePath + avatarFileName));
                return new ResponseUser(false, PromptUtils.FILE_UPLOAD_SUCCESS, null);
            } catch (IOException e) {
                return new ResponseUser(false, PromptUtils.FILE_UPLOAD_FAILED, null);
            }
        }
        // 如果MultipartFile或id为空，则文件上传失败
        else {
            return new ResponseUser(false, PromptUtils.FILE_UPLOAD_FAILED, null);
        }
    }

    /**
     * 用户个人肖像上传方法，逻辑如下：
     * 1. 首先判断id和个人肖像文件是否为空，任何一项为空就返回文件上传失败提示信息；
     * 2. 获取文件保存路径，获取文件名称，创建文件对象，判断前端提交文件是否为图片；
     * 3. 根据文件保存路径创建文件目录对象，检查父级目录是否都已创建；
     * 4. 将文件保存到制定路径下，返回保存成功信息；若保存中产生异常，则说名保存失败；
     *
     * @param userId                目标用户id
     * @param portraitMultipartFile 前端提交的用户个人肖像图片文件
     * @return
     */
    @PostMapping(value = "/portrait/upload")
    public ResponseUser userPortraitUpload(
            @RequestParam("id") Integer userId,
            @RequestParam("portrait") MultipartFile portraitMultipartFile
    ) {
        // 检查接受前端文件的对象和id是否为空
        if (!portraitMultipartFile.isEmpty() && !DataUtils.isIdEmpty(userId)) {
            String portraitSavePath = FilePathUtils.getUserPortraitPath(userId);
            String portraitFileName = portraitMultipartFile.getOriginalFilename();

            // 根据文件名的后缀检查文件是否为图片文件
            // ***** 此验证过程并不严谨 *****
            if (!DataUtils.isImage(portraitFileName)) {
                return new ResponseUser(false, PromptUtils.FILE_FORMAT_ERROR, null);
            }

            // 根据保存路径创建目录文件对象，检查保存文件的目录是否已经创建
            File portraitSavePathDir = new File(portraitSavePath, portraitFileName);
            if (!portraitSavePathDir.getParentFile().exists())
                portraitSavePathDir.getParentFile().mkdir();

            try {
                // 将文件保存到指定路径下，如果保存过程中产生异常，则说明保存失败
                portraitMultipartFile.transferTo(new File(portraitSavePath + portraitFileName));
                return new ResponseUser(false, PromptUtils.FILE_UPLOAD_SUCCESS, null);
            } catch (IOException e) {
                return new ResponseUser(false, PromptUtils.FILE_UPLOAD_FAILED, null);
            }
        }
        // 如果MultipartFile或id为空，则文件上传失败
        else {
            return new ResponseUser(false, PromptUtils.FILE_UPLOAD_FAILED, null);
        }
    }
}
