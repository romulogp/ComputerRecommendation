package br.com.rgp.rbc.service;

import java.util.List;

import br.com.rgp.rbc.model.Configuracao;

public interface IConfiguracaoService {

	List<Configuracao> listAllConfigurations();
	
	void save(Configuracao configuracao);
	
}
