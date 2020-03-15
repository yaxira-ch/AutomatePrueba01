package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobCarteraDocumentosBL extends FinanciamientoDescuentosCobCarteraDocumentosBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDescuentosCobCarteraDocumentosMapeo objFinanciamientoDescuentosCobCarteraDocumentosBE = new FinanciamientoDescuentosCobCarteraDocumentosMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();

	public boolean financiamientoDescuentosCobCarteraDocumentos() throws SQLException, IOException{
		boolean blnResultadoOperacion = true;
		long lngHoraFinEjecucion;
		long lngTiempoEjecucion;
		long lngHoraInicioEjecucion;
		String strTipoLog = null;
		try {
			
			objHeader.menuPrincipal( "<IGNORE>",GstrTXT_MENU, GstrTXT_SUBMENU);
			objFinanciamientoDescuentosCobCarteraDocumentosBE.verificarEnvioCamposObligatorios();

									
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.seleccionarEmpresa(GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoOperacion = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PARTICIPE_COMO)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.seleccionarParticipeComo(GstrCMB_PARTICIPE_COMO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "PARTICIPE COMO "+GstrCMB_PARTICIPE_COMO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoOperacion = false;
				objFuncionesGenerales.callPasosErrado(2, "PARTICIPE COMO "+GstrCMB_PARTICIPE_COMO , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_PRODUCTO)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.seleccionarProducto( GstrCMB_PRODUCTO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoOperacion = false;
				objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_SITUACION)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.seleccionarSituacion( GstrCMB_SITUACION))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la SITUACION "+GstrCMB_SITUACION , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoOperacion = false;
				objFuncionesGenerales.callPasosErrado(2, "de la SITUACION "+GstrCMB_SITUACION , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NUMERO_DOCUMENTO)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresarNumeroDocumento( GstrTXT_NUMERO_DOCUMENTO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NÚMERO DE DOCUMENTO "+GstrTXT_NUMERO_DOCUMENTO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
				blnResultadoOperacion = false;
				objFuncionesGenerales.callPasosErrado(3, "El NÚMERO DE DOCUMENTO "+GstrTXT_NUMERO_DOCUMENTO , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}

			
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
							
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoBotonBuscar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					strTipoLog="1";
					objFinanciamientoDescuentosCobCarteraDocumentosBE.verificarTablaResultado();	
				}else{
					strTipoLog="0";									
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoLinkEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  	
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresarCorreo( GstrTXT_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  	
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_CORREO))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	
				objFinanciamientoDescuentosCobCarteraDocumentosBE.verificarMensajeCorreo();
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoBotonAceptarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoLinkExportarExcel()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoLinkExportarPDF()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR))
			{	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objFinanciamientoDescuentosCobCarteraDocumentosBE.ingresoLinkImprimir()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			
			
		} catch (Exception e) {
			blnResultadoOperacion=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	
		}
		return blnResultadoOperacion;
	}
}