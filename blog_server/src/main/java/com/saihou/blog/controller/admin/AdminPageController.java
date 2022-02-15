package com.saihou.blog.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ページ遷移
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/11 13:11
 */
@Controller("adminPageController")
@RequestMapping("/admin")
public class AdminPageController {

    /**
     * 管理サイトホームページ
     */
    @GetMapping("/index")
    public String header() {
        return "index";
    }

    /**
     * カテゴリページ
     */
    @GetMapping("/categories")
    public String listCategories() {
        return "category/list";
    }

    /**
     * タグページ
     */
    @GetMapping("/tags")
    public String listTags() {
        return "tag/list";
    }

    /**
     * ログインページ
     */
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    /**
     * ログアウトして，ログインページに移動
     */
    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            subject.logout();
        }

        return "redirect:/admin/login";
    }

    /**
     * パスワード管理ページ
     */
    @GetMapping("/profile")
    public String profile() {
        return "user/profile";
    }
}
