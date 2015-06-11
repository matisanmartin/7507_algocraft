package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class DepositoSuministros extends EdificioPoblacion {

	public DepositoSuministros(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setTiempoDeConstruccion(6);
		this.setVida("500");
	}

}
