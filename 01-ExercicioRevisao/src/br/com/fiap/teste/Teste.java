package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Livro;
import br.com.fiap.bean.Tablet;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um livro e um tablet
		Tablet tablet = new Tablet(1,"Novo Lenovo 10",
			100, "10G", "Lenovo", "Android", true);
		
		Livro livro = new Livro(2, "Harry Potter", 1200, 
			"JK Rowling", "Rocco", 
			new GregorianCalendar(1996, Calendar.JANUARY , 1));
		
		//Exibir as informações
		System.out.println(tablet);
		System.out.println(livro);
		System.out.println(tablet.calcularGarantiaEstendida());
		
	}
	
}
