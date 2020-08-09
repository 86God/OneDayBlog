package com.example.blog.controller;

import com.example.blog.service.ArticleService;
import com.example.blog.service.SpecolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/specolCtl")
@CrossOrigin
public class SpecolController {
    @Autowired
    SpecolService specolService;

    @RequestMapping("/findSpecolList")
    protected List<Map<String,Object>> findSpecolList(Integer userId){
        return specolService.findSpecolList(userId);
    }

    @RequestMapping("/findSpecolInfoList")
    protected Map<String,Object> findSpecolInfoList(Integer userId,Integer page,Integer limit){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        int start = (page -1) * limit;
        map1.put("start",start);
        map1.put("limit",limit);
        try{
            List<Map<String,Object>> specolList = specolService.findSpecolInfoList(map1);
            int count = specolService.findSpecolInfoListCount(userId);
            map.put("count",count);
            map.put("data",specolList);
            map.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

    @RequestMapping("/addSpecol")
    protected Map<String,Object> addSpecol(Integer userId,String specolName,String sort){
        Map<String,Object> map = new HashMap<>();
        try{
            specolService.addSpecol(userId,specolName,sort);
            map.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

    @RequestMapping("/findSpecol")
    protected Map<String,Object> findSpecol(Integer specolId){
        return specolService.findSpecol(specolId);
    }

    @RequestMapping("/updateSpecol")
    protected Map<String,Object> updateSpecol(Integer specolId,String specolName,String sort){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("specolId",specolId);
        map1.put("specolName",specolName);
        map1.put("sort",sort);
        Map<String,Object> map = new HashMap<>();
        try{
            specolService.updateSpecol(map1);
            map.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

    @RequestMapping("/batchDel")
    protected Map<String,Object> batchDel(String idList){
        String[] ids = idList.split(",");
        Map<String,Object> map = new HashMap<>();
        try{
            specolService.batchDel(ids);
            specolService.batchDelRel(ids);
            map.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

}
