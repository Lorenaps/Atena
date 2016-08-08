package br.com.tebd.atena.service;

import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.persistence.IParticipanteDAO;

public class CadastrarParticipanteService {
	private IParticipanteDAO participanteDAO;
	
	public void cadastrar(Participante participante){
		System.out.println(participante.getNome());
		//this.participanteDAO.salvarParticipante(participante);
	}
}
