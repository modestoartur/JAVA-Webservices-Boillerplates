package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

public class BuscaTeste {

	public static void main(String[] args) {
		AtletaRepository rep = new AtletaRepository();
		
		try {
			System.out.println("Listagem");
			List<Atleta> listar = rep.listar();
			for (Atleta atleta : listar) {
				System.out.println(atleta.getNome());
			}
			
			System.out.println("Busca por código");
			Atleta atleta = rep.buscar(5);
			System.out.println(atleta.getNome());
			
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
