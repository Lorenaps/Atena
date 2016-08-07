package br.com.tebd.atena.persistence;

import java.util.ArrayList;

import br.com.tebd.atena.entity.Instituicao;

public interface IInstituicaoDAO {
	public ArrayList<Instituicao> listarTodas();
}
