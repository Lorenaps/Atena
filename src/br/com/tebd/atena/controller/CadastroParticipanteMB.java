package br.com.tebd.atena.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.tebd.atena.common.ConstanteUtil;
import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.service.ParticipanteService;

@ManagedBean(name="cadastroParticipanteMB")
@SessionScoped
public class CadastroParticipanteMB {
	private ParticipanteService ps;
	private Participante participante;
	private boolean consulta;
	
	public CadastroParticipanteMB(){
		this.ps = new ParticipanteService();
		this.participante = new Participante();
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public String cadastrar(){
		this.ps.cadastrar(this.participante);
		this.participante = new Participante();
		return ConstanteUtil.CADASTRO_PARTICIPANTE+ConstanteUtil.REDIRECT;
	}
	
	public void consultaListener(ActionEvent evt){
		this.consulta = true;
		String num = (String)evt.getComponent().getAttributes().get("inscricao");
		//this.participante.setCpf(num);
		this.participante = this.ps.buscarParticipantePorNumInscricao(num);
	}
}
