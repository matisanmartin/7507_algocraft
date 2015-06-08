package strategy;

import java.util.List;

import common.Posicion;

import model.ElementoArtificial;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;

public class ContextoStrategy {
	
	private Strategy strategy;
	
	public ContextoStrategy(Strategy strategy) {
		this.strategy=strategy;
	}
	
	public void ejecutarStrategy(Posicion posicionActual, String rangoAtaque, String daño, List<ElementoArtificial> unidadesEnemigas) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException {
		strategy.realizarAccion(posicionActual,rangoAtaque, daño, unidadesEnemigas);
	}
	
}
