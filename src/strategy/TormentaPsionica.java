package strategy;

import java.util.List;
import java.util.ListIterator;

import model.ElementoArtificial;

import common.Posicion;

import controller.JuegoController;
import exceptions.FactoryInvalidaException;

public class TormentaPsionica implements Strategy {
	
	private static final int RANGO_ATAQUE_TORMENTA_PSIONICA=10;
	private static final int DAÑO_TORMENTA_PSIONICA=100;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante,Posicion posicionDestino) throws FactoryInvalidaException {
		
		//TODO msma: Agregar validacion de energía
		//TODO msma: Validar que este en rango de vision!
		List<ElementoArtificial> armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
			
			Posicion posicionTemporal = elementoTemporal.getPosicion();
			
			String distancia = posicionTemporal.getDistancia(posicionDestino);
			
			Long distanciaNum = Long.parseLong(distancia);
			
			String dañoTormentaPsionica=Long.toString(DAÑO_TORMENTA_PSIONICA);
			
			if(distanciaNum<RANGO_ATAQUE_TORMENTA_PSIONICA){
				elementoTemporal.restarVida(dañoTormentaPsionica);
				it.set(elementoTemporal);
			}
		}
	}



}
