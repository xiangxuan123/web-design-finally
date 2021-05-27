package com.example.springexamples.example02.aop;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyInterceptor {

    MyAuthorityType[] value() default MyAuthorityType.USER;

    public static enum MyAuthorityType {
        USER, ADMIN, SUPERADMIN
    }
}
