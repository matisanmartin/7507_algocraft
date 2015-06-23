package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import jugador.Jugador;
import model.Elemento;
import model.ElementoArtificial;
import model.Juego;
import vista.VentanaPrincipal;
import command.Accion;
import common.Posicion;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class ControladorMouse implements MouseListener {
	
	private VentanaPrincipal ventana;


	public ControladorMouse(VentanaPrincipal vp) {
		this.ventana = vp;
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		Juego juego = Juego.getInstancia();
		try {
			Posicion pos = new Posicion(event.getX(), event.getY());
			Jugador jugador = juego.getJugadorActual();
			Elemento elemento = juego.getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(pos);
			Map<String, Accion> acciones = ((ElementoArtificial)elemento).getAccionesDisponibles();
			this.ventana.agregarPanelDeOpciones(acciones);
			
		} catch (ElementoNoEncontradoException | FueraDeRangoException | PosicionInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
