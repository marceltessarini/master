package com.marceltessarini.lojavirtual.rs.controller.ranking;

/**
 * Request com os parâmetros para se consultar os rankings de um produto.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public class RankingsDoProdutoRequest {

	private Long page;
	private Long limit;
	private Long idProduto;
	private String order;

	public RankingsDoProdutoRequest(Long page, Long limit, Long idProduto, String order) {
		super();
		this.page = page;
		this.limit = limit;
		this.idProduto = idProduto;
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

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
