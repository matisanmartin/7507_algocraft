package model;

import java.io.IOException;
import java.util.ArrayList;

import recursos.Cristal;
import recursos.Volcan;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public abstract class Base extends Elemento{
	
	private static final int CANTIDAD_DE_VOLCANES = 1;
	private static final int CANTIDAD_DE_CRISTALES = 6;
	private static final int VOLCAN_ALTO = 65;
	private static final int VOLCAN_ANCHO = 65;
	private static final int CRISTAL_ALTO = 65;
	private static final int CRISTAL_ANCHO = 65;
	Posicion posicion;
	ArrayList<Volcan> volcan;
	ArrayList<Cristal> cristal;

	public Base(Posicion pos) throws FueraDeRangoException, PosicionInvalidaException {
		super(0, 0, pos, new EspacioTerrestre());
		this.posicion = pos;
		this.volcan = new ArrayList<Volcan>();
		this.cristal = new ArrayList<Cristal>();
		for (int i = 0; i < CANTIDAD_DE_VOLCANES;i++) {
			Volcan nuevoVolcan = new Volcan(VOLCAN_ALTO, VOLCAN_ANCHO, new Posicion(this.posicion.getX(), this.posicion.getY()));
			this.volcan.add(nuevoVolcan);
			try {
				Juego.getInstancia().getListener().seCreoVolcan(nuevoVolcan);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Volcan> getVolcan() {

		return this.volcan;
	}

	public ArrayList<Cristal> getCristales() {

		return this.cristal;
	}
	
	public int getCantidadDeCristales(){
		return CANTIDAD_DE_CRISTALES;
	}
	
	public int getAltoCristal(){
		return CRISTAL_ALTO;
	}
	
	public int getAnchoCristal(){
		return CRISTAL_ANCHO;
	}

}
