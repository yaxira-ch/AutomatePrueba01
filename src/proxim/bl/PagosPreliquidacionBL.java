package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosPreliquidacionBL extends PagosPreliquidacionBE {

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	PagosPreliquidacionMapeo objPagoPreliquidacionBE = new PagosPreliquidacionMapeo();
	
	String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	FirmarBL objFirmarBL =new FirmarBL();
	HeaderBL objHeader = new HeaderBL();
	public boolean pagoPreliquidacion() throws SQLException, IOException{
		boolean blnResultadoEsperado = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		int intNumeroFilaRegistro=0;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String strNumDocumento="<IGNORE>";
		
		
		try {

			if(objFuncionesGenerales.verificarIgnore( GstrBUSCAR_NRO_DOCUMENTO) ){
				strNumDocumento=GstrBUSCAR_NRO_DOCUMENTO;
			}else{
				strNumDocumento=GstrTXT_NRO_DOCUMENTO;
			}
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal( "<IGNORE>",GstrTXT_MENU, GstrTXT_SUBMENU);
			
			objPagoPreliquidacionBE.verificarCamposObligatorios();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoPreliquidacionBE.seleccionarEmpresa(GstrCMB_EMPRESA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_BUSQUEDA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoPreliquidacionBE.seleccionarBusqueda(GstrCMB_BUSQUEDA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la BUSQUEDA "+GstrCMB_BUSQUEDA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la BUSQUEDA "+GstrCMB_BUSQUEDA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_SITUACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoPreliquidacionBE.seleccionarSituacion(GstrCMB_SITUACION)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la SITUACION "+GstrCMB_SITUACION , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la SITUACION "+GstrCMB_SITUACION , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoPreliquidacionBE.seleccionarMoneda(GstrCMB_MONEDA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NRO_DOCUMENTO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoPreliquidacionBE.ingresarNroDocumento(GstrTXT_NRO_DOCUMENTO)){	
					objFuncionesGenerales.callPasosAcierto(3, "NUMERO DE DOCUMENTO: ", GstrTXT_NRO_DOCUMENTO ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE DOCUMENTO: ", GstrTXT_NRO_DOCUMENTO ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoPreliquidacionBE.ingresoBotonBuscar()){	
					objPagoPreliquidacionBE.verificarTabla();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
				
			if (objFuncionesGenerales.verificarIgnore( strNumDocumento) && objFuncionesGenerales.verificarIgnore(GstrLNK_NRO_DOCUMENTO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				intNumeroFilaRegistro=objPagoPreliquidacionBE.buscarSolicitudProcesada(strNumDocumento);
				if (intNumeroFilaRegistro!=0){	
					objFuncionesGenerales.callPasosAcierto(5, "", "" ,"con la Solicitud Procesada");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "", "" ,"con la Solicitud Procesada");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (intNumeroFilaRegistro!=0){	

				if (objFuncionesGenerales.verificarIgnore( GstrLNK_NRO_DOCUMENTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
					if (objPagoPreliquidacionBE.seleccionarSolicitudProcesada(intNumeroFilaRegistro)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Número de Documento");
						objPagoPreliquidacionBE.verificarConsultaPreliquidacion();
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Procesada");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.scrollCapturaPantalla();
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoLinkRegresar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link REGRESAR");
						objPagoPreliquidacionBE.verificarTabla();
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link REGRESAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_SELECCIONAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.seleccionarCheckNroDocumento(intNumeroFilaRegistro)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check Seleccionar");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check Seleccionar");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}

				if (objFuncionesGenerales.verificarIgnore(GstrBTN_PRELIQUIDAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoBotonPreliquidar()){	
						objPagoPreliquidacionBE.verificarCamposSeleccionarTipoLiquidacion();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón PRELIQUIDAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón PRELIQUIDAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_LIQUIDACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.seleccionarTipoLiquidacion(GstrCMB_TIPO_LIQUIDACION)){	
						objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE LIQUIDACION "+GstrCMB_TIPO_LIQUIDACION , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, "del TIPO DE LIQUIDACION "+GstrCMB_TIPO_LIQUIDACION , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUEVA_FECHA_VENCIMIENTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresarNuevaFechaVencimiento(GstrTXT_NUEVA_FECHA_VENCIMIENTO)){	
						objFuncionesGenerales.callPasosAcierto(3, "NUEVA FECHA VENCIMIENTO: ", GstrTXT_NUEVA_FECHA_VENCIMIENTO ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "NUEVA FECHA VENCIMIENTO: ", GstrTXT_NUEVA_FECHA_VENCIMIENTO ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUEVO_IMPORTE_DOCUMENTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresarNuevoImporteDocumento(GstrTXT_NUEVO_IMPORTE_DOCUMENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "NUEVO IMPORTE DOCUMENTO: ", GstrTXT_NUEVO_IMPORTE_DOCUMENTO ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "NUEVO IMPORTE DOCUMENTO: ", GstrTXT_NUEVO_IMPORTE_DOCUMENTO ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoBotonConfirmar()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
						objPagoPreliquidacionBE.verificarResultadoFinal();
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoBotonCancelarOperacion()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACION");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACION");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_FINAL)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoLmkRegresarFinal()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link REGRESAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link REGRESAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoLinkEnviarEmail()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresarCorreo(GstrTXT_CORREO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Correo : " + GstrTXT_CORREO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "El Correo : " + GstrTXT_CORREO, "" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresarMensajeCorreo(GstrTXT_MENSAJE_CORREO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_CORREO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_CORREO, "" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoBotonEnviar()){
						
						objPagoPreliquidacionBE.verificarMensajeCorreo();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoBotonAceptarCorreo()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ACEPTAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ACEPTAR CORREO");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoLinkExportarExcel()){
						
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoLinkExportarPDF()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoPreliquidacionBE.ingresoLinkImprimir()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				}
				
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
		
	}
	
}
