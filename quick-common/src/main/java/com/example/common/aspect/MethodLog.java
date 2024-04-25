package com.example.common.aspect;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {

    String remark() default "";
    String operType() default "0";
    // String desc() default "";
}