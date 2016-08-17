package br.com.tebd.atena.service;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Estado;
import br.com.tebd.atena.entity.Municipio;
import br.com.tebd.atena.persistence.IMunicipioDAO;
import br.com.tebd.atena.persistence.mysql.MunicipioDAO;

public class MunicipioService {
	private IMunicipioDAO municipioDAO;
	
	public MunicipioService(){
		this.municipioDAO = new MunicipioDAO();
	}
	
	public ArrayList<Municipio> buscarMunicipiosPorEstado(Estado estado){
		return this.municipioDAO.listarMunicipiosPorEstado(estado);
	}
	
	public Municipio buscarMunicipioPorId(Integer id){
		Municipio m = new Municipio();
		m.setId(id);
		return this.municipioDAO.listarPorId(m);
	}
}
