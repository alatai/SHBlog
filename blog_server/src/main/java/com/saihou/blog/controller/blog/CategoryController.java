package com.saihou.blog.controller.blog;

import com.saihou.blog.entity.Category;
import com.saihou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/21 22:56
 */
@RestController("frontCategoryController")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> list() {
        return categoryService.findAll();
    }
}
