package com.saihou.blog;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/22 11:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonmarkTest {

    private BlogService blogService;

    @Autowired
    public void setBlogService (BlogService blogService) {
        this.blogService = blogService;
    }

    @Test
    public void testCommonmark() {
        Blog blog = blogService.findById(6);
        String content = blog.getContent();

        Parser parser = Parser.builder().build();
        Node document = parser.parse(content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String render = renderer.render(document);

        System.out.println(render);
    }
}
