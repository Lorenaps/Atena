package br.com.tebd.atena.entity;

public enum VinculoInstitucional {
	Egresso(1), Discente(2), Docente(3), Pesquisador(4);
	
	private final int codVinculo;
	VinculoInstitucional(int valor){
		codVinculo = valor;
	}
	public int getValor(){
		return codVinculo;
	}
}
