package com.example.blog.bean;

public class Condition {
    private String userId;
    private String artType;
    private Integer pageNum;
    private Integer limit;
    private String speId;
    private String isreg;
    private String artName;

    public Condition() {
    }

    public Condition(String userId, String artType, Integer pageNum, Integer limit, String speId, String isreg, String artName) {
        this.userId = userId;
        this.artType = artType;
        this.pageNum = pageNum;
        this.limit = limit;
        this.speId = speId;
        this.isreg = isreg;
        this.artName = artName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSpeId() {
        return speId;
    }

    public void setSpeId(String speId) {
        this.speId = speId;
    }

    public String getIsreg() {
        return isreg;
    }

    public void setIsreg(String isreg) {
        this.isreg = isreg;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "userId='" + userId + '\'' +
                ", artType='" + artType + '\'' +
                ", pageNum=" + pageNum +
                ", limit=" + limit +
                ", speId='" + speId + '\'' +
                ", isreg='" + isreg + '\'' +
                ", artName='" + artName + '\'' +
                '}';
    }
}
