package strategy;

import model.Armada;
import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import factory.UnidadFactory;

/**
 * Magia de la NaveCiencia Terran
 *
 */
public class Radiacion implements Strategy {
	
	private static final int ENERGIA_NECESARIA=75;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws ElementoNoEncontradoException, FueraDeRangoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, PosicionInvalidaException {
				
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		//TODO msma: Test para rango de vision
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		//Long distanciaNum = Long.parseLong(distancia);
		if(distancia>UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION)
			throw new FueraDeRangoDeVisionException();
		
		Armada armadaEnemiga = JuegoController.getInstancia()
			       							 .getJugadorEnemigo()
			       							 .obtenerArmada();
		
		ElementoArtificial elementoAtacado = armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);
		
		elementoAtacado.morir();
		
		Posicion posicionElementoDerecha 	= new Posicion(posicionDestino.getPosX()+1,posicionDestino.getPosY());
		Posicion posicionElementoIzquierda 	= new Posicion(posicionDestino.getPosX()-1,posicionDestino.getPosY());
		Posicion posicionElementoDetras		= new Posicion(posicionDestino.getPosX(),posicionDestino.getPosY()+1);
		Posicion posicionElementoDelante	= new Posicion(posicionDestino.getPosX(),posicionDestino.getPosY()-1);
		
 
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDelante);
			//TODO msma: Para este y todos, de encotnrarlos, deberia drenarle la vida hasta que el otro se muera, luego no.
			// Por ahora se le saca vida para probar la funcionalidad
			elementoCandidato.morir();
			JuegoController.getInstancia()
						   .getJugadorEnemigo()
						   .obtenerArmada()
						   .modificarElementoEnPosicion(posicionElementoDelante, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDetras);
			elementoCandidato.morir();
			JuegoController.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoDetras, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDerecha);
			elementoCandidato.morir();
			JuegoController.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoDerecha, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoIzquierda);
			elementoCandidato.morir();
			JuegoController.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoIzquierda, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		JuegoController.getInstancia().verificarFinDePartida();
				
	}
	


}
