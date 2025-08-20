package com.sumukh.demo.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JWTclass {

    private String key= "";

    public JWTclass(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey Genkey= keyGenerator.generateKey();
            byte[] keyBytes = Genkey.getEncoded();
            key = Base64.getEncoder().encodeToString(Genkey.getEncoded());
            System.out.println("GEn Key: "+ Genkey);
            System.out.println("BYteds Key: "+ keyBytes);


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean verify(String token, String username){

        return JWT.require(Algorithm.HMAC256(key)).build().verify(token).getSubject().equals(username);
    }





    public String generate(String username){

        Map<String, Object> map = new HashMap<>();
        System.out.println("Key: "+ key);
        return JWT
                .create()
                .withClaim("List",map)
                .withSubject(username)
                .withIssuedAt(Date.from(new Date().toInstant()))
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .sign(Algorithm.HMAC256(key));

    }

    public String getUsername(String token) {
        return JWT.require(Algorithm.HMAC256(key)).build().verify(token).getSubject();
    }
}


