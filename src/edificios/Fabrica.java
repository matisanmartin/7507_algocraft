package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class Fabrica extends Edificio {

	public Fabrica(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("200M100G");
		this.setTiempoDeConstruccion(12);
		this.setVida("1250");
	}
	
	public Unidad crearGolliat() throws UnidadInvalidaException, FueraDeRangoException {
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, new Posicion(10,10))); //Verificar donde deberia dejar la unidad creada
	}
}
