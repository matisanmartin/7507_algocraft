package strategy;

import model.ElementoArtificial;
import common.Posicion;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;

public interface Strategy {
	
	void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws 	FactoryInvalidaException, 
			UnidadInvalidaException, 
			FueraDeRangoException, 
			ElementoInvalidoException, 
			PosicionInvalidaException, 
			ElementoNoEncontradoException, 
			FueraDeRangoDeVisionException, 
			EnergiaInsuficienteException;

}
