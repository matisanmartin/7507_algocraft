package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.Constantes;
import common.Posicion;

import exceptions.PosicionInvalidaException;

public class CampoBatalla {
	
	private int ancho;
	private int alto;
	private List<Elemento> elementos;
	private EspacioTerrestre espacioTerrestre;
	private EspacioAereo espacioAereo;
	private static CampoBatalla INSTANCIA = null;

	private CampoBatalla() {
		
		setAncho(Constantes.ANCHO_DEFECTO);
		setAlto(Constantes.ALTO_DEFECTO);
		this.elementos = new ArrayList<Elemento>();
		this.espacioTerrestre = new EspacioTerrestre();
		this.espacioAereo = new EspacioAereo();
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

	public List<Elemento> getElementos() {
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

	public void eliminarElementoEnPosicion(Posicion pos, List<Elemento> espacio) {
		
		Iterator<Elemento> it = espacio.iterator();
		int indice = 0;
		int i=0;
	
		while(it.hasNext())
		{	
			Elemento actual = it.next();
			
			if(actual.getPosicion().equals(pos))
				indice=i;
			i++;
		}
		
		elementos.remove(indice);

	}

	public List<Elemento> obtenerElementosEnEspacio(Espacio espacioElementoActuante) {
		return espacioElementoActuante.obtenerElementosDeCampoDeBatalla();
	}

	public List<Elemento> obtenerElementosTerrestres() {
		return espacioTerrestre.getEspacio();
	}

	public List<Elemento> obtenerElementosAereos() {
		return espacioAereo.getEspacio();
	}

	public void posicionarElementoEnEspacioAereo(Elemento elementoParaAgregar) {
		espacioAereo.getEspacio().add(elementoParaAgregar);
		
	}

	public void posicionarElementoEnEspacioTerrestre(Elemento elementoParaAgregar) {
		espacioTerrestre.getEspacio().add(elementoParaAgregar);
		
	}


}
