package factory;

import exceptions.UnidadInvalidaException;
import factory.construcciones.Construccion;
import factory.construcciones.TipoConstruccion;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

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

	//Atributos Marine
	public static final int 		UNIDAD_MARINE_TRANSPORTE = 1;
	public static final int 		UNIDAD_MARINE_VISION = 7;
	public static final String 		UNIDAD_MARINE_COSTO = "50M";
	public static final int 		UNIDAD_MARINE_TIEMPO_CONSTRUCCION = 3;
	public static final String 		UNIDAD_MARINE_DAÑO = "6A6T";
	public static final int 		UNIDAD_MARINE_SUMINISTRO = 1;
	public static final String 		UNIDAD_MARINE_RANGO_ATAQUE = "0A4T";
	public static final String 		UNIDAD_MARINE_VIDA = "40";
	
	//Atributos Golliat
	public static final int 	UNIDAD_GOLLIAT_TRANSPORTE = 2;
	public static final int 	UNIDAD_GOLLIAT_VISION = 8;
	public static final String 	UNIDAD_GOLLIAT_COSTO = "100M50G";
	public static final int 	UNIDAD_GOLLIAT_TIEMPO_CONSTRUCCION = 6;
	public static final String 	UNIDAD_GOLLIAT_DAÑO = "10A12T";
	public static final int 	UNIDAD_GOLLIAT_SUMINISTRO = 2;
	public static final String 	UNIDAD_GOLLIAT_RANGO_ATAQUE = "5A6T";
	public static final String 	UNIDAD_GOLLIAT_VIDA = "125";
	
	//Atributos Espectro
	public static final int 	UNIDAD_ESPECTRO_TRANSPORTE = 0;
	public static final int 	UNIDAD_ESPECTRO_VISION = 7;
	public static final String	UNIDAD_ESPECTRO_COSTO = "150M100G";
	public static final int 	UNIDAD_ESPECTRO_TIEMPO_CONSTRUCCION = 8;
	public static final String 	UNIDAD_ESPECTRO_DAÑO = "20A8T";
	public static final int 	UNIDAD_ESPECTRO_SUMINISTRO = 2;
	public static final String 	UNIDAD_ESPECTRO_RANGO_ATAQUE = "5A0T";
	public static final String 	UNIDAD_ESPECTRO_VIDA = "120";
	
	//Atributos NaveCiencia
	public static final int 	UNIDAD_NAVE_CIENCIA_TRANSPORTE = 0;
	public static final int 	UNIDAD_NAVE_CIENCIA_VISION = 10;
	public static final String 	UNIDAD_NAVE_CIENCIA_COSTO = "50M";
	public static final int 	UNIDAD_NAVE_CIENCIA_TIEMPO_CONSTRUCCION = 3;
	public static final String 	UNIDAD_NAVE_CIENCIA_DAÑO = "0A0T";
	public static final int 	UNIDAD_NAVE_CIENCIA_SUMINISTRO = 2;
	public static final String 	UNIDAD_NAVE_CIENCIA_RANGO_ATAQUE = "0A0T";
	public static final String 	UNIDAD_NAVE_CIENCIA_VIDA = "200";
	
	//Atributos NaveTransporteTerran
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_TRANSPORTE = 8;
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_VISION = 8;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_COSTO = "50M";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_TIEMPO_CONSTRUCCION = 3;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_DAÑO = "0A0T";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_TERRAN_SUMINISTRO = 2;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_RANGO_ATAQUE = "0A0T";
	public static final String 	UNIDAD_NAVE_TRANSPORTE_TERRAN_VIDA = "150";
	
	//Atributos Zealot
	public static final int 	UNIDAD_ZEALOT_TRANSPORTE = 2;
	public static final int 	UNIDAD_ZEALOT_VISION = 7;
	public static final String 	UNIDAD_ZEALOT_COSTO = "100M";
	public static final int 	UNIDAD_ZEALOT_TIEMPO_CONSTRUCCION = 4;
	public static final String 	UNIDAD_ZEALOT_DAÑO = "0A8T";
	public static final int 	UNIDAD_ZEALOT_SUMINISTRO = 2;
	public static final String 	UNIDAD_ZEALOT_RANGO_ATAQUE = "0A1T";
	public static final String 	UNIDAD_ZEALOT_VIDA = "60/100";
	
	//Atributos Dragon
	public static final int 	UNIDAD_DRAGON_TRANSPORTE = 4;
	public static final int 	UNIDAD_DRAGON_VISION = 8;
	public static final String 	UNIDAD_DRAGON_COSTO = "125M50G";
	public static final int 	UNIDAD_DRAGON_TIEMPO_CONSTRUCCION = 5;
	public static final String 	UNIDAD_DRAGON_DAÑO = "20A20T";
	public static final int 	UNIDAD_DRAGON_SUMINISTRO = 2;
	public static final String 	UNIDAD_DRAGON_RANGO_ATAQUE = "0A4T";
	public static final String	UNIDAD_DRAGON_VIDA = "80/100";
	
	//Atributos Scout
	public static final int 	UNIDAD_SCOUT_TRANSPORTE = 0;
	public static final int 	UNIDAD_SCOUT_VISION = 7;
	public static final String 	UNIDAD_SCOUT_COSTO = "300M150G";
	public static final int 	UNIDAD_SCOUT_TIEMPO_CONSTRUCCION = 8;
	public static final String 	UNIDAD_SCOUT_DAÑO = "14A8T";
	public static final int 	UNIDAD_SCOUT_SUMINISTRO = 0;
	public static final String 	UNIDAD_SCOUT_RANGO_ATAQUE = "4A0T";
	public static final String 	UNIDAD_SCOUT_VIDA = "100/150";
	
	//Atributos AltoTemplario
	public static final int 	UNIDAD_ALTO_TEMPLARIO_TRANSPORTE = 2;
	public static final int 	UNIDAD_ALTO_TEMPLARIO_VISION = 7;
	public static final String 	UNIDAD_ALTO_TEMPLARIO_COSTO = "50M150G";
	public static final int 	UNIDAD_ALTO_TEMPLARIO_TIEMPO_CONSTRUCCION = 5;
	public static final String 	UNIDAD_ALTO_TEMPLARIO_DAÑO = "0A0T";
	public static final int 	UNIDAD_ALTO_TEMPLARIO_SUMINISTRO = 0;
	public static final String 	UNIDAD_ALTO_TEMPLARIO_RANGO_ATAQUE = "0A0T";
	public static final String	UNIDAD_ALTO_TEMPLARIO_VIDA = "40/40";
	
	//Atributos NaveTransporteProtoss
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_TRANSPORTE = 8;
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_VISION = 8;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_COSTO = "200M";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_TIEMPO_CONSTRUCCION = 0;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_DAÑO = "0A0T";
	public static final int 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_SUMINISTRO = 0;
	public static final String 	UNIDAD_NAVE_TRANSPORTE_PROTOSS_RANGO_ATAQUE = "0A0T";
	public static final String	UNIDAD_NAVE_TRANSPORTE_PROTOSS_VIDA = "60/80";

	
	@Override
	public Unidad getUnidad(TipoUnidad unidadRequerida) throws UnidadInvalidaException {
		
		Unidad unidadCreada = null;
		
		switch (unidadRequerida) {
		case TERRAN_MARINE:
			unidadCreada = new Unidad(	UNIDAD_MARINE_TRANSPORTE,
										UNIDAD_MARINE_VISION,
										UNIDAD_MARINE_COSTO,
										UNIDAD_MARINE_TIEMPO_CONSTRUCCION,
										UNIDAD_MARINE_DAÑO,
										UNIDAD_MARINE_SUMINISTRO,
										UNIDAD_MARINE_RANGO_ATAQUE,
										UNIDAD_MARINE_VIDA);
			break;
		
		case TERRAN_GOLLIAT:
			unidadCreada = new Unidad(	UNIDAD_GOLLIAT_TRANSPORTE,
										UNIDAD_GOLLIAT_VISION,
										UNIDAD_GOLLIAT_COSTO,
										UNIDAD_GOLLIAT_TIEMPO_CONSTRUCCION,
										UNIDAD_GOLLIAT_DAÑO,
										UNIDAD_GOLLIAT_SUMINISTRO,
										UNIDAD_GOLLIAT_RANGO_ATAQUE,
										UNIDAD_GOLLIAT_VIDA);
			break;
			
		case TERRAN_ESPECTRO:
			unidadCreada = new Unidad(	UNIDAD_ESPECTRO_TRANSPORTE,
										UNIDAD_ESPECTRO_VISION,
										UNIDAD_ESPECTRO_COSTO,
										UNIDAD_ESPECTRO_TIEMPO_CONSTRUCCION,
										UNIDAD_ESPECTRO_DAÑO,
										UNIDAD_ESPECTRO_SUMINISTRO,
										UNIDAD_ESPECTRO_RANGO_ATAQUE,
										UNIDAD_ESPECTRO_VIDA);
			break;
			
		case TERRAN_NAVE_CIENCIA:
			unidadCreada = new Unidad(	UNIDAD_NAVE_CIENCIA_TRANSPORTE,
										UNIDAD_NAVE_CIENCIA_VISION,
										UNIDAD_NAVE_CIENCIA_COSTO,
										UNIDAD_NAVE_CIENCIA_TIEMPO_CONSTRUCCION,
										UNIDAD_NAVE_CIENCIA_DAÑO,
										UNIDAD_NAVE_CIENCIA_SUMINISTRO,
										UNIDAD_NAVE_CIENCIA_RANGO_ATAQUE,
										UNIDAD_NAVE_CIENCIA_VIDA);
			break;
			
		case TERRAN_NAVE_TRANSPORTE:
			unidadCreada = new Unidad(	UNIDAD_NAVE_TRANSPORTE_TERRAN_TRANSPORTE,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_VISION,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_COSTO,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_TIEMPO_CONSTRUCCION,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_DAÑO,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_SUMINISTRO,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_RANGO_ATAQUE,
										UNIDAD_NAVE_TRANSPORTE_TERRAN_VIDA);	
			break;
			
		case PROTOSS_ZEALOT:
			unidadCreada = new Unidad(	UNIDAD_ZEALOT_TRANSPORTE,
										UNIDAD_ZEALOT_VISION,
										UNIDAD_ZEALOT_COSTO,
										UNIDAD_ZEALOT_TIEMPO_CONSTRUCCION,
										UNIDAD_ZEALOT_DAÑO,
										UNIDAD_ZEALOT_SUMINISTRO,
										UNIDAD_ZEALOT_RANGO_ATAQUE,
										UNIDAD_ZEALOT_VIDA);
			break;
			
		case PROTOSS_DRAGON:
			unidadCreada = new Unidad(	UNIDAD_DRAGON_TRANSPORTE,
										UNIDAD_DRAGON_VISION,
										UNIDAD_DRAGON_COSTO,
										UNIDAD_DRAGON_TIEMPO_CONSTRUCCION,
										UNIDAD_DRAGON_DAÑO,
										UNIDAD_DRAGON_SUMINISTRO,
										UNIDAD_DRAGON_RANGO_ATAQUE,
										UNIDAD_DRAGON_VIDA);
			break;
			
		case PROTOSS_SCOUT:
			unidadCreada = new Unidad(	UNIDAD_SCOUT_TRANSPORTE,
										UNIDAD_SCOUT_VISION,
										UNIDAD_SCOUT_COSTO,
										UNIDAD_SCOUT_TIEMPO_CONSTRUCCION,
										UNIDAD_SCOUT_DAÑO,
										UNIDAD_SCOUT_SUMINISTRO,
										UNIDAD_SCOUT_RANGO_ATAQUE,
										UNIDAD_SCOUT_VIDA);
			break;
			
		case PROTOSS_ALTO_TEMPLARIO:
			unidadCreada = new Unidad(	UNIDAD_ALTO_TEMPLARIO_TRANSPORTE,
										UNIDAD_ALTO_TEMPLARIO_VISION,
										UNIDAD_ALTO_TEMPLARIO_COSTO,
										UNIDAD_ALTO_TEMPLARIO_TIEMPO_CONSTRUCCION,
										UNIDAD_ALTO_TEMPLARIO_DAÑO,
										UNIDAD_ALTO_TEMPLARIO_SUMINISTRO,
										UNIDAD_ALTO_TEMPLARIO_RANGO_ATAQUE,
										UNIDAD_ALTO_TEMPLARIO_VIDA);
			break;
			
		case PROTOSS_NAVE_TRANSPORTE:
			unidadCreada = new Unidad(	UNIDAD_NAVE_TRANSPORTE_PROTOSS_TRANSPORTE,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_VISION,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_COSTO,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_TIEMPO_CONSTRUCCION,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_DAÑO,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_SUMINISTRO,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_RANGO_ATAQUE,
										UNIDAD_NAVE_TRANSPORTE_PROTOSS_VIDA);
			break;
		default: 
			throw new UnidadInvalidaException();
				
		}
		
		return unidadCreada;
	}

	@Override
	public Construccion getConstruccion(TipoConstruccion construccionRequerida) {
		return null;
	}

}
