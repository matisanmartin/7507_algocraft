package model;

import java.util.ArrayList;

import common.Posicion;

import exceptions.FueraDeRangoException;

public abstract class Elemento {

	private Posicion posicion;
	private ArrayList<Parte> partes;

	//para probar dimension de elemento
	private int alto;
	private	int ancho;

	public void setAlto(int alto){
		this.alto = alto;
	}

	public void setAncho(int ancho){
		this.ancho = ancho;
	}

	//habria que validad el alto y el ancho
	public Elemento(int alto, int ancho, Posicion posicion) throws FueraDeRangoException {
		this.partes = new ArrayList<Parte>();
		this.alto = alto; 
		this.ancho = ancho;
		this.posicion = posicion;
		crearPartes();
	}

	private void crearPartes() throws FueraDeRangoException {
		for (int i = 0; i < this.alto; i++) {
			for (int j = 0; j < this.ancho; j++) {
				Parte parte = new Parte(new Posicion(i, j));
				this.partes.add(parte);
			}
		}
	}

	public ArrayList<Parte> getPartes(){
		return this.partes;
	}
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		//TODO msma: Acá se agregaría la validación de que la nueva posicion es valida
		// Si no se puede, tira excepcion, si se puede, 
		this.posicion = posicion;
	}

	public abstract void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException;
}
