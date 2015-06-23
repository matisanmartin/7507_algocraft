package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaCentroComandoTerran extends Imagen {
	public VistaCentroComandoTerran(ObjetoPosicionable modelo) throws IOException {
		super(VistaCentroComandoTerran.class.getResource("/vista/imagenes/centroComandoTerran70-70.png"), modelo);
	}

}
