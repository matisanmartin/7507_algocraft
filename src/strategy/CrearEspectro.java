package strategy;

import java.io.IOException;

import model.Elemento;
import model.ElementoArtificial;
import model.Juego;

import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;

public class CrearEspectro implements Strategy{
	
	@Override
	public void realizarAccion(Elemento elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException, UnidadLlenaException, DanioInvalidoException, IOException {
		
		UnidadFactory factory = new UnidadFactory();		
		ElementoArtificial espectro = factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO, posicionDestino);
		Juego.getInstancia().agregarUnidadAJugadorActual(espectro);
		Juego.getInstancia().getListener().seCreoEspectro(espectro);
	}

}
