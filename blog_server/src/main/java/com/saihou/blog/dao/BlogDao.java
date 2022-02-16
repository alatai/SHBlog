package com.saihou.blog.dao;

import com.saihou.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BlogDao
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 23:02
 */
public interface BlogDao extends JpaRepository<Blog, Integer> {

}
