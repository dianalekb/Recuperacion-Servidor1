package com.recuperacion.distribuida.servicios;

import java.util.List;

import com.recuperacion.distribuida.entidades.Todos;



public interface TodosCrud {
	
	 public Todos Buscar(int id);
	 public List<Todos> buscarTodo();
	
}
