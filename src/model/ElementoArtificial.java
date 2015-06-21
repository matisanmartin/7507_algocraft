package model;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import strategy.ContextoStrategy;
import command.Accion;
import command.AtaqueAccion;
import command.MoverAccion;
import common.Costo;
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
import exceptions.RecursosFaltantesException;
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
		setPosicion(new Posicion(posicionInicial.getX(),posicionInicial.getY()));	
	}
	
	
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException, PosicionInvalidaException {	
		setPosicion(new Posicion(nuevaPosicion.getX(),nuevaPosicion.getY()));
	}

	

	
	public abstract void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino)
	throws 	FactoryInvalidaException, 
			UnidadInvalidaException, 
			FueraDeRangoException, 
			ElementoInvalidoException,
			PosicionInvalidaException, 
			ElementoNoEncontradoException, 
			FueraDeRangoDeVisionException, 
			EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException;

	public Map<String,Accion> getAccionesDisponibles() {
		return accionesDisponibles;
	}

	public void setAccionesDisponibles(Map<String,Accion> acciones) {
		this.accionesDisponibles = acciones;
	}
	
	public void definirAccionesDisponibles() {
		accionesDisponibles.put("Atacar",new AtaqueAccion(this));
		accionesDisponibles.put("Mover", new MoverAccion(this));
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
	
	public abstract int getSuministro();  

	
	public int restarPoblacion() {
		return 0;
	}
	
	public int aumentoPoblacion() { 
		return 0;
	}
	
	public int disminuirMineral() {
		return this.getCosto().getCostoMineral();
	}
	
	public int disminuirGas() {
		return this.getCosto().getCostoGas();
	}
	
	public abstract void disminuirPoblacion();
	
	






}
