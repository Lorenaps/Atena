package br.com.tebd.atena.service;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Estado;
import br.com.tebd.atena.persistence.IEstadoDAO;
import br.com.tebd.atena.persistence.mysql.EstadoDAO;

public class EstadoService {
	private IEstadoDAO estadoDAO;
	
	public EstadoService(){
		this.estadoDAO = new EstadoDAO();
	}
	
	public ArrayList<Estado> buscarTodos(){
		return this.estadoDAO.listarTodos();
	}
	
	
}
