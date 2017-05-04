package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;
import br.com.fiap.exception.DBException;

@ManagedBean
public class AtletaBean {

	private Atleta atleta;

	private AtletaBO bo;
	
	@PostConstruct
	private void init(){
		atleta = new Atleta();
		bo = new AtletaBO();
	}
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			bo.cadastrar(atleta);
			msg = new FacesMessage("Atleta cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
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
