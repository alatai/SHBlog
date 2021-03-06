package com.saihou.blog.service;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.util.PageResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * BlogService
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 23:03
 */
public interface BlogService {

    List<Blog> findAll();

    PageResult<Blog> findAll(Integer start, Integer size, Integer displayPages);

    Blog findById(Integer id);

    PageResult<Blog> findAllByStatus(Integer status, Integer start, Integer size,
                                     Integer displayPages);

    PageResult<Blog> findAllByCategory(Integer cid, Integer start, Integer size,
                                       Integer displayPages);

    PageResult<Blog> findAllByKeyword(String keyword, Integer start, Integer size,
                                      Integer displayPages);

    Blog insert(Blog blog);

    Blog update(Blog blog);

    void deleteById(Integer id);

    String upload(HttpServletRequest request, MultipartFile image);

    long countAllBlogs();
}
