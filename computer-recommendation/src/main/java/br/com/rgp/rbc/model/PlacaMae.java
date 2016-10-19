package br.com.rgp.rbc.model;

public class PlacaMae extends Dispositivo implements ISimilaridade<PlacaMae> {

	private static final long serialVersionUID = 1L;

	public PlacaMae() {
		super.setMarca("MSI");
        super.setModelo("970 Gaming");
	}
	
	@Override
	public Double similaridadeCom(PlacaMae placaMae) {
		return 0.0;
	}

	@Override
	public Double getSomatorioPesos() {
		return 0.0;
	}

}
