package com.fiap.loja.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;

import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	//Simula o banco de dados
	private Map<Integer, ProdutoTO> banco;
	
	public EstoqueBO() {
		banco = new HashMap<>();
		banco.put(401, new ProdutoTO(401, "Camiseta Masculina Manga Curta Branca", 100, 10));
		banco.put(402, new ProdutoTO(402, "Camiseta Feminina Manga Longa Rosa", 50, 15));
	}
	
	public ProdutoTO consultarProduto(int codigo) 
										throws AxisFault{
		ProdutoTO prod = banco.get(codigo);
		if (prod == null)
			throw new AxisFault("Produto não cadastrado");
		return prod;
	}
	
}





