package br.com.rgp.rbc.core;

import java.util.ArrayList;
import java.util.List;

import br.com.rgp.rbc.model.Configuracao;
import br.com.rgp.rbc.model.ConfiguracaoSimilaridade;

public class RecommendationCore {

	public Double avaliarSimilidaridade(Configuracao c1, Configuracao c2) {
		return null;
	}

	public List<ConfiguracaoSimilaridade> avaliarSimilaridades(Configuracao c, List<Configuracao> database) {
		List<ConfiguracaoSimilaridade> searchResult = new ArrayList<>();
		
		for (Configuracao dbConf : database) {
			searchResult.add(new ConfiguracaoSimilaridade(dbConf, avaliarSimilidaridade(c, dbConf)));
		}
		return searchResult;
	}
	
}
