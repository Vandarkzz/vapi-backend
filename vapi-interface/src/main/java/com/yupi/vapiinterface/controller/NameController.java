package com.yupi.vapiinterface.controller;

import com.example.vapiclientsdk.model.User;
import com.example.vapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name){
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "POST   你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String body = request.getHeader("body");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");

        // TODO: 2023/3/20 去数据库中查验accessKey
        if (!accessKey.equals("vandark")){
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }
        // TODO: 2023/3/20  检验时间戳 与 当前时间 相差不超过 5分钟
        // TODO: 2023/3/20  出数据库中查出用户的secretKey
        String verifiedSign = SignUtils.getSign(body, "abcdefgh");
        if (!sign.equals(verifiedSign)){
            throw new RuntimeException("无权限");
        }

        return  "POST 用户的名字是" + user.getUsername();
    }
}
