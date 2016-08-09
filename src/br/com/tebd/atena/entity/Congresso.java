package br.com.tebd.atena.entity;

import java.util.Date;

public class Congresso {
	private Integer id;
	private String nome;
	private String endereco;
	private Date dataInicio;
	private Date dataFinal;
	private Date dataInicioSubmissaoArtigos;
	private Date dataFinalSubmissaoArtigos;
	private AreaConhecimento areaConhecimento;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Date getDataInicioSubmissaoArtigos() {
		return dataInicioSubmissaoArtigos;
	}
	public void setDataInicioSubmissaoArtigos(Date dataInicioSubmissaoArtigos) {
		this.dataInicioSubmissaoArtigos = dataInicioSubmissaoArtigos;
	}
	public Date getDataFinalSubmissaoArtigos() {
		return dataFinalSubmissaoArtigos;
	}
	public void setDataFinalSubmissaoArtigos(Date dataFinalSubmissaoArtigos) {
		this.dataFinalSubmissaoArtigos = dataFinalSubmissaoArtigos;
	}
	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}
	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	
}
