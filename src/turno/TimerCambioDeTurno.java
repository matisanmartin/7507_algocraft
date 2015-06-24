package turno;

import java.util.TimerTask;

import javax.swing.JOptionPane;

import vista.VentanaPrincipal;
import model.Juego;
import common.Mensajes;
import exceptions.NombreJugadorRepetidoException;


public class TimerCambioDeTurno extends TimerTask {

	@Override
	public void run() {
		//Acá se llamaria al invertirJugadores
		System.out.println("Entre al run");
		try {
			JOptionPane.showMessageDialog(null,Mensajes.MSJ_CAMBIO_DE_TURNO, Mensajes.NOMBRE_POPUP_TURNO, JOptionPane.INFORMATION_MESSAGE);
			Juego.getInstancia().cambiarTurno();
			VentanaPrincipal.agregarInformacionDeJugador();
			
		} catch (NombreJugadorRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Jugador1 = "+ Juego.getInstancia().getJugadorActual().getNombre());
		System.out.println("Jugador2 = "+ Juego.getInstancia().getJugadorEnemigo().getNombre());
		
	}

}
