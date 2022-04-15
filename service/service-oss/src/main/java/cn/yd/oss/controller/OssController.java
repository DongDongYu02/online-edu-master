package cn.yd.oss.controller;

import cn.yd.commonVo.Result;
import cn.yd.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/eduoss/fileoss")
public class OssController {
    @Autowired
    private OssService ossService;
    @Autowired
    @PostMapping
    public Result<?> uploadOssFile(MultipartFile file){
        ossService.uploadAvatar(file);
        return Result.OK();
    }
}
