package vista.edificios;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaDepositoDeSuministros extends Imagen {
	public VistaDepositoDeSuministros(ObjetoPosicionable modelo) throws IOException {
		super(VistaDepositoDeSuministros.class.getResource("/vista/imagenes/depositoSuministro50-50.png"), modelo);
	}

}
