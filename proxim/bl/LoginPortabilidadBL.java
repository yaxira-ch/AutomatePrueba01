package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.dao.ConexionDriver;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class LoginPortabilidadBL {
	boolean bandera = true;
	String lngHoraFin;
	long lngTiempoEjeCaso;
	String lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	private static String strTipoLog = null;
	PortabilidadMapeo objPortabilidadAutorizacionMapeo=new PortabilidadMapeo();
	String strTextoImagen="1. Imagenes";
	
	public boolean loginPortabilidad(String strTIE,String strCLAVE,String strTxtCapcha,String strBtnSiguiente,String strBtnSiguiente1) throws SQLException, IOException{
		
		try {
			
			Mdl_Variables.Gstr_Url=Mdl_Variables.Gstr_UrlPorta;
			ConexionDriver.conexion();
			
			if (objFuncionesGenerales.verificarIgnore(strTIE)){	
				lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPortabilidadAutorizacionMapeo.IngresarTIE(strTIE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La TIE ", strTIE,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La TIE ", strTIE,"");
				}
				lngHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),lngHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(strCLAVE)){	
				lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPortabilidadAutorizacionMapeo.ingresarClave(strCLAVE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave ", strCLAVE,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave ", strCLAVE,"");
				}
				lngHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),lngHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtCapcha))
			{
    			lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	    
    			if (objPortabilidadAutorizacionMapeo.ingresarCapcha(strTxtCapcha))
				{
					objFuncionesGenerales.callPasosAcierto(3, "el texto del CAPCHA" , strTxtCapcha ,  "");
					strTipoLog="1";
					if (strTxtCapcha.equals("*")) {
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    					Thread.sleep(20000);
    					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    				}
				}else{
					strTipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "el texto del CAPCHA" , strTxtCapcha ,  "");
				}
    			lngHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),lngHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnSiguiente))
			{	
				lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Thread.sleep(1000);
				if (objPortabilidadAutorizacionMapeo.ingresoBotonSiguiente()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SIGUIENTE ");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SIGUIENTE");
				}
				lngHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),lngHoraInicio);
	    		Thread.sleep(1800);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnSiguiente1)){	
				lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPortabilidadAutorizacionMapeo.ingresoBotonSiguiente1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SIGUIENTE");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SIGUIENTE");
				}
				lngHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),lngHoraInicio);
				Thread.sleep(1000);
			}
			

	    	
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}

	public boolean logOffPortabilidad(String strLnkCerrarSession) throws SQLException, IOException{
			
		try {
			if (objFuncionesGenerales.verificarIgnore(strLnkCerrarSession)){	
				lngHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Thread.sleep(500);
				if (objPortabilidadAutorizacionMapeo.ingresoCerrarCesion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR SESION");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR SESION");
				}
				lngHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(lngHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),lngHoraInicio);
			}

	    	FuncionesGenerales.CerrarPantallas();
	    	
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
}
