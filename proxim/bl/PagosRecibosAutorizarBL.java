package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.ObjetosGenerales;
import proxim.be.PagosRecibosAutorizarBE;
import proxim.be.PagosRecibosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosRecibosAutorizarBL extends PagosRecibosAutorizarBE{

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosRecibosMapeo objPagoRecibosBE = new PagosRecibosMapeo();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	HeaderBL objHeader = new HeaderBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	String strCadena = "S/.";
	String strTexto; 
	
	public boolean PagosRecibosAutorizar(int valor,boolean consultar) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;	
		String strFechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());	
		try {
					//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
				objPagoRecibosBE.verificarPestania();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			//---------------------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
			{	
				objPagoRecibosBE.verificarPagoResivos();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarEmpresaAutorizar(GstrCMB_EMPRESA))
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
			
					
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO))
			{		
				LStr_HoraInicio = System.currentTimeMillis();	
				objPagoRecibosBE.verificarPagoResivos();
				if (objPagoRecibosBE.seleccionarCuenta(GstrCMB_CUENTA_CARGO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(strFechaBusqueda))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarFechaSolicitudDesdeAutorizar(strFechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA SOLICITUD DESDE: "+strFechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA SOLICITUD DESDE: "+strFechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(strFechaBusqueda))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarFechaSolicitudHastaAutorizar(strFechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA SOLICITUD HASTA: "+strFechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA SOLICITUD HASTA: "+strFechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
				LStr_HoraInicio = System.currentTimeMillis();
				
				if (objPagoRecibosBE.ingresoBotonBuscarAutorizar()){
					objPagoRecibosBE.verificarTablaAutorizar();
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

			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkEnviarEmailAutorizar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 	
				if (objPagoRecibosBE.ingresarCorreoAutorizar( GstrTXT_CORREO_AUTORIZAR))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 	
				if (objPagoRecibosBE.ingresarMensajeCorreoAutorizar( GstrTXT_MENSAJE_CORREO_AUTORIZAR))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoBotonEnviarAutorizar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_AUTORIZAR ))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				objPagoRecibosBE.verificarMensajeCorreoAutorizar();
				if (objPagoRecibosBE.ingresoBotonAceptarCorreoAutorizar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkExportarExcelAutorizar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkExportarPDFAutorizar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_AUTORIZAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkImprimirAutorizar()){	
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
			//------------------------------------------
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS)){	
				
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarLoteAutorizacion()){	//considerar fechaaaaaaa
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Pago a Autorizar");
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Pago a Autorizar");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objPagoRecibosBE.seleccionarVerDetalleAutorizacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Pago para ver el Detalle");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Pago para ver el Detalle");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkEnviarEmailAutorizarDetalle()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 	
					if (objPagoRecibosBE.ingresarCorreoAutorizar( GstrTXT_CORREO_AUTORIZAR_DETALLE))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 	
					if (objPagoRecibosBE.ingresarMensajeCorreoAutorizar( GstrTXT_MENSAJE_CORREO_AUTORIZAR_DETALLE))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoBotonEnviarAutorizar()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_AUTORIZAR ))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					objPagoRecibosBE.verificarMensajeCorreoAutorizar();
					if (objPagoRecibosBE.ingresoBotonAceptarCorreoAutorizar()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkExportarExcelAutorizarDetalle()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkExportarPDFAutorizarDetalle()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_AUTORIZAR_DETALLE))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkImprimirAutorizarDetalle()){	
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
				//------------------------
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR)){	
					objPagoRecibosBE.verificarDetalleAutorizar();
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objPagoRecibosBE.ingresoLinkRegresarAutorizar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link REGRESAR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link REGRESAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_AUTORIZAR)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				objPagoRecibosBE.verificarTablaAutorizar();
				if (objPagoRecibosBE.ingresoBotonAutorizarAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AUTORIZAR");
					objPagoRecibosBE.verificarContrasenaAutorizar();
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AUTORIZAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BLOQUEAR)){	
				LStr_HoraInicio = System.currentTimeMillis();	 
				objPagoRecibosBE.verificarTablaAutorizar();
				if (objPagoRecibosBE.ingresoBotonBloquearAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BLOQUEAR");
				}
				else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BLOQUEAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if( GstrTXT_CLAVE.equals("SI")){
				if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
					
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CLAVE_DINAMICA)){	
				LStr_HoraInicio = System.currentTimeMillis();	
				objPagoRecibosBE.verificarContrasenaAutorizar();
				if (objPagoRecibosBE.ingresarClaveDinamicaAutorizar(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CLAVE DINAMICA ", GstrTXT_CLAVE_DINAMICA,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La CLAVE DINAMICA ", GstrTXT_CLAVE_DINAMICA,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONFIRMAR)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonConfirmarAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					TipoLog="1";objPagoRecibosBE.verificarResultadoFinal();
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CANCELAR_OPERACION)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonCancelarOperacionAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrRESULTADO_ESPERADO)){		
				LStr_HoraInicio = System.currentTimeMillis();
				objPagoRecibosBE.verificarResultadoFinalAutorizar();
				if (objPagoRecibosBE.compararResultadoEsperadoAutorizar(GstrRESULTADO_ESPERADO)){	
					objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado", "Resultado Obtenido" ,"");
					TipoLog="1";
					Thread.sleep(700);
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado", "Resultado Obtenido" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
    		}
			
			if(bandera){
//-------------07/10/2016
				
//				if (objFuncionesGenerales.verificarIgnore("CLICK")){
//					LStr_HoraInicio = System.currentTimeMillis();	
//					
//					strTexto = objPagoRecibosBE.BuscarCadenaTabla(strCadena,"MontoSolesAutorizarResultadoEsperado");
//					if(!strTexto.equals(""))
//					{	
//						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto Pagado de la grilla Detalle Autorizar: "+strTexto, "" ,"");
//						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, toString().valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto Total de la grilla Envío", strCadena, strTexto);
//					}else{
//						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto a Pagar de la grilla Envío: ", "" ,"");
//					}
//					
//					LStr_HoraFin = System.currentTimeMillis();	  
//	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkEnviarEmailAutorizarResultadoEsperado()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 	
					if (objPagoRecibosBE.ingresarCorreoAutorizar( GstrTXT_CORREO_AUTORIZAR_RESULTADO_ESPERADO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_AUTORIZAR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 	
					if (objPagoRecibosBE.ingresarMensajeCorreoAutorizar( GstrTXT_MENSAJE_CORREO_AUTORIZAR_RESULTADO_ESPERADO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_AUTORIZAR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoBotonEnviarAutorizar()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_AUTORIZAR ))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					objPagoRecibosBE.verificarMensajeCorreoAutorizar();
					if (objPagoRecibosBE.ingresoBotonAceptarCorreoAutorizar()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkExportarExcelAutorizarResultadoEsperado()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkExportarPDFAutorizarResultadoEsperado()){	
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
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_AUTORIZAR_RESULTADO_ESPERADO))
				{	
					LStr_HoraInicio = System.currentTimeMillis(); 
					if (objPagoRecibosBE.ingresoLinkImprimirAutorizarResultadoEsperado()){	
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
				//------------------------
				
				if (bandera&&consultar==true){
					bandera=objConsultaHistoricaBL.consultaHistorico("Pago de Recibos",GstrCMB_EMPRESA,PagosRecibosBE.GstrCMB_CUENTA_CARGO,1,PagosRecibosBE.GstrESTADO,PagosRecibosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS,PagosRecibosBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)&&consultar!=true)
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
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
	