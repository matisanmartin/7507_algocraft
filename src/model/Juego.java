package model;

import java.util.Iterator;
import java.util.List;

import jugador.Jugador;
import listener.JuegoListener;

import common.Mensajes;

import exceptions.CostoInvalidoException;
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
	private static JuegoListener listener;
	
	@SuppressWarnings("static-access")
	private Juego(JuegoListener listener){
		try
		{
			this.listener = listener;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public static Juego getInstancia() {
		return INSTANCIA;
	}
	
	public static Juego crearInstancia(JuegoListener juegoListener) {
			
			if (INSTANCIA == null) {
			       INSTANCIA = new Juego(juegoListener);
			}
			return INSTANCIA;
		}
		
		//para probar
		public static void destruirInstancia(){
			INSTANCIA = null;
		}
			

	private Juego(Jugador jugadorActual, Jugador jugadorEnemigo,CampoBatalla campoDeBatalla) throws NombreJugadorRepetidoException{
		setJugadorActual(jugadorActual);
		setJugadorEnemigo(jugadorEnemigo);
//		JuegoController.setCampoDeBatalla(campoDeBatalla);
	}
	
	
	
	
	public Armada obtenerArmadaJugadorEnemigo() {
		return getJugadorEnemigo().obtenerArmada();
	}
	
	public Armada obtenerArmadaJugadorActual() {
		return getJugadorActual().obtenerArmada();
	}

	public Jugador getJugadorEnemigo() {
		return jugadorEnemigo;
	}

	public void setJugadorEnemigo(Jugador jugadorEnemigo) throws NombreJugadorRepetidoException {
		if(jugadorEnemigo.getNombre().equals(getJugadorActual().getNombre()))
			throw new NombreJugadorRepetidoException(Mensajes.MSJ_ERROR_NOMBRE_REPETIDO);
		Juego.jugadorEnemigo = jugadorEnemigo;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public void setJugadorActual(Jugador jugadorActual) {
		Juego.jugadorActual = jugadorActual;
	}
	
	public String obtenerNombreJugadorActual() {
		return getJugadorActual().getNombre();
	}
	
	public String obtenerNombreJugadorEnemigo() {
		return getJugadorEnemigo().getNombre();
	}

	public String obtenerColorJugadorActual() {
		return getJugadorActual().getColor();
	}

	public String obtenerColorJugadorEnemigo() {
		return getJugadorEnemigo().getColor();
	}
	
	private void intercambiarJugadores() throws NombreJugadorRepetidoException  {
			
		Jugador jugadorActualAntesDeCambio = getJugadorActual();
		Jugador jugadorEnemAntesDeCambio = getJugadorEnemigo();
		
		setJugadorActual(jugadorEnemAntesDeCambio);
		setJugadorEnemigo(jugadorActualAntesDeCambio);
	
	}

	private void actualizar() {
		
		getJugadorActual().actualizarUnidades();
		getJugadorEnemigo().actualizarUnidades();
		
	}
	
	public void cambiarTurno() throws NombreJugadorRepetidoException {
		getJugadorActual().actualizarRecursos();
		//getJugadorEnemigo().actualizarRecursos();
		actualizar();
		intercambiarJugadores();
	}


	public void agregarUnidadAJugadorEnemigo(Elemento elem) 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException {
		getJugadorEnemigo().agregarElemento(elem);
	
	}
	
	public void agregarUnidadAJugadorActual(Elemento elem) 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, PoblacionFaltanteException, CostoInvalidoException {
		
		int cantidadDeCristal=getJugadorActual().getCantidadDeCristal();
		int cantidadDeGas= getJugadorActual().getCantidadDeGas();
		int costoMineral = elem.getCosto().getCostoMineral();
		int costoGas = elem.getCosto().getCostoGas();
		int poblacionActual = getJugadorActual().getPoblacionActual();
		int poblacionDisponible = getJugadorActual().getPoblacionDisponible();
		int suministro = elem.getSuministro();
		
		if (poblacionActual + suministro > poblacionDisponible) {
			throw new PoblacionFaltanteException(Mensajes.MSJ_ERROR_POBLACION_FALTANTE);
		}
		
		if(cantidadDeCristal<costoMineral||cantidadDeGas<costoGas)
				throw new RecursosInsuficientesException(Mensajes.MSJ_ERROR_RECURSOS_INSUFICIENTES);
		else{
			getJugadorActual().agregarElemento(elem);
			getJugadorActual().disminuirRecursos(elem.disminuirMineral(),elem.disminuirGas());
			getJugadorActual().aumentarPoblacionActual(elem.getSuministro());
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
		
		verificarPartidaGanada();
		verificarPartidaPerdida();
		//TODO msma: a futuro agregar un tiempo limite que tire FinDePartidaException y muestre un ganador
		

	}


	private void verificarPartidaPerdida() throws PartidaPerdidaException{

		Armada armadaActual = obtenerArmadaJugadorActual();
		
		List<Elemento> unidadesActual = armadaActual.getArmada();
		
		Iterator<Elemento> it = unidadesActual.iterator();
		
		while(it.hasNext()) {
			if(it.next().getVida() > 0)
				return;		
		}

		getListener().sePerdioPartida();
		
	}


	private void verificarPartidaGanada() throws PartidaGanadaException {
		Armada armadaEnemiga = obtenerArmadaJugadorEnemigo();
		
		List<Elemento> unidadesEnemigas = armadaEnemiga.getArmada();
		
		Iterator<Elemento> it = unidadesEnemigas.iterator();
		
		while(it.hasNext()) {
			if(it.next().getVida() > 0)
				return;		
		}
		getListener().seGanoPartida();
		
	}


	public void eliminarElementoDeJugadorEnemigo(Elemento marine) throws PosicionInvalidaException, FueraDeRangoException {
		getJugadorEnemigo().disminuirPoblacionActual(marine.getSuministro());
		
		//elem.disminuirPoblacion();
		getJugadorEnemigo().eliminarElementoMuertoEnPosicion(marine.getPosicion());
		CampoBatalla.getInstancia().eliminarElementoEnPosicion(marine.getPosicion(), marine.getEspacio());
		
	}
	
	public String pruebaListener() {
		return listener.pruebaListener();
	}
	
	public JuegoListener getListener() {
		return listener;
	}
//	public void setListener(JuegoListener listener) {
//		listener=listener;
//	}
	
			 
//	public static void main(String[] args) {
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try 
//				{
//					//Ventana para ingresar nombres, color y raza
//					Jugador jugadorActual= new Jugador("pepe",TipoColor.COLOR_AMARILLO,new Terran());
//					Jugador jugadorEnemigo = new Jugador("itaka",TipoColor.COLOR_ROJO,new Protoss());
//					
//					Juego.setJugadorActual(jugadorActual);
//					Juego.setJugadorEnemigo(jugadorEnemigo);
//					
////					//Se setean las bases
//					CampoBatalla.setUpBases();
//
//					//Se setean los centros de comando
//					CampoBatalla.setUpCentros();
//
//					//Se setea el comienzo de los turnos
//					Timer tiempoDeTurno = new Timer();
//					TimerCambioDeTurno cambioDeTurno= new TimerCambioDeTurno();
//					tiempoDeTurno.schedule(cambioDeTurno,10000, 10000);
//						
//					}
//				catch (Exception e){
//					e.printStackTrace();
//				}
//					
//			}
//		});
//	}

//	public void initialize() {
//		
//				try 
//				{
//					
//						
//				}
//				catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//					
//			}		
	}				
					