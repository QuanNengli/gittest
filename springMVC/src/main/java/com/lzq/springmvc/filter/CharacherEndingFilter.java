package com.lzq.springmvc.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacherEndingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request,response);
    }
}
