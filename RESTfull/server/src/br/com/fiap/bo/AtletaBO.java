package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.dao.impl.AtletaDAOImpl;
import br.com.fiap.entity.Atleta;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class AtletaBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Atleta atleta) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		AtletaDAO dao = new AtletaDAOImpl(em);
		dao.cadastrar(atleta);
		dao.salvar();
		em.close();
	}
	
	public void atualizar(Atleta atleta) throws DBException{
		EntityManager em = fabrica.createEntityManager();
		AtletaDAO dao = new AtletaDAOImpl(em);
		dao.alterar(atleta);
		dao.salvar();
		em.close();
	}
	
	public void remover(int codigo) throws DBException, IdNotFoundException{
		EntityManager em = fabrica.createEntityManager();
		AtletaDAO dao = new AtletaDAOImpl(em);
		dao.remover(codigo);
		dao.salvar();
		em.close();
	}
	
	public Atleta buscar(int codigo){
		EntityManager em = fabrica.createEntityManager();
		AtletaDAO dao = new AtletaDAOImpl(em);
		Atleta atleta = dao.pesquisar(codigo);
		em.close();
		return atleta;
	}
	
	public List<Atleta> listar(){
		EntityManager em = fabrica.createEntityManager();
		AtletaDAO dao = new AtletaDAOImpl(em);
		List<Atleta> lista = dao.listar();
		em.close();
		return lista;
	}
	
}
