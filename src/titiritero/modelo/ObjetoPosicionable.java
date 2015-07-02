package titiritero.modelo;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public interface ObjetoPosicionable {
	
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public ObjetoPosicionable clonar(Posicion nuevaPosicion) throws PosicionInvalidaException, FueraDeRangoException;

}