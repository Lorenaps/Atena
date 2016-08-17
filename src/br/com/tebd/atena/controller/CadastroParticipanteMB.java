package br.com.tebd.atena.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.tebd.atena.common.ConstanteUtil;
import br.com.tebd.atena.common.NumInscricaoUtil;
import br.com.tebd.atena.entity.Estado;
import br.com.tebd.atena.entity.Municipio;
import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.service.MunicipioService;
import br.com.tebd.atena.service.ParticipanteService;

@ManagedBean(name="cadastroParticipanteMB")
@SessionScoped
public class CadastroParticipanteMB {
	private ParticipanteService ps;
	//private EstadoService es;
	private MunicipioService ms;
	
	private Participante participante;
	//private ArrayList<Estado> estados;
	private Estado estado;
	private ArrayList<Municipio> municipios;
	private Municipio municipio;
	private boolean consulta;
	
	public CadastroParticipanteMB(){
		this.ps = new ParticipanteService();
		//this.es = new EstadoService();
		this.ms = new MunicipioService();
		
		this.estado = new Estado();
		this.estado.setId(5);
		this.estado.setNome("BAHIA");
		this.estado.setUf("BA");
		


		
		this.municipios = this.ms.buscarMunicipiosPorEstado(estado);
		//this.estados = this.es.buscarTodos();
		this.participante = new Participante();
		this.municipio = new Municipio();
	}

	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public ArrayList<Municipio> getMunicipios() {
		return municipios;
	}
	public void setMunicipios(ArrayList<Municipio> municipios) {
		this.municipios = municipios;
	}
	public boolean isConsulta() {
		return consulta;
	}
	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String cadastrar(){
		this.participante.setMunicipio(municipio);
		this.participante.setNumInscricao(NumInscricaoUtil.gerarNumInscricao());
		this.ps.cadastrar(this.participante);
		
		this.municipio = new Municipio();
		this.participante = new Participante();
		
		return ConstanteUtil.CADASTRO_PARTICIPANTE+ConstanteUtil.REDIRECT;
	}
	
	public void consultaListener(ActionEvent evt){
		this.consulta = true;
		String num = (String)evt.getComponent().getAttributes().get("inscricao");
		//this.participante.setCpf(num);
		this.participante = this.ps.buscarParticipantePorNumInscricao(num);
		this.municipio = this.participante.getMunicipio();
	}
}
