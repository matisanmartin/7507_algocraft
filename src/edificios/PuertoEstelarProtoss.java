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

	public Unidad crearScout() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.PROTOSS_SCOUT, new Posicion(10, 10)));
	}
	
	public Unidad crearNaveDeTransporte() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.PROTOSS_NAVE_TRANSPORTE, new Posicion(10, 10)));
	}
}
