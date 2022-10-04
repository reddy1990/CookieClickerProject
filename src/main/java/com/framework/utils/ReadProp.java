package com.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	
	public static String readData(String value) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/Config/Config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(value);
	}

}
