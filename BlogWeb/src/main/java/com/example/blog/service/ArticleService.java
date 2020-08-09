package com.example.blog.service;

import com.example.blog.bean.Article;
import com.example.blog.bean.ArticleList;
import com.example.blog.bean.Condition;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Map<String, Object>> findArtTypeList();

    List<Map<String,Object>> findSpeColListByUserId(String userId);

    int saveArt(Article article);

    void saveArtTypeAndSpecol(int artId, String[] artType, String[] specol, int permType, int isreg);

    List<ArticleList> findArtListByPage(Condition condition);

    int findArtListCount(Condition condition);

    Map<String,Object> findArtById(Integer artId);

    void updateArt(Article article);

    Map<String, Object> findArtRelById(Integer artId);

    void deleteById(Integer artId);

    void batchDeleteById(String idList);

    void addVisit(Integer userId, Integer artId);

    boolean ifLike(Integer userId, Integer artId);

    void removeLike(Integer userId, Integer artId);

    void addLike(Integer userId, Integer artId);

    void updateArtNum(int artId);

    boolean ifCollect(Integer userId, Integer artId);

    void removeCollect(Integer userId, Integer artId);

    void addCollect(Integer userId, Integer artId);

    List<ArticleList> findArtCollectList(Map<String, Object> map1);

    int findArtCollectListCount(Map<String, Object> map1);

    void publishComment(Map<String, Object> map1);

    List<Map<String, Object>> findCommentList(Map<String, Object> map1);

    int findCommentListCount(Map<String, Object> map);
}
