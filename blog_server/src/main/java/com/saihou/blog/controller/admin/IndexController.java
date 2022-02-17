package com.saihou.blog.controller.admin;

import com.saihou.blog.service.BlogService;
import com.saihou.blog.service.CategoryService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.RestfulResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Adminホームページ
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/17 22:17
 */
@RestController("indexController")
@RequestMapping("/admin/data")
public class IndexController {

    private BlogService blogService;
    private CategoryService categoryService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/index")
    public RestfulResult<Map<String, Long>> index() {
        long blogs = blogService.countAllBlogs();
        long categories = categoryService.countAllCategories();

        Map<String, Long> result = new HashMap<>();
        result.put("blogs", blogs);
        result.put("categories", categories);

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, result);
    }
}
