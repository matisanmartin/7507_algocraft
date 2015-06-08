package model;

import java.util.List;

import common.Posicion;

import strategy.ContextoStrategy;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;


public abstract class ElementoArtificial extends Elemento {
	


	public ElementoArtificial(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		// TODO Auto-generated constructor stub
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
	
	
	public abstract void realizarAccion(ContextoStrategy contexto, List<ElementoArtificial> unidadesEnemigas) 
	throws FactoryInvalidaException,UnidadInvalidaException, FueraDeRangoException;	

}
