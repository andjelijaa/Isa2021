package com.example.backend.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        if (authException instanceof DisabledException) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        response.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response.getOutputStream().print(new ObjectMapper().writeValueAsString(authException.getMessage()));
        response.flushBuffer();
    }
}