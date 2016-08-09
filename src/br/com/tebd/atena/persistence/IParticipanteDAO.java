package br.com.tebd.atena.persistence;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Participante;

public interface IParticipanteDAO {
	public Participante buscarParticipantePorNumInscricao(String numInscricao);
	public ArrayList<Participante> listarTodos();
	public boolean salvarParticipante(Participante participante);
	public boolean alterarParticipante(Participante participante); 

}
