package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.*;
import com.devsuperior.dslist.projections.VendaIDProjection;
import com.devsuperior.dslist.services.ProdutoService;
import com.devsuperior.dslist.services.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<VendaDTO> findById(@PathVariable Long id) {
		VendaDTO result = vendaService.findById(id);
		return ResponseEntity.ok().body(result);
	}

	/*
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll() {
		List<VendaDTO> result = vendaService.findAll();
		return ResponseEntity.ok(result);
	}*/

	/*@GetMapping(value = "/games")
	public List<VendaProjecaoDTO> findGames() {
		List<VendaProjecaoDTO> result = vendaService.findByGameList();
		return result;
	}*/

	@GetMapping
	public Map<Long, List<VendaProjecaoDTO>> findGames() {
		Map<Long, List<VendaProjecaoDTO>> result = vendaService.findByGameList();
		return result;
	}

	/*
	@GetMapping(value = "/inserir")
	public VendaIDProjection inserirVenda() {
		VendaIDProjection result = vendaService.insertVendaID();
		return result;
	}*/

	/*@GetMapping(value = "/belong")
	public void inserirBelongVenda(@RequestBody InsertVendaDTO dto) {
		//vendaService.insertBelongVenda(dto);
	}*/

	@PostMapping(value = "/inserir")
	public ResponseEntity<VendaProjecaoCadastroDTO> inserirBelongVenda(@RequestBody ListInsertVendaDTO dto) {
		//vendaService.insertBelongVenda(dto);



		List<InsertVendaDTO> itens = dto.getListaItens();

		vendaService.insertTBVenda();

		VendaIDProjection idDaVenda = vendaService.insertVendaID();



		for (InsertVendaDTO item: itens) {

			item.setVendaID(idDaVenda.getId());

			System.out.println("*******************");
			System.out.println(item.getVendaID());
			System.out.println(item.getProdutoID());
			System.out.println(item.getQuantidade());
			System.out.println("*******************");

			vendaService.insertBelongVenda(item);
			vendaService.insertProdutoVenda(item);
		}


		VendaProjecaoCadastroDTO venda = new VendaProjecaoCadastroDTO();
		venda.setVendaID(idDaVenda.getId());
		venda.setItensVendidos(itens);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/inserir").buildAndExpand(idDaVenda.getId()).toUri();



		return ResponseEntity.created(uri).body(venda);

	}

	@DeleteMapping(value = "deletar/{id}")
	public void delete(@PathVariable Long id){
		vendaService.deleteBelongVenda(id);
	}

	/*
	@PostMapping
	public ResponseEntity<VendaDTO> insert(@Valid @RequestBody VendaDTO dto){
		dto = vendaService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<VendaDTO> update(@PathVariable Long id , @RequestBody VendaDTO dto){
		dto = vendaService.update(id,dto);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<VendaDTO> delete(@PathVariable Long id){
		vendaService.delete(id);
		return ResponseEntity.noContent().build();

	}
*/
}
