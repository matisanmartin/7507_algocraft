package strategy;

import java.util.List;
import java.util.ListIterator;

import model.ElementoArtificial;
import controller.Posicion;

public class Atacar implements Strategy {

	@Override
	public void realizarAccion(Posicion posicionActual, String rangoAtaque, String daño, List<ElementoArtificial> unidadesEnemigas) {
	
		ListIterator<ElementoArtificial> it = unidadesEnemigas.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
			
			Posicion posicionTemporal = elementoTemporal.getPosicion();
			
			String distancia = posicionTemporal.getDistancia(posicionActual);
			
			Long distanciaNum = Long.parseLong(distancia);
			
			if(distanciaNum<Long.parseLong(rangoAtaque)){
				elementoTemporal.restarVida(daño);
				it.set(elementoTemporal);
			}
		}
	}

}
