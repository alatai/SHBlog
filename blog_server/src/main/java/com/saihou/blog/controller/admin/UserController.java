package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.User;
import com.saihou.blog.service.UserService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.RestfulResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 16:52
 */
@RestController("userController")
@RequestMapping("/admin/data")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public RestfulResult<String> login(@RequestBody User user, HttpSession session) {
        System.out.println(user);

        String name = user.getName();
        String password = user.getPassword();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            System.out.println("login success!!");
            subject.login(token);
            User findUser = userService.findByName(name);
            session.setAttribute("user", findUser);

            return new RestfulResult<>(Constant.SUCCESS_STATUS, Constant.SUCCESS_MESSAGE, "login success!");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            return new RestfulResult<>(Constant.SUCCESS_STATUS, Constant.SUCCESS_MESSAGE, e.getMessage());
        }
    }
}
