package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaCentroMineral extends Imagen {
	public VistaCentroMineral(ObjetoPosicionable modelo) throws IOException {
		super(VistaCentroMineral.class.getResource("/vista/imagenes/centroMineral.png"), modelo);
	}

}


