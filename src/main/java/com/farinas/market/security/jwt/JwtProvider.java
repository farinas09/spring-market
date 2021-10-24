package com.farinas.market.security.jwt;

import com.farinas.market.security.entity.UserMain;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UserMain userMain = (UserMain) authentication.getPrincipal();
        return Jwts.builder().setSubject(userMain.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Badly formed token");
        }catch (UnsupportedJwtException e){
            logger.error("Token not supported");
        }catch (ExpiredJwtException e){
            logger.error("Expired token");
        }catch (IllegalArgumentException e){
            logger.error("Empty token");
        }catch (SignatureException e){
            logger.error("Signature failure");
        }
        return false;
    }
}
