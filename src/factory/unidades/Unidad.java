package factory.unidades;

import model.ElementoImpl;
import controller.Posicion;
import exceptions.FueraDeRangoException;

public abstract class Unidad extends ElementoImpl {

	protected int transporte;
	protected int vision;
	private String costo;
	private int tiempoConstruccion;
	private String daño;
	private int suministro;
	private String rangoAtaque;
	private String vida;
	

	public Unidad(int transporte, int vision, String costo, int tiempoConstruccion, 
			          String daño, int suministro,String rangoAtaque, String unidadMarineVida) {
		
		setTransporte(transporte);
		setVision(vision);
		setCosto(costo);
		setTiempoConstruccion(tiempoConstruccion);
		setDaño(daño);
		setSuministro(suministro);
		setRangoAtaque(rangoAtaque);
		setVida(unidadMarineVida);
		
	}

	public int getTransporte() {
		return transporte;
	}
	public void setTransporte(int transporte) {
		this.transporte = transporte;
	}
	public int getVision() {
		return vision;
	}
	public void setVision(int vision) {
		this.vision = vision;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
	}

	public void setTiempoConstruccion(int tiempoConstruccion) {
		this.tiempoConstruccion = tiempoConstruccion;
	}

	public String getDaño() {
		return daño;
	}

	public void setDaño(String daño) {
		this.daño = daño;
	}

	public int getSuministro() {
		return suministro;
	}

	public void setSuministro(int suministro) {
		this.suministro = suministro;
	}

	public String getRangoAtaque() {
		return rangoAtaque;
	}

	public void setRangoAtaque(String rangoAtaque) {
		this.rangoAtaque = rangoAtaque;
	}

	public String getVida() {
		return vida;
	}

	public void setVida(String unidadMarineVida) {
		this.vida = unidadMarineVida;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public void posicionar(Posicion posicionInicial) throws FueraDeRangoException{
		posicion = new Posicion(posicionInicial.getPosX(),posicionInicial.getPosY());
		
	}
	
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException {	
		posicion = new Posicion(nuevaPosicion.getPosX(),nuevaPosicion.getPosY());
	}
	
	



}
