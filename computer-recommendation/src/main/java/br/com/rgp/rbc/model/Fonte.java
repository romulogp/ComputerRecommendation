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

    /**
     * Cria uma fonte de alimentação padrão para fins de testes.
     */
    public Fonte() {
        super.setMarca("Corsair");
        super.setModelo("CX 600 Modular");
        this.potencia = 600;
        this.eficiencia = 85;
    }

    public Fonte(String marca, String modelo, Integer potencia, Integer eficiencia) {
        super.setMarca(marca);
        super.setModelo(modelo);
        this.potencia = potencia;
        this.eficiencia = eficiencia;
    }
    
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public int getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(Integer eficiencia) {
        this.eficiencia = eficiencia;
    }

}