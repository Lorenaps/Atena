package br.com.tebd.atena.entity;

import java.util.ArrayList;

import br.com.tebd.atena.persistence.mysql.AreaConhecimentoDAO;
import br.com.tebd.atena.persistence.mysql.CongressoDAO;
import br.com.tebd.atena.persistence.mysql.EstadoDAO;
import br.com.tebd.atena.persistence.mysql.InstituicaoDAO;
import br.com.tebd.atena.persistence.mysql.MunicipioDAO;
import br.com.tebd.atena.persistence.mysql.ParticipanteDAO;

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
	
	public static void testaInstituicao(){
		InstituicaoDAO t = new InstituicaoDAO();
		ArrayList<Instituicao> e = new ArrayList<>();
		e = t.listarTodas();
			
		for(int i=0; i< e.size();i++){
			System.out.println(e.get(i).getNome());
		}
	}
	
	public static void testaParticipante(){
		ParticipanteDAO t = new ParticipanteDAO();
		ArrayList<Participante> e = new ArrayList<>();
		Participante p = new Participante();
		Congresso c = new Congresso();
		c.setId(1);
		
		p.setNome("Daniel");
		p.setTelefone("(21)367498");
		p.setCpf("12345678999");
		p.setEmail("Daniel@gmail.com");
		p.setRevisor(true);
		p.setEndereco("Rua de cima N 10");
		p.setNumInscricao(70001);
		p.setCongresso(c);
		
		Municipio m = new Municipio();
		m.setId(30);
		
		p.setMunicipio(m);
		
		if(t.salvarParticipante(p))
			System.out.println("Cadastro com Sucesso");
		else
			System.out.println("Erro no cadastro");

	}

	public static void main(String[] args) {
		testaParticipante();
	}
	

}
