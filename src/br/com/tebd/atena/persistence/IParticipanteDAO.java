package br.com.tebd.atena.persistence;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Participante;

public interface IParticipanteDAO {
	public Participante buscarParticipantePorNumInscricao(String numInscricao, Integer idCongresso);
	public Participante buscarParticipantePorCPF(String cpf);
	public ArrayList<Participante> listarTodos();
	public void salvarParticipante(Participante participante); //saveOrUpdate
}
