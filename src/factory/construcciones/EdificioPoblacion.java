package factory.construcciones;

import common.Costo;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;

public abstract class EdificioPoblacion extends Edificio{

	public EdificioPoblacion(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.setCosto(new Costo("100M"));
	}



}
