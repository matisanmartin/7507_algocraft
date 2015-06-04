package model;

import controller.Posicion;
import exceptions.FueraDeRangoException;

public interface Elemento {
	
	void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException;
	void mover(Posicion nuevaPosicion) throws FueraDeRangoException;

}
