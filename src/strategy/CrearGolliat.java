package strategy;

import juego.Juego;
import model.ElementoArtificial;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;

public class CrearGolliat implements Strategy {
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, CostoInvalidoException, RecursosInsuficientesException {
		
		UnidadFactory factory = new UnidadFactory();
		
		ElementoArtificial golliat = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, posicionDestino);
		Juego.getInstancia().agregarUnidadAJugadorActual(golliat);
		
	}

}
