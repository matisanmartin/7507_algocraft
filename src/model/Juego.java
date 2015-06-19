package model;

import java.util.Iterator;
import java.util.List;

import jugador.Jugador;
import jugador.TipoColor;
import exceptions.ElementoInvalidoException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;

public class Juego {
	
	private static Jugador jugadorActual;
	private static Jugador jugadorEnemigo;
//	private static CampoBatalla campoDeBatalla;
	private static Juego INSTANCIA = null;
	
	private Juego(){
		jugadorActual = new Jugador();
		jugadorEnemigo = new Jugador();
		//campoDeBatalla=CampoBatalla.getInstancia();
	}
	
	
	public static Juego getInstancia() {
			
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
		       INSTANCIA = new Juego();
		    }
		}
	
	
	private Juego(Jugador jugadorActual, Jugador jugadorEnemigo,CampoBatalla campoDeBatalla) throws NombreJugadorRepetidoException{
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
//		JuegoController.getInstancia().setCampoDeBatalla(campoDeBatalla);
	}
	
	
	
	
	public Armada obtenerArmadaJugadorEnemigo() {
		return Juego.getInstancia().getJugadorEnemigo().obtenerArmada();
	}
	
	public Armada obtenerArmadaJugadorActual() {
		return getInstancia().getJugadorActual().obtenerArmada();
	}

	public Jugador getJugadorEnemigo() {
		return jugadorEnemigo;
	}

	public void setJugadorEnemigo(Jugador jugadorEnemigo) throws NombreJugadorRepetidoException {
		if(jugadorEnemigo.getNombre().equals(Juego.getInstancia().getJugadorActual().getNombre()))
			throw new NombreJugadorRepetidoException();
		Juego.jugadorEnemigo = jugadorEnemigo;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public void setJugadorActual(Jugador jugadorActual) {
		Juego.jugadorActual = jugadorActual;
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
		return Juego.getInstancia().getJugadorEnemigo().getColor();
	}
	
	private void intercambiarJugadores() throws NombreJugadorRepetidoException {
		Jugador jugadorTemp = getInstancia().getJugadorActual();
		getInstancia().setJugadorActual(jugadorEnemigo);
		getInstancia().setJugadorEnemigo(jugadorTemp);
		
		getInstancia().actualizar();
	}

	private void actualizar() {
		
		getInstancia().getJugadorActual().actualizarUnidades();
		getInstancia().getJugadorEnemigo().actualizarUnidades();
		
	}
	
	public void cambiarTurno() throws NombreJugadorRepetidoException {
		getInstancia().intercambiarJugadores();
	}


	public void agregarUnidadAJugadorEnemigo(ElementoArtificial elem) 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException {
		getInstancia().getJugadorEnemigo().agregarElemento(elem);
	
	}
	
	public void agregarUnidadAJugadorActual(ElementoArtificial elem) 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, PoblacionFaltanteException {
		
		int cantidadDeCristal=getInstancia().getJugadorActual().getCantidadDeCristal();
		int cantidadDeGas= getInstancia().getJugadorActual().getCantidadDeGas();
		int costoMineral = elem.getCosto().getCostoMineral();
		int costoGas = elem.getCosto().getCostoGas();
		int poblacionActual = getInstancia().getJugadorActual().getPoblacionActual();
		int poblacionDisponible = getInstancia().getJugadorActual().getPoblacionDisponible();
		int suministro = elem.getSuministro();
		
		if (poblacionActual + suministro > poblacionDisponible) {
			throw new PoblacionFaltanteException();
		}
		
		if(cantidadDeCristal<costoMineral||cantidadDeGas<costoGas)
				throw new RecursosInsuficientesException();
		else{
			getInstancia().getJugadorActual().agregarElemento(elem);
			getInstancia().getJugadorActual().disminuirRecursos(elem.disminuirMineral(),elem.disminuirGas());
			getInstancia().getJugadorActual().aumentarPoblacionActual(elem.getSuministro());
		}
			
	}
	
	/**
	 * Verifica que una partida sea ganada o perdida y tira la excepcion correspondiente
	 * @throws FinDePartidaException
	 * @throws PartidaGanadaException 
	 * @throws PartidaPerdidaException 
	 */
	public void verificarFinDePartida() 
	throws FinDePartidaException, PartidaGanadaException, PartidaPerdidaException {
		
		getInstancia().verificarPartidaGanada();
		getInstancia().verificarPartidaPerdida();
		//TODO msma: a futuro agregar un tiempo limite que tire FinDePartidaException y muestre un ganador
		

	}


	private void verificarPartidaPerdida() throws PartidaPerdidaException{

		Armada armadaActual = Juego.getInstancia().obtenerArmadaJugadorActual();
		
		List<ElementoArtificial> unidadesActual = armadaActual.getArmada();
		
		Iterator<ElementoArtificial> it = unidadesActual.iterator();
		
		while(it.hasNext()) {
			if(!it.next().estaMuerta())
				return;		
		}

		throw new PartidaPerdidaException();
		
	}


	private void verificarPartidaGanada() throws PartidaGanadaException {
		Armada armadaEnemiga = Juego.getInstancia().obtenerArmadaJugadorEnemigo();
		
		List<ElementoArtificial> unidadesEnemigas = armadaEnemiga.getArmada();
		
		Iterator<ElementoArtificial> it = unidadesEnemigas.iterator();
		
		while(it.hasNext()) {
			if(!it.next().estaMuerta())
				return;		
		}
		throw new PartidaGanadaException();
		
	}


	public void eliminarElementoDeJugadorEnemigo(ElementoArtificial elem) throws PosicionInvalidaException, FueraDeRangoException {
		getInstancia().getJugadorEnemigo().disminuirPoblacionActual(elem.getSuministro());
		
		//elem.disminuirPoblacion();
		getInstancia().getJugadorEnemigo().eliminarElementoMuertoEnPosicion(elem.getPosicion());
		CampoBatalla.getInstancia().eliminarElementoEnPosicion(elem.getPosicion(), elem.getEspacio());
		
	}

}
