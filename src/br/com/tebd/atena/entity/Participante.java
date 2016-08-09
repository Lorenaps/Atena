package br.com.tebd.atena.entity;

import java.util.ArrayList;

public class Participante {
	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private String cpf;
	private boolean revisor;
	private Integer numInscricao;
	private Congresso congresso;
	private Municipio municipio;
	private ArrayList<AreaConhecimento> areasConhecimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public boolean isRevisor() {
		return revisor;
	}
	public void setRevisor(boolean revisor) {
		this.revisor = revisor;
	}
	public Integer getNumInscricao() {
		return numInscricao;
	}
	public void setNumInscricao(Integer numInscricao) {
		this.numInscricao = numInscricao;
	}
	public Congresso getCongresso() {
		return congresso;
	}
	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}
	public ArrayList<AreaConhecimento> getAreasConhecimento() {
		return areasConhecimento;
	}
	public void setAreaConhecimento(ArrayList<AreaConhecimento> areasConhecimento) {
		this.areasConhecimento = areasConhecimento;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
}
