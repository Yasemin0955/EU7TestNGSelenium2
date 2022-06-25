package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader3 {
    private static Properties properties;  //declare a variable from Properties class

    //static blocks it initiates everytime i call the class
    static{

        String path="configurationThree.properties";
        try{
            properties=new Properties();
            FileInputStream file=new FileInputStream(path);
            properties.load(file);
            file.close();
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
