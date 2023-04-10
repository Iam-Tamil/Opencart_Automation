package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperty {

	private static Properties property;

	/**
	 * This method will read the properties file
	 * 
	 * @param String filePath
	 */
	public static void loadPropertyFile(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			property = new Properties();
			property.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will return the value for a specific key
	 * 
	 * @param String key
	 * @return String value
	 */
	public static String getPropertyFile(String key) {
		return property.getProperty(key);
	}
}
