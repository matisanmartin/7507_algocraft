package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class PuertoEstelarProtoss extends PuertoEstelar {

	public PuertoEstelarProtoss(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("600/600");
		// TODO Auto-generated constructor stub
	}

}
