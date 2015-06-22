package model;

import java.io.IOException;

import recursos.Cristal;
import recursos.Volcan;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class BaseSupDer extends Base {

	public BaseSupDer(Posicion pos) throws FueraDeRangoException, PosicionInvalidaException {
		super(pos);		
		int ancho = this.getAnchoCristal();
		int alto = this.getAltoCristal();

		//crea volcan
		Volcan nuevoVolcan = new Volcan(VOLCAN_ALTO, VOLCAN_ANCHO, new Posicion(this.posicion.getX()-ancho, this.posicion.getY()));
		this.volcan.add(nuevoVolcan);
		try {
			Juego.getInstancia().getListener().seCreoVolcan(nuevoVolcan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//crea cristales
		Cristal cristal = null; 
		cristal = new Cristal(alto, ancho, new Posicion(pos.getX()-(ancho*2), pos.getY()));
		this.cristal.add(cristal);
		try {
			Juego.getInstancia().getListener().seCreoCristal(cristal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cristal = new Cristal(alto, ancho, new Posicion(pos.getX()-(ancho*3), pos.getY()));
		this.cristal.add(cristal);
		try {
			Juego.getInstancia().getListener().seCreoCristal(cristal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cristal = new Cristal(alto, ancho, new Posicion(pos.getX()-(ancho*4), pos.getY()));
		this.cristal.add(cristal);
		try {
			Juego.getInstancia().getListener().seCreoCristal(cristal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cristal = new Cristal(alto, ancho, new Posicion(pos.getX()-ancho, pos.getY()+(ancho)));
		this.cristal.add(cristal);
		try {
			Juego.getInstancia().getListener().seCreoCristal(cristal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cristal = new Cristal(alto, ancho, new Posicion(pos.getX()-ancho, pos.getY()+(ancho*2)));
		this.cristal.add(cristal);
		try {
			Juego.getInstancia().getListener().seCreoCristal(cristal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cristal = new Cristal(alto, ancho, new Posicion(pos.getX()-ancho, pos.getY()+(ancho*3)));
		this.cristal.add(cristal);
		try {
			Juego.getInstancia().getListener().seCreoCristal(cristal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}
}

