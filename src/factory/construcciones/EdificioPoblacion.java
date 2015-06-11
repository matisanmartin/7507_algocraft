package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public abstract class EdificioPoblacion extends Edificio{

	public EdificioPoblacion(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("100M");
	}



}
