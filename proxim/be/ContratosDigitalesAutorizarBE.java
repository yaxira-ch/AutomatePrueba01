package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ContratosDigitalesAutorizarBE {
	
	public static String GstrID_CASO =Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN =Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE =Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOTE =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1 =Mdl_Variables.Gstr_Ignore;
	public static String GstrIND_EMPRESA =Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA =Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_SELECCIONAR_REGISTRO =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DETALLE =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_USUARIOS_CON_ACCESO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_POPUP_USUARIOS_CON_ACCESOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_AGREGAR_FIRMA_SOLICITUD_SI =Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI =Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO =Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_AGREGAR_FIRMA_SOLICITUD_NO =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_FIRMAR_Y_ENVIAR =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_FIRMAR_Y_GUARDAR =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR =Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO1 =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_USUARIOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_VER_USUARIOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_TERMINOS_CONDICIONES =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_TERMINOS_CONDICIONES =Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_ACEPTO_TERMINOS_CONDICIONES =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA =Mdl_Variables.Gstr_Ignore;
	public static String strBtnPago =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_QUIERES_SABER_COMO =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR_OPERACION =Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO2 =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_USUARIOS2=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_VER_USUARIOS2=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION =Mdl_Variables.Gstr_Ignore;
	public static String GstrDESIGN_STEPS =Mdl_Variables.Gstr_Ignore;
	public static String GstrDESCRIPTION =Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO_CASO =Mdl_Variables.Gstr_Ignore;
	public static String GstrUTILIZADO =Mdl_Variables.Gstr_Ignore;
	public static String GstrACIERTO_ERROR =Mdl_Variables.Gstr_Ignore;
	public static String GstrEJECUCION_AC_ERR =Mdl_Variables.Gstr_Ignore;
	public static String GstrTIEMPO_EJECUCION =Mdl_Variables.Gstr_Ignore;
	
	
	
	public boolean ContratosDigitalesAutorizar(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE = Rst_Funcionalidad.getObject("FIRMANTE") != null ? Rst_Funcionalidad.getString("FIRMANTE") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOTE = Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrIND_EMPRESA= Rst_Funcionalidad.getObject("IND_EMPRESA") != null ? Rst_Funcionalidad.getString("IND_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_SELECCIONAR_REGISTRO= Rst_Funcionalidad.getObject("CHK_SELECCIONAR_REGISTRO") != null ? Rst_Funcionalidad.getString("CHK_SELECCIONAR_REGISTRO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DETALLE= Rst_Funcionalidad.getObject("LNK_VER_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_VER_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_USUARIOS_CON_ACCESO= Rst_Funcionalidad.getObject("LNK_VER_USUARIOS_CON_ACCESO") != null ? Rst_Funcionalidad.getString("LNK_VER_USUARIOS_CON_ACCESO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR= Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_POPUP_USUARIOS_CON_ACCESOS= Rst_Funcionalidad.getObject("BTN_CERRAR_POPUP_USUARIOS_CON_ACCESOS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POPUP_USUARIOS_CON_ACCESOS") : Mdl_Variables.Gstr_Ignore;			
			GstrBTN_CERRAR_DETALLE= Rst_Funcionalidad.getObject("LNK_VER_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_VER_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrRBT_AGREGAR_FIRMA_SOLICITUD_SI= Rst_Funcionalidad.getObject("RBT_AGREGAR_FIRMA_SOLICITUD_SI") != null ? Rst_Funcionalidad.getString("RBT_AGREGAR_FIRMA_SOLICITUD_SI") : Mdl_Variables.Gstr_Ignore;
			GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI= Rst_Funcionalidad.getObject("RBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI") != null ? Rst_Funcionalidad.getString("RBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI") : Mdl_Variables.Gstr_Ignore;
			GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO= Rst_Funcionalidad.getObject("RBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO") != null ? Rst_Funcionalidad.getString("RBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO") : Mdl_Variables.Gstr_Ignore;
			GstrRBT_AGREGAR_FIRMA_SOLICITUD_NO= Rst_Funcionalidad.getObject("RBT_AGREGAR_FIRMA_SOLICITUD_NO") != null ? Rst_Funcionalidad.getString("RBT_AGREGAR_FIRMA_SOLICITUD_NO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_FIRMAR_Y_ENVIAR= Rst_Funcionalidad.getObject("BTN_FIRMAR_Y_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_FIRMAR_Y_ENVIAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_FIRMAR_Y_GUARDAR= Rst_Funcionalidad.getObject("BTN_FIRMAR_Y_GUARDAR") != null ? Rst_Funcionalidad.getString("BTN_FIRMAR_Y_GUARDAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR= Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO1= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO1") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO1") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_USUARIOS= Rst_Funcionalidad.getObject("LNK_VER_USUARIOS") != null ? Rst_Funcionalidad.getString("LNK_VER_USUARIOS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_VER_USUARIOS= Rst_Funcionalidad.getObject("BTN_CERRAR_VER_USUARIOS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_VER_USUARIOS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("LNK_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("LNK_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("BTN_CERRAR_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_ACEPTO_TERMINOS_CONDICIONES = Rst_Funcionalidad.getObject("CHK_ACEPTO_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("CHK_ACEPTO_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			strBtnPago= Rst_Funcionalidad.getObject("BTN_PAGOS") != null ? Rst_Funcionalidad.getString("BTN_PAGOS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_QUIERES_SABER_COMO = Rst_Funcionalidad.getObject("BTN_CERRAR_QUIERES_SABER_COMO") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_QUIERES_SABER_COMO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CONFIRMAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			
			GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO2= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO2") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO2") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_USUARIOS2= Rst_Funcionalidad.getObject("LNK_VER_USUARIOS2") != null ? Rst_Funcionalidad.getString("LNK_VER_USUARIOS2") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_VER_USUARIOS2= Rst_Funcionalidad.getObject("BTN_CERRAR_VER_USUARIOS2") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_VER_USUARIOS2") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrDESIGN_STEPS= Rst_Funcionalidad.getObject("DESIGN_STEPS") != null ? Rst_Funcionalidad.getString("DESIGN_STEPS") : Mdl_Variables.Gstr_Ignore;
			GstrDESCRIPTION= Rst_Funcionalidad.getObject("DESCRIPTION") != null ? Rst_Funcionalidad.getString("DESCRIPTION") : Mdl_Variables.Gstr_Ignore;
			GstrESTADO_CASO = Rst_Funcionalidad.getObject("ESTADO_CASO") != null ? Rst_Funcionalidad.getString("ESTADO_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrUTILIZADO = Rst_Funcionalidad.getObject("UTILIZADO") != null ? Rst_Funcionalidad.getString("UTILIZADO") : Mdl_Variables.Gstr_Ignore;
			GstrACIERTO_ERROR = Rst_Funcionalidad.getObject("ACIERTO_ERROR") != null ? Rst_Funcionalidad.getString("ACIERTO_ERROR") : Mdl_Variables.Gstr_Ignore;
		
			GstrEJECUCION_AC_ERR = Rst_Funcionalidad.getObject("EJECUCION_AC_ERR") != null ? Rst_Funcionalidad.getString("EJECUCION_AC_ERR") : Mdl_Variables.Gstr_Ignore;
			GstrTIEMPO_EJECUCION= Rst_Funcionalidad.getObject("TIEMPO_EJECUCION") != null ? Rst_Funcionalidad.getString("TIEMPO_EJECUCION") : Mdl_Variables.Gstr_Ignore;
	
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}
	
	
	
}
