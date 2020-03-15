package proxim.bl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.MonitoreoTransaccionesGeneralBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class MonitoreoTransaccionesBL extends MonitoreoTransaccionesGeneralBE {
	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	MonitoreoTransaccionesMapeo objMonitoreoTransaccionesBE = new MonitoreoTransaccionesMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL(); 

	public boolean monitoreoTransacciones() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		
		try {
			boolean bArchivo = false;
			if (objFuncionesGenerales.verificarIgnore(strRUTA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFuncionesGenerales.verificarIgnore(strNOMBRE_ARCHIVO)){
					objFuncionesGenerales.callPasosAcierto(2, "ARCHIVO DE TEXTO", "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "ARCHIVO DE TEXTO", "" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    //CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (bArchivo){	//CARGAR ARCHIO DE TEXTO
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objMonitoreoTransaccionesBE.CargarLote(strID_CASO,strRUTA,strNOMBRE_ARCHIVO)){	
					//objMonitoreoTransaccionesBE.CargarLote("1","D:\\CHOUCAIR\\INFORMACION\\DATA MATRIZ\\MONITOREO DE TRANSFERENCIAS", "BIE_20160811.txt");
					objFuncionesGenerales.callPasosAcierto(4, "valores del archivo" + strNOMBRE_ARCHIVO, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(4, "valores del archivo" + strNOMBRE_ARCHIVO, "" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    //CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;	
		
	}
	

	public boolean LogTransacciones() throws SQLException, IOException{
		boolean bandera = false;
		/*String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		boolean Lbln_Bandera=false;
*/
		try {
			
				bandera = objMonitoreoTransaccionesBE.GuardarLog();
				
		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        /*CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );*/
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;	
		
	}
	
	public boolean LogInsertarTransaccion(String strTipoTransaccion,String strID_CASO,String strGrupoEjecucion) throws SQLException, IOException{
		boolean bandera = false;
		/*String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		boolean Lbln_Bandera=false;
*/
		try {
			switch (strTipoTransaccion.toUpperCase())
			{
				case "ENTRE CUENTAS":
					bandera = objMonitoreoTransaccionesBE.InsertarLog("TRANSFERENCIA ENTRE CUENTAS", strID_CASO, strGrupoEjecucion);
					break;
				case "TRANSFERENCIA ENTRE CUENTAS":
					bandera = objMonitoreoTransaccionesBE.InsertarLog("TRANSFERENCIA ENTRE CUENTAS", strID_CASO, strGrupoEjecucion);
					break;
				case "A TERCEROS":
					bandera = objMonitoreoTransaccionesBE.InsertarLog("TRANSFERENCIA A TERCEROS", strID_CASO, strGrupoEjecucion);
					break;
				case "TRANSFERENCIA A TERCEROS":
					bandera = objMonitoreoTransaccionesBE.InsertarLog("TRANSFERENCIA A TERCEROS", strID_CASO, strGrupoEjecucion);
					break;
			}
		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        /*CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );*/
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;	
		
	}
	
	
	
	
	
}
