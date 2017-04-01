package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class AtualizarTeste {

	public static void main(String[] args) {
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = new ProdutoTO(1, 
				"Placa de video", 100, 2);
		
		try {
			rep.atualizar(produto);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
