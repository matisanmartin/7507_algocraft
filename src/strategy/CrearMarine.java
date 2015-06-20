package strategy;

import java.io.IOException;

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
import model.ElementoArtificial;
import model.Juego;

public class CrearMarine implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException, UnidadLlenaException, DanioInvalidoException, IOException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial marine = factory.getUnidad(TipoUnidad.TERRAN_MARINE, posicionDestino);
		Juego.getInstancia().agregarUnidadAJugadorActual(marine);
		Juego.getInstancia().getListener().seCreoMarine(marine);
		
	}

}
