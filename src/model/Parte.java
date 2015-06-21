package model;

import common.Posicion;

public class Parte{

	private Posicion posicion;
	
	
	public Parte(Posicion posicion)  {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public boolean posicionEsParte(Posicion pos) {

		return posicion.equals(pos);
	}
	


}
