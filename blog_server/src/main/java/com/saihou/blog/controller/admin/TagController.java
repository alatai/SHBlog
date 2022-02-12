package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.Tag;
import com.saihou.blog.service.TagService;
import com.saihou.blog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TagController
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/12 16:36
 */
@RestController("tagController")
@RequestMapping("/admin/data")
public class TagController {

    private TagService tagService;

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public PageResult<Tag> list(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                @RequestParam(value = "size", defaultValue = "5") Integer size) {
        start = start < 0 ? 0 : start;

        return tagService.findAll(start, size, 5);
    }

    @PostMapping("/tags")
    public void add(@RequestBody Tag tag) {
        tagService.insert(tag);
    }

    @DeleteMapping("/tags/{id}")
    public void delete(@PathVariable("id") Integer id) {
        tagService.deleteById(id);
    }

    @PutMapping("/tags")
    public void update(@RequestBody Tag tag) {
        tagService.update(tag);
    }
}