package model;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;

import jugador.Jugador;
import jugador.TipoColor;
import listener.JuegoListener;
import razas.Protoss;
import razas.Terran;
import turno.TimerCambioDeTurno;
import vista.VentanaPrincipal;
import common.Mensajes;
import common.Posicion;
import exceptions.ColorInvalidoException;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import factory.construcciones.CentroComandoProtoss;
import factory.construcciones.CentroComandoTerran;

public class Juego {
	
	private static Jugador jugadorActual;
	private static Jugador jugadorEnemigo;
//	private static CampoBatalla campoDeBatalla;
	private static Juego INSTANCIA = null;
	private static JuegoListener listener;
	
	private Juego(){
		try
		{
//			jugadorActual = new Jugador();
//			jugadorEnemigo = new Jugador();	
			listener = new VentanaPrincipal();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static Juego getInstancia() {
			
			if (INSTANCIA == null) {
				crearInstancia();
			}
			return INSTANCIA;
		}
		
		//para probar
		public static void destruirInstancia(){
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
		return getInstancia().getJugadorActual().getNombre();
	}
	
	public String obtenerNombreJugadorEnemigo() {
		return getInstancia().getJugadorEnemigo().getNombre();
	}

	public String obtenerColorJugadorActual() {
		return getInstancia().getJugadorActual().getColor();
	}

	public String obtenerColorJugadorEnemigo() {
		return Juego.getInstancia().getJugadorEnemigo().getColor();
	}
	
	private void intercambiarJugadores() throws NombreJugadorRepetidoException  {
		
			
		Jugador jugadorActualAntesDeCambio = getInstancia().getJugadorActual();
		Jugador jugadorEnemAntesDeCambio = getInstancia().getJugadorEnemigo();
		
		getInstancia().setJugadorActual(jugadorEnemAntesDeCambio);
		getInstancia().setJugadorEnemigo(jugadorActualAntesDeCambio);
		
		Jugador actualDespueDe = getInstancia().getJugadorActual();
		Jugador enemDespuesDe = getInstancia().getJugadorEnemigo();
		
		
		
		
	}

	private void actualizar() {
		
		getInstancia().getJugadorActual().actualizarUnidades();
		getInstancia().getJugadorEnemigo().actualizarUnidades();
		
	}
	
	public void cambiarTurno() throws NombreJugadorRepetidoException {
		getInstancia().getJugadorActual().actualizarRecursos();
		//getInstancia().getJugadorEnemigo().actualizarRecursos();
		getInstancia().actualizar();
		getInstancia().intercambiarJugadores();
	}


	public void agregarUnidadAJugadorEnemigo(Elemento elem) 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException {
		getInstancia().getJugadorEnemigo().agregarElemento(elem);
	
	}
	
	public void agregarUnidadAJugadorActual(Elemento elem) 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, PoblacionFaltanteException, CostoInvalidoException {
		
		int cantidadDeCristal=getInstancia().getJugadorActual().getCantidadDeCristal();
		int cantidadDeGas= getInstancia().getJugadorActual().getCantidadDeGas();
		int costoMineral = elem.getCosto().getCostoMineral();
		int costoGas = elem.getCosto().getCostoGas();
		int poblacionActual = getInstancia().getJugadorActual().getPoblacionActual();
		int poblacionDisponible = getInstancia().getJugadorActual().getPoblacionDisponible();
		int suministro = elem.getSuministro();
		
		if (poblacionActual + suministro > poblacionDisponible) {
			throw new PoblacionFaltanteException(Mensajes.MSJ_ERROR_POBLACION_FALTANTE);
		}
		
		if(cantidadDeCristal<costoMineral||cantidadDeGas<costoGas)
				throw new RecursosInsuficientesException(Mensajes.MSJ_ERROR_RECURSOS_INSUFICIENTES);
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
		
		List<Elemento> unidadesActual = armadaActual.getArmada();
		
		Iterator<Elemento> it = unidadesActual.iterator();
		
		while(it.hasNext()) {
			if(!it.next().estaMuerta())
				return;		
		}

		throw new PartidaPerdidaException(Mensajes.MSJ_PARTIDA_PERDIDA);
		
	}


	private void verificarPartidaGanada() throws PartidaGanadaException {
		Armada armadaEnemiga = Juego.getInstancia().obtenerArmadaJugadorEnemigo();
		
		List<Elemento> unidadesEnemigas = armadaEnemiga.getArmada();
		
		Iterator<Elemento> it = unidadesEnemigas.iterator();
		
		while(it.hasNext()) {
			if(!it.next().estaMuerta())
				return;		
		}
		throw new PartidaGanadaException(Mensajes.MSJ_PARTIDA_GANADA);
		
	}


	public void eliminarElementoDeJugadorEnemigo(Elemento marine) throws PosicionInvalidaException, FueraDeRangoException {
		getInstancia().getJugadorEnemigo().disminuirPoblacionActual(marine.getSuministro());
		
		//elem.disminuirPoblacion();
		getInstancia().getJugadorEnemigo().eliminarElementoMuertoEnPosicion(marine.getPosicion());
		CampoBatalla.getInstancia().eliminarElementoEnPosicion(marine.getPosicion(), marine.getEspacio());
		
	}
	
	public String pruebaListener() {
		return listener.pruebaListener();
	}
	
	public JuegoListener getListener() {
		return listener;
	}
//	public void setListener(JuegoListener listener) {
//		getInstancia().listener=listener;
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
//					Juego.getInstancia().setJugadorActual(jugadorActual);
//					Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
//					
////					//Se setean las bases
//					CampoBatalla.getInstancia().setUpBases();
//
//					//Se setean los centros de comando
//					CampoBatalla.getInstancia().setUpCentros();
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

	public void initialize() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					//Ventana para ingresar nombres, color y raza
//					Jugador jugadorActual= new Jugador("pepe",TipoColor.COLOR_AMARILLO,new Terran());
//					Jugador jugadorEnemigo = new Jugador("itaka",TipoColor.COLOR_ROJO,new Protoss());
					
//					Juego.getInstancia().setJugadorActual(jugadorActual);
//					Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
					
//					//Se setean las bases
					CampoBatalla.getInstancia().setUpBases();

					//Se setean los centros de comando
					CampoBatalla.getInstancia().setUpCentros();

					//Se setea el comienzo de los turnos
					Timer tiempoDeTurno = new Timer();
					TimerCambioDeTurno cambioDeTurno= new TimerCambioDeTurno();
//					tiempoDeTurno.schedule(cambioDeTurno,10000, 10000);
					tiempoDeTurno.schedule(cambioDeTurno,25000, 25000);
						
					}
				catch (Exception e){
					e.printStackTrace();
				}
					
			}
		});
		
	}				
					
}					
					
//					//Ventana para ingresar nombres, color y raza
//					Jugador jugadorActual= new Jugador("pepe",TipoColor.COLOR_AMARILLO,new Terran());
//					Jugador jugadorEnemigo = new Jugador("itaka",TipoColor.COLOR_ROJO,new Protoss());
//					
//					Juego.getInstancia().setJugadorActual(jugadorActual);
//					Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
//					
//	
//					//Se setean las bases
//					CampoBatalla.getInstancia().setUpBases();
//					CentroComandoTerran centro = new CentroComandoTerran(70, 70, new Posicion(80, 80));
//					
//					Juego.getInstancia().getListener().seCreoCentroDeComandoTerran(centro);
//					Juego.getInstancia().agregarUnidadAJugadorActual(centro);
////					centro.morir();
////					Juego.getInstancia().obtenerArmadaJugadorActual().eliminarElementoMuertoEnPosicion( new Posicion(80, 80));
//
//					Timer tiempoDeTurno = new Timer();
//					
//					TimerCambioDeTurno cambioDeTurno= new TimerCambioDeTurno();
//					
//					//El tiempo que se pasa es en milisegundos
//					tiempoDeTurno.schedule(cambioDeTurno,5000, 5000);
					
					
					
					//si salio todo bien, pasa a la siguiente ventana
//					VentanaPrincipal ventana = (VentanaPrincipal) Juego.getInstancia().getListener();
//					ventana.getFrame().setVisible(true);
					//ventana.getGameLoop().iniciarEjecucion();
					

					
					//Se setea el mapa
					

					
//					Unidad unidad = null;
//					UnidadFactory factory = new UnidadFactory();
//					unidad = factory.
				
					//Se setean los centros de comando
					

		
		


