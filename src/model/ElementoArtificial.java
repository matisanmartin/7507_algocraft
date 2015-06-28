package model;

import common.Costo;
import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadLlenaException;


public abstract class ElementoArtificial extends Elemento  {
	
//	private Map<String, Accion> accionesDisponibles;

	public ElementoArtificial(int alto, int ancho, Posicion posicion, Espacio espacio)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion,espacio);
		
	}

	public ElementoArtificial() {
		super();
		// TODO temporal
	}
	
	private Costo costo;
	
	
	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo2) {
		this.costo = costo2;
	}
	
	public void posicionar(Posicion posicionInicial) throws FueraDeRangoException, PosicionInvalidaException{
		setPosicion(new Posicion(posicionInicial.getX(),posicionInicial.getY()));	
	}
	
	
//	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException, PosicionInvalidaException {	
//		setPosicion(new Posicion(nuevaPosicion.getX(),nuevaPosicion.getY()));
//	}
	
	public void mover(Posicion posicionDestino) throws FueraDeRangoException, PosicionInvalidaException {
		int posPartidaX = this.getPosicion().getX();
		int posPartidaY = this.getPosicion().getY();
		int [] proximo = null;
		boolean sigue = true;
		while (sigue) {
			proximo = this.getProximoPunto(posPartidaX, posPartidaY, posicionDestino.getX(), posicionDestino.getY());
			posPartidaX = proximo[0];
			posPartidaY = proximo[1];
			this.setPosicion(new Posicion(posPartidaX, posPartidaY));
			if ((proximo[0] == posicionDestino.getX()) && (proximo[1] == posicionDestino.getY())){
				sigue = false;
			}


		}
		
		
	}
	
	public int[] getProximoPunto(int x,int y,int x2, int y2) {
	    int w = x2 - x;
	    int h = y2 - y;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
	    if (w<0) dx1 = -1; else if (w>0) dx1 = 1;
	    if (h<0) dy1 = -1; else if (h>0) dy1 = 1;
	    if (w<0) dx2 = -1; else if (w>0) dx2 = 1;
	    int longest = Math.abs(w);
	    int shortest = Math.abs(h);
	    if (!(longest>shortest)) {
	        longest = Math.abs(h);
	        shortest = Math.abs(w);
	        if (h<0) dy2 = -1; else if (h>0) dy2 = 1;
	        dx2 = 0;            
	    }
	    int numerator = longest >> 1;
	    numerator += shortest;
	    if (!(numerator<longest)) {
	        numerator -= longest;
	        x += dx1;
	        y += dy1;
	    } else {
	        x += dx2;
	        y += dy2;
	    }
	    int[] res = {x, y};
	    return res;
	}

	public void agregarEnergiaPorPasoDeTurno() {
		setEnergia(getEnergia()+0);
	}

	public int getEnergia() {
		return 0;
	}


	public void restarEnergiaPorAccion(int energiaNecesaria) {
		setEnergia(getEnergia()-energiaNecesaria);
		
	}

	public void agregarEscudoPorPasoDeTurno() {
		setEscudo(getEscudo()+0);
		
	}



	public abstract void agregarUnidad(Elemento unidadASubir) throws UnidadLlenaException;

	public abstract int getCantidadDeUnidadesTransportadas();
	
	public abstract int getSuministro();  

	
	public int restarPoblacion() {
		return 0;
	}
	
	public int aumentoPoblacion() { 
		return 0;
	}
	
	public int disminuirMineral() {
		return this.getCosto().getCostoMineral();
	}
	
	public int disminuirGas() {
		return this.getCosto().getCostoGas();
	}
	
	public abstract void disminuirPoblacion();
	
	






}
