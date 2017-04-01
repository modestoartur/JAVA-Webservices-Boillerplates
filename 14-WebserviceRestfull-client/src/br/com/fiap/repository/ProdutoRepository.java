package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.to.ProdutoTO;

//Classe para acessar o webservice
public class ProdutoRepository {

	private Client client = Client.create();
	
	private static final String URL = "http://localhost:8080/12-WebserviceRestfull-server/rest/produto/";
	
	public List<ProdutoTO> listar() throws WebServiceException{
		WebResource resource = client.resource(URL);
		
		ClientResponse response =
				//Tipo de retorno aceito JSON
				resource.accept(MediaType.APPLICATION_JSON)
								//Faz o método GET
								.get(ClientResponse.class);
		
		//Validar o HTTP Status code
		if (response.getStatus() != 200){
			throw new WebServiceException(
					"HTTP Status: " + response.getStatus());
		}
		
		//Recuperar as informações enviadas pelo servidor
		ProdutoTO[] array = response.getEntity(ProdutoTO[].class);
		//Transforma o array em List e retorna
		return Arrays.asList(array);
	}
	
	public ProdutoTO buscar(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo); 
		
		ClientResponse response = 
			resource.accept(MediaType.APPLICATION_JSON)
			.get(ClientResponse.class);
		
		if (response.getStatus() != 200){
			throw new WebServiceException("HTTP Status: " +
					response.getStatus());
		}
		
		return response.getEntity(ProdutoTO.class);
	}
	
	public void cadastrar(ProdutoTO produto) throws WebServiceException{
		WebResource resource = client.resource(URL);
		ClientResponse response = resource 
			.type(MediaType.APPLICATION_JSON)
			.post(ClientResponse.class,produto);
		//Status 201 Created
		if (response.getStatus() != 201){
			throw new WebServiceException("HTTP Status: "
					+ response.getStatus());
		}
	}
	
	public void atualizar(ProdutoTO produto) throws WebServiceException{
		WebResource resource = 
				client.resource(URL + produto.getCodigo());
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,produto);
		
		if (response.getStatus() != 200){
			throw new WebServiceException("HTTP Status: "
					+ response.getStatus());
		}
	}
	
	public void remover(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = 
				resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204){
			throw new WebServiceException("HTTP Status: "
					+ response.getStatus());
		}
	}
	
	
}









