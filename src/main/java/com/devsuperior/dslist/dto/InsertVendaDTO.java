package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Venda;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InsertVendaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer quantidade;

    private Long produtoID;

    private Long vendaID;

    public InsertVendaDTO() {

    }

    public InsertVendaDTO(Integer quantidade, Long produtoID, Long vendaID) {
        this.quantidade = quantidade;
        this.produtoID = produtoID;
        this.vendaID = vendaID;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Long produtoID) {
        this.produtoID = produtoID;
    }

    public Long getVendaID() {
        return vendaID;
    }

    public void setVendaID(Long vendaID) {
        this.vendaID = vendaID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsertVendaDTO that = (InsertVendaDTO) o;
        return produtoID.equals(that.produtoID) && vendaID.equals(that.vendaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoID, vendaID);
    }
}


