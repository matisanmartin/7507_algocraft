package factory.construcciones;

import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;

public class Asimilador extends EdificioGas {

	public Asimilador(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.setVitalidad(new Vitalidad(450,450));
	}

}
