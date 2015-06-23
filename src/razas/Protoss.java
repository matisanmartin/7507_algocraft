package razas;

import model.ElementoArtificial;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import factory.AbstractFactory;
import factory.EdificioFactory;
import factory.construcciones.TipoEdificio;


public class Protoss extends Raza {

	@Override
	public ElementoArtificial obtenerCentroDeComandos() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		AbstractFactory factory = new EdificioFactory();
		
		//TODO DEFINIR POSICION
		Posicion posicionCdc = new Posicion(1,1);
		return factory.getEdificio(TipoEdificio.PROTOSS_CENTRO_COMANDO,posicionCdc);
	}


}
