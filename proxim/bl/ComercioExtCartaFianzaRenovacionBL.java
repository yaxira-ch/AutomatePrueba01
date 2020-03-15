package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ComercioExtCartaFianzaGeneralBE;
import proxim.be.ComercioExtCartaFianzaRenovacionBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaRenovacionBL extends ComercioExtCartaFianzaRenovacionBE{
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	ComercioExtCartaFianzaRenovacionProcesadasMapeo objComExtCartaFianzaSolRenovMapeo=new ComercioExtCartaFianzaRenovacionProcesadasMapeo();
	ComercioExtCartaFianzaGeneralBE objComerExtCartaFianzaSolicitudBL= new ComercioExtCartaFianzaGeneralBE();
	private static String TipoLog = null;
	
	public boolean realizarEnvio() throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;
		
		try{
			
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal( "<IGNORE>","Comercio Exterior", "Solicitud de Renovación");
			
			//------------------------------------------------------------------------------			
					
			
			//---------------------------------------------------------PANTALLA DE REGISTRO-------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objComExtCartaFianzaSolRenovMapeo.seleccionarEmpresa( GstrCMB_EMPRESA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA: "+ GstrCMB_EMPRESA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA: "+ GstrCMB_EMPRESA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_CARTA_FIANZA))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objComExtCartaFianzaSolRenovMapeo.ingresarNumeroCartaFianza( GstrTXT_NUMERO_CARTA_FIANZA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"NUMERO DE CARTA FIANZA: ", GstrTXT_NUMERO_CARTA_FIANZA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE CARTA FIANZA: ", GstrTXT_NUMERO_CARTA_FIANZA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objComExtCartaFianzaSolRenovMapeo.ingresarFechaDesde( GstrTXT_FECHA_DESDE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA DESDE: ", GstrTXT_FECHA_DESDE ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA DESDE: ", GstrTXT_FECHA_DESDE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objComExtCartaFianzaSolRenovMapeo.ingresarFechaHasta( GstrTXT_FECHA_HASTA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA HASTA: ", GstrTXT_FECHA_HASTA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA HASTA: ", GstrTXT_FECHA_HASTA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_ESTADO_OPERACION))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objComExtCartaFianzaSolRenovMapeo.seleccionarEstadoOperacion( GstrCMB_ESTADO_OPERACION))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "ESTADO OPERACION: "+ GstrCMB_ESTADO_OPERACION, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "ESTADO OPERACION: "+ GstrCMB_ESTADO_OPERACION, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objComExtCartaFianzaSolRenovMapeo.buscarCartaFianza())
				{ 
					objFuncionesGenerales.callPasosAcierto(1, ""+ "", "" ,"	Buscar");
					TipoLog="1";
					Thread.sleep(1000);
					objComExtCartaFianzaSolRenovMapeo.verificarTablaCartaFianza();
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, " "+ "", "" ,"Buscar");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
						
			objSQL.listaTablaIdCaso("APP_COMERCIO_EXT_CARTA_FIANZA_D WHERE ID_CASO="+GstrID_CASO_LOTE,"",3);
			while (Mdl_Variables.Grst_NuevaTabla.next()==true){ 
				objComerExtCartaFianzaSolicitudBL.obtenerCamposBD(Mdl_Variables.Grst_NuevaTabla);
			}				
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objComExtCartaFianzaSolRenovMapeo.verDetalleLoteEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el link para VER el detalle del LOTE a Enviar");						
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el link para VER el detalle del LOTE a Enviar");
				}				
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_DETALLE)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkEnviarEmailDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar por e-mail");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar por e-mail");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objComExtCartaFianzaSolRenovMapeo.ingresarCorreo( GstrTXT_CORREO_DETALLE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objComExtCartaFianzaSolRenovMapeo.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO_DETALLE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_DETALLE))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
					Thread.sleep(1000);
					objComExtCartaFianzaSolRenovMapeo.ingresoBotonAceptarEnviar();
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_DETALLE)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkExportarExcelDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			CapturarPantalla.pageDown("500");
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_DETALLE)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkExportarPDFDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_DETALLE)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkImprimirDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK  Imprimir");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK  Imprimir");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_A_TABLA))
			{	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objComExtCartaFianzaSolRenovMapeo.regresarTablaCartaFianza()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el link para REGRESAR a la tabla de Cartas Fianzas");						
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el link para REGRESAR a la tabla de Cartas Fianzas");
				}				
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		
			LStr_HoraInicio = System.currentTimeMillis(); 			
			if (objComExtCartaFianzaSolRenovMapeo.seleccionarCartaFianza()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la Carta Fianza");
				TipoLog="1";				
			}else{
				TipoLog="0";									
				bandera = false;
				objFuncionesGenerales.callPasosErrado(6, "Caso Lote", "" ,"");
			}
			LStr_HoraFin = System.currentTimeMillis(); 
			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR1))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objComExtCartaFianzaSolRenovMapeo.continuarEnvio())
				{ 
					objFuncionesGenerales.callPasosAcierto(1, ""+ "", "" ,"	Continuar");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, " "+ "", "" ,"Continuar");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			//---------------------------------------------------------PANTALLA DE ENVIO PREVIO-------------------

			LStr_HoraInicio = System.currentTimeMillis(); 
			String CamposDiferentes=objComExtCartaFianzaSolRenovMapeo.verificarDatosEnvio();
			if (!CamposDiferentes.equals("")){ 
				objFuncionesGenerales.callPasosAcierto(5, ""+ "Datos iguales", "Todos" ,"	");
				TipoLog="1";
			}else{
				TipoLog="0";
				bandera = false;
				objFuncionesGenerales.callPasosErrado(5, " "+ "Datos diferentes", CamposDiferentes ,"");
			}
			LStr_HoraFin = System.currentTimeMillis(); 
			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DIAS_NUEVO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objComExtCartaFianzaSolRenovMapeo.ingresarNumeroDiasNuevo( GstrTXT_NUMERO_DIAS_NUEVO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"NUMERO DE DIAS: ", GstrTXT_NUMERO_DIAS_NUEVO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE DIAS: ", GstrTXT_NUMERO_DIAS_NUEVO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA_NUEVO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objComExtCartaFianzaSolRenovMapeo.ingresarFechaHastaNuevo( GstrTXT_FECHA_HASTA_NUEVO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"NUMERO DE DIAS: ", GstrTXT_FECHA_HASTA_NUEVO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE DIAS: ", GstrTXT_FECHA_HASTA_NUEVO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			objComExtCartaFianzaSolRenovMapeo.capturarDatos();
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUEVO_MONTO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();   
				Thread.sleep(700);
				if (objComExtCartaFianzaSolRenovMapeo.ingresarNuevoMonto( GstrTXT_NUEVO_MONTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"INFORMACION DE CONTACTO: ", GstrTXT_NUEVO_MONTO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "INFORMACION DE CONTACTO: ", GstrTXT_NUEVO_MONTO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();   
				Thread.sleep(700);
				if (objComExtCartaFianzaSolRenovMapeo.ingresarNombreResponsable( GstrTXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"INFORMACION DE CONTACTO: ", GstrTXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "INFORMACION DE CONTACTO: ", GstrTXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DOCUMENTO_NUEVO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objComExtCartaFianzaSolRenovMapeo.seleccionarTipoDocumento( GstrCMB_TIPO_DOCUMENTO_NUEVO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA: "+ GstrCMB_TIPO_DOCUMENTO_NUEVO, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA: "+ GstrCMB_TIPO_DOCUMENTO_NUEVO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DOCUMENTO_NUEVO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();   
				Thread.sleep(700);
				if (objComExtCartaFianzaSolRenovMapeo.ingresarNumeroDocumento( GstrTXT_NUMERO_DOCUMENTO_NUEVO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"INFORMACION DE CONTACTO: ", GstrTXT_NUMERO_DOCUMENTO_NUEVO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "INFORMACION DE CONTACTO: ", GstrTXT_NUMERO_DOCUMENTO_NUEVO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_CONTACTO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();   
				Thread.sleep(700);
				if (objComExtCartaFianzaSolRenovMapeo.ingresarInformacionContacto( GstrTXT_CORREO_CONTACTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"INFORMACION DE CONTACTO: ", GstrTXT_CORREO_CONTACTO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "INFORMACION DE CONTACTO: ", GstrTXT_CORREO_CONTACTO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR2))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objComExtCartaFianzaSolRenovMapeo.continuarEnvio2())
				{ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"CONTINUAR");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"CONTINUAR");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			//---------------------------------------------------------PANTALLA DE ENVIO-------------------

			LStr_HoraInicio = System.currentTimeMillis(); 
			String CamposDiferentes2=objComExtCartaFianzaSolRenovMapeo.verificarDatosEnvio2();
			if (CamposDiferentes2.equals("")){ 
				objFuncionesGenerales.callPasosAcierto(5, ""+ "Datos iguales", "Todos" ,"	");
				TipoLog="1";
			}else{
				TipoLog="0";
				bandera = false;
				objFuncionesGenerales.callPasosErrado(5, " "+ "Datos diferentes", CamposDiferentes2 ,"");
			}
			LStr_HoraFin = System.currentTimeMillis(); 
			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		

			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
				LStr_HoraInicio = System.currentTimeMillis(); 	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoClave(Mdl_Variables.Gstr_Clave)){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CLAVE_DINAMICA)){	
				LStr_HoraInicio = System.currentTimeMillis(); 	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_QUIERES_SABER_COMO)){	
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkQuieresSaberComo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Quieres Saber Como");
					TipoLog="1";					
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Quieres Saber Como");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				objComExtCartaFianzaSolRenovMapeo.cerrarLinkQuieresSaberComo();
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONFIRMAR)){	
				LStr_HoraInicio = System.currentTimeMillis(); 	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoBotonConfirmar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					TipoLog="1";
					Thread.sleep(1000);
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
				if (objComExtCartaFianzaSolRenovMapeo.ingresoBotonCancelarOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					TipoLog="1";
					Thread.sleep(1000);
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
			
			//---------------------------------------------------------PANTALLA DE CONFIRMACION-------------------
			
			LStr_HoraInicio = System.currentTimeMillis(); 
			String CamposDiferentesConfirmacion=objComExtCartaFianzaSolRenovMapeo.verificarDatosConfirmacion();
			if (CamposDiferentesConfirmacion.equals("")){ 
				objFuncionesGenerales.callPasosAcierto(5, ""+ "Datos iguales", "Todos" ,"	");
				TipoLog="1";
				objComExtCartaFianzaSolRenovMapeo.GuardarDatosOperacionAutorizar();
			}else{
				TipoLog="0";
				bandera = false;
				objFuncionesGenerales.callPasosErrado(5, " "+ "Datos diferentes", CamposDiferentesConfirmacion ,"");
			}
			LStr_HoraFin = System.currentTimeMillis(); 
			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
									
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar por e-mail");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar por e-mail");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objComExtCartaFianzaSolRenovMapeo.ingresarCorreo( GstrTXT_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objComExtCartaFianzaSolRenovMapeo.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
					Thread.sleep(1000);
					objComExtCartaFianzaSolRenovMapeo.ingresoBotonAceptarEnviar();
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkExportarExcel()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkExportarPDF()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkImprimir()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK  Imprimir");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK  Imprimir");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_REGRESAR)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objComExtCartaFianzaSolRenovMapeo.ingresoLinkRegresar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Regresar");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Regresar");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			//---------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
			
			//---------------------------------------FLUJO DE FIRMAS---------------------------------------
			
			boolean consultar1=false;
			boolean consultar2=false;
			boolean consultar3=false;
			
			if (bandera){
				if(GstrFIRMAR.equals("SI")){

					if (!GstrFIRMANTE3.equals("<IGNORE>")){
						consultar3=true;
					}else{
						if (!GstrFIRMANTE2.equals("<IGNORE>")){
							consultar2=true;
						}else{
							if (!GstrFIRMANTE1.equals("<IGNORE>")){
								consultar1=true;
							}
						}
					}					

					String tabla_Autorizar_Plantilla="APP_COMERCIO_EXT_CARTA_FIANZA_AUTORIZAR_D";
					String tabla_Autorizar_Portabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
					String tabla_Autorizar_autorizacion="APP_AND_AUTORIZACIONES_PENDIENTES_D";

					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))	{
						if (GstrFIRMANTE1.equals("PA") || GstrFIRMANTE1.equals("PA-B") ){
							bandera=objFirmarBL.cartaFianzaRenovacion(tabla_Autorizar_Plantilla,GstrID_CASO,"F1",consultar1);
						}else{
							if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
								bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,GstrID_CASO,"F1' AND TIPO_CARTA_FIANZA='Renovacion Carta Fianza",consultar1,null,null,null);
							}else{
								bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,GstrID_CASO,"F1","Renovacion Carta Fianza",consultar1);
							}
						}
					}

					if(bandera){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2))
						{
							if (GstrFIRMANTE2.equals("PA") || GstrFIRMANTE2.equals("PA-B")){
								bandera=objFirmarBL.cartaFianzaRenovacion(tabla_Autorizar_Plantilla,GstrID_CASO,"F2",consultar2);
							}else{
								if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
									bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,GstrID_CASO,"F2' AND TIPO_CARTA_FIANZA='Renovación Carta Fianza",consultar2,null,null,null);
								}else{
									bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,GstrID_CASO,"F2","Renovacion Carta Fianza",consultar2);
								}
							}
						}

						if(bandera){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3))
							{
								if (GstrFIRMANTE3.equals("PA") || GstrFIRMANTE3.equals("PA-B")){
									bandera=objFirmarBL.cartaFianzaRenovacion(tabla_Autorizar_Plantilla,GstrID_CASO,"F3",consultar3);
								}else{
									if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
										bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,GstrID_CASO,"F3' AND TIPO_CARTA_FIANZA='Renovacion Carta Fianza",consultar3,null,null,null);
									}else{
										bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,GstrID_CASO,"F3","Renovacion Carta Fianza",consultar3);
									}
								}
							}

						}
					}

				}
			}
			
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}

}