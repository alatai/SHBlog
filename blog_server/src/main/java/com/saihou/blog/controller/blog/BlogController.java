package com.saihou.blog.controller.blog;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.Constant;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Blog> list() {
        return  blogService.findByStatus(Constant.BLOG_RELEASED);
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlog(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        String content = blog.getContent();

        // markdown -> html
        Parser parser = Parser.builder().build();
        Node document = parser.parse(content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String render = renderer.render(document);

        blog.setContent(render);

        return blog;
    }
}
