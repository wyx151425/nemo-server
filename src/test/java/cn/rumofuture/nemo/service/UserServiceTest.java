package cn.rumofuture.nemo.service;

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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void logInTest() {
        User resultUser = userService.userLogIn("15253620357");
        System.out.println(resultUser);
    }
}
