package strategy;
import java.util.List;
import java.util.ListIterator;

import common.Mensajes;
import common.Posicion;
import exceptions.ElementoNoEncontradoException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import factory.unidades.Unidad;
import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Espacio;
import model.Juego;

public class Ataque implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, PosicionInvalidaException, FueraDeRangoException {
				
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		int rangoDeVisionElementoActuante=((Unidad)elementoActuante).getVision();
		
		//TODO msma: Test para excepcion FueraDeRangoDeVisionException
		if(distancia>rangoDeVisionElementoActuante)
			throw new FueraDeRangoDeVisionException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO_DE_VISION);
	
		//Armada armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo();
		//ElementoArtificial elementoAtacado=armadaEnemiga.obtenerElementoEnPosicion(posicionDestino);
		List<Elemento> elementosAtacados=CampoBatalla.getInstancia().obtenerElementosEnEspacio(elementoActuante.obtenerEspacio());
		
		
		ListIterator<Elemento> it = elementosAtacados.listIterator();
		Espacio espacioUnidad = elementoActuante.obtenerEspacio();
		
		while(it.hasNext()) {
			
			Elemento elementoTemporal = it.next();
			
			if(elementoTemporal.getPosicion().equals(posicionDestino)) {
				Espacio espacioTemporal = ((ElementoArtificial) elementoTemporal).obtenerEspacio();
				
				int danioAtaqueNum=espacioTemporal.getDanio(((Unidad) elementoTemporal).getDanio());
				int rangoAtaqueAtacante = espacioUnidad.getRangoDeAtaque(((Unidad) elementoActuante).getRangoAtaque());
				//TODO msma: Test para distancia menor y test para distancia mayor
				if(distancia<=rangoAtaqueAtacante){
					elementoTemporal.restarVitalidad(danioAtaqueNum);
					it.set(elementoTemporal);
					Juego.getInstancia().getListener().seRealizoAtaque((ElementoArtificial)elementoTemporal);
					//break;
				}
			}
		}
		
		Juego.getInstancia().verificarFinDePartida();
	
	}			
}