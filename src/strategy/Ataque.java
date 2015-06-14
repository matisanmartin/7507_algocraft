package strategy;

import java.util.List;
import java.util.ListIterator;

import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;

import common.Posicion;

import exceptions.ElementoNoEncontradoException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import factory.unidades.Unidad;

public class Ataque implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException {
				
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		int rangoDeVisionElementoActuante=((Unidad)elementoActuante).getVision();
		
		//TODO msma: Test para excepcion FueraDeRangoDeVisionException
		if(distancia>rangoDeVisionElementoActuante)
			throw new FueraDeRangoDeVisionException();
	
		//Armada armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo();
		//ElementoArtificial elementoAtacado=armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);
		List<Elemento> elementosAtacados=CampoBatalla.getInstancia().obtenerElementosEnEspacio(elementoActuante.obtenerEspacio());
		
		
		ListIterator<Elemento> it = elementosAtacados.listIterator();
		
		while(it.hasNext()) {
			
			Elemento elementoTemporal = it.next();
			
			if(elementoTemporal.getPosicion().equals(posicionDestino)){
				String dañoAtaque=((Unidad)elementoActuante).getDaño();
				int dañoAtaqueNum=Integer.parseInt(dañoAtaque);
				
				//TODO msma: Test para distancia menor y test para distancia mayor
				if(distancia<Long.parseLong(((Unidad)elementoActuante).getRangoAtaque())){
					elementoTemporal.restarVitalidad(dañoAtaqueNum);
					it.set(elementoTemporal);
				}
			}
		}
	
	}			
}