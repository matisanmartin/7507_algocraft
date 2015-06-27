package factory.unidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import strategy.ContextoStrategy;
import titiritero.modelo.ObjetoPosicionable;
import titiritero.modelo.ObjetoVivo;
import command.Accion;
import command.AtaqueAccion;
import command.MoverAccion;
import common.Costo;
import common.Danio;
import common.Posicion;
import common.RangoAtaque;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import model.Elemento;
import model.ElementoArtificial;
import model.Espacio;
import model.Juego;

public class Unidad extends ElementoArtificial implements ObjetoVivo, ObjetoPosicionable {

	private int transporte;
	private int vision;
	private int tiempoConstruccion;
	private Danio danio;
	private int suministro;
	private RangoAtaque rangoAtaque;
	List<Unidad> unidadesTransportadas;


	public Unidad(int transporte, int vision, Costo costo, int tiempoConstruccion, Danio danio, int suministro,RangoAtaque unidadMarineRangoAtaque, Vitalidad vida,int alto, int ancho, Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion,espacio);
		setTransporte(transporte);
		setVision(vision);
		setCosto(costo);
		setTiempoConstruccion(tiempoConstruccion);
		setDanio(danio);
		setSuministro(suministro);
		setRangoAtaque(unidadMarineRangoAtaque);
		setVitalidad(vida);
		this.definirAccionesDisponibles();
		unidadesTransportadas=new ArrayList<Unidad>();

	}

	public Unidad() {
		super();
		// TODO temporal borrar
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

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
	}

	public void setTiempoConstruccion(int tiempoConstruccion) {
		this.tiempoConstruccion = tiempoConstruccion;
	}

	public Danio getDanio() {
		return danio;
	}

	public void setDanio(Danio danio) {
		this.danio = danio;
	}

	public int getSuministro() {
		return suministro;
	}

	public void setSuministro(int suministro) {
		this.suministro = suministro;
	}

	public RangoAtaque getRangoAtaque() {
		return rangoAtaque;
	}

	public void setRangoAtaque(RangoAtaque unidadMarineRangoAtaque) {
		this.rangoAtaque = unidadMarineRangoAtaque;
	}

	@Override
	public void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino) 
	throws UnidadLlenaException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, CloneNotSupportedException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		contexto.ejecutarStrategy(this, posicionDestino);
	}
	
	@Override
	public void definirAccionesDisponibles(){
		Map<String, Accion> acciones = new Hashtable<String, Accion>();
		acciones.put("Atacar", new AtaqueAccion(this));
		acciones.put("Mover", new MoverAccion(this));
		setAccionesDisponibles(acciones);
	}
	
	@Override
	public void agregarUnidad(Elemento elemento) throws UnidadLlenaException {
		
		if(transporte==0 || capacidadLlena()){
			throw new UnidadLlenaException();
		}
		
		elemento.setPosicion(this.getPosicion());
		unidadesTransportadas.add((Unidad) elemento);
		
	}

	private boolean capacidadLlena() {
		return unidadesTransportadas.size()==transporte;
	}

	@Override
	public int getCantidadDeUnidadesTransportadas() {
		return unidadesTransportadas.size();
	}

	@Override
	public void disminuirPoblacion() {
		Juego.getInstancia().getJugadorEnemigo().disminuirPoblacionActual(this.getSuministro());
		
	}

	@Override
	public void vivir() {
		System.out.println("Estoy viviendo!!!");
		
	}

	@Override
	public int getX() {
		
		return this.getPosicion().getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.getPosicion().getY();
	}
	
	public String toString() {
		
		StringBuffer strUnidad = new StringBuffer();
		strUnidad.append("<html>Unidad Seleccionada: <br>");
		strUnidad.append("Vida: "+getVida()+"<br>");
		strUnidad.append("Posicion: ("+getPosicion().getX()+","+getPosicion().getY()+")<br></html>");
		
		return strUnidad.toString();	
	}

	
}
