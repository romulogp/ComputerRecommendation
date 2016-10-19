package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class Fonte extends Dispositivo implements ISimilaridade<Fonte> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Double MAX_POTENCIA = 1500.0;
	private static final Double MAX_EFICIENCIA = 100.0;
	// Valores Mínimos
	private static final Double MIN_POTENCIA = 10.0;
	private static final Double MIN_EFICIENCIA = 0.0;
	// Pesos
	private Double pesoPotencia;
	private Double pesoEficiencia;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer potencia;

	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer eficiencia;

	public Fonte() {
		pesoPotencia = 0.7;
		pesoEficiencia = 0.8;
	}
	
	public Fonte(String teste) {
		this();
		super.setMarca("Corsair");
        super.setModelo("CX 600 Modular");
        this.potencia = 600;
        this.eficiencia = 85;
	}

	@Override
	public Double similaridadeCom(Fonte obj) {
		Double similaridade = 0.0;

		similaridade += this.getEficiencia() == null || obj.getEficiencia() == null ? 0 :
				pesoEficiencia * (1 - ((Math.abs(this.getEficiencia() - obj.getEficiencia())) / (double)(MAX_EFICIENCIA - MIN_EFICIENCIA)));
		similaridade += this.getPotencia() == null || obj.getPotencia() == null ? 0 :
				pesoPotencia * (1 - ((Math.abs(this.getPotencia() - obj.getPotencia())) / (double)(MAX_POTENCIA - MIN_POTENCIA)));

		return similaridade;
	}

	@Override
	public Double getSomatorioPesos() {
		return pesoEficiencia + pesoPotencia;
	}

	public Double getPesoPotencia() {
		return pesoPotencia;
	}

	public void setPesoPotencia(Double pesoPotencia) {
		this.pesoPotencia = pesoPotencia;
	}

	public Double getPesoEficiencia() {
		return pesoEficiencia;
	}

	public void setPesoEficiencia(Double pesoEficiencia) {
		this.pesoEficiencia = pesoEficiencia;
	}
	
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