package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class Refineria extends EdificioGas {

	public Refineria(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("750");
	}

}
