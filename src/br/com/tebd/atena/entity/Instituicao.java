package br.com.tebd.atena.entity;

public class Instituicao {
	private Integer id;
	private String nome;
	private String sigla;
	private String endereco;
	private CategoriaAdmInstituicao categoriaAdm;
	private Municipio municipio;
	
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
	public CategoriaAdmInstituicao getCategoriaAdm() {
		return categoriaAdm;
	}
	public void setCategoriaAdm(CategoriaAdmInstituicao categoriaAdm) {
		this.categoriaAdm = categoriaAdm;
	}
	public void setCategoriaAdm(int categoriaId) {
		if(categoriaId == 1)
			this.categoriaAdm = CategoriaAdmInstituicao.Federal;
		else if(categoriaId == 2)
			this.categoriaAdm = CategoriaAdmInstituicao.Estadual;
		else if(categoriaId == 3)
			this.categoriaAdm = CategoriaAdmInstituicao.Municipal;
		else if(categoriaId == 4)
			this.categoriaAdm = CategoriaAdmInstituicao.Privada;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	
}
