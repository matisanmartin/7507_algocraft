package titiritero.dibujables;

import java.awt.Graphics;

import common.Posicion;

import titiritero.modelo.ObjetoPosicionable;
import titiritero.modelo.SuperficieDeDibujo;

public class Circulo extends Figura {

	private int radio;
	
	public Circulo(int radio, ObjetoPosicionable objetoPosicionable) {
		super(objetoPosicionable);
		this.radio = radio;
	}

	public int getRadio() {
		return this.radio;
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = ((SuperficiePanel)superfice).getBuffer();
		grafico.setColor(this.getColor());
		grafico.fillOval(getPosicionable().getX() , getPosicionable().getY(), this.radio, this.radio);
	}

	@Override
	public Imagen clonar(Posicion nuevaPosicion) {
		// TODO Auto-generated method stub
		return null;
	}
}
