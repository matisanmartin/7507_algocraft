package strategy;

import java.util.List;
import java.util.ListIterator;

import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;

public class Emp implements Strategy {
	
	private static final int RADIO_ACCION_MISIL_EMP= 5;

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) {
		
		//TODO msma: Agregar validacion de energia (100) para el elemento y tirar excepcion
		//TODO msma: Validar que este en rango de vision!
		
		List<ElementoArtificial> armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
		
		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
		
		while(it.hasNext())
		{
			ElementoArtificial elementoTemporal = it.next();
			
			Posicion posicionTemporal = elementoTemporal.getPosicion();
			
			String distancia = posicionTemporal.getDistancia(posicionDestino);
			
			Long distanciaNum = Long.parseLong(distancia);
			
			if(distanciaNum<RADIO_ACCION_MISIL_EMP){
				elementoTemporal.setVida("0");
				it.set(elementoTemporal);
			}
		}
	}
	

}
