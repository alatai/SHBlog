package com.saihou.blog.controller.admin;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ErrorController
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/17 23:06
 */
@Controller("myErrorController")
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handlerError() {
        return "error";
    }

}
