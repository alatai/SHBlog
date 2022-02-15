package com.saihou.blog;

import com.saihou.blog.entity.User;
import com.saihou.blog.service.UserService;
import com.saihou.blog.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 10:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testGetUser() {
        User user = userService.findByName("admin");
        String passwordInDb = user.getPassword();
        String salt = user.getSalt();
        String encodedPassword = ShiroUtil.encrypt("123", salt);

        System.out.println(encodedPassword);
        System.out.println(encodedPassword.equals(passwordInDb));
    }
}
