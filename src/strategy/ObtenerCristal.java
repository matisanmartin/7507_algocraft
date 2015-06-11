package strategy;

import model.ElementoArtificial;

import common.Posicion;

import controller.JuegoController;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;

public class ObtenerCristal implements Strategy {
	
	public static final int CANTIDAD_DE_CRISTAL=5;
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException {
		
		JuegoController.getInstancia().getJugadorActual().agregarCantidadDeCristal(CANTIDAD_DE_CRISTAL);
	}

}
