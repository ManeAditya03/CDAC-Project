package com.app.filters;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.jwtUtils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTRequestFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils utils;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	Logger log;
	
//	private static final Logger logger = LoggerFactory.getLogger(JWTRequestFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("in once per request filter");

		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer ")) {

			String token = header.substring(7);
			if (utils.validateJwtToken(token)) {

				String userName = utils.getUserNameFromJwtToken(token);

				if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

					SecurityContextHolder.getContext().setAuthentication(authentication);
				} else log.info("user name null or authentication already set , username {}"+userName);
			}
		} else log.error("Request header DOES NOT contain a Bearer Token");

		filterChain.doFilter(request, response);

	}
}
