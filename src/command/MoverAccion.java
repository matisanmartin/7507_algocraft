package command;

import java.io.IOException;

import model.Elemento;
import strategy.ContextoStrategy;
import strategy.Mover;

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

public class MoverAccion implements Accion {
	
	Elemento elemento;
	
	public MoverAccion(Elemento elemento) {
		this.elemento=elemento;
	}

	@Override
	public void execute(Posicion posicionDestino)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException, ElementoInvalidoException,
			PosicionInvalidaException, ElementoNoEncontradoException,
			FueraDeRangoDeVisionException, EnergiaInsuficienteException,
			CostoInvalidoException, RecursosInsuficientesException,
			CloneNotSupportedException, FinDePartidaException,
			PartidaGanadaException, PartidaPerdidaException,
			UnidadLlenaException, RecursosFaltantesException,
			PoblacionFaltanteException, DanioInvalidoException, IOException {
		elemento.realizarAccion(new ContextoStrategy(new Mover()), posicionDestino);

	}

}
