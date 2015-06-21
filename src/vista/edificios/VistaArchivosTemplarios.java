package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaArchivosTemplarios extends Imagen {
	public VistaArchivosTemplarios(ObjetoPosicionable modelo) throws IOException {
		super(VistaArchivosTemplarios.class.getResource("/vista/imagenes/archivosTemplarios110-110.png"), modelo);
	}

}
