package com.example.springexamples.example04;

import java.lang.annotation.*;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAuthority {
    MyAuthorityType[] value() default MyAuthorityType.USER;
    String key() default "";
    public enum MyAuthorityType {
        USER, ADMIN, SUPERADMIN
    }
}
