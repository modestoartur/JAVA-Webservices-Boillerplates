package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMediaResponse;

public class TerminalConsulta {

	public static void main(String[] args) {
		try {
			//Chamar o webservice:
			DisciplinaBOStub bo = new DisciplinaBOStub();
			
			//Valores para o webservice
			CalcularMedia valores = new CalcularMedia();
			valores.setAm(10);
			valores.setNac(8);
			valores.setPs(3);
			
			//Chama o webservice
			CalcularMediaResponse response =
								bo.calcularMedia(valores);
			
			//Recupera o retorno do webservice
			double media = response.get_return();
			
			System.out.println("Média: " + media);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
