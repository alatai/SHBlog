package com.saihou.blog.controller.admin;

import com.saihou.blog.entity.Blog;
import com.saihou.blog.service.BlogService;
import com.saihou.blog.util.Constant;
import com.saihou.blog.util.RestfulResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

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

    @PostMapping("/blog")
    public RestfulResult<String> add(@RequestBody Blog blog) {
        blogService.insert(blog);

        return new RestfulResult<String>(Constant.SUCCESS_STATUS, Constant.SUCCESS_MESSAGE, "OK!");
    }

    @PostMapping("/img")
    public String upload(HttpServletRequest request,
                         @RequestParam("editormd-image-file")
                                 MultipartFile image) {
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
                success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
                message : "提示的信息，上传成功或上传失败及错误信息等。",
                url     : "图片地址"        // 上传成功时才返回
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

}
