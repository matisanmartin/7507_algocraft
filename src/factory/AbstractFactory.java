package factory;

import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Edificio;
import factory.construcciones.TipoEdificio;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public abstract class AbstractFactory {

	public abstract  Unidad getUnidad(TipoUnidad unidadRequerida,Posicion posicion)
			throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;
	
	public abstract Edificio getEdificio(TipoEdificio construccionRequerida, Posicion posicion) throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;
	
//	public abstract Base getBase(Posicion posicion) throws FueraDeRangoException;
}
