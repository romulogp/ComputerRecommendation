package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public class Dispositivo extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	@NotNull
	@NotBlank
	private String marca;
	
	@Column(nullable = false)
	@NotNull
	@NotBlank
    private String modelo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
