package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class NexoMineral extends EdificioMineral {

	public NexoMineral(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("250/250");
	}

}
