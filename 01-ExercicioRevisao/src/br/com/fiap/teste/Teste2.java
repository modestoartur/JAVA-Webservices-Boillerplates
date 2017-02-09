package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Livro;

public class Teste2 {

	public static void main(String[] args) {
		
		Livro livro1 = new Livro(1, "Harry Potter e calice", 10, 
				"JK Rooling", "Rocco", 
				new GregorianCalendar(1996,Calendar.AUGUST,2 ));
		
		Livro livro2 = new Livro(1, "Harry Potter e prisioneiro", 10, 
				"JK Rooling", "Rocco", 
				new GregorianCalendar(2000,Calendar.DECEMBER,25 ));
		
		Livro livro3 = new Livro(1, "Harry Potter ordem", 10, 
				"JK Rooling", "Rocco", 
				new GregorianCalendar(1996,Calendar.JANUARY,20 ));
		
		
		//Adicionar o livro em uma coleção
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		
		//Exibir os livros
		for (Livro livro : livros) {
			System.out.println("****************");
			System.out.println(livro);
		}
		
	}
	
}
