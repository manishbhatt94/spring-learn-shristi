package com.productapp.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

	// Token validity in seconds (30 minutes)
	private static final long JWT_TOKEN_VALIDITY_SECONDS = 30 * 60;

	@Value("${jwt.secret}")
	private String secret;

	// Generate a proper SecretKey from the secret string
	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	}

	// Retrieve username from JWT token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	// Retrieve expiration date from JWT token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	// Generic claim extractor
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = parseToken(token);
		return claimsResolver.apply(claims);
	}

	// Parse token once and return claims
	private Claims parseToken(String token) {
		return Jwts
				.parser() // ✅ factory method
				.verifyWith(getSigningKey()) // ✅ recommended replacement for setSigningKey
				.build()
				.parseSignedClaims(token) // ✅ modern parsing API
				.getPayload(); // ✅ extract Claims
	}

	// Check if the token has expired
	private boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// Generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", userDetails.getAuthorities()); // optional enrichment
		return doGenerateToken(claims, userDetails.getUsername());
	}

	// Build the JWT
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expiration = new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY_SECONDS * 1000);

		return Jwts
				.builder()
				.claims(claims) // ✅ modern API
				.subject(subject)
				.issuedAt(issuedAt)
				.expiration(expiration)
				.signWith(getSigningKey()) // ✅ modern API, algorithm inferred
				.compact();
	}

	// Validate token
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
