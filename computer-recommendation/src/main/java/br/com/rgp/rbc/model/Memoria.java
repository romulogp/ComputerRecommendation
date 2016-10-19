package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Memoria extends Dispositivo implements ISimilaridade<Memoria> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Double MAX_CLOCK = 5000.0;
	private static final Integer MAX_TAMANHO = 16;
	// Valores Mínimos
	private static final Double MIN_CLOCK = 166.0;
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
		pesoTamanho = 0.9;
	}
	
	public Memoria(String teste) {
		this();
		super.setMarca("Kingston");
		super.setModelo("Hyper X");
		this.clock = 2133.0;
		this.tamanho = 8;
	}

	@Override
	public Double similaridadeCom(Memoria obj) {
		Double similaridade = 0.0;
		
		similaridade += this.getClock() == null || obj.getClock() == null ? 0 :
				pesoClock * (1 - ((Math.abs(this.getClock() - obj.getClock())) / (double)(MAX_CLOCK - MIN_CLOCK)));
		similaridade += this.getTamanho() == null || obj.getTamanho() == null ? 0 :
				pesoTamanho * (1 - ((Math.abs(this.getTamanho() - obj.getTamanho())) / (double)(MAX_TAMANHO - MIN_TAMANHO)));
		
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
