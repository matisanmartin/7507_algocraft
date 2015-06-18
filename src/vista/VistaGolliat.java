package vista;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaGolliat extends Imagen {
	
	public VistaGolliat(ObjetoPosicionable modelo) throws IOException {
		super(VistaGolliat.class.getResource("/imagenes/golliat.png"), modelo);
	}

}
