package com.app.jwtUtils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.app.services.CustomLoginDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

	@Value("${SECRET_KEY}")
	private String jwtSecretKey;

	@Value("${EXP_TIMEOUT}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		log.info("generate jwt token " + authentication);
		//
		CustomLoginDetails userPrincipal = (CustomLoginDetails) authentication.getPrincipal();
		
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecretKey)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser()
			.setSigningKey(jwtSecretKey)
			.parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			log.error("Invalid JWT : " + e.getMessage());
		}
		return false;
	}
}
