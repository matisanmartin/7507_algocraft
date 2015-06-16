package strategy;

import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.construcciones.TipoEdificio;

public class CrearNexoMineral implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException, FactoryInvalidaException {
		
		AbstractFactory factory = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
		
		ElementoArtificial nexoMineral = factory.getEdificio(TipoEdificio.PROTOSS_NEXO_MINERAL, posicionDestino);
		JuegoController.getInstancia().getJugadorActual().validarCreacion(nexoMineral);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(nexoMineral);
		
	}

}
