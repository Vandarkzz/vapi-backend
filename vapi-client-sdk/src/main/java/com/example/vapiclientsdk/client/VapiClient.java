package com.example.vapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.example.vapiclientsdk.model.User;
import java.util.HashMap;
import java.util.Map;

import static com.example.vapiclientsdk.utils.SignUtils.getSign;

/**
 * 调用第三方接口的客户端
 */
public class VapiClient {

    private String accessKey;
    private String secretKey;

    public VapiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result= HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }


    public String getNameByPost(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result= HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }


    private Map<String, String> getHeaderMap(String body){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        //密码不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", getSign(body, secretKey));
        return  hashMap;
    }


    public String getUsernameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(response.getStatus());
        String result = response.body();
        System.out.println(result);
        return  result;
    }


}
