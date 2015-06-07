package model;

import controller.Posicion;
import exceptions.FueraDeRangoException;

public interface Elemento {
	
	public Posicion getPosicion();	
	void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException;


}
