package strategy;

import model.Armada;
import model.Elemento;
import model.Juego;

import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;

public class Mover implements Strategy {

	@Override
	public void realizarAccion(Elemento elementoActuante,
			Posicion posicionDestino) throws FactoryInvalidaException,
			UnidadInvalidaException, FueraDeRangoException,
			ElementoInvalidoException, PosicionInvalidaException,
			ElementoNoEncontradoException, FueraDeRangoDeVisionException,
			EnergiaInsuficienteException, CostoInvalidoException,
			RecursosInsuficientesException, CloneNotSupportedException, PoblacionFaltanteException {
		
		elementoActuante.setPosicion(posicionDestino);
//		elementoActuante.moverPosicion(posicionDestino);
		Armada armada = Juego.getInstancia().getJugadorActual().obtenerArmada();
//		ElementoArtificial copia = (ElementoArtificial) elementoActuante.clone();
//		copia.setPosicion(posicionDestino);
//		
//		CampoBatalla.getInstancia().eliminarElementoEnPosicion(elementoActuante.getPosicion(), elementoActuante.obtenerEspacio());
//		
//		elementoActuante.setVitalidad(new Vitalidad(0,0));//TODO msma: esto es temporal hasta hacer un metodo que elimine de una sin necesidad de estar muerto
//		Juego.getInstancia().getJugadorActual().eliminarElementoMuertoEnPosicion(elementoActuante.getPosicion());
//		
//		//Agrego los recursos suficientes para que se le agregue la unidad copiada al jugador actual, ya que sino podria tirar excepcion
//		Juego.getInstancia().getJugadorActual().agregarCantidadDeCristal(copia.getCosto().getCostoMineral());
//		Juego.getInstancia().getJugadorActual().agregarCantidadDeGas(copia.getCosto().getCostoGas());
//		
//		Juego.getInstancia().agregarUnidadAJugadorActual(copia);
//		Juego.getInstancia().getListener().seMovioUnidad(copia);
		
//		int posicionInicialX=elementoActuante.getPosicion().getX();
//		int posicionInicialY=elementoActuante.getPosicion().getY();
//		
//		int posicionFinalX = posicionDestino.getX();
//		int posicionFinalY = posicionDestino.getY();
//		
//		//Si esta en la misma columna
//		if(posicionInicialY==posicionFinalY)
//		{
//			for(int i=posicionInicialX;i<posicionFinalX;i++)
//			{
//				elementoActuante.setPosicion(new Posicion(i+1,posicionFinalY));
//			}
//		}
//		
//		//Si esta en la misma fila
//		if(posicionInicialX==posicionFinalX)
//		{
//			for(int i = posicionInicialY; i<posicionFinalY;i++)
//			{
//				elementoActuante.setPosicion(new Posicion(posicionFinalX,i+1));
//			}
//		}
//		
//		//Si es un movimiento compuesto
//		for(int i=posicionInicialX;i<posicionFinalX;i++)
//		{
//			for(int j=posicionInicialY;j<posicionFinalY;j++)
//			{
//				Posicion nuevaPos= new Posicion(i+1,j+1);
//				elementoActuante.posicionar(nuevaPos);
//				
//				
//				
//				
//				if(j==posicionFinalY-1)//Llegue a la columna
//				{
//					elementoActuante.setPosicion(posicion);
//				}
//			}
//		}
		
	
		
	}

}
