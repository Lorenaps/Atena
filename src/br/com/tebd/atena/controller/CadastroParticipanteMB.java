package br.com.tebd.atena.controller;

import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.service.CadastrarParticipanteService;

public class CadastroParticipanteMB {
	private CadastrarParticipanteService cps;
	private Participante participante;

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public String cadastrar(){
		this.cps.cadastrar(this.participante);
		return null;
	}
}
