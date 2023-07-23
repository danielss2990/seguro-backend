package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Produto;
import com.devsuperior.dslist.entities.Venda;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VendaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double valorTotal = 0.0;

    private List<ProdutoDTO> produtos = new ArrayList<>();

    private List<ItemDTO> lista = new ArrayList<>();

    public VendaDTO() {

    }

    public VendaDTO(Long id) {
        this.id = id;
    }

    public VendaDTO(Venda entity) {
        BeanUtils.copyProperties(entity, this);
        entity.getProdutos().forEach(produto -> this.produtos.add(new ProdutoDTO(produto)));

        final Double[] valor = {0.0};
        produtos.forEach(produto -> valor[0] += produto.getValor());
        this.valorTotal = valor[0];

        for (ProdutoDTO produto : produtos) {
            this.lista.add(new ItemDTO(produto.getId(), produto.getValor(), produto.getValor()));
        }

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}


