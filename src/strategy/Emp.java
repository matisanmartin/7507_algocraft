package strategy;

import java.util.List;
import java.util.ListIterator;

import model.ElementoArtificial;

import common.Posicion;

import controller.JuegoController;
import exceptions.EnergiaInsuficienteException;
import exceptions.FueraDeRangoDeVisionException;
import factory.UnidadFactory;

public class Emp implements Strategy {
	
	private static final int RADIO_ACCION_MISIL_EMP= 5;
	private static final int ENERGIA_NECESARIA=100;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) throws EnergiaInsuficienteException, FueraDeRangoDeVisionException {
		
		//TODO msma: Test para energia insuficiente
		Long vidaElementoActuante = Long.parseLong(elementoActuante.getVida());
		if(vidaElementoActuante<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		Long distanciaNum = Long.parseLong(distancia);
		
		//TODO msma: Test para rango de vision
		if(distanciaNum>UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION)
			throw new FueraDeRangoDeVisionException();
		
		List<ElementoArtificial> armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
			
			Posicion posicionTemporal = elementoTemporal.getPosicion();	
			String distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
			Long distanciaNumTemp = Long.parseLong(distanciaTemp);
			
			if(distanciaNumTemp<RADIO_ACCION_MISIL_EMP){
				elementoTemporal.setVida("0");
				it.set(elementoTemporal);
			}
		}
	}
	

}
