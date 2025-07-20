package com.agaramtech.qualis.global;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilterConfiguration extends OncePerRequestFilter {

//	private final JwtUtilityFunction jwtUtilityFunction;
//
//	public JwtFilterConfiguration(JwtUtilityFunction jwtUtilityFunction) {
//		super();
//		this.jwtUtilityFunction = jwtUtilityFunction;
//	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//		String token = null;
//		if (request.getCookies() != null) {
//			token = Arrays.stream(request.getCookies()).filter(cookie -> "jwt".equals(cookie.getName())).findFirst()
//					.map(Cookie::getValue).orElse(null);
//		}
//		if (token != null) {
//			boolean flag = jwtUtilityFunction.isTokenExpired(token);
//			if (flag) {
//				if (jwtUtilityFunction.extractExpiryTime(token) > 0) {
//					// for refresh token
//					token = jwtUtilityFunction.generateRefreshToken(token);
//					Cookie cookie = new Cookie("jwt", token);
//					cookie.setHttpOnly(true);
//					cookie.setSecure(true);
//					cookie.setPath("/");
//					cookie.setMaxAge(60 * 60 * 24); // seconds * minutes * hours
//					response.addCookie(cookie);
//				}
//			}
//			final String sessionId = jwtUtilityFunction.extractSessionId(token);
//			if ((sessionId != null && SecurityContextHolder.getContext().getAuthentication() == null) || flag) {
//				if (jwtUtilityFunction.isTokenValid(token)) {
					UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(null,
							null, null);
					authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authtoken);
//				}
//			}
//		}
		filterChain.doFilter(request, response);
	}

}
