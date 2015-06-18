package model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import algocraft.CampoBatallaTest;
import common.Constantes;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class CampoBatalla implements ObjetoVivo {
	
	private int ancho;
	private int alto;
	private List<Elemento> elementos;
	private EspacioTerrestre espacioTerrestre;
	private EspacioAereo espacioAereo;
	private static CampoBatalla INSTANCIA = null;

	private CampoBatalla() throws PosicionInvalidaException {
		
		setAncho(Constantes.ANCHO_DEFECTO);
		setAlto(Constantes.ALTO_DEFECTO);
		this.elementos = new ArrayList<Elemento>();
		this.espacioTerrestre = new EspacioTerrestre();
		this.espacioAereo = new EspacioAereo();
	};
	
	/*
	 * POST:setea las bases en el campo
	 */
	public void setUpBases() throws PosicionInvalidaException, FueraDeRangoException{
				
		this.espacioTerrestre.agregarBase(new BaseSupIzq(new Posicion(Constantes.POS_INICIAL_CAMPO_BATALLA, Constantes.POS_INICIAL_CAMPO_BATALLA)));
		this.espacioTerrestre.agregarBase(new BaseInfIzq(new Posicion(Constantes.ALTO_DEFECTO, Constantes.POS_INICIAL_CAMPO_BATALLA)));
		this.espacioTerrestre.agregarBase(new BaseSupDer(new Posicion(Constantes.POS_INICIAL_CAMPO_BATALLA, Constantes.ANCHO_DEFECTO)));
		this.espacioTerrestre.agregarBase(new BaseInfDer(new Posicion(Constantes.ALTO_DEFECTO, Constantes.ANCHO_DEFECTO)));
	
		
	}
	public static CampoBatalla getInstancia() throws PosicionInvalidaException, FueraDeRangoException {
		
		if (INSTANCIA == null) {
			crearInstancia();
		}
		return INSTANCIA;
	}
	
	//para probar
	public static void DestruirInstancia(){
		INSTANCIA = null;
	}
	
	private synchronized static void crearInstancia() throws PosicionInvalidaException, FueraDeRangoException {
		
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

	public void posicionarElemento(Elemento elemento, Espacio espacio) throws PosicionInvalidaException, FueraDeRangoException {
		espacio.agregarElemento(elemento);
		
	}

	public void eliminarElementoEnPosicion(Posicion pos, Espacio espacio) throws PosicionInvalidaException, FueraDeRangoException {
		
		List<Elemento> elementosEnEspacio = espacio.obtenerElementosDeCampoDeBatalla();
	
		ListIterator<Elemento> it = elementosEnEspacio.listIterator();
	
		while(it.hasNext()) {	
			Elemento actual = it.next();
			
			if(actual.getPosicion().equals(pos))
				it.remove();
		}
	}

	public List<Elemento> obtenerElementosEnEspacio(Espacio espacioElementoActuante) throws PosicionInvalidaException, FueraDeRangoException {
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

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}


}
