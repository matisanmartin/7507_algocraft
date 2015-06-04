package controller;

import model.CampoBatalla;

import common.Mensajes;

import exceptions.FueraDeRangoException;

public class Posicion {
	private int posX;
	private int posY;
	
	public Posicion(int posX, int posY) throws FueraDeRangoException{
		
		if( posX>CampoBatalla.getInstancia().getAncho()||posY>CampoBatalla.getInstancia().getAlto()||posX<0||posY<0)
			throw new FueraDeRangoException(Mensajes.MSJ_ERROR_FUERA_DE_RANGO);
	
		this.setPosX(posX);
		this.setPosY(posY);

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public boolean equals(Object pos){
		return (this.posX ==  ((Posicion) pos).getPosX() && this.posY == ((Posicion) pos).getPosY());
	}

	
}
