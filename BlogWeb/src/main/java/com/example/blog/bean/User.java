package com.example.blog.bean;

public class User {
    private int id;
    private String userName;
    private String nickname;
    private String password;
    private String address;
    private long phoneNum;
    private String identity;
    private String synopsis;
    private String img;
    private String sex;
    private String tag;

    public User() {

    }

    public User(int id, String userName, String nickname, String password, String address, long phoneNum, String identity, String synopsis, String img, String sex, String tag) {
        this.id = id;
        this.userName = userName;
        this.nickname = nickname;
        this.password = password;
        this.address = address;
        this.phoneNum = phoneNum;
        this.identity = identity;
        this.synopsis = synopsis;
        this.img = img;
        this.sex = sex;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum=" + phoneNum +
                ", identity='" + identity + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", img='" + img + '\'' +
                ", sex='" + sex + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
