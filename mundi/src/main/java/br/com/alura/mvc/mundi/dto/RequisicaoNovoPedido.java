package br.com.alura.mvc.mundi.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mundi.model.Pedido;

public class RequisicaoNovoPedido {

	/*
	 * Por padrão, quando ocorre um Exception
	 * dos campos RequisicaoNovoPedido eles possuem
	 * a seguinte estrutura: 
	 * NotBlank.requisicaoNovoPedido.nomeProduto
	 * 
	 */
	@NotBlank @Min(5) @Max(20) //tem a opção de colocar a mensagem aqui, mas pode colocar em um arquivo externo
	private String nomeProduto;
	@NotBlank
	private String urlProduto;
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		return pedido;
		
	}

}
