package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.*;
import com.devsuperior.dslist.entities.Venda;
import com.devsuperior.dslist.projections.VendaIDProjection;
import com.devsuperior.dslist.projections.VendaProjection;
import com.devsuperior.dslist.repositories.ProdutoRepository;
import com.devsuperior.dslist.repositories.VendaRepository;
import com.devsuperior.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;


	@Transactional(readOnly = true)
	public VendaDTO findById(@PathVariable Long id) {
		Optional<Venda> obj = vendaRepository.findById(id);
		Venda entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		return new VendaDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<VendaDTO> findAll() {
		List<Venda> result = vendaRepository.findAll();

		List<VendaDTO> list = result.stream().map(VendaDTO::new).toList();

		return result.stream().map(VendaDTO::new).toList();
	}

	/*@Transactional(readOnly = true)
	public List<VendaProjecaoDTO> findByGameList() {
		List<VendaProjection> games = vendaRepository.searchByList();
		return games.stream().map(VendaProjecaoDTO::new).toList();
	}*/
	@Transactional(readOnly = true)
	public Map<Long, List<VendaProjecaoDTO>> findByGameList() {
		List<VendaProjection> games = vendaRepository.searchByList();

		List<VendaProjecaoDTO> lista = games.stream().map(VendaProjecaoDTO::new).toList();

		for (VendaProjecaoDTO produto : lista){
			ProdutoDTO produtoGarantia = produtoService.findById(produto.getId());
			produto.setGarantias(produtoGarantia.getGarantias());
		}


		Map<Long, List<VendaProjecaoDTO>> mapaVendas = new HashMap<>();

		for(VendaProjecaoDTO item : lista){
			Long venda = item.getVenda();
			// Verifica se a venda já existe no mapa
			if (mapaVendas.containsKey(venda)) {
				// Se já existe, adiciona o item à lista correspondente
				mapaVendas.get(venda).add(item);
			} else {
				// Se não existe, cria uma nova lista com o item e adiciona ao mapa
				List<VendaProjecaoDTO> novaLista = new ArrayList<>();
				novaLista.add(item);
				mapaVendas.put(venda, novaLista);
			}
		}

		for (Map.Entry<Long, List<VendaProjecaoDTO>> entry : mapaVendas.entrySet()) {
			Long venda = entry.getKey();
			List<VendaProjecaoDTO> listaPorVenda = entry.getValue();

			double valorTotalVenda = 0.0;
			for (VendaProjecaoDTO item : listaPorVenda) {
				valorTotalVenda += item.getTotal();
			}

			// Atualiza o valor total para cada item da venda
			for (VendaProjecaoDTO item : listaPorVenda) {
				item.setValorTotalVenda(valorTotalVenda);
			}
		}




		/*
		// Calcula e imprime o valor total de cada venda
		for (Map.Entry<Long, List<VendaProjecaoDTO>> entry : mapaVendas.entrySet()) {
			Long venda = entry.getKey();
			List<VendaProjecaoDTO> listaPorVenda = entry.getValue();

			double valorTotalVenda = 0.0;
			for (VendaProjecaoDTO item : listaPorVenda) {
				valorTotalVenda += item.getTotal();
			}

			System.out.println("Venda " + venda + " - Valor Total: " + valorTotalVenda);
		}*/




		return mapaVendas;
	}

	@Transactional(readOnly = true)
	public VendaIDProjection insertVendaID() {
		VendaIDProjection id = vendaRepository.insertVendaID();
		return  id;
	}

	@Transactional(readOnly = true)
	public void insertBelongVenda(InsertVendaDTO dto) {
		vendaRepository.insertBelongVenda(dto.getQuantidade(), dto.getProdutoID(), dto.getVendaID());
	}

	@Transactional(readOnly = true)
	public void insertProdutoVenda(InsertVendaDTO dto) {
		vendaRepository.insertProdutoVenda(dto.getProdutoID(), dto.getVendaID());
	}

	@Transactional(readOnly = true)
	public void insertTBVenda() {
		vendaRepository.insertTBVenda();
	}


	@Transactional(readOnly = true)
	public void deleteBelongVenda(Long vendaID) {
		vendaRepository.deleteBelongVenda(vendaID);
		vendaRepository.deleteProdutoVenda(vendaID);
		vendaRepository.deleteVenda(vendaID);
	}


	private void copyDtoToEntity(VendaDTO dto, Venda entity) {

	}





}
