package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {

	private static HashMap<Integer, ProdutoTO> banco = new HashMap<>();
	private static int sequence = 3;
	
	static {
		banco.put(1, new ProdutoTO(1, "Iphone", 10000, 10));
		banco.put(2, new ProdutoTO(2, "Samsung", 500, 10));
		banco.put(3, new ProdutoTO(3, "LG", 10000, 50));
	}
	
	public void cadastrar(ProdutoTO produto){
		produto.setCodigo(++sequence);
		banco.put(sequence, produto);
	}
	
	public ProdutoTO buscar(int codigo){
		return banco.get(codigo);
	}
	
	public void remover(int codigo){
		banco.remove(codigo);
	}
	
	public List<ProdutoTO> listar(){
		return new ArrayList<ProdutoTO>(banco.values());
	}
	
	public void alterar(ProdutoTO produto){
		banco.put(produto.getCodigo(), produto);
	}
	
	
	
}
