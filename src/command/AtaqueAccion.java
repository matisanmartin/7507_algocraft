package command;

import model.ElementoArtificial;
import strategy.Ataque;
import strategy.ContextoStrategy;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;

public class AtaqueAccion implements Accion {
	
	ElementoArtificial elemento;
	
	public AtaqueAccion(ElementoArtificial elemento) {
		this.elemento=elemento;
	}

	@Override
	public void execute(Posicion posicionDestino)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException, ElementoInvalidoException,
			PosicionInvalidaException, ElementoNoEncontradoException,
			FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException {
		elemento.realizarAccion(new ContextoStrategy(new Ataque()), posicionDestino);
		
	}

}
