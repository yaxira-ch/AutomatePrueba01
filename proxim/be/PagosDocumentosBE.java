package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PagosDocumentosBE {
	
	public static String Gstr_ID_CASO =Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrVALIDAR_POP=Mdl_Variables.Gstr_Ignore;
	public static String GstrVALIDAR_TAP=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String strCMB_BUSQUEDA=Mdl_Variables.Gstr_Ignore;
	public static String strCMB_SITUACION=Mdl_Variables.Gstr_Ignore;
	public static String strCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String strTXT_NRO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String strBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String strTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String strTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String strNUMERO_DOCUMENTOS=Mdl_Variables.Gstr_Ignore;
	public static String strBTN_CONTINUAR=Mdl_Variables.Gstr_Ignore;
	public static String strCMB_CUENTA_CARGO=Mdl_Variables.Gstr_Ignore;
	public static String strTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String strBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String strBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String strRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String strLBN_ESTADO_LOTE_MENSAJE=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	//public static String GstrOPERADOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrPOTERGACION=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_PROCESADO=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrCMB_SITUACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_MONTO_TOTAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_RESULTADO_FINAL=Mdl_Variables.Gstr_Ignore;
	
	public static String TIPO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String NUMERO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String RELACION=Mdl_Variables.Gstr_Ignore;
	public static String SITUACION_ESTADO=Mdl_Variables.Gstr_Ignore;
	public static String MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String IMPORTE_TOTAL_PAGAR=Mdl_Variables.Gstr_Ignore;
	public static String FECHA_VENCIMIENTO=Mdl_Variables.Gstr_Ignore;
	 
	public static String GstrLNK_ENVIAR_EMAIL_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_BLOQUEADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCONSULTAR_SALDOS_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
		
	
	public static String GstrID_CASO_LOTE;//es el id de descuento y cobranza al cual corresponde
			
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			
				Gstr_ID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				GstrID_CASO_LOGIN= Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
				GstrVALIDAR_POP = Rst_Funcionalidad.getObject("VALIDAR_POP") != null ? Rst_Funcionalidad.getString("VALIDAR_POP") : Mdl_Variables.Gstr_Ignore;
				GstrVALIDAR_TAP= Rst_Funcionalidad.getObject("VALIDAR_TAP") != null ? Rst_Funcionalidad.getString("VALIDAR_TAP") : Mdl_Variables.Gstr_Ignore;
				
				
				
				GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_DOCUMENTO= Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				
				strCMB_BUSQUEDA = Rst_Funcionalidad.getObject("CMB_BUSQUEDA") != null ? Rst_Funcionalidad.getString("CMB_BUSQUEDA") : Mdl_Variables.Gstr_Ignore;
				strCMB_SITUACION = Rst_Funcionalidad.getObject("CMB_SITUACION") != null ? Rst_Funcionalidad.getString("CMB_SITUACION") : Mdl_Variables.Gstr_Ignore;
				strCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				strTXT_NRO_DOCUMENTO = Rst_Funcionalidad.getObject("TXT_NRO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NRO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				strTXT_COLUMNA_ERROR = Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				strBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				strTXT_MENSAJE_ERROR = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				strNUMERO_DOCUMENTOS = Rst_Funcionalidad.getObject("NUMERO_DOCUMENTOS") != null ? Rst_Funcionalidad.getString("NUMERO_DOCUMENTOS") : Mdl_Variables.Gstr_Ignore;
				strBTN_CONTINUAR = Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
				strCMB_CUENTA_CARGO = Rst_Funcionalidad.getObject("CMB_CUENTA_CARGO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_CARGO") : Mdl_Variables.Gstr_Ignore;
				strTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
				strBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
				strBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
				strRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				strLBN_ESTADO_LOTE_MENSAJE= Rst_Funcionalidad.getObject("LBN_ESTADO_LOTE_MENSAJE") != null ? Rst_Funcionalidad.getString("LBN_ESTADO_LOTE_MENSAJE") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMAR= Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMANTE1= Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMANTE2= Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMANTE3= Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
				GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_CERRAR_SESION = Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				GstrCONSULTAR_SALDOS_MOVIMIENTOS= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				GstrPOTERGACION= Rst_Funcionalidad.getObject("POSTERGACION") != null ? Rst_Funcionalidad.getString("POSTERGACION") : Mdl_Variables.Gstr_Ignore;
				
				
				GstrLNK_ENVIAR_EMAIL_PROCESADO = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_PROCESADO= Rst_Funcionalidad.getObject("TXT_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_PROCESADO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_PROCESADO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO_PROCESADO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_PROCESADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_PROCESADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_PROCESADO = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_SITUACION= Rst_Funcionalidad.getObject("CMB_SITUACION") != null ? Rst_Funcionalidad.getString("CMB_SITUACION") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_ENVIAR_EMAIL_BLOQUEADO = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_BLOQUEADO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_BLOQUEADO= Rst_Funcionalidad.getObject("TXT_CORREO_BLOQUEADO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_BLOQUEADO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_BLOQUEADO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_BLOQUEADO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_BLOQUEADO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO_BLOQUEADO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_BLOQUEADO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_BLOQUEADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_BLOQUEADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_BLOQUEADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_BLOQUEADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_BLOQUEADO = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_BLOQUEADO") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_BLOQUEADO") : Mdl_Variables.Gstr_Ignore;
				
				GstrID_CASO_LOTE= Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
				
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}

}
