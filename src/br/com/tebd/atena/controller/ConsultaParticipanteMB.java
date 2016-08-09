package br.com.tebd.atena.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.tebd.atena.common.ConstanteUtil;
import br.com.tebd.atena.entity.Congresso;
import br.com.tebd.atena.service.CongressoService;
import br.com.tebd.atena.service.ParticipanteService;

@ManagedBean(name="consultaParticipanteMB")
@RequestScoped
public class ConsultaParticipanteMB {
	private String numInscricao;
	//private Congresso congresso;
	//private ArrayList<Congresso> congressos;
	//private CongressoService cs;
	private ParticipanteService ps;
	
	public ConsultaParticipanteMB(){
		this.ps = new ParticipanteService();
		//this.cs = new CongressoService();
		//this.congressos = this.cs.listarTodosCongressos();
	}

	public String getNumInscricao() {
		return numInscricao;
	}

	public void setNumInscricao(String numInscricao) {
		this.numInscricao = numInscricao;
	}
	/*
	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}

	public ArrayList<Congresso> getCongressos() {
		return congressos;
	}

	public void setCongressos(ArrayList<Congresso> congressos) {
		this.congressos = congressos;
	}
	*/

	public String consultar(){
		if(!this.numInscricao.isEmpty())	return ConstanteUtil.CADASTRO_PARTICIPANTE+ConstanteUtil.REDIRECT;
		
		return null;
	}
}
