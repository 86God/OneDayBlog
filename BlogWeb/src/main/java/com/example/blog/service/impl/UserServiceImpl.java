package com.example.blog.service.impl;

import com.example.blog.bean.ArticleList;
import com.example.blog.bean.User;

import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.findByUserNamePW(user);
    }

    @Override
    public Map<String, Object> findUserInfoById(Integer id) {
        Map<String, Object> map = userMapper.findUserInfoById(id);
        String tag = (String) map.get("tagList");
        if(tag != null && tag != ""){
            String[] tagList = tag.split(",");
            map.put("tagList",tagList);
        }
        return map;
    }

    @Override
    public String findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    @Transactional
    public void reg(User user) {
        //注册用户
        userMapper.reg(user);
        //返回最新插入的主键
        int userId = userMapper.backId();
        //设置用户主键
        user.setId(userId);
        //添加用户主页的头信息
        userMapper.addHeadInfo(user);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public List<Map<String, Object>> findAllTag() {
        return userMapper.findAllTag();
    }

    @Override
    public void updateUserTag(int id, String[] tagList) {
        userMapper.deleteAllUserTag(id);
        List<Integer> tagId = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        for(int i = 0;i<tagList.length;i++){
            int tId = userMapper.findTagId(tagList[i]);
            map.put("tId",tId);
            userMapper.insertUserTag(map);
        }
    }

    @Override
    public void changePW(Integer useId, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("useId",useId);
        map.put("password",password);
        userMapper.changePW(map);
    }

    @Override
    public User verifyOldPW(String userId, String oldPassword) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("oldPassword",oldPassword);
        return userMapper.verifyOldPW(map);
    }

    @Override
    public List<Map<String, Object>> findViewList(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        return userMapper.findViewList(userId);
    }

    @Override
    public void updateUserHeadInfo(Integer userId) {
        userMapper.updateUserHeadInfo(userId);
    }

    @Override
    public List<ArticleList> findUserListByPage(Map<String, Object> map) {
        int start = ((int)map.get("pageNum") - 1)*(int)map.get("limit");
        map.put("start",start);
        return userMapper.findUserListByPage(map);
    }

    @Override
    public int findUserListCount(Map<String, Object> map) {
        return userMapper.findUserListCount(map);
    }

    @Override
    public List<Map<String, Object>> findCommentList(Integer userId) {
        return userMapper.findCommentList(userId);
    }

    @Override
    public Map<String, Object> ifFocus(Map<String,Object> map) {
        return userMapper.ifFocus(map);
    }

    @Override
    public void addContact(Map<String, Object> map) {
        userMapper.addContact(map);
    }

    @Override
    public void removeContact(Map<String, Object> map) {
        userMapper.removeContact(map);
    }

    @Override
    public List<ArticleList> findCollectList(Map<String, Object> map) {
        int start = ((int)map.get("pageNum") - 1)*(int)map.get("limit");
        map.put("start",start);
        return userMapper.findCollectList(map);
    }

    @Override
    public int findCollectListCount(Map<String, Object> map) {
        return userMapper.findCollectListCount(map);
    }

    @Override
    public Map<String,Object> findCreateData(Integer userId) {
        return userMapper.findCreateData(userId);
    }

    @Override
    public List<Map<String, Object>> findTodayHot(Integer userId) {
        return userMapper.findTodayHot(userId);
    }

    @Override
    public List<Map<String, Object>> findHistoryHot(Integer userId) {
        return userMapper.findHistoryHot(userId);
    }

    @Override
    public List<Map<String, Object>> findTodayArtNum(Integer userId) {
        return userMapper.findTodayArtNum(userId);
    }

    @Override
    public List<Map<String, Object>> findTodayViewNum(Integer userId) {
        return userMapper.findTodayViewNum(userId);
    }

    @Override
    public List<Map<String, Object>> findTodayCommentNum(Integer userId) {
        return userMapper.findTodayCommentNum(userId);
    }

    @Override
    public List<Map<String, Object>> findWeekArtNum(Integer userId) {
        return userMapper.findWeekArtNum(userId);
    }

    @Override
    public List<Map<String, Object>> findWeekViewNum(Integer userId) {
        return userMapper.findWeekViewNum(userId);
    }

    @Override
    public List<Map<String, Object>> findWeekCommentNum(Integer userId) {
        return userMapper.findWeekCommentNum(userId);
    }

    @Override
    public List<Map<String, Object>> findMonthArtNum(Integer userId) {
        return userMapper.findMonthArtNum(userId);
    }

    @Override
    public List<Map<String, Object>> findMonthViewNum(Integer userId) {
        return userMapper.findMonthViewNum(userId);
    }

    @Override
    public List<Map<String, Object>> findMonthCommentNum(Integer userId) {
        return userMapper.findMonthCommentNum(userId);
    }


}
