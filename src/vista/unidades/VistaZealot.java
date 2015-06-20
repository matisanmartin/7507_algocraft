package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaZealot extends Imagen {

	public VistaZealot(ObjetoPosicionable modelo) throws IOException {
		super(VistaZealot.class.getResource("/vista/imagenes/zealot.png"), modelo);
	}

}
