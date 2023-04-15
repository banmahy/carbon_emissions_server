package com.example.ceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ceserver.model.entity.TblSysUser;
import com.example.ceserver.service.SysUserService;
import com.example.ceserver.util.JWTUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysUserService sysUserService;


    public String login(String code,String userInfo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = CODE2SESSION + "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code +"&grant_type=authorization_code";
        String result = restTemplate.getForObject(url, String.class);
        String openid = JSONObject.fromObject(result).getString("openid");
        if (StringUtils.isBlank(openid)) {
            throw new RuntimeException("jscode2session接口未返回openId数据");
        }
        JSONObject info = JSONObject.fromObject(userInfo);
        //通过openId查找用户
        TblSysUser user = sysUserService.getOne(new QueryWrapper<TblSysUser>().eq("open_id", openid));
        //若没有找到相应用户，则进行静默注册
        if (user == null) {
            user = TblSysUser.builder()
                    .avatarUrl(String.valueOf(info.get("avatarUrl")))
                    .username(String.valueOf(info.get("nickName")))// 暂无用户名，用昵称填充
                    .nickname(String.valueOf(info.get("nickName")))
                    .sex(String.valueOf(info.get("gender")))
                    .openId(openid)
                    .menuList("10,20,30,40") //目前先默认开放出所有菜单
                    .build();
            sysUserService.save(user);
        }

        return JWTUtils.generateToken(user.getId(),user.getNickname());
    }
}
