package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/16 16:58
 */
@RestController("blogController")
@RequestMapping("/admin/data")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public PageResult<Blog> list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                 @RequestParam(value = "size", defaultValue = "5") Integer size) {
        start = start < 0 ? 0 : start;
        return blogService.findAll(start, size, 5);
    }

    @GetMapping("/blog/{id}")
    public Blog getBlog(@PathVariable("id") Integer id) {
        return blogService.findById(id);
    }

    @PostMapping("/blogs")
    public String add(@RequestBody Blog blog) {
        blogService.insert(blog);
        return Constant.SUCCESS;
    }

    @PutMapping("/blogs")
    public String update(@RequestBody Blog blog) {
        blogService.update(blog);
        return Constant.SUCCESS;
    }

    @DeleteMapping("/blogs/{id}")
    public void delete(@PathVariable("id") Integer id) {
        blogService.deleteById(id);
    }

    @PostMapping("/img")
    public String upload(HttpServletRequest request,
                         // パラメーターネームはフロントエンド側と同じに
                         @RequestParam("editormd-image-file") MultipartFile image) {
        return blogService.upload(request, image);
    }

}
