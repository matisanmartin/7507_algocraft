package model;

import java.util.List;

import strategy.ContextoStrategy;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;

public interface ElementoArtificial extends Elemento {

	String getVida();
	String getCosto();
	void mover(Posicion nuevaPosicion) throws FueraDeRangoException;
	public void restarVida(String da�o);
	
	void realizarAccion(ContextoStrategy contexto, List<ElementoArtificial> unidadesEnemigas) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException;
}
