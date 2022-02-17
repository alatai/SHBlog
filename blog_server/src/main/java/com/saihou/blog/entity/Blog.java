package com.saihou.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saihou.blog.util.Constant;

import javax.persistence.*;
import java.util.Date;

/**
 * ブログ
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/15 22:52
 */
@Entity
@Table(name = "Blog")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String title;

    private String subtitle;

    private String content;

    // ブログの状態
    // 0: WAIT_RELEASE
    // 1: RELEASED
    // 2: DELETED
    private Integer status;

    private Date createdDate;

    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    @Transient
    private String statusDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStatusDesc() {
        String desc;

        switch (status) {
            case Constant.BLOG_WAIT_RELEASE:
                desc = Constant.BLOG_WAIT_RELEASE_DESC;
                break;
            case Constant.BLOG_RELEASED:
                desc = Constant.BLOG_RELEASED_DESC;
                break;
            case Constant.BLOG_DELETED:
                desc = Constant.BLOG_DELETED_DESC;
                break;
            default:
                desc = Constant.BLOG_ERROR_DESC;
        }

        return desc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", category=" + category +
                ", statusDesc='" + statusDesc + '\'' +
                '}';
    }
}
