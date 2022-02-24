package com.saihou.blog.dao;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * BlogDao
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 23:02
 */
public interface BlogDao extends JpaRepository<Blog, Integer> {

    Page<Blog> findByStatusOrderByCreatedDateDesc(int status, Pageable pageable);

    Page<Blog> findByCategoryOrderByCreatedDateDesc(Category category, Pageable pageable);

    Page<Blog> findByTitleLikeOrderByCreatedDateDesc(String keyword, Pageable pageable);
}
