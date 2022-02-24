package com.saihou.blog.controller.blog;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/21 22:55
 */
@RestController("frontBlogController")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public PageResult<Blog> list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                 @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        return blogService.findAllByStatus(Constant.BLOG_RELEASED,
                start, size, Constant.PAGE_RESULT_DISPLAYS);
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlog(@PathVariable Integer id) {
        return blogService.findById(id);
    }

    @GetMapping("/categories/{cid}/blogs")
    public PageResult<Blog> searchByCategory(@PathVariable Integer cid,
                                             @RequestParam(value = "start", defaultValue = "0") Integer start,
                                             @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        return blogService.findAllByCategory(cid, start, size,
                Constant.PAGE_RESULT_DISPLAYS);
    }

    @GetMapping("/blogs/keyword")
    public PageResult<Blog> searchByKeyword(@RequestParam String keyword,
                                            @RequestParam(value = "start", defaultValue = "0") Integer start,
                                            @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        return blogService.findAllByKeyword(keyword, start, size,
                Constant.PAGE_RESULT_DISPLAYS);
    }
}
