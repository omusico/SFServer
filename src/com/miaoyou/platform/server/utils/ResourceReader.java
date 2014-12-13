package com.miaoyou.platform.server.utils;

import java.util.ResourceBundle;

import com.miaoyou.platform.server.constants.Constants;

public class ResourceReader {

    private final static ResourceBundle bundle = ResourceBundle.getBundle(Constants.CONFIG_PATH);

    public static String getString(String arg0) {
        return bundle.getString(arg0);
    }
}
