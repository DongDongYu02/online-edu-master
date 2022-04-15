package cn.yd.oss.service.impl;

import cn.yd.commonVo.Result;
import cn.yd.oss.service.OssService;
import cn.yd.oss.utils.ConstantPropertiesUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Autowired
    ConstantPropertiesUtils constantPropertiesUtils;
    @Override
    public String uploadAvatar(MultipartFile file) {
        OSS oos = new OSSClientBuilder().build(constantPropertiesUtils.ossEndpoint,
                constantPropertiesUtils.ossKeyId,
                constantPropertiesUtils.ossKeySecret);
        try{
            InputStream  fileInputStream =file.getInputStream();
            //获取图片格式
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //设置图片文件名
            String fileName = "avatar"+UUID.randomUUID().toString().replaceAll("-","").substring(0,6)+suffix;
            PutObjectResult result = oos.putObject(constantPropertiesUtils.ossBucketName, "img/avatar" + fileName, fileInputStream);
            //设置oos头像存储路径
            return "https://"+ constantPropertiesUtils.ossBucketName +"/"+
                    constantPropertiesUtils.ossEndpoint+"/"+fileName;
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }finally {
            oos.shutdown();
        }
    }
}
