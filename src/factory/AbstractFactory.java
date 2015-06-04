package factory;

import exceptions.UnidadInvalidaException;
import factory.construcciones.Construccion;
import factory.construcciones.TipoConstruccion;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public abstract class AbstractFactory {

	public abstract Unidad getUnidad(TipoUnidad unidadRequerida) throws UnidadInvalidaException;
	abstract Construccion getConstruccion(TipoConstruccion construccionRequerida);
}
