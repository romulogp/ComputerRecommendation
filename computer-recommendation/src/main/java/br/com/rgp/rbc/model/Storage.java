package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Storage extends Dispositivo implements ISimilaridade<Storage> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Integer MAX_CAPACIDADE = 4000;
	private static final Integer MAX_VELOCIDADE = 1000;
	// Valores Mínimos
	private static final Integer MIN_CAPACIDADE = 40;
	private static final Integer MIN_VELOCIDADE = 1;
	// Pesos
	private Double pesoCapacidade;
	private Double pesoVelocidade;
	
	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer capacidade;

	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
	private Double velocidade;

	public Storage() {
		pesoCapacidade = 0.5;
		pesoVelocidade = 0.8;
	}

	public Storage(String teste) {
		this();
		super.setMarca("Samsung");
        super.setModelo("850V EVO");
        this.capacidade = 4000;
        this.velocidade = 160.0;
	}
	
	@Override
	public Double similaridadeCom(Storage obj) {
		Double similaridade = 0.0;
		
		similaridade += this.getCapacidade() == null || obj.getCapacidade() == null ? 0 :
				pesoCapacidade * (1 - ((Math.abs(this.getCapacidade() - obj.getCapacidade())) / (double)(MAX_CAPACIDADE - MIN_CAPACIDADE)));
		similaridade += this.getVelocidade() == null || obj.getCapacidade() == null ? 0 : 
				pesoVelocidade * (1 - ((Math.abs(this.getVelocidade() - obj.getVelocidade())) / (double)(MAX_VELOCIDADE - MIN_VELOCIDADE)));

		return similaridade;
	}

	@Override
	public Double getSomatorioPesos() {
		return pesoCapacidade + pesoVelocidade;
	}

	public Double getPesoCapacidade() {
		return pesoCapacidade;
	}

	public void setPesoCapacidade(Double pesoCapacidade) {
		this.pesoCapacidade = pesoCapacidade;
	}

	public Double getPesoVelocidade() {
		return pesoVelocidade;
	}

	public void setPesoVelocidade(Double pesoVelocidade) {
		this.pesoVelocidade = pesoVelocidade;
	}
	
	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

}
