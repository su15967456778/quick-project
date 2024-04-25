package com.example.quickcommon.filter;

import cn.hutool.core.util.IdUtil;
import com.example.quickcommon.constant.LogConst;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Configuration
@WebFilter(filterName = "requestResponseTraceIdFilter", urlPatterns = "/*")
public class TraceIdFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        putTraceId(request);

        response.addHeader("X-Trace-Id", MDC.get(LogConst.TRACE_ID));

        filterChain.doFilter(request, response);

        MDC.remove(LogConst.TRACE_ID);
    }

    private void putTraceId(HttpServletRequest request) {
        String traceId = request.getHeader(LogConst.TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            MDC.put(LogConst.TRACE_ID, IdUtil.fastSimpleUUID());
        } else {
            MDC.put(LogConst.TRACE_ID, traceId);
        }
    }

}
