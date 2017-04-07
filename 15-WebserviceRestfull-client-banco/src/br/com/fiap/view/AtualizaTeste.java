package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

public class AtualizaTeste {

	public static void main(String[] args) {
		AtletaRepository rep = new AtletaRepository();
		
		try {
			Atleta atleta = rep.buscar(5);
			atleta.setNome("Maria");
			rep.atualizar(atleta);
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
