package com.saihou.blog.util;

/**
 * RESTful API
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 17:03
 */
public class RestfulResult<T> {

    private int status;
    private String message;
    private T content;

    public int getStatus() {
        return status;
    }

    public RestfulResult(int status, String message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
