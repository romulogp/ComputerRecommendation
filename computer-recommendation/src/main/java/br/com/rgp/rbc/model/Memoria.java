package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Memoria extends Dispositivo {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double clock;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer tamanho;

	/**
	 * Cria uma memoria padrão para fins de testes.
	 */
	public Memoria() {
		super.setMarca("Kingston");
		super.setModelo("Hyper X");
		this.clock = 2133.0;
		this.tamanho = 8;
	}

	public Memoria(String marca, String modelo, Double clock, Integer tamanho) {
		super.setMarca(marca);
		super.setModelo(modelo);
		this.clock = clock;
		this.tamanho = tamanho;
	}

	public double getClock() {
		return clock;
	}

	public void setClock(Double clock) {
		this.clock = clock;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

}
