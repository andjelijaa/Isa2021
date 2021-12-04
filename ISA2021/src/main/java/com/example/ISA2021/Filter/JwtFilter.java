package com.example.ISA2021.Filter;


import com.example.ISA2021.Services.MyUserDetailService;
import com.example.ISA2021.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String token = "";
        String username = "";
        if(header != null && header.startsWith("Bearer ")){
            token = header.substring(7);
            username = jwtUtils.extractUsername(token);
        }

        if(!username.equals("") && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = myUserDetailService.loadUserByUsername(username);

            if(jwtUtils.validateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upat);

            }

        }

        filterChain.doFilter(request, response);

    }
}
