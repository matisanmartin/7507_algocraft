package factory.construcciones;

import common.Posicion;

import exceptions.FueraDeRangoException;

public abstract class EdificioGas extends Edificio {
	
	private static final int CANTIDAD_DE_MINERAL = 5;

	public EdificioGas(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		// TODO Auto-generated constructor stub
		this.setCosto("100M");
		this.setTiempoDeConstruccion(6);
	}

	public int getGas() {
		// TODO Auto-generated method stub
		return this.CANTIDAD_DE_MINERAL;
	}

}
