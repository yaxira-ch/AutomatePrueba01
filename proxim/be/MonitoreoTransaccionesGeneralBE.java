package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;


public class MonitoreoTransaccionesGeneralBE {
	
	public static String strID_CASO;
	public static String strID_CASO_LOGIN;
	public String strRUTA;
	public String strNOMBRE_ARCHIVO;
	public String strFECHA_HASTA;
	public String strHORA_HASTA;
	public String strTOTAL_REGISTROS_TEXTO;
	public String strTOTAL_REGISTROS_BASE;
	public String strTOTAL_REGISTROS_MARGE;
	public String strFECHA_EJECUCION;
	public String strHORA_EJECUCION; 
	
	//TABLA DETALLE
	public static String GstrTIPO_TRANSACCION="";
	public static String GstrTIPO_GRUPO_EMPRESA="";
	public static String GstrCODIGO_CANAL="";
	public static String GstrCODIGO_TRANSACCION="";
	public static String GstrDETALLE_CODIGO_TRANSACCION="";
	public static String GstrNRO_TARJETA_INTERACTIVA="";
	public static String GstrFECHA_ACUSE_TARJETA="";
	public static String GstrFECHA_TRANSACCION="";
	public static String GstrHORA_TRANSACCION="";
	public static String GstrMONEDA="";
	public static String GstrIMPORTE="";
	public static String GstrCODIGO_UNICO_CLIENTE="";
	public static String GstrDNI_CLIENTE="";
	public static String GstrDISPOSITIVO_TRANSACCION="";
	public static String GstrIP_IMEI="";
	public static String GstrTIPO_MONEDA_ORIGEN="";
	public static String GstrTIPO_CUENTA_ORIGEN="";
	public static String GstrCODIGO_OFICINA_ORIGEN="";
	public static String GstrNUMERO_CUENTA_ORIGEN="";
	public static String GstrTIPO_MONEDA_DESTINO="";
	public static String GstrTIPO_CUENTA_DESTINO="";
	public static String GstrCODIGO_OFICINA_DESTINO="";
	public static String GstrNUMERO_CUENTA_DESTINO="";
	public static String GstrCCI_CUENTA_DESTINIO="";
	public static String GstrPUNTO_SERVICIO="";
	public static String GstrNIVEL_TRANSACCIONAL="";
	public static String GstrTIPO_ACCESO="";
	public static String GstrSALDO_DISPONIBLE_ORIGEN="";
	public static String GstrFECHA_EJECUCION="";
	public static String GstrHORA_EJECUCION="";
	
	public boolean Referencias(ResultSet Rst_Funcionalidad,int nOpcion){
		boolean bandera = true; 
		try {
			switch (nOpcion)
			{
				case 1:
					strID_CASO= Rst_Funcionalidad.getObject( "ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
					strID_CASO_LOGIN= Rst_Funcionalidad.getObject( "ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
					strRUTA= Rst_Funcionalidad.getObject( "RUTA") != null ? Rst_Funcionalidad.getString("RUTA") : Mdl_Variables.Gstr_Ignore;
					strNOMBRE_ARCHIVO= Rst_Funcionalidad.getObject( "NOMBRE_ARCHIVO") != null ? Rst_Funcionalidad.getString("NOMBRE_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
					strFECHA_HASTA= Rst_Funcionalidad.getObject( "FECHA_HASTA") != null ? Rst_Funcionalidad.getString("FECHA_HASTA") : Mdl_Variables.Gstr_Ignore;
					strHORA_HASTA= Rst_Funcionalidad.getObject( "HORA_HASTA") != null ? Rst_Funcionalidad.getString("HORA_HASTA") : Mdl_Variables.Gstr_Ignore;
					strTOTAL_REGISTROS_TEXTO= Rst_Funcionalidad.getObject( "TOTAL_REGISTROS_TEXTO") != null ? Rst_Funcionalidad.getString("TOTAL_REGISTROS_TEXTO") : Mdl_Variables.Gstr_Ignore;
					strTOTAL_REGISTROS_BASE= Rst_Funcionalidad.getObject( "TOTAL_REGISTROS_BASE") != null ? Rst_Funcionalidad.getString("TOTAL_REGISTROS_BASE") : Mdl_Variables.Gstr_Ignore;
					strTOTAL_REGISTROS_MARGE= Rst_Funcionalidad.getObject( "TOTAL_REGISTROS_MARGE") != null ? Rst_Funcionalidad.getString("TOTAL_REGISTROS_MARGE") : Mdl_Variables.Gstr_Ignore;
					strFECHA_EJECUCION= Rst_Funcionalidad.getObject( "FECHA_EJECUCION") != null ? Rst_Funcionalidad.getString("FECHA_EJECUCION") : Mdl_Variables.Gstr_Ignore;
					strHORA_EJECUCION= Rst_Funcionalidad.getObject( "HORA_EJECUCION") != null ? Rst_Funcionalidad.getString("HORA_EJECUCION") : Mdl_Variables.Gstr_Ignore;
					break;
					
				case 0:
					break;
			}

		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
	
}