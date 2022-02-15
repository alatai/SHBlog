package com.saihou.blog.service.impl;

import com.saihou.blog.dao.CategoryDao;
import com.saihou.blog.entity.Category;
import com.saihou.blog.service.CategoryService;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public PageResult<Category> findAll(Integer start, Integer size, Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<Category> page = categoryDao.findAll(pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category insert(Category category) {
        category.setCreatedDate(new Date());
        return categoryDao.save(category);
    }

    @Override
    public Category update(Category category) {
        category.setModifiedDate(new Date());

        return categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }
}
