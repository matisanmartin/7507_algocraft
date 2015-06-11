package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public abstract class PuertoEstelar extends Edificio {

	public PuertoEstelar(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M150G");
		this.setTiempoDeConstruccion(10);
		// TODO Auto-generated constructor stub
	}
	

}
