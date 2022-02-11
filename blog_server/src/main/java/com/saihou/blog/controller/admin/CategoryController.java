package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.Category;
import com.saihou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CategoryController
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/11 13:20
 */
// すべてのメソッドのリターンはJSONタイプにする
@RestController("categoryController")
@RequestMapping("/admin/data")
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
