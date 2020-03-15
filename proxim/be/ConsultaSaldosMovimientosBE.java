package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaSaldosMovimientosBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_PRODUCTO	=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERO_CUENTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_NUMERO_CUENTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_ALIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_SALDO_DISPONIBLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_FECHA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_FECHA_PROCESO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_DESDE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_HASTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_CUENTA=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_TEXTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;

	public static String GstrBTN_SALDO_DISPONIBLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_DEPOSITOS_CHEQUES=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_SALDOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_SALDOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_SALDOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_SALDOS=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrCMB_EMPRESA_MOVIMIENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA_MOVIMIENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_REGRESAR_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_TEXTO_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrVALIDAR_SALDOS_CICS=Mdl_Variables.Gstr_Ignore;
	public static String GstrVALIDAR_MOVIMIENTOS_CICS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCODIGO_UBICACION=Mdl_Variables.Gstr_Ignore;
	public static String  GstrBTN_CERRAR_POP_UP=Mdl_Variables.Gstr_Ignore;
	public static String  GstrLNK_DESCARGAR_EXPORTABLE=Mdl_Variables.Gstr_Ignore;

		
		
		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
			boolean bandera = true; 
			try {

				//GENERAL
				Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_PRODUCTO= Rst_Funcionalidad.getObject("CMB_TIPO_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_NUMERO_CUENTA= Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_NUMERO_CUENTA = Rst_Funcionalidad.getObject("LNK_NUMERO_CUENTA") != null ? Rst_Funcionalidad.getString("LNK_NUMERO_CUENTA") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_ALIAS= Rst_Funcionalidad.getObject("TXT_ALIAS") != null ? Rst_Funcionalidad.getString("TXT_ALIAS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_SALDO_DISPONIBLE = Rst_Funcionalidad.getObject("LNK_SALDO_DISPONIBLE") != null ? Rst_Funcionalidad.getString("LNK_SALDO_DISPONIBLE") : Mdl_Variables.Gstr_Ignore;
				GstrRBT_FECHA_OPERACION= Rst_Funcionalidad.getObject("RBT_FECHA_OPERACION") != null ? Rst_Funcionalidad.getString("RBT_FECHA_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrRBT_FECHA_PROCESO = Rst_Funcionalidad.getObject("RBT_FECHA_PROCESO") != null ? Rst_Funcionalidad.getString("RBT_FECHA_PROCESO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_FECHA_DESDE = Rst_Funcionalidad.getObject("TXT_FECHA_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DESDE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_FECHA_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_BUSCAR = Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_CUENTA = Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_ENVIAR_TEXTO= Rst_Funcionalidad.getObject("LNK_ENVIAR_TEXTO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_TEXTO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
				
				GstrBTN_SALDO_DISPONIBLE= Rst_Funcionalidad.getObject("BTN_SALDO_DISPONIBLE") != null ? Rst_Funcionalidad.getString("BTN_SALDO_DISPONIBLE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_DEPOSITOS_CHEQUES= Rst_Funcionalidad.getObject("BTN_DEPOSITOS_CHEQUES") != null ? Rst_Funcionalidad.getString("BTN_DEPOSITOS_CHEQUES") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_REGRESAR_SALDOS= Rst_Funcionalidad.getObject("LNK_REGRESAR_SALDOS") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_SALDOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_SALDOS= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_SALDOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_SALDOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_SALDOS= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_SALDOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_SALDOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_SALDOS= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_SALDOS") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_SALDOS") : Mdl_Variables.Gstr_Ignore;
				
				GstrCMB_EMPRESA_MOVIMIENTO = Rst_Funcionalidad.getObject("CMB_EMPRESA_MOVIMIENTO") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA_MOVIMIENTO") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_CUENTA_MOVIMIENTO= Rst_Funcionalidad.getObject("CMB_CUENTA_MOVIMIENTO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_MOVIMIENTO") : Mdl_Variables.Gstr_Ignore;
				
				GstrCMB_CUENTA= Rst_Funcionalidad.getObject("CMB_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_CUENTA") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_REGRESAR_MOVIMIENTOS= Rst_Funcionalidad.getObject("LNK_REGRESAR_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_ENVIAR_TEXTO_MOVIMIENTOS= Rst_Funcionalidad.getObject("LNK_ENVIAR_TEXTO_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_TEXTO_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL_MOVIMIENTOS= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF_MOVIMIENTOS= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR_MOVIMIENTOS= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				
				GstrVALIDAR_SALDOS_CICS= Rst_Funcionalidad.getObject("VALIDAR_SALDOS_CICS") != null ? Rst_Funcionalidad.getString("VALIDAR_SALDOS_CICS") : Mdl_Variables.Gstr_Ignore;
				GstrVALIDAR_MOVIMIENTOS_CICS= Rst_Funcionalidad.getObject("VALIDAR_MOVIMIENTOS_CICS") != null ? Rst_Funcionalidad.getString("VALIDAR_MOVIMIENTOS_CICS") : Mdl_Variables.Gstr_Ignore;
				GstrCODIGO_UBICACION= Rst_Funcionalidad.getObject("CODIGO_UBICACION") != null ? Rst_Funcionalidad.getString("CODIGO_UBICACION") : Mdl_Variables.Gstr_Ignore;
				
				GstrBTN_CERRAR_POP_UP= Rst_Funcionalidad.getObject("BTN_CERRAR_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_DESCARGAR_EXPORTABLE= Rst_Funcionalidad.getObject("LNK_DESCARGAR_EXPORTABLE") != null ? Rst_Funcionalidad.getString("LNK_DESCARGAR_EXPORTABLE") : Mdl_Variables.Gstr_Ignore;
				
				
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}	
	}
