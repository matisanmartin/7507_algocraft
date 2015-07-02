package strategy;

import model.Elemento;
import model.Juego;

import common.Danio;
import common.Mensajes;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.Unidad;

public class Alucinacion implements Strategy {

	private static final int ENERGIA_NECESARIA=100;
	
	@Override
	public void realizarAccion(Elemento elementoActuante, Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, ElementoNoEncontradoException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, PoblacionFaltanteException {
		
		//msma: En principio estas validaciones se realizan aca, pero deberian hacerse antes
		//para elegir si se muestra o no la opción como válida para ejecutarse
		//se supone que si el metodo llega a ejecutarse, es porque se puede
		//Todo dependerá de como decidamos elegir la interacción con el usuario
		
		int energiaActual=elementoActuante.getEnergia();
		
		if(energiaActual<ENERGIA_NECESARIA)
			throw new EnergiaInsuficienteException(Mensajes.MSJ_ERROR_ENERGIA_INSUFICIENTE);
		
		int factor = elementoActuante.getAncho();
		int distancia = posicionDestino.getDistancia(elementoActuante.getPosicion());
		
		if(distancia>UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION*factor)
			throw new FueraDeRangoDeVisionException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO_DE_VISION);
		
		int posX=posicionDestino.getX();
		int posY=posicionDestino.getY();
		
		//TODO msma: podria mejorarse y que la posicion ficticia sea aleatoria en un rango acotado cerca de la unidad
		//TODO msma: Si se cambian estas posiciones, van a fallar luego los tests, ojo, repararlos!!
		Posicion posicionFicticia1 = new Posicion(posX+5+factor,posY);
		Elemento elementoCopiado = Juego.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		Elemento copiaFicticia1 = ((Unidad)elementoCopiado).clonar(posicionFicticia1);
		copiaFicticia1.getVitalidad().setVida(0);
		Danio danioNulo = new Danio("0A0T");
		((Unidad) copiaFicticia1).setDanio(danioNulo);//TODO casteo temporal
		copiaFicticia1.setAccionesDisponibles(null);
	
		Posicion posicionFicticia2 = new Posicion(posX-5-factor,posY);
		Elemento copiaFicticia2 = ((Unidad)elementoCopiado).clonar(posicionFicticia2);
		copiaFicticia2.getVitalidad().setVida(0);	
		((Unidad) copiaFicticia2).setDanio(danioNulo);//TODO casteo temporal
		copiaFicticia2.setAccionesDisponibles(null);
	
		elementoActuante.restarEnergiaPorAccion(ENERGIA_NECESARIA);
		
		Juego.getInstancia().agregarUnidadAJugadorActual(copiaFicticia1);
		Juego.getInstancia().agregarUnidadAJugadorActual(copiaFicticia2);
		
		Juego.getInstancia().getListener().seRealizoAlucinacion(elementoCopiado,copiaFicticia1,copiaFicticia2);
		
		//Juego.getInstancia().verificarFinDePartida();

	}

}
