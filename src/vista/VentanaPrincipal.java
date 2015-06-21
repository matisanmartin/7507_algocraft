package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jugador.Jugador;
import jugador.TipoColor;
import listener.JuegoListener;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Juego;
import model.UnidadModelo;
import razas.Protoss;
import razas.Terran;
import titiritero.dibujables.Imagen;
import titiritero.dibujables.SuperficiePanel;
import titiritero.modelo.GameLoop;
import titiritero.modelo.SuperficieDeDibujo;
import vista.edificios.VistaAcceso;
import vista.edificios.VistaArchivosTemplarios;
import vista.edificios.VistaAsimilador;
import vista.edificios.VistaBarraca;
import vista.edificios.VistaCentroMineral;
import vista.edificios.VistaDepositoDeSuministros;
import vista.edificios.VistaFabrica;
import vista.edificios.VistaNexoMineral;
import vista.edificios.VistaPilon;
import vista.edificios.VistaPuertoEstelarProtoss;
import vista.edificios.VistaPuertoEstelarTerran;
import vista.edificios.VistaRefineria;
import vista.unidades.VistaAltoTemplario;
import vista.unidades.VistaDragon;
import vista.unidades.VistaEspectro;
import vista.unidades.VistaGolliat;
import vista.unidades.VistaMarine;
import vista.unidades.VistaNaveCiencia;
import vista.unidades.VistaNaveTransporteProtoss;
import vista.unidades.VistaNaveTransporteTerran;
import vista.unidades.VistaScout;
import vista.unidades.VistaZealot;
import command.Accion;
import common.Posicion;
import controller.ControladorMouse;
import exceptions.ColorInvalidoException;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;


public class VentanaPrincipal implements JuegoListener {

	private JFrame frame;
	private GameLoop gameLoop;
	private int tamanioCasillaX;
	private int tamanioCasillaY;
	private CampoBatalla campoBatalla;
	private Juego juego;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal windows = new VentanaPrincipal();
					windows.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws PosicionInvalidaException 
	 * @throws FueraDeRangoException 
	 */
	public VentanaPrincipal() throws FueraDeRangoException, PosicionInvalidaException {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws PosicionInvalidaException 
	 * @throws FueraDeRangoException 
	 */
	private void initialize() throws IOException, FueraDeRangoException, PosicionInvalidaException {
		//ventana principal
		frame = new JFrame("Algocraft");
		frame.setForeground(new Color(0,0,0));
		frame.setBounds(1, 1, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//		frame.setVisible(true);
		
		//boton iniciar juego
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameLoop.iniciarEjecucion();
				
			}
		});
		btnIniciar.setBounds(25, 25, 100, 25);
		frame.getContentPane().add(btnIniciar);
		
		//boto finalizar juego
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
				
			}
		});
		btnFinalizar.setBounds(135, 25, 100, 25);
		frame.getContentPane().add(btnFinalizar);
		
//		JButton botonAccion = new JButton("pruebaa");
//		botonAccion.setBounds(300, 25, 100, 25);
//		frame.getContentPane().add(botonAccion);
//		botonAccion.setFocusable(true);
	
		
		//superficie donde se dibujarn los elementos
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(25, 60, 1000, 600);
		frame.getContentPane().add(panel);
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
	

		frame.setFocusable(true);
		btnIniciar.setFocusable(false);
		btnFinalizar.setFocusable(false);
		
		Unidad unidad = null;
		UnidadFactory factory = new UnidadFactory();
		try {
			unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(50, 50));
		} catch (UnidadLlenaException | UnidadInvalidaException
				| CostoInvalidoException | DanioInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Jugador jugadorActual;
		Jugador jugadorEnemigo;
		try {
			jugadorActual = new Jugador("jugador1",TipoColor.COLOR_ROJO,new Terran());
			jugadorEnemigo = new Jugador("jugador2",TipoColor.COLOR_AZUL,new Protoss());

			Juego.getInstancia().setJugadorActual(jugadorActual);
			Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
			Juego.getInstancia().obtenerArmadaJugadorActual().agregarElemento(unidad);
		} catch (NombreCortoException | ColorInvalidoException | NombreJugadorRepetidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	

		
		
		
		this.gameLoop.agregar(unidad);
		Imagen imagenmarine = new VistaMarine(unidad);
		this.gameLoop.agregar(imagenmarine);
		
		panel.addMouseListener(new ControladorMouse(this));
		
		
	}
	
	public void agregarPanelDeOpciones(Map<String, Accion> opciones){
		Set<String> keys = opciones.keySet();
		int posX = 1100;
		int posY = 25;
		
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){
			String keyActual = it.next();
			JButton botonAccion = new JButton(keyActual);
			Accion accionActual = opciones.get(keyActual);
			botonAccion.addActionListener(new CreadorBotonDinamico(accionActual));
			botonAccion.setBounds(posX, posY, 100, 25);
			frame.getContentPane().add(botonAccion);
			botonAccion.setFocusable(true);
			posY += 25;
			
		}
		
		
		
		
	}
	public Juego getJuego(){
		return this.juego;
	}
		
	public GameLoop getGameLoop() {
		return gameLoop;
	}

	public void setGameLoop(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
	}
		
//	private void dibujarCuadriculaDeTablero(JPanel panel) throws PosicionInvalidaException, FueraDeRangoException{
//		this.campoBatalla = CampoBatalla.getInstancia();
//		this.getGameLoop().agregar(campoBatalla);
//		
//		//lineas en x
//		this.tamanioCasillaX = panel.getHeight()/this.campoBatalla.getAncho();
//		Posicion.setTamanioDePosicionX(tamanioCasillaX);
//		for (int i = Constantes.POS_INICIAL_CAMPO_BATALLA; i < Constantes.ANCHO_DEFECTO; i++) {
//			Posicion posicion = new Posicion(i*tamanioCasillaX, 1);
//			Figura linea = new Cuadrado(3, panel.getHeight(), posicion);
//			this.getGameLoop().agregar(linea);
//		}
//		
//		//lineas en Y
//		this.tamanioCasillaY = panel.getWidth()/this.campoBatalla.getAlto();
//		Posicion.setTamanioDePosicionY(tamanioCasillaY);
//		for (int i = Constantes.POS_INICIAL_CAMPO_BATALLA; i < Constantes.ALTO_DEFECTO; i++) {
//			Posicion posicion = new Posicion(1, i*tamanioCasillaY);
//			Figura linea = new Cuadrado(panel.getWidth(), 3, posicion);
//			this.getGameLoop().agregar(linea);
//		}
//	}

	@Override
	public String pruebaListener() {
		return "pruebaListener()";
	}

	@Override
	public void seCreoMarine(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaMarine(modelo);
		this.getGameLoop().agregar(imagen);	
	}

	@Override
	public void seCreoGolliat(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaGolliat(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoEspectro(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaEspectro(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoNaveCiencia(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaNaveCiencia(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoNaveTransporteTerran(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaNaveTransporteTerran(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoZealot(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaZealot(modelo);
		this.getGameLoop().agregar(imagen);
		
	}

	@Override
	public void seCreoDragon(ElementoArtificial elemento)  throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaDragon(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoScout(ElementoArtificial elemento)  throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaScout(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoAltoTemplario(ElementoArtificial elemento)  throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaAltoTemplario(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoNaveTransporteProtoss(ElementoArtificial elemento)  throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaNaveTransporteProtoss(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoCentroMineral(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException  {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaCentroMineral(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoBarraca(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaBarraca(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoDepositoDeSuministro(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaDepositoDeSuministros(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoRefineria(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaRefineria(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoFabrica(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaFabrica(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoPuertoEstelarTerran(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaPuertoEstelarTerran(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoNexoMineral(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaNexoMineral(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoPilon(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaPilon(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoAsimilador(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaAsimilador(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoAcceso(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaAcceso(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoPuertoEstelarProtoss(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaPuertoEstelarProtoss(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seCreoArchivosTemplarios(ElementoArtificial elemento)throws FueraDeRangoException, PosicionInvalidaException, IOException {
		final UnidadModelo modelo = new UnidadModelo();
		this.getGameLoop().agregar(modelo);
		Imagen imagen = new VistaArchivosTemplarios(modelo);
		this.getGameLoop().agregar(imagen);	
		
	}

	@Override
	public void seMovioUnidad(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoAtaque(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoEmp(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoRadiacion(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoTormentaPsionica(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoAlucinacion(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seMurioUnaUnidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comenzoJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminojuego() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void seCreoCopiaFicticia(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

}

