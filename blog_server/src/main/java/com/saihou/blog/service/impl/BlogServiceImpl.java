package com.saihou.blog.service.impl;

import com.saihou.blog.dao.BlogDao;
import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * BlogServiceImpl
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 23:04
 */
@Service
public class BlogServiceImpl implements BlogService {

    private BlogDao blogDao;

    @Autowired
    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    public PageResult<Blog> findAll(Integer start, Integer size, Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<Blog> page = blogDao.findAll(pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    public Blog findById(Integer id) {
        return blogDao.getById(id);
    }

    @Override
    public Blog insert(Blog blog) {
        blog.setCreatedDate(new Date());
        return blogDao.save(blog);
    }

    @Override
    public Blog update(Blog blog) {
        blog.setModifiedDate(new Date());
        return blogDao.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogDao.deleteById(id);
    }
}
