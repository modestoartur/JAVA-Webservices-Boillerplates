package br.com.fiap.view;

import br.com.fiap.bo.JogoBOStub;
import br.com.fiap.bo.JogoBOStub.Cadastrar;
import br.com.fiap.bo.JogoBOStub.Jogo;

public class ConsolveView {

	public static void main(String[] args) {		
		try{
			//Instanciar o Stub
			JogoBOStub stub = new JogoBOStub();
			//Instanciar o jogo
			Jogo jogo = new Jogo();
			jogo.setNome("Pokemon Go");
			jogo.setPreco(0);
			jogo.setProdutora("Niantic");
			//Instanciar a classe "Cadastrar"
			Cadastrar params = new Cadastrar();
			//setar o jogo no objeto "Cadastrar"
			params.setJogo(jogo);
			//Chamar o método de cadastrar do stub
			stub.cadastrar(params);
			//Sucesso!
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
