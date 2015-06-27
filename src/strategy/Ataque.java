package strategy;
import java.util.List;
import java.util.ListIterator;

import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Espacio;
import model.Juego;

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

public class Ataque implements Strategy {

	@Override
	public void realizarAccion(Elemento elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, PosicionInvalidaException, FueraDeRangoException {
				
		int factor = elementoActuante.getAncho();
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		int rangoDeVisionElementoActuante=((Unidad)elementoActuante).getVision();
		
		if(distancia>rangoDeVisionElementoActuante*factor)
			throw new FueraDeRangoDeVisionException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO_DE_VISION);
	
		List<Elemento> elementosAtacados=CampoBatalla.getInstancia().obtenerElementosEnEspacio(elementoActuante.obtenerEspacio());
		
		
		ListIterator<Elemento> it = elementosAtacados.listIterator();
		Espacio espacioUnidad = elementoActuante.obtenerEspacio();
		
		while(it.hasNext()) {
			
			//Obtengo la unidad atacada
			Elemento elementoAtacado = it.next();

			//Me fijo que la posición de destino sea parte de la unidad atacada
			if(elementoAtacado.posicionEsParte(posicionDestino)) 
			{
				Espacio espacioTemporal = ((ElementoArtificial) elementoAtacado).obtenerEspacio();
				
				int danioAtaqueNum=espacioTemporal.getDanio(((Unidad) elementoAtacado).getDanio());
				int rangoAtaqueAtacante = espacioUnidad.getRangoDeAtaque(((Unidad) elementoActuante).getRangoAtaque());

				if(distancia<=rangoAtaqueAtacante*factor)
				{
					elementoAtacado.restarVitalidad(danioAtaqueNum);
					it.set(elementoAtacado);
					Juego.getInstancia().getListener().seRealizoAtaque((ElementoArtificial)elementoAtacado);
				}
				else
				{
					throw new FueraDeRangoException("La unidad está fuera del rango de ataque.");
				}
			}
		}
		
		Juego.getInstancia().getListener().seRealizoAtaque(elementoActuante);
		Juego.getInstancia().verificarFinDePartida();
	
	}			
}