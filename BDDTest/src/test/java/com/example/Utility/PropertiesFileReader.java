package com.example.Utility;

import java.io.FileInputStream;
//import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	public Properties getProperty() 
	{
		FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {        	 
            properties.load(new FileInputStream("src/test/resources/browser-config.properties"));
            
            properties.load(new FileInputStream("src/test/resources/testdata-config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return properties;	
	}
	
	
}
