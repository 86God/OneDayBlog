package com.example.blog.bean;

import java.util.Date;

public class ArticleList {
    private Integer userId;
    private String userImg;
    private String userNickName;
    private Date artRelTime;
    private String artTitle;
    private String artText;
    private Integer artView;
    private Integer artLikes;
    private Integer artCollect;
    private Integer artCommentNum;
    private String artType;
    private Integer speId;
    private String userName;
    private Integer artId;
    private Integer artEditorType;
    private Integer artPermType;
    private Integer isreg;
    private String speList;
    private String artTypeList;

    public ArticleList() {
    }

    public ArticleList(Integer userId, String userImg, String userNickName, Date artRelTime, String artTitle, String artText, Integer artView, Integer artLikes, Integer artCollect, Integer artCommentNum, String artType, Integer speId, String userName, Integer artId, Integer artEditorType, Integer artPermType, Integer isreg, String speList, String artTypeList) {
        this.userId = userId;
        this.userImg = userImg;
        this.userNickName = userNickName;
        this.artRelTime = artRelTime;
        this.artTitle = artTitle;
        this.artText = artText;
        this.artView = artView;
        this.artLikes = artLikes;
        this.artCollect = artCollect;
        this.artCommentNum = artCommentNum;
        this.artType = artType;
        this.speId = speId;
        this.userName = userName;
        this.artId = artId;
        this.artEditorType = artEditorType;
        this.artPermType = artPermType;
        this.isreg = isreg;
        this.speList = speList;
        this.artTypeList = artTypeList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public Date getArtRelTime() {
        return artRelTime;
    }

    public void setArtRelTime(Date artRelTime) {
        this.artRelTime = artRelTime;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtText() {
        return artText;
    }

    public void setArtText(String artText) {
        this.artText = artText;
    }

    public Integer getArtView() {
        return artView;
    }

    public void setArtView(Integer artView) {
        this.artView = artView;
    }

    public Integer getArtLikes() {
        return artLikes;
    }

    public void setArtLikes(Integer artLikes) {
        this.artLikes = artLikes;
    }

    public Integer getArtCollect() {
        return artCollect;
    }

    public void setArtCollect(Integer artCollect) {
        this.artCollect = artCollect;
    }

    public Integer getArtCommentNum() {
        return artCommentNum;
    }

    public void setArtCommentNum(Integer artCommentNum) {
        this.artCommentNum = artCommentNum;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public Integer getSpeId() {
        return speId;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getArtEditorType() {
        return artEditorType;
    }

    public void setArtEditorType(Integer artEditorType) {
        this.artEditorType = artEditorType;
    }

    public Integer getArtPermType() {
        return artPermType;
    }

    public void setArtPermType(Integer artPermType) {
        this.artPermType = artPermType;
    }

    public Integer getIsreg() {
        return isreg;
    }

    public void setIsreg(Integer isreg) {
        this.isreg = isreg;
    }

    public String getSpeList() {
        return speList;
    }

    public void setSpeList(String speList) {
        this.speList = speList;
    }

    public String getArtTypeList() {
        return artTypeList;
    }

    public void setArtTypeList(String artTypeList) {
        this.artTypeList = artTypeList;
    }

    @Override
    public String toString() {
        return "ArticleList{" +
                "userId=" + userId +
                ", userImg='" + userImg + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", artRelTime=" + artRelTime +
                ", artTitle='" + artTitle + '\'' +
                ", artText='" + artText + '\'' +
                ", artView=" + artView +
                ", artLikes=" + artLikes +
                ", artCollect=" + artCollect +
                ", artCommentNum=" + artCommentNum +
                ", artType='" + artType + '\'' +
                ", speId=" + speId +
                ", userName='" + userName + '\'' +
                ", artId=" + artId +
                ", artEditorType=" + artEditorType +
                ", artPermType=" + artPermType +
                ", isreg=" + isreg +
                ", speList='" + speList + '\'' +
                ", artTypeList='" + artTypeList + '\'' +
                '}';
    }
}
