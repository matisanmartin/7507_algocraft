package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaAcceso extends Imagen {
	public VistaAcceso(ObjetoPosicionable modelo) throws IOException {
		super(VistaAcceso.class.getResource("/vista/imagenes/acceso123-123.png"), modelo);
	}

}
