package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

@Path("/atleta")
public class AtletaResource {

	private AtletaBO bo = new AtletaBO();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) //Retorna JSON
	public Atleta buscar(@PathParam("id") int codigo){
		return bo.buscar(codigo);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Atleta> listar(){
		return bo.listar();
	}
	
	//POST /rest/atleta
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //Recebe JSON
	public Response cadastrar(Atleta atleta, 
								@Context UriInfo uriInfo){
		try {
			bo.cadastrar(atleta);
		} catch (DBException e) {
			e.printStackTrace();
			throw new WebApplicationException();
		}
		//Construir a URL para acessar o atleta cadastrado
		//localhost:8080/Projeto/rest/atleta/codigo
		UriBuilder uri = UriBuilder.fromPath(uriInfo.getPath());
		uri.path(String.valueOf(atleta.getCodigo()));
		
		return Response.created(uri.build()).build();
	}
	
	
	//PUT /rest/atleta/1
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Atleta atleta, 
							@PathParam("id") int codigo){
		try {
			atleta.setCodigo(codigo);
			bo.atualizar(atleta);
		} catch (DBException e) {
			e.printStackTrace();
			throw new WebApplicationException();
		}
		return Response.ok().build(); //HTTP STATUS 200 OK
	}
	

	//DELETE /rest/atleta/1
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo){
		try {
			bo.remover(codigo);
		} catch (DBException | IdNotFoundException e) {
			e.printStackTrace();
			throw new WebApplicationException();
		}
	}
	
}



