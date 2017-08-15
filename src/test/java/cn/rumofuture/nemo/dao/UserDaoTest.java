package cn.rumofuture.nemo.dao;

import cn.rumofuture.nemo.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WangZhenqi on 2017/8/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)  // spring的单元测试
@ContextConfiguration({"classpath:spring/spring-*.xml"})  //上下文配置
public class UserDaoTest {

    @Autowired
    private UserDao userDao;  // 初始化Dao层，面向接口编程

    /**
     * 添加用户的单元测试
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("王振琦");
        user.setMobilePhoneNumber("18930721259");
        user.setPassword("wyx51425");
        int result = 0;  // 受影响的行数默认为0
        try {
            result = userDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加用户失败");
        }
        if (result > 0)
            System.out.println("添加用户成功");
    }
}
