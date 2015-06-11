package model;

import java.util.ArrayList;

import algocraft.Cristal;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class Base {
	
	private static final int CANTIDAD_DE_VOLCANES = 1;
	private static final int CANTIDAD_DE_CRISTALES = 6;
	private static final int VOLCAN_ALTO = 2;
	private static final int VOLCAN_ANCHO = 2;
	private static final int CRISTAL_ALTO = 2;
	private static final int CRISTAL_ANCHO = 2;
	Posicion posicion;
	ArrayList<Volcan> volcan;
	ArrayList<Cristal> cristal;

	public Base(Posicion pos) throws FueraDeRangoException {
		this.posicion = pos;
		this.volcan = new ArrayList<Volcan>();
		this.cristal = new ArrayList<Cristal>();
		for (int i = 0; i < CANTIDAD_DE_VOLCANES;i++) {
			this.volcan.add(new Volcan(VOLCAN_ALTO, VOLCAN_ANCHO, new Posicion(this.posicion.getPosX(), this.posicion.getPosY())));
		}
		for (int i = 0; i < CANTIDAD_DE_CRISTALES; i++) {
			//TODO jl:agregar metodo que detecte la posicion de los cristales a crear
			this.cristal.add(new Cristal(CRISTAL_ALTO, CRISTAL_ANCHO, new Posicion(3, 3)));
		}
	}

	public ArrayList<Volcan> getVolcan() {

		return this.volcan;
	}

	public ArrayList<Cristal> getCristales() {

		return this.cristal;
	}

}
