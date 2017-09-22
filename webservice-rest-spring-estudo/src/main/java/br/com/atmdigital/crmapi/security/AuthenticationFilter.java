package br.com.atmdigital.crmapi.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Component
@Scope("singleton")
public class AuthenticationFilter  extends GenericFilterBean{

	@Value("${keytoken}")
	private String keyToken;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		
		String authorization =  req.getHeader("Authorization");

		if (!StringUtils.startsWith(authorization, "Bearer")){
			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
		}else{
			
			try {
				
				String token = StringUtils.substring(authorization, 7);
				Jwts.parser().setSigningKey(keyToken).parseClaimsJws(token).getBody();
			
				chain.doFilter(request, response);
			}catch (ExpiredJwtException ex) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			} 
		}
	}

}
