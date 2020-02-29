package com.recuperacion.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import com.recuperacion.distribuida.entidades.Todos;


@ApplicationScoped
@Transactional
public class TodosCrudImpl implements TodosCrud{
	
	@PersistenceContext
	private EntityManager em;
	
	
	  
	@Override
	  public Todos Buscar(int id) {
		  Todos todos = em.find(Todos.class, id);
				return todos;
	  }

	@Override
	  public List<Todos> buscarTodo() {
		  TypedQuery<Todos> query = em.createQuery("Select e from Todos e", Todos.class);
	      List<Todos> todos = query.getResultList();
	      return todos;

	  }
	  
	
	  
}
