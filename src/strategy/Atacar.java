package strategy;

import model.Armada;
import model.ElementoArtificial;

import common.Posicion;

import controller.JuegoController;
import exceptions.ElementoNoEncontradoException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import factory.unidades.Unidad;

public class Atacar implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException {
			
		
		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		Long distanciaNum = Long.parseLong(distancia);
		Long rangoDeVisionElementoActuante=Long.parseLong(((Unidad)elementoActuante).getRangoAtaque());
		
		if(distanciaNum>rangoDeVisionElementoActuante)
			throw new FueraDeRangoDeVisionException();
		
		
		//TODO msma: Validar que este en rango de vision!!!
		Armada armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo();
		
		ElementoArtificial elementoAtacado=armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);
			
//		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
//		Long distanciaNum = Long.parseLong(distancia);
		
		String dañoTormentaPsionica=((Unidad)elementoActuante).getDaño();
		
		if(distanciaNum<Long.parseLong(((Unidad)elementoActuante).getRangoAtaque())){
			elementoAtacado.restarVida(dañoTormentaPsionica);
			armadaEnemiga.modificarElementoEnPosicion(posicionDestino,elementoAtacado);
		}
	}			
}
		


	
	
	