package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaRenovacionAutorizarBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_FIRMANTE=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_SOLICITUD_DESDE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_SOLICITUD_HASTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_SOLICITUDES_EXPIRADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_SOLICITUDES_EXPIRADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_TODOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_DESCARGAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AUTORIZAR=Mdl_Variables.Gstr_Ignore;  
	public static String GstrBTN_BLOQUEAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;  
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;  
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_OPERACION=Mdl_Variables.Gstr_Ignore; 
	public static String GstrIMG_DESCARGAR_OPERACION=Mdl_Variables.Gstr_Ignore;  
	public static String GstrLNK_QUIERES_SABER_COMO=Mdl_Variables.Gstr_Ignore;
    public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore; 
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_MONTO_TOTAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_RESULTADO_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REALIZAR_OTRA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	//public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
	
	
	public boolean ComerExtCartaFianzaSolicitudAutorizar(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
	
		try {
			Gstr_ID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			Gstr_FIRMANTE= Rst_Funcionalidad.getObject("FIRMANTE") != null ? Rst_Funcionalidad.getString("FIRMANTE") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOTE = Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_SOLICITUD_DESDE= Rst_Funcionalidad.getObject("TXT_FECHA_SOLICITUD_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_SOLICITUD_DESDE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_SOLICITUD_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_SOLICITUD_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_SOLICITUD_HASTA") : Mdl_Variables.Gstr_Ignore;
			//GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_SOLICITUDES_EXPIRADOS= Rst_Funcionalidad.getObject("LNK_VER_SOLICITUDES_EXPIRADOS") != null ? Rst_Funcionalidad.getString("LNK_VER_SOLICITUDES_EXPIRADOS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR_SOLICITUDES_EXPIRADOS= Rst_Funcionalidad.getObject("LNK_REGRESAR_SOLICITUDES_EXPIRADOS") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_SOLICITUDES_EXPIRADOS") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_TODOS= Rst_Funcionalidad.getObject("CHK_TODOS") != null ? Rst_Funcionalidad.getString("CHK_TODOS") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_LOTE= Rst_Funcionalidad.getObject("CHK_LOTE") != null ? Rst_Funcionalidad.getString("CHK_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DETALLE= Rst_Funcionalidad.getObject("LNK_VER_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_VER_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR_DETALLE= Rst_Funcionalidad.getObject("LNK_REGRESAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_DESCARGAR_DETALLE= Rst_Funcionalidad.getObject("LNK_DESCARGAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_DESCARGAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BLOQUEAR= Rst_Funcionalidad.getObject("BTN_BLOQUEAR") != null ? Rst_Funcionalidad.getString("BTN_BLOQUEAR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_OPERACION= Rst_Funcionalidad.getObject("LNK_VER_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_VER_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrIMG_DESCARGAR_OPERACION= Rst_Funcionalidad.getObject("IMG_DESCARGAR_OPERACION") != null ? Rst_Funcionalidad.getString("IMG_DESCARGAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_QUIERES_SABER_COMO= Rst_Funcionalidad.getObject("LNK_QUIERES_SABER_COMO") != null ? Rst_Funcionalidad.getString("LNK_QUIERES_SABER_COMO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REALIZAR_OTRA_OPERACION= Rst_Funcionalidad.getObject("LNK_REALIZAR_OTRA_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_REALIZAR_OTRA_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL_FINAL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_FINAL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_FINAL= Rst_Funcionalidad.getObject("TXT_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("TXT_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_FINAL= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_FINAL= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_FINAL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_FINAL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_FINAL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_FINAL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_FINAL= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_FINAL") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
