package strategy;

import juego.Juego;
import model.ElementoArtificial;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class Alucinacion implements Strategy {

	private static final int ENERGIA_NECESARIA=100;
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		
		//TODO msma: En principio estas validaciones se realizan aca, pero deberian hacerse antes
		//para elegir si se muestra o no la opción como válida para ejecutarse
		//se supone que si el metodo llega a ejecutarse, es porque se puede
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException();
		
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		//Long distanciaNum = Long.parseLong(distancia);
		
		//TODO msma: test para esta excepcion
		if(distancia>UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION)
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
	
		Juego.getInstancia().agregarUnidadAJugadorActual(copiaFicticia1);
		Juego.getInstancia().agregarUnidadAJugadorActual(copiaFicticia2);
			


	}

}
