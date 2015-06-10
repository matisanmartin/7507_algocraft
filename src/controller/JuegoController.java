package controller;

import java.util.Iterator;
import java.util.List;

import jugador.Jugador;
import jugador.TipoColor;
import model.Armada;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Espacio;
import exceptions.ElementoInvalidoException;
import exceptions.FinDePartidaException;
import exceptions.PosicionInvalidaException;

public class JuegoController {
	
	private static Jugador jugadorActual;
	private static Jugador jugadorEnemigo;
//	private static CampoBatalla campoDeBatalla;
	private static JuegoController INSTANCIA = null;
	
	private JuegoController(){
		jugadorActual = new Jugador();
		jugadorEnemigo = new Jugador();
		//campoDeBatalla=CampoBatalla.getInstancia();
	}
	
	
	public static JuegoController getInstancia() {
			
			if (INSTANCIA == null) {
				crearInstancia();
			}
			return INSTANCIA;
		}
		
		//para probar
		public static void DestruirInstancia(){
			INSTANCIA = null;
		}
		
		private synchronized static void crearInstancia() {
			
			if (INSTANCIA == null) { 
		       INSTANCIA = new JuegoController();
		    }
		}
	
	
	private JuegoController(Jugador jugadorActual, Jugador jugadorEnemigo,CampoBatalla campoDeBatalla){
		JuegoController.getInstancia().setJugadorActual(jugadorActual);
		JuegoController.getInstancia().setJugadorEnemigo(jugadorEnemigo);
//		JuegoController.getInstancia().setCampoDeBatalla(campoDeBatalla);
	}
	
	
	
	
	public Armada obtenerArmadaJugadorEnemigo() {
		return JuegoController.getInstancia().getJugadorEnemigo().obtenerArmada();
	}
	
	public static Armada obtenerArmadaJugadorActual() {
		return getInstancia().getJugadorActual().obtenerArmada();
	}

	public Jugador getJugadorEnemigo() {
		return jugadorEnemigo;
	}

	public void setJugadorEnemigo(Jugador jugadorEnemigo) {
		JuegoController.jugadorEnemigo = jugadorEnemigo;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public void setJugadorActual(Jugador jugadorActual) {
		JuegoController.jugadorActual = jugadorActual;
	}
	
	public String obtenerNombreJugadorActual() {
		return getInstancia().getJugadorActual().getNombre();
	}
	
	public String obtenerNombreJugadorEnemigo() {
		return getInstancia().getJugadorEnemigo().getNombre();
	}

	public TipoColor obtenerColorJugadorActual() {
		return getInstancia().getJugadorActual().getColor();
	}

	public TipoColor obtenerColorJugadorEnemigo() {
		return JuegoController.getInstancia().getJugadorEnemigo().getColor();
	}
	
	public void intercambiarJugadores() {
		Jugador jugadorTemp = getInstancia().getJugadorActual();
		getInstancia().setJugadorActual(jugadorEnemigo);
		getInstancia().setJugadorEnemigo(jugadorTemp);
	}

	public void agregarUnidadAJugadorEnemigo(ElementoArtificial elem) 
	throws ElementoInvalidoException, PosicionInvalidaException {
		
		//TODO msma: Luego verificar que el metodo posicionarElemento haya cambiado la firma
		// 				y no requera espacio
		CampoBatalla.getInstancia().posicionarElemento(elem, new Espacio());
		getInstancia().getJugadorEnemigo().agregarElemento(elem);
	
	}
	
	public void agregarUnidadAJugadorActual(ElementoArtificial elem) 
	throws ElementoInvalidoException, PosicionInvalidaException {
		
		//TODO msma: Luego verificar que el metodo posicionarElemento haya cambiado la firma
		// 				y no requera espacio
		CampoBatalla.getInstancia().posicionarElemento(elem, new Espacio());
		getInstancia().getJugadorActual().agregarElemento(elem);
	}
	
	/**
	 * Verifica que exista al menos una unidad con vida en la lista de enemigos
	 * @throws FinDePartidaException
	 */
	public void verificarFinDePartida() throws FinDePartidaException {
		Armada armadaEnemiga = JuegoController.getInstancia().getJugadorEnemigo().obtenerArmada();
		
		List<ElementoArtificial> unidadesEnemigas = armadaEnemiga.getArmada();
		Iterator<ElementoArtificial> it = unidadesEnemigas.iterator();
		
		while(it.hasNext()) {
			if(!it.next().getVida().equals("0"))
				return;		
		}
		throw new FinDePartidaException();
	}

}
