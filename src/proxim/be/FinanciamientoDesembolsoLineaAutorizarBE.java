package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class FinanciamientoDesembolsoLineaAutorizarBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_FIRMANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_OPERACION_DESDE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_OPERACION_HASTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_SOLICITUD_EXPIRADA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_AUTORIZAR=Mdl_Variables.Gstr_Ignore; 
	public static String GstrLNK_VER=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AUTORIZAR=Mdl_Variables.Gstr_Ignore;  
	public static String GstrBTN_BLOQUEAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore; 
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REALIZAR_OTRA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;

	public boolean FinanDesembolsoLineaAutorizar(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
	
		try {
			Gstr_ID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOTE = Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_SOLICITUD_EXPIRADA= Rst_Funcionalidad.getObject("LNK_SOLICITUD_EXPIRADA") != null ? Rst_Funcionalidad.getString("LNK_SOLICITUD_EXPIRADA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_OPERACION_DESDE= Rst_Funcionalidad.getObject("TXT_FECHA_OPERACION_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_OPERACION_DESDE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_OPERACION_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_OPERACION_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_OPERACION_HASTA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			Gstr_FIRMANTE= Rst_Funcionalidad.getObject("FIRMANTE") != null ? Rst_Funcionalidad.getString("FIRMANTE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER= Rst_Funcionalidad.getObject("LNK_VER") != null ? Rst_Funcionalidad.getString("LNK_VER") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR= Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_AUTORIZAR= Rst_Funcionalidad.getObject("CHK_AUTORIZAR") != null ? Rst_Funcionalidad.getString("CHK_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BLOQUEAR= Rst_Funcionalidad.getObject("BTN_BLOQUEAR") != null ? Rst_Funcionalidad.getString("BTN_BLOQUEAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REALIZAR_OTRA_OPERACION= Rst_Funcionalidad.getObject("LNK_REALIZAR_OTRA_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_VELNK_REALIZAR_OTRA_OPERACIONR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
