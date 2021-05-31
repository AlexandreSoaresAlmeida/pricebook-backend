package com.pricebookbr.services.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricebookbr.repositories.dashboard.CategoriaClienteVipRepository;

@Service
public class CategoriaClienteVipService {
	@Autowired
	private CategoriaClienteVipRepository repo;

	public List<Object[]> categoriaClienteVip(Integer cliente_id) {
		return repo.categoriaClienteVip(cliente_id);
	}
}