package com.saihou.blog.dao;

import com.saihou.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 15:44
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByName(String name);
}
