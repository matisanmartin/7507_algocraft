package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDragon extends Imagen {

	public VistaDragon(ObjetoPosicionable modelo) throws IOException {
		super(VistaDragon.class.getResource("/vista/imagenes/dragoon.png"), modelo);
	}
}
