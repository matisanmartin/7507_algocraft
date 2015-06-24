package model;

import java.util.ArrayList;

import titiritero.modelo.ObjetoPosicionable;
import titiritero.modelo.ObjetoVivo;
import common.Posicion;
import common.Vitalidad;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public abstract class Elemento implements ObjetoVivo, ObjetoPosicionable{

	private Posicion posicion;
	private ArrayList<Parte> partes;
	private Espacio espacio;



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
	
	public void setPosicion(Posicion posicionDestino) {
		int deltaX = Math.abs(this.posicion.getX() - posicionDestino.getX());
		int deltaY = Math.abs(this.posicion.getY() - posicionDestino.getY());
		
		//se mueve hacia abajo y hacia la derecha 
		if ( (posicionDestino.getX() >= this.posicion.getX() && (posicionDestino.getY() >= this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX + deltaX);
				parte.getPosicion().setPosY(parteY + deltaY); 
			}
		}
		//se mueve hacia abajo y hacia la izquierda
		if ( (posicionDestino.getX() <= this.posicion.getX() && (posicionDestino.getY() >= this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX - deltaX);
				parte.getPosicion().setPosY(parteY + deltaY); 
			}
		}
		
		//se mueve hacia arriba y hacia la derecha
		if ( (posicionDestino.getX() >= this.posicion.getX() && (posicionDestino.getY() <= this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX + deltaX);
				parte.getPosicion().setPosY(parteY - deltaY); 
			}
		}
		
		//se mueve hacia arriba y hacia la izquierda
		if ( (posicionDestino.getX() <= this.posicion.getX() && (posicionDestino.getY() <= this.posicion.getY()) ) ){
			for (Parte parte : partes) {
				int parteX = parte.getPosicion().getX();
				int parteY = parte.getPosicion().getY();
				parte.getPosicion().setPosX(parteX - deltaX);
				parte.getPosicion().setPosY(parteY - deltaY); 
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
		return getVitalidad().getVida()<=0;
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
		Juego.getInstancia().getListener().seMurioUnaUnidad(this);
		
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
		System.out.println("Clase elemento viviendo");
	}

}
