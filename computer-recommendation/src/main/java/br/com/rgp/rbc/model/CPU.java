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

    /**
     * Cria um processador padrão para fins de teste
     */
    public CPU() {
        super.setMarca("Intel");
        super.setModelo("Core I7 4790K");
        this.nucleos = 8;
        this.clock = 4.0;
        this.cache = 8;
        this.tdp = 88;
    }

    public CPU(String marca, String modelo, Integer nucleos, Double clock, Integer cache, Integer tdp) {
        super.setMarca(marca);
        super.setModelo(modelo);
        this.nucleos = nucleos;
        this.clock = clock;
        this.cache = cache;
        this.tdp = tdp;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(Double clock) {
        this.clock = clock;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    public double getTdp() {
        return tdp;
    }

    public void setTdp(Integer tdp) {
        this.tdp = tdp;
    }

}
