package factory.unidades;

import model.Espacio;

import common.Costo;
import common.Danio;
import common.Posicion;
import common.RangoAtaque;
import common.Vitalidad;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

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
		
		if(getEscudo()+RECUPERACION_ESCUDO>200)
			setEscudo(200);
		else
			setEscudo(getEscudo()+RECUPERACION_ESCUDO);

	}
	
	public String toString() {
		StringBuffer strUnidadProtoss = new StringBuffer();
		
		strUnidadProtoss.append("<html>Unidad Seleccionada: <br>");
		strUnidadProtoss.append("Vida: "+getVida()+"<br>");
		strUnidadProtoss.append("Escudo: "+getEscudo()+"<br>");
		strUnidadProtoss.append("Posicion: ("+getPosicion().getX()+","+getPosicion().getY()+")<br></html>");
		
		return strUnidadProtoss.toString();	
	}
	
	public void recibirEmp(){
		setEscudo(0);
	}

}
