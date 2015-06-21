package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaCristal extends Imagen {
	public VistaCristal(ObjetoPosicionable modelo) throws IOException {
		super(VistaCristal.class.getResource("/vista/imagenes/cristal65-65.png"), modelo);
	}

}

