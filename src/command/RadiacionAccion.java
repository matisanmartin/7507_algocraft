package command;

import java.io.IOException;

import strategy.ContextoStrategy;
import strategy.Radiacion;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
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
import model.ElementoArtificial;


public class RadiacionAccion implements Accion {

	ElementoArtificial elemento;
	
	public RadiacionAccion(ElementoArtificial unidad) {
		this.elemento=unidad;
	}
	
	@Override
	public void execute(Posicion posicionDestino)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException, ElementoInvalidoException,
			PosicionInvalidaException, ElementoNoEncontradoException,
			FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		elemento.realizarAccion(new ContextoStrategy(new Radiacion()), posicionDestino);
	}




}
