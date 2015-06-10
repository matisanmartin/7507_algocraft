package strategy;

import model.ElementoArtificial;
import common.Posicion;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;

public class ContextoStrategy {
	
	private Strategy strategy;
	
	public ContextoStrategy(Strategy strategy) {
		this.strategy=strategy;
	}
	
	public void ejecutarStrategy(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		strategy.realizarAccion(elementoActuante,posicionDestino);
	}
	
}
