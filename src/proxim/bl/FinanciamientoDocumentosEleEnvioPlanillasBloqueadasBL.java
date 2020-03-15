package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleEnvioPlanillasBloqueadasBL extends FinanciamientoDocumentosEleEnvioPlanillasBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDocumentosEleEnvioPlanillasMapeo objFinanciamientoDocumentosEleEnvioPlanillasBE = new FinanciamientoDocumentosEleEnvioPlanillasMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	String strTextoImagen="1. Imagenes";
	String strFechaHora="dd/MM/yyyy HH:mm:ss";
	int intNewRegistro=0;
	public boolean financiamientoDocumentosEleEnvioPlanillasBloqueadas(int valor) throws SQLException, IOException{
		boolean blnResultadoEsperado = true;
		String strHoraFin;
		long lngTiempoEjeCaso;
		String strHoraInicio;
		String strTipoLog = null;
		String strTXT_SUBMENU1="Planillas Bloqueadas";
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		try {
			
			//---------------------------------------MENU---------------------------------------
			if(valor==2){
				objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			}
			
			if (objFuncionesGenerales.verificarIgnore( strTXT_SUBMENU1)){	
				objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarEnvioCamposObligatorios();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarSubMenu1( strTXT_SUBMENU1))
				{	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la pestaña "+strTXT_SUBMENU1);
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la pestaña "+strTXT_SUBMENU1);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//------------------------------------------------------------------------------

			objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarCamposObligatoriosBloqueados();
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarEmpresaBloqueados( GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_PRODUCTO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarProductoBloqueados( GstrCMB_PRODUCTO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( fechaBusqueda)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresarFechaOperacionDesdeBloqueados( fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DESDE "+fechaBusqueda , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "La FECHA DESDE "+fechaBusqueda , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore( fechaBusqueda)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresarFechaOperacionHastaBloqueados( fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA HASTA "+fechaBusqueda , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "La FECHA HASTA "+fechaBusqueda , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){
				Thread.sleep(5000);	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
							
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonBuscarBloqueados()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					strTipoLog="1";
					objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarTablaBloqueados();	
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
    			objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarTablaBloqueados();	
    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoLinkEnviarEmailFinalBloqueadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresarCorreoFinalBloqueadas( GstrTXT_CORREO_BLOQUEADOS))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_BLOQUEADOS , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_BLOQUEADOS , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresarMensajeCorreoFinalBloqueadas( GstrTXT_MENSAJE_CORREO_BLOQUEADOS))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_BLOQUEADOS , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_BLOQUEADOS , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonEnviarFinalBloqueadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoLinkExportarExcelFinalBloqueadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoLinkExportarPDFFinalBloqueadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_BLOQUEADOS))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoLinkImprimirFinalBloqueadas()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( "CLICK")){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				CapturarPantalla.scrollCapturaPantalla();
				intNewRegistro=objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarSolicitudBloqueadas();
				if (intNewRegistro!=0){	
					objFuncionesGenerales.callPasosAcierto(1, "La operación realizada", "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "La operación realizada", "" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
						
			if (intNewRegistro!=0){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.verSolicitudBloqueadas(intNewRegistro)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Solicitud Bloqueada");
					strTipoLog="1";
					objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarDetalleBloqueados();
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la Solicitud Bloqueada");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.scrollCapturaPantalla();
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		} catch (Exception e) {
			blnResultadoEsperado=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado;
	}
}