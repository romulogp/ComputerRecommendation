package br.com.rgp.rbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rgp.rbc.core.RecommendationCore;
import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.model.ConfiguracaoSimilaridade;

public class RecommendationService implements IRecommendationService {

	@Autowired
	private ConfiguracaoService configService;
	
	@Override
	public List<ConfiguracaoSimilaridade> searchForRecommendedConfigurations(Configuracao c) {
		RecommendationCore core = new RecommendationCore();
		
		List<Configuracao> database = configService.listAllConfigurations();
		
		return core.avaliarSimilaridades(c, database);
	}

}
