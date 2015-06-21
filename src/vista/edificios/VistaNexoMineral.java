package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaNexoMineral extends Imagen {
	public VistaNexoMineral(ObjetoPosicionable modelo) throws IOException {
		super(VistaNexoMineral.class.getResource("/vista/imagenes/nexoMineral96-96.png"), modelo);
	}

}

