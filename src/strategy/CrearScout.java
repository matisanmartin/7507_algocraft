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

public class CrearScout implements Strategy{

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial scout = factory.getUnidad(TipoUnidad.PROTOSS_SCOUT, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(scout);
		JuegoController.getInstancia().getJugadorActual().aumentarPoblacionActual(scout.sumarPoblacion());
		JuegoController.getInstancia().getJugadorActual().disminuirRecursos(scout.disminuirMineral(),scout.disminuirGas());
		JuegoController.getInstancia().agregarUnidadAJugadorActual(scout);
		
	}
	
	

}
