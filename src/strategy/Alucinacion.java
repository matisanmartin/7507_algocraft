package strategy;

import model.ElementoArtificial;
import common.Posicion;
import controller.JuegoController;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.Unidad;

public class Alucinacion implements Strategy {

	private static final int ENERGIA_NECESARIA=100;
	
	@Override
	public void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, ElementoNoEncontradoException, CloneNotSupportedException {
		
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
		
		int posX=elementoActuante.getPosicion().getPosX();
		int posY=elementoActuante.getPosicion().getPosY();
		
		//TODO msma: podria mejorarse y que la posicion ficticia sea aleatoria en un rango acotado cerca de la unidad
		//TODO msma: Si se cambian estas posiciones, van a fallar luego los tests, ojo, repararlos!!
		Posicion posicionFicticia1 = new Posicion(posX+1,posY);
		ElementoArtificial elementoCopiado = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		ElementoArtificial copiaFicticia1 = (ElementoArtificial) elementoCopiado.clone();
		copiaFicticia1.setPosicion(posicionFicticia1);
		copiaFicticia1.getVitalidad().setVida(0);
		((Unidad) copiaFicticia1).setDaño("0");//TODO casteo temporal
	
		Posicion posicionFicticia2 = new Posicion(posX-1,posY);
		ElementoArtificial copiaFicticia2 = (ElementoArtificial)copiaFicticia1.clone();
		copiaFicticia2.setPosicion(posicionFicticia2);
		copiaFicticia2.getVitalidad().setVida(0);	
		((Unidad) copiaFicticia2).setDaño("0");//TODO casteo temporal
	
		JuegoController.getInstancia().agregarUnidadAJugadorActual(copiaFicticia1);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(copiaFicticia2);
			

	}

}
