package factory.construcciones;

import common.Posicion;
import exceptions.FueraDeRangoException;

public class Pilon extends EdificioPoblacion {

	public Pilon(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setTiempoDeConstruccion(5);
		this.setVida("300/300");
	}

}
