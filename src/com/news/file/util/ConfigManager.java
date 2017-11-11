package com.news.file.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ConfigManager {
	private static Properties properties = new Properties();
	private static ConfigManager manager = new ConfigManager();
	private ConfigManager() {
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static ConfigManager getInstance(){
		return manager;
	}
	public String getValue(String key){
		return properties.getProperty(key);
	}
}
