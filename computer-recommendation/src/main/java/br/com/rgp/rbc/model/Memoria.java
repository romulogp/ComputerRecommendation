package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Memoria extends Dispositivo implements ISimilaridade<Memoria> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Double MAX_CLOCK = 5133.0;
	private static final Integer MAX_TAMANHO = 64;
	// Valores Mínimos
	private static final Double MIN_CLOCK = 1.0;
	private static final Integer MIN_TAMANHO = 1;

	// Pesos
	private Double pesoClock;
	private Double pesoTamanho;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double clock;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer tamanho;

	public Memoria() {
		pesoClock = 0.3;
		pesoTamanho = 0.5;
	}

	@Override
	public Double similaridadeCom(Memoria obj) {
		Double similaridade = 0.0;
		
		similaridade += pesoClock
				* (1 - ((Math.abs(this.getClock() - obj.getClock())) / (MAX_CLOCK - MIN_CLOCK)));
		similaridade += pesoTamanho
				* (1 - ((Math.abs(this.getTamanho() - obj.getTamanho())) / (MAX_TAMANHO - MIN_TAMANHO)));
		
		return similaridade;
	}

	@Override
	public Double getSomatorioPesos() {
		return pesoClock + pesoTamanho;
	}

	
	public Double getPesoClock() {
		return pesoClock;
	}

	public void setPesoClock(Double pesoClock) {
		this.pesoClock = pesoClock;
	}

	public Double getPesoTamanho() {
		return pesoTamanho;
	}

	public void setPesoTamanho(Double pesoTamanho) {
		this.pesoTamanho = pesoTamanho;
	}

	public Double getClock() {
		return clock;
	}

	public void setClock(Double clock) {
		this.clock = clock;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	
}
