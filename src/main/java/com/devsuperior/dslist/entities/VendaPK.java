package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class VendaPK {

	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda venda;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VendaPK vendaPK = (VendaPK) o;
		return venda.equals(vendaPK.venda) && produto.equals(vendaPK.produto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(venda, produto);
	}
}
