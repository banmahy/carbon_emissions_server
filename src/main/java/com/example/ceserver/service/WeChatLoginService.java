package com.example.ceserver.service;

import com.example.ceserver.util.JWTUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName WeChatLoginService
 * @Author
 * @Date
 **/
@Service
public class WeChatLoginService {

    @Value("${weChat.appId}")
    private String appId;

    @Value("${weChat.appSecret}")
    private String appSecret;

    private final static String CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?";


    public String login(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String url = CODE2SESSION + "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code +"&grant_type=authorization_code";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        JSONObject object = JSONObject.fromObject(result);

        return JWTUtils.generateToken("1","2");
    }
}
