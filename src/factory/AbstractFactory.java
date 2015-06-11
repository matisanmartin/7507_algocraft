package factory;

import model.Base;

import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Edificio;
import factory.construcciones.TipoEdificio;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public abstract class AbstractFactory {

	public abstract  Unidad getUnidad(TipoUnidad unidadRequerida,Posicion posicion)
			throws UnidadInvalidaException, FueraDeRangoException;
	
	public abstract Edificio getEdificio(TipoEdificio construccionRequerida, Posicion posicion) throws FueraDeRangoException;
	
	public abstract Base getBase(Posicion posicion) throws FueraDeRangoException;
}
