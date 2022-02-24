package com.saihou.blog.service.impl;

import com.saihou.blog.dao.BlogDao;
import com.saihou.blog.entity.Blog;
import com.saihou.blog.entity.Category;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.service.CategoryService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.PageResult;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "blogs")
public class BlogServiceImpl implements BlogService {

    private BlogDao blogDao;
    private CategoryService categoryService;

    @Autowired
    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @Cacheable(key = "'blogs-all'")
    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    @Cacheable(key = "'blogs-page-'+#p0+'-'+#p1")
    public PageResult<Blog> findAll(Integer start, Integer size, Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<Blog> page = blogDao.findAll(pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    @Cacheable(key = "'blogs-status-'+#p0+'-page-'+#p1+'-'+#p2")
    public PageResult<Blog> findAllByStatus(Integer status, Integer start, Integer size,
                                            Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<Blog> page = blogDao.findByStatusOrderByCreatedDateDesc(status, pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    @Cacheable(key = "'blogs-cid-'+#p0+'-page-'+#p1+'-'+#p2")
    public PageResult<Blog> findAllByCategory(Integer cid, Integer start, Integer size,
                                              Integer displayPages) {
        Category category = categoryService.findById(cid);
        Pageable pageable = PageRequest.of(start, size);
        Page<Blog> page = blogDao.findByCategoryOrderByCreatedDateDesc(category, pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    public PageResult<Blog> findAllByKeyword(String keyword, Integer start, Integer size, Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<Blog> page = blogDao.findByTitleLikeOrderByCreatedDateDesc("%" + keyword + "%", pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    @Cacheable(key = "'blogs-one-'+#p0")
    public Blog findById(Integer id) {
        return blogDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackForClassName = "Exception")
    @CacheEvict(allEntries = true)
    public Blog insert(Blog blog) {
        String markdown = blog.getContent();
        String html = markdown2Html(markdown);

        blog.setHtmlContent(html);
        blog.setStatus(Constant.BLOG_WAIT_RELEASE);
        blog.setCreatedDate(new Date());

        return blogDao.save(blog);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            rollbackForClassName = "Exception")
    @CacheEvict(allEntries = true)
    public Blog update(Blog blog) {
        String markdown = blog.getContent();
        String html = markdown2Html(markdown);

        blog.setHtmlContent(html);
        blog.setModifiedDate(new Date());

        return blogDao.save(blog);
    }

    @Override
    @CacheEvict(allEntries = true)
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
    @Cacheable(key = "'blogs-count'")
    public long countAllBlogs() {
        return blogDao.count();
    }

    /**
     * markdown -> Html
     */
    private String markdown2Html(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        return renderer.render(document);
    }
}
