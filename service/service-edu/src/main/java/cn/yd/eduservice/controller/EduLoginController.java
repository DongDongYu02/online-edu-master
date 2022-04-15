package cn.yd.eduservice.controller;

import cn.hutool.json.JSONObject;
import cn.yd.commonVo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class EduLoginController {

    @PostMapping("login")
    public Result login(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("token","admin");
        return Result.OK(jsonObject);
    }

    @GetMapping("info")
    public Result info(){
        JSONObject jsonObject = new JSONObject();
        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("roles","admin");
        jsonMap.put("name","Dong");
        jsonMap.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonObject.putAll(jsonMap);
        return Result.OK(jsonObject);
    }
}
