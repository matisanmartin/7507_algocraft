package strategy;

import model.Armada;
import model.ElementoArtificial;

import common.Posicion;

import controller.JuegoController;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;

public class Radiacion implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws ElementoNoEncontradoException, FueraDeRangoException {
		
		//TODO msma: Agregar validacion de Energia, necesita tener 75, y restarsela a lo actual
		//TODO msma: Validar que este en rango de vision!
		
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
