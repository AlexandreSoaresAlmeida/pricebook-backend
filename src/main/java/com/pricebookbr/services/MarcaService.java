package com.pricebookbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.Marca;
import com.pricebookbr.dto.MarcaDTO;
import com.pricebookbr.repositories.MarcaRepository;
import com.pricebookbr.services.exceptions.DataIntegrityException;
import com.pricebookbr.services.exceptions.ObjectNotFoundException;

@Service
public class MarcaService {

		@Autowired
		private MarcaRepository repo;
		
		public Marca find(Integer id) {
			Optional <Marca> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Marca.class.getName()));
		}
		
		public Marca insert(Marca obj) {
			obj.setId(null);
			return repo.save(obj);
		}
		
		public Marca update(Marca obj) {
			Marca newObj = find(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
		}		
		
		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma marca que possui produtos");
			}
		}
		
		public List<Marca> findAll(){
			return repo.findAll();
		}
		
		public Page<Marca> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
					orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Marca fromDTO(MarcaDTO objDto) {
			return new Marca(objDto.getId(), objDto.getNome(), objDto.getDescricao());
		}
		
		private void updateData(Marca newObj, Marca obj) {
			newObj.setNome(obj.getNome());
			newObj.setDescricao(obj.getDescricao());
		}		
}