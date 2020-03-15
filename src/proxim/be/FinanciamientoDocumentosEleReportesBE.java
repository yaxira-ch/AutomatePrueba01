package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleReportesBE {
	
	public static String GstrID_CASO =Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU =Mdl_Variables.Gstr_Ignore;
	
	public static String GstrCMB_EMPRESA =Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_SERVICIO =Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_REPORTE =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_REPORTE_DESDE =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_REPORTE_HASTA =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR =Mdl_Variables.Gstr_Ignore;

	public static String GstrLNK_ENVIAR_EMAIL =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;

	public static String GstrLNK_DESCARGAR =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION =Mdl_Variables.Gstr_Ignore;

	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			 GstrID_CASO  = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			 GstrID_CASO_LOGIN  = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_MENU  = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_SUBMENU  = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			 
			 GstrCMB_EMPRESA  = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			 GstrCMB_SERVICIO  = Rst_Funcionalidad.getObject("CMB_SERVICIO") != null ? Rst_Funcionalidad.getString("CMB_SERVICIO") : Mdl_Variables.Gstr_Ignore;
			 GstrCMB_TIPO_REPORTE  = Rst_Funcionalidad.getObject("CMB_TIPO_REPORTE") != null ? Rst_Funcionalidad.getString("CMB_TIPO_REPORTE") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_FECHA_REPORTE_DESDE  = Rst_Funcionalidad.getObject("TXT_FECHA_REPORTE_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_REPORTE_DESDE") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_FECHA_REPORTE_HASTA  = Rst_Funcionalidad.getObject("TXT_FECHA_REPORTE_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_REPORTE_HASTA") : Mdl_Variables.Gstr_Ignore;
			 GstrBTN_BUSCAR  = Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;


			 GstrLNK_ENVIAR_EMAIL  = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_CORREO  = Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_MENSAJE_CORREO  = Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			 GstrBTN_ENVIAR_CORREO  = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			 GstrBTN_ACEPTAR_CORREO  = Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			 GstrLNK_EXPORTAR_EXCEL  = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			 GstrLNK_EXPORTAR_PDF  = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			 GstrLNK_IMPRIMIR  = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;


			 GstrLNK_DESCARGAR  = Rst_Funcionalidad.getObject("LNK_DESCARGAR") != null ? Rst_Funcionalidad.getString("LNK_DESCARGAR") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_COLUMNA_ERROR  = Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			 GstrTXT_MENSAJE_ERROR  = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			 GstrLNK_CERRAR_SESION  = Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
		
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
}
