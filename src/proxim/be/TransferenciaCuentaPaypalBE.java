package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class TransferenciaCuentaPaypalBE {
	public static String GstrID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AFILIAR_CUENTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTARAFILIACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_MENSAJE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_USUARIO_PAYPAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrBTN_ACEPTAR_NO_AFILIADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AFILIAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_TERMINOS_CONDICIONES=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CONTRASENA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrTXT_MONTO_RETIRAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_MINIMO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_MAXIMO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_SUPERA_LIMITE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_RETIRAR_FONDOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR_RETIRO=Mdl_Variables.Gstr_Ignore;
	public static String GstrVERIFICAR_CAMPOS=Mdl_Variables.Gstr_Ignore;
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			GstrID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_SUBMENU = Rst_Funcionalidad.getObject("LNK_SUBMENU1") != null ? Rst_Funcionalidad.getString("LNK_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AFILIAR_CUENTA= Rst_Funcionalidad.getObject("BTN_AFILIAR_CUENTA") != null ? Rst_Funcionalidad.getString("BTN_AFILIAR_CUENTA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_USUARIO_PAYPAL= Rst_Funcionalidad.getObject("TXT_USUARIO_PAYPAL") != null ? Rst_Funcionalidad.getString("TXT_USUARIO_PAYPAL") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_NO_AFILIADO = Rst_Funcionalidad.getObject("BTN_ACEPTAR_NO_AFILIADO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_NO_AFILIADO") : Mdl_Variables.Gstr_Ignore;
			
			GstrCMB_CUENTA= Rst_Funcionalidad.getObject("CMB_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_CUENTA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AFILIAR= Rst_Funcionalidad.getObject("BTN_AFILIAR") != null ? Rst_Funcionalidad.getString("BTN_AFILIAR") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_TERMINOS_CONDICIONES = Rst_Funcionalidad.getObject("CHK_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("CHK_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CONTRASENA= Rst_Funcionalidad.getObject("TXT_CONTRASENA") != null ? Rst_Funcionalidad.getString("TXT_CONTRASENA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CANCELAR= Rst_Funcionalidad.getObject("BTN_CANCELAR") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR= Rst_Funcionalidad.getObject("BTN_ACEPTAR") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTARAFILIACION= Rst_Funcionalidad.getObject("BTN_ACEPTARAFILIACION") != null ? Rst_Funcionalidad.getString("BTN_ACEPTARAFILIACION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_MENSAJE= Rst_Funcionalidad.getObject("BTN_ACEPTAR_MENSAJE") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_MENSAJE") : Mdl_Variables.Gstr_Ignore;
			
			GstrTXT_MONTO_RETIRAR= Rst_Funcionalidad.getObject("TXT_MONTO_RETIRAR") != null ? Rst_Funcionalidad.getString("TXT_MONTO_RETIRAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO_MINIMO= Rst_Funcionalidad.getObject("TXT_MONTO_MINIMO") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MINIMO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO_MAXIMO= Rst_Funcionalidad.getObject("TXT_MONTO_MAXIMO") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MAXIMO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO_SUPERA_LIMITE= Rst_Funcionalidad.getObject("TXT_MONTO_SUPERA_LIMITE") != null ? Rst_Funcionalidad.getString("TXT_MONTO_SUPERA_LIMITE") : Mdl_Variables.Gstr_Ignore;
			
			
			GstrBTN_RETIRAR_FONDOS= Rst_Funcionalidad.getObject("BTN_RETIRAR_FONDOS") != null ? Rst_Funcionalidad.getString("BTN_RETIRAR_FONDOS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE= Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR_RETIRO= Rst_Funcionalidad.getObject("BTN_CONFIRMAR_RETIRO") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR_RETIRO") : Mdl_Variables.Gstr_Ignore;
			GstrVERIFICAR_CAMPOS= Rst_Funcionalidad.getObject("VERIFICAR_CAMPOS") != null ? Rst_Funcionalidad.getString("VERIFICAR_CAMPOS") : Mdl_Variables.Gstr_Ignore;
			
			
			
		
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}

