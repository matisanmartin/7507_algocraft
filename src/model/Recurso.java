package model;

import controller.Posicion;
import exceptions.FueraDeRangoException;

public class Recurso extends ElementoImpl {
	
	public Recurso(Posicion pos){
		this.setPosicion(pos);
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}
}
