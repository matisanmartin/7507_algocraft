package strategy;

import java.util.List;
import java.util.ListIterator;

import strategy.Strategy;
import common.Mensajes;
import common.Posicion;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import factory.UnidadFactory;
import model.Elemento;
import model.ElementoArtificial;
import model.Juego;

public class TormentaPsionica implements Strategy {
	
	private static final int RANGO_ATAQUE_TORMENTA_PSIONICA=10;
	private static final int DAÑO_TORMENTA_PSIONICA=100;
	private static final int ENERGIA_NECESARIA=75;

	@Override
	public void realizarAccion(Elemento elementoActuante,Posicion posicionDestino) throws FactoryInvalidaException, EnergiaInsuficienteException, FueraDeRangoDeVisionException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException {
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException(Mensajes.MSJ_ERROR_ENERGIA_INSUFICIENTE);
		
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		int factor=elementoActuante.getAncho();

		if(distancia>UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION*factor)
			throw new FueraDeRangoDeVisionException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO_DE_VISION);
		
		List<Elemento> armadaEnemiga=Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<Elemento> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			Elemento elementoTemporalAtacado = it.next();
	
			Posicion posicionTemporal = elementoTemporalAtacado.getPosicion();
			
			int distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
			distanciaTemp=distanciaTemp*factor;
			
			if(distanciaTemp<RANGO_ATAQUE_TORMENTA_PSIONICA*factor){
				Juego.getInstancia().getListener().seRealizoTormentaPsionica(elementoTemporalAtacado);
				elementoTemporalAtacado.restarVitalidad(DAÑO_TORMENTA_PSIONICA);
				it.set(elementoTemporalAtacado);
			}
		}
		
		Juego.getInstancia().verificarFinDePartida();
	}
}
