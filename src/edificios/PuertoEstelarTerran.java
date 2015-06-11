package edificios;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class PuertoEstelarTerran extends PuertoEstelar {

	public PuertoEstelarTerran(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("1300");
		// TODO Auto-generated constructor stub
	}
	
}
