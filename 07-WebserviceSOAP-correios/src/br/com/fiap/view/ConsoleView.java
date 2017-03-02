package br.com.fiap.view;

import javax.swing.JOptionPane;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) {
		
		try {
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			//Parametros para enviar ao ws
			CalcPrazo params = new CalcPrazo();
			params.setNCdServico("41106"); //SEDEX
			params.setSCepDestino(
				JOptionPane.showInputDialog("CEP de Destino"));
			params.setSCepOrigem(
				JOptionPane.showInputDialog("CEP de Origem"));
			
			//Chama o ws
			CalcPrazoResponse response = stub.calcPrazo(params);
			
			//Recuperar a resposta do ws
			String prazo = response.getCalcPrazoResult().getServicos()
							.getCServico()[0].getPrazoEntrega();
			
			JOptionPane.showMessageDialog(null, "Prazo: " + prazo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}