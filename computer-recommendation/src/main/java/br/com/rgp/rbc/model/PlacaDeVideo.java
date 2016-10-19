package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PlacaDeVideo extends Dispositivo implements ISimilaridade<PlacaDeVideo> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Integer MAX_NUCLEOS = 3584;
	private static final Double MAX_CLOCK_BASE = 1607.0;
	private static final Double MAX_CLOCK_MEMORIA = 10000.0;
	private static final Integer MAX_TAMANHO_MEMORIA = 16384;
	private static final Double MAX_CONSUMO = 250.0;
	private static final Integer MAX_BITS = 384;
	private static final Double MAX_LARGURA_BANDA = 512.0;
	private static final Double MAX_COMPRIMENTO = 50.0;
	private static final Double MAX_TEMP_MAXIMA = 130.0;
	// Valores Máximos
	private static final Integer MIN_NUCLEOS = 1;
	private static final Double MIN_CLOCK_BASE = 250.0;
	private static final Double MIN_CLOCK_MEMORIA = 166.0;
	private static final Integer MIN_TAMANHO_MEMORIA = 128;
	private static final Double MIN_CONSUMO = 0.0;
	private static final Integer MIN_BITS = 64;
	private static final Double MIN_LARGURA_BANDA = 2.6;
	private static final Double MIN_COMPRIMENTO = 10.0;
	private static final Double MIN_TEMP_MAXIMA = 10.0;

	// Pesos
	private Double pesoNucleos;
	private Double pesoClockBase;
	private Double pesoClockMemoria;
	private Double pesoTamanhoMemoria;
	private Double pesoConsumo;
	private Double pesoBits;
	private Double pesoLarguraBanda;
	private Double pesoComprimento;
	private Double pesoTempMaxima;

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

	public PlacaDeVideo() {
		pesoNucleos = 0.5;
		pesoClockBase = 0.2;
		pesoClockMemoria = 0.8;
		pesoTamanhoMemoria = 0.8;
		pesoConsumo = 0.1;
		pesoBits = 0.3;
		pesoLarguraBanda = 0.5;
		pesoComprimento = 0.8;
		pesoTempMaxima = 0.2;
	}
	
	public PlacaDeVideo(String teste) {
		this();
		super.setMarca("NVidia");
        super.setModelo("GTX 780 Ti");
        this.nucleos = 2280;
        this.clockBase = 876.0;
        this.clockMemoria = 7.0;
        this.tamanhoMemoria = 3072;
        this.consumo = 250.0;
        this.bits = 384;
        this.larguraBanda = 336.0;
        this.comprimento = 26.67;
        this.temperaturaMaxima = 95.0;
	}

	@Override
	public Double similaridadeCom(PlacaDeVideo obj) {
		Double similaridade = 0.0;

		similaridade += this.getNucleos() == null || obj.getNucleos() == null ? 0 :
				pesoNucleos * (1 - ((Math.abs(this.getNucleos() - obj.getNucleos())) / (double)(MAX_NUCLEOS - MIN_NUCLEOS)));
		similaridade += this.getClockBase() == null || obj.getClockBase() == null ? 0 :
				pesoClockBase * (1 - ((Math.abs(this.getClockBase() - obj.getClockBase())) / (double)(MAX_CLOCK_BASE - MIN_CLOCK_BASE)));
		similaridade += this.getClockMemoria() == null || obj.getClockMemoria() == null ? 0 :
				pesoClockMemoria * (1 - ((Math.abs(this.getClockMemoria() - obj.getClockMemoria())) / (double)(MAX_CLOCK_MEMORIA - MIN_CLOCK_MEMORIA)));
		similaridade += this.getTamanhoMemoria() == null || obj.getTamanhoMemoria() == null ? 0 :
				pesoTamanhoMemoria * (1 - ((Math.abs(this.getTamanhoMemoria() - obj.getTamanhoMemoria())) / (double)(MAX_TAMANHO_MEMORIA - MIN_TAMANHO_MEMORIA)));
		similaridade += this.getConsumo() == null || obj.getConsumo() == null ? 0 :
				pesoConsumo * (1 - ((Math.abs(this.getConsumo() - obj.getConsumo())) / (double)(MAX_CONSUMO - MIN_CONSUMO)));
		similaridade += this.getBits() == null || obj.getBits() == null ? 0 :
				pesoBits * (1 - ((Math.abs(this.getBits() - obj.getBits())) / (double)(MAX_BITS - MIN_BITS)));
		similaridade += this.getLarguraBanda() == null || obj.getLarguraBanda() == null ? 0 :
				pesoLarguraBanda * (1 - ((Math.abs(this.getLarguraBanda() - obj.getLarguraBanda())) / (double)(MAX_LARGURA_BANDA - MIN_LARGURA_BANDA)));
		similaridade += this.getComprimento() == null || obj.getComprimento() == null ? 0 :
				pesoComprimento * (1 - ((Math.abs(this.getComprimento() - obj.getComprimento())) / (double)(MAX_COMPRIMENTO - MIN_COMPRIMENTO)));
		similaridade += this.getTemperaturaMaxima() == null || obj.getTemperaturaMaxima() == null ? 0 :
				pesoTempMaxima * (1 - ((Math.abs(this.getTemperaturaMaxima() - obj.getTemperaturaMaxima())) / (double)(MAX_TEMP_MAXIMA - MIN_TEMP_MAXIMA)));

		return similaridade;
	}

	@Override
	public Double getSomatorioPesos() {
		return pesoNucleos
				+ pesoClockBase
				+ pesoClockMemoria 
				+ pesoTamanhoMemoria 
				+ pesoConsumo 
				+ pesoBits 
				+ pesoLarguraBanda 
				+ pesoComprimento 
				+ pesoTempMaxima;
	}
	
	public Double getPesoNucleos() {
		return pesoNucleos;
	}

	public void setPesoNucleos(Double pesoNucleos) {
		this.pesoNucleos = pesoNucleos;
	}

	public Double getPesoClockBase() {
		return pesoClockBase;
	}

	public void setPesoClockBase(Double pesoClockBase) {
		this.pesoClockBase = pesoClockBase;
	}

	public Double getPesoClockMemoria() {
		return pesoClockMemoria;
	}

	public void setPesoClockMemoria(Double pesoClockMemoria) {
		this.pesoClockMemoria = pesoClockMemoria;
	}

	public Double getPesoTamanhoMemoria() {
		return pesoTamanhoMemoria;
	}

	public void setPesoTamanhoMemoria(Double pesoTamanhoMemoria) {
		this.pesoTamanhoMemoria = pesoTamanhoMemoria;
	}

	public Double getPesoConsumo() {
		return pesoConsumo;
	}

	public void setPesoConsumo(Double pesoConsumo) {
		this.pesoConsumo = pesoConsumo;
	}

	public Double getPesoBits() {
		return pesoBits;
	}

	public void setPesoBits(Double pesoBits) {
		this.pesoBits = pesoBits;
	}

	public Double getPesoLarguraBanda() {
		return pesoLarguraBanda;
	}

	public void setPesoLarguraBanda(Double pesoLarguraBanda) {
		this.pesoLarguraBanda = pesoLarguraBanda;
	}

	public Double getPesoComprimento() {
		return pesoComprimento;
	}

	public void setPesoComprimento(Double pesoComprimento) {
		this.pesoComprimento = pesoComprimento;
	}

	public Double getPesoTempMaxima() {
		return pesoTempMaxima;
	}

	public void setPesoTempMaxima(Double pesoTempMaxima) {
		this.pesoTempMaxima = pesoTempMaxima;
	}

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
	
}
