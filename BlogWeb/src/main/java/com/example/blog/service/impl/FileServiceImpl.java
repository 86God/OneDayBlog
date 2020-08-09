package com.example.blog.service.impl;

import com.example.blog.bean.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.FileService;
import com.example.blog.util.CosUtil;
import com.example.blog.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String uploadUserImg(User user, CommonsMultipartFile file) {
        String filename = "";
        String newFileName = "";

        try {
            filename = file.getOriginalFilename();
            //编写存放的文件名字（当前时间+文件后缀名）
            newFileName = StringUtil.createNewNameByDate()+"."+ StringUtil.subFileType(filename);
            File storeFile = new File(newFileName);

            // 保存文件到硬盘
            file.transferTo(storeFile);

            //上传图片到对象存储
            CosUtil.upLoad(user.getUserName(),storeFile);
            //删除本地的临时文件
            storeFile.deleteOnExit();
            user.setImg(newFileName);
            userMapper.updateUserImg(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    @Override
    public String uploadImg(MultipartFile file) {
        String filename = "";
        String newFileName = "";

        try {
            filename = file.getOriginalFilename();
            //编写存放的文件名字（当前时间+文件后缀名）
            newFileName = StringUtil.createNewNameByDate()+"."+ StringUtil.subFileType(filename);
            File storeFile = new File(newFileName);

            // 保存文件到硬盘
            file.transferTo(storeFile);

            //上传图片到对象存储
            CosUtil.upLoad("img",storeFile);
            //删除本地的临时文件
            storeFile.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    @Override
    public String uploadImgByCkeditor(MultipartFile file) {
        String filename = "";
        String newFileName = "";

        try {
            filename = file.getOriginalFilename();
            //编写存放的文件名字（当前时间+文件后缀名）
            newFileName = StringUtil.createNewNameByDate()+"."+ StringUtil.subFileType(filename);
            File storeFile = new File(newFileName);

            // 保存文件到硬盘
            file.transferTo(storeFile);

            //上传图片到对象存储
            CosUtil.upLoad("img",storeFile);
            //删除本地的临时文件
            storeFile.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFileName;
    }
}
