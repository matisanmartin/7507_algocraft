package factory.construcciones;

import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class NexoMineral extends EdificioMineral {

	public NexoMineral(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setVitalidad(new Vitalidad(250,250));
	}
	
	@Override
	public int obtenerAumentoDeCristalPorTurno() {
		return 10;
	}

}
