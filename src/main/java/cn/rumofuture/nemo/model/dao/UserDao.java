package cn.rumofuture.nemo.model.dao;

import cn.rumofuture.nemo.model.domain.User;
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
    int updateUserInfo(User user);
    User findUserById(Integer id);
    User findUserByMobilePhoneNumber(String mobilePhoneNumber);
}
