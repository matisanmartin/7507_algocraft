package model;

import controller.Posicion;

public abstract class ElementoImpl implements Elemento {
	
	private Posicion posicion;
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		//TODO msma: Ac� se agregar�a la validaci�n de que la nueva posicion es valida
		// Si no se puede, tira excepcion, si se puede, 
		this.posicion = posicion;
	}
}
