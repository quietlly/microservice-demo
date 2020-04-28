package com.mic.pro.common.lang.utils;

public class BeanUtils {
    public static <T> T getBean(String name) {
        return (T) ApplicationContextHolder.getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> type) {
        return ApplicationContextHolder.getApplicationContext().getBean(type);
    }

    public static <T> T getBean(Class<T> type, Object... arguments) {
        return ApplicationContextHolder.getApplicationContext().getBean(type, arguments);
    }

    public static <T> T getBean(String name, Class<T> type) {
        return ApplicationContextHolder.getApplicationContext().getBean(name, type);
    }
}
