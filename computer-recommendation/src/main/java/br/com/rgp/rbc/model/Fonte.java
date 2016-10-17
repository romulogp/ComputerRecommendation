package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class Fonte extends Dispositivo {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer potencia;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer eficiencia;

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Integer getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(Integer eficiencia) {
		this.eficiencia = eficiencia;
	}

}