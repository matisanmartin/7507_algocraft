package model;

import java.util.Hashtable;
import java.util.Map;

import strategy.ContextoStrategy;
import command.Accion;
import command.AtaqueAccion;
import common.Costo;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;


public abstract class ElementoArtificial extends Elemento implements Cloneable {
	
	private Map<String, Accion> accionesDisponibles;

	public ElementoArtificial(int alto, int ancho, Posicion posicion, Espacio espacio)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion,espacio);
		accionesDisponibles=new Hashtable<String,Accion>();
	}

	public ElementoArtificial() {
		super();
		// TODO temporal
	}
	
	private Costo costo;
	
	
	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo2) {
		this.costo = costo2;
	}
	
	public void posicionar(Posicion posicionInicial) throws FueraDeRangoException, PosicionInvalidaException{
		setPosicion(new Posicion(posicionInicial.getPosX(),posicionInicial.getPosY()));	
	}
	
	
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException, PosicionInvalidaException {	
		setPosicion(new Posicion(nuevaPosicion.getPosX(),nuevaPosicion.getPosY()));
	}

	

	
	public abstract void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino)
	throws 	FactoryInvalidaException, 
			UnidadInvalidaException, 
			FueraDeRangoException, 
			ElementoInvalidoException,
			PosicionInvalidaException, 
			ElementoNoEncontradoException, 
			FueraDeRangoDeVisionException, 
			EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException;

	public Map<String,Accion> getAccionesDisponibles() {
		return accionesDisponibles;
	}

	public void setAccionesDisponibles(Map<String,Accion> acciones) {
		this.accionesDisponibles = acciones;
	}
	
	public void definirAccionesDisponibles() {
		accionesDisponibles.put("Atacar",new AtaqueAccion(this));
		//TODO agregar mover
	}
	
	public void EliminarAccionDisponible(String keyAccion){
		accionesDisponibles.remove(keyAccion);
	}
	
	public void agregarAccionDisponible(String keyAccion, Accion accion) {
		accionesDisponibles.put(keyAccion, accion);
	}

	public void agregarEnergiaPorPasoDeTurno() {
		setEnergia(getEnergia()+0);
	}

	public int getEnergia() {
		return 0;
	}

	public void setEnergia(int energia) {
		return;
	}

	public void restarEnergiaPorAccion(int energiaNecesaria) {
		setEnergia(getEnergia()-energiaNecesaria);
		
	}

	public void agregarEscudoPorPasoDeTurno() {
		setEscudo(getEscudo()+0);
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		ElementoArtificial clone = (ElementoArtificial)super.clone();
		return clone;
	}

	public abstract void agregarUnidad(ElementoArtificial elementoActuante) throws UnidadLlenaException;

	public abstract int getCantidadDeUnidadesTransportadas();






}
