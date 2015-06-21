package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaRefineria extends Imagen {
	public VistaRefineria(ObjetoPosicionable modelo) throws IOException {
		super(VistaRefineria.class.getResource("/vista/imagenes/refineria125-125.png"), modelo);
	}

}

