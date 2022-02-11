package com.saihou.blog.service.impl;

import com.saihou.blog.dao.CategoryDao;
import com.saihou.blog.entity.Category;
import com.saihou.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryServiceImpl
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/11 13:18
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category insert(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }
}
