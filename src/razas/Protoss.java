package razas;

import java.io.IOException;

import model.Elemento;
import model.ElementoArtificial;
import titiritero.dibujables.Imagen;
import vista.edificios.VistaCentroComandoProtoss;

import command.Accion;
import command.CrearAsimiladorAccion;
import command.CrearNexoMineralAccion;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import factory.AbstractFactory;
import factory.EdificioFactory;
import factory.construcciones.TipoEdificio;


public class Protoss extends Raza {

	@Override
	public ElementoArtificial obtenerCentroDeComandos(Posicion pos) throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		AbstractFactory factory = new EdificioFactory();
		return factory.getEdificio(TipoEdificio.PROTOSS_CENTRO_COMANDO,pos);
	}

	@Override
	public Imagen obtenerCentroDeComandos(ElementoArtificial elemento) throws IOException {
		return new VistaCentroComandoProtoss(elemento);
	}

	@Override
	public Accion obtenerAccionRecolectorDeMinerales(Elemento elem)throws FueraDeRangoException, CostoInvalidoException,PosicionInvalidaException {
		return new CrearNexoMineralAccion(elem);
	}

	@Override
	public Accion obtenerAccionRecolectorDeGas(Elemento elem) throws FueraDeRangoException,CostoInvalidoException, PosicionInvalidaException {
		return new CrearAsimiladorAccion(elem);
	}


	public String toString() {
		return "Protoss";
	}



}
