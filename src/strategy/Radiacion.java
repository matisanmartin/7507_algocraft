package strategy;

import model.Armada;
import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import factory.UnidadFactory;

/**
 * Magia de la NaveCiencia Terran
 *
 */
public class Radiacion implements Strategy {
	
	private static final int ENERGIA_NECESARIA=75;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws ElementoNoEncontradoException, FueraDeRangoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
				
		//TODO msma: test para vida insuficiente
		Long vidaElementoActuante = Long.parseLong(elementoActuante.getVida());
		if(vidaElementoActuante<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		//TODO msma: Test para rango de vision
		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		Long distanciaNum = Long.parseLong(distancia);
		if(distanciaNum>UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION)
			throw new FueraDeRangoDeVisionException();
		
		Armada armadaEnemiga = JuegoController.getInstancia()
			       							 .getJugadorEnemigo()
			       							 .obtenerArmada();
		
		ElementoArtificial elementoAtacado = armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);
		
		elementoAtacado.setVida("0");
		
		Posicion posicionElementoDerecha 	= new Posicion(posicionDestino.getPosX()+1,posicionDestino.getPosY());
		Posicion posicionElementoIzquierda 	= new Posicion(posicionDestino.getPosX()-1,posicionDestino.getPosY());
		Posicion posicionElementoDetras		= new Posicion(posicionDestino.getPosX(),posicionDestino.getPosY()+1);
		Posicion posicionElementoDelante	= new Posicion(posicionDestino.getPosX(),posicionDestino.getPosY()-1);
		
 
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDelante);
			//TODO msma: Para este y todos, de encotnrarlos, deberia drenarle la vida hasta que el otro se muera, luego no.
			// Por ahora se le saca vida para probar la funcionalidad
			elementoCandidato.setVida("0");
			JuegoController.getInstancia()
						   .getJugadorEnemigo()
						   .obtenerArmada()
						   .modificarElementoEnPosicion(posicionElementoDelante, elementoAtacado);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDetras);
			elementoCandidato.setVida("0");
			JuegoController.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoDetras, elementoAtacado);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoDerecha);
			elementoCandidato.setVida("0");
			JuegoController.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoDerecha, elementoAtacado);
		}
		catch(ElementoNoEncontradoException enee){}
		
		try
		{
			ElementoArtificial elementoCandidato=armadaEnemiga.obtenerElementoEnPosicion(posicionElementoIzquierda);
			elementoCandidato.setVida("0");
			JuegoController.getInstancia()
			   .getJugadorEnemigo()
			   .obtenerArmada()
			   .modificarElementoEnPosicion(posicionElementoIzquierda, elementoAtacado);
		}
		catch(ElementoNoEncontradoException enee){}
				
	}
	


}
