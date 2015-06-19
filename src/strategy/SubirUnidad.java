package strategy;

import model.ElementoArtificial;
import model.Juego;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public class SubirUnidad implements Strategy {

	
	/**
	 * En este caso, la posicion de destino es la posición de la unidad que va a subir
	 * y el elemento actuante es la nave de transporte
	 * @throws UnidadLlenaException 
	 */
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante,
			Posicion posicionDestino) throws FactoryInvalidaException,
			UnidadInvalidaException, FueraDeRangoException,
			ElementoInvalidoException, PosicionInvalidaException,
			ElementoNoEncontradoException, FueraDeRangoDeVisionException,
			EnergiaInsuficienteException, CostoInvalidoException,
			RecursosInsuficientesException, CloneNotSupportedException,
			FinDePartidaException, PartidaGanadaException,
			PartidaPerdidaException, UnidadLlenaException {
		
		ElementoArtificial unidadASubir = Juego.getInstancia()
															.obtenerArmadaJugadorActual()
															.obtenerElementoEnPosicion(posicionDestino);
		
		elementoActuante.agregarUnidad(unidadASubir);

		
	}

}
