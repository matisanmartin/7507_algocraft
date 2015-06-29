package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import strategy.ContextoStrategy;
import titiritero.modelo.ObjetoPosicionable;
import titiritero.modelo.ObjetoVivo;

import command.Accion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public abstract class Elemento implements ObjetoVivo, ObjetoPosicionable,Cloneable{

	private Posicion posicion;
	private ArrayList<Parte> partes;
	private Espacio espacio;
	private Map<String, Accion> accionesDisponibles;
	
	//para probar dimension de elemento
	private int alto;
	private	int ancho;
	private Vitalidad vitalidad;
	
	public Espacio getEspacio() {
		return espacio;
	}

	public void setAlto(int alto){
		this.alto = alto;
	}

	public void setAncho(int ancho){
		this.ancho = ancho;
	}
	
	public int getAlto(){
		return this.alto;
	}
	
	public int getAncho(){
		return this.ancho;
	}

	//habria que validad el alto y el ancho
	public Elemento(int alto, int ancho, Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		this.partes = new ArrayList<Parte>();
		this.alto = alto; 
		this.ancho = ancho;
		this.posicion = posicion;
		this.espacio = espacio;
		crearPartes();
		accionesDisponibles=new Hashtable<String,Accion>();
	}

	public Elemento() {
		// TODO Auto-generated constructor stub
	}

	private void crearPartes() throws FueraDeRangoException, PosicionInvalidaException {
		for (int i = 0; i < this.alto; i++) {
			for (int j = 0; j < this.ancho; j++) {
				Parte parte = new Parte(new Posicion(this.posicion.getX() + i, this.posicion.getY() + j));
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

//	public void setPosicion(Posicion posicion) {
//		this.posicion = posicion;
//	}
	
//	public void setPosicion(Posicion posicionDestino) {
//		int deltaX = Math.abs(this.posicion.getX() - posicionDestino.getX());
//		int deltaY = Math.abs(this.posicion.getY() - posicionDestino.getY());
//		
//		//se mueve hacia abajo y hacia la derecha 
//		if ( (posicionDestino.getX() >= this.posicion.getX() && (posicionDestino.getY() >= this.posicion.getY()) ) ){
//			for (Parte parte : partes) {
//				int parteX = parte.getPosicion().getX();
//				int parteY = parte.getPosicion().getY();
//				parte.getPosicion().setPosX(parteX + deltaX);
//				parte.getPosicion().setPosY(parteY + deltaY); 
//			}
//		}
//		//se mueve hacia abajo y hacia la izquierda
//		if ( (posicionDestino.getX() <= this.posicion.getX() && (posicionDestino.getY() >= this.posicion.getY()) ) ){
//			for (Parte parte : partes) {
//				int parteX = parte.getPosicion().getX();
//				int parteY = parte.getPosicion().getY();
//				parte.getPosicion().setPosX(parteX - deltaX);
//				parte.getPosicion().setPosY(parteY + deltaY); 
//			}
//		}
//		
//		//se mueve hacia arriba y hacia la derecha
//		if ( (posicionDestino.getX() >= this.posicion.getX() && (posicionDestino.getY() <= this.posicion.getY()) ) ){
//			for (Parte parte : partes) {
//				int parteX = parte.getPosicion().getX();
//				int parteY = parte.getPosicion().getY();
//				parte.getPosicion().setPosX(parteX + deltaX);
//				parte.getPosicion().setPosY(parteY - deltaY); 
//			}
//		}
//		
//		//se mueve hacia arriba y hacia la izquierda
//		if ( (posicionDestino.getX() <= this.posicion.getX() && (posicionDestino.getY() <= this.posicion.getY()) ) ){
//			for (Parte parte : partes) {
//				int parteX = parte.getPosicion().getX();
//				int parteY = parte.getPosicion().getY();
//				parte.getPosicion().setPosX(parteX - deltaX);
//				parte.getPosicion().setPosY(parteY - deltaY); 
//			}
//		}
//		
//		
//		
//		this.posicion = posicionDestino;
//	}
	
	public void setPosicion(Posicion posicionDestino) throws PosicionInvalidaException, FueraDeRangoException {
		int deltaX = Math.abs(this.posicion.getX() - posicionDestino.getX());
		int deltaY = Math.abs(this.posicion.getY() - posicionDestino.getY());
		
		
		//se mueve hacia abajo y hacia la derecha 
		if ( (posicionDestino.getX() > this.posicion.getX() && (posicionDestino.getY() > this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX + deltaX);
				parte.getPosicion().setPosY(parteY + deltaY); 
			}
		}
		//se mueve hacia abajo y hacia la izquierda
		if ( (posicionDestino.getX() < this.posicion.getX() && (posicionDestino.getY() > this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX - deltaX);
				parte.getPosicion().setPosY(parteY + deltaY); 
			}
		}
		
		//se mueve hacia arriba y hacia la derecha
		if ( (posicionDestino.getX() > this.posicion.getX() && (posicionDestino.getY() < this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX + deltaX);
				parte.getPosicion().setPosY(parteY - deltaY); 
			}
		}
		
		//se mueve hacia arriba y hacia la izquierda
		if ( (posicionDestino.getX() < this.posicion.getX() && (posicionDestino.getY() < this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX - deltaX);
				parte.getPosicion().setPosY(parteY - deltaY); 
			}
		}
		
		//arriba
		if ( (posicionDestino.getX() == this.posicion.getX() && (posicionDestino.getY() < this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX);
				parte.getPosicion().setPosY(parteY - deltaY); 
			}
		}
		
		//abajo
		if ( (posicionDestino.getX() == this.posicion.getX() && (posicionDestino.getY() > this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX);
				parte.getPosicion().setPosY(parteY + deltaY); 
			}
		}
		
		//derecha
		if ( (posicionDestino.getX() > this.posicion.getX() && (posicionDestino.getY() == this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX + deltaX);
				parte.getPosicion().setPosY(parteY); 
			}
		}
		
		//izquierda
		if ( (posicionDestino.getX() < this.posicion.getX() && (posicionDestino.getY() == this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX - deltaX);
				parte.getPosicion().setPosY(parteY); 
			}
		}
		
		this.posicion = posicionDestino;
	}

	public abstract void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException, PosicionInvalidaException;

	public Vitalidad getVitalidad() {
		return vitalidad;
	}
	
	public void restarVitalidad(int danio) {
		getVitalidad().restarVitalidad(danio);

		
	}

	public void setVitalidad(Vitalidad vitalidad) {
		this.vitalidad=vitalidad;
		
	}
	
	public boolean estaMuerta() {
		return this.vitalidad.getVida() == 0;
	}

	public int getVida() {
		return getVitalidad().getVida();
	}
	
	public int getEscudo() {
		return getVitalidad().getEscudo();
	}
	
	public void setEscudo(int escudo) {
		getVitalidad().setEscudo(escudo);
	}

	public void morir() throws ElementoNoEncontradoException {
		setVitalidad(new Vitalidad(0,0));
		//Juego.getInstancia().getListener().seMurioUnaUnidad(this);
		
	}
	
	public void recibirEmp() {
		getVitalidad().setEscudo(0);
	}
	
	public Espacio obtenerEspacio() {
		return this.espacio;
	}
	
	public int getX(){
		return this.posicion.getX();
	}
	public int getY(){
		return this.posicion.getY();
	}
	
	public void vivir(){
		//System.out.println("Clase elemento viviendo");
	}

	public boolean posicionEsParte(Posicion posicionDestino) {
		
		for (Parte parteActual : partes) {
			if(posicionDestino.equals(this.getPosicion()))
				return true;
			else
			{
				if(parteActual.posicionEsParte(posicionDestino))
					return true;
			}
		}
		return false;
	}
	
	public abstract void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino)
			throws 	FactoryInvalidaException, 
					UnidadInvalidaException, 
					FueraDeRangoException, 
					ElementoInvalidoException,
					PosicionInvalidaException, 
					ElementoNoEncontradoException, 
					FueraDeRangoDeVisionException, 
					EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException;
	
	public Map<String,Accion> getAccionesDisponibles() {
		return accionesDisponibles;
	}

	public void setAccionesDisponibles(Map<String,Accion> acciones) {
		this.accionesDisponibles = acciones;
	}
	
	public void definirAccionesDisponibles() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		
	}
	
	public void eliminarAccionDisponible(String keyAccion){
		accionesDisponibles.remove(keyAccion);
	}
	
	public void agregarAccionDisponible(String keyAccion, Accion accion) {
		accionesDisponibles.put(keyAccion, accion);
	}

	public void agregarEnergiaPorPasoDeTurno() {
		
	}

	public void agregarEscudoPorPasoDeTurno() {
		
	}

	public Costo getCosto() throws CostoInvalidoException {
		return new Costo("0M0G");
	}

	public int getSuministro() {
		return 0;
	}

	public int disminuirMineral() {
		return 0;
	}

	public int disminuirGas() {
		return 0;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		ElementoArtificial clone = (ElementoArtificial)super.clone();
		return clone;
	}

	public int getEnergia() {
		return 0;
	}

	public void setEnergia(int i) {
		
	}

	public void agregarUnidad(Elemento unidadASubir) throws UnidadLlenaException, PosicionInvalidaException, FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

	public void restarEnergiaPorAccion(int energiaNecesaria) {
		// TODO Auto-generated method stub
		
	}

	public int obtenerAumentoDeCristalPorTurno() {
		return 0;
	}

	public int obtenerAumentoDeGasPorTurno() {
		return 0;
	}
	
	public abstract String toString();

}
