package com.jayden.admin.filter;

import com.jayden.admin.servlet.MultiReadableHttpServletRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MultiReadableHttpServletRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MultiReadableHttpServletRequest multiReadableHttpServletRequest = new MultiReadableHttpServletRequest(request);
        filterChain.doFilter(multiReadableHttpServletRequest, response);
    }
}
