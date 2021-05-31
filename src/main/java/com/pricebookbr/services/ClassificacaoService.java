package com.pricebookbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.Classificacao;
import com.pricebookbr.dto.ClassificacaoDTO;
import com.pricebookbr.repositories.ClassificacaoRepository;
import com.pricebookbr.services.exceptions.DataIntegrityException;
import com.pricebookbr.services.exceptions.ObjectNotFoundException;

@Service
public class ClassificacaoService {

		@Autowired
		private ClassificacaoRepository repo;
		
		public Classificacao find(Integer id) {
			Optional <Classificacao> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Classificacao.class.getName()));
		}
		
		public Classificacao insert(Classificacao obj) {
			obj.setId(null);
			return repo.save(obj);
		}
		
		public Classificacao update(Classificacao obj) {
			Classificacao newObj = find(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
		}		
		
		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma classificacao que possui produtos");
			}
		}
		
		public List<Classificacao> findAll(){
			return repo.findAll();
		}
		
		public Page<Classificacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
					orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Classificacao fromDTO(ClassificacaoDTO objDto) {
			return new Classificacao(objDto.getId(), objDto.getNome(), objDto.getDescricao());
		}
		
		private void updateData(Classificacao newObj, Classificacao obj) {
			newObj.setNome(obj.getNome());
			newObj.setDescricao(obj.getDescricao());
		}		
}