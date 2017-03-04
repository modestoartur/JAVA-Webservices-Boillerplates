package br.com.fiap.dao.impl;

import br.com.fiap.entity.Jogo;
import javax.persistence.EntityManager;
import br.com.fiap.dao.JogoDAO;

public class JogoDAOImpl 
				extends GenericDAOImpl<Jogo, Integer> 
										implements JogoDAO{

	public JogoDAOImpl(EntityManager em) {
		super(em);
	}

}