package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class ArchivoTemplario extends Edificio {

	public ArchivoTemplario(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M200G");
		this.setTiempoDeConstruccion(9);
		this.setVida("500/500");
	}
	
	public Unidad crearAltoTemplario() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(10, 10)));
	}

}
