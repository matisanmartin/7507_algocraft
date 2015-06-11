package edificios;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class Acceso extends Edificio {

	public Acceso(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M");
		this.setTiempoDeConstruccion(8);
		this.setVida("500/500");
		// TODO Auto-generated constructor stub
	}

}
