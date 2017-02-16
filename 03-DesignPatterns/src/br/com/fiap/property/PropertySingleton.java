package br.com.fiap.property;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {
	
	private static Logger log = LoggerFactory
					.getLogger(PropertySingleton.class);

	private static Properties prop;
	
	//Construtor private
	private PropertySingleton(){}
	
	//Método que retorna a instancia de Properties
	public static Properties getInstance(){
		if (prop == null){
			log.info("Instanciando o Properties");
			//Instancia um properties
			prop = new Properties();
			try {
				log.info("Carregando as propriedades");
				//Carregar o arquivo de configurações no objeto
				prop.load(PropertySingleton.class
					.getResourceAsStream("/config.properties"));
			} catch (IOException e) {
				log.error("Erro ao carregar as propriedades");
				e.printStackTrace();
			}
		}
		log.trace("Retornando as propriedades");
		return prop;
	}
	
}
