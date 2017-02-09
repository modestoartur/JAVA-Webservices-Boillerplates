package br.com.fiap.bean;

public class Produto {
	
	private int codigo;
	
	private String titulo;

	protected double preco;
	
	public Produto(){
		
	}
	
	public Produto(int codigo, String titulo, double preco){
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
