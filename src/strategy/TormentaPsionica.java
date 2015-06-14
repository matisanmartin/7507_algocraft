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
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());

		if(distancia>UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION)
			throw new FueraDeRangoDeVisionException();
		
		List<ElementoArtificial> armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
	
			Posicion posicionTemporal = elementoTemporal.getPosicion();
			
			int distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
			
			if(distanciaTemp<RANGO_ATAQUE_TORMENTA_PSIONICA){
				elementoTemporal.restarVitalidad(DAÑO_TORMENTA_PSIONICA);
				it.set(elementoTemporal);
			}
		}
	}



}
