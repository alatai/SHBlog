package com.saihou.blog.controller.admin;

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
}
