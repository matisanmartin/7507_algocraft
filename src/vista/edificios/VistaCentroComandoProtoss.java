package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaCentroComandoProtoss extends Imagen {
	public VistaCentroComandoProtoss(ObjetoPosicionable modelo) throws IOException {
		super(VistaCentroComandoProtoss.class.getResource("/vista/imagenes/centroComandoProtoss70-70.png"), modelo);
	}

}
