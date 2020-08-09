package com.example.blog.service;

import com.example.blog.bean.User;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileService {

    String uploadUserImg(User user, CommonsMultipartFile file);

    String uploadImg(MultipartFile file);

    String uploadImgByCkeditor(MultipartFile file);
}
