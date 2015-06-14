package factory.construcciones;

import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;

public class Pilon extends EdificioPoblacion {

	public Pilon(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.setTiempoDeConstruccion(5);
		this.setVitalidad(new Vitalidad(300,300));
	}

}
