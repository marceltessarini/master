package com.marceltessarini.lojavirtual.negocio.catagolo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Catalogo {

	@Id
	@SequenceGenerator(name="sq_catalogo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_catalogo")
	private Long id;
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "idCatalogo")
	private Catalogo catalogo;

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

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}
