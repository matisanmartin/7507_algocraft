package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Espacio {
	List<Elemento> espacio;
	
	public List<Elemento> getEspacio(){
		return this.espacio;
	}
	public Espacio() {
		this.espacio = new ArrayList<Elemento>();
	}
	
	public int getCantidadDeElementos(){
		return (this.espacio.size());
	}
	
	
	public void agregarElemento(Elemento elementoParaAgregar) throws PosicionInvalidaException, FueraDeRangoException{
		for (Elemento elemento : espacio) {
			if(this.ocupanMismoEspacio(elementoParaAgregar,elemento)) throw new PosicionInvalidaException();
		} //this.espacio.add(elementoParaAgregar);
	}

	private boolean ocupanMismoEspacio(Elemento elementoParaAgregar,Elemento elemento) {
		
		return ( (elementoParaAgregar.getPosicion().getPosX() >= elemento.getPosicion().getPosX()-1) || 
				(elementoParaAgregar.getPosicion().getPosX() <= elemento.getPosicion().getPosX()+elemento.getAlto()) ) &&
				( (elementoParaAgregar.getPosicion().getPosY() >= elemento.getPosicion().getPosY()-1) || 
				(elementoParaAgregar.getPosicion().getPosY() <= elemento.getPosicion().getPosY()+elemento.getAncho()) );
		
		
	}
	public List<Elemento> obtenerElementosDeCampoDeBatalla() throws PosicionInvalidaException, FueraDeRangoException {
		return null;
	}

}
