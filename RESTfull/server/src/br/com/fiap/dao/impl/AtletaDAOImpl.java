package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.entity.Atleta;

public class AtletaDAOImpl 
			extends GenericDAOImpl<Atleta, Integer>
									implements AtletaDAO{

	public AtletaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Atleta> listar() {
		return em.createQuery("from Atleta",
				Atleta.class).getResultList();
	}

}

