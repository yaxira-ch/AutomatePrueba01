package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobConsultaDocumentosBE {
	
	public static String GstrID_CASO = "";
	public static String GstrID_CASO_LOGIN = "";
	public static String GstrCMB_EMPRESA= "";
	public static String GstrCMB_PRODUCTO= "";
	public static String GstrCMB_SITUACION= "";
	public static String GstrCMB_POR_DOCUMENTO= "";
	public static String GstrTXT_NUMERO_DOCUMENTO= "";
	public static String GstrCMB_TIPO_DE_BUSQUEDA= "";
	public static String GstrTXT_FECHA_DESDE= "";
	public static String GstrTXT_FECHA_HASTA= "";
	public static String GstrBTN_BUSCAR= "";
	public static String GstrLNK_ENVIAR_EMAIL= "";
	public static String GstrTXT_CORREO_POPUP= "";
	public static String GstrTXT_MENSAJE_POPUP= "";
	public static String GstrBTN_ENVIAR_CORREO_POPUP= "";
	public static String GstrLNK_EXPORTAR_EXCEL= "";
	public static String GstrLNK_EXPORTAR_PDF= "";
	public static String GstrLNK_IMPRIMIR= "";
	public static String GstrLNK_CERRAR_SESION= "";

	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_PRODUCTO = Rst_Funcionalidad.getObject("CMB_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_SITUACION = Rst_Funcionalidad.getObject("CMB_SITUACION") != null ? Rst_Funcionalidad.getString("CMB_SITUACION") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_POR_DOCUMENTO = Rst_Funcionalidad.getObject("CMB_POR_DOCUMENTO") != null ? Rst_Funcionalidad.getString("CMB_POR_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_DOCUMENTO = Rst_Funcionalidad.getObject("TXT_NUMERO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_DE_BUSQUEDA = Rst_Funcionalidad.getObject("CMB_TIPO_DE_BUSQUEDA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DE_BUSQUEDA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_DESDE = Rst_Funcionalidad.getObject("TXT_FECHA_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DESDE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_HASTA = Rst_Funcionalidad.getObject("TXT_FECHA_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR = Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP = Rst_Funcionalidad.getObject("TXT_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP = Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
}
