package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.to.Atleta;

@ManagedBean
public class AtletaBean {

	private Atleta atleta;
	
	private AtletaRepository rep;
	
	//Método de inicialização
	@PostConstruct
	public void init(){
		atleta = new Atleta();
		rep = new AtletaRepository();
	}
	
	//Método para o clique do botão
	public void cadastrar(){
		FacesMessage msg;
		try {
			rep.cadastrar(atleta);
			msg = new FacesMessage("Atleta cadastrado!");
		} catch (WebServiceException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
}
