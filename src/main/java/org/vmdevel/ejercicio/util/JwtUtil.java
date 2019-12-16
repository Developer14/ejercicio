package org.vmdevel.ejercicio.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.vmdevel.ejercicio.domain.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.signingkey}")
    private String signingKey;

    private static final long TOKEN_VALIDITY = 60 * 60;

    /**
     *
     * @param token
     * @param claimsTFunction
     * @param <T>
     * @return
     */
    private <T> T getClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = getClaims(token);
        return claimsTFunction.apply(claims);
    }

    /**
     *
     * @param token
     * @return
     */
    private Claims getClaims(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
        return claims.getBody();
    }

    /**
     *
     * @param user
     * @return
     */
    public String generateNewToken(User user) {

        Map<String, Object> claims = new HashMap<>();
        Consumer<Map<String, Object>> consumer = UserDataTokenParser.setTokenClaims(user);
        consumer.accept(claims);

        return generateToken(claims,user.getEmail());
    }

    /**
     *
     * @param claims
     * @param subject
     * @return
     */
    private String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();
    }

}