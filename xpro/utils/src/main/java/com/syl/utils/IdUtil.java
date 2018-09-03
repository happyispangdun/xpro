package com.syl.utils;

import java.util.UUID;

public class IdUtil {

    /**
     * @return 生成字符串ID
     * 生成UUID，将UUID中“-”替换成“”
     */
    public static String generateId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "");
        return id;
    }
}
