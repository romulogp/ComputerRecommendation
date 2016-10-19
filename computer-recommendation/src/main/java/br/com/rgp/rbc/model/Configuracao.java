package br.com.rgp.rbc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.Gson;

@Entity
public class Configuracao implements ISimilaridade<Configuracao> {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpu_id")
	private CPU cpu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fonte_id")
	private Fonte fonte;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ram_id")
	private Memoria ram;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "placa_de_video_id")
	private PlacaDeVideo placaDeVideo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "placa_mae_id")
	private PlacaMae placaMae;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storage_id")
	private Storage storage;

	public Configuracao() {

	}
	
	/**
	 * Configuração de teste
	 */
	public Configuracao(String teste) {
		this.cpu = new CPU(teste);
		this.fonte = new Fonte(teste);
		this.ram = new Memoria(teste);
		this.placaDeVideo = new PlacaDeVideo(teste);
		this.placaMae = new PlacaMae(teste);
		this.storage = new Storage(teste);
	}

	@Override
	public Double similaridadeCom(Configuracao configuracao) {
		Double somatorioSimilaridades = 0.0;

		somatorioSimilaridades += this.getCpu().similaridadeCom(configuracao.getCpu());
		somatorioSimilaridades += this.getFonte().similaridadeCom(configuracao.getFonte());
		somatorioSimilaridades += this.getPlacaDeVideo().similaridadeCom(configuracao.getPlacaDeVideo());
		somatorioSimilaridades += this.getRam().similaridadeCom(configuracao.getRam());
		somatorioSimilaridades += this.getStorage().similaridadeCom(configuracao.getStorage());

		double smNormalizada = normalizarSimilaridade(somatorioSimilaridades, getSomatorioPesos());
		
		return smNormalizada > 0 ? smNormalizada : 0;
	}

	@Override
	public Double getSomatorioPesos() {
		return cpu.getSomatorioPesos() + fonte.getSomatorioPesos()
				+ ram.getSomatorioPesos() + placaDeVideo.getSomatorioPesos() 
				+ storage.getSomatorioPesos();
	}

	private Double normalizarSimilaridade(Double valorOriginal, Double somatorioPesos) {
		return valorOriginal / somatorioPesos;
	}

	public static void main(String[] args) {
		Configuracao c1 = new Configuracao("teste");

		Configuracao c2 = new Configuracao("teste");
		c2.getCpu().setClock(1.0);
		c2.getCpu().setCache(16);

		System.out.println(c1.similaridadeCom(c2));
	}

	@Override
	public String toString() {
		Gson converter = new Gson();
		return converter.toJson(this);
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

	public Memoria getRam() {
		return ram;
	}

	public void setRam(Memoria ram) {
		this.ram = ram;
	}

	public PlacaDeVideo getPlacaDeVideo() {
		return placaDeVideo;
	}

	public void setPlacaDeVideo(PlacaDeVideo placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}

	public PlacaMae getPlacaMae() {
		return placaMae;
	}

	public void setPlacaMae(PlacaMae placaMae) {
		this.placaMae = placaMae;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
