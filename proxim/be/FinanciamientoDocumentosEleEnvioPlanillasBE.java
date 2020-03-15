package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;
public class FinanciamientoDocumentosEleEnvioPlanillasBE {

	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_CARGA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SELECCIONAR_ARCHIVO=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_PROVEEDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_CLIENTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_PRODUCTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA_CARGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_PLANILLA=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_CON_CONFIRMACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_SIN_CONFIRMACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AGREGAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CREAR_PLANILLA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_TODOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String  GstrENVIO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SI_POP_UP=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_NO_POP_UP=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	public static String GstrOPERADOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_MONTO_TOTAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_RESULTADO_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_NUMERO_PLANILLA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCONSULTAR_SALDOS_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;


		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
			boolean bandera = true; 
			try {
				//GENERAL
				Gstr_ID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				
				Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMAR= Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_CARGA = Rst_Funcionalidad.getObject("CMB_TIPO_CARGA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CARGA") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_SELECCIONAR_ARCHIVO= Rst_Funcionalidad.getObject("BTN_SELECCIONAR_ARCHIVO") != null ? Rst_Funcionalidad.getString("BTN_SELECCIONAR_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
				GstrRDB_PROVEEDOR = Rst_Funcionalidad.getObject("RDB_PROVEEDOR") != null ? Rst_Funcionalidad.getString("RDB_PROVEEDOR") : Mdl_Variables.Gstr_Ignore;
				GstrRDB_CLIENTE= Rst_Funcionalidad.getObject("RDB_CLIENTE") != null ? Rst_Funcionalidad.getString("RDB_CLIENTE") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_PRODUCTO = Rst_Funcionalidad.getObject("CMB_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_MONEDA= Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_CUENTA_CARGO= Rst_Funcionalidad.getObject("CMB_CUENTA_CARGO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_CARGO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_NOMBRE_PLANILLA = Rst_Funcionalidad.getObject("TXT_NOMBRE_PLANILLA") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_PLANILLA") : Mdl_Variables.Gstr_Ignore;
				GstrRDB_CON_CONFIRMACION= Rst_Funcionalidad.getObject("RDB_CON_CONFIRMACION") != null ? Rst_Funcionalidad.getString("RDB_CON_CONFIRMACION") : Mdl_Variables.Gstr_Ignore;
				GstrRDB_SIN_CONFIRMACION= Rst_Funcionalidad.getObject("RDB_SIN_CONFIRMACION") != null ? Rst_Funcionalidad.getString("RDB_SIN_CONFIRMACION") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_AGREGAR= Rst_Funcionalidad.getObject("BTN_AGREGAR") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				
				GstrBTN_CREAR_PLANILLA= Rst_Funcionalidad.getObject("BTN_CREAR_PLANILLA") != null ? Rst_Funcionalidad.getString("BTN_CREAR_PLANILLA") : Mdl_Variables.Gstr_Ignore;
				GstrCHK_TODOS= Rst_Funcionalidad.getObject("CHK_TODOS") != null ? Rst_Funcionalidad.getString("CHK_TODOS") : Mdl_Variables.Gstr_Ignore;
				GstrCHK_LOTE= Rst_Funcionalidad.getObject("CHK_LOTE") != null ? Rst_Funcionalidad.getString("CHK_LOTE") : Mdl_Variables.Gstr_Ignore;
				//GstrLNK_REGRESAR_DETALLE= Rst_Funcionalidad.getObject("LNK_REGRESAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
				
				GstrBTN_ENVIAR= Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CLAVE= Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
				
				GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_SI_POP_UP= Rst_Funcionalidad.getObject("BTN_SI_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_NO_POP_UP= Rst_Funcionalidad.getObject("BTN_NO_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrENVIO_LOTE= Rst_Funcionalidad.getObject("ENVIO_LOTE") != null ? Rst_Funcionalidad.getString("ENVIO_LOTE") : Mdl_Variables.Gstr_Ignore;
				GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_ENVIAR_EMAIL_PROCESADO = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_PROCESADO= Rst_Funcionalidad.getObject("TXT_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_PROCESADO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_PROCESADO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_PROCESADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_PROCESADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_PROCESADO = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_PROCESADO") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_ENVIAR_EMAIL_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_BLOQUEADOS= Rst_Funcionalidad.getObject("TXT_CORREO_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("TXT_CORREO_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO_BLOQUEADOS= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_BLOQUEADOS= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			
				GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMANTE1= Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMANTE2= Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMANTE3= Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
				GstrOPERADOR= Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
				GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
				GstrCONSULTAR_SALDOS_MOVIMIENTOS= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}	
	}