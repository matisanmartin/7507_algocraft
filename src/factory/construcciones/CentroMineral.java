package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class CentroMineral extends EdificioMineral {

	public CentroMineral(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("500");
	}

}
