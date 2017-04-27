package br.com.fiap.bean;

import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.JogoBOStub;
import br.com.fiap.bo.JogoBOStub.Cadastrar;
import br.com.fiap.bo.JogoBOStub.Jogo;

@ManagedBean
public class JogoBean {

	private Jogo jogo;
	
	private JogoBOStub stub;
	
	@PostConstruct
	private void inicializacao(){
		jogo = new Jogo();
		try {
			stub = new JogoBOStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			Cadastrar params = new Cadastrar();
			params.setJogo(jogo);
			stub.cadastrar(params);
			msg = new FacesMessage("Cadastrado!");
		} catch (RemoteException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
}
