package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
public class CPU extends Dispositivo implements ISimilaridade<CPU> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Integer MAX_NUCLEOS = 32;
	private static final Double MAX_CLOCK = 10.0;
	private static final Integer MAX_CACHE = 60;
	private static final Integer MAX_TDP = 200;
	// Valores Mínimos
	private static final Integer MIN_NUCLEOS = 1;
	private static final Double MIN_CLOCK = 1.0;
	private static final Integer MIN_CACHE = 1;
	private static final Integer MIN_TDP = 50;

	// Pesos
	private Double pesoNucleos;
	private Double pesoClock;
	private Double pesoCache;
	private Double pesoTdp;

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

	public CPU() {
		pesoNucleos = 0.8;
		pesoClock = 0.8;
		pesoCache = 0.6;
		pesoTdp = 0.1;
		
		super.setMarca("Intel");
        super.setModelo("Core I7 4790K");
        this.nucleos = 8;
        this.clock = 4.0;
        this.cache = 8;
        this.tdp = 88;
	}

	@Override
	public Double similaridadeCom(CPU obj) {
		Double similaridade = 0.0;
		
		similaridade += this.getNucleos() == null || obj.getNucleos() == null ? 0 :
				pesoNucleos * (1 - ((Math.abs(this.getNucleos() - obj.getNucleos())) / (double)(MAX_NUCLEOS - MIN_NUCLEOS)));
		similaridade += this.getClock() == null || obj.getClock() == null ? 0 :
				pesoClock * (1 - ((Math.abs(this.getClock() - obj.getClock())) / (double)(MAX_CLOCK - MIN_CLOCK)));
		similaridade += this.getCache() == null || obj.getCache() == null ? 0 :
				pesoCache * (1 - ((Math.abs(this.getCache() - obj.getCache())) / (double)(MAX_CACHE - MIN_CACHE)));
		similaridade += this.getPesoTdp() == null || obj.getTdp() == null ? 0 :
				pesoTdp * (1 - ((Math.abs(this.getTdp() - obj.getTdp())) / (double)(MAX_TDP - MIN_TDP)));

		return similaridade;
	}

	@Override
	public Double getSomatorioPesos() {
		return pesoNucleos + pesoClock + pesoCache + pesoTdp;
	}
	
	
	public Double getPesoNucleos() {
		return pesoNucleos;
	}

	public void setPesoNucleos(Double pesoNucleos) {
		this.pesoNucleos = pesoNucleos;
	}

	public Double getPesoClock() {
		return pesoClock;
	}

	public void setPesoClock(Double pesoClock) {
		this.pesoClock = pesoClock;
	}

	public Double getPesoCache() {
		return pesoCache;
	}

	public void setPesoCache(Double pesoCache) {
		this.pesoCache = pesoCache;
	}

	public Double getPesoTdp() {
		return pesoTdp;
	}

	public void setPesoTdp(Double pesoTdp) {
		this.pesoTdp = pesoTdp;
	}

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