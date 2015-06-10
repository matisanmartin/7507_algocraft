package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;

public abstract class EdificioMineral extends Edificio {
	
	private static final int CANTIDAD_DE_MINERAL = 5;

	public EdificioMineral(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("50M");
		this.setTiempoDeConstruccion(4);
	}

	public int getMineral() {
		// TODO Auto-generated method stub
		return this.CANTIDAD_DE_MINERAL;
	}

}
