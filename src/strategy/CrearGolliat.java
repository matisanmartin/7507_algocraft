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

public class CrearGolliat implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial golliat = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(golliat);
		JuegoController.getInstancia().getJugadorActual().aumentarPoblacionActual(golliat.sumarPoblacion());
		JuegoController.getInstancia().getJugadorActual().disminuirRecursos(golliat.disminuirMineral(),golliat.disminuirGas());
		JuegoController.getInstancia().agregarUnidadAJugadorActual(golliat);
		
	}

}
