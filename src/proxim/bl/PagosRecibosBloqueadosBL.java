package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.PagosRecibosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosRecibosBloqueadosBL extends PagosRecibosBE{

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosRecibosMapeo objPagoRecibosBE = new PagosRecibosMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean PagosRecibosBloqueados(int valor) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;	
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		try {
			//-------------------------------------------------------MENU----------------------------------------------------------------
			if(valor==2){
				objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			}
			
			String subMenu="Pagos Bloqueados";
			
			if (objFuncionesGenerales.verificarIgnore(subMenu)){	
				objPagoRecibosBE.verificarPestania();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarSubMenu1(subMenu)){	
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
				objPagoRecibosBE.verificarPagoResivos();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarEmpresaBloqueado(GstrCMB_EMPRESA))
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
				objPagoRecibosBE.verificarPagoResivos();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarCuentaCargoBloqueado(GstrCMB_CUENTA_CARGO))
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
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarFechaSolicitudDesdeBloqueado(fechaBusqueda))
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
				if (objPagoRecibosBE.ingresarFechaSolicitudHastaBloqueado(fechaBusqueda))
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
				if (objPagoRecibosBE.ingresoBotonBuscarBloqueado()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					objPagoRecibosBE.verificarTablasBloqueados();
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_BLOQUEADOS))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkEnviarEmailBloqueados()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_BLOQUEADOS))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    	
				if (objPagoRecibosBE.ingresarCorreoAutorizar( GstrTXT_CORREO_BLOQUEADOS))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_BLOQUEADOS , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_BLOQUEADOS , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();		  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_BLOQUEADOS))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    	
				if (objPagoRecibosBE.ingresarMensajeCorreoAutorizar( GstrTXT_MENSAJE_CORREO_BLOQUEADOS))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_BLOQUEADOS , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_BLOQUEADOS , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();		  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_BLOQUEADOS))
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_BLOQUEADOS))
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkExportarExcelBloqueados()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_BLOQUEADOS))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkExportarPDFBloqueados()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_BLOQUEADOS))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkImprimirBloqueados()){	
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
			int intResultadoEsperado=0;
			if (objFuncionesGenerales.verificarIgnore("CLICK")){	
				LStr_HoraInicio = System.currentTimeMillis();
				intResultadoEsperado=objPagoRecibosBE.verificarExistePago();
				if (intResultadoEsperado!=0){	//falta corregir la fechaaa de hoyyy  CORREGODP
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Pago para Ver el Detalle");
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Pago para Ver el Detalle");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (intResultadoEsperado!=0){
				if (objFuncionesGenerales.verificarIgnore("CLICK")){	
					LStr_HoraInicio = System.currentTimeMillis();
					if (objPagoRecibosBE.seleccionarVerDetalleBloqueado(intResultadoEsperado)){	//falta corregir la fechaaa de hoyyy CORREGIDO
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Pago para Ver el Detalle");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Pago para Ver el Detalle");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    			CapturarPantalla.scrollCapturaPantalla();
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_BLOQUEADOS_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkEnviarEmailBloqueadosDetalle()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_BLOQUEADOS_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    	
				if (objPagoRecibosBE.ingresarCorreoAutorizar( GstrTXT_CORREO_BLOQUEADOS_DETALLE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_BLOQUEADOS_DETALLE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_BLOQUEADOS_DETALLE , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();		  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_BLOQUEADOS_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    	
				if (objPagoRecibosBE.ingresarMensajeCorreoAutorizar( GstrTXT_MENSAJE_CORREO_BLOQUEADOS_DETALLE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_BLOQUEADOS_DETALLE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_BLOQUEADOS_DETALLE , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();		  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_BLOQUEADOS_DETALLE))
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_BLOQUEADOS_DETALLE))
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkExportarExcelBloqueadosDetalle()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_BLOQUEADOS_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkExportarPDFBloqueadosDetalle()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_BLOQUEADOS_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	    
				if (objPagoRecibosBE.ingresoLinkImprimirBloqueadosDetalle()){	
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
	