package com.mic.pro.common.lang.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnumAddition {
    /**
     * 编码
     */
    String code();

    /**
     * 标题
     */
    String label();
}
