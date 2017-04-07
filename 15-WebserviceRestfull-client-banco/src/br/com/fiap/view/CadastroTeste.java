package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

public class CadastroTeste {

	public static void main(String[] args) {
		AtletaRepository rep = new AtletaRepository();

		Atleta atleta = new Atleta();
		atleta.setNome("Rita");
		atleta.setModalidade("Corrida");
		atleta.setRanking(1);
		
		try {
			rep.cadastrar(atleta);
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
