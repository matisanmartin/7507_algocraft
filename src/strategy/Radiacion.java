package strategy;

import model.Armada;
import model.Elemento;
import model.Juego;

import common.Mensajes;
import common.Posicion;

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
	public void realizarAccion(Elemento elementoActuante, Posicion posicionDestino) 
	throws ElementoNoEncontradoException, FueraDeRangoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, PosicionInvalidaException {
				
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException(Mensajes.MSJ_ERROR_ENERGIA_INSUFICIENTE);
		
		int factor = elementoActuante.getAncho();
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		if(distancia>UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION*factor)
			throw new FueraDeRangoDeVisionException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO_DE_VISION);
		
		Armada armadaEnemiga = Juego.getInstancia()
			       							 .getJugadorEnemigo()
			       							 .obtenerArmada();
		
		Elemento elementoAtacado = armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);
		
		//Juego.getInstancia().getListener().seRealizoRadiacion(elementoAtacado);
		elementoAtacado.morir();
		
		Posicion posicionElementoDerecha 	= new Posicion(posicionDestino.getX()+1+factor,posicionDestino.getY());
		Posicion posicionElementoIzquierda 	= new Posicion(posicionDestino.getX()-1-factor,posicionDestino.getY());
		Posicion posicionElementoDetras		= new Posicion(posicionDestino.getX(),posicionDestino.getY()+1+factor);
		Posicion posicionElementoDelante	= new Posicion(posicionDestino.getX(),posicionDestino.getY()-1-factor);
		
 
		try
		{
			Elemento elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDelante);
			//TODO msma: Para este y todos, de encotnrarlos, deberia drenarle la vida hasta que el otro se muera, luego no.
			// Por ahora se le saca vida para probar la funcionalidad
			Juego.getInstancia().getListener().seRealizoRadiacion(elementoCandidato);
			elementoCandidato.morir();
			Juego.getInstancia()
						   .getJugadorEnemigo()
						   .obtenerArmada()
						   .modificarElementoEnPosicion(posicionElementoDelante, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			Elemento elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDetras);
			Juego.getInstancia().getListener().seRealizoRadiacion(elementoCandidato);
			elementoCandidato.morir();
			Juego.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoDetras, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			Elemento elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDerecha);
			Juego.getInstancia().getListener().seRealizoRadiacion(elementoCandidato);
			elementoCandidato.morir();
			Juego.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoDerecha, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			Elemento elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoIzquierda);
			Juego.getInstancia().getListener().seRealizoRadiacion(elementoCandidato);
			elementoCandidato.morir();
			Juego.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoIzquierda, elementoCandidato);
		}
		catch(ElementoNoEncontradoException enee){}
		
		Juego.getInstancia().verificarFinDePartida();
				
	}
	


}
