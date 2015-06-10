package model;

import java.util.Hashtable;
import java.util.Map;

import strategy.ContextoStrategy;

import command.Accion;
import command.AtaqueAccion;
import common.Posicion;

import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;


public abstract class ElementoArtificial extends Elemento {
	
	private Map accionesDisponibles;

	public ElementoArtificial(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
	}


	public ElementoArtificial() {
		super();
		// TODO temporal
	}


	private String costo;
	private String vida;	
	
	
	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	
	public String getVida() {
		return vida;
	}
	
	public void setVida(String vida) {
		this.vida=vida;	
	}

	
	public void posicionar(Posicion posicionInicial) throws FueraDeRangoException{
		setPosicion(new Posicion(posicionInicial.getPosX(),posicionInicial.getPosY()));
		
	}
	
	
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException {	
		setPosicion(new Posicion(nuevaPosicion.getPosX(),nuevaPosicion.getPosY()));
	}

	
	public void restarVida(String daño) {
		
		Long dañoNum = Long.parseLong(daño);
		
		Long vida = Long.parseLong(this.getVida());
		
		this.setVida(Long.toString(vida-dañoNum));
		
	}
	

	public void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino)
	throws 	FactoryInvalidaException, 
			UnidadInvalidaException, 
			FueraDeRangoException, 
			ElementoInvalidoException,
			PosicionInvalidaException, 
			ElementoNoEncontradoException, 
			FueraDeRangoDeVisionException, 
			EnergiaInsuficienteException {}

	public Map getAccionesDisponibles() {
		return accionesDisponibles;
	}

	public void setAccionesDisponibles(Map acciones) {
		this.accionesDisponibles = acciones;
	}
	

	public void definirAccionesDisponibles() {
		Map<String, Accion> acciones = new Hashtable<String,Accion>();
		
		acciones.put("Atacar",new AtaqueAccion(this));
		//TODO agregar mover
		
	}
	
	public void EliminarAccionDisponible(String keyAccion){
		accionesDisponibles.remove(keyAccion);
		
	}
	
	public void agregarAccionDisponible(String keyAccion, Accion accion) {
		
		accionesDisponibles.put(keyAccion, accion);
	}

}
