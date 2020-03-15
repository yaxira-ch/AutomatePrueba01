package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PortabilidadAutorizacionBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrRUTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTIE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SIGUIENTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SIGUIENTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AUTORIZACIONES_PENDIENTES=Mdl_Variables.Gstr_Ignore;
	public static String GstrTIPO_CARTA_FIANZA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBL_TIPO_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String gstrLblTipoProducto=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AUTORIZAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BLOQUEAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBL_DESCRIPCION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBL_ESTADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_HISTORIAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrINTENTOS_PREVIOS_CAPCHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAPCHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_ACEPTAR=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrBTN_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLBL_MONTO=Mdl_Variables.Gstr_Ignore;
	
	public boolean Portabilidad(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrRUTA=Rst_Funcionalidad.getObject("RUTA") != null ? Rst_Funcionalidad.getString("RUTA") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOTE=Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrTIE=Rst_Funcionalidad.getObject("TIE") != null ? Rst_Funcionalidad.getString("TIE") : Mdl_Variables.Gstr_Ignore;
			GstrCLAVE = Rst_Funcionalidad.getObject("CLAVE") != null ? Rst_Funcionalidad.getString("CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE = Rst_Funcionalidad.getObject("FIRMANTE") != null ? Rst_Funcionalidad.getString("FIRMANTE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SIGUIENTE = Rst_Funcionalidad.getObject("BTN_SIGUIENTE") != null ? Rst_Funcionalidad.getString("BTN_SIGUIENTE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SIGUIENTE1 = Rst_Funcionalidad.getObject("BTN_SIGUIENTE1") != null ? Rst_Funcionalidad.getString("BTN_SIGUIENTE1") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AUTORIZACIONES_PENDIENTES = Rst_Funcionalidad.getObject("BTN_AUTORIZACIONES_PENDIENTES") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZACIONES_PENDIENTES") : Mdl_Variables.Gstr_Ignore;
			GstrTIPO_CARTA_FIANZA= Rst_Funcionalidad.getObject("TIPO_CARTA_FIANZA") != null ? Rst_Funcionalidad.getString("TIPO_CARTA_FIANZA") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_TIPO_OPERACION = Rst_Funcionalidad.getObject("LBL_TIPO_OPERACION") != null ? Rst_Funcionalidad.getString("LBL_TIPO_OPERACION") : Mdl_Variables.Gstr_Ignore;
			gstrLblTipoProducto = Rst_Funcionalidad.getObject("LBL_TIPO_PRODUCTO") != null ? Rst_Funcionalidad.getString("LBL_TIPO_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_AUTORIZAR =Rst_Funcionalidad.getObject("CHK_AUTORIZAR") != null ? Rst_Funcionalidad.getString("CHK_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AUTORIZAR =Rst_Funcionalidad.getObject("BTN_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BLOQUEAR=Rst_Funcionalidad.getObject("BTN_BLOQUEAR") != null ? Rst_Funcionalidad.getString("BTN_BLOQUEAR") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_DESCRIPCION=Rst_Funcionalidad.getObject("LBL_DESCRIPCION") != null ? Rst_Funcionalidad.getString("LBL_DESCRIPCION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;				  
			GstrRESULTADO_ESPERADO = Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_HISTORIAL= Rst_Funcionalidad.getObject("BTN_HISTORIAL") != null ? Rst_Funcionalidad.getString("BTN_HISTORIAL") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_ESTADO= Rst_Funcionalidad.getObject("LBL_ESTADO") != null ? Rst_Funcionalidad.getString("LBL_ESTADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrINTENTOS_PREVIOS_CAPCHA= Rst_Funcionalidad.getObject("INTENTOS_PREVIOS_CAPCHA") != null ? Rst_Funcionalidad.getString("INTENTOS_PREVIOS_CAPCHA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAPCHA= Rst_Funcionalidad.getObject("TXT_CAPCHA") != null ? Rst_Funcionalidad.getString("TXT_CAPCHA") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_ACEPTAR= Rst_Funcionalidad.getObject("CHK_ACEPTAR") != null ? Rst_Funcionalidad.getString("CHK_ACEPTAR") : Mdl_Variables.Gstr_Ignore;
			
			GstrBTN_ENVIAR_EMAIL= Rst_Funcionalidad.getObject("BTN_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR= Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR= Rst_Funcionalidad.getObject("BTN_CERRAR") != null ? Rst_Funcionalidad.getString("BTN_CERRAR") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MONTO= Rst_Funcionalidad.getObject("LBL_MONTO") != null ? Rst_Funcionalidad.getString("LBL_MONTO") : Mdl_Variables.Gstr_Ignore;
			

		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	

}


