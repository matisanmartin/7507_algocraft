package strategy;

import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.ElementoInvalidoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class Alucinacion implements Strategy {

	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		
		//TODO sm114244: En principio estas validaciones se realizan aca, pero deberian hacerse antes
		//para elegir si se muestra o no la opci�n como v�lida para ejecutarse
		//se supone que si el metodo llega a ejecutarse, es porque se puede
		String vida = elementoActuante.getVida();
		int vidaNum = Integer.parseInt(vida);
		if(vidaNum<100)
			throw new EnergiaInsuficienteException();
		
		String distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		Long distanciaNum = Long.parseLong(distancia);
		
		if(distanciaNum>7)
			throw new FueraDeRangoDeVisionException();
		
		AbstractFactory factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		int posX=elementoActuante.getPosicion().getPosX();
		int posY=elementoActuante.getPosicion().getPosY();
		
		//TODO msma: podria mejorarse y que la posicion ficticia sea aleatoria en un rango acotado cerca de la unidad
		//TODO msma: Si se cambian estas posiciones, van a fallar luego los tests, ojo, repararlos!!
		Posicion posicionFicticia1 = new Posicion(posX+1,posY);
		Unidad copiaFicticia1 = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, posicionFicticia1);
	
		Posicion posicionFicticia2 = new Posicion(posX-1,posY);
		Unidad copiaFicticia2 = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, posicionFicticia2);
	
		JuegoController.getInstancia().agregarUnidadAJugadorActual(copiaFicticia1);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(copiaFicticia2);
			


	}

}