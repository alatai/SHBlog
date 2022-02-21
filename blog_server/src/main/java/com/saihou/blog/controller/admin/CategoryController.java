package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.Category;
import com.saihou.blog.service.CategoryService;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public PageResult<Category> list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                     @RequestParam(value = "size", defaultValue = "5") Integer size) {
        start = start < 0 ? 0 : start;

        return categoryService.findAll(start, size, 5);
    }

    @PostMapping("/categories")
    public void add(@RequestBody Category category) {
        categoryService.insert(category);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable("id") Integer id) {
        categoryService.deleteById(id);
    }

    @PutMapping("/categories")
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }
}
