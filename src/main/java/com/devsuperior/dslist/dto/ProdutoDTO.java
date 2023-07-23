package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Garantia;
import com.devsuperior.dslist.entities.Produto;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Double valor;
    private Integer estoqueMinimo;
    private Integer estoqueMaximo;
    private Integer saldoEstoque;
    private String fornecedor;
    private Boolean garantia;

    private List<GarantiaDTO> garantias = new ArrayList<>();



    public ProdutoDTO(){

    }

    public ProdutoDTO(Long id, String nome, Double valor, Integer estoqueMinimo,
                      Integer estoqueMaximo, Integer saldoEstoque, String fornecedor,
                      Boolean garantia) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.saldoEstoque = saldoEstoque;
        this.fornecedor = fornecedor;
        this.garantia = garantia;
    }

    public ProdutoDTO(Produto entity){
        BeanUtils.copyProperties(entity, this);
        entity.getGarantias().forEach(garantia -> this.garantias.add(new GarantiaDTO(garantia)));
    }


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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Integer getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(Integer estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public Integer getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(Integer saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getGarantia() {
        return garantia;
    }

    public void setGarantia(Boolean garantia) {
        this.garantia = garantia;
    }

    public List<GarantiaDTO> getGarantias() {
        return garantias;
    }

    public void setGarantias(List<GarantiaDTO> garantias) {
        this.garantias = garantias;
    }
}
