package factory.construcciones;

import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Refineria extends EdificioGas {

	public Refineria(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setVitalidad(new Vitalidad(750,0));
	}

	@Override
	public int obtenerAumentoDeGasPorTurno() {
		return 10;
	}

}
