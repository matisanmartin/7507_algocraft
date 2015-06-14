package factory.construcciones;

import common.Costo;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;

public abstract class EdificioMineral extends Edificio {
	
	private static final int CANTIDAD_DE_MINERAL = 5;

	public EdificioMineral(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.setCosto(new Costo("50M"));
		this.setTiempoDeConstruccion(4);
	}

	public int getMineral() {
		return this.CANTIDAD_DE_MINERAL;
	}

}
