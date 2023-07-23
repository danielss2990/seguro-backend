package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GarantiaDTO;
import com.devsuperior.dslist.dto.ProdutoDTO;
import com.devsuperior.dslist.entities.Garantia;
import com.devsuperior.dslist.entities.Produto;
import com.devsuperior.dslist.repositories.GarantiaRepository;
import com.devsuperior.dslist.repositories.ProdutoRepository;
import com.devsuperior.dslist.services.exceptions.DatabaseException;
import com.devsuperior.dslist.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private GarantiaRepository garantiaRepository;

	/*
	@Transactional(readOnly = true)
	public ProdutoDTO findById(@PathVariable Long listId) {
		Produto result = produtoRepository.findById(listId).get();
		return new ProdutoDTO(result);
	}*/

	@Transactional(readOnly = true)
	public ProdutoDTO findById(@PathVariable Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		Produto entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		return new ProdutoDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll() {
		List<Produto> result = produtoRepository.findAll();
		return result.stream().map(ProdutoDTO::new).toList();
	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {

		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		entity.setValor(dto.getValor());
		entity.setEstoqueMinimo(dto.getEstoqueMinimo());
		entity.setEstoqueMaximo(dto.getEstoqueMaximo());
		entity.setSaldoEstoque(dto.getSaldoEstoque());
		entity.setFornecedor(dto.getFornecedor());
		entity.setGarantia(dto.getGarantia());

		entity.getGarantias().clear();

		for(GarantiaDTO garantiaDto: dto.getGarantias()) {
			//Garantia garantia = garantiaRepository.getOne(garantiaDto.getId());
			Optional<Garantia> optionalGarantia = garantiaRepository.findById(garantiaDto.getId());
			if (optionalGarantia.isPresent()){
				Garantia gar = optionalGarantia.get();
				entity.getGarantias().add(gar);
			}
		}

		Produto consultaBD = produtoRepository.findByNome(entity.getNome());
		if (consultaBD == null){
			entity = produtoRepository.save(entity);
			return new ProdutoDTO(entity);
		}
		throw new DatabaseException("The nome is already used: " + consultaBD.getNome());

	}

	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		try {
			Optional<Produto> optionalProduto = produtoRepository.findById(id);

			if (optionalProduto.isPresent()){
				Produto entity = optionalProduto.get();
				copyDtoToEntity(dto, entity);

				entity.getGarantias().clear();

				for(GarantiaDTO garantiaDto: dto.getGarantias()) {
					//Garantia garantia = garantiaRepository.getOne(garantiaDto.getId());
					Optional<Garantia> optionalGarantia = garantiaRepository.findById(garantiaDto.getId());
					if (optionalGarantia.isPresent()){
						Garantia gar = optionalGarantia.get();
						entity.getGarantias().add(gar);
					}
				}

				entity = produtoRepository.save(entity);

				return new ProdutoDTO(entity);
			}else {
				throw new ResourceNotFoundException("Produto not found with ID: " + id);
			}

		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	/*
	public void delete(Long id) {

		try {
			produtoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found" + id );
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}*/

	public void delete(Long id) {

		try {
			Optional<Produto> optionalProduto = produtoRepository.findById(id);

			if (optionalProduto.isPresent()){
				Produto entity = optionalProduto.get();
				produtoRepository.deleteById(id);
			}else {
				throw new ResourceNotFoundException("Produto not found with ID: " + id);
			}

		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
		entity.setNome(dto.getNome());
		entity.setValor(dto.getValor());
		entity.setEstoqueMinimo(dto.getEstoqueMinimo());
		entity.setEstoqueMaximo(dto.getEstoqueMaximo());
		entity.setSaldoEstoque(dto.getSaldoEstoque());
		entity.setFornecedor(dto.getFornecedor());
		entity.setGarantia(dto.getGarantia());
	}



	/*
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}*/
}
