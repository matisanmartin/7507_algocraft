package model;

import titiritero.modelo.ObjetoPosicionable;
import titiritero.modelo.ObjetoVivo;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

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

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObjetoPosicionable clonar(Posicion nuevaPosicion)
			throws PosicionInvalidaException, FueraDeRangoException {
		// TODO Auto-generated method stub
		return null;
	}

}
