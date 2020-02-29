package com.recuperacion.distribuida.servicioRest;


import java.util.List;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.recuperacion.distribuida.entidades.Todos;
import com.recuperacion.distribuida.servicios.TodosCrud;




@Path("/todos")
@ApplicationScoped
public class TodosRest {

	
	@Inject
	TodosCrud jdbc ;
		

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response  buscar(@PathParam("id") int id)  {
		
		Todos todos = jdbc.Buscar(id);
		if (todos.getId() == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
        } else {
        	
            return Response.ok(todos).build();
        }
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todos> buscartodo()   {
		return jdbc.buscarTodo();
		
	}
	
	@GET
	@Path(value = "/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public String hola() {
		
		System.out.println("ping");
		return "ok";
	}
	
	
}
