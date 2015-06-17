package strategy;

import model.CampoBatalla;
import model.ElementoArtificial;
import common.Posicion;
import common.Vitalidad;
import controller.JuegoController;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;

public class Mover implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante,
			Posicion posicionDestino) throws FactoryInvalidaException,
			UnidadInvalidaException, FueraDeRangoException,
			ElementoInvalidoException, PosicionInvalidaException,
			ElementoNoEncontradoException, FueraDeRangoDeVisionException,
			EnergiaInsuficienteException, CostoInvalidoException,
			RecursosInsuficientesException, CloneNotSupportedException, PoblacionFaltanteException {
		
		
		ElementoArtificial copia = (ElementoArtificial) elementoActuante.clone();
		copia.setPosicion(posicionDestino);
		
		CampoBatalla.getInstancia().eliminarElementoEnPosicion(elementoActuante.getPosicion(), elementoActuante.obtenerEspacio());
		
		elementoActuante.setVitalidad(new Vitalidad(0,0));//TODO msma: esto es temporal hasta hacer un metodo que elimine de una sin necesidad de estar muerto
		JuegoController.getInstancia().getJugadorActual().eliminarElementoMuertoEnPosicion(elementoActuante.getPosicion());
		
		//Agrego los recursos suficientes para que se le agregue la unidad copiada al jugador actual, ya que sino podria tirar excepcion
		JuegoController.getInstancia().getJugadorActual().agregarCantidadDeCristal(copia.getCosto().getCostoMineral());
		JuegoController.getInstancia().getJugadorActual().agregarCantidadDeGas(copia.getCosto().getCostoGas());
		
		JuegoController.getInstancia().agregarUnidadAJugadorActual(copia);
		
	}

}
