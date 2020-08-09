package com.example.blog.service.impl;

import com.example.blog.bean.Article;
import com.example.blog.bean.ArticleList;
import com.example.blog.bean.Condition;
import com.example.blog.mapper.ArticleMapper;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    UserMapper userMapper;
    @Override
    public List<Map<String, Object>> findArtTypeList() {
        List<Map<String, Object>> typeList = articleMapper.findArtTypeList();
        for(int i = 0;i<typeList.size();i++){
            Map<String, Object> map = typeList.get(i);
            String secId = (String) map.get("secId");
            if(secId != null && secId!=""){
                String[] secList = secId.split(",");
                map.put("secId",secList);
            }else{
                map.put("secId",0);
            }
            String secNameList = (String)map.get("secNameList");
            if(secNameList != null && secNameList!=""){
                String[] secNameList1 = secNameList.split(",");
                map.put("secNameList",secNameList1);
            }else{
                map.put("secNameList","-");
            }
            typeList.set(i,map);
        }
        System.out.println(typeList);
        return typeList;
    }

    @Override
    public List<Map<String,Object>> findSpeColListByUserId(String userId) {
        return articleMapper.findSpeColListByUserId(userId);
    }

    @Override
    @Transactional
    public int saveArt(Article article) {
        articleMapper.saveArt(article);
        return articleMapper.backId();
    }

    @Override
    @Transactional
    public void saveArtTypeAndSpecol(int artId, String[] artType, String[] specol, int permType, int isreg) {
        Article article = new Article();
        article.setId(artId);
        article.setPermType(permType);
        article.setIsreg(isreg);
        //更新文章信息
        articleMapper.updateArt(article);

        //删掉之前的文章类型
        articleMapper.deleteArtType(artId);

        //添加最新的文章类型
        for(String s:artType){
            articleMapper.addArtType(artId,s);
        }

        //删掉之前的文章所属专栏
        articleMapper.deleteSpecol(artId);
        //添加最新的文章所属专栏
        for(String s:specol){
            articleMapper.addSpecol(artId,s);
        }
        userMapper.updateUserHeadInfo(artId);

    }

    @Override
    public List<ArticleList> findArtListByPage(Condition condition) {
        int start = (condition.getPageNum() - 1)*condition.getLimit();
        return articleMapper.findArtListByPage(condition,start);
    }

    @Override
    public int findArtListCount(Condition condition) {
        return articleMapper.findArtListCount(condition);
    }

    @Override
    @Transactional
    public Map<String,Object> findArtById(Integer artId) {
        articleMapper.addViewNum(artId);
        articleMapper.updateArtNum(artId);
        return articleMapper.findArtById(artId);
    }

    @Override
    public void updateArt(Article article) {
        articleMapper.updateArtCon(article);
    }

    @Override
    public Map<String, Object> findArtRelById(Integer artId) {
        return articleMapper.findArtRelById(artId);
    }

    @Override
    @Transactional
    public void deleteById(Integer artId) {
        //删掉之前的文章类型
        articleMapper.deleteArtType(artId);
        //删掉之前的文章所属专栏
        articleMapper.deleteSpecol(artId);
        //删掉文章
        articleMapper.deleteArtById(artId);
    }

    @Override
    @Transactional
    public void batchDeleteById(String idList) {
        String[] ids=idList.split(",");
        for(int i = 0;i<ids.length;i++){
            //删掉之前的文章类型
            articleMapper.deleteArtType(Integer.valueOf(ids[i]));
            //删掉之前的文章所属专栏
            articleMapper.deleteSpecol(Integer.valueOf(ids[i]));
            //删掉文章
            articleMapper.deleteArtById(Integer.valueOf(ids[i]));
        }
    }

    @Override
    public void addVisit(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        articleMapper.addVisit(map);
    }

    @Override
    //判断是否已经点过赞
    public boolean ifLike(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        Map<String,Object> map1 = articleMapper.ifLike(map);
        if(map1 == null){
            return false;
        }else{
            return true;
        }

    }

    @Override
    @Transactional
    //取消赞
    public void removeLike(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        map.put("num",-1);
        articleMapper.deleteLike(map);
        articleMapper.updateArtLikes(map);
    }

    @Override
    public void addLike(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        map.put("num",1);
        articleMapper.addLike(map);
        articleMapper.updateArtLikes(map);
    }

    @Override
    public void updateArtNum(int artId) {
        articleMapper.updateArtNum(artId);
    }

    @Override
    public boolean ifCollect(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        Map<String,Object> map1 = articleMapper.ifCollect(map);
        if(map1 == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void removeCollect(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        map.put("num",-1);
        articleMapper.deleteCollect(map);
        articleMapper.updateArtCollect(map);
    }

    @Override
    public void addCollect(Integer userId, Integer artId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("artId",artId);
        map.put("num",1);
        articleMapper.addCollect(map);
        articleMapper.updateArtCollect(map);
    }

    @Override
    public List<ArticleList> findArtCollectList(Map<String, Object> map) {
        int start = ((int)map.get("pageNum") - 1)*(int)map.get("limit");
        map.put("start",start);
        return articleMapper.findArtCollectList(map);
    }

    @Override
    public int findArtCollectListCount(Map<String, Object> map1) {
        return articleMapper.findArtCollectListCount(map1);
    }

    @Override
    public void publishComment(Map<String, Object> map) {
        articleMapper.publishComment(map);
    }

    @Override
    public List<Map<String, Object>> findCommentList(Map<String, Object> map) {
        int start = ((int)map.get("pageNum") - 1)*(int)map.get("limit");
        map.put("start",start);
        return articleMapper.findCommentList(map);
    }

    @Override
    public int findCommentListCount(Map<String, Object> map) {
        return articleMapper.findCommentListCount(map);
    }
}
