package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private Double valor;
    private Integer estoqueMinimo;
    private Integer estoqueMaximo;
    private Integer saldoEstoque;
    private String fornecedor;
    private Boolean garantia;

    @ManyToMany
    @JoinTable(
            name="tb_produto_garantia",
            joinColumns = @JoinColumn(name="produto_id"),
            inverseJoinColumns = @JoinColumn(name="garantia_id")
    )
    Set<Garantia> garantias = new HashSet<>();



    @ManyToMany
    @JoinTable(
            name="tb_produto_vendas",
            joinColumns = @JoinColumn(name="produto_id"),
            inverseJoinColumns = @JoinColumn(name="venda_id")
    )
    Set<Venda> vendas = new HashSet<>();


    public Produto(){

    }

    public Produto(Long id, String nome, Double valor, Integer estoqueMinimo,
                   Integer estoqueMaximo, Integer saldoEstoque, String fornecedor, Boolean garantia) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.saldoEstoque = saldoEstoque;
        this.fornecedor = fornecedor;
        this.garantia = garantia;
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

    public Set<Garantia> getGarantias() {
        return garantias;
    }

    public void setGarantias(Set<Garantia> garantias) {
        this.garantias = garantias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
