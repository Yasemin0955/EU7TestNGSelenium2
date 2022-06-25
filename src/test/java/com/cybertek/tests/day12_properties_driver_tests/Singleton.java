package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {
    //singleton class will have private constructor
    //it means other classes can not create object of this class
    private Singleton(){}
    private static String str;
    public static String getInstance(){
        if(str==null){
            System.out.println("str is null, assigning a value to it");
            str="somevalue";
        }else{
            System.out.println("it has value just return it");
        }
        return str;
    }
}
