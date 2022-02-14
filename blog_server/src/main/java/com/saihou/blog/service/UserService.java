package com.saihou.blog.service;

import com.saihou.blog.entity.User;
import com.saihou.blog.util.PageResult;

import java.util.List;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 15:45
 */
public interface UserService {

    List<User> findAll();

    PageResult<User> findAll(Integer start, Integer size, Integer displayPages);

    User findById(Integer id);

    User findByName(String name);

    User insert(User user);

    User update(User user);

    void deleteById(Integer id);
}
