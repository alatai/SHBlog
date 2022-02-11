package com.saihou.blog.dao;

import com.saihou.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CategoryDao
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/11 13:16
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
