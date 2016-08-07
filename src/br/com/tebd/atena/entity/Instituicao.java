package br.com.tebd.atena.entity;

public class Instituicao {
	private Integer id;
	private String nome;
	private String sigla;
	private String endereco;
	private String categoriaAdm;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCategoriaAdm() {
		return categoriaAdm;
	}
	public void setCategoriaAdm(String categoriaAdm) {
		this.categoriaAdm = categoriaAdm;
	}
	
	
}
