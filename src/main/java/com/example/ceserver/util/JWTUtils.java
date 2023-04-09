package com.example.ceserver.util;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @ClassName JWTUtils
 * @Author
 * @Date
 **/
public class JWTUtils {
    // 过期时间(默认一周)
    private static long tokenExpiration = 168*60*60*1000;
    // 加密密钥
    private static String tokenSignKey = "parket7";

    public static String generateToken (String userId, String userName) {
        return Jwts.builder()
                .setSubject("IMEDI-USER")
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId",userId)
                .claim("userName",userName)
                .signWith(SignatureAlgorithm.HS512,tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

}
