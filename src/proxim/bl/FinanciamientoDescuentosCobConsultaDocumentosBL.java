package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.FinanciamientoDescuentosCobConsultaDocumentosBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobConsultaDocumentosBL extends FinanciamientoDescuentosCobConsultaDocumentosBE{
	long LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	long LStr_HoraInicio;
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	private static String TipoLog = null;
	
	FinanciamientoDescuentosCobConsultaDocumentosMapeo objFinanciamientoDescuentosCobConsultaDocumentosMapeo=new FinanciamientoDescuentosCobConsultaDocumentosMapeo();
	
	public boolean realizarConsulta() throws SQLException, IOException{
		
		boolean blnResultadoEsperado = true;
		
		try{
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal("<IGNORE>", "Financiamiento", "Consulta de Documentos");
			//----------------------------------------------------------------------------------
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.seleccionarEmpresa( GstrCMB_EMPRESA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PRODUCTO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.seleccionarProducto( GstrCMB_PRODUCTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_PRODUCTO "+ GstrCMB_PRODUCTO, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_PRODUCTO "+ GstrCMB_PRODUCTO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_SITUACION))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.seleccionarSituacion( GstrCMB_SITUACION))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_SITUACION "+ GstrCMB_SITUACION, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_SITUACION "+ GstrCMB_SITUACION, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_POR_DOCUMENTO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.seleccionarDocumento( GstrCMB_POR_DOCUMENTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_POR_DOCUMENTO "+ GstrCMB_POR_DOCUMENTO, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_POR_DOCUMENTO "+ GstrCMB_POR_DOCUMENTO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DOCUMENTO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.ingresarNumeroDocumento( GstrTXT_NUMERO_DOCUMENTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TXT_NUMERO_DOCUMENTO", GstrTXT_NUMERO_DOCUMENTO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "TXT_NUMERO_DOCUMENTO", GstrTXT_NUMERO_DOCUMENTO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DE_BUSQUEDA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.seleccionarTipoBusqueda( GstrCMB_TIPO_DE_BUSQUEDA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_TIPO_DE_BUSQUEDA "+ GstrCMB_TIPO_DE_BUSQUEDA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_TIPO_DE_BUSQUEDA "+ GstrCMB_TIPO_DE_BUSQUEDA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.ingresarFechaDesde( GstrTXT_FECHA_DESDE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TXT_FECHA_DESDE", GstrTXT_FECHA_DESDE ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "TXT_FECHA_DESDE", GstrTXT_FECHA_DESDE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.ingresarFechaHasta( GstrTXT_FECHA_HASTA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TXT_FECHA_HASTA", GstrTXT_FECHA_HASTA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "TXT_FECHA_HASTA", GstrTXT_FECHA_HASTA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR))
			{       

				if(objFinanciamientoDescuentosCobConsultaDocumentosMapeo.buscar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "","Buscar");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "","Buscar");
				}

				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL)){	
				LStr_HoraInicio = System.currentTimeMillis();  
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.ingresarEnvioCorreo()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP)){
					objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP)){
					objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.enviarCorreo()){
					Thread.sleep(3000);
					objFinanciamientoDescuentosCobConsultaDocumentosMapeo.aceptarEnvio();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			CapturarPantalla.pageDown("1200");

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = System.currentTimeMillis();   
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.exportarExcel()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
				LStr_HoraInicio = System.currentTimeMillis();  
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.exportarPdf()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobConsultaDocumentosMapeo.imprimir()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
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
