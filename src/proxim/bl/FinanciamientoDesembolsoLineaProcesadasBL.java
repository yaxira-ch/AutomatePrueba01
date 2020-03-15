package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDesembolsoLineaProcesadasBL extends FinanciamientoDesembolsoLineaBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDesembolsoLineaGeneralMapeo objFinanciamientoDesembolsoLineaBE = new FinanciamientoDesembolsoLineaGeneralMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean FinanciamientoDesembolsoLineaProcesadas(int valor) throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio;
		String TipoLog = null;
		String LstrTXT_SUBMENU1="Solicitudes Procesadas";
		int intNumeroFilaRegistro=0;
		try {
			
			//---------------------------------------MENU---------------------------------------
			if(valor==2){
				objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
				objFinanciamientoDesembolsoLineaBE.verificarEnvioSolicitud();
			}
			
			if (objFuncionesGenerales.verificarIgnore( LstrTXT_SUBMENU1)){	
				
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDesembolsoLineaBE.seleccionarSubMenu1( LstrTXT_SUBMENU1))
				{	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la pestaña "+LstrTXT_SUBMENU1);
					TipoLog="1";
					objFinanciamientoDesembolsoLineaBE.verificarSolicitudesProcesadas();
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la pestaña "+LstrTXT_SUBMENU1);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			//------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDesembolsoLineaBE.seleccionarEmpresaProcesadas( GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLBL_FECHA_OPERACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				//objFinanciamientoDesembolsoLineaBE.verificarTerminarCargarProcesadas();
				if (objFinanciamientoDesembolsoLineaBE.ingresarFechaOperacionDesdeProcesadas( GstrLBL_FECHA_OPERACION))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DESDE "+GstrLBL_FECHA_OPERACION , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "La FECHA DESDE "+GstrLBL_FECHA_OPERACION , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore( GstrLBL_FECHA_OPERACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDesembolsoLineaBE.ingresarFechaOperacionHastaProcesadas( GstrLBL_FECHA_OPERACION))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA HASTA "+GstrLBL_FECHA_OPERACION , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "La FECHA HASTA "+GstrLBL_FECHA_OPERACION , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objFinanciamientoDesembolsoLineaBE.ingresoBotonBuscarProcesadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
    			objFinanciamientoDesembolsoLineaBE.verificarTerminarCargarProcesadas();	
    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				objFinanciamientoDesembolsoLineaBE.verificarTablaProcesada();
				intNumeroFilaRegistro=objFinanciamientoDesembolsoLineaBE.buscarSolicitudProcesada();
				if (intNumeroFilaRegistro!=0){	
					objFuncionesGenerales.callPasosAcierto(5, "", "" ,"con la Solicitud Procesada");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, "", "" ,"con la Solicitud Procesada");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
					if (objFinanciamientoDesembolsoLineaBE.seleccionarSolicitudProcesada(intNumeroFilaRegistro)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Solicitud Procesada");
						TipoLog="1";
						objFinanciamientoDesembolsoLineaBE.verificarDetalleProcesada();
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Procesada");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.scrollCapturaPantalla();
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}				
			
			
		} catch (Exception e) {
			bandera=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	
		}
		return bandera;
	}
}