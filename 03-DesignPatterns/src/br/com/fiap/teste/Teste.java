package br.com.fiap.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.property.PropertySingleton;

public class Teste {
	
	private static Logger log = 
			LoggerFactory.getLogger(Teste.class);

	public static void main(String[] args) {
		log.debug("Lendo uma propriedade do sistema");
		//Exibir uma propriedade 
		System.out.println(PropertySingleton
				.getInstance().getProperty("url"));
	}
	
}
