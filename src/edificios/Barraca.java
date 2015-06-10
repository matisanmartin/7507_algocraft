package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class Barraca extends Edificio {

	public Barraca(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M");
		this.setTiempoDeConstruccion(12);
		this.setVida("1000");
		// TODO Auto-generated constructor stub
	}

	public Unidad crearMarine() throws UnidadInvalidaException, FueraDeRangoException {
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,10))); //Verificar donde deberia dejar la unidad creada
	}


}
