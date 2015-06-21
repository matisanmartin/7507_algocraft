package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaDragon extends Imagen {

	public VistaDragon(ObjetoPosicionable modelo) throws IOException {
		super(VistaDragon.class.getResource("/vista/imagenes/dragoon.png"), modelo);
	}
}
