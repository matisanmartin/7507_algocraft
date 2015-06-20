package model;

import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class UnidadModelo implements ObjetoPosicionable, ObjetoVivo {
	
	private Posicion posicion; 
	
	public UnidadModelo() throws FueraDeRangoException, PosicionInvalidaException {
		this.posicion = new Posicion(5, 5);
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getX() {
		return this.posicion.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.posicion.getY();
	}

}
