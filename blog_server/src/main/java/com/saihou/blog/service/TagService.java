package com.saihou.blog.service;

import com.saihou.blog.entity.Tag;
import com.saihou.blog.util.PageResult;

import java.util.List;

/**
 * TagService
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/12 16:32
 */
public interface TagService {

    List<Tag> findAll();

    PageResult<Tag> findAll(Integer start, Integer size, Integer displayPages);

    Tag findById(Integer id);

    Tag insert(Tag tag);

    Tag update(Tag tag);

    void deleteById(Integer id);
}
