package strategy;

import java.io.IOException;

import model.Elemento;
import model.ElementoArtificial;
import model.Juego;

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

public class CrearFabrica implements Strategy {
	
	@Override
	public void realizarAccion(Elemento elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException, RecursosFaltantesException, PoblacionFaltanteException, FactoryInvalidaException, IOException {
		
		AbstractFactory factory = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
		
		ElementoArtificial fabrica = factory.getEdificio(TipoEdificio.TERRAN_FABRICA, posicionDestino);
		Juego.getInstancia().agregarUnidadAJugadorActual(fabrica);
		Juego.getInstancia().getListener().seCreoFabrica(fabrica);
		
	}

}