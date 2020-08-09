package com.example.blog.mapper;

import com.example.blog.bean.Article;
import com.example.blog.bean.ArticleList;
import com.example.blog.bean.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SpecolMapper {

    List<Map<String, Object>> findSpecolList(Integer userId);

    List<Map<String, Object>> findSpecolInfoList(Map<String,Object> map);

    void addSpecol(Map<String,Object> map);

    Map<String, Object> findSpecol(Integer specolId);

    int findSpecolInfoListCount(Integer userId);

    void updateSpecol(Map<String, Object> map);

    void batchDel(String[] ids);

    void batchDelRel(String[] ids);
}
