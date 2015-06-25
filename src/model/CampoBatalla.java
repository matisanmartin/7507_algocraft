package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import titiritero.modelo.ObjetoVivo;
import common.Constantes;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;

public class CampoBatalla implements ObjetoVivo {
	
	private int ancho;
	private int alto;
	private List<Elemento> elementos;
	private EspacioTerrestre espacioTerrestre;
	private EspacioAereo espacioAereo;
	private ArrayList<Elemento> elementosABorrar;
	private static CampoBatalla INSTANCIA = null;

	private CampoBatalla() throws PosicionInvalidaException {
		
		setAncho(Constantes.ANCHO_DEFECTO);
		setAlto(Constantes.ALTO_DEFECTO);
		this.elementos = new ArrayList<Elemento>();
		this.espacioTerrestre = new EspacioTerrestre();
		this.espacioAereo = new EspacioAereo();
		this.elementosABorrar = new ArrayList<Elemento>();
	}
	
	/*
	 * POST:setea las bases en el campo
	 */
	public void setUpBases() throws PosicionInvalidaException, FueraDeRangoException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, CostoInvalidoException{
		

				
		Posicion pos = new Posicion(Constantes.POS_INICIAL_CAMPO_BATALLA, Constantes.POS_INICIAL_CAMPO_BATALLA);
		Base base1 = new BaseSupIzq(pos);
		//TODO jl:aparentemente ya lo agrega el agregarunidad 
//		this.espacioTerrestre.agregarElemento(base1.getVolcan().get(0));
		
		Juego.getInstancia().agregarUnidadAJugadorActual(base1.getVolcan().get(0));
		for (int i = 0; i < 6; i++) {
//			this.espacioTerrestre.agregarElemento(base1.getCristales().get(i));
			Juego.getInstancia().agregarUnidadAJugadorActual(base1.getCristales().get(i));
		}
		
		Base base2 = new  BaseSupDer(new Posicion(Constantes.ANCHO_DEFECTO, Constantes.POS_INICIAL_CAMPO_BATALLA));
		for (int i = 0; i < 6; i++) {
			this.espacioTerrestre.agregarElemento(base2.getCristales().get(i));
		}
		
		Base base3= new BaseInfIzq(new Posicion(Constantes.POS_INICIAL_CAMPO_BATALLA, Constantes.ALTO_DEFECTO));
		for (int i = 0; i < 6; i++) {
			this.espacioTerrestre.agregarElemento(base3.getCristales().get(i));
		}
		
		
		Base base4 = new BaseInfDer(new Posicion(Constantes.ANCHO_DEFECTO, Constantes.ALTO_DEFECTO));
//		this.espacioTerrestre.agregarElemento(base4.getVolcan().get(0));
		Juego.getInstancia().agregarUnidadAJugadorEnemigo(base4.getVolcan().get(0));
		for (int i = 0; i < 6; i++) {
//			this.espacioTerrestre.agregarElemento(base4.getCristales().get(i));
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(base4.getCristales().get(i));
		}
		

		
	
		
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
	
//	public void removerElementoEnPosicion(Posicion pos, Espacio espacio){
//		Iterator<Elemento> it = espacio.getEspacio().iterator();
//		int indice = 0;
//		
//		while(it.hasNext()){
//			Elemento actual = it.next();
//			
//			if(actual.getPosicion().equals(pos)){
//				break;
//			}
//			indice++;
//			
//		}
//		espacio.getEspacio().remove(indice);
//	}
	
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
	
	public Espacio getEspacioAereo(){
		 
		return this.espacioAereo;
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
			
			if(actual.getPosicion().equals(pos)){
				this.elementosABorrar.add(actual);
				it.remove();
			}
				
				
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

	public void setUpCentros() throws FueraDeRangoException, PosicionInvalidaException, IOException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, CostoInvalidoException {
		
		ElementoArtificial centroComandoJugadorActual = Juego.getInstancia().getJugadorActual().getRaza().obtenerCentroDeComandos(new Posicion(80,80));
		ElementoArtificial centroComandoJugadorEnemigo = Juego.getInstancia().getJugadorEnemigo().getRaza().obtenerCentroDeComandos(new Posicion(860,460));
		
		Juego.getInstancia().getListener().seCreoCentroDeComandos(centroComandoJugadorActual,Juego.getInstancia().getJugadorActual().getRaza());
		Juego.getInstancia().getListener().seCreoCentroDeComandos(centroComandoJugadorEnemigo,Juego.getInstancia().getJugadorEnemigo().getRaza());
		
		Juego.getInstancia().agregarUnidadAJugadorActual(centroComandoJugadorActual);	
		Juego.getInstancia().agregarUnidadAJugadorEnemigo(centroComandoJugadorEnemigo);
		
	}

	public ArrayList<Elemento> getElementosABorrar() {
		// TODO Auto-generated method stub
		return this.elementosABorrar;
	}


}
