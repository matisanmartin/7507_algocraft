package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaZealot extends Imagen {

	public VistaZealot(ObjetoPosicionable modelo) throws IOException {
		super(VistaZealot.class.getResource("/vista/imagenes/zealot.png"), modelo);
	}

}
