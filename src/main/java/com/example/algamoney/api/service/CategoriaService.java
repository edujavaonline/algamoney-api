package com.example.algamoney.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar() {
		return this.categoriaRepository.findAll();
	}
	
	public Categoria salvar(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
	public Categoria buscarCategoriaPeloCodigo(Long codigo) {
		Categoria categoriaRetornada = this.categoriaRepository.findOne(codigo);
		if(categoriaRetornada == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaRetornada;
	}
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaRetornada = this.buscarCategoriaPeloCodigo(codigo);
		BeanUtils.copyProperties(categoria, categoriaRetornada, "codigo");
		return this.categoriaRepository.save(categoriaRetornada);		
	}
}
