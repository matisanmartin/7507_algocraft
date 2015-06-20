package factory.unidades;

import common.Costo;
import common.Danio;
import common.Posicion;
import common.RangoAtaque;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import model.Espacio;
import model.EspacioAereo;
import model.EspacioTerrestre;

public class UnidadProtoss extends Unidad {
	
	private static final int RECUPERACION_ESCUDO = 10;
	
	public UnidadProtoss(int transporte, int vision,
			Costo costo, int tiempoConstruccion,
			Danio danio, int suministro,
			RangoAtaque unidadZealotRangoAtaque, Vitalidad vida,
			int alto, int ancho, Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		super(transporte, vision, costo, tiempoConstruccion, danio, suministro, unidadZealotRangoAtaque, vida, alto, ancho, posicion, espacio);
	}



	public void agregarEscudoPorPasoDeTurno() {
		
		setEscudo(getEscudo()+RECUPERACION_ESCUDO);
		
	}

}
