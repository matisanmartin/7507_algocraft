package factory.unidades;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import model.ElementoArtificial;
import model.Espacio;
import strategy.ContextoStrategy;
import command.Accion;
import command.AtaqueAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public class Unidad extends ElementoArtificial {

	private int transporte;
	private int vision;
	private int tiempoConstruccion;
	private String daño;
//	private int daño;
	private int suministro;
	private String rangoAtaque;
	List<Unidad> unidadesTransportadas;


	public Unidad(int transporte, int vision, Costo costo, int tiempoConstruccion, 
			String daño, int suministro,String rangoAtaque, Vitalidad vida,int alto, int ancho, Posicion posicion, Espacio espacio) throws FueraDeRangoException {
		super(alto, ancho, posicion,espacio);
		setTransporte(transporte);
		setVision(vision);
		setCosto(costo);
		setTiempoConstruccion(tiempoConstruccion);
		setDaño(daño);
		setSuministro(suministro);
		setRangoAtaque(rangoAtaque);
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

	@Override
	public void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException {
		contexto.ejecutarStrategy(this, posicionDestino);
	}
	
	public void definirAccionesDisponibles(){
		Map<String, Accion> acciones = new Hashtable<String, Accion>();
		acciones.put("Atacar", new AtaqueAccion(this));
		setAccionesDisponibles(acciones);
	}
	
	@Override
	public void agregarUnidad(ElementoArtificial elemento) throws UnidadLlenaException {
		
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


}
