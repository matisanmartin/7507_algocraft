package razas;

import java.io.IOException;

import model.Elemento;
import model.ElementoArtificial;
import titiritero.dibujables.Imagen;

import command.Accion;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;


public abstract class Raza {
	
	public abstract ElementoArtificial obtenerCentroDeComandos(Posicion pos) throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;
	public abstract Imagen obtenerCentroDeComandos(ElementoArtificial elemento) throws IOException;
	public abstract Accion obtenerAccionRecolectorDeMinerales(Elemento elem) throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;
	public abstract Accion obtenerAccionRecolectorDeGas(Elemento elem) throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException;

}
