package listener;

import java.io.IOException;

import razas.Raza;
import recursos.Cristal;
import model.Elemento;
import model.ElementoArtificial;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import factory.construcciones.CentroComandoProtoss;

public interface JuegoListener {
	
	//Metodo de prueba para ver si la comunicaci�n vista-modelo funciona
	public String pruebaListener();
	
	//M�todos de creacion de unidades terran
	public void seCreoMarine(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException;
	public void seCreoGolliat(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoEspectro(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoNaveCiencia(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException;
	public void seCreoNaveTransporteTerran(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de unidades protoss
	public void seCreoZealot(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoDragon(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoScout(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoAltoTemplario(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoNaveTransporteProtoss(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de edificios terran
	public void seCreoCentroMineral(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoBarraca(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoDepositoDeSuministro(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoRefineria(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoFabrica(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoPuertoEstelarTerran(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoCentroDeComandoTerran(ElementoArtificial elemento ) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de edificios protoss
	public void seCreoNexoMineral(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoPilon(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoAsimilador(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoAcceso(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoPuertoEstelarProtoss(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoArchivosTemplarios(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoCentroDeComandoProtoss(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de cristal y volcan
	public void seCreoVolcan(Elemento elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	
	//Metodos relacionados con acciones de unidades
	public void seMovioUnidad(ElementoArtificial elemento);
	public void seRealizoAtaque(Elemento elementoActuante);
	public void seRealizoEmp(ElementoArtificial elemento);
	public void seRealizoRadiacion(Elemento elementoAtacado);
	public void seRealizoTormentaPsionica(Elemento elementoTemporalAtacado);
	public void seRealizoAlucinacion(ElementoArtificial elemento);
	
	//Metodos relacionados con la vida de una unidad
	public void seMurioUnaUnidad(Elemento elemento) throws ElementoNoEncontradoException;
	
	//Metodos relacionados con el juego
	public void comenzoJuego();
	public void terminojuego();

	public void seCreoCopiaFicticia(Elemento copiaFicticia1);

	public void seCreoCristal(Cristal cristal) throws IOException, FueraDeRangoException, PosicionInvalidaException;

	void seMurioUnaUnidad();

	public void seCreoCentroDeComandos(
			ElementoArtificial centroComandoJugadorActual, Raza raza) throws IOException;

	

	
	
	
	

}
