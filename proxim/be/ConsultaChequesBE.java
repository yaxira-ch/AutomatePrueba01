package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaChequesBE {
	public static String GstrID_CASO = Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERO_CHEQUE = Mdl_Variables.Gstr_Ignore;
	public static String GstrRBTN_OTROS_VALORES = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_SITUACION_CHEQUE = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_DESDE = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_HASTA = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXORTAR_EXCEL = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR = Mdl_Variables.Gstr_Ignore;

	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_CUENTA = Rst_Funcionalidad.getObject("CMB_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_CUENTA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_CHEQUE = Rst_Funcionalidad.getObject("TXT_NUMERO_CHEQUE") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CHEQUE") : Mdl_Variables.Gstr_Ignore;
			GstrRBTN_OTROS_VALORES = Rst_Funcionalidad.getObject("RBTN_OTROS_VALORES") != null ? Rst_Funcionalidad.getString("RBTN_OTROS_VALORES") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_SITUACION_CHEQUE = Rst_Funcionalidad.getObject("CMB_SITUACION_CHEQUE") != null ? Rst_Funcionalidad.getString("CMB_SITUACION_CHEQUE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_DESDE = Rst_Funcionalidad.getObject("TXT_FECHA_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DESDE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_HASTA = Rst_Funcionalidad.getObject("TXT_FECHA_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR = Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXORTAR_EXCEL = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;

			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		
		return bandera;
		}
}
