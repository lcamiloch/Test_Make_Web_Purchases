package com.rosengroup.qa.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesConfig {

    static Properties prop;
    static FileInputStream file;

    public static String getParameter(String variable){
        prop = new Properties();
        try{
            file = new FileInputStream(
                    "src/test/resources/applications.properties");
            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(variable);
    }
}