package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class FinanciamientoDesembolsoLineaBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SI=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_NO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_NUMERO_CUOTAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_FRECUENCIA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_CRONOGRAMA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_PRIMERA_CUOTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONTINUAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONTINUAR_REG=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION =Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBL_FECHA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBL_HORA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String StrInteres=Mdl_Variables.Gstr_Ignore;
	public static String StrMontoMoneda=Mdl_Variables.Gstr_Ignore;
	public static String StrTotal_Pagar=Mdl_Variables.Gstr_Ignore;
	public static String StrTEA=Mdl_Variables.Gstr_Ignore;
	public static String StrMontoPagar=Mdl_Variables.Gstr_Ignore;
	public static String GstrCONSULTAR_SALDOS_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrOPERADOR=Mdl_Variables.Gstr_Ignore;
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {
			Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR = Rst_Funcionalidad.getObject("BTN_ACEPTAR") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SI = Rst_Funcionalidad.getObject("BTN_SI") != null ? Rst_Funcionalidad.getString("BTN_SI") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_NO = Rst_Funcionalidad.getObject("BTN_NO") != null ? Rst_Funcionalidad.getString("BTN_NO") : Mdl_Variables.Gstr_Ignore;
			
			
			GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_NUMERO_CUOTAS = Rst_Funcionalidad.getObject("CMB_NUMERO_CUOTAS") != null ? Rst_Funcionalidad.getString("CMB_NUMERO_CUOTAS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO = Rst_Funcionalidad.getObject("TXT_MONTO") != null ? Rst_Funcionalidad.getString("TXT_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR_REG =Rst_Funcionalidad.getObject("BTN_CONTINUAR_REG") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR_REG") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;				  
			GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO = Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR = Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE1 = Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2 = Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3 = Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR =Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMAR = Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrESTADO = Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_CUENTA = Rst_Funcionalidad.getObject("CMB_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_CUENTA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR = Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_PRIMERA_CUOTA = Rst_Funcionalidad.getObject("TXT_FECHA_PRIMERA_CUOTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_PRIMERA_CUOTA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_CRONOGRAMA = Rst_Funcionalidad.getObject("CMB_TIPO_CRONOGRAMA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CRONOGRAMA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_FRECUENCIA = Rst_Funcionalidad.getObject("CMB_FRECUENCIA") != null ? Rst_Funcionalidad.getString("CMB_FRECUENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrCONSULTAR_SALDOS_MOVIMIENTOS	= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrOPERADOR= Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
			
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
