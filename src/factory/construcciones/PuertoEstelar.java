package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public abstract class PuertoEstelar extends Edificio {

	public PuertoEstelar(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setTiempoDeConstruccion(10);
		// TODO Auto-generated constructor stub
	}
	

}
