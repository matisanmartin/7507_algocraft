package model;

import java.io.IOException;

import recursos.Cristal;
import recursos.Volcan;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class BaseSupIzq extends Base {

	public BaseSupIzq(Posicion pos) throws FueraDeRangoException, PosicionInvalidaException {
		super(pos);
		for (int i = 0; i < CANTIDAD_DE_VOLCANES;i++) {
			Volcan nuevoVolcan = new Volcan(VOLCAN_ALTO, VOLCAN_ANCHO, new Posicion(this.posicion.getX(), this.posicion.getY()));
			this.volcan.add(nuevoVolcan);
			try {
				Juego.getInstancia().getListener().seCreoVolcan(nuevoVolcan);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		int ancho = this.getAnchoCristal();
		int alto = this.getAltoCristal();
		for (int i = 1; i <= this.getCantidadDeCristales()/2; i++) {
			Cristal cristal = new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(pos.getX(), pos.getY()+ (i*ancho)));
			this.cristal.add(cristal);
			try {
				Juego.getInstancia().getListener().seCreoCristal(cristal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cristal cristal2 = new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(pos.getX()+(i * alto), pos.getY()));
			this.cristal.add(cristal2);
			try {
				Juego.getInstancia().getListener().seCreoCristal(cristal2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}
		
}


