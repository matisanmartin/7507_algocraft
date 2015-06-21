package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaPuertoEstelarProtoss extends Imagen {
	public VistaPuertoEstelarProtoss(ObjetoPosicionable modelo) throws IOException {
		super(VistaPuertoEstelarProtoss.class.getResource("/vista/imagenes/puertoEstelarProtoss123-123.png"), modelo);
	}

}
