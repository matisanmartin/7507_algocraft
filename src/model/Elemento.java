package model;

import java.util.ArrayList;

import common.Posicion;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public abstract class Elemento {

	private Posicion posicion;
	private ArrayList<Parte> partes;
	private Espacio espacio;

	//para probar dimension de elemento
	private int alto;
	private	int ancho;
	private Vitalidad vitalidad;

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
				Parte parte = new Parte(new Posicion(this.posicion.getPosX() + i, this.posicion.getPosY() + j));
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
		this.posicion = posicion;
	}

	public abstract void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException, PosicionInvalidaException;

	public Vitalidad getVitalidad() {
		return vitalidad;
	}
	
	public void restarVitalidad(int daño) {
		getVitalidad().restarVitalidad(daño);

		
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

	public void morir() {
		setVitalidad(new Vitalidad(0,0));
		
	}
	
	public void recibirEmp() {
		getVitalidad().setEscudo(0);
	}
	
	public Espacio obtenerEspacio() {
		return this.espacio;
	}
}
