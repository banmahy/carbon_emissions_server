package com.example.ceserver.util;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @ClassName JwtAuthenticationFilter
 * @Author
 * @Date
 **/
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isProtectedUrl(request)) {
                String token = request.getHeader("Authorization");
                JWTUtils.verifyToken(URLDecoder.decode(token));
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(request,response);
    }

    private boolean isProtectedUrl (HttpServletRequest request) {
        return pathMatcher.match("/api/**", request.getServletPath());
    }
}
