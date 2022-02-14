package com.saihou.blog.interceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログインインターセプター
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 16:29
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String ctx = session.getServletContext().getContextPath();

        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            response.sendRedirect(ctx + "/admin/login");

            return false;
        }

        return true;
    }
}
