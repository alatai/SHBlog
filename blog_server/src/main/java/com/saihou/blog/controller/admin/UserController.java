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
    public RestfulResult<String> login(@RequestBody User user, HttpSession session) {
        String name = user.getName();
        String password = user.getPassword();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            subject.login(token);
            User findUser = userService.findByName(name);
            session.setAttribute("user", findUser);

            return new RestfulResult<>(Constant.SUCCESS_STATUS,
                    Constant.SUCCESS_MESSAGE, "login success!");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            return new RestfulResult<>(Constant.SUCCESS_STATUS,
                    Constant.SUCCESS_MESSAGE, e.getMessage());
        }
    }

    @GetMapping("/user")
    public RestfulResult<User> getCurrentUser(HttpSession session) {
        User user = (User) session.getAttribute("user");

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, user);
    }

    @PutMapping("/user")
    public RestfulResult<String> update(@RequestBody Map<String, String> params,
                                        HttpSession session) {
        String oldPassword = params.get("oldPassword");
        String newPassword = params.get("newPassword");
        String newName = params.get("newName");
        User oldUser = (User) session.getAttribute("user");

        if (!userService.passwordCheck(oldUser, oldPassword)) {
            return new RestfulResult<>(Constant.SUCCESS_STATUS,
                    Constant.SUCCESS_MESSAGE, "パスワード間違い");
        } else if (userService.passwordCheck(oldUser, newPassword)) {
            return new RestfulResult<>(Constant.SUCCESS_STATUS,
                    Constant.SUCCESS_MESSAGE, "同じパスワード");
        }

        oldUser.setName(newName);
        oldUser.setPassword(newPassword);

        userService.update(oldUser);

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, "success");
    }

    @GetMapping("/check")
    public RestfulResult<String> checkLogin() {
        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            return new RestfulResult<>(Constant.SUCCESS_STATUS,
                    Constant.SUCCESS_MESSAGE, "fail");
        }

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, "success");
    }
}
