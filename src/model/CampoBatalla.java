package model;

import java.util.ArrayList;

import common.Constantes;

import exceptions.PosicionInvalidaException;

public class CampoBatalla {
	
	private int ancho;
	private int alto;
	private ArrayList<Elemento> elementos;
	private Espacio espacioTerrestre;
	private Espacio espacioAereo;
	private static CampoBatalla INSTANCIA = null;

	private CampoBatalla() {
		
		setAncho(Constantes.ANCHO_DEFECTO);
		setAlto(Constantes.ALTO_DEFECTO);
		this.elementos = new ArrayList<Elemento>();
		this.espacioTerrestre = new Espacio();
		this.espacioAereo = new Espacio();
	};
	
	public static CampoBatalla getInstancia() {
		
		if (INSTANCIA == null) {
			crearInstancia();
		}
		return INSTANCIA;
	}
	
	//para probar
	public static void DestruirInstancia(){
		INSTANCIA = null;
	}
	
	private synchronized static void crearInstancia() {
		
		if (INSTANCIA == null) { 
	       INSTANCIA = new CampoBatalla();
	    }
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	//comente esto porque aparentemente esta sin uso
//	public void agregarElemento(Elemento elem) {
//		
//		getElementos().add(elem);
//	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	private void esZonaAerea(int posicionX, int posicionY) {
		
	}
	
	private void esZonaTerrestre(int posicionX, int posicionY) {
		
	}

	public Espacio getEspacioTerrestre() {
		return this.espacioTerrestre;
	}

//	public void agregarElementoTerrestre(Elemento elemento) throws PosicionInvalidaException {
//		this.espacioTerrestre.agregarElemento(elemento);
//		
//	}

	public void posicionarElemento(Elemento elemento, Espacio espacio) throws PosicionInvalidaException {
		espacio.agregarElemento(elemento);
		
	}


}
