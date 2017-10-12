package cn.rumofuture.nemo.service;

import cn.rumofuture.nemo.model.dao.UserDao;
import cn.rumofuture.nemo.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public int userSignUp(User user) {
        return userDao.saveUser(user);
    }

    public boolean canUserSignUp(String mobilePhoneNumber) {
        User user = userDao.findUserByMobilePhoneNumber(mobilePhoneNumber);
        if (user == null)
            return true;
        return false;
    }

    public User userLogIn(String mobilePhoneNumber) {
        return userDao.findUserByMobilePhoneNumber(mobilePhoneNumber);
    }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public int updateUserAvatar(User user) {
        return userDao.updateUserAvatar(user);
    }

    public int updateUserPortrait(User user) {
        return userDao.updateUserPortrait(user);
    }

    public int updateUserPassword(User user) {
        return userDao.updateUserPassword(user);
    }

    public int updateUserInformation(User user) {
        return userDao.updateUserInfo(user);
    }
}
