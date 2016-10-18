package br.com.rgp.rbc.model;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class Fonte extends Dispositivo implements ISimilaridade<Fonte> {

	private static final long serialVersionUID = 1L;

	// Valores Máximos
	private static final Double MAX_POTENCIA = 2000.0;
	private static final Double MAX_EFICIENCIA = 100.0;
	// Valores Mínimos
	private static final Double MIN_POTENCIA = 0.0;
	private static final Double MIN_EFICIENCIA = 0.0;
	
	
	// Pesos
	private static final Double PESO_POTENCIA = 0.7;
	private static final Double PESO_EFICIENCIA = 0.8;
	
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

	@Override
	public Double similaridadeCom(Fonte fonte) {
		Double similaridade = 0.0;
		
		similaridade += PESO_EFICIENCIA * (1 - ((Math.abs(this.getEficiencia() - fonte.getEficiencia())) / (MAX_EFICIENCIA - MIN_EFICIENCIA)));
		similaridade += PESO_POTENCIA * (1 - ((Math.abs(this.getPotencia() - fonte.getPotencia())) / (MAX_POTENCIA - MIN_POTENCIA)));
		return normalizarSimilaridade(similaridade);
	}
	
	private Double normalizarSimilaridade(Double valorOriginal) {
		Double somatorioPesos = (double) (PESO_EFICIENCIA + PESO_POTENCIA);
		System.out.println(valorOriginal);
		System.out.println(somatorioPesos);
		
		return valorOriginal / somatorioPesos;
	}
	
	public static void main(String[] args) {
		Fonte f1 = new Fonte();
		f1.setEficiencia(80);
		f1.setPotencia(750);
		
		Fonte f2 = new Fonte();
		f2.setPotencia(750);
		f2.setEficiencia(80);
		
		System.out.println(f1.similaridadeCom(f2));
	}
	
}