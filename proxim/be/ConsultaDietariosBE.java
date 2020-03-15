package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaDietariosBE {
	//GENERAL

		public static String Gstr_ID_CASO= Mdl_Variables.Gstr_Ignore;
		public static String Gstr_ID_CASO_LOGIN= Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENU= Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_SUBMENU1= Mdl_Variables.Gstr_Ignore;
		public static String GstrCMB_EMPRESA= Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_FECHA_DESDE= Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_FECHA_HASTA= Mdl_Variables.Gstr_Ignore;
		public static String GstrCMB_CUENTA_CARGO= Mdl_Variables.Gstr_Ignore;
		
		public static String GstrTXT_COLUMNA_ERROR= Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENSAJE_ERROR= Mdl_Variables.Gstr_Ignore;
		
		public static String GstrBTN_BUSCAR= Mdl_Variables.Gstr_Ignore;
		
		public static String GstrLNK_EXPORTAR_CSV= Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_EXCEL= Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_EXPORTAR_PDF= Mdl_Variables.Gstr_Ignore;

		public static String GstrRESULTADO_ESPERADO= Mdl_Variables.Gstr_Ignore;
		public static String GstrLNK_CERRAR_SESION= Mdl_Variables.Gstr_Ignore;

		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
			boolean bandera = true; 
			try {
				//GENERAL
				Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_FECHA_DESDE =Rst_Funcionalidad.getObject("TXT_FECHA_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DESDE") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_FECHA_HASTA =Rst_Funcionalidad.getObject("TXT_FECHA_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA") : Mdl_Variables.Gstr_Ignore;				
				GstrCMB_CUENTA_CARGO = Rst_Funcionalidad.getObject("CMB_CUENTA_CARGO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_CARGO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_BUSCAR =Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_EXPORTAR_CSV  = Rst_Funcionalidad.getObject("LNK_EXPORTAR_CSV") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_CSV") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL  = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				
				GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;				
				
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}
}
