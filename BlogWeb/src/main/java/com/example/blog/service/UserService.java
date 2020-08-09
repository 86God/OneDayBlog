package com.example.blog.service;

import com.example.blog.bean.ArticleList;
import com.example.blog.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(User user);

    Map<String, Object> findUserInfoById(Integer id);

    String findUserByUserName(String userName);

    void reg(User user);

    void updateUserInfo(User user);

    List<Map<String, Object>> findAllTag();

    void updateUserTag(int id, String[] tagList);

    void changePW(Integer useId, String password);

    User verifyOldPW(String userId, String oldPassword);

    List<Map<String, Object>> findViewList(Integer userId);

    void updateUserHeadInfo(Integer userId);

    List<ArticleList> findUserListByPage(Map<String, Object> map);

    int findUserListCount(Map<String, Object> map1);

    List<Map<String, Object>> findCommentList(Integer userId);

    Map<String, Object> ifFocus(Map<String,Object> map);

    void addContact(Map<String, Object> map1);

    void removeContact(Map<String, Object> map1);

    List<ArticleList> findCollectList(Map<String, Object> map1);

    int findCollectListCount(Map<String, Object> map1);

    Map<String,Object> findCreateData(Integer userId);

    List<Map<String, Object>> findTodayHot(Integer userId);

    List<Map<String, Object>> findHistoryHot(Integer userId);

    List<Map<String, Object>> findTodayArtNum(Integer userId);

    List<Map<String, Object>> findTodayViewNum(Integer userId);

    List<Map<String, Object>> findTodayCommentNum(Integer userId);

    List<Map<String, Object>> findWeekArtNum(Integer userId);

    List<Map<String, Object>> findWeekViewNum(Integer userId);

    List<Map<String, Object>> findWeekCommentNum(Integer userId);

    List<Map<String, Object>> findMonthArtNum(Integer userId);

    List<Map<String, Object>> findMonthViewNum(Integer userId);

    List<Map<String, Object>> findMonthCommentNum(Integer userId);
}
