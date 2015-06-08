package strategy;

import java.util.List;
import java.util.ListIterator;

import common.Posicion;

import model.ElementoArtificial;
import exceptions.FactoryInvalidaException;

public class TormentaPsionica implements Strategy {
	
	private static final int RANGO_ATAQUE_TORMENTA_PSIONICA=10;
	private static final int DAÑO_TORMENTA_PSIONICA=100;

	@Override
	public void realizarAccion(Posicion posicionActual, String rangoAtaque, String daño, List<ElementoArtificial> unidadesEnemigas) throws FactoryInvalidaException {
		
		ListIterator<ElementoArtificial> it = unidadesEnemigas.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
			
			Posicion posicionTemporal = elementoTemporal.getPosicion();
			
			String distancia = posicionTemporal.getDistancia(posicionActual);
			
			Long distanciaNum = Long.parseLong(distancia);
			
			String dañoTormentaPsionica=Long.toString(DAÑO_TORMENTA_PSIONICA);
			
			if(distanciaNum<RANGO_ATAQUE_TORMENTA_PSIONICA){
				elementoTemporal.restarVida(dañoTormentaPsionica);
				it.set(elementoTemporal);
			}
		}
	}

}
