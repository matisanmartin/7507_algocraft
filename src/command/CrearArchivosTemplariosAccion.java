package command;

import model.ElementoArtificial;
import strategy.ContextoStrategy;
import strategy.CrearArchivosTemplarios;
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
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public class CrearArchivosTemplariosAccion implements Accion {
	ElementoArtificial elemento;
	
	public CrearArchivosTemplariosAccion(ElementoArtificial elem) {
		this.elemento=elem;
	}
	
	@Override
	public void execute(Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException {
		elemento.realizarAccion(new ContextoStrategy(new CrearArchivosTemplarios()), posicionDestino);
		
	}

}