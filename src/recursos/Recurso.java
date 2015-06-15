package recursos;

import model.Elemento;
import model.Espacio;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Recurso extends Elemento {

	public Recurso(int alto, int ancho, Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion, espacio);
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

}
