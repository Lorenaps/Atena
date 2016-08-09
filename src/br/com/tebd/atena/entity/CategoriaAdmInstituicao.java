package br.com.tebd.atena.entity;

public enum CategoriaAdmInstituicao {
	Federal(1), Estadual(2), Municipal(3), Privada(4);
	
	private final int codVinculo;
	CategoriaAdmInstituicao(int valor){
		codVinculo = valor;
	}
	public int getValor(){
		return codVinculo;
	}
}
