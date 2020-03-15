package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PortabilidadConsultaSaldosBE {
	public static String GstrID_CASO= "";
	public static String GstrRUTA= "";
	public static String GstrID_CASO_LOTE= "";
	public static String GstrTIE= "";
	public static String GstrCLAVE= "";
	public static String GstrFIRMANTE= "";
	public static String GstrTXT_CAPCHA= "";
	public static String GstrBTN_SIGUIENTE= "";
	public static String GstrBTN_SIGUIENTE1= "";
	public static String GstrBTN_CONSULTA_SALDOS= "";
	public static String GstrCMB_EMPRESA= "";
	public static String GstrBTN_ENVIAR_EMAIL= "";
	public static String GstrTXT_CORREO= "";
	public static String GstrTXT_MENSAJE_CORREO= "";
	public static String GstrBTN_ENVIAR_CORREO= "";
	public static String GstrBTN_CERRAR_CORREO= "";
	public static String GstrBTN_SELECCIONAR_CUENTA= "";
	public static String GstrLBL_GLOSA= "";
	public static String GstrLBL_ORDENANTE= "";
	public static String GstrLBL_FECHA= "";
	public static String GstrLBL_TIPO= "";
	public static String GstrLBL_MONTO= "";
	public static String GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS= "";
	public static String GstrTXT_CORREO_MOVIMIENTOS= "";
	public static String GstrTXT_MENSAJE_CORREO_MOVIMIENTOS= "";
	public static String GstrBTN_ENVIAR_CORREO_MOVIMIENTOS= "";
	public static String GstrBTN_CERRAR_CORREO_MOVIMIENTOS= "";
	public static String GstrBTN_CERRAR_SESION= "";
	public static String GstrCICS= "";
	public static String GstrTABLA_CARGA= "";
	public static String GstrOPERACION_FECHA= "";
	public static String GstrOPERACION_HORA= "";
	public static String GstrID_CASO_LOGIN= "";
	public static String GstrLNK_NUMERO_CUENTA= "";
	public static String GstrCMB_TIPO_PRODUCTO= "";
	public static String GstrCMB_MONEDA= "";
	public static String GstrUTILIZADO_CICS= "";
	public static String GstrTIPO_OPERACION= "";
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrRUTA = Rst_Funcionalidad.getObject("RUTA") != null ? Rst_Funcionalidad.getString("RUTA") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOTE = Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrTIE = Rst_Funcionalidad.getObject("TIE") != null ? Rst_Funcionalidad.getString("TIE") : Mdl_Variables.Gstr_Ignore;
			GstrCLAVE = Rst_Funcionalidad.getObject("CLAVE") != null ? Rst_Funcionalidad.getString("CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE = Rst_Funcionalidad.getObject("FIRMANTE") != null ? Rst_Funcionalidad.getString("FIRMANTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAPCHA = Rst_Funcionalidad.getObject("TXT_CAPCHA") != null ? Rst_Funcionalidad.getString("TXT_CAPCHA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SIGUIENTE = Rst_Funcionalidad.getObject("BTN_SIGUIENTE") != null ? Rst_Funcionalidad.getString("BTN_SIGUIENTE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SIGUIENTE1 = Rst_Funcionalidad.getObject("BTN_SIGUIENTE1") != null ? Rst_Funcionalidad.getString("BTN_SIGUIENTE1") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONSULTA_SALDOS = Rst_Funcionalidad.getObject("BTN_CONSULTA_SALDOS") != null ? Rst_Funcionalidad.getString("BTN_CONSULTA_SALDOS") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("BTN_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO = Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO = Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_CORREO = Rst_Funcionalidad.getObject("BTN_CERRAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_NUMERO_CUENTA = Rst_Funcionalidad.getObject("LNK_NUMERO_CUENTA") != null ? Rst_Funcionalidad.getString("LNK_NUMERO_CUENTA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SELECCIONAR_CUENTA = Rst_Funcionalidad.getObject("BTN_SELECCIONAR_CUENTA") != null ? Rst_Funcionalidad.getString("BTN_SELECCIONAR_CUENTA") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_GLOSA = Rst_Funcionalidad.getObject("LBL_GLOSA") != null ? Rst_Funcionalidad.getString("LBL_GLOSA") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_ORDENANTE=Rst_Funcionalidad.getObject("LBL_ORDENANTE") != null ? Rst_Funcionalidad.getString("LBL_ORDENANTE") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_FECHA= Rst_Funcionalidad.getObject("LBL_FECHA") != null ? Rst_Funcionalidad.getString("LBL_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MONTO = Rst_Funcionalidad.getObject("LBL_MONTO") != null ? Rst_Funcionalidad.getString("LBL_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS = Rst_Funcionalidad.getObject("BTN_ENVIAR_EMAIL_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_EMAIL_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_MOVIMIENTOS = Rst_Funcionalidad.getObject("TXT_CORREO_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("TXT_CORREO_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_MOVIMIENTOS = Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_MOVIMIENTOS = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_CORREO_MOVIMIENTOS = Rst_Funcionalidad.getObject("BTN_CERRAR_CORREO_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_CORREO_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_SESION= Rst_Funcionalidad.getObject("BTN_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrCICS= Rst_Funcionalidad.getObject("CICS") != null ? Rst_Funcionalidad.getString("CICS") : Mdl_Variables.Gstr_Ignore;
			GstrTABLA_CARGA= Rst_Funcionalidad.getObject("TABLA_CARGA") != null ? Rst_Funcionalidad.getString("TABLA_CARGA") : Mdl_Variables.Gstr_Ignore;
			GstrOPERACION_FECHA= Rst_Funcionalidad.getObject("OPERACION_FECHA") != null ? Rst_Funcionalidad.getString("OPERACION_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrOPERACION_HORA= Rst_Funcionalidad.getObject("OPERACION_HORA") != null ? Rst_Funcionalidad.getString("OPERACION_HORA") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN= Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_PRODUCTO= Rst_Funcionalidad.getObject("CMB_TIPO_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
			GstrUTILIZADO_CICS= Rst_Funcionalidad.getObject("UTILIZADO_CICS") != null ? Rst_Funcionalidad.getString("UTILIZADO_CICS") : Mdl_Variables.Gstr_Ignore;
			GstrTIPO_OPERACION= Rst_Funcionalidad.getObject("TIPO_OPERACION") != null ? Rst_Funcionalidad.getString("TIPO_OPERACION") : Mdl_Variables.Gstr_Ignore;
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
}
