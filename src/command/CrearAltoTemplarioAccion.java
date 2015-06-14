package command;

import model.ElementoArtificial;
import strategy.ContextoStrategy;
import strategy.CrearAltoTemplario;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public class CrearAltoTemplarioAccion implements Accion {
	ElementoArtificial elemento;
	
	public CrearAltoTemplarioAccion(ElementoArtificial elem) {
		this.elemento=elem;
	}
	
	@Override
	public void execute(Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException {
		elemento.realizarAccion(new ContextoStrategy(new CrearAltoTemplario()), posicionDestino);
		
	}

}

