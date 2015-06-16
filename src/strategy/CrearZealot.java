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

public class CrearZealot implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial zealot = factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(zealot);
		JuegoController.getInstancia().getJugadorActual().aumentarPoblacionActual(zealot.sumarPoblacion());
		JuegoController.getInstancia().getJugadorActual().disminuirRecursos(zealot.disminuirMineral(),zealot.disminuirGas());
		JuegoController.getInstancia().agregarUnidadAJugadorActual(zealot);
		
	}

}
