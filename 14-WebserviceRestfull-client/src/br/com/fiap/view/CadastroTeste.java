package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class CadastroTeste {

	public static void main(String[] args) {
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = new ProdutoTO(0, 
				"Arduino", 100, 1000);
		try {
			rep.cadastrar(produto);
			System.out.println("Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
