package com.pricebookbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.Configuracao;
import com.pricebookbr.dto.ConfiguracaoDTO;
import com.pricebookbr.repositories.ConfiguracaoRepository;
import com.pricebookbr.services.exceptions.DataIntegrityException;
import com.pricebookbr.services.exceptions.ObjectNotFoundException;

@Service
public class ConfiguracaoService {

		@Autowired
		private ConfiguracaoRepository repo;
		
		public Configuracao find(Integer id) {
			Optional <Configuracao> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Configuracao.class.getName()));
		}
		
		public Configuracao insert(Configuracao obj) {
			obj.setId(null);
			return repo.save(obj);
		}
		
		public Configuracao update(Configuracao obj) {
			Configuracao newObj = find(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
		}		
		
		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma configuração que possui produtos");
			}
		}
		
		public List<Configuracao> findAll(){
			return repo.findAll();
		}
		
		public Page<Configuracao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
					orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Configuracao fromDTO(ConfiguracaoDTO objDto) {
			return new Configuracao(objDto.getId(), objDto.getVersao(), objDto.getDtHoraHistorico());
		}
		
		private void updateData(Configuracao newObj, Configuracao obj) {
			newObj.setVersao(obj.getVersao());
			newObj.setDtHoraHistorico(obj.getDtHoraHistorico());
		}
		
		public List<Configuracao> findByLastVersion() {
			return repo.findByLastVersion();
		}
}