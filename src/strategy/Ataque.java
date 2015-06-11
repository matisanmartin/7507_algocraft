package strategy;

import model.Armada;
import model.ElementoArtificial;

import common.Posicion;

import controller.JuegoController;
import exceptions.ElementoNoEncontradoException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import factory.unidades.Unidad;

public class Ataque implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException {
				
		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		Long distanciaNum = Long.parseLong(distancia);
		Long rangoDeVisionElementoActuante=Long.parseLong(((Unidad)elementoActuante).getRangoAtaque());
		
		//TODO msma: Test para excepcion FueraDeRangoDeVisionException
		if(distanciaNum>rangoDeVisionElementoActuante)
			throw new FueraDeRangoDeVisionException();
	
		Armada armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo();
		ElementoArtificial elementoAtacado=armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);

		String dañoTormentaPsionica=((Unidad)elementoActuante).getDaño();
		
		//TODO msma: Test para distancia menor y test para distancia mayor
		if(distanciaNum<Long.parseLong(((Unidad)elementoActuante).getRangoAtaque())){
			elementoAtacado.restarVida(dañoTormentaPsionica);
			armadaEnemiga.modificarElementoEnPosicion(posicionDestino,elementoAtacado);
		}
	}			
}
		


	
	
	