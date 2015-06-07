package model;

import controller.Posicion;

public abstract class ElementoImpl implements Elemento {
	
	private Posicion posicion;
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		//TODO msma: Acá se agregaría la validación de que la nueva posicion es valida
		// Si no se puede, tira excepcion, si se puede, 
		this.posicion = posicion;
	}
}
