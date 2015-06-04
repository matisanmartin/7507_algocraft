package model;

import java.util.ArrayList;
import java.util.List;

import common.Constantes;

public class CampoBatalla {
	
	private int ancho;
	private int alto;
	private List<Elemento> elementos;
	private static CampoBatalla INSTANCIA = null;

	private CampoBatalla() {
		
		setAncho(Constantes.ANCHO_DEFECTO);
		setAlto(Constantes.ALTO_DEFECTO);
		setElementos(new ArrayList<Elemento>());
	};
	
	public static CampoBatalla getInstancia() {
		
		if (INSTANCIA == null) {
			crearInstancia();
		}
		return INSTANCIA;
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
	
	public void agregarElemento(Elemento elem) {
		
		getElementos().add(elem);
	}

	public List<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	private void esZonaAerea(int posicionX, int posicionY) {
		
	}
	
	private void esZonaTerrestre(int posicionX, int posicionY) {
		
	}
	

}
