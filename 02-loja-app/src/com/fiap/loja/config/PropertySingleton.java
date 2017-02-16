package com.fiap.loja.config;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	private static Properties prop;
	
	private PropertySingleton() {}
	
	public static Properties getInstance(){
		if (prop == null){
			prop = new Properties();
			//carrega as informações
			try {
				prop.load(PropertySingleton
					.class.getResourceAsStream("/loja.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}
