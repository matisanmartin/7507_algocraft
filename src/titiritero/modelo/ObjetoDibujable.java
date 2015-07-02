package titiritero.modelo;

import titiritero.dibujables.Imagen;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;


public interface ObjetoDibujable {
	void dibujar(SuperficieDeDibujo superficieDeDibujo);
	public Imagen clonar(Posicion nuevaPosicion) throws PosicionInvalidaException, FueraDeRangoException;
	
}
