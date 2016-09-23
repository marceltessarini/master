package com.marceltessarini.lojavirtual.rs.controller.produto;

public class GetProdutosRequest {

	private Long page;
	private Long limit;
	private String nome;
	private String descricao;
	private String todos;
	private Long idCategoria;
	private String order;

	public GetProdutosRequest(Long page, Long limit, String nome, String descricao, String todos, Long idCategoria,
			String order) {
		super();
		this.page = page;
		this.limit = limit;
		this.nome = nome;
		this.descricao = descricao;
		this.todos = todos;
		this.idCategoria = idCategoria;
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

	public String getTodos() {
		return todos;
	}

	public void setTodos(String todos) {
		this.todos = todos;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "GetProdutosRequest [page=" + page + ", limit=" + limit + ", nome=" + nome + ", descricao=" + descricao
				+ ", todos=" + todos + ", idCategoria=" + idCategoria + ", order=" + order + "]";
	}

}
