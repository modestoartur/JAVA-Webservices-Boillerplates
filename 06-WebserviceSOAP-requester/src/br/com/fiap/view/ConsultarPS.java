package br.com.fiap.view;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPs;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPsResponse;

public class ConsultarPS {

	public static void main(String[] args) {
		//Chamar o serviço de calcular nota da ps necessária
		try {
			DisciplinaBOStub bo = new DisciplinaBOStub();
			
			CalcularPs valores = new CalcularPs();
			valores.setAm(2);
			valores.setNac(2);
			
			CalcularPsResponse response = bo.calcularPs(valores);
			
			double ps = response.get_return();
			
			System.out.println("Você precisa de: " + ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
