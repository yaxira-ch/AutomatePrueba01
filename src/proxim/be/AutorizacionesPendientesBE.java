package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;


public class AutorizacionesPendientesBE {

	//GENERAL
		public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
		public static String GstrID_CASO=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
		public static String GstrID_CASO_LOTE=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
		public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;//para realizar todo el ecenario completo
		public static String GstrCMB_TIPO_OPERACION=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
		public static String GstrCHK_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_BLOQUEAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
		public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
		public static String GstrDESCRIPTION=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
		public static String GstrTIPO_PRODUCTO=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_SI_POP_UP=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_NO_POP_UP=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_SI_POP_UP1=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_NO_POP_UP1=Mdl_Variables.Gstr_Ignore;
		
		public static String GstrLNK_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ACEPTAR_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
		
		public static String GstrLNK_REALIZAR_OTRA_OPERACION=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_ENVIAR_EMAIL_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENSAJE_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ENVIAR_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ACEPTAR_CORREO_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_EXCEL_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_PDF_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_IMPRIMIR_FINAL=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_ENVIAR_EMAIL_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CORREO_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENSAJE_CORREO_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ENVIAR_CORREO_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ACEPTAR_CORREO_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_EXCEL_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_PDF_DETALLE=Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_IMPRIMIR_DETALLE=Mdl_Variables.Gstr_Ignore;
		
		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
			boolean bandera = true; 
			try {

				//GENERAL
				Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				GstrID_CASO_LOTE= Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_OPERACION = Rst_Funcionalidad.getObject("CMB_TIPO_OPERACION") != null ? Rst_Funcionalidad.getString("CMB_TIPO_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrCHK_AUTORIZAR =Rst_Funcionalidad.getObject("CHK_AUTORIZAR") != null ? Rst_Funcionalidad.getString("CHK_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_AUTORIZAR =Rst_Funcionalidad.getObject("BTN_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_BLOQUEAR =Rst_Funcionalidad.getObject("BTN_BLOQUEAR") != null ? Rst_Funcionalidad.getString("BTN_BLOQUEAR") : Mdl_Variables.Gstr_Ignore;
				GstrTIPO_PRODUCTO =Rst_Funcionalidad.getObject("TIPO_PRODUCTO") != null ? Rst_Funcionalidad.getString("TIPO_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CLAVE=Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				GstrDESCRIPTION = Rst_Funcionalidad.getObject("DESCRIPTION") != null ? Rst_Funcionalidad.getString("DESCRIPTION") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_SI_POP_UP = Rst_Funcionalidad.getObject("BTN_SI_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_NO_POP_UP= Rst_Funcionalidad.getObject("BTN_NO_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_SI_POP_UP1 = Rst_Funcionalidad.getObject("BTN_SI_POP_UP1") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP1") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_NO_POP_UP1= Rst_Funcionalidad.getObject("BTN_NO_POP_UP1") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP1") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_REALIZAR_OTRA_OPERACION= Rst_Funcionalidad.getObject("LNK_REALIZAR_OTRA_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_REALIZAR_OTRA_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_ENVIAR_EMAIL_FINAL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_FINAL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_FINAL= Rst_Funcionalidad.getObject("TXT_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("TXT_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_FINAL= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_FINAL= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO_FINAL= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_FINAL") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_FINAL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_FINAL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_FINAL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_FINAL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_FINAL= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_FINAL") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_ENVIAR_EMAIL_DETALLE= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_DETALLE= Rst_Funcionalidad.getObject("TXT_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_DETALLE= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_DETALLE= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO_DETALLE= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_DETALLE= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_DETALLE= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_DETALLE") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_DETALLE= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_DETALLE") : Mdl_Variables.Gstr_Ignore;
		
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}	
	}