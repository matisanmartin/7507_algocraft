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
				
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		Long rangoDeVisionElementoActuante=Long.parseLong(((Unidad)elementoActuante).getRangoAtaque());
		
		//TODO msma: Test para excepcion FueraDeRangoDeVisionException
		if(distancia>rangoDeVisionElementoActuante)
			throw new FueraDeRangoDeVisionException();
	
		Armada armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo();
		ElementoArtificial elementoAtacado=armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);

		String da�oAtaque=((Unidad)elementoActuante).getDa�o();
		int da�oAtaqueNum=Integer.parseInt(da�oAtaque);
		
		//TODO msma: Test para distancia menor y test para distancia mayor
		if(distancia<Long.parseLong(((Unidad)elementoActuante).getRangoAtaque())){
			elementoAtacado.restarVitalidad(da�oAtaqueNum);
			armadaEnemiga.modificarElementoEnPosicion(posicionDestino,elementoAtacado);
		}
	}			
}
		


	
	
	