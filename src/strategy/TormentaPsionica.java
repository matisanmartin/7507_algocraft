package strategy;

import java.util.List;
import java.util.ListIterator;

import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import factory.UnidadFactory;

public class TormentaPsionica implements Strategy {
	
	private static final int RANGO_ATAQUE_TORMENTA_PSIONICA=10;
	private static final int DAÑO_TORMENTA_PSIONICA=100;
	private static final int ENERGIA_NECESARIA=75;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante,Posicion posicionDestino) throws FactoryInvalidaException, EnergiaInsuficienteException, FueraDeRangoDeVisionException {
		

		//TODO msma: test 
		Long vidaElementoActuante = Long.parseLong(elementoActuante.getVida());
		if(vidaElementoActuante<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		//TODO msma: Test
		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		Long distanciaNum = Long.parseLong(distancia);
		if(distanciaNum>UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION)
			throw new FueraDeRangoDeVisionException();
		
		List<ElementoArtificial> armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
	
			Posicion posicionTemporal = elementoTemporal.getPosicion();
			
			String distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
			Long distanciaNumTemp = Long.parseLong(distanciaTemp);
			String dañoTormentaPsionica=Long.toString(DAÑO_TORMENTA_PSIONICA);
			
			if(distanciaNumTemp<RANGO_ATAQUE_TORMENTA_PSIONICA){
				elementoTemporal.restarVida(dañoTormentaPsionica);
				it.set(elementoTemporal);
			}
		}
	}



}
