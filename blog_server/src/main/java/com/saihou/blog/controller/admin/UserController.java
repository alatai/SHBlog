package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.User;
import com.saihou.blog.service.UserService;
import com.saihou.blog.util.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
    public String login(@RequestBody User user, HttpSession session) {
        String name = user.getName();
        String password = user.getPassword();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            subject.login(token);
            User findUser = userService.findByName(name);
            session.setAttribute("user", findUser);

            return Constant.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            return Constant.LOGIN_FAIL;
        }
    }

    @GetMapping("/user")
    public User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    @PutMapping("/user")
    public String update(@RequestBody Map<String, String> params, HttpSession session) {
        String oldPassword = params.get("oldPassword");
        String newPassword = params.get("newPassword");
        String newName = params.get("newName");
        User oldUser = (User) session.getAttribute("user");

        if (!userService.passwordCheck(oldUser, oldPassword)) {
            return Constant.PASSWORD_MISTAKE;
        } else if (userService.passwordCheck(oldUser, newPassword)) {
            return Constant.PASSWORD_SAME;
        }

        oldUser.setName(newName);
        oldUser.setPassword(newPassword);
        userService.update(oldUser);

        return Constant.SUCCESS;
    }

    @GetMapping("/check")
    public String checkLogin() {
        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            return Constant.FAIL;
        }

        return Constant.SUCCESS;
    }
}
