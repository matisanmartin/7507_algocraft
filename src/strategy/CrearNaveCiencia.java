package strategy;

import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;

public class CrearNaveCiencia implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial naveCiencia = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(naveCiencia);
		JuegoController.getInstancia().getJugadorActual().aumentarPoblacionActual(naveCiencia.sumarPoblacion());
		JuegoController.getInstancia().getJugadorActual().disminuirRecursos(naveCiencia.disminuirMineral(),naveCiencia.disminuirGas());
		JuegoController.getInstancia().agregarUnidadAJugadorActual(naveCiencia);
		
	}

}
