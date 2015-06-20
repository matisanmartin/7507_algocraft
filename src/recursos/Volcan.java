package recursos;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import model.EspacioTerrestre;

public class Volcan extends Recurso {

	public Volcan(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion, new EspacioTerrestre());
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

}
