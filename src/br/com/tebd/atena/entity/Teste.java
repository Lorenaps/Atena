package br.com.tebd.atena.entity;

import java.util.ArrayList;

import br.com.tebd.atena.persistence.mysql.EstadoDAO;
import br.com.tebd.atena.persistence.mysql.MunicipioDAO;

public class Teste {
	
	public static void escolheVinculo(VinculoInstitucional v){
		if(v == VinculoInstitucional.Discente){
			System.out.println("Discente lenhado!");
		}
		else if(v == VinculoInstitucional.Docente){
			System.out.println("É docente");
		}
	}
	
	public static void testaEstados(){
		EstadoDAO t = new EstadoDAO();
		ArrayList<Estado> e = new ArrayList<>();
		e = t.listarTodos();
		
		for(int i=0; i< e.size();i++){
			System.out.println(e.get(i).getId()+" "+ e.get(i).getUf()
								+ " " + e.get(i).getNome());
		}
	}
	
	public static void testaMunicipiosEstado(){
		Estado estado = new Estado();
		MunicipioDAO t = new MunicipioDAO();
		ArrayList<Municipio> e = new ArrayList<>();
		
		estado.setId(4);
		e = t.listarMunicipiosPorEstado(estado);
		
		for(int i=0; i< e.size();i++){
			System.out.println(e.get(i).getId()+" "+ e.get(i).getUf()
								+ " " + e.get(i).getNome());
		}
	}

	public static void main(String[] args) {
		testaMunicipiosEstado();
		
	}
	

}
