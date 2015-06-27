package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JOptionPane;

import model.Elemento;
import model.Juego;
import vista.VentanaPrincipal;

import command.Accion;
import common.Posicion;

import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class ControladorMouse implements MouseListener {
	
	private VentanaPrincipal ventana;
	private static Posicion posicionDestino;


	public ControladorMouse(VentanaPrincipal vp) {
		this.ventana = vp;
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		Juego juego = Juego.getInstancia();
		try {
			
			if(event.getButton() == MouseEvent.BUTTON1){
				System.out.println("click izquierdo!");
				this.ventana.limpiarPanelDeOpciones();
				Posicion pos = new Posicion(event.getX(), event.getY());				
	
				Elemento elemento = juego.getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(pos);
				Map<String, Accion> acciones = elemento.getAccionesDisponibles();
				this.ventana.agregarPanelDeOpciones(acciones);
				this.ventana.agregarInformacionDeUnidad(elemento);

				
			}
			if(event.getButton() == MouseEvent.BUTTON3){
				System.out.println("click derecho!");
				posicionDestino = new Posicion(event.getX(), event.getY());
				
			}
			

		} catch (ElementoNoEncontradoException | FueraDeRangoException | PosicionInvalidaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ventana.getFrame(), e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
			
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

	public static Posicion getPosicionDestino() {
		// TODO Auto-generated method stub
		return posicionDestino;
	}

}
