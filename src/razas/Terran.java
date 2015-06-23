package razas;

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
	public ElementoArtificial obtenerCentroDeComandos() throws FueraDeRangoException, CostoInvalidoException,PosicionInvalidaException {
		AbstractFactory factory = new EdificioFactory();
		
		//TODO REVISAR POSICIONE
		Posicion posicionCdc = new Posicion(10,10);
		
		return factory.getEdificio(TipoEdificio.TERRAN_CENTRO_DE_COMANDO, posicionCdc);
	}
	


}
