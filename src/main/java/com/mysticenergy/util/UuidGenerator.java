package com.mysticenergy.util;

import java.util.UUID;

/**
 * Created by 书生 on 2018/2/20.
 */
public class UuidGenerator {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
