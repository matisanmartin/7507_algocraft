package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import common.Mensajes;
import common.Posicion;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Armada {
	
	List<Elemento> elementos;
	int dimensionArmada;
	
	public Armada() {
		elementos = new ArrayList<Elemento>();
		dimensionArmada=0;
	}
	
	public Armada(List<Elemento> elem){
		elementos=elem;
		dimensionArmada=elem.size();
	}
	
	public int getDimensionArmada() {
		return elementos.size();
	}
	
	public List<Elemento> getArmada() {
		return elementos;
	}
	
	public void agregarElemento(Elemento elem) throws PosicionInvalidaException, FueraDeRangoException {
		
		CampoBatalla.getInstancia().posicionarElemento(elem, elem.obtenerEspacio());
		
		elementos.add(elem);
		dimensionArmada=elementos.size();
	}
	
	//TODO msma: Falta contemplar el caso de que dos unidades esten en la misma posicion(aerea/terrestre)
	//En el caso de eliminarElemento, que en general se usaria cuando una unidad muere, sacarlo de la lista
	//simplementa bastaria con buscar todas las ocurrencias y eliminar el que tenga
	public void eliminarElementoMuertoEnPosicion(Posicion pos) {
	//se asume que existen como mucho 2 elementos en una misma posicion
	//uno en aire y otro en tierra
		
		Iterator<Elemento> it = elementos.iterator();
		int indice = 0;
		int i=0;
		
	
		while(it.hasNext())
		{	
			Elemento actual = it.next();
			
			if(actual.getPosicion().equals(pos)&&actual.estaMuerta())
				indice=i;
			i++;
		}
		
		elementos.remove(indice);
		
		dimensionArmada=elementos.size();
	}
	
	public Elemento obtenerElementoEnPosicion(Posicion pos) throws ElementoNoEncontradoException {
		
		Iterator<Elemento> it = elementos.iterator();
		
		while(it.hasNext())
		{
			Elemento actual = it.next();
			if(pos.equals(actual.getPosicion()))
				return actual;
			else
			{
				ArrayList<Parte> partesActuales = actual.getPartes();
				for (Parte unaParte : partesActuales) {
					if (unaParte.posicionEsParte(pos)){
						return actual;
					}
				}
			}
			
//			boolean esParte = partesActuales.posicionEsParte(pos);
//			if(actual.getPosicion().equals(pos))
//				return actual;
		}

		throw new ElementoNoEncontradoException(Mensajes.MSJ_ERROR_ELEMENTO_NO_ENCONTRADO);
		
		
		
		
//		Iterator<ElementoArtificial> it = elementos.iterator();
//		
//		while(it.hasNext())
//		{
//			ElementoArtificial actual = it.next();
//			if(actual.getPosicion().equals(pos))
//				return actual;
//		}
//
//		throw new ElementoNoEncontradoException();
	}
	
	public void removerElementoEnPosicion(Posicion pos) {
		
			Iterator<Elemento> it = elementos.iterator();
			int indice = 0;
			
			while(it.hasNext()){
				Elemento actual = it.next();
				
				if(actual.getPosicion().equals(pos)){
					break;
				}
				indice++;
				
			}
			elementos.remove(indice);
			try {
				CampoBatalla.getInstancia().eliminarElementoEnPosicion(pos, CampoBatalla.getInstancia().getEspacioTerrestre());
			} catch (PosicionInvalidaException | FueraDeRangoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		
}

	public void modificarElementoEnPosicion(Posicion posicionDestino, Elemento elementoAtacado) {

		ListIterator<Elemento> it = elementos.listIterator();
		while(it.hasNext())
		{
			Elemento elementoTemporal = it.next();
			Posicion posicionActual=elementoTemporal.getPosicion();
			
			if(posicionActual.equals(posicionDestino)){
				elementoTemporal=elementoAtacado;
				it.set(elementoTemporal);
				break;	
			}
		}
	}

	public void actualizarUnidades() {
		
		ListIterator<Elemento> it = elementos.listIterator();
		
		while(it.hasNext())
		{
			Elemento elementoTemporal = it.next();
			elementoTemporal.agregarEnergiaPorPasoDeTurno();
			elementoTemporal.agregarEscudoPorPasoDeTurno();
			it.set(elementoTemporal);
		}
		
	}
		
}
