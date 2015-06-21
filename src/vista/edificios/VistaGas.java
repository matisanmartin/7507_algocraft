package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaGas extends Imagen {
	public VistaGas(ObjetoPosicionable modelo) throws IOException {
		super(VistaGas.class.getResource("/vista/imagenes/gas112-112.png"), modelo);
	}

}
