package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaScout extends Imagen {
	
	public VistaScout(ObjetoPosicionable modelo) throws IOException {
		super(VistaScout.class.getResource("/imagenes/scout.png"), modelo);
	}

}
