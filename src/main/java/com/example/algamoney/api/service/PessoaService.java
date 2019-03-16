package com.example.algamoney.api.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa salvar(Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = this.pessoaRepository.save(pessoa);
		this.publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		return pessoaSalva;
	}
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaRetornada = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaRetornada, "codigo");
		return this.pessoaRepository.save(pessoaRetornada);
	}	

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaRetornada = buscarPessoaPeloCodigo(codigo);
		pessoaRetornada.setAtivo(ativo);
		pessoaRepository.save(pessoaRetornada);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaRetornada = this.pessoaRepository.findOne(codigo);
		if(pessoaRetornada == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaRetornada;
	}
	
	public void remover(Long codigo) {
		this.pessoaRepository.delete(codigo);
	}
}
