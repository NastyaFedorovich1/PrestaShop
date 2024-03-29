package com.prestashop.testing.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().
                    getResourceAsStream("config.properties"));
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static long getTimeout(){
        return Long.parseLong(properties.getProperty("timeout"));
    }
}
