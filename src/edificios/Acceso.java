package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class Acceso extends Edificio {

	public Acceso(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M");
		this.setTiempoDeConstruccion(8);
		this.setVida("500/500");
		// TODO Auto-generated constructor stub
	}

	
	public Unidad crearZealot() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, new Posicion(10, 10)));
	}
	
	public Unidad crearDragon() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.PROTOSS_DRAGON, new Posicion(10, 10)));
	}


}
