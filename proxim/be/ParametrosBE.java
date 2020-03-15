package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ParametrosBE {
	public static String GstrID = "";
	public static String GstrTABLA = "";
	public static String GstrTIPO = "";
	public static String GstrNOMBRE = "";
	public static String GstrDESCRIPCION = "";
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			GstrID = Rst_Funcionalidad.getObject("ID") != null ? Rst_Funcionalidad.getString("ID") : Mdl_Variables.Gstr_Ignore;
			GstrTABLA = Rst_Funcionalidad.getObject("TABLA") != null ? Rst_Funcionalidad.getString("TABLA") : Mdl_Variables.Gstr_Ignore;
			GstrTIPO = Rst_Funcionalidad.getObject("TIPO") != null ? Rst_Funcionalidad.getString("TIPO") : Mdl_Variables.Gstr_Ignore;
			GstrNOMBRE = Rst_Funcionalidad.getObject("NOMBRE") != null ? Rst_Funcionalidad.getString("NOMBRE") : Mdl_Variables.Gstr_Ignore;
			GstrDESCRIPCION = Rst_Funcionalidad.getObject("DESCRIPCION") != null ? Rst_Funcionalidad.getString("DESCRIPCION") : Mdl_Variables.Gstr_Ignore;
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
}
