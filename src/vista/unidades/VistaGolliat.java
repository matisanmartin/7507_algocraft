package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaGolliat extends Imagen {
	
	public VistaGolliat(ObjetoPosicionable modelo) throws IOException {
		super(VistaGolliat.class.getResource("/vista/imagenes/golliat.png"), modelo);
	}

}
