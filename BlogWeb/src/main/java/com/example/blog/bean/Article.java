package com.example.blog.bean;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private Integer userId;
    private String content;
    private Integer likes;
    private Integer collect;
    private Date releaseTime;
    private Integer pageView;
    private Integer commentNum;
    private Integer permType;
    private String text;
    private Integer editorType;
    private Integer isreg;

    public Article() {
    }

    public Article(Integer id, String title, Integer userId, String content, Integer likes, Integer collect, Date releaseTime, Integer pageView, Integer commentNum, Integer permType, String text, Integer editorType, Integer isreg) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.content = content;
        this.likes = likes;
        this.collect = collect;
        this.releaseTime = releaseTime;
        this.pageView = pageView;
        this.commentNum = commentNum;
        this.permType = permType;
        this.text = text;
        this.editorType = editorType;
        this.isreg = isreg;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Date getRelease_time() {
        return releaseTime;
    }

    public void setRelease_time(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getPermType() {
        return permType;
    }

    public void setPermType(Integer permType) {
        this.permType = permType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getEditorType() {
        return editorType;
    }

    public void setEditorType(Integer editorType) {
        this.editorType = editorType;
    }

    public Integer getIsreg() {
        return isreg;
    }

    public void setIsreg(Integer isreg) {
        this.isreg = isreg;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", collect=" + collect +
                ", releaseTime=" + releaseTime +
                ", pageView=" + pageView +
                ", commentNum=" + commentNum +
                ", permType=" + permType +
                ", text='" + text + '\'' +
                ", editorType=" + editorType +
                ", isreg=" + isreg +
                '}';
    }
}
