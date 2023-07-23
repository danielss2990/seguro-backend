package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.projections.VendaProjection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VendaProjecaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long venda;
    private Long id;
    private String nome;
    private Double valor;
    private Integer quantidade;
    private Double total;

    private Double valorTotalVenda;

    private List<GarantiaDTO> garantias = new ArrayList<>();

    public VendaProjecaoDTO(){

    }

    public VendaProjecaoDTO(Long venda, Long id, String nome, Double valor, Integer quantidade, Double total) {
        this.venda = venda;
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.total = total;
    }

    public VendaProjecaoDTO(VendaProjection projection) {
        this.venda = projection.getVenda();
        this.id = projection.getId();
        this.nome = projection.getNome();
        this.valor = projection.getValor();
        this.quantidade = projection.getQuantidade();
        this.total = projection.getTotal();
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getVenda() {
        return venda;
    }

    public void setVenda(Long vendaId) {
        this.venda = venda;
    }

    public Double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(Double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public List<GarantiaDTO> getGarantias() {
        return garantias;
    }

    public void setGarantias(List<GarantiaDTO> garantias) {
        this.garantias = garantias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaProjecaoDTO that = (VendaProjecaoDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
