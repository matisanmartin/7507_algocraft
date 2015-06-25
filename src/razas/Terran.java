package razas;

import java.io.IOException;

import model.Elemento;
import model.ElementoArtificial;
import titiritero.dibujables.Imagen;
import vista.edificios.VistaCentroComandoTerran;

import command.Accion;
import command.CrearCentroDeMineralAccion;
import command.CrearRefineriaAccion;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import factory.AbstractFactory;
import factory.EdificioFactory;
import factory.construcciones.TipoEdificio;


public class Terran extends Raza {

	@Override
	public ElementoArtificial obtenerCentroDeComandos(Posicion pos) throws FueraDeRangoException, CostoInvalidoException,PosicionInvalidaException {
		AbstractFactory factory = new EdificioFactory();		
		return factory.getEdificio(TipoEdificio.TERRAN_CENTRO_COMANDO, pos);	
	}

	@Override
	public Imagen obtenerCentroDeComandos(ElementoArtificial elem) throws IOException {
		return new VistaCentroComandoTerran(elem);
	}
	
	@Override
	public Accion obtenerAccionRecolectorDeMinerales(Elemento elem)throws FueraDeRangoException, CostoInvalidoException,PosicionInvalidaException {
		return new CrearCentroDeMineralAccion(elem);
	}

	@Override
	public Accion obtenerAccionRecolectorDeGas(Elemento elem) throws FueraDeRangoException,CostoInvalidoException, PosicionInvalidaException {
		return new CrearRefineriaAccion(elem);
	}
	
	public String toString()
	{
		return "Terran";
	}
	


}
