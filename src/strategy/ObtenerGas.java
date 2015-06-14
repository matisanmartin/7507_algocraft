package strategy;

import juego.Juego;
import model.ElementoArtificial;
import common.Posicion;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;

public class ObtenerGas implements Strategy {
	
	public static final int CANTIDAD_DE_GAS=5;
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException {
		
		Juego.getInstancia().getJugadorActual().agregarCantidadDeGas(CANTIDAD_DE_GAS);
		
	}

}
