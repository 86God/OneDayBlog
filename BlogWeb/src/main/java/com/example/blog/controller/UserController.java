package com.example.blog.controller;

import com.example.blog.bean.ArticleList;
import com.example.blog.bean.User;
import com.example.blog.service.UserService;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userCtl")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    //登录
    @RequestMapping("/login")
    protected Map<String,Object> login(User user, HttpSession session, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<>();
        try{
            String password = DigestUtils.md5Hex(user.getPassword());
            user.setPassword(password);
            User user1 = userService.login(user);
            if(user1!=null){
                map.put("user",user1);
                map.put("sessionId",session.getId());
                map.put("code",0);
                session.setAttribute("user",user1);
            }else{
                map.put("code",1);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",2);
        }
        return map;
    }

    //推出，注销
    @RequestMapping("/logout")
    protected void logout(HttpSession session)  {
        try {
            session.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查看个人资料
    @RequestMapping("/findUserInfo")
    protected Map<String,Object> findUserInfo(Integer userId)  {
        Map<String,Object> map = new HashMap<>();
        try {
            userService.updateUserHeadInfo(userId);
            map = userService.findUserInfoById(userId);
            map.put("code",0);
        } catch (Exception e) {
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }

    //注册
    @RequestMapping("/reg")
    protected Map<String,Object> reg(User user)  {
        String password = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(password);
        Map<String,Object> map = new HashMap<>();
        try {
            userService.reg(user);
            map.put("code",0);
        } catch (Exception e) {
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }

    //验证用户名是否使用
    @RequestMapping("/findUserByUserName")
    protected Map<String,Object> findUserByUserName(String userName)  {
        Map<String,Object> map = new HashMap<>();
        try {
            String a = userService.findUserByUserName(userName);
            if(a == null || a == ""){
                map.put("code",1);
            }else{
                map.put("code",0);
            }
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    //更新个人资料
    @RequestMapping("/updateUserInfo")
    protected Map<String,Object> updateUserInfo(User user)  {
        System.out.println(user);
        System.out.println(user.getTag());
        String[] tagList = user.getTag().split(",");
        Map<String,Object> map = new HashMap<>();
        try {
            userService.updateUserInfo(user);
            userService.updateUserTag(user.getId(),tagList);
            map.put("user",user);
            map.put("code",0);
        } catch (Exception e) {
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }

    //查找所有标签
    @RequestMapping("/findAllTag")
    protected List<Map<String,Object>> findAllTag()  {
        List<Map<String,Object>> tagList = new ArrayList<>();
        try {
            tagList = userService.findAllTag();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tagList;
    }

    //修改密码
    @RequestMapping("/changePW")
    protected Map<String,Object> changePW(Integer useId,String password){
        Map<String,Object> map = new HashMap<>();
        try {
            userService.changePW(useId,password);
            map.put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

    //验证旧密码是否正确
    @RequestMapping("/verifyOldPW")
    protected Map<String,Object> verify(String userId,String oldPassword){
        System.out.println(userId);
        System.out.println(oldPassword);
        Map<String,Object> map = new HashMap<>();
        try {
            User user = userService.verifyOldPW(userId,oldPassword);
            if(user != null){
                map.put("code",0);
            }else{
                map.put("code",1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",2);
        }
        return map;
    }

    //根据用户Id查询访问记录
    @RequestMapping("/findViewList")
    protected List<Map<String,Object>> findViewList(Integer userId){
        return userService.findViewList(userId);
    }


    //查找用户的粉丝列表和关注列表
    @RequestMapping("/findUserListByPage")
    protected Map<String,Object> findUserListByPage(String userId,Integer pageNum,Integer limit,String action){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("pageNum",pageNum);
        map1.put("limit",limit);

        //查找粉丝列表
        if(action.equals("focusList")){
            map1.put("userId",userId);
        }
        //查找关注人列表
        if(action.equals("concernList")){
            map1.put("concernId",userId);
        }
        List<ArticleList> list = userService.findUserListByPage(map1);
        map.put("data",list);
        int count = userService.findUserListCount(map1);
        int pages = (int) Math.ceil(((double) count)/limit);
        map.put("pages",pages);
        map.put("code",0);
        map.put("count",count);
        return map;
    }

    //查找用户的关注列表
    @RequestMapping("/findCommentList")
    protected List<Map<String,Object>> findCommentList(Integer userId){
        List<Map<String,Object>> list = userService.findCommentList(userId);
        return list;
    }

    //判断是否已经关注
    @RequestMapping("/ifFocus")
    protected Map<String,Object> ifFocus(Integer userId,Integer focus){
        int flag = -1;
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        map1.put("focus",focus);
        Map<String,Object> map = userService.ifFocus(map1);
        if(map == null){
            map1.put("flag",1);
        }else{
            map1.put("flag",0);
        }
        return map1;
    }

    //添加关注
    @RequestMapping("/addContact")
    protected Map<String,Object> addContact(Integer userId,Integer focus){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        map1.put("focus",focus);
        try{
            userService.addContact(map1);
            map1.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map1.put("code",1);
        }
        return map1;
    }

    //取消关注
    @RequestMapping("/removeContact")
    protected Map<String,Object> removeContact(Integer userId,Integer focus){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        map1.put("focus",focus);
        try{
            userService.removeContact(map1);
            map1.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map1.put("code",1);
        }
        return map1;
    }

    //用户的收到的评论列表
    @RequestMapping("/findCommentListByPage")
    protected Map<String,Object> findCommentListByPage(Integer userId,Integer page,Integer limit){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        map1.put("pageNum",page);
        map1.put("limit",limit);
        Map<String,Object> map = new HashMap<>();
        List<ArticleList> list = userService.findCollectList(map1);
        map.put("data",list);
        int count = userService.findCollectListCount(map1);
        int pages = (int) Math.ceil(((double) count)/limit);
        map.put("pages",pages);
        map.put("code",0);
        map.put("count",count);
        return map;
    }

    //查找用户的创作数据
    @RequestMapping("/findCreateData")
    protected Map<String,Object> findCreateData(Integer userId){
        Map<String,Object> map = userService.findCreateData(userId);
        return map;
    }

    //查找用户的今天的数据
    @RequestMapping("/findTodayHot")
    protected List<Map<String,Object>> findTodayHot(Integer userId){
        List<Map<String,Object>> map = userService.findTodayHot(userId);
        return map;
    }

    //查找用户的历史的数据
    @RequestMapping("/findHistoryHot")
    protected List<Map<String,Object>> findHistoryHot(Integer userId){
        List<Map<String,Object>> map = userService.findHistoryHot(userId);
        return map;
    }

    //查找用户数据界面的图表信息
    @RequestMapping("/findChartInfo")
    protected Map<String,Object> findChartInfo(Integer userId,String action){
        Map<String,Object> map = new HashMap<>();
        List timeNumList = new ArrayList<>();
        List artNumList = new ArrayList<>();
        List viewNumList = new ArrayList<>();
        List commentNumList = new ArrayList<>();
        if(action.equals("getToday")){
            List<Map<String,Object>> artList = userService.findTodayArtNum(userId);
            List<Map<String,Object>> viewList = userService.findTodayViewNum(userId);
            List<Map<String,Object>> commentList = userService.findTodayCommentNum(userId);
            for(int i = 0;i<artList.size();i++){
                timeNumList.add(artList.get(i).get("time"));
                artNumList.add(artList.get(i).get("artNum"));
                viewNumList.add(viewList.get(i).get("viewNum"));
                commentNumList.add(commentList.get(i).get("commentNum"));
            }
        }else if(action.equals("getWeek")){
            List<Map<String,Object>> artList = userService.findWeekArtNum(userId);
            List<Map<String,Object>> viewList = userService.findWeekViewNum(userId);
            List<Map<String,Object>> commentList = userService.findWeekCommentNum(userId);
            for(int i = 0;i<artList.size();i++){
                timeNumList.add(artList.get(i).get("time"));
                artNumList.add(artList.get(i).get("artNum"));
                viewNumList.add(viewList.get(i).get("viewNum"));
                commentNumList.add(commentList.get(i).get("commentNum"));
            }
        }else{
            List<Map<String,Object>> artList = userService.findMonthArtNum(userId);
            List<Map<String,Object>> viewList = userService.findMonthViewNum(userId);
            List<Map<String,Object>> commentList = userService.findMonthCommentNum(userId);
            for(int i = 0;i<artList.size();i++){
                timeNumList.add(artList.get(i).get("time"));
                artNumList.add(artList.get(i).get("artNum"));
                viewNumList.add(viewList.get(i).get("viewNum"));
                commentNumList.add(commentList.get(i).get("commentNum"));
            }
        }
        map.put("timeNumList",timeNumList);
        map.put("artNumList",artNumList);
        map.put("viewNumList",viewNumList);
        map.put("commentNumList",commentNumList);
        return map;
    }
}
