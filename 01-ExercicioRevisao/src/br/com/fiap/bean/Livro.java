package br.com.fiap.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Livro extends Produto{

	private String autor;
	
	private String editora;
	
	private Calendar dataLancamento;
	
	public Livro(){
		
	}
	
	public Livro(int codigo, String titulo, double preco, String autor, String editora, Calendar dataLancamento) {
		super(codigo, titulo, preco);
		this.autor = autor;
		this.editora = editora;
		this.dataLancamento = dataLancamento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatador = 
				new SimpleDateFormat("dd/MM/yyyy");
		return getTitulo() + "\n" + autor + "\n" + editora
			+ "\n" + preco + "\n" + 
				formatador.format(dataLancamento.getTime());
	}
	
}
