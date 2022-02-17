package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.PageResult;
import com.saihou.blog.util.RestfulResult;
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
    public RestfulResult<PageResult<Blog>> list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                                @RequestParam(value = "size", defaultValue = "5") Integer size) {
        start = start < 0 ? 0 : start;
        PageResult<Blog> pageResult = blogService.findAll(start, size, 5);

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, pageResult);
    }

    @GetMapping("/blog/{id}")
    public RestfulResult<Blog> getBlog(@PathVariable("id") Integer id) {
        Blog blog = blogService.findById(id);

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, blog);
    }

    @PostMapping("/blogs")
    public RestfulResult<String> add(@RequestBody Blog blog) {
        blogService.insert(blog);

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, "OK!");
    }

    @PutMapping("/blogs")
    public RestfulResult<String> update(@RequestBody Blog blog) {
        blogService.update(blog);

        return new RestfulResult<>(Constant.SUCCESS_STATUS,
                Constant.SUCCESS_MESSAGE, "OK!");
    }

    @PostMapping("/img")
    public String upload(HttpServletRequest request, @RequestParam("editormd-image-file") MultipartFile image) {
        return blogService.upload(request, image);
    }

}
