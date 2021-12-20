package com.bhjx.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtils {
    public static final String SECRET_KEY = "jdskhfdsjbg"; //秘钥
    public static final long TOKEN_EXPIRE_TIME = 6 * 60 * 60 * 1000; //token过期时间
    private static final String ISSUER = "issuer"; //签发人

    /**
     * 生成签名
     */
    public static String generateToken(Long userId,String userName){
        Date now = new Date();
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); //算法

        String token = JWT.create()
                .withIssuer(ISSUER) //签发人
                .withIssuedAt(now) //签发时间
                .withExpiresAt(new Date(now.getTime() + TOKEN_EXPIRE_TIME)) //过期时间
                .withClaim("userId", userId.toString()) //保存身份标识
                .withClaim("userName", userName)
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); //算法
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 从token获取username
     */
    public static long getUserIdFromToken(String token){
        try{
            String id = JWT.decode(token).getClaim("userId").asString();
            return id == null ? 0 : Long.parseLong(id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public static String getUserNameFromToken(String token){
        try{
            String name = JWT.decode(token).getClaim("userName").asString();
            return name;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
