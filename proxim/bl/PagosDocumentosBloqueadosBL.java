package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.PagosDocumentosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosDocumentosBloqueadosBL extends PagosDocumentosBE{

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosDocumentosMapeo objPagoDocumentosBE = new PagosDocumentosMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	String subMenu="Pagos Bloqueados";
	HeaderBL objHeader = new HeaderBL();
	
	public boolean PagosDocumentosBloqueados(int valor) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;	
		int intNumeroRegistro=0;
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		try {
			//-------------------------------------------------------MENU----------------------------------------------------------------
			if(valor==2){
				objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
				objPagoDocumentosBE.verificarCamposObligatoriosDocumentos();
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(subMenu)){	
				
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarSubMenu1(subMenu)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+subMenu);
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+subMenu);
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			//---------------------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
			{	
				objPagoDocumentosBE.verificarCamposObligatoriosBloqueados();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarEmpresaBloqueado(GstrCMB_EMPRESA))
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
				objPagoDocumentosBE.verificarCamposObligatoriosBloqueados();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarTipoDocumentoBloqueado(GstrCMB_TIPO_DOCUMENTO))
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
				objPagoDocumentosBE.verificarCamposObligatoriosBloqueados();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.seleccionarMonedaBloqueado(strCMB_MONEDA))
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
				if (objPagoDocumentosBE.ingresarFechaDesdeBloqueado(fechaBusqueda))
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
				if (objPagoDocumentosBE.ingresarFechaHastaBloqueado(fechaBusqueda))
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
				if (objPagoDocumentosBE.ingresoBotonBuscarBloqueado()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				objPagoDocumentosBE.verificarTablaProcesados();
				//if (objPagoDocumentosBE.seleccionarSolicitudProcesada(PagDocumentosAutorizarBL.GstrCMB_EMPRESA,PagDocumentosBL.TIPO_DOCUMENTO,PagDocumentosBL.NUMERO_DOCUMENTO,PagDocumentosBL.RELACION,PagDocumentosBL.SITUACION_ESTADO,PagDocumentosBL.MONEDA,PagDocumentosBL.IMPORTE_TOTAL_PAGAR,PagDocumentosBL.FECHA_VENCIMIENTO)){	
				intNumeroRegistro=objPagoDocumentosBE.seleccionarSolicitudBloqueada(PagosDocumentosBE.NUMERO_DOCUMENTO);
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
			    //CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    			CapturarPantalla.scrollCapturaPantalla();
    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if(intNumeroRegistro!=0){
				if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					
					if (objPagoDocumentosBE.VerDetalleProcesada(intNumeroRegistro)){	
						//if (objPagoDocumentosBE.VerDetalleProcesada(PagDocumentosAutorizarBL.GstrCMB_EMPRESA,PagDocumentosBL.TIPO_DOCUMENTO,PagDocumentosBL.NUMERO_DOCUMENTO,PagDocumentosBL.RELACION,PagDocumentosBL.SITUACION_ESTADO,PagDocumentosBL.MONEDA,PagDocumentosBL.IMPORTE_TOTAL_PAGAR,PagDocumentosBL.FECHA_VENCIMIENTO)){	
							
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Solicitud Procesada");
						TipoLog="1";
						Thread.sleep(500);
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Procesada");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    //CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    			CapturarPantalla.scrollCapturaPantalla();
	    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
							
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoLinkEnviarEmailBloqueadas()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoDocumentosBE.ingresarCorreoBloqueadas( GstrTXT_CORREO_BLOQUEADO))
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoDocumentosBE.ingresarMensajeCorreoBloqueadas( GstrTXT_MENSAJE_CORREO_BLOQUEADO))
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoBotonEnviarBloqueadas()){	
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
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoLinkExportarExcelBloqueadas()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoLinkExportarPDFBloqueadas()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_BLOQUEADO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoDocumentosBE.ingresoLinkImprimirBloqueadas()){	
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
			
		}catch (Exception e) {
			bandera = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
}
	