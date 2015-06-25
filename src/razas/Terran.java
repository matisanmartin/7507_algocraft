package razas;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import vista.edificios.VistaCentroComandoTerran;
import model.ElementoArtificial;
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
	


}
