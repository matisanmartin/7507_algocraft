package titiritero.dibujables;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import titiritero.modelo.ObjetoDibujable;
import titiritero.modelo.ObjetoPosicionable;
import titiritero.modelo.SuperficieDeDibujo;

import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Imagen implements ObjetoDibujable {

    private BufferedImage imagen;
    private ObjetoPosicionable posicionable;

    public Imagen(URL imagenUrl, ObjetoPosicionable posicionable) throws IOException {
    	this.posicionable = posicionable;
		this.imagen = ImageIO.read(imagenUrl);
    }
    
	public Imagen(BufferedImage imagen2, ObjetoPosicionable posicionable2) {
		this.imagen=imagen2;
		this.posicionable=posicionable2;
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(),null);
	}
	
	public ObjetoPosicionable getPosicionable() {
		return posicionable;
	}
	
	public Imagen clonar(Posicion nuevaPosicion) throws PosicionInvalidaException, FueraDeRangoException {
		
		int posX=nuevaPosicion.getX();
		int posY=nuevaPosicion.getY();
	
		
		ObjetoPosicionable posicionableNuevo = this.posicionable.clonar(nuevaPosicion);
		Imagen clon = new Imagen(this.imagen,posicionableNuevo);
		
		//clon.getPosicionable().setX(nuevaPosicion.getX());
		//clon.getPosicionable().setY(nuevaPosicion.getY());
		
		return clon;
		
	}
	
}