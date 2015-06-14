package strategy;

import java.util.List;
import java.util.ListIterator;

import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Espacio;
import model.EspacioAereo;
import model.EspacioTerrestre;
import common.Posicion;
import common.RangoAtaque;
import controller.JuegoController;
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
		
		Espacio espacioElementoActuante = elementoActuante.obtenerEspacio();
		
		//La nave ciencia es aerea pero sus ataques pueden lastimar tanto elementos aereos como terrestres
		List<Elemento> elementosEnEspacioCampoDeBatalla=CampoBatalla.getInstancia()
																	.obtenerElementosEnEspacio(espacioElementoActuante);
		
		List<Elemento> elementosEnTierraCampoDeBatalla=CampoBatalla.getInstancia()
																   .obtenerElementosEnEspacio(new EspacioTerrestre());
		
		
		//Hago un append de los elementos de tierra en los elementos de espacio para que verifique todos
		elementosEnEspacioCampoDeBatalla.addAll(elementosEnTierraCampoDeBatalla);
		
		ListIterator<Elemento> it = elementosEnEspacioCampoDeBatalla.listIterator();
		
		while(it.hasNext()){
			
			Elemento elemTemporal = it.next();
			Posicion posTemporal = elemTemporal.getPosicion();
			
			int distanciaTemp = posTemporal.getDistancia(posicionDestino);
			//Long distanciaNumTemp = Long.parseLong(distanciaTemp);
			
			//Valido que este en el radio y que no sea el elemento que actua
			//En principio, no podria atacar a una unidad que este en otro espacio y misma posicion
			if(distanciaTemp<RADIO_ACCION_MISIL_EMP&&!posTemporal.equals(elementoActuante.getPosicion())){
				elemTemporal.recibirEmp();
				it.set(elemTemporal);
	
			}
		}
		
		
		
		
		
		
		elementoActuante.restarEnergiaPorAccion(ENERGIA_NECESARIA);
		
//		List<ElementoArtificial> armadaEnemiga=JuegoController.getInstancia().obtenerArmadaJugadorEnemigo().getArmada();
//		
//		
//		ListIterator<ElementoArtificial> it = armadaEnemiga.listIterator();
//		
//		while(it.hasNext())
//		{
//			ElementoArtificial elementoTemporal = it.next();
//			
//			Posicion posicionTemporal = elementoTemporal.getPosicion();	
//			int distanciaTemp = posicionTemporal.getDistancia(posicionDestino);
//			//Long distanciaNumTemp = Long.parseLong(distanciaTemp);
//			
//			if(distanciaTemp<RADIO_ACCION_MISIL_EMP){
//				elementoTemporal.recibirEmp();
//				it.set(elementoTemporal);
//			}
//		}
//		
//		elementoActuante.restarEnergiaPorAccion(ENERGIA_NECESARIA);
	}
	

}
