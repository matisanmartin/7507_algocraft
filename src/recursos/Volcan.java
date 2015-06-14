package recursos;

import model.Elemento;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class Volcan extends Elemento {

	public Volcan(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		// TODO Auto-generated constructor stub
	}

	public Volcan() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

}
