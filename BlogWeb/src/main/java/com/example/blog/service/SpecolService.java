package com.example.blog.service;

import java.util.List;
import java.util.Map;

public interface SpecolService {

    List<Map<String,Object>> findSpecolList(Integer userId);

    List<Map<String, Object>> findSpecolInfoList(Map<String,Object> map);

    void addSpecol(Integer userId, String specolName, String sort);

    Map<String, Object> findSpecol(Integer specolId);

    int findSpecolInfoListCount(Integer userId);

    void updateSpecol(Map<String, Object> map1);

    void batchDel(String[] ids);

    void batchDelRel(String[] ids);
}
