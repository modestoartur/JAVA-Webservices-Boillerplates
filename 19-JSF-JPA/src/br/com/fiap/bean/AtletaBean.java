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
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			if (atleta.getCodigo() == 0){
				bo.cadastrar(atleta);
				msg = new FacesMessage("Atleta cadastrado!");
			}else{
				bo.atualizar(atleta);
				msg = new FacesMessage("Atleta atualizado!");				
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			return "atleta";
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
								.getFlash().setKeepMessages(true);
		return "lista-atleta?faces-redirect=true";
	}
	
	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
}
