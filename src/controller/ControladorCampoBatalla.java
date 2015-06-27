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
	
	private Map<Elemento,ObjetoDibujable> mapaDeVistasDeElementos;
	private VentanaPrincipal ventana;
//	private static ControladorCampoBatalla INSTANCIA = null;

	public ControladorCampoBatalla(VentanaPrincipal vp) {
		mapaDeVistasDeElementos = new HashMap<Elemento, ObjetoDibujable>();
		ventana = vp;
	}
	
	public void agregarAMapaDeVistaDeElementos(Elemento elemento, ObjetoDibujable vista){
		this.mapaDeVistasDeElementos.put(elemento, vista);
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
				ObjetoDibujable vista = this.mapaDeVistasDeElementos.get(elemento);
				if (vista != null){
					this.ventana.getGameLoop().remover(vista);
					this.mapaDeVistasDeElementos.remove(elemento);
				}
			}
		} catch (PosicionInvalidaException | FueraDeRangoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	}

}
