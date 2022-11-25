package com.example.ssl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
// Filter Interface를 구현해서 클라이언트 정보를 획득
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try
        {
            log.info("──────────────────");
            log.info("Filter Information");
            log.info("request.getRemoteAddr() : {} ",request.getRemoteAddr());
            log.info("request.getRemoteHost() : {} ",request.getRemoteHost());
            log.info("request.getScheme() : {} ",request.getScheme());
            log.info("request.getProtocol() : {} ",request.getProtocol());
            if (request instanceof HttpServletRequest) {
                String url = ((HttpServletRequest)request).getRequestURL().toString();
                String queryString = ((HttpServletRequest)request).getQueryString();
                log.info("url : {} ", url);
                log.info("queryString : {} ", queryString);
            }
            // 필터 호출
            chain.doFilter(request, response);

            log.info("FirstFilter end");
            log.info("──────────────────");

        }
        catch(Exception e)
        {
            log.error("doFilter Exception : " + e.getMessage());
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}