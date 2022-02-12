package com.saihou.blog.dao;

import com.saihou.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TagDao
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/12 16:31
 */
public interface TagDao extends JpaRepository<Tag, Integer> {

}
