package strategy;

import java.util.List;
import java.util.ListIterator;

import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Espacio;
import model.EspacioTerrestre;
import model.Juego;

import common.Mensajes;
import common.Posicion;

import exceptions.EnergiaInsuficienteException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import factory.UnidadFactory;

public class Emp implements Strategy {
	
	private static final int RADIO_ACCION_MISIL_EMP= 3;
	private static final int ENERGIA_NECESARIA=100;

	@Override
	public void realizarAccion(Elemento elementoActuante, Posicion posicionDestino) throws EnergiaInsuficienteException, FueraDeRangoDeVisionException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, PosicionInvalidaException, FueraDeRangoException {
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException(Mensajes.MSJ_ERROR_ENERGIA_INSUFICIENTE);
		
		int factor = elementoActuante.getAncho();
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		//TODO msma: Test para rango de vision
		if(distancia>UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION*factor)
			throw new FueraDeRangoDeVisionException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO_DE_VISION);
		
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
			
			Elemento elementoAtacado = it.next();
			Posicion posTemporal = elementoAtacado.getPosicion();
			
			int distanciaTemp = posTemporal.getDistancia(posicionDestino);
			
			//Valido que este en el radio y que no sea el elemento que actua
			//En principio, no podria atacar a una unidad que este en otro espacio y misma posicion
			if(distanciaTemp<RADIO_ACCION_MISIL_EMP*factor&&!(elementoAtacado.posicionEsParte(posicionDestino)))
			{
				Juego.getInstancia().getListener().seRealizoEmp((ElementoArtificial)elementoAtacado);
				elementoAtacado.recibirEmp();
				it.set(elementoAtacado);
	
			}
		}

		elementoActuante.restarEnergiaPorAccion(ENERGIA_NECESARIA);

		Juego.getInstancia().verificarFinDePartida();
	}
	

}
