package com.saihou.blog.service;

import com.saihou.blog.entity.Category;

import java.util.List;

/**
 * CategoryService
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/11 13:17
 */
public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    Category insert(Category category);

    Category update(Category category);

    void deleteById(Integer id);
}
