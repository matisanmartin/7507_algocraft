package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaPilon extends Imagen {
	public VistaPilon(ObjetoPosicionable modelo) throws IOException {
		super(VistaPilon.class.getResource("/vista/imagenes/pilon64-64.png"), modelo);
	}

}

