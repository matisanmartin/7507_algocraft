package factory;

import common.Posicion;

import edificios.Edificio;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.TipoConstruccion;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public abstract class AbstractFactory {


//	public abstract Construccion getConstruccion(TipoConstruccion construccionRequerida);

	public abstract  Unidad getUnidad(TipoUnidad unidadRequerida,Posicion posicion)
			throws UnidadInvalidaException, FueraDeRangoException;
	
	public abstract Edificio getEdificio(TipoConstruccion construccionRequerida, Posicion posicion);
}
