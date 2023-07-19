package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entities.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping(value = "/transferencia")
public class TransferenciaController {
	
	@Autowired
	TransferenciaRepository repository;
	
    @GetMapping
    public List<Transferencia> listar(String dataInicio, String dataFim, String nomeUsuario) {
    	List<Transferencia> transferencias = null;
    	
    	if(dataInicio == null && dataFim == null  && nomeUsuario == null ) {
    		transferencias = repository.findAll();
    	}
    	
    	if(dataInicio == null && dataFim == null  && nomeUsuario != null) {
    		transferencias = repository.findByNomeOperadorTransacao(nomeUsuario);
    	}
    	
    	if(dataInicio != null && dataFim == null  && nomeUsuario == null) {
    		transferencias = repository.findByDataInicio(dataInicio);
    	}
    
    	if(dataInicio == null && dataFim != null  && nomeUsuario == null) {
    		transferencias = repository.findByDataFim(dataFim);
    	}
    	    	
    	if(dataInicio != null && dataFim != null  && nomeUsuario == null) {
    		transferencias = repository.findByDataInicioFim(dataInicio, dataFim);
    	}
    	
    	if(dataInicio != null && dataFim != null  && nomeUsuario != null) {
    		transferencias = repository.findByDataInicioFimUsuario(dataInicio, dataFim, nomeUsuario);
    	}
    	
    	if(dataInicio == null && dataFim != null  && nomeUsuario != null) {
    		transferencias = repository.findByDataFimUsuario(dataFim, nomeUsuario);
    	}
    	
    	if(dataInicio != null && dataFim == null  && nomeUsuario != null) {
    		transferencias = repository.findByDataInicioUsuario(dataInicio, nomeUsuario);
    	}
    	
       	return transferencias;
    }
}
