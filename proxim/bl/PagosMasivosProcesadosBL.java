
package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.EnvioPagosMasivosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosMasivosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosMasivosProcesadosBL extends PagosMasivosBE{
	
	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	EnvioPagosMasivosBE objEnvioPagosMasivosBE = new EnvioPagosMasivosBE();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	pagosMasivosAdministracionTest objPagoMasivoAdministracionPagoBE = new pagosMasivosAdministracionTest();//88
	HeaderBL objHeader = new HeaderBL();
	
	public boolean administracionPagosProcesados(int valor1) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio ;	
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		//String fechaBusqueda = "01/03/2018";
		String TXT_SUBMENU1="Pagos Procesados";
		
		try {
			
			//---------------------------------------------MENU------------------------------------------------------------
			if(valor1==2){
				objHeader.menuPrincipal("<IGNORE>", PagosMasivosAdministracionAfiliadosBE.strTxtMenu, PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu);
				
				objEnvioPagosMasivosBE.verificarEnvioPagos();
			}
			
			if (objFuncionesGenerales.verificarIgnore(TXT_SUBMENU1)){	
				
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objPagoMasivoAdministracionPagoBE.seleccionarSubMenuPestana(TXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+TXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+TXT_SUBMENU1);
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			//------------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){	
				objEnvioPagosMasivosBE.verificarPagosProcesos();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.seleccionarEmpresaPagosProcesados(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){		
				objEnvioPagosMasivosBE.verificarPagosProcesos();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.seleccionarProducto(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO"+PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){		
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.seleccionarServicio(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){	
					objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO"+PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del SERVICIO"+PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda)){	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objEnvioPagosMasivosBE.ingresarFechaInicio(fechaBusqueda)){	
					objFuncionesGenerales.callPasosAcierto(3, "La Fecha de Inicio "+fechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La Fecha de Inicio "+fechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if(!PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO.equals("<IGNORE>")){
				fechaBusqueda=PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO;
			}
						
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda)){	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objEnvioPagosMasivosBE.ingresarFechaFin(fechaBusqueda)){	
					objFuncionesGenerales.callPasosAcierto(3, "La Fecha Fin "+fechaBusqueda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La Fecha Fin "+fechaBusqueda , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			//Busca combo Canal 
			if (objFuncionesGenerales.verificarIgnore("CLICK")){		
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.comboVerificar()){ 
					objFuncionesGenerales.callPasosAcierto(8, "Se muestra el Combo", "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(8, "No se muestra el Combo", "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO)){		
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.seleccionarCanalEnvio(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO)){	
					objFuncionesGenerales.callPasosAcierto(2, "del CANAL DE ENVIO "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del CANAL DE ENVIO "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			boolean bBuscarProcesados = false;
			if (objFuncionesGenerales.verificarIgnore("CLICK")){	
				Thread.sleep(20000);
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.ingresoBotonBuscar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
					bBuscarProcesados = true;
					objEnvioPagosMasivosBE.verificarResultadoTablaBloqueo();
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
    			CapturarPantalla.scrollCapturaPantallaHorizontal("/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]");
    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		
			
			//-------PIE DE PAGINA DE LA LISTA (CABECERA)
			if(bBuscarProcesados){
				
				if (objEnvioPagosMasivosBE.verificarResultadoTablaBloqueo()){
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objEnvioPagosMasivosBE.buscarNumeroInterno())		          { 
						objFuncionesGenerales.callPasosAcierto(6, "la Columna: Canal", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(6, "la Columna: Canal", "" ,"");
					}          
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			       objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_ENVIAR_CORREO)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoEnviarCorreoCab("SeccionPagosProcesados")){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresarTituloCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresarMensajeCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Pagos Procesados")){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Pagos Procesados", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Pagos Procesados", "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR_CORREO)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoBotonEnviarCorreo()){
						Thread.sleep(3000);
						objEnvioPagosMasivosBE.ingresoBotonEnviarCorreo2();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_EXCEL)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoExportarExcelCab("SeccionPagosProcesados")){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_PDF)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoExportarPdfCab("SeccionPagosProcesados")){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_IMPRIMIR)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoImprimirCab("SeccionPagosProcesados")){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}

			//---------------------------------
			
			boolean bVerDetalle = false;
			if (objFuncionesGenerales.verificarIgnore("CLICK")){	
				objEnvioPagosMasivosBE.verificarResultadoTablaBloqueo();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objEnvioPagosMasivosBE.seleccionarLoteVerDetalle(fechaBusqueda)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link del Lote para VER DETALLE");
					TipoLog="1";
					bVerDetalle = true;
					objEnvioPagosMasivosBE.verificarResultadoTablaProcesadoDetalle();
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link del Lote para VER DETALLE");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
    			CapturarPantalla.scrollCapturaPantallaHorizontal("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[5]/div/div[5]");
			   	objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			//------PIE DE PAGINA (DETALLE) -----------
			
			if(bVerDetalle){
				//Comparar campos
				if (objFuncionesGenerales.verificarIgnore("CLICK")){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.comparaCampos()){
						objFuncionesGenerales.callPasosAcierto(5, " Canal", "Valor del Canal" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, " Canal", "Valor del Canal" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_ENVIAR_CORREO)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoEnviarCorreo()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresarTituloCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresarMensajeCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Pagos Procesados Detalle")){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Pagos Procesados Detalle", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Pagos Procesados Detalle", "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR_CORREO)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoBotonEnviarCorreo()){
						Thread.sleep(3000);
						objEnvioPagosMasivosBE.ingresoBotonEnviarCorreo2();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_EXCEL)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoExportarExcel()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_PDF)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoExportarPdf()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_IMPRIMIR)){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objEnvioPagosMasivosBE.ingresoImprimir()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				
				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA EN GRILLAS -----
				String strCadena = "Nuevos";
				String strTexto = objPagoMasivoAdministracionPagoBE.BuscarCadenaTabla(strCadena,"DetallePagoProcesadosMonedaOperacion");
				if(!strTexto.equals(""))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Pagos Procesados, columna Moneda de la Operación", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: En la columna Moneda de la Operacion de la Tabla", "" ,"");
				}
				
				strCadena = "S/.";
				strTexto = "";
				strTexto = objPagoMasivoAdministracionPagoBE.ObtenerTextoMontoDetalleProcesados();
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Pagos Procesados, valor Monto Total Soles", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto, "" ,"");
				}
				//---------------------------------------------------------
				
			}
			//-------------------------------

		}
		catch (Exception e) {
			bandera = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso)); 
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
}