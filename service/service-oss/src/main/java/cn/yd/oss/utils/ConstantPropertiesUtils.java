package cn.yd.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils{
    @Value("${aliyun.oss.file.endpoint}")
    public String ossEndpoint;

    @Value("${aliyun.oss.file.keyid}")
    public  String ossKeyId;

    @Value("${aliyun.oss.file.keysecret}")
    public String ossKeySecret;

    @Value("${aliyun.oss.file.bucketname}")
    public  String ossBucketName;


}
