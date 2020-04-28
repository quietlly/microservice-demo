package com.mic.pro.common.lang.utils;

import com.mic.pro.common.lang.annotation.EnumAddition;
import org.apache.commons.lang3.StringUtils;

import org.springframework.context.MessageSource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class EnumUtils {
	
    private static final String I18N_PREFIX = "i18n:";
    private static final int I18N_PREFIX_LENGTH = I18N_PREFIX.length();

    private static Map<String, EnumAddition> nameMapping = new HashMap<>();
    private static Map<String, Enum<?>> codeMapping = new HashMap<>();
    private static MessageSource messageSource;
    private static boolean initilized = false;



    public static <T extends Enum> String getCode(T value) {

        String key = value.getClass().getName() + "." + value.name();
        return nameMapping.containsKey(key) ? nameMapping.get(key).code() : null;
    }

    public static <T extends Enum> String getLabel(T value) {
        return getLabel(value, Locale.getDefault());
    }

    public static <T extends Enum> String getLabel(T value, Locale locale, Object... args) {

        String key = value.getClass().getName() + "." + value.name();
        String label = null;
        if (nameMapping.containsKey(key)) {
            label = nameMapping.get(key).label();
            if (StringUtils.startsWithIgnoreCase(label, I18N_PREFIX)) {
                if (locale == null)
                    locale = Locale.getDefault();
                label = messageSource.getMessage(label.substring(I18N_PREFIX_LENGTH), args, locale);
            }
        }
        return label;
    }

    public static <T extends Enum> T codeOf(Class<T> javaType, String code) {
        if (StringUtils.isEmpty(code)){
            return null;
        }

        String key = javaType.getName() + "." + code;
        return (T) Optional.ofNullable(codeMapping.get(key))
                .orElseThrow(() -> new EnumConstantNotPresentException(javaType, "CODE_" + code));
    }

}
