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

public class CrearEspectro implements Strategy{
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial espectro = factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(espectro);
		JuegoController.getInstancia().getJugadorActual().aumentarPoblacionActual(espectro.sumarPoblacion());
		JuegoController.getInstancia().getJugadorActual().disminuirRecursos(espectro.disminuirMineral(),espectro.disminuirGas());
		JuegoController.getInstancia().agregarUnidadAJugadorActual(espectro);
		
	}

}
