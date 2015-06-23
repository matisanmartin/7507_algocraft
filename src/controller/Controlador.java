package controller;

import java.io.IOException;

import recursos.Cristal;
import listener.JuegoListener;
import model.Elemento;
import model.ElementoArtificial;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Controlador implements JuegoListener {
	
	private static Elemento ultimaReferencia;

	@Override
	public String pruebaListener() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Elemento getUlitmaReferencia() {
		return ultimaReferencia;
	}
	
	public static void setUltimaReferencia(Elemento nuevaUltimaReferencia) {
		ultimaReferencia=nuevaUltimaReferencia;
	}

	@Override
	public void seCreoMarine(ElementoArtificial elemento) throws IOException,
			FueraDeRangoException, PosicionInvalidaException {
		
	}

	@Override
	public void seCreoGolliat(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoEspectro(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoNaveCiencia(ElementoArtificial elemento)
			throws IOException, FueraDeRangoException,
			PosicionInvalidaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoNaveTransporteTerran(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoZealot(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoDragon(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoScout(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoAltoTemplario(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoNaveTransporteProtoss(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoCentroMineral(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoBarraca(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoDepositoDeSuministro(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoRefineria(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoFabrica(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoPuertoEstelarTerran(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoNexoMineral(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoPilon(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoAsimilador(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoAcceso(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoPuertoEstelarProtoss(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoArchivosTemplarios(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seMovioUnidad(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoAtaque(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoEmp(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoRadiacion(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoTormentaPsionica(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seRealizoAlucinacion(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seMurioUnaUnidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comenzoJuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminojuego() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoCopiaFicticia(ElementoArtificial elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoVolcan(Elemento elemento) throws FueraDeRangoException,
			PosicionInvalidaException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoCristal(Cristal cristal) throws IOException,
			FueraDeRangoException, PosicionInvalidaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seCreoCentroDeComandoTerran(ElementoArtificial elemento)
			throws FueraDeRangoException, PosicionInvalidaException,
			IOException {
		// TODO Auto-generated method stub
		
	}
	
}
