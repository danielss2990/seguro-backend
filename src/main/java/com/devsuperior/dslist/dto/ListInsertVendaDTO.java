package com.devsuperior.dslist.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListInsertVendaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    List<InsertVendaDTO> listaItens = new ArrayList<>();
    public ListInsertVendaDTO() {

    }

    public List<InsertVendaDTO> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<InsertVendaDTO> listaItens) {
        this.listaItens = listaItens;
    }
}


