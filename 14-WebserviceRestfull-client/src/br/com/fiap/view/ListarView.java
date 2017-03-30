package br.com.fiap.view;

import java.util.List;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class ListarView {

	public static void main(String[] args) {
		
		ProdutoRepository rep = new ProdutoRepository();
		
		try {
			List<ProdutoTO> lista = rep.listar();
			for (ProdutoTO produtoTO : lista) {
				System.out.println(produtoTO.getNome());
				System.out.println(produtoTO.getPreco());
				System.out.println(produtoTO.getQuantidade());
				System.out.println("************");
			}
		} catch (WebServiceException e) {
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
