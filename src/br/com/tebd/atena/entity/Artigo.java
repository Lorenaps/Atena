package br.com.tebd.atena.entity;

public class Artigo {
	private Long id;
	private Integer numSubmissao;
	private String titulo;
	private String resumo;
	private Integer nota;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumSubmissao() {
		return numSubmissao;
	}
	public void setNumSubmissao(Integer numSubmissao) {
		this.numSubmissao = numSubmissao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	
}
