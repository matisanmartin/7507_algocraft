package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.CampoBatalla;
import model.Elemento;
import titiritero.modelo.ObjetoDibujable;
import titiritero.modelo.ObservadorDeGameLoop;
import vista.VentanaPrincipal;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class ControladorCampoBatalla implements ObservadorDeGameLoop {
	
	private static Map<Elemento,ObjetoDibujable> mapaDeVistasDeElementos;
	private VentanaPrincipal ventana;
//	private static ControladorCampoBatalla INSTANCIA = null;

	public ControladorCampoBatalla(VentanaPrincipal vp) {
		mapaDeVistasDeElementos = new HashMap<Elemento, ObjetoDibujable>();
		ventana = vp;
	}
	
	public void agregarAMapaDeVistaDeElementos(Elemento elemento, ObjetoDibujable vista){
		mapaDeVistasDeElementos.put(elemento, vista);
	}
	
	public static ObjetoDibujable obtenerVista(Elemento elemento) {
		return mapaDeVistasDeElementos.get(elemento);
	}
	
//	public static ControladorCampoBatalla getInstancia(){
//		if (INSTANCIA == null){
//			crearInstancia();
//		}
//		
//		return INSTANCIA;
//	}
//	
//	private void crearInstancia(){
//		
//	}
	
	

	@Override
	public void notificarCicloFinalizado() {
		ArrayList<Elemento> elementosABorrar;
		try {
			elementosABorrar = CampoBatalla.getInstancia().getElementosABorrar();
			for (Elemento elemento : elementosABorrar) {
				ObjetoDibujable vista = mapaDeVistasDeElementos.get(elemento);
				if (vista != null){
					this.ventana.getGameLoop().remover(vista);
					mapaDeVistasDeElementos.remove(elemento);
				}
			}
		} catch (PosicionInvalidaException | FueraDeRangoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	}

	public static void set(Elemento copia, ObjetoDibujable copiaDib) {
		
		mapaDeVistasDeElementos.put(copia, copiaDib);
		
	}

}
