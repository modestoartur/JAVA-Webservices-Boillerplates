package br.com.fiap.bean;

import br.com.fiap.bean.interfaces.Eletronico;

public class Tablet extends Produto implements Eletronico{

	private String modelo;
	
	private String marca;
	
	private String sistemaOperacional;
	
	private boolean rede3G;
	
	public Tablet(){
		
	}
	
	public Tablet(int codigo, String titulo, double preco, String modelo, String marca, String sistemaOperacional,
			boolean rede3g) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.sistemaOperacional = sistemaOperacional;
		rede3G = rede3g;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public boolean isRede3G() {
		return rede3G;
	}

	public void setRede3G(boolean rede3g) {
		rede3G = rede3g;
	}

	@Override
	public double calcularGarantiaEstendida() {		
		return this.preco*0.05;
	}
	
	@Override
	public String toString() {		
		return getTitulo() + "\n" + modelo + "\n" + marca
			+ "\n" + preco + "\n" + sistemaOperacional 
			+ "\n" + rede3G;
	}
	
}



