package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosDocumentosProcesadasBL extends PagosDocumentosBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	PagosDocumentosMapeo objPagoDocumentosBE = new PagosDocumentosMapeo();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean pagosDocumentosProcesadas(int valor) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;	
		String TipoLog = null;
		String LstrTXT_SUBMENU1="Pagos Procesados";
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		int intNumeroRegistro=0;
		try {
			
			//---------------------------------------MENU---------------------------------------
			if(valor==2){
				objHeader.menuPrincipal( "<IGNORE>",GstrTXT_MENU, GstrTXT_SUBMENU);
				
				objPagoDocumentosBE.verificarCamposObligatoriosDocumentos();
			}
			
			if (objFuncionesGenerales.verificarIgnore( LstrTXT_SUBMENU1)){	
				
				LStr_HoraInicio = System.currentTimeMillis();	  
				
				if (objPagoDocumentosBE.seleccionarSubMenu1( LstrTXT_SUBMENU1))
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
			{	
				objPagoDocumentosBE.verificarCamposObligatoriosProcesadas();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarEmpresaProcesadas(GstrCMB_EMPRESA))
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
			
					
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DOCUMENTO))
			{		
				objPagoDocumentosBE.verificarCamposObligatoriosProcesadas();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarTipoDocumentoProcesadas(GstrCMB_TIPO_DOCUMENTO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE DOCUMENTO "+GstrCMB_TIPO_DOCUMENTO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE DOCUMENTO "+GstrCMB_TIPO_DOCUMENTO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(strCMB_MONEDA))
			{		
				objPagoDocumentosBE.verificarCamposObligatoriosProcesadas();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarMonedaProcesadas(strCMB_MONEDA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+strCMB_MONEDA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+strCMB_MONEDA , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoDocumentosBE.ingresarFechaDesdeProcesadas(fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE SOLICITUD DESDE "+fechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE SOLICITUD DESDE "+fechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoDocumentosBE.ingresarFechaHastaProcesadas(fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE SOLICITUD HASTA "+fechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE SOLICITUD HASTA "+fechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
				
			if (objFuncionesGenerales.verificarIgnore("CLICK")){				
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoBotonBuscarProcesadas()){	
					objPagoDocumentosBE.verificarTablaProcesados();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			//CHA
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				System.out.println(">> CLICK - seleccionarSolicitudProcesada");
				//if (objPagoDocumentosBE.seleccionarSolicitudProcesada(PagDocumentosBL.strNUMERO_DOCUMENTOS,PagDocumentosBL.GstrCMB_EMPRESA,PagDocumentosBL.TIPO_DOCUMENTO,PagDocumentosBL.NUMERO_DOCUMENTO,PagDocumentosBL.RELACION,PagDocumentosBL.SITUACION_ESTADO,PagDocumentosBL.MONEDA,PagDocumentosBL.IMPORTE_TOTAL_PAGAR,PagDocumentosBL.FECHA_VENCIMIENTO)){	
				intNumeroRegistro=objPagoDocumentosBE.seleccionarSolicitudProcesada(PagosDocumentosBE.NUMERO_DOCUMENTO);
				if (intNumeroRegistro!=0){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Solicitud Procesada");
					System.out.println(">> CLICK - tipolog: 1");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Procesada");
					System.out.println(">> CLICK - tipolog: 0");
				}
				
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    //CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    			CapturarPantalla.scrollCapturaPantalla();
    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if(intNumeroRegistro!=0){
				if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					System.out.println(">> CLICK 02");
					//if (objPagoDocumentosBE.VerDetalleProcesada(PagDocumentosBL.strNUMERO_DOCUMENTOS,PagDocumentosAutorizarBL.GstrCMB_EMPRESA,PagDocumentosBL.TIPO_DOCUMENTO,PagDocumentosBL.NUMERO_DOCUMENTO,PagDocumentosBL.RELACION,PagDocumentosBL.SITUACION_ESTADO,PagDocumentosBL.MONEDA,PagDocumentosBL.IMPORTE_TOTAL_PAGAR,PagDocumentosBL.FECHA_VENCIMIENTO)){	
					if (objPagoDocumentosBE.VerDetalleProcesada(intNumeroRegistro))
							{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Solicitud Procesada");
						System.out.println(">> CLICK 02 - ING - VER DETALLE");
						TipoLog="1";
						Thread.sleep(500);
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Procesada");
						System.out.println(">> CLICK 02 - NO ING - VER DETALLE");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    //CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    			CapturarPantalla.scrollCapturaPantalla();
	    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
							
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_PROCESADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoLinkEnviarEmailProcesada()){	
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
				if (objPagoDocumentosBE.ingresarCorreoProcesada( GstrTXT_CORREO_PROCESADO))
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
				if (objPagoDocumentosBE.ingresarMensajeCorreoProcesada( GstrTXT_MENSAJE_CORREO_PROCESADO))
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
				if (objPagoDocumentosBE.ingresoBotonEnviarProcesada()){	
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
				objPagoDocumentosBE.verificarMensajeCorreoProcesado();
				if (objPagoDocumentosBE.ingresoBotonAceptarCorreoProcesado()){	
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
				if (objPagoDocumentosBE.ingresoLinkExportarExcelProcesada()){	
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
				if (objPagoDocumentosBE.ingresoLinkExportarPDFProcesada()){	
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
				if (objPagoDocumentosBE.ingresoLinkImprimirProcesada()){	
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
			
		} catch (Exception e) {
			bandera=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	
		}
		return bandera;
	}
}