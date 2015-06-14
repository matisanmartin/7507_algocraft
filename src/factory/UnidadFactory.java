package factory;

import model.Base;
import model.EspacioAereo;
import model.EspacioTerrestre;

import common.Costo;
import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Edificio;
import factory.construcciones.TipoEdificio;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;
import factory.unidades.UnidadMagicaProtoss;
import factory.unidades.UnidadMagicaTerran;
import factory.unidades.UnidadProtoss;

public class UnidadFactory extends AbstractFactory{
	
//	private static UnidadFactory INSTANCIA = null;
//	
//	UnidadFactory(){}
//	
//	public static UnidadFactory getInstancia() {
//		if(INSTANCIA == null)
//			crearInstancia();
//		
//		return INSTANCIA;	
//	}
//	
//	private static void crearInstancia() {
//		if (INSTANCIA == null)
//			INSTANCIA = new UnidadFactory();
//	}

	//GENERAL PARA PROBAR TAMAÑOS
	public static final int			UNIDAD_ALTO = 2;
	public static final int			UNIDAD_ANCHO = 2;
	
	//Atributos Marine
	public static final int 		UNIDAD_MARINE_TRANSPORTE = 1;
	public static final int 		UNIDAD_MARINE_VISION = 7;
	public static final String 		UNIDAD_MARINE_COSTO = "50M";
	public static final int 		UNIDAD_MARINE_TIEMPO_CONSTRUCCION = 3;
	public static final String 		UNIDAD_MARINE_DAÑO = "6A6T";
	public static final int 		UNIDAD_MARINE_SUMINISTRO = 1;
	public static final String 		UNIDAD_MARINE_RANGO_ATAQUE = "0A4T";
	public static final int			UNIDAD_MARINE_ALTO = 2;
	public static final int			UNIDAD_MARINE_ANCHO = 2;
	
	
	//Atributos Golliat
	public static final int 	UNIDAD_GOLLIAT_TRANSPORTE = 2;
	public static final int 	UNIDAD_GOLLIAT_VISION = 8;
	public static final String 	UNIDAD_GOLLIAT_COSTO = "100M50G";
	public static final int 	UNIDAD_GOLLIAT_TIEMPO_CONSTRUCCION = 6;
	public static final String 	UNIDAD_GOLLIAT_DAÑO = "10A12T";
	public static final int 	UNIDAD_GOLLIAT_SUMINISTRO = 2;
	public static final String 	UNIDAD_GOLLIAT_RANGO_ATAQUE = "5A6T";
	public static final Vitalidad 	UNIDAD_GOLLIAT_VIDA = new Vitalidad(125,0);
	
	//Atributos Espectro
	public static final int 	UNIDAD_ESPECTRO_TRANSPORTE = 0;
	public static final int 	UNIDAD_ESPECTRO_VISION = 7;
	public static final String	UNIDAD_ESPECTRO_COSTO = "150M100G";
	public static final int 	UNIDAD_ESPECTRO_TIEMPO_CONSTRUCCION = 8;
	public static final String 	UNIDAD_ESPECTRO_DAÑO = "20A8T";
	public static final int 	UNIDAD_ESPECTRO_SUMINISTRO = 2;
	public static final String 	UNIDAD_ESPECTRO_RANGO_ATAQUE = "5A0T";
	public static final Vitalidad	UNIDAD_ESPECTRO_VIDA = new Vitalidad(120,0);
	
