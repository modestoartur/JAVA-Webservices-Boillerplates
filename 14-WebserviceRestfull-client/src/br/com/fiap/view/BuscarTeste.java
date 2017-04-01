package br.com.fiap.view;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class BuscarTeste {

	public static void main(String[] args) {
		ProdutoRepository rep = new ProdutoRepository();
		
		try {
			//Buscar o produto de código 1
			ProdutoTO produto = rep.buscar(2);
			System.out.println(produto.getNome());
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
	
}
