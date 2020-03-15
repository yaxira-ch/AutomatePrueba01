package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.FinanciamientoDescuentosCobNotifiVencimientoBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobNotifiVencimientoBL extends FinanciamientoDescuentosCobNotifiVencimientoBE{

	boolean bandera;
	long LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	long LStr_HoraInicio;
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	private static String TipoLog = null;
	
	FinanciamientoDescuentosCobNotifiVencimientoMapeo objFinanciamientoDescuentosCobNotifiVencimientoMapeo=new FinanciamientoDescuentosCobNotifiVencimientoMapeo();
	
	public boolean realizarConsulta() throws SQLException, IOException{
		
		bandera = true;
		
		try{
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal( "<IGNORE>","Financiamiento", "Notificación de Vencimiento");
			//----------------------------------------------------------------------------------
	
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.seleccionarEmpresa( GstrCMB_EMPRESA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_BUSQUEDA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.seleccionarBusqueda( GstrCMB_BUSQUEDA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_BUSQUEDA "+ GstrCMB_BUSQUEDA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_BUSQUEDA "+ GstrCMB_BUSQUEDA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.seleccionarMoneda( GstrCMB_MONEDA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CMB_MONEDA "+ GstrCMB_MONEDA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "CMB_MONEDA "+ GstrCMB_MONEDA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.ingresarFechaDesde( GstrTXT_FECHA_DESDE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TXT_FECHA_DESDE", GstrTXT_FECHA_DESDE ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
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
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.ingresarFechaHasta( GstrTXT_FECHA_HASTA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TXT_FECHA_HASTA", GstrTXT_FECHA_HASTA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "TXT_FECHA_HASTA", GstrTXT_FECHA_HASTA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DOCUMENTO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.ingresarNumeroDocumento( GstrTXT_NUMERO_DOCUMENTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TXT_NUMERO_DOCUMENTO", GstrTXT_NUMERO_DOCUMENTO,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "TXT_NUMERO_DOCUMENTO", GstrTXT_NUMERO_DOCUMENTO,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR))
			{       

				if(objFinanciamientoDescuentosCobNotifiVencimientoMapeo.buscar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "","Buscar");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
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
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.ingresarEnvioCorreo()){
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

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP)){
					objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP)){
					objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.enviarCorreo()){
					Thread.sleep(3000);
					objFinanciamientoDescuentosCobNotifiVencimientoMapeo.aceptarEnvio();
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

			CapturarPantalla.pageDown("1200");

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = System.currentTimeMillis();   
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.exportarExcel()){
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

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
				LStr_HoraInicio = System.currentTimeMillis();  
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.exportarPdf()){
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
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.imprimir()){
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
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_SELECCIONAR)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objFinanciamientoDescuentosCobNotifiVencimientoMapeo.seleccionarDocumento(GstrLBL_NUM_DOC,GstrTXT_EMAIL)){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(2, "Documento: "+GstrLBL_NUM_DOC, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "Documento: "+GstrLBL_NUM_DOC, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR))
			{       

				if(objFinanciamientoDescuentosCobNotifiVencimientoMapeo.enviar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "","Enviar");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "","Enviar");
				}
				CapturarPantalla.pageDown("-400");
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR))
			{       

				if(objFinanciamientoDescuentosCobNotifiVencimientoMapeo.regresar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "","Regresar");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "","Regresar");
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
			bandera = false;
		}
		return bandera;
	}
}
