package strategy;

import java.util.List;
import java.util.ListIterator;

import juego.Juego;
import model.ElementoArtificial;
import common.Posicion;
import common.RangoAtaque;
import exceptions.EnergiaInsuficienteException;
import exceptions.FueraDeRangoDeVisionException;
import factory.UnidadFactory;
import factory.unidades.Unidad;

public class Emp implements Strategy {
	
	private static final int RADIO_ACCION_MISIL_EMP= 3;
	private static final int ENERGIA_NECESARIA=100;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) throws EnergiaInsuficienteException, FueraDeRangoDeVisionException {
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		//Long distanciaNum = Long.parseLong(distancia);
		
		//TODO msma: Test para rango de vision
		if(distancia>UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION)
			throw new FueraDeRangoDeVisionException();
		
//		List<Elemento> elementosEnCampoDeBatalla=CampoBatalla.getInstancia().getElementos();
//		
//		ListIterator<Elemento> it = elementosEnCampoDeBatalla.listIterator();
//		
//		while(it.hasNext()){
//			
//			Elemento elemTemporal = it.next();
//			Posicion posTemporal = elemTemporal.getPosicion();
//			
//			if(JuegoController.getInstancia().getJugadorActual().elementoMePertenece(posTemporal))
//				it.next();
//			else
//			{
//				int distanciaTemp = posTemporal.getDistancia(posicionDestino);
//				//Long distanciaNumTemp = Long.parseLong(distanciaTemp);
//				
//				if(distanciaTemp<RADIO_ACCION_MISIL_EMP){
//					elemTemporal.recibirEmp();
//					it.set(elemTemporal);
//				}
//			}
//		}
//		
//		elementoActuante.restarEnergiaPorAccion(ENERGIA_NECESARIA);
		
		List<ElementoArtificial> armadaEnemiga=Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
			
			Posicion posicionTemporal = elementoTemporal.getPosicion();	
			int distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
			//Long distanciaNumTemp = Long.parseLong(distanciaTemp);
			
			if(distanciaTemp<RADIO_ACCION_MISIL_EMP){
				elementoTemporal.recibirEmp();
				it.set(elementoTemporal);
			}
		}
		
		elementoActuante.restarEnergiaPorAccion(ENERGIA_NECESARIA);
	}
	

}
