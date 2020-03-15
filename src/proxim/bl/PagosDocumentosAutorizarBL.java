package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosDocumentosAutorizarBL extends PagosDocumentosAutorizarBE {

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	PagosDocumentosMapeo objPagoDocumentosBE = new PagosDocumentosMapeo();
	HeaderBL objHeader = new HeaderBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	public boolean PagoDocumentosAutorizar(int valor,boolean consultar) throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String strFechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());	
		
		try {

			
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			
			if (objFuncionesGenerales.verificarIgnore(GstrVALIDAR_POP))
			{	
				if(GstrVALIDAR_POP.equals("SI")){
					
					if (objFuncionesGenerales.verificarIgnore("CLICK"))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPagoDocumentosBE.verificarMensajeInformativo())
						{	
							objFuncionesGenerales.callPasosAcierto(6, " EL MENSAJE INFORMATIVO" , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(6, " EL MENSAJE INFORMATIVO" , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if(bandera){
						if (objFuncionesGenerales.verificarIgnore("CLICK"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							if (objPagoDocumentosBE.ingresoAceptar()){	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosDocumentos();
								
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				objPagoDocumentosBE.verificarCamposObligatoriosDocumentos();
				if (objPagoDocumentosBE.seleccionarSubMenu1(GstrTXT_SUBMENU1))
				{	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					TipoLog="1";
					objPagoDocumentosBE.verificarCamposObligatoriosAutorizar();
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
						
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarEmpresa_Autorizar(GstrCMB_EMPRESA))
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
			
			if (objFuncionesGenerales.verificarIgnore(PagosDocumentosBE.GstrCMB_TIPO_DOCUMENTO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarTipoDocumentoAutorizar(PagosDocumentosBE.GstrCMB_TIPO_DOCUMENTO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DOCUMENTO "+PagosDocumentosBE.GstrCMB_TIPO_DOCUMENTO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DOCUMENTO "+PagosDocumentosBE.GstrCMB_TIPO_DOCUMENTO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosDocumentosBE.strCMB_MONEDA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarMonedaAutorizar(PagosDocumentosBE.strCMB_MONEDA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+PagosDocumentosBE.strCMB_MONEDA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+PagosDocumentosBE.strCMB_MONEDA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
//			Date fechaActual=new Date();
//			DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");	
//
//			GstrTXT_FECHA_SOLICITUD_DESDE= formatoFecha.format(fechaActual);
//			objSQL.ActualizarTabla("APP_PAGOS_DOCUMENTOS_AUTORIZAR_D", "TXT_FECHA_SOLICITUD_DESDE", GstrTXT_FECHA_SOLICITUD_DESDE, Gstr_ID_CASO);
//			GstrTXT_FECHA_SOLICITUD_HASTA= formatoFecha.format(fechaActual);
//			objSQL.ActualizarTabla("APP_PAGOS_DOCUMENTOS_AUTORIZAR_D", "TXT_FECHA_SOLICITUD_HASTA", GstrTXT_FECHA_SOLICITUD_HASTA, Gstr_ID_CASO);
//			
			if (objFuncionesGenerales.verificarIgnore(strFechaBusqueda))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objPagoDocumentosBE.ingresarFechaInicioOperacionAutorizar(strFechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA PAGO DESDE: "+strFechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA PAGO DESDE: "+strFechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			   	objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(strFechaBusqueda))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objPagoDocumentosBE.ingresarFechaFinOperacionAutorizar(strFechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA PAGO HASTA: "+strFechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA PAGO HASTA: "+strFechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			   	objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_PAGOS_EXPIRADOS)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		  
				if (objPagoDocumentosBE.ingresoVerPagosExpiradosAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Ver Pagos Expirados");
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Ver Pagos Expirados");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_PAGOS_EXPIRADOS)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		  
				if (objPagoDocumentosBE.ingresoRegresarPagosExpiradosAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link REGRESAR");
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link REGRESAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		  
				if (objPagoDocumentosBE.ingresoBotonBuscarAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					objPagoDocumentosBE.verificarTablaAutorizacion();
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCHK_TODOS))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoChkTodosAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check TODOS");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check TODOS");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoLinkEnviarEmailAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objPagoDocumentosBE.ingresarCorreoAutorizacion( GstrTXT_CORREO_AUTORIZAR))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objPagoDocumentosBE.ingresarMensajeCorreoAutorizacion( GstrTXT_MENSAJE_CORREO_AUTORIZAR))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonEnviarAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_AUTORIZAR ))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
				objPagoDocumentosBE.verificarMensajeCorreoAutorizacion();
				if (objPagoDocumentosBE.ingresoBotonAceptarCorreoAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoLinkExportarExcelAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoLinkExportarPDFAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoLinkImprimirAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//				PagDocumentosBL.TIPO_DOCUMENTO="Letra";
//				PagDocumentosBL.NUMERO_DOCUMENTO="0070602011";
//				PagDocumentosBL.RELACION="Aceptante";
//				PagDocumentosBL.SITUACION_ESTADO="Vencido";
//				PagDocumentosBL.MONEDA="Soles";
//				PagDocumentosBL.IMPORTE_TOTAL_PAGAR="1,222.00";
//				PagDocumentosBL.FECHA_VENCIMIENTO="19/01/2017";
				
				if (objPagoDocumentosBE.seleccionarLoteFirmar(PagosDocumentosAutorizarBE.GstrCMB_EMPRESA,PagosDocumentosBE.TIPO_DOCUMENTO,PagosDocumentosBE.NUMERO_DOCUMENTO,PagosDocumentosBE.RELACION,PagosDocumentosBE.SITUACION_ESTADO,PagosDocumentosBE.MONEDA,PagosDocumentosBE.IMPORTE_TOTAL_PAGAR,PagosDocumentosBE.FECHA_VENCIMIENTO)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check del LOTE a Enviar");
					Thread.sleep(200);
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check del LOTE a Enviar");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.verDetalleLoteFirmar(PagosDocumentosAutorizarBE.GstrCMB_EMPRESA,PagosDocumentosBE.TIPO_DOCUMENTO,PagosDocumentosBE.NUMERO_DOCUMENTO,PagosDocumentosBE.RELACION,PagosDocumentosBE.SITUACION_ESTADO,PagosDocumentosBE.MONEDA,PagosDocumentosBE.IMPORTE_TOTAL_PAGAR,PagosDocumentosBE.FECHA_VENCIMIENTO)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el link para VER el detalle del LOTE a Enviar");
						objPagoDocumentosBE.verificarDetalleLoteEnviar();
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el link para VER el detalle del LOTE a Enviar");
					}
					
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.RegresarLinkDetalle()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el link Regresar del detalle del LOTE a Enviar");
						objPagoDocumentosBE.verificarTablaAutorizacion();
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el link Regresar del detalle del LOTE a Enviar");
					}
					
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_AUTORIZAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonAutorizarAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AUTORIZAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AUTORIZAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.verificarMensajeFinalAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(5, " el Mensaje Informativo", "Mensaje esperado" ,"");
					TipoLog="1";
					Thread.sleep(15000);
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, " el Mensaje Informativo", "Mensaje esperado" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore("CLICK") && GstrTXT_COLUMNA_ERROR.equals("BTN_AUTORIZAR"))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.ingresoMensajeAceptar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_BLOQUEAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonBloquearAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BLOQUEAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BLOQUEAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_VER_CONFIRMACION)){	
				objPagoDocumentosBE.verificarConfirmarOperacionAutorizacion();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoLinkVerOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Número Documento");
					TipoLog="1";
					objPagoDocumentosBE.verificarConfirmarDetalleOperacionAutorizacion();
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Número Documento");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore( GstrLNK_REGRESAR_CONFIRMACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoLinkRegresarDetalleVerOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Ver");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Ver");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			if(GstrTXT_CLAVE.equals("SI")){
				objPagoDocumentosBE.verificarConfirmarOperacionAutorizacion();
				if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.ingresoClaveAutorizar(Mdl_Variables.Gstr_Clave)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña", Mdl_Variables.Gstr_Clave,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña", Mdl_Variables.Gstr_Clave,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CLAVE_DINAMICA)){	
				objPagoDocumentosBE.verificarConfirmarOperacionAutorizacion();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresarClaveDinamicaAutorizacion( GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica", GstrTXT_CLAVE_DINAMICA,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica", GstrTXT_CLAVE_DINAMICA,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
	//---------------------------------------------------------------		
//			if (objFuncionesGenerales.verificarIgnore( GstrLNK_QUIERES_SABER_COMO)){	
//				objPagoDocumentosBE.verificarConfirmarOperacionAutorizacion();
//				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//				if (objPagoDocumentosBE.ingresoLinkQuieresSaberComoAutorizacion()){	
//					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Quieres Saber Como");
//					TipoLog="1";
//				}else{
//					TipoLog="0";			
//					bandera = false;
//					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Quieres Saber Como");
//				}
//				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONFIRMAR)){	
				objPagoDocumentosBE.verificarConfirmarOperacionAutorizacion();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonConfirmarAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					TipoLog="1";
					
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CANCELAR_OPERACION)){
				objPagoDocumentosBE.verificarConfirmarOperacionAutorizacion();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonCancelarOperacionAutorizacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			Thread.sleep(15000);
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO))
			{	
				if(objPagoDocumentosBE.verificarmensajeFinal()){
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.compararResultadoEsperadoPositivoAutorizar(GstrRESULTADO_ESPERADO))
					{	
						objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado ", " Resultado Obtenido" ,"");
						TipoLog="1";
						
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado ", " Resultado Obtenido" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					
				}}
		    		
			if(bandera && consultar==true&& GstrTXT_COLUMNA_ERROR.equals("<IGNORE>")){
				bandera=objConsultaHistoricaBL.consultaHistorico("Pago de Documentos",GstrCMB_EMPRESA,PagosDocumentosBE.strCMB_CUENTA_CARGO,1,PagosDocumentosBE.GstrESTADO,PagosDocumentosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS,PagosDocumentosBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
			}
				
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
		
	}
	
}
