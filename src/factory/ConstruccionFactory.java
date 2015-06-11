package factory;

import common.Posicion;
import edificios.Edificio;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.TipoConstruccion;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class ConstruccionFactory extends AbstractFactory {

	public static final int ALTO=2;
	public static final int ANCHO=2;
	
	//Atributos Acceso
	public static final String 	ACCESO_COSTO = "150M";
	public static final int		ACCESO_TIEMPO_CONSTRUCCION = 8;
	public static final String 	ACCESO_VIDA = "500/500";
	
	@Override
	public Edificio getEdificio(TipoConstruccion construccionRequerida,
			Posicion posicion) {
		// TODO Aca irian todos los switchs y habria que definir todos las constantes como arriba
		return null;
	}
	
	@Override
	public Unidad getUnidad(TipoUnidad unidadRequerida, Posicion posicion)
	throws UnidadInvalidaException, FueraDeRangoException {
		return null;
	}
	
	

	
	
	

}
