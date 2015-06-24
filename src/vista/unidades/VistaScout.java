package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaScout extends Imagen {
	
	public VistaScout(ObjetoPosicionable modelo) throws IOException {
		super(VistaScout.class.getResource("/vista/imagenes/scout40-40.png"), modelo);
	}

}
