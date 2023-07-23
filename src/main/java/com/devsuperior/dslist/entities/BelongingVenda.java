package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

//Classe de Relacionamento entre Game e GameList
@Entity
@Table(name = "tb_belonging_venda")
public class BelongingVenda {

	//Chave Composta
	@EmbeddedId
	private VendaPK id = new VendaPK();

	private Integer quantidade;


	public VendaPK getId() {
		return id;
	}

	public void setId(VendaPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BelongingVenda that = (BelongingVenda) o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
