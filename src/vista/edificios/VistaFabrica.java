package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaFabrica extends Imagen {
	public VistaFabrica(ObjetoPosicionable modelo) throws IOException {
		super(VistaFabrica.class.getResource("/vista/imagenes/fabrica112-112.png"), modelo);
	}

}
