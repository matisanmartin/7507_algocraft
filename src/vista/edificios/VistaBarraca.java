package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaBarraca extends Imagen {
	public VistaBarraca(ObjetoPosicionable modelo) throws IOException {
		super(VistaBarraca.class.getResource("/vista/imagenes/barraca70-70.png"), modelo);
	}

}

