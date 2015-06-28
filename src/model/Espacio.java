package model;

import java.util.ArrayList;
import java.util.List;

import common.Danio;
import common.Mensajes;
import common.RangoAtaque;

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
			if(this.ocupanMismoEspacio(elementoParaAgregar,elemento)) throw new PosicionInvalidaException(Mensajes.MSJ_ERROR_POSICION_INVALIDA);
		} //this.espacio.add(elementoParaAgregar);
	}

	private boolean ocupanMismoEspacio(Elemento elementoParaAgregar,Elemento elemento) {
		
//		return ( (elementoParaAgregar.getPosicion().getX() >= elemento.getPosicion().getX()-1) || 
//				(elementoParaAgregar.getPosicion().getX() <= elemento.getPosicion().getX()+elemento.getAlto()) ) &&
//				( (elementoParaAgregar.getPosicion().getY() >= elemento.getPosicion().getY()-1) || 
//				(elementoParaAgregar.getPosicion().getY() <= elemento.getPosicion().getY()+elemento.getAncho()) );
//		
//		boolean res =  ( (elementoParaAgregar.getPosicion().getX() >= elemento.getPosicion().getX()-1) || 
//				(elementoParaAgregar.getPosicion().getX() <= elemento.getPosicion().getX()+elemento.getAlto()) ) &&
//				( (elementoParaAgregar.getPosicion().getY() >= elemento.getPosicion().getY()-1) || 
//				(elementoParaAgregar.getPosicion().getY() <= elemento.getPosicion().getY()+elemento.getAncho()) );
//		
//		return res;
		
//		return ( (elementoParaAgregar.getPosicion().getX() >= elemento.getPosicion().getX()) && 
//				((elementoParaAgregar.getPosicion().getX() <= (elemento.getPosicion().getX()+elemento.getAlto()-1)))&&
//				((elementoParaAgregar.getPosicion().getY() >= elemento.getPosicion().getY()) && 
//				(elementoParaAgregar.getPosicion().getY() <= elemento.getPosicion().getY()+elemento.getAncho()-1))
//				);
		
		boolean res = ( (elementoParaAgregar.getPosicion().getX() >= elemento.getPosicion().getX()) && 
				((elementoParaAgregar.getPosicion().getX() <= (elemento.getPosicion().getX()+elemento.getAncho()-1)))&&
				((elementoParaAgregar.getPosicion().getY() >= elemento.getPosicion().getY()) && 
				(elementoParaAgregar.getPosicion().getY() <= elemento.getPosicion().getY()+elemento.getAlto()-1))
				);
		
		if (!res) {
			res = ( (elementoParaAgregar.getPosicion().getX() <= elemento.getPosicion().getX()) && 
					((elementoParaAgregar.getPosicion().getX() >= (elemento.getPosicion().getX()-elemento.getAncho()+1)))&&
					((elementoParaAgregar.getPosicion().getY() <= elemento.getPosicion().getY()) && 
					(elementoParaAgregar.getPosicion().getY() >= elemento.getPosicion().getY()-elemento.getAlto()+1))
					);
		}
		

		
		return res;
		
	}
	public List<Elemento> obtenerElementosDeCampoDeBatalla() throws PosicionInvalidaException, FueraDeRangoException {
		return null;
	}
	
	public int getDanio(Danio danio) {
		return 0;
	}
	public int getRangoDeAtaque(RangoAtaque rangoAtaque) {
		return 0;
	}

}
