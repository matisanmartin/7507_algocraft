package model;

import controller.Posicion;

public abstract class ElementoImpl implements Elemento {
	
	private Posicion posicion;
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
}
