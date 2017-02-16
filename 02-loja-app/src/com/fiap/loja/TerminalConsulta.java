package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.loja.bo.EstoqueBO;
import com.fiap.loja.config.PropertySingleton;
import com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {
	
	private static Logger log = LoggerFactory.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		log.warn("Início da aplicação");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//Ler a configuração para recuperar o nome da loja
		String loja = PropertySingleton
				.getInstance().getProperty("nome");
		
		System.out.println(loja + "         " +
					sdf.format(Calendar.getInstance().getTime()));
		System.out.println("***********************************");
		
		try {
			
			System.out.print("Digite o código: ");
			int codigo = scanner.nextInt();
			
			EstoqueBO bo = new EstoqueBO();
			ProdutoTO produto = bo.consultarProduto(codigo);
			log.debug("Produto pesquisado - codigo: " + codigo);
			
			if (produto != null){
				System.out.println(produto.getDescricao());
				System.out.println(produto.getQuantidade());
				//Formatar o valor monetário
				DecimalFormat format = new DecimalFormat("R$ #,###.00");
				System.out.println(format.format(produto.getPreco()));
			}else{
				log.error("Código de produto inexistente");
				System.out.println("Produto não cadastrado!");
			}
		
		}catch(InputMismatchException e){
			System.out.println("Código inválido");
			log.error("Código inválido");
		}
		scanner.close();
		log.warn("Fim da aplicação");
	}
	
}
