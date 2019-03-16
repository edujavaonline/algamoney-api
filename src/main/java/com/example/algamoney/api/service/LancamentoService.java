package com.example.algamoney.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.repository.filter.LancamentoFilter;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInvativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return this.lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoaRetornada = this.pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if(pessoaRetornada == null || !pessoaRetornada.getAtivo()) {
			throw new PessoaInexistenteOuInvativaException();
		}
		return this.lancamentoRepository.save(lancamento);
	}
	
	public Lancamento buscarLancamentoPeloCodigo(Long codigo) {
		Lancamento lancamentoRetornado = this.lancamentoRepository.findOne(codigo);
		if(lancamentoRetornado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamentoRetornado;
	}
	
	public void excluir(Long codigo) {		
		this.lancamentoRepository.delete(codigo);
	}
}
