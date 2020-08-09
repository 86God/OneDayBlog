package com.example.blog.mapper;

import com.example.blog.bean.ArticleList;
import com.example.blog.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    User findByUserNamePW(User user);

    void updateUserImg(User user);

    Map<String, Object> findUserInfoById(Integer id);

    String findUserByUserName(String userName);

    void reg(User user);

    void updateUserInfo(User user);

    List<Map<String, Object>> findAllTag();

    void deleteAllUserTag(int id);

    void insertUserTag(Map<String,Object> map);

    int findTagId(String s);

    void changePW(Map<String,Object> map);

    User verifyOldPW(Map<String,Object> map);

    List<Map<String, Object>> findViewList(Integer userId);

    void addHeadInfo(User user);

    void updateUserHeadInfo(Integer userId);

    List<ArticleList> findUserListByPage(Map<String, Object> map);

    int findUserListCount(Map<String, Object> map);

    List<Map<String, Object>> findCommentList(Integer userId);

    Map<String, Object> ifFocus(Map<String,Object> map);

    void addContact(Map<String, Object> map);

    void removeContact(Map<String, Object> map);

    List<ArticleList> findCollectList(Map<String, Object> map);

    int findCollectListCount(Map<String, Object> map);

    int backId();

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
