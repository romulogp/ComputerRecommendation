package br.com.rgp.rbc.core;

import java.util.ArrayList;
import java.util.List;

import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.model.ConfiguracaoSimilaridade;

public class RecommendationCore {

	public List<ConfiguracaoSimilaridade> avaliarSimilaridades(Configuracao c, List<Configuracao> database) {
		List<ConfiguracaoSimilaridade> searchResult = new ArrayList<>();
		
		for (Configuracao dbConf : database) {
			searchResult.add(new ConfiguracaoSimilaridade(dbConf, c.similaridadeCom(dbConf)));
		}
		
		// Lambda para ordenar a lista de forma DECRESCENTE
		searchResult.sort((o1, o2) -> {
			if (o1.getSimilaridade() > o2.getSimilaridade()) {
				return -1;
			} else if (o1.getSimilaridade() < o2.getSimilaridade()) {
				return 1;
			}
			return 0;
		});
		
		return searchResult;
	}
	
}
