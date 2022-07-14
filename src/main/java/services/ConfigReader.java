package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private final String propertyDir = System.getProperty("user.dir") + "/src/test/resources/";
	private String propertyFilePath;

	/**
	 * Constructor to load the data property file
	 * 
	 * @author shubham_k
	 * @param String
	 * @exception IOException FileNotFoundException
	 */
	public ConfigReader(String propertyFilePath) {
		BufferedReader reader;
		this.propertyFilePath = this.propertyDir + propertyFilePath;
		try {
			reader = new BufferedReader(new FileReader(this.propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + this.propertyFilePath);
		}
	}
	
	/**
	 * Constructor to load the config property file
	 * 
	 * @author shubham_k
	 * @exception IOException FileNotFoundException
	 */
	public ConfigReader() {
		BufferedReader reader;
		this.propertyFilePath = this.propertyDir + "config.properties";
		try {
			reader = new BufferedReader(new FileReader(this.propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at config.properties");
		}
	}

	/**
	 * Get property value
	 * 
	 * @author shubham_k
	 * @param String
	 * @return String
	 * @exception RuntimeException
	 */
	public String getPropertyValue(String key) {
		String val = properties.getProperty(key);
		if (val != null) {
			return val;
		} else {
			throw new RuntimeException(key + " not specified in the properties file.");
		}
	}

}
