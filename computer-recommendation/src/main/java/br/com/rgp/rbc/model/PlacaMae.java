package br.com.rgp.rbc.model;

public class PlacaMae extends Dispositivo {

	private static final long serialVersionUID = 1L;

	public PlacaMae() {
        super.setMarca("MSI");
        super.setModelo("970 Gaming");
    }
    
    public PlacaMae(String marca, String modelo) {
        super.setMarca(marca);
        super.setModelo(modelo);
    }
    
}
