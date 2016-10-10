package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Storage extends Dispositivo {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	@NotNull
	@DecimalMin(value = "0")
	private Integer capacidade;
	
	@Column(nullable = false)
	@NotNull
	@Digits(integer = 5, fraction = 2)
    private Double velocidade;

    public Storage() {
        super.setMarca("Samsung");
        super.setModelo("850V EVO");
    }

    public Storage(String marca, String modelo, Integer capacidade, Double velocidade) {
        super.setMarca(marca);
        super.setModelo(modelo);
        this.capacidade = capacidade;
        this.velocidade = velocidade;
    }
    
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

}
