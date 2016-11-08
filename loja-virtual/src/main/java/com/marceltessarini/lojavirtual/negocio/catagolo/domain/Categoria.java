package com.marceltessarini.lojavirtual.negocio.catagolo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sq_categoria")
    @SequenceGenerator(name="sq_categoria", sequenceName="sq_categoria", allocationSize=1)
	private Long id;
	private String nome;
	private String descricao;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoriaMae;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoriaMae() {
		return categoriaMae;
	}

	public void setCategoriaMae(Categoria categoriaMae) {
		this.categoriaMae = categoriaMae;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
