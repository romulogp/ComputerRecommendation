package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PlacaDeVideo extends Dispositivo implements ISimilaridade<PlacaDeVideo> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Integer MAX_NUCLEOS = 8;
	private static final Double MAX_CLOCK_BASE = 2000.0;
	private static final Double MAX_CLOCK_MEMORIA = 10.0;
	private static final Integer MAX_TAMANHO_MEMORIA = 64;
	private static final Double MAX_CONSUMO = 250.0;
	private static final Integer MAX_BITS = 364;
	private static final Double MAX_LARGURA_BANDA = 600.0;
	private static final Double MAX_COMPRIMENTO = 40.0;
	private static final Double MAX_TEMP_MAXIMA = 130.0;

	// Pesos
	private static final Double PESO_NUCLEOS = 0.7;
	private static final Double PESO_CLOCK_BASE = 0.3;
	private static final Double PESO_CLOCK_MEMORIA = 0.5;
	private static final Double PESO_TAMANHO_MEMORIA = 0.5;
	private static final Double PESO_CONSUMO = 0.1;
	private static final Double PESO_BITS = 0.1;
	private static final Double PESO_LARGURA_BANDA = 0.3;
	private static final Double PESO_COMPRIMENTO = 0.7;
	private static final Double PESO_TEMP_MAXIMA = 0.3;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer nucleos;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double clockBase;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double clockMemoria;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer tamanhoMemoria;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 4, fraction = 2)
	private Double consumo;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer bits;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double larguraBanda;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double comprimento;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double temperaturaMaxima;

	public Integer getNucleos() {
		return nucleos;
	}

	public void setNucleos(Integer nucleos) {
		this.nucleos = nucleos;
	}

	public Double getClockBase() {
		return clockBase;
	}

	public void setClockBase(Double clockBase) {
		this.clockBase = clockBase;
	}

	public Double getClockMemoria() {
		return clockMemoria;
	}

	public void setClockMemoria(Double clockMemoria) {
		this.clockMemoria = clockMemoria;
	}

	public Integer getTamanhoMemoria() {
		return tamanhoMemoria;
	}

	public void setTamanhoMemoria(Integer tamanhoMemoria) {
		this.tamanhoMemoria = tamanhoMemoria;
	}

	public Double getConsumo() {
		return consumo;
	}

	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}

	public Integer getBits() {
		return bits;
	}

	public void setBits(Integer bits) {
		this.bits = bits;
	}

	public Double getLarguraBanda() {
		return larguraBanda;
	}

	public void setLarguraBanda(Double larguraBanda) {
		this.larguraBanda = larguraBanda;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	@Override
	public Double similaridadeCom(PlacaDeVideo placaDeVideo) {
		Double similaridade = 0.0;
		similaridade += (PESO_BITS * (Math.abs(placaDeVideo.getBits() - this.getBits())));

		return normalizarSimilaridade(similaridade);
	}

	private Double normalizarSimilaridade(Double valorOriginal) {
		Double somatorioPesos = PESO_BITS + PESO_CLOCK_BASE + PESO_CLOCK_MEMORIA + PESO_COMPRIMENTO + PESO_CONSUMO + PESO_LARGURA_BANDA
				+ PESO_NUCLEOS + PESO_TAMANHO_MEMORIA + PESO_TEMP_MAXIMA;
		return valorOriginal / somatorioPesos;
	}

}
