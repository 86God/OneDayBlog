package com.example.blog.controller;

import com.alibaba.fastjson.JSON;
import com.example.blog.bean.User;
import com.example.blog.service.FileService;
import com.example.blog.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fileCtl")
@CrossOrigin
public class FileController {
    @Autowired
    FileService fileService;


    @RequestMapping("uploadUserImg")
    public Map<String,Object> uploadUserImg(User user,@RequestParam("file") CommonsMultipartFile file){
        Map<String,Object> map = new HashMap<>();
        try {
            String userImg = fileService.uploadUserImg(user,file);
            System.out.println("userImg:"+userImg);
            map.put("code",0);
            map.put("userImg",userImg);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
        }
        return map;
    }

    @RequestMapping("uploadImg")
    public Map<String,Object> uploadImg(@RequestParam("editormd-image-file") CommonsMultipartFile file){
        Map<String,Object> map = new HashMap<>();
        String cosUrl = "https://blog-web-1302471896.cos.ap-beijing.myqcloud.com";
        try {
            String imgUrl = fileService.uploadImg(file);
            System.out.println("imgUrl:"+imgUrl);
            map.put("success",1);
            map.put("url",cosUrl+"/img/"+imgUrl);
            System.out.println(map.get("url"));
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",2);
            map.put("message", "upload success!");
        }
        return map;
    }

    @RequestMapping("uploadImgByCkeditor")
    public String uploadImgByCkeditor(@RequestParam("upload") MultipartFile file, Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        Map<String,Object> map = new HashMap<>();
        String cosUrl = "https://blog-web-1302471896.cos.ap-beijing.myqcloud.com";
        try {
            String imgUrl = fileService.uploadImgByCkeditor(file);
            map.put("uploaded",1);
            map.put("url",cosUrl+"/img/"+imgUrl);
            System.out.println(map.get("url"));
        }catch (Exception e){
            e.printStackTrace();
            map.put("uploaded",0);
            map.put("message", "upload success!");
        }finally {
//            Gson gson = new Gson();
//            String json = gson.toJson(map);
            String json = JSON.toJSONString(map);
            return json;
        }
    }

    @RequestMapping("uploadImgByLayEdit")
    public Map<String,Object> uploadImgByLayEdit(MultipartFile  file){
        Map<String,Object> map = new HashMap<>();
        String cosUrl = "https://blog-web-1302471896.cos.ap-beijing.myqcloud.com";
        try {
            String imgUrl = fileService.uploadImg(file);
            System.out.println("imgUrl:"+imgUrl);
            map.put("code",0);
            map.put("msg","上传成功");
            Map<String,Object> map1 = new HashMap<>();
            map1.put("src",cosUrl+"/img/"+imgUrl);
            map1.put("src",cosUrl+"/img/"+imgUrl);
            map1.put("title",imgUrl);
            map.put("data",map1);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
            map.put("msg","上传失败");
        }
        return map;
    }
}
