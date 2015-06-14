package command;

import model.ElementoArtificial;
import strategy.ContextoStrategy;
import strategy.TormentaPsionica;
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

public class TormentaPsionicaAccion implements Accion {

	ElementoArtificial elemento;
	
	public TormentaPsionicaAccion(ElementoArtificial elem) {
		this.elemento=elem;
	}

	@Override
	public void execute(Posicion posicionDestino)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException, ElementoInvalidoException,
			PosicionInvalidaException, ElementoNoEncontradoException,
			FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException {
		elemento.realizarAccion(new ContextoStrategy(new TormentaPsionica()), posicionDestino);
		
	}


}
