package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;

public class RemoveTeste {

	public static void main(String[] args) {
		AtletaRepository rep = new AtletaRepository();
		try {
			rep.remover(5);
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
}
