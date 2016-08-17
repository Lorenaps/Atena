package br.com.tebd.atena.service;

import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.persistence.IParticipanteDAO;
import br.com.tebd.atena.persistence.mysql.ParticipanteDAO;

public class ParticipanteService {
	private IParticipanteDAO participanteDAO;
	
	public ParticipanteService(){
		this.participanteDAO = new ParticipanteDAO();
	}
	
	public void cadastrar(Participante participante){
		//System.out.println(participante.getNome());
		this.participanteDAO.salvarParticipante(participante);
	}
		
	public Participante buscarParticipantePorNumInscricao(String numInscricao){
		Participante p = this.participanteDAO.buscarParticipantePorNumInscricao(numInscricao);		
		return p;
	}
}
