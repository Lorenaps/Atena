package br.com.tebd.atena.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.tebd.atena.common.ConstanteUtil;
import br.com.tebd.atena.service.ParticipanteService;

@ManagedBean(name="consultaParticipanteMB")
@RequestScoped
public class ConsultaParticipanteMB {
	private String numInscricao;
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

	public String consultar(){
		if(!this.numInscricao.isEmpty())	return ConstanteUtil.CADASTRO_PARTICIPANTE+ConstanteUtil.REDIRECT;
		
		return null;
	}
}
