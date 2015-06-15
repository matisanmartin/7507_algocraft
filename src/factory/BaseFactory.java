package factory;

import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Edificio;
import factory.construcciones.TipoEdificio;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class BaseFactory extends AbstractFactory {

	public BaseFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unidad getUnidad(TipoUnidad unidadRequerida, Posicion posicion)
			throws UnidadInvalidaException, FueraDeRangoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edificio getEdificio(TipoEdificio construccionRequerida,
			Posicion posicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Base getBase(Posicion posicion) throws FueraDeRangoException {
//		return (new Base(posicion));
//	}

}
