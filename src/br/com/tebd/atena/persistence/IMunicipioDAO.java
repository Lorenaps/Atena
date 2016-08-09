package br.com.tebd.atena.persistence;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Estado;
import br.com.tebd.atena.entity.Municipio;

public interface IMunicipioDAO {
	public ArrayList<Municipio> listarTodos();
	public ArrayList<Municipio> listarMunicipiosPorEstado(Estado estado);
	public Municipio listarPorId(Municipio munic);
}
