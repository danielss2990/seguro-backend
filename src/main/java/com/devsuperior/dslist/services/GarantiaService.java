package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GarantiaDTO;
import com.devsuperior.dslist.entities.Garantia;
import com.devsuperior.dslist.repositories.GarantiaRepository;
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
public class GarantiaService {

	@Autowired
	private GarantiaRepository garantiaRepository;

	@Transactional(readOnly = true)
	public GarantiaDTO findById(@PathVariable Long id) {
		Optional<Garantia> obj = garantiaRepository.findById(id);
		Garantia entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		return new GarantiaDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<GarantiaDTO> findAll() {
		List<Garantia> result = garantiaRepository.findAll();
		return result.stream().map(GarantiaDTO::new).toList();
	}

	@Transactional
	public GarantiaDTO insert(GarantiaDTO dto) {

		Garantia entity = new Garantia();
		entity.setNome(dto.getNome());
		entity.setValor(dto.getValor());
		entity.setPrazo(dto.getPrazo());

		Garantia consultaBD = garantiaRepository.findByNome(entity.getNome());
		if (consultaBD == null){
			entity = garantiaRepository.save(entity);
			return new GarantiaDTO(entity);
		}
		throw new DatabaseException("The nome is already used: " + consultaBD.getNome());
	}

	@Transactional
	public GarantiaDTO update(Long id, GarantiaDTO dto) {
		try {
			Optional<Garantia> optionalGarantia = garantiaRepository.findById(id);

			if (optionalGarantia.isPresent()){
				Garantia entity = optionalGarantia.get();
				copyDtoToEntity(dto, entity);

				entity = garantiaRepository.save(entity);

				return new GarantiaDTO(entity);
			}else {
				throw new ResourceNotFoundException("Garantia not found with ID: " + id);
			}

		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	public void delete(Long id) {

		try {
			Optional<Garantia> optionalGarantia = garantiaRepository.findById(id);

			if (optionalGarantia.isPresent()){
				Garantia entity = optionalGarantia.get();
				garantiaRepository.deleteById(id);
			}else {
				throw new ResourceNotFoundException("Garantia not found with ID: " + id);
			}

		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	private void copyDtoToEntity(GarantiaDTO dto, Garantia entity) {
		entity.setNome(dto.getNome());
		entity.setValor(dto.getValor());
		entity.setPrazo(dto.getPrazo());
	}
}
