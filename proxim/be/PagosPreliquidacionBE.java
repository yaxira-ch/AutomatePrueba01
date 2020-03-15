package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PagosPreliquidacionBE {
	
	public static String Gstr_ID_CASO =Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN =Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_BUSQUEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_SITUACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NRO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUEVA_FECHA_VENCIMIENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUEVO_IMPORTE_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBUSCAR_NRO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_NRO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_SELECCIONAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_PRELIQUIDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_LIQUIDACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
			
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			
				Gstr_ID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				GstrID_CASO_LOGIN= Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_BUSQUEDA = Rst_Funcionalidad.getObject("CMB_BUSQUEDA") != null ? Rst_Funcionalidad.getString("CMB_BUSQUEDA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_SITUACION = Rst_Funcionalidad.getObject("CMB_SITUACION") != null ? Rst_Funcionalidad.getString("CMB_SITUACION") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_NRO_DOCUMENTO = Rst_Funcionalidad.getObject("TXT_NRO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NRO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				GstrBUSCAR_NRO_DOCUMENTO= Rst_Funcionalidad.getObject("BUSCAR_NRO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("BUSCAR_NRO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_NRO_DOCUMENTO= Rst_Funcionalidad.getObject("LNK_NRO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("LNK_NRO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_REGRESAR= Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
				GstrCHK_SELECCIONAR= Rst_Funcionalidad.getObject("CHK_SELECCIONAR") != null ? Rst_Funcionalidad.getString("CHK_SELECCIONAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_PRELIQUIDAR = Rst_Funcionalidad.getObject("BTN_PRELIQUIDAR") != null ? Rst_Funcionalidad.getString("BTN_PRELIQUIDAR") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_LIQUIDACION= Rst_Funcionalidad.getObject("CMB_TIPO_LIQUIDACION") != null ? Rst_Funcionalidad.getString("CMB_TIPO_LIQUIDACION") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_REGRESAR_FINAL= Rst_Funcionalidad.getObject("LNK_REGRESAR_FINAL") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_FINAL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_CORREO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
		
				GstrTXT_COLUMNA_ERROR = Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_ERROR = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_CERRAR_SESION = Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				
				GstrTXT_NUEVA_FECHA_VENCIMIENTO= Rst_Funcionalidad.getObject("TXT_NUEVA_FECHA_VENCIMIENTO") != null ? Rst_Funcionalidad.getString("TXT_NUEVA_FECHA_VENCIMIENTO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_NUEVO_IMPORTE_DOCUMENTO = Rst_Funcionalidad.getObject("TXT_NUEVO_IMPORTE_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NUEVO_IMPORTE_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				
				
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}

}
