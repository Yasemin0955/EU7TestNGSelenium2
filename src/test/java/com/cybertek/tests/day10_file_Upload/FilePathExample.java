package com.cybertek.tests.day10_file_Upload;

import org.testng.annotations.Test;

public class FilePathExample {
    @Test
    public void test1(){
      //  C:\Users\Luton\IdeaProjects\EU7TestNGSelenium\src\test\resources\textfile.txt -->absolute path
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));

        System.out.println(System.getProperty("user.dir"));
        String projectPath=System.getProperty("user.dir");  //dynamic project path
        String filePath="src/test/resources/textfile.txt";   //static file path
        String fullPath=projectPath+"/"+filePath;
        System.out.println(fullPath);
    }
}
