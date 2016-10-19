package br.com.rgp.rbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rgp.rbc.core.RecommendationCore;
import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.model.ConfiguracaoSimilaridade;

@Service
public class RecommendationService implements IRecommendationService {

	@Autowired
	private IConfiguracaoService configService;
	
	@Override
	public List<ConfiguracaoSimilaridade> searchForRecommendedConfigurations(Configuracao c) {
		RecommendationCore core = new RecommendationCore();
		
//		configService = new ConfiguracaoService();
		List<Configuracao> database = configService.listAllConfigurations();
		
		return core.avaliarSimilaridades(c, database);
	}

}
