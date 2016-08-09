package br.com.tebd.atena.entity;

import java.util.ArrayList;

import br.com.tebd.atena.persistence.mysql.AreaConhecimentoDAO;
import br.com.tebd.atena.persistence.mysql.CongressoDAO;
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
	
	public static void testaAreaConhecimento(){
		AreaConhecimento area = new AreaConhecimento();
		AreaConhecimentoDAO t = new AreaConhecimentoDAO();
		ArrayList<AreaConhecimento> e = new ArrayList<>();
		
		e = t.listarTodas();
		
		for(int i=0; i< e.size();i++){
			System.out.println(e.get(i).getId()+" " + e.get(i).getNome()
								+ " " + e.get(i).getCodigo());
		}
	}
	
	public static void testaCongresso(){
		Congresso o = new Congresso();
		CongressoDAO t = new CongressoDAO();
		o = t.listarTodos();
			
		System.out.println(o.getId()+" " + o.getDataInicio().toString() + " "
							+ o.getAreaConhecimento().getNome());
	}

	public static void main(String[] args) {
		testaCongresso();
		
	}
	

}
