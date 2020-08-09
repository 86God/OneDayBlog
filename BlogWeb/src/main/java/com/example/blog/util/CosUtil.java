package com.example.blog.util;

import com.qcloud.cos.*;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;


public class CosUtil {
    // 1 初始化用户身份信息（secretId, secretKey）。
    public static  final String secretId = "AKIDGJ5brqjCCv75mGRvLW1GE0JL7gyI2ExT";
    public static  final String secretKey = "OQsEM9jSwA5hcKOBpENHSN3UgnaXNr66";
    public static  final COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
    public static  final Region region = new Region("ap-beijing");
    public static  final ClientConfig clientConfig = new ClientConfig(region);
    // 3 生成 cos 客户端。
    public static  final COSClient cosClient = new COSClient(cred, clientConfig);

    public static void upLoad(String path,File file){
        // 指定要上传到的存储桶
        String bucketName = "blog-web-1302471896";

        // 指定要上传到 COS 上对象键
        String key = path + "//";
        key += file.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
    }
}
