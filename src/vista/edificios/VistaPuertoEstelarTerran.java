package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaPuertoEstelarTerran extends Imagen {
	public VistaPuertoEstelarTerran(ObjetoPosicionable modelo) throws IOException {
		super(VistaPuertoEstelarTerran.class.getResource("/vista/imagenes/puertoEstelarTerran110-110.png"), modelo);
	}

}

