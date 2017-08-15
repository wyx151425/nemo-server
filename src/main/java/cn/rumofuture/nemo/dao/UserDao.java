package cn.rumofuture.nemo.dao;

import cn.rumofuture.nemo.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

@Mapper
public interface UserDao {
    int saveUser(User user);
    int updateUserAvatar(User user);
    int updateUserPortrait(User user);
    int updateUserPassword(User user);
    int updateUserInformation(User user);
    User findUserById(Integer id);
    User findUserByMobilePhoneNumber(String mobilePhoneNumber);
}
