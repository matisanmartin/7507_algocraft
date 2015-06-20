package strategy;

import java.io.IOException;

import common.Posicion;
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
import model.ElementoArtificial;
import model.Juego;

public class CrearBarraca implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException, FactoryInvalidaException, IOException {
		
		AbstractFactory factory = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
		
		ElementoArtificial barraca = factory.getEdificio(TipoEdificio.TERRAN_BARRACA, posicionDestino);
		Juego.getInstancia().agregarUnidadAJugadorActual(barraca);
		Juego.getInstancia().getListener().seCreoBarraca(barraca);
	}

}