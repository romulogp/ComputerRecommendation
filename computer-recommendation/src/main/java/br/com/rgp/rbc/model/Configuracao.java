package br.com.rgp.rbc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Configuracao {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpu_id")
    private CPU cpu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fonte_id")
    private Fonte fonte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ram_id")
    private Memoria ram;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "placa_de_video_id")
    private PlacaDeVideo placaDeVideo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "placa_mae_id")
    private PlacaMae placaMae;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storage_id")
    private Storage storage;

    /**
     * Configuração Padrão
     */
    public Configuracao() {
        this.cpu = new CPU();
        this.fonte = new Fonte();
        this.ram = new Memoria();
        this.placaDeVideo = new PlacaDeVideo();
        this.placaMae = new PlacaMae();
        this.storage = new Storage();
    }
    
    /**
     * Cria uma nova configuração
     * @param cpu
     * @param fonte
     * @param ram
     * @param placaDeVideo
     * @param placaMae
     * @param storage 
     */
    public Configuracao(CPU cpu, Fonte fonte, Memoria ram, PlacaDeVideo placaDeVideo, PlacaMae placaMae, Storage storage) {
        this.cpu = cpu;
        this.fonte = fonte;
        this.ram = ram;
        this.placaDeVideo = placaDeVideo;
        this.placaMae = placaMae;
        this.storage = storage;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public Memoria getRam() {
        return ram;
    }

    public void setRam(Memoria ram) {
        this.ram = ram;
    }

    public PlacaDeVideo getPlacaDeVideo() {
        return placaDeVideo;
    }

    public void setPlacaDeVideo(PlacaDeVideo placaDeVideo) {
        this.placaDeVideo = placaDeVideo;
    }

    public PlacaMae getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(PlacaMae placaMae) {
        this.placaMae = placaMae;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

}
