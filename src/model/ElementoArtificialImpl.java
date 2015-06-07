package model;

import java.util.List;

import strategy.ContextoStrategy;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;


public abstract class ElementoArtificialImpl extends ElementoImpl implements ElementoArtificial {
	
	protected String costo;
	private String vida;
	
	@Override
	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	@Override
	public String getVida() {
		return vida;
	}
	
	public void setVida(String vida) {
		this.vida=vida;	
	}

	@Override
	public void posicionar(Posicion posicionInicial) throws FueraDeRangoException{
		setPosicion(new Posicion(posicionInicial.getPosX(),posicionInicial.getPosY()));
		
	}
	
	@Override
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException {	
		setPosicion(new Posicion(nuevaPosicion.getPosX(),nuevaPosicion.getPosY()));
	}

	@Override
	public void restarVida(String daño) {
		
		Long dañoNum = Long.parseLong(daño);
		
		Long vida = Long.parseLong(this.getVida());
		
		this.setVida(Long.toString(vida-dañoNum));
		
	}
	
	@Override
	public abstract void realizarAccion(ContextoStrategy contexto, List<ElementoArtificial> unidadesEnemigas) 
	throws FactoryInvalidaException,UnidadInvalidaException, FueraDeRangoException;	

}
