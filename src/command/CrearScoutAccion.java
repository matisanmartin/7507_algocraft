package command;

import model.ElementoArtificial;
import strategy.ContextoStrategy;
import strategy.CrearScout;

import common.Posicion;

import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;

public class CrearScoutAccion implements Accion {
	ElementoArtificial elemento;
	
	public CrearScoutAccion(ElementoArtificial elem) {
		this.elemento=elem;
	}
	
	@Override
	public void execute(Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		elemento.realizarAccion(new ContextoStrategy(new CrearScout()), posicionDestino);
		
	}

}
