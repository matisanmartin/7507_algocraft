package razas;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import model.ElementoArtificial;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;


public abstract class Raza {
	
	public abstract ElementoArtificial obtenerCentroDeComandos(Posicion pos) throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;
	public abstract Imagen obtenerCentroDeComandos(ElementoArtificial elemento) throws IOException;

}
