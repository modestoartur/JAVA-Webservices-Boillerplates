package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Atleta;

public interface AtletaDAO 
					extends GenericDAO<Atleta, Integer>{

	List<Atleta> listar();

}
