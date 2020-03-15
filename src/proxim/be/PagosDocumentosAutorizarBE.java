package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PagosDocumentosAutorizarBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_FIRMANTE=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrVALIDAR_POP=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrCMB_TIPO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_SOLICITUD_DESDE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_SOLICITUD_HASTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_PAGOS_EXPIRADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_PAGOS_EXPIRADOS=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrCHK_TODOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_AUTORIZAR=Mdl_Variables.Gstr_Ignore; 
	public static String GstrLNK_VER=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_AUTORIZAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AUTORIZAR=Mdl_Variables.Gstr_Ignore;  
	public static String GstrBTN_BLOQUEAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_CONFIRMACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_CONFIRMACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore; 
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REALIZAR_OTRA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;

	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_MONTO_TOTAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_RESULTADO_FINAL=Mdl_Variables.Gstr_Ignore;
		

		public boolean PagosDocumentosAutorizar(ResultSet Rst_Funcionalidad){
			boolean bandera = true; 
			try {
				Gstr_ID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				Gstr_ID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				Gstr_ID_CASO_LOTE = Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
				//GstrLNK_SOLICITUD_EXPIRADA= Rst_Funcionalidad.getObject("LNK_SOLICITUD_EXPIRADA") != null ? Rst_Funcionalidad.getString("LNK_SOLICITUD_EXPIRADA") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				GstrCHK_TODOS= Rst_Funcionalidad.getObject("CHK_TODOS") != null ? Rst_Funcionalidad.getString("CHK_TODOS") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrVALIDAR_POP= Rst_Funcionalidad.getObject("VALIDAR_POP") != null ? Rst_Funcionalidad.getString("VALIDAR_POP") : Mdl_Variables.Gstr_Ignore;
				
				
				
				GstrCMB_TIPO_DOCUMENTO= Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				
				GstrCMB_MONEDA= Rst_Funcionalidad.getObject("CMD_MONEDA") != null ? Rst_Funcionalidad.getString("CMD_MONEDA") : Mdl_Variables.Gstr_Ignore;
				
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
				GstrTXT_FECHA_SOLICITUD_DESDE = Rst_Funcionalidad.getObject("TXT_FECHA_SOLICITUD_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_SOLICITUD_DESDE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_FECHA_SOLICITUD_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_SOLICITUD_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_SOLICITUD_HASTA") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_VER_PAGOS_EXPIRADOS= Rst_Funcionalidad.getObject("LNK_VER_PAGOS_EXPIRADOS") != null ? Rst_Funcionalidad.getString("LNK_VER_PAGOS_EXPIRADOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_REGRESAR_PAGOS_EXPIRADOS= Rst_Funcionalidad.getObject("LNK_REGRESAR_PAGOS_EXPIRADOS") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_PAGOS_EXPIRADOS") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_ENVIAR_EMAIL_AUTORIZAR = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_AUTORIZAR") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_AUTORIZAR= Rst_Funcionalidad.getObject("TXT_CORREO_AUTORIZAR") != null ? Rst_Funcionalidad.getString("TXT_CORREO_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_AUTORIZAR= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_AUTORIZAR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_AUTORIZAR = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_AUTORIZAR") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_AUTORIZAR = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_AUTORIZAR") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_AUTORIZAR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_AUTORIZAR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			
				GstrLNK_ENVIAR_EMAIL_AUTORIZAR_DETALLE = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_AUTORIZAR_DETALLE= Rst_Funcionalidad.getObject("TXT_CORREO_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_CORREO_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_AUTORIZAR_DETALLE= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_AUTORIZAR_DETALLE= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO_AUTORIZAR_DETALLE= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_AUTORIZAR_DETALLE = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_AUTORIZAR_DETALLE = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_AUTORIZAR_DETALLE = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_AUTORIZAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_AUTORIZAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
			
				GstrLNK_VER_CONFIRMACION = Rst_Funcionalidad.getObject("LNK_VER_CONFIRMACION") != null ? Rst_Funcionalidad.getString("LNK_VER_CONFIRMACION") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_REGRESAR_CONFIRMACION = Rst_Funcionalidad.getObject("LNK_REGRESAR_CONFIRMACION") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_CONFIRMACION") : Mdl_Variables.Gstr_Ignore;
				
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}	
	}