package factory.unidades;

import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.FueraDeRangoException;

public class UnidadProtoss extends Unidad {
	
	private static final int RECUPERACION_ESCUDO = 10;
	
	public UnidadProtoss(int transporte, int vision,
			Costo costo, int tiempoConstruccion,
			String daño, int suministro,
			String rangoAtaque, Vitalidad vida,
			int alto, int ancho, Posicion posicion) throws FueraDeRangoException {
		super(transporte, vision, costo, tiempoConstruccion, daño, suministro, rangoAtaque, vida, alto, ancho, posicion);
	}

	public void agregarEscudoPorPasoDeTurno() {
		
		setEscudo(getEscudo()+RECUPERACION_ESCUDO);
		
	}

}
