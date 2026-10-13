package com.diworksdev.WeddingInvitation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        System.out.println("CorsFilterが呼ばれました");

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        httpResponse.setHeader(
                "Access-Control-Allow-Origin",
                "http://localhost:5173"
        );

        httpResponse.setHeader(
                "Access-Control-Allow-Credentials",
                "true"
        );

        httpResponse.setHeader(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS"
        );

        httpResponse.setHeader(
                "Access-Control-Allow-Headers",
                "Content-Type"
        );

        // OPTIONSリクエストの場合はここで終了
        if ("OPTIONS".equalsIgnoreCase(
                httpRequest.getMethod())) {

            httpResponse.setStatus(
                    HttpServletResponse.SC_OK);

            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}