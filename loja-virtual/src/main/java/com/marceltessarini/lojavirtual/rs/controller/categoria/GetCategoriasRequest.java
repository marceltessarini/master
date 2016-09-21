package com.marceltessarini.lojavirtual.rs.controller.categoria;

public class GetCategoriasRequest {

	private Long page;
	private Long limit;
	private String status;
	private String nomeCategoria;
	private String produto;
	private String order;

	public GetCategoriasRequest(Long page, Long limit, String status, String nomeCategoria, String produto,
			String order) {
		super();
		this.page = page;
		this.limit = limit;
		this.status = status;
		this.nomeCategoria = nomeCategoria;
		this.produto = produto;
		this.order = order;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
