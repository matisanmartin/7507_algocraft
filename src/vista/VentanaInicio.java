package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sonido.Reproductor;
import sonido.TipoSonido;
import turno.TimerCambioDeTurno;
import jugador.Jugador;
import model.CampoBatalla;
import model.Juego;
import exceptions.CampoVacioException;
import exceptions.ColorRepetidoException;
import exceptions.NombreCortoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.RazaInvalidaException;

public class VentanaInicio {

	private String nombre1;
	private String nombre2;
	private String color1,color2;
	private String raza1,raza2;
	
	public VentanaInicio(){
		
		try
		{
			JFrame frame = new JFrame("AlgoCraft");
			frame.setBounds(1,1,350,300);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
	        JPanel contentPane = new JPanel();
	        
	        JLabel labelNombre= new JLabel();
	        labelNombre.setText("Nombre");
	        contentPane.add(labelNombre);
	        labelNombre.setBounds(10,50,50,25);
	        
	        JLabel labelColor= new JLabel();
	        labelColor.setText("Color");
	        contentPane.add(labelColor);
	        labelColor.setBounds(10,110,50,25);
	        
	        JLabel labelRaza= new JLabel();
	        labelRaza.setText("Raza");
	        contentPane.add(labelRaza);
	        labelRaza.setBounds(10,80,50,25);
	        
	        JLabel labelJug1 = new JLabel();
	        labelJug1.setText("Jugador 1");
	        contentPane.add(labelJug1);
	        labelJug1.setBounds(70,20,100,25);
	       
	        final JTextField nombreJug1 = new JTextField(10);
	        contentPane.add(nombreJug1);
	        nombreJug1.setBounds(60,50,100,25);
	        
	        final JTextField razaJug1 = new JTextField(10);
	        contentPane.add(razaJug1);
	        razaJug1.setBounds(60,80,100,25);

	        final JTextField colorJug1 = new JTextField(10);
	        contentPane.add(colorJug1);
	        colorJug1.setBounds(60,110,100,25);
	        
	        JLabel labelJug2 = new JLabel();
	        labelJug2.setText("Jugador 2");
	        contentPane.add(labelJug2);
	        labelJug2.setBounds(220,20,100,25);

	        final JTextField nombreJug2 = new JTextField(10);
	        contentPane.add(nombreJug2);
	        nombreJug2.setBounds(200,50,100,25);

	        final JTextField razaJug2 = new JTextField(10);
	        contentPane.add(razaJug2);
	        razaJug2.setBounds(200,80,100,25);
	        
	        final JTextField colorJug2 = new JTextField(10);
	        contentPane.add(colorJug2);
	        colorJug2.setBounds(200,110,100,25);


	        frame.setContentPane(contentPane);
	        
			JButton botonAccion = new JButton("Comenzar");
			botonAccion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try
					{
						validarFormulario();
						
						Jugador jugador1 = new Jugador(nombre1,raza1,color1);
						Jugador jugador2 = new Jugador(nombre2,raza2,color2);
						
						VentanaPrincipal principal= new VentanaPrincipal();	
						Juego.crearInstancia(principal);
						
						Juego.getInstancia().setJugadorActual(jugador1);
						Juego.getInstancia().setJugadorEnemigo(jugador2);
						
						//Se setean las bases
						CampoBatalla.getInstancia().setUpBases();

						//Se setean los centros de comando
						CampoBatalla.getInstancia().setUpCentros();

						//Se setea el comienzo de los turnos
//						Timer tiempoDeTurno = new Timer();
//						TimerCambioDeTurno cambioDeTurno= new TimerCambioDeTurno();
//						tiempoDeTurno.schedule(cambioDeTurno,10000, 10000);
						

					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
				}
				
				private void validarFormulario() throws CampoVacioException, NombreJugadorRepetidoException, ColorRepetidoException, RazaInvalidaException, NombreCortoException {
					
					nombre1=nombreJug1.getText();
					nombre2=nombreJug2.getText();
					
					color1=colorJug1.getText();
					color2=colorJug2.getText();
					
					raza1=razaJug1.getText();
					raza2=razaJug2.getText();
					
					if(nombre1.equals("")||nombre2.equals("")||color1.equals("")||color2.equals("")||raza1.equals("")||raza2.equals(""))
						throw new CampoVacioException("Hay campos vacios.");
					
					if(nombre1.equals(nombre2))
						throw new NombreJugadorRepetidoException("Nombres repetidos.");
					
					if(nombre1.length()<4||nombre2.length()<4)
						throw new NombreCortoException("Nombre muy corto. Debe ser mayor a 4 caracteres");
					
					if(color1.equals(color2))
						throw new ColorRepetidoException("Color repetido.");
					
					if((!raza1.equalsIgnoreCase("Terran")&&!raza1.equalsIgnoreCase("Protoss"))||(!raza2.equalsIgnoreCase("Terran")&&!raza2.equalsIgnoreCase("Protoss")))
						throw new RazaInvalidaException("Raza invalida");
					
					
					
					
				}	
			});
			
			botonAccion.setBounds(125,150,100,25);
			frame.getContentPane().add(botonAccion);
			botonAccion.setFocusable(false);
			//frame.pack();
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try
				{
					VentanaInicio ventana = new VentanaInicio();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
		
}	


