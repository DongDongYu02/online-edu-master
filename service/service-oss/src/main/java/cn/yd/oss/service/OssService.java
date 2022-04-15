package cn.yd.oss.service;

import cn.yd.commonVo.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface OssService {
    String uploadAvatar(MultipartFile file);
}
