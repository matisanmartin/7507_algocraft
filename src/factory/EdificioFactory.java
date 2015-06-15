package factory;

import model.Base;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Acceso;
import factory.construcciones.ArchivoTemplario;
import factory.construcciones.Asimilador;
import factory.construcciones.Barraca;
import factory.construcciones.CentroMineral;
import factory.construcciones.DepositoSuministros;
import factory.construcciones.Edificio;
import factory.construcciones.Fabrica;
import factory.construcciones.NexoMineral;
import factory.construcciones.Pilon;
import factory.construcciones.PuertoEstelarProtoss;
import factory.construcciones.PuertoEstelarTerran;
import factory.construcciones.Refineria;
import factory.construcciones.TipoEdificio;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class EdificioFactory extends AbstractFactory {

	public static final int ALTO=2;
	public static final int ANCHO=2;
	
	//Centro mineral
	public static final int CENTRO_MINERAL_ALTO = 2;
	public static final int CENTRO_MINERAL_ANCHO = 2;
	private static final int REFINERIA_ALTO = 2;
	private static final int REFINERIA_ANCHO = 2;
	private static final int BARRACA_ALTO = 2;
	private static final int BARRACA_ANCHO = 2;
	private static final int FABRICA_ALTO = 2;
	private static final int FABRICA_ANCHO = 2;
	private static final int PUERTO_ESTELAR_TERRAN_ALTO = 2;
	private static final int PUERTO_ESTELAR_TERRAN_ANCHO = 2;
	private static final int NEXO_MINERAL_ALTO = 2;
	private static final int NEXO_MINERAL_ANCHO = 2;
	private static final int ASIMILADOR_ALTO = 2;
	private static final int ASIMILADOR_ANCHO = 2;
	private static final int ACCESO_ALTO = 2;
	private static final int ACCESO_ANCHO = 2;
	private static final int PUERTO_ESTELAR_PROTOSS_ALTO = 2;
	private static final int PUERTO_ESTELAR_PROTOSS_ANCHO = 2;
	private static final int ARCHIVO_TEMPLARIO_ALTO = 2;
	private static final int ARCHIVO_TEMPLARIO_ANCHO = 2;
	private static final int DEPOSITO_ALTO = 2;
	private static final int DEPOSITO_ANCHO = 2;
	private static final int PILON_ALTO = 0;
	private static final int PILON_ANCHO = 0;
	
	
	@Override
	public Edificio getEdificio(TipoEdificio construccionRequerida,
			Posicion posicion) throws FueraDeRangoException, CostoInvalidoException {
		
		Edificio edificioCreado = null;
		
		switch (construccionRequerida) {
		
		
		case TERRAN_CENTRO_MINERAL: 
			edificioCreado = new CentroMineral(CENTRO_MINERAL_ALTO, CENTRO_MINERAL_ANCHO, posicion);
			
			break;
			
		case TERRAN_REFINERIA:
			edificioCreado = new Refineria(REFINERIA_ALTO, REFINERIA_ANCHO, posicion);
			
			break;
			
		case TERRAN_BARRACA:
			edificioCreado = new Barraca(BARRACA_ALTO, BARRACA_ANCHO, posicion);
			
			break;
			
		case TERRAN_FABRICA:
			edificioCreado = new Fabrica(FABRICA_ALTO,  FABRICA_ANCHO, posicion);
			
			break;
		
		case TERRAN_PUERTO_ESTELAR:
			edificioCreado = new PuertoEstelarTerran(PUERTO_ESTELAR_TERRAN_ALTO, PUERTO_ESTELAR_TERRAN_ANCHO, posicion);
			
			break;
			
		case TERRAN_DEPOSITO_SUMINISTROS:
			edificioCreado = new DepositoSuministros(DEPOSITO_ALTO, DEPOSITO_ANCHO, posicion);
			break;
			
		case PROTOSS_NEXO_MINERAL:
			edificioCreado = new NexoMineral(NEXO_MINERAL_ALTO, NEXO_MINERAL_ANCHO, posicion);
			
			break;
			
		case PROTOSS_ASIMILADOR:
			edificioCreado = new Asimilador(ASIMILADOR_ALTO, ASIMILADOR_ANCHO, posicion);
			break;
			
		case PROTOSS_ACCESO:
			edificioCreado = new Acceso(ACCESO_ALTO, ACCESO_ANCHO, posicion);
			break;
			
		case PROTOSS_PUERTO_ESTELAR:
			edificioCreado = new PuertoEstelarProtoss(PUERTO_ESTELAR_PROTOSS_ALTO, PUERTO_ESTELAR_PROTOSS_ANCHO, posicion);
			break;
			
		case PROTOSS_ARCHIVO_TEMPLARIO:
			edificioCreado = new ArchivoTemplario(ARCHIVO_TEMPLARIO_ALTO, ARCHIVO_TEMPLARIO_ANCHO, posicion);
			break;
			
		case PROTOSS_PILON:
			edificioCreado = new Pilon(PILON_ALTO, PILON_ANCHO, posicion);
			break;

			
		default:
			break;
		}
		return edificioCreado;
	}
	
	@Override
	public Unidad getUnidad(TipoUnidad unidadRequerida, Posicion posicion)
	throws UnidadInvalidaException, FueraDeRangoException {
		return null;
	}

//	@Override
//	public Base getBase(Posicion posicion) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

	
	
	

}
