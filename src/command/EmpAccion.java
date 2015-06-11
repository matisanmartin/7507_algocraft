package command;

import model.ElementoArtificial;
import strategy.ContextoStrategy;
import strategy.Emp;

import common.Posicion;

import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;

public class EmpAccion implements Accion {

	ElementoArtificial elemento;
	
	public EmpAccion(ElementoArtificial elem) {
		this.elemento=elem;
	}
	

	@Override
	public void execute(Posicion posicionDestino)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException, ElementoInvalidoException,
			PosicionInvalidaException, ElementoNoEncontradoException,
			FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		elemento.realizarAccion(new ContextoStrategy(new Emp()), posicionDestino);
		
	}

}