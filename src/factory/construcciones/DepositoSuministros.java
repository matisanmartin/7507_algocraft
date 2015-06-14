package factory.construcciones;

import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;

public class DepositoSuministros extends EdificioPoblacion {

	public DepositoSuministros(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.setTiempoDeConstruccion(6);
		this.setVitalidad(new Vitalidad(500,0));
	}

}
