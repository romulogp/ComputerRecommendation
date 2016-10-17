package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PlacaDeVideo extends Dispositivo {

	private static final long serialVersionUID = 1L;

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

}
