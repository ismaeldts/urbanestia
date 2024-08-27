package com.urbanestia.property.infrastructure.configuration.aop;

import com.urbanestia.property.infrastructure.rest.api.dto.request.PropertyRequest;
import com.urbanestia.property.shared.SanitizeStringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SanitizationAspect {
    @Before("execution(* com.urbanestia.property.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestBody)")
    public void sanitizeRequestBody(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof PropertyRequest request) {
                request.setTitle(SanitizeStringUtil.sanitize(request.getTitle()));
                request.setDescription(SanitizeStringUtil.sanitize(request.getDescription()));
            }
        }
    }
}
