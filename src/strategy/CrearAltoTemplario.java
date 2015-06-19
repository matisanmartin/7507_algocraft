package strategy;

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

public class CrearAltoTemplario implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException, UnidadLlenaException, DanioInvalidoException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial altoTemplario = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, posicionDestino);
		Juego.getInstancia().agregarUnidadAJugadorActual(altoTemplario);
		
	}

}
