package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaAsimilador extends Imagen {

	public VistaAsimilador(ObjetoPosicionable modelo) throws IOException {
		super(VistaAsimilador.class.getResource("/vista/imagenes/asimilador122-122.png"), modelo);
	}
}