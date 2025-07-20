package com.bdd.utils;
import java.io.InputStream;
import java.util.Properties;

	public class ConfigManager {
		private static Properties properties = new Properties();

	    static {
	        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
	            properties.load(input);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
	}




