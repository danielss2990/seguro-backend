package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GarantiaDTO;
import com.devsuperior.dslist.services.GarantiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/garantias")
public class GarantiaController {

	@Autowired
	private GarantiaService garantiaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<GarantiaDTO> findById(@PathVariable Long id) {
		GarantiaDTO result = garantiaService.findById(id);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping
	public ResponseEntity<List<GarantiaDTO>> findAll() {
		List<GarantiaDTO> result = garantiaService.findAll();
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<GarantiaDTO> insert(@Valid @RequestBody GarantiaDTO dto){

		dto = garantiaService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<GarantiaDTO> update(@PathVariable Long id , @RequestBody GarantiaDTO dto){
		dto = garantiaService.update(id,dto);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<GarantiaDTO> delete(@PathVariable Long id){
		garantiaService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
