package edificios;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class Asimilador extends EdificioGas {

	public Asimilador(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("450/450");
	}

}
