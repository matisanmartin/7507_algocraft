package strategy;

import java.util.List;
import java.util.ListIterator;

import strategy.Strategy;
import common.Posicion;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import factory.UnidadFactory;
import model.ElementoArtificial;
import model.Juego;

public class TormentaPsionica implements Strategy {
	
	private static final int RANGO_ATAQUE_TORMENTA_PSIONICA=10;
	private static final int DAÑO_TORMENTA_PSIONICA=100;
	private static final int ENERGIA_NECESARIA=75;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante,Posicion posicionDestino) throws FactoryInvalidaException, EnergiaInsuficienteException, FueraDeRangoDeVisionException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException {
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());

		if(distancia>UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION)
			throw new FueraDeRangoDeVisionException();
		
		List<ElementoArtificial> armadaEnemiga=Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporalAtacado = it.next();
	
			Posicion posicionTemporal = elementoTemporalAtacado.getPosicion();
			
			int distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
			
			if(distanciaTemp<RANGO_ATAQUE_TORMENTA_PSIONICA){
				Juego.getInstancia().getListener().seRealizoTormentaPsionica(elementoTemporalAtacado);
				elementoTemporalAtacado.restarVitalidad(DAÑO_TORMENTA_PSIONICA);
				it.set(elementoTemporalAtacado);
			}
		}
		
		Juego.getInstancia().verificarFinDePartida();
	}
}
