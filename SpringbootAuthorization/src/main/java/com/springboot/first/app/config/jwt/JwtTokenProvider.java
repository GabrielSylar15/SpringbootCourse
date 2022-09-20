package com.springboot.first.app.config.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.springboot.first.app.service.security.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
@Component
public class JwtTokenProvider {
	private final String JWT_SECRET = "vinhnt";
	private final long JWT_EXPIRATION = 60480000000L;

	public String generateToken(UserDetailsImpl userDetail) {
		Date now = new Date();
		Date expireDate = new Date(now.getTime() + JWT_EXPIRATION);
		String jwtToken = Jwts.builder().setExpiration(expireDate).setSubject(userDetail.getUsername())
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
		return jwtToken;
	}
	
	public String getUserNameFromToken(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			// TODO: handle exception
			System.out.print("Invalid JWT Token");
		} catch (ExpiredJwtException e) {
			// TODO: handle exception
			System.out.println("Expired JWT Token");
		} catch (UnsupportedJwtException e) {
			System.out.println("Unsupported JWT Token");
		} catch (IllegalArgumentException e) {
			System.out.print("JWT claims string is empty");
		}
		return false;
	}
}