	//Atributos NaveCiencia
	public static final int 	UNIDAD_NAVE_CIENCIA_TRANSPORTE = 0;
	public static final int 	UNIDAD_NAVE_CIENCIA_VISION = 10;
	public static final String 	UNIDAD_NAVE_CIENCIA_COSTO = "100M225G";
	public static final int 	UNIDAD_NAVE_CIENCIA_TIEMPO_CONSTRUCCION = 10;
	public static final String 	UNIDAD_NAVE_CIENCIA_DAÑO = "0A0T";
	public static final int 	UNIDAD_NAVE_CIENCIA_SUMINISTRO = 2;
	public static final String 	UNIDAD_NAVE_CIENCIA_RANGO_ATAQUE = "0A0T";
	
	
	//Atributos NaveTransporteTerran
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_TRANSPORTE = 8;
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_VISION = 8;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_COSTO = "100M100G";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_TIEMPO_CONSTRUCCION = 7;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_DAÑO = "0A0T";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_SUMINISTRO = 2;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_RANGO_ATAQUE = "0A0T";

	
	//Atributos Zealot
	public static final int 	UNIDAD_ZEALOT_TRANSPORTE = 2;
	public static final int 	UNIDAD_ZEALOT_VISION = 7;
	public static final String 	UNIDAD_ZEALOT_COSTO = "100M";
	public static final int 	UNIDAD_ZEALOT_TIEMPO_CONSTRUCCION = 4;
	public static final String 	UNIDAD_ZEALOT_DAÑO = "0A8T";
	public static final int 	UNIDAD_ZEALOT_SUMINISTRO = 2;
	public static final String 	UNIDAD_ZEALOT_RANGO_ATAQUE = "0A1T";

	
	//Atributos Dragon
	public static final int 	UNIDAD_DRAGON_TRANSPORTE = 4;
	public static final int 	UNIDAD_DRAGON_VISION = 8;
	public static final String 	UNIDAD_DRAGON_COSTO = "125M50G";
	public static final int 	UNIDAD_DRAGON_TIEMPO_CONSTRUCCION = 5;
	public static final String 	UNIDAD_DRAGON_DAÑO = "20A20T";
	public static final int 	UNIDAD_DRAGON_SUMINISTRO = 2;
	public static final String 	UNIDAD_DRAGON_RANGO_ATAQUE = "0A4T";

	
	//Atributos Scout
	public static final int 	UNIDAD_SCOUT_TRANSPORTE = 0;
	public static final int 	UNIDAD_SCOUT_VISION = 7;
	public static final String 	UNIDAD_SCOUT_COSTO = "300M150G";
	public static final int 	UNIDAD_SCOUT_TIEMPO_CONSTRUCCION = 9;
	public static final String 	UNIDAD_SCOUT_DAÑO = "14A8T";
	public static final int 	UNIDAD_SCOUT_SUMINISTRO = 0;
	public static final String 	UNIDAD_SCOUT_RANGO_ATAQUE = "4A0T";

	
	//Atributos AltoTemplario
	public static final int 	UNIDAD_ALTO_TEMPLARIO_TRANSPORTE = 2;
	public static final int 	UNIDAD_ALTO_TEMPLARIO_VISION = 7;
	public static final String 	UNIDAD_ALTO_TEMPLARIO_COSTO = "50M150G";
	public static final int 	UNIDAD_ALTO_TEMPLARIO_TIEMPO_CONSTRUCCION = 7;
	public static final String 	UNIDAD_ALTO_TEMPLARIO_DAÑO = "0A0T";
	public static final int 	UNIDAD_ALTO_TEMPLARIO_SUMINISTRO = 0;
	public static final String 	UNIDAD_ALTO_TEMPLARIO_RANGO_ATAQUE = "0A0T";

	
	//Atributos NaveTransporteProtoss
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_TRANSPORTE = 8;
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_VISION = 8;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_COSTO = "200M";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_TIEMPO_CONSTRUCCION = 8;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_DAÑO = "0A0T";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_SUMINISTRO = 0;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_RANGO_ATAQUE = "0A0T";


	
	@Override
	public Unidad getUnidad(TipoUnidad unidadRequerida,Posicion posicion) throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException {
		
		Unidad unidadCreada = null;
		
		switch (unidadRequerida) {
		case TERRAN_MARINE:
			
			unidadCreada = new Unidad(	UNIDAD_MARINE_TRANSPORTE,
										UNIDAD_MARINE_VISION,
										new Costo(UNIDAD_MARINE_COSTO),
										UNIDAD_MARINE_TIEMPO_CONSTRUCCION,
										UNIDAD_MARINE_DAÑO,
										UNIDAD_MARINE_SUMINISTRO,
										UNIDAD_MARINE_RANGO_ATAQUE,
										new Vitalidad(40,0),
										UNIDAD_MARINE_ALTO,
										UNIDAD_MARINE_ANCHO,
										posicion,
										new EspacioTerrestre());
			break;
		
		case TERRAN_GOLLIAT:
			unidadCreada = new Unidad(	UNIDAD_GOLLIAT_TRANSPORTE,
										UNIDAD_GOLLIAT_VISION,
										new Costo(UNIDAD_GOLLIAT_COSTO),
										UNIDAD_GOLLIAT_TIEMPO_CONSTRUCCION,
										UNIDAD_GOLLIAT_DAÑO,
										UNIDAD_GOLLIAT_SUMINISTRO,
										UNIDAD_GOLLIAT_RANGO_ATAQUE,
										new Vitalidad(125,0),
										UNIDAD_ALTO,
										UNIDAD_ANCHO,
										posicion,
										new EspacioTerrestre());
			break;
			
		case TERRAN_ESPECTRO:
			unidadCreada = new Unidad(	UNIDAD_ESPECTRO_TRANSPORTE,
										UNIDAD_ESPECTRO_VISION,
										new Costo(UNIDAD_ESPECTRO_COSTO),
										UNIDAD_ESPECTRO_TIEMPO_CONSTRUCCION,
										UNIDAD_ESPECTRO_DAÑO,
										UNIDAD_ESPECTRO_SUMINISTRO,
										UNIDAD_ESPECTRO_RANGO_ATAQUE,
										new Vitalidad(120,0),
										UNIDAD_ALTO,
										UNIDAD_ANCHO,
										posicion,
										new EspacioAereo());
			break;
			
		case TERRAN_NAVE_CIENCIA:
			unidadCreada = new UnidadMagicaTerran(	UNIDAD_NAVE_CIENCIA_TRANSPORTE,
													UNIDAD_NAVE_CIENCIA_VISION,
													new Costo(UNIDAD_NAVE_CIENCIA_COSTO),
													UNIDAD_NAVE_CIENCIA_TIEMPO_CONSTRUCCION,
													UNIDAD_NAVE_CIENCIA_DAÑO,
													UNIDAD_NAVE_CIENCIA_SUMINISTRO,
													UNIDAD_NAVE_CIENCIA_RANGO_ATAQUE,
													new Vitalidad(200,0),
													UNIDAD_ALTO,
													UNIDAD_ANCHO,
													posicion,
													new EspacioAereo());
			break;
			
		case TERRAN_NAVE_TRANSPORTE:
			unidadCreada = new Unidad(	UNIDAD_NAVE_TRANSPORTE_TERRAN_TRANSPORTE,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_VISION,
										new Costo(UNIDAD_NAVE_TRANSPORTE_TERRAN_COSTO),
										UNIDAD_NAVE_TRANSPORTE_TERRAN_TIEMPO_CONSTRUCCION,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_DAÑO,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_SUMINISTRO,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_RANGO_ATAQUE,
										new Vitalidad(150,0),
										UNIDAD_ALTO,
										UNIDAD_ANCHO,
										posicion,
										new EspacioAereo());
			break;
		case PROTOSS_ZEALOT:
			unidadCreada = new UnidadProtoss(	UNIDAD_ZEALOT_TRANSPORTE,
												UNIDAD_ZEALOT_VISION,
												new Costo(UNIDAD_ZEALOT_COSTO),
												UNIDAD_ZEALOT_TIEMPO_CONSTRUCCION,
												UNIDAD_ZEALOT_DAÑO,
												UNIDAD_ZEALOT_SUMINISTRO,
												UNIDAD_ZEALOT_RANGO_ATAQUE,
												new Vitalidad(100,60),
												UNIDAD_ALTO,
												UNIDAD_ANCHO,
												posicion,
												new EspacioTerrestre());
			break;
			
		case PROTOSS_DRAGON:
			unidadCreada = new UnidadProtoss(	UNIDAD_DRAGON_TRANSPORTE,
												UNIDAD_DRAGON_VISION,
												new Costo(UNIDAD_DRAGON_COSTO),
												UNIDAD_DRAGON_TIEMPO_CONSTRUCCION,
												UNIDAD_DRAGON_DAÑO,
												UNIDAD_DRAGON_SUMINISTRO,
												UNIDAD_DRAGON_RANGO_ATAQUE,
												new Vitalidad(100,80),
												UNIDAD_ALTO,
												UNIDAD_ANCHO,
												posicion,
												new EspacioTerrestre());
			break;
			
		case PROTOSS_SCOUT:
			unidadCreada = new UnidadProtoss(	UNIDAD_SCOUT_TRANSPORTE,
												UNIDAD_SCOUT_VISION,
												new Costo(UNIDAD_SCOUT_COSTO),
												UNIDAD_SCOUT_TIEMPO_CONSTRUCCION,
												UNIDAD_SCOUT_DAÑO,
												UNIDAD_SCOUT_SUMINISTRO,
												UNIDAD_SCOUT_RANGO_ATAQUE,
												new Vitalidad(150,100),
												UNIDAD_ALTO,
												UNIDAD_ANCHO,
												posicion,
												new EspacioAereo());
			break;
			
		case PROTOSS_ALTO_TEMPLARIO:
			unidadCreada = new UnidadMagicaProtoss(	UNIDAD_ALTO_TEMPLARIO_TRANSPORTE,
													UNIDAD_ALTO_TEMPLARIO_VISION,
													new Costo(UNIDAD_ALTO_TEMPLARIO_COSTO),
													UNIDAD_ALTO_TEMPLARIO_TIEMPO_CONSTRUCCION,
													UNIDAD_ALTO_TEMPLARIO_DAÑO,
													UNIDAD_ALTO_TEMPLARIO_SUMINISTRO,
													UNIDAD_ALTO_TEMPLARIO_RANGO_ATAQUE,
													new Vitalidad(40,40),
													UNIDAD_ALTO,
													UNIDAD_ANCHO,
													posicion,
													new EspacioTerrestre());
			break;
			
		case PROTOSS_NAVE_TRANSPORTE:
			unidadCreada = new UnidadProtoss(	UNIDAD_NAVE_TRANSPORTE_PROTOSS_TRANSPORTE,
												UNIDAD_NAVE_TRANSPORTE_PROTOSS_VISION,
												new Costo(UNIDAD_NAVE_TRANSPORTE_PROTOSS_COSTO),
												UNIDAD_NAVE_TRANSPORTE_PROTOSS_TIEMPO_CONSTRUCCION,
												UNIDAD_NAVE_TRANSPORTE_PROTOSS_DAÑO,
												UNIDAD_NAVE_TRANSPORTE_PROTOSS_SUMINISTRO,
												UNIDAD_NAVE_TRANSPORTE_PROTOSS_RANGO_ATAQUE,
												new Vitalidad(80,60),
												UNIDAD_ALTO,
												UNIDAD_ANCHO,
												posicion,
												new EspacioAereo());
			break;
		default: 
			throw new UnidadInvalidaException();
				
		}
		
		return unidadCreada;
	}


	@Override
	public Edificio getEdificio(TipoEdificio construccionRequerida,
			Posicion posicion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Base getBase(Posicion posicion) {
		// TODO Auto-generated method stub
		return null;
	}
}
