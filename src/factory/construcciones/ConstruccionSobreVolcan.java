package factory.construcciones;

import model.Volcan;
import controller.Posicion;
import exceptions.FueraDeRangoException;

public abstract class ConstruccionSobreVolcan extends Construccion {
	
	public ConstruccionSobreVolcan(Volcan volcan) {
		// TODO Auto-generated constructor stub
		this.setPosicion(volcan.getPosicion());
		
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

}
