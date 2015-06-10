package model;

import strategy.ContextoStrategy;
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
	


	public ElementoArtificial(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
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

}
