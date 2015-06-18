package vista;

import java.io.IOException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaZealot extends Imagen {

	public VistaZealot(ObjetoPosicionable modelo) throws IOException {
		super(VistaZealot.class.getResource("/imagenes/zealot.png"), modelo);
		// TODO Auto-generated constructor stub
	}

}
