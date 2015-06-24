package sonido;

import java.util.ArrayList;

public class Reproductor {

	private static final String PAQUETE_SONIDO = "sonido/";
	private static ArrayList <Sonido> sonidos;
	private static Reproductor INSTANCIA = null;
	
	private Reproductor(){
		try
		{
			sonidos = new ArrayList<Sonido>();
            this.agregarSonido("error.wav", TipoSonido.ERROR);
            this.agregarSonido("musicaFondo.wav", TipoSonido.MUSICA);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	private synchronized static void crearInstancia() {
		
		if (INSTANCIA == null) { 
	       INSTANCIA = new Reproductor();
	    }
	}
	
	public static Reproductor getInstancia() {
		
		if (INSTANCIA == null) {
			crearInstancia();
		}
		return INSTANCIA;
	}
	private void agregarSonido(String nombreArchivo, TipoSonido nombreSonido) {
		sonidos.add(new Sonido(PAQUETE_SONIDO + nombreArchivo, nombreSonido));
	}
	
	private static Sonido obtenerSonido(TipoSonido nombreSonido) {
		for (Sonido sonido : sonidos) {
			if (sonido.getNombre() == nombreSonido) {
				return sonido;
			}
		}
		return null;
	}
	public void loopSonido(TipoSonido nombreSonido) {
		obtenerSonido(nombreSonido).loop();
	}
	public void playSonido(TipoSonido nombreSonido) {
		obtenerSonido(nombreSonido).loop();
	}
}