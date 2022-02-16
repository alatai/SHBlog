package com.saihou.blog.service.impl;

import com.saihou.blog.dao.TagDao;
import com.saihou.blog.entity.Tag;
import com.saihou.blog.service.TagService;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * TagServiceImpl
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/12 16:33
 */
@Service
public class TagServiceImpl implements TagService {

    private TagDao tagDao;

    @Autowired
    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public PageResult<Tag> findAll(Integer start, Integer size, Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<Tag> page = tagDao.findAll(pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    public Tag findById(Integer id) {
        return tagDao.getById(id);
    }

    @Override
    public Tag insert(Tag tag) {
        tag.setCreatedDate(new Date());
        return tagDao.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        tag.setModifiedDate(new Date());
        return tagDao.save(tag);
    }

    @Override
    public void deleteById(Integer id) {
        tagDao.deleteById(id);
    }
}
