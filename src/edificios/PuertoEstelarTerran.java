package edificios;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class PuertoEstelarTerran extends PuertoEstelar {

	public PuertoEstelarTerran(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("1300");
		// TODO Auto-generated constructor stub
	}
	
	public Unidad crearEspectro() throws UnidadInvalidaException, FueraDeRangoException {
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO, new Posicion(10,10))); //Verificar donde deberia dejar la unidad creada
	}
	
	public Unidad crearNaveDeTransporte() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE, new Posicion(10,10)));
	}
	
	public Unidad crearNaveDeCiencia() throws UnidadInvalidaException, FueraDeRangoException{
		UnidadFactory factory = new UnidadFactory();
		return (factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(10,10)));
	}


}
