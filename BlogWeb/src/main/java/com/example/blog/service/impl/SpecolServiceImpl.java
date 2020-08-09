package com.example.blog.service.impl;

import com.example.blog.mapper.SpecolMapper;
import com.example.blog.service.SpecolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecolServiceImpl implements SpecolService {
    @Autowired
    SpecolMapper specolMapper;

    @Override
    public List<Map<String, Object>> findSpecolList(Integer userId) {
        return specolMapper.findSpecolList(userId);
    }

    @Override
    public List<Map<String, Object>> findSpecolInfoList(Map<String,Object> map) {
        return specolMapper.findSpecolInfoList(map);
    }

    @Override
    public void addSpecol(Integer userId, String specolName, String sort) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("specolName",specolName);
        map.put("sort",sort);
        specolMapper.addSpecol(map);
    }

    @Override
    public Map<String, Object> findSpecol(Integer specolId) {
        return specolMapper.findSpecol(specolId);
    }

    @Override
    public int findSpecolInfoListCount(Integer userId) {
        return specolMapper.findSpecolInfoListCount(userId);
    }

    @Override
    public void updateSpecol(Map<String, Object> map) {
        specolMapper.updateSpecol(map);
    }

    @Override
    public void batchDel(String[] ids) {
        specolMapper.batchDel(ids);
    }

    @Override
    public void batchDelRel(String[] ids) {
        specolMapper.batchDelRel(ids);
    }
}
