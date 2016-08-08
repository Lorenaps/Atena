package br.com.tebd.atena.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tebd.atena.common.ConstanteUtil;
import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.service.CadastrarParticipanteService;

@ManagedBean(name="cadastroParticipanteMB")
@SessionScoped
public class CadastroParticipanteMB {
	private CadastrarParticipanteService cps;
	private Participante participante;
	
	public CadastroParticipanteMB(){
		this.cps = new CadastrarParticipanteService();
		this.participante = new Participante();
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public String cadastrar(){
		this.cps.cadastrar(this.participante);
		this.participante = new Participante();
		return ConstanteUtil.CADASTRO_PARTICIPANTE+ConstanteUtil.REDIRECT;
	}
}
