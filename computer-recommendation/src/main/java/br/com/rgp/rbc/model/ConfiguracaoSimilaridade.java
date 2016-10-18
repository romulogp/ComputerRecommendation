package br.com.rgp.rbc.model;

public class ConfiguracaoSimilaridade {

	private Configuracao configuracao;
	private Double similaridade;

	public ConfiguracaoSimilaridade(Configuracao c, Double s) {
		this.configuracao = c;
		this.similaridade = s;
	}
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public Double getSimilaridade() {
		return similaridade;
	}

	public void setSimilaridade(Double similaridade) {
		this.similaridade = similaridade;
	}

}
