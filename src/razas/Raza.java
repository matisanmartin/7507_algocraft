package razas;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import model.ElementoArtificial;


public abstract class Raza {
	
	public abstract ElementoArtificial obtenerCentroDeComandos() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;

}
