package com.example.common.aspect;

import cn.hutool.json.JSONUtil;
import com.example.common.constant.LogConst;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("(execution(public * com.example.controller..*.*(..)) || @annotation(com.example.common.aspect.MethodLog)) && !@annotation(com.example.common.aspect.NotMethodLog))")
    public void controllerMethod() {
    }

    @Around("controllerMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        //String activeProfile = ProfileUtil.getActiveProfile();

        String methodName = point.getSignature().toShortString();

        Object[] params = point.getArgs();

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            log.info("traceId-{} ,methodName {} start, request={}", MDC.get(LogConst.TRACE_ID), methodName, JSONUtil.toJsonStr(params));
            Object result = point.proceed();
            log.info("traceId-{} ,methodName{} end, result={}", MDC.get(LogConst.TRACE_ID), methodName, JSONUtil.toJsonStr(result));
            return result;
        } catch (Exception e) {
            log.error("traceId-{} ,methodName {} error, exception={}", MDC.get(LogConst.TRACE_ID) ,methodName, e);
            throw e;
        }

    }

}
