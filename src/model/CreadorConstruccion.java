package model;

import exceptions.FactoryInvalidaException;
import factory.construcciones.TipoConstruccion;

public interface CreadorConstruccion {
	
	Elemento crearConstruccion(TipoConstruccion construccionRequerida) throws FactoryInvalidaException;

}
