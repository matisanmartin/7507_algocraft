package factory;

import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;



public class ConstruccionFactory extends AbstractFactory {

	@Override
	public Unidad getUnidad(TipoUnidad unidadRequerida, Posicion posicion)
			throws UnidadInvalidaException, FueraDeRangoException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Unidad getUnidad(TipoUnidad unidadRequerida) {
//		
//		return null;
//	}

//	@Override
//	public Construccion getConstruccion(TipoConstruccion construccionRequerida) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
