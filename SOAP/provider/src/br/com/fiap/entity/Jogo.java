package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqJogo",
sequenceName="SQ_TB_JOGO",allocationSize=1)
public class Jogo {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqJogo")
	private int codigo;
	
	private String nome;
	
	private String produtora;
	
	private float preco;
	
	public Jogo() {
		super();
	}

	public Jogo(int codigo, String nome, String produtora, float preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.produtora = produtora;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
