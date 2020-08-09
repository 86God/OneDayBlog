package com.example.blog.mapper;

import com.example.blog.bean.Article;
import com.example.blog.bean.ArticleList;
import com.example.blog.bean.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleMapper {
    List<Map<String, Object>> findArtTypeList();

    List<Map<String,Object>> findSpeColListByUserId(String userId);

    void saveArt(Article article);

    int backId();

    void updateArt(Article article);

    void deleteArtType(int artId);

    void addArtType(int artId, String artType);

    void deleteSpecol(int artId);

    void addSpecol(int artId, String specol);

    List<ArticleList> findArtListByPage(Condition condition, int start);

    int findArtListCount(Condition condition);

    Map<String,Object> findArtById(Integer artId);

    void updateArtCon(Article article);

    Map<String, Object> findArtRelById(Integer artId);

    void deleteArtById(Integer artId);

    void addViewNum(Integer artId);

    void addVisit(Map<String,Object> map);

    Map<String,Object> ifLike(Map<String,Object> map);

    void deleteLike(Map<String,Object> map);

    void updateArtLikes(Map<String,Object> map);

    void addLike(Map<String, Object> map);

    void updateArtNum(int artId);

    Map<String,Object> ifCollect(Map<String, Object> map);

    void deleteCollect(Map<String, Object> map);

    void updateArtCollect(Map<String, Object> map);

    void addCollect(Map<String, Object> map);

    List<ArticleList> findArtCollectList(Map<String, Object> map);

    int findArtCollectListCount(Map<String, Object> map1);

    void publishComment(Map<String, Object> map);

    List<Map<String, Object>> findCommentList(Map<String, Object> map);

    int findCommentListCount(Map<String, Object> map);
}
