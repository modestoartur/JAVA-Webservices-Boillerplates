package com.fiap.loja.to;

import java.io.Serializable;

public class ProdutoTO implements Serializable{

	private int codigo;
	
	private String descricao;
	
	private int quantidade;
	
	private double preco;

	public ProdutoTO() {
		super();
	}

	public ProdutoTO(int codigo, String descricao, int quantidade, double preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}