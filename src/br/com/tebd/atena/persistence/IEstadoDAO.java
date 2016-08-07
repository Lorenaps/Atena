package br.com.tebd.atena.persistence;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Estado;

public interface IEstadoDAO {
	public ArrayList<Estado> listarTodos();
}