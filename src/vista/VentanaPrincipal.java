package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.CampoBatalla;

import common.Constantes;
import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.Figura;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;


public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;
	private int tamanioCasillaX;
	private int tamanioCasillaY;
	private CampoBatalla campoBatalla;
	
		public static void main(String[] args)
		{
			
			VentanaPrincipal window;
			try {
				window = new VentanaPrincipal();
				window.gameLoop.iniciarEjecucion();
			} catch (FueraDeRangoException | PosicionInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			frame = new JFrame();
			frame.setForeground(new Color(0,0,0));
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);
			
			JButton btnIniciar = new JButton("Iniciar");
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					gameLoop.iniciarEjecucion();
				}
			});
			btnIniciar.setBounds(42, 16, 77, 25);
			frame.getContentPane().add(btnIniciar);
			
			JButton btnDetener = new JButton("Detener");
			btnDetener.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameLoop.detenerEjecucion();
				}
			});
			btnDetener.setBounds(325, 16, 92, 25);
			frame.getContentPane().add(btnDetener);
			
			JPanel panel = new SuperficiePanel();
			panel.setBackground(new Color(255, 0, 0));
			panel.setBounds(42, 53, 375, 187);
			frame.getContentPane().add(panel);
			

			
			this.gameLoop = new GameLoop(200, (SuperficieDeDibujo) panel);
		
			frame.setFocusable(true);
			btnDetener.setFocusable(false);
			btnIniciar.setFocusable(false);
			this.dibujarCuadriculaDeTablero(panel);
			
			//zealot
//			final UnidadModelo modelo = new UnidadModelo();
//			this.gameLoop.agregar(modelo);
//			Imagen imagen = new VistaZealot(modelo);
//			this.gameLoop.agregar(imagen);
//			
			
			
//			Circulo circulo = new VistaObjetoMultiforma(modelo);
//			this.gameLoop.agregar(circulo);
//			
//			ObjetoMultiforma modelo2 = new ObjetoMultiforma();
//			modelo2.mutar();
//			this.gameLoop.agregar(modelo2);
//			Figura cuadrado = new Vista2ObjetoMultiforma(modelo2);
//			this.gameLoop.agregar(cuadrado);
//
//			ObjetoMultiforma modelo3 = new ObjetoMultiforma();
//			modelo3.inmutar();
//			this.gameLoop.agregar(modelo3);
//			Imagen imagen = new Vista3ObjetoMultiforma(modelo3);
//			this.gameLoop.agregar(imagen);
			
//			panel.addMouseListener(new MouseAdapter() {
//						
//				@Override
//				public void mouseClicked(MouseEvent arg0) {
//					modelo.moverA(arg0.getX(), arg0.getY());
//						
//				}});


//			frame.addKeyListener(new KeyListener(
//					) {
//				
//				@Override
//				public void keyTyped(KeyEvent arg0) {
//					System.out.println("Key pressed");
//				}
//				
//				@Override
//				public void keyReleased(KeyEvent arg0) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void keyPressed(KeyEvent arg0) {
//				
//					System.out.println("Ping");
//					
//				}  
//				 	
//			});
			
			
			
		}
		
	private void dibujarCuadriculaDeTablero(JPanel panel) throws PosicionInvalidaException, FueraDeRangoException{
		this.campoBatalla = CampoBatalla.getInstancia();
		this.gameLoop.agregar(campoBatalla);
		
		//lineas en x
		this.tamanioCasillaX = panel.getHeight()/this.campoBatalla.getAncho();
		Posicion.setTamanioDePosicionX(tamanioCasillaX);
		for (int i = Constantes.POS_INICIAL_CAMPO_BATALLA; i < Constantes.ANCHO_DEFECTO; i++) {
			Posicion posicion = new Posicion(i*tamanioCasillaX, 1);
			Figura linea = new Cuadrado(3, panel.getHeight(), posicion);
			this.gameLoop.agregar(linea);
		}
		
		//lineas en Y
		this.tamanioCasillaY = panel.getWidth()/this.campoBatalla.getAlto();
		Posicion.setTamanioDePosicionY(tamanioCasillaY);
		for (int i = Constantes.POS_INICIAL_CAMPO_BATALLA; i < Constantes.ALTO_DEFECTO; i++) {
			Posicion posicion = new Posicion(1, i*tamanioCasillaY);
			Figura linea = new Cuadrado(panel.getWidth(), 3, posicion);
			this.gameLoop.agregar(linea);
		}
	}

}

