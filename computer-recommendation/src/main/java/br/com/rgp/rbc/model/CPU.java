package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
public class CPU extends Dispositivo {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer nucleos;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double clock;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer cache;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer tdp;

	public Integer getNucleos() {
		return nucleos;
	}

	public void setNucleos(Integer nucleos) {
		this.nucleos = nucleos;
	}

	public Double getClock() {
		return clock;
	}

	public void setClock(Double clock) {
		this.clock = clock;
	}

	public Integer getCache() {
		return cache;
	}

	public void setCache(Integer cache) {
		this.cache = cache;
	}

	public Integer getTdp() {
		return tdp;
	}

	public void setTdp(Integer tdp) {
		this.tdp = tdp;
	}

}