package factory.unidades;

import model.Espacio;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class UnidadProtoss extends Unidad {
	
	private static final int RECUPERACION_ESCUDO = 10;
	
	public UnidadProtoss(int transporte, int vision,
			Costo costo, int tiempoConstruccion,
			String daño, int suministro,
			String rangoAtaque, Vitalidad vida,
			int alto, int ancho, Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		super(transporte, vision, costo, tiempoConstruccion, daño, suministro, rangoAtaque, vida, alto, ancho, posicion, espacio);
	}

	public void agregarEscudoPorPasoDeTurno() {
		
		setEscudo(getEscudo()+RECUPERACION_ESCUDO);
		
	}

}
