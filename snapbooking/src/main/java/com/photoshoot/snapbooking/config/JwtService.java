package com.photoshoot.snapbooking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

  @Value("${jwt.secret}")
  private String secretKey;

  public String generateToken(UserDetails userDetails) {
    return Jwts.builder()
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
      .signWith(SignatureAlgorithm.HS256, secretKey)
      .compact();
  }

  public String getEmailFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser()
      .setSigningKey(secretKey)
      .parseClaimsJws(token)
      .getBody();
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    final String email = getEmailFromToken(token);
    return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  private boolean isTokenExpired(String token) {
    final Date expiration = getClaimFromToken(token, Claims::getExpiration);
    return expiration.before(new Date());
  }
}
