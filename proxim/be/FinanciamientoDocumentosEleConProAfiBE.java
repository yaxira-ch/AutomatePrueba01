package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleConProAfiBE {
	public static String GstrID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_PRODUCTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_PESTANA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPODOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERODOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRERAZONSOCIAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCARPREAFILIDOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRECONTACTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_TELEFONOCONTACTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_EMAILCONTACTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_PREAFILIAR=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_PREAFILIACION=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrCMB_PROVEEDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_ConPreafiliados=Mdl_Variables.Gstr_Ignore;
	public static String GstrFECHA_AFILIACION=Mdl_Variables.Gstr_Ignore;
		
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			//GENERAL
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_PESTANA = Rst_Funcionalidad.getObject("PESTANA") != null ? Rst_Funcionalidad.getString("PESTANA") : Mdl_Variables.Gstr_Ignore;
			
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_PRODUCTO = Rst_Funcionalidad.getObject("CMB_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_PROVEEDOR= Rst_Funcionalidad.getObject("CMB_PROVEEDOR") != null ? Rst_Funcionalidad.getString("CMB_PROVEEDOR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR = Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CORREO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
		
			GstrCMB_TIPODOCUMENTO= Rst_Funcionalidad.getObject("CMB_TIPODOCUMENTO") != null ? Rst_Funcionalidad.getString("CMB_TIPODOCUMENTO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERODOCUMENTO= Rst_Funcionalidad.getObject("TXT_NUMERODOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NUMERODOCUMENTO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCARPREAFILIDOS= Rst_Funcionalidad.getObject("BTN_BUSCARPREAFILIDOS") != null ? Rst_Funcionalidad.getString("BTN_BUSCARPREAFILIDOS") : Mdl_Variables.Gstr_Ignore;
			
			GstrTXT_NOMBRERAZONSOCIAL= Rst_Funcionalidad.getObject("TXT_NOMBRERAZONSOCIAL") != null ? Rst_Funcionalidad.getString("TXT_NOMBRERAZONSOCIAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRECONTACTO= Rst_Funcionalidad.getObject("TXT_NOMBRECONTACTO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRECONTACTO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_TELEFONOCONTACTO= Rst_Funcionalidad.getObject("TXT_TELEFONOCONTACTO") != null ? Rst_Funcionalidad.getString("TXT_TELEFONOCONTACTO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_EMAILCONTACTO= Rst_Funcionalidad.getObject("TXT_EMAILCONTACTO") != null ? Rst_Funcionalidad.getString("TXT_EMAILCONTACTO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_PREAFILIAR= Rst_Funcionalidad.getObject("BTN_PREAFILIAR") != null ? Rst_Funcionalidad.getString("BTN_PREAFILIAR") : Mdl_Variables.Gstr_Ignore;
			
			GstrLNK_ENVIAR_EMAIL_PREAFILIACION= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_PREAFILIACION") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_PREAFILIACION= Rst_Funcionalidad.getObject("TXT_CORREO_PREAFILIACION") != null ? Rst_Funcionalidad.getString("TXT_CORREO_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_PREAFILIACION= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_PREAFILIACION") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_PREAFILIACION= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_PREAFILIACION") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CORREO_PREAFILIACION= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_PREAFILIACION") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_PREAFILIACION= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_PREAFILIACION") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_PREAFILIACION= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_PREAFILIACION") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_PREAFILIACION= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_PREAFILIACION") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_PREAFILIACION") : Mdl_Variables.Gstr_Ignore;
		
			GstrLNK_ENVIAR_EMAIL_ConPreafiliados= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_ConPreafiliados") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_ConPreafiliados= Rst_Funcionalidad.getObject("TXT_CORREO_ConPreafiliados") != null ? Rst_Funcionalidad.getString("TXT_CORREO_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_ConPreafiliados= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_ConPreafiliados") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_ConPreafiliados= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_ConPreafiliados") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CORREO_ConPreafiliados= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_ConPreafiliados") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_ConPreafiliados= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_ConPreafiliados") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_ConPreafiliados= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_ConPreafiliados") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_ConPreafiliados= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_ConPreafiliados") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_ConPreafiliados") : Mdl_Variables.Gstr_Ignore;
			GstrFECHA_AFILIACION= Rst_Funcionalidad.getObject("FECHA_AFILIACION") != null ? Rst_Funcionalidad.getString("FECHA_AFILIACION") : Mdl_Variables.Gstr_Ignore;
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
