package com.fiap.loja;

import javax.swing.JOptionPane;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalBuscaPreco {

	public static void main(String[] args) {
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			
			//Parametros para o webservice
			ConsultarProduto params = new ConsultarProduto();
			params.setCodigo(Integer.parseInt(
				JOptionPane.showInputDialog("Código do produto")));
			
			//Chamar o webservice
			ConsultarProdutoResponse response =
								stub.consultarProduto(params);
			
			//Recuperar a resposta do webservice
			ProdutoTO produto = response.get_return();
			
			JOptionPane.showMessageDialog(null, 
					"Descrição: " + produto.getDescricao() +
					"\nPreço: " + produto.getPreco() +
					"\nQtd: " + produto.getQuantidade());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
