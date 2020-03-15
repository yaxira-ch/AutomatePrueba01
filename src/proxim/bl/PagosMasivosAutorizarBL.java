package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.EnvioPagosMasivosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosMasivosBE;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosMasivosAutorizarBL extends PagosMasivosBE{
	
	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	EnvioPagosMasivosBE objEnvioPagosMasivosBE = new EnvioPagosMasivosBE();
	PagosMasivosAdministracionAfiliadosBE objPagosMasivosBL=new PagosMasivosAdministracionAfiliadosBE();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	pagosMasivosAdministracionTest objPagoMasivoAdministracionPagoBE = new pagosMasivosAdministracionTest();

	public boolean administracionPagosPorAutorizar(int valor,boolean consulta) throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		String strFechaBusquedaInicio = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());	
		//String strFechaBusquedaInicio = "01/03/2018";	
		boolean Lbln_Bandera=false;
		String strFechaBusquedaFin ;
	
		try {
/*//			org.openqa.selenium.Point coordinates1=Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[2]/table[5]/tbody/tr/td[1]/div/span[3]")).getLocation();
//			Robot robot1=new Robot();
//			robot1.mouseMove(coordinates1.getX(), coordinates1.getY());
			objFuncionesGenerales.clicMenu();*/
			
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrTXT_SUBMENU1)){
				objEnvioPagosMasivosBE.verificarEnvioPagos();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoMasivoAdministracionPagoBE.seleccionarSubMenuPestana(PagosMasivosBE.GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+PagosMasivosBE.GstrTXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+PagosMasivosBE.GstrTXT_SUBMENU1);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			//-------------------------------------------------------------------------------------------------------------------			
			
			boolean bEntrarPasos = true;
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_VER_EXPIRADOS))
			{
				if (PagosMasivosAdministracionAfiliadosBE.GstrLNK_VER_EXPIRADOS.toUpperCase().equals("SI"))
				{
					bEntrarPasos = false;
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoVerPagosExpirados())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "VER PAGOS EXPIRADOS" , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "VER PAGOS EXPIRADOS", "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					
				}else{
					bEntrarPasos = true;
				}
			}
			if (bEntrarPasos){
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrCMB_EMPRESA)){		
					objEnvioPagosMasivosBE.verificarPagosAutorizar();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.seleccionarEmpresa(PagosMasivosBE.GstrCMB_EMPRESA)){	
						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+PagosMasivosBE.GstrCMB_EMPRESA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA"+PagosMasivosBE.GstrCMB_EMPRESA , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrCMD_PRODUCTO)){		
					objEnvioPagosMasivosBE.verificarPagosAutorizar();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.seleccionarProducto(PagosMasivosBE.GstrCMD_PRODUCTO)){	
						objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+PagosMasivosBE.GstrCMD_PRODUCTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO"+PagosMasivosBE.GstrCMD_PRODUCTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrCMD_SERVICIO)){		
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.seleccionarServicio(PagosMasivosBE.GstrCMD_SERVICIO)){	
						objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO"+PagosMasivosBE.GstrCMD_SERVICIO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del SERVICIO"+PagosMasivosBE.GstrCMD_SERVICIO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(strFechaBusquedaInicio)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
					if (objEnvioPagosMasivosBE.ingresarFechaInicio(strFechaBusquedaInicio)){	
						objFuncionesGenerales.callPasosAcierto(3, "La Fecha de Inicio "+strFechaBusquedaInicio , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La Fecha de Inicio "+strFechaBusquedaInicio , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(!PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO.equals("<IGNORE>")){
					strFechaBusquedaFin=PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO;
				}else{
					strFechaBusquedaFin=strFechaBusquedaInicio;
				}
				
				if (objFuncionesGenerales.verificarIgnore(strFechaBusquedaFin)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
					if (objEnvioPagosMasivosBE.ingresarFechaFin(strFechaBusquedaFin)){	
						objFuncionesGenerales.callPasosAcierto(3, "La Fecha Fin"+strFechaBusquedaFin , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La Fecha Fin"+strFechaBusquedaFin , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrBTN_BUSCAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoBotonBuscar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_ENVIAR_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoEnviarCorreoCab("SeccionPagosAutorizar")){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresarTituloCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresarMensajeCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE, "" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR_CORREO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
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
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_EXCEL)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoExportarExcelCab("SeccionPagosAutorizar")){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_PDF)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoExportarPdfCab("SeccionPagosAutorizar")){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_IMPRIMIR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoImprimirCab("SeccionPagosAutorizar")){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				//---------------------------------------------------------
				
			
				boolean bVerDetalle = false;
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS)){	
					objEnvioPagosMasivosBE.verificarTablaAutorizar();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						
					if(valor==1){
						//-----------------------SELECCIONA PARA FIRMAR O VER DETALLE
						if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.Gstr_ID_CASO_LOTE)){	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
							//-------
							FuncionesGenerales.casosEjecutar(PagosMasivosBE.Gstr_ID_CASO_LOTE,2);//captura todos los id a hacer prueba
							objSQL.listaTablaIdCaso("APP_AND_PAGO_MAS_ADMPAGOS_D","",2);
						
							while (Mdl_Variables.Grst_TablaLogin.next()==true) {	
					    		
					    		if 	(FuncionesGenerales.existeCasosEjecutar(Mdl_Variables.Garr_CasoAfiliacion) == true){  
						    		if (FuncionesGenerales.buscarCasosEjecutar(Mdl_Variables.Grst_TablaLogin.getString("ID_CASO"),2) == true){
						    			Lbln_Bandera = objPagosMasivosBL.obtenerCamposBD(Mdl_Variables.Grst_TablaLogin, 2);//capturo todos los datos de el lote
						    			
						    			if(Lbln_Bandera){
						    				if(PagosMasivosBE.GstrTXT_SUBMENU1.equals("Pagos por Autorizar")){
						    					Lbln_Bandera= objEnvioPagosMasivosBE.seleccionarLoteFirmar(); //FIRMAR
						    				}else{
						    					Lbln_Bandera= objEnvioPagosMasivosBE.seleccionarLoteDetalle();//VER DETALLE
						    				}
						    			}
						    		}
					    		}
					    	}//casa
							//------
							
							
							if (Lbln_Bandera){	
								if(PagosMasivosBE.GstrTXT_SUBMENU1.equals("Pagos por Autorizar")){
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en los lotes a FIRMAR"); //FIRMAR
			    				}else{
			    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el link para ver DETALLE");//VER DETALLE
			    					bVerDetalle = true;
			    				}	
							}else{									
								bandera = false;
								if(PagosMasivosBE.GstrTXT_SUBMENU1.equals("Pagos por Autorizar")){
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en los lotes a FIRMAR"); //FIRMAR
			    				}else{
			    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el link para ver DETALLE");//VER DETALLE
			    					bVerDetalle = true;
			    				}
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						//----------------------
					}else{
						Lbln_Bandera= objEnvioPagosMasivosBE.seleccionarLoteFirmar(); //FIRMAR
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(bVerDetalle){
					//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_ENVIAR_CORREO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objEnvioPagosMasivosBE.ingresoEnviarCorreoCab("SeccionDetallePagosAutorizar")){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objEnvioPagosMasivosBE.ingresarTituloCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){
							objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objEnvioPagosMasivosBE.ingresarMensajeCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){
							objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE, "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE, "" ,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR_CORREO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
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
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_EXCEL)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objEnvioPagosMasivosBE.ingresoExportarExcelCab("SeccionDetallePagosAutorizar")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_PDF)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objEnvioPagosMasivosBE.ingresoExportarPdfCab("SeccionDetallePagosAutorizar")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_IMPRIMIR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objEnvioPagosMasivosBE.ingresoImprimirCab("SeccionDetallePagosAutorizar")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					//---------------------------------------------------------
					
					//------------  VALIDANDO CAMBIO SIMBOLO MONEDA EN GRILLAS -----
					String strCadena = "Nuevos";
					String strTexto = objPagoMasivoAdministracionPagoBE.BuscarCadenaTabla(strCadena,"DetallePagoAutorizarMonedaOperacion");
					if(!strTexto.equals("")){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Pagos por Autorizar, columna Moneda de la Operación", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: En la columna Moneda de la Operacion de la Tabla", "" ,"");
					}
					
					strCadena = "S/.";
					strTexto = "";
					strTexto = objPagoMasivoAdministracionPagoBE.ObtenerTextoMontoDetalleAutorizaciones();
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Pagos por Autorizar, valor Monto Total Soles", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto, "" ,"");
					}
					//--------------------------------------------------------------
				}
				
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrBTN_AUTORIZAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoBotonAutorizar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AUTORIZAR");
						TipoLog="1";
						objEnvioPagosMasivosBE.verificarResultadoConfirmacion();
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
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrBTN_BLOQUEAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoBotonBloquear()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BLOQUEAR");
						TipoLog="1";
						objEnvioPagosMasivosBE.verificarResultadoConfirmacion();
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
				
				if(GstrTXT_CLAVE.equals("SI")){
					objEnvioPagosMasivosBE.verificarConfirmarOperacion();
					if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
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
				
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrTXT_CLAVE_DINAMICA)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresarClaveDinamica(PagosMasivosBE.GstrTXT_CLAVE_DINAMICA)){	
						objFuncionesGenerales.callPasosAcierto(3, "La clave dinámica", PagosMasivosBE.GstrTXT_CLAVE_DINAMICA,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La clave dinámica", PagosMasivosBE.GstrTXT_CLAVE_DINAMICA,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrBTN_CONFIRMAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoBotonConfirmar1()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
						TipoLog="1";
						objEnvioPagosMasivosBE.verificarResultadoEsperadoFinal();
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
				
//				if (objFuncionesGenerales.verificarIgnore(EnviosBL.GstrTXT_MENSAJE_ERROR))
//				{		
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
//					if (objEnvioPagosMasivosBE.compararMensajeResultante1(EnviosBL.GstrTXT_MENSAJE_ERROR))
//					{	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"se compara mensaje FINAL");
//						TipoLog="1";
//					}else{
//						TipoLog="0";										
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"se compara mensaje FINAL");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosBE.GstrBTN_CANCELAR_OPERACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.ingresoBotonCancelarOperacion()){	
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
				
				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
					//esperar mensaje
					objEnvioPagosMasivosBE.verificarmensajeFinal();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objEnvioPagosMasivosBE.compararResultadoEsperado(GstrRESULTADO_ESPERADO))
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
				}
				
				if(bandera){
					if(consulta==true){
						bandera=objConsultaHistoricaBL.consultaHistorico("Pagos Masivos",GstrCMB_EMPRESA,PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO,1,PagosMasivosAdministracionAfiliadosBE.GstrESTADO,PagosMasivosAdministracionAfiliadosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS,PagosMasivosAdministracionAfiliadosBE.strIdCaso);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					}else{
						objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
					}
				}
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
