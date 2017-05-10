package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

@ManagedBean
public class ListaAtletaBean {

	private List<Atleta> lista;
	
	private AtletaRepository rep;
	
	//Método de inicialização do ManagedBean
	@PostConstruct
	private void sensato(){
		rep = new AtletaRepository();
		try {
			lista = rep.listar();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}

	public List<Atleta> getLista() {
		return lista;
	}

	public void setLista(List<Atleta> lista) {
		this.lista = lista;
	}
	
}
