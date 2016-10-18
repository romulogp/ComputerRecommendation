package br.com.rgp.rbc.service;

import java.util.List;

import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.model.ConfiguracaoSimilaridade;

public interface IRecommendationService {

	List<ConfiguracaoSimilaridade> searchForRecommendedConfigurations(Configuracao c);
	
}
