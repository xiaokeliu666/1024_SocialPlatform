package com.tensquare.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJKYXkiLCJpYXQiOjE1ODc3MTE1MTEsImV4cCI6MTU4NzcxMTU3MSwicm9sZSI6ImFkbWluIn0.iJ_ccXoYBnJvLDeVfhfpIw3YzJl59gd6m6S0R8YduiA")
                .getBody();
        System.out.println("UserId:"+claims.getId());
        System.out.println("UserName:"+claims.getSubject());
        System.out.println("LoginTime:"+new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("ExpiredTime:"+new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(claims.getExpiration()));
        System.out.println("Role:"+claims.get("role"));
    }
}
