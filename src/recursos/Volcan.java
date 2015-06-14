package recursos;

import model.EspacioTerrestre;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class Volcan extends Recurso {

	public Volcan(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion, new EspacioTerrestre());
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

}
