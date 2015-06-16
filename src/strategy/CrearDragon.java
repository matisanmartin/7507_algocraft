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

public class CrearDragon implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial dragon = factory.getUnidad(TipoUnidad.PROTOSS_DRAGON, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(dragon);
		JuegoController.getInstancia().getJugadorActual().aumentarPoblacionActual(dragon.sumarPoblacion());
		JuegoController.getInstancia().getJugadorActual().disminuirRecursos(dragon.disminuirMineral(),dragon.disminuirGas());
		JuegoController.getInstancia().agregarUnidadAJugadorActual(dragon);
		
	}

}
