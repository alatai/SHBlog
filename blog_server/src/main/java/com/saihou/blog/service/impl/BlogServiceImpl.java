package com.saihou.blog.service.impl;

import com.saihou.blog.dao.BlogDao;
import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public List<Blog> findByStatus(Integer status) {
        return blogDao.findByStatusOrderByCreatedDateDesc(status);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public Blog insert(Blog blog) {
        blog.setStatus(Constant.BLOG_WAIT_RELEASE);
        blog.setCreatedDate(new Date());
        return blogDao.save(blog);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public Blog update(Blog blog) {
        blog.setModifiedDate(new Date());
        return blogDao.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogDao.deleteById(id);
    }

    @Override
    public String upload(HttpServletRequest request, MultipartFile image) {
        // アップロードパス
        String path = request.getServletContext().getRealPath(Constant.UPLOAD_PATH);
        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

        // ファイル名を設置する
        String filename = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        JSONObject jsonObject = new JSONObject();

        try {
            image.transferTo(new File(path, filename));
            String origin = request.getHeader("Origin");
            String url = origin + Constant.UPLOAD_PATH + filename;

            /*
              {
                success : 0 | 1,       // 0 fail, 1 success
                message : "message",
                url     : "image url"  // return only in success
              }
             */
            jsonObject.put("success", 1);
            jsonObject.put("message", "success");
            jsonObject.put("url", url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

    @Override
    public long countAllBlogs() {
        return blogDao.count();
    }
}
