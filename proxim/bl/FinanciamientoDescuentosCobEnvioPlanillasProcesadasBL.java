package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobEnvioPlanillasProcesadasBL extends FinanciamientoDescuentosCobEnvioPlanillasGeneralBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo objFinanciamientoDescuentosCobEnvioPlanillasBE = new FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();

	public boolean financiamientoDescuentosCobEnvioPlanillasProcesadas(int valor) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;
		String TipoLog = null;
		String LstrTXT_SUBMENU1="Planillas Procesadas";
		int intNumeroRegistro=0;
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		//HeaderBL objHeader = new HeaderBL();
		
		try {
			
			//---------------------------------------MENU---------------------------------------
			if(valor==2){
				//objHeader.menuPrincipal( GstrTXT_MENU, GstrTXT_SUBMENU);
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENU)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					
					if (objFuncionesGenerales.seleccionarMenu( GstrTXT_MENU))
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el MENU "+GstrTXT_MENU );
						TipoLog="1";
					}else{
						TipoLog="0";		
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el MENU "+GstrTXT_MENU);
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
	
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_SUBMENU)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					
					if (objFinanciamientoDescuentosCobEnvioPlanillasBE.seleccionarSubMenu( GstrTXT_SUBMENU))
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción "+GstrTXT_SUBMENU);
						TipoLog="1";
					}else{
						TipoLog="0";		
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción "+GstrTXT_SUBMENU);
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				objFuncionesGenerales.clicMenu();
				objFinanciamientoDescuentosCobEnvioPlanillasBE.verificarEnvioCamposObligatorios();
			}
			
			if (objFuncionesGenerales.verificarIgnore( LstrTXT_SUBMENU1)){	
				
				LStr_HoraInicio = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.seleccionarSubMenu1( LstrTXT_SUBMENU1))
				{	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la pestaña "+LstrTXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la pestaña "+LstrTXT_SUBMENU1);
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			//------------------------------------------------------------------------------
			
			objFinanciamientoDescuentosCobEnvioPlanillasBE.verificarCamposObligatoriosGeneral();
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.seleccionarEmpresaProcesadas( GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_PRODUCTO)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.seleccionarProductoProcesadas( GstrCMB_PRODUCTO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( fechaBusqueda)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresarFechaOperacionDesdeProcesadas( fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DESDE "+fechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "La FECHA DESDE "+fechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore( fechaBusqueda)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresarFechaOperacionHastaProcesadas( fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA HASTA "+fechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "La FECHA HASTA "+fechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				
				LStr_HoraInicio = System.currentTimeMillis();	  
						
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoBotonBuscarProcesadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
					objFinanciamientoDescuentosCobEnvioPlanillasBE.verificarTablaProcesados();	
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoLinkEnviarEmailFinalProcesada()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresarCorreo( GstrTXT_CORREO_PROCESADO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_PROCESADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_PROCESADO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO_PROCESADO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_PROCESADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_PROCESADO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_PROCESADO ))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	
				objFinanciamientoDescuentosCobEnvioPlanillasBE.verificarMensajeCorreo();
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoBotonAceptarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoLinkExportarExcelFinalProcesada()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoLinkExportarPDFFinalProcesada()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.ingresoLinkImprimirFinalProcesada()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				intNumeroRegistro=objFinanciamientoDescuentosCobEnvioPlanillasBE.seleccionarSolicitudProcesada();		
				if (intNumeroRegistro!=0){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Solicitud Procesada");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Procesada");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
						
			
			if (intNumeroRegistro!=0){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobEnvioPlanillasBE.verDetalleProcesada(intNumeroRegistro)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ," ver detalle de la Solicitud Procesada");
					TipoLog="1";
					objFinanciamientoDescuentosCobEnvioPlanillasBE.verificarDetalleProcesados();	
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ," ver detalle de la Solicitud Procesada");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
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