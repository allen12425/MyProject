package com.example.demo.common;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/")//匹配所有的url,也就是所有的url都要经过此过滤器
public class AccountFilter implements Filter {
    private final String[] IGNORE_URI = {"/index", "/account/validate", "/account/login","/account/register",
            "/css", "/js", "/images"};
    public FilterConfig config;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();
        //1.判断当前是uri是否在ignore_uri 中
        System.out.println(uri);
        boolean flag = this.isContains(uri);
        if (flag) {
            //如果存在，允许访问
            filterChain.doFilter(request, response);
            return;
        }
        //2.判断是否已经登录，在session里找Account
        Object obj = request.getSession().getAttribute("account");
        if (obj == null) {
            //没有登录，跳转到登录界面
            response.sendRedirect(request.getContextPath()+"/account/login");
            return;
        }
        System.out.println("-----filter----" + uri);
        filterChain.doFilter(request, response);
    }

    public boolean isContains(String uri) {
        for (String val : IGNORE_URI) {
            if (uri.indexOf(val) != -1) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //加载Filter启动之前需要的资源
        System.out.println("-----AccountFilter Init....");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        this.config = null;
    }
}
