package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.FinanciamientoDocumentosEleConsultasAdeVenBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleConsultasAdeVenBL extends FinanciamientoDocumentosEleConsultasAdeVenBE{
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	
	FinanciamientoDocumentosEleConsultasAdeVenMapeo objFinanciamientoDocumentosEleConsultasAdeVenBE= new FinanciamientoDocumentosEleConsultasAdeVenMapeo();
	private static String TipoLog = null;
	
	public boolean consultarAdelVenc() throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;
		
		try{
						
			objHeader.menuPrincipal("<IGNORE>", "Financiamiento", "Consultas de Adelantos y Vencimientos");
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.seleccionarEmpresa( GstrCMB_EMPRESA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PRODUCTO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.seleccionarProducto( GstrCMB_PRODUCTO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "PRODUCTO "+ GstrCMB_PRODUCTO, "" ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "PRODUCTO "+ GstrCMB_PRODUCTO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_SITUACION))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.seleccionarSituacion( GstrCMB_SITUACION))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "SITUACION "+ GstrCMB_SITUACION, "" ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "SITUACION "+ GstrCMB_SITUACION, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_PROVEEDOR))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresarProveedor( GstrTXT_PROVEEDOR))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"PROVEEDOR ", GstrTXT_PROVEEDOR ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "PROVEEDOR ", GstrTXT_PROVEEDOR ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_BUSQUEDA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.seleccionarTipoBusqueda( GstrCMB_TIPO_BUSQUEDA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "TIPO DE BÚSQUEDA "+ GstrCMB_TIPO_BUSQUEDA, "" ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "TIPO DE BÚSQUEDA "+ GstrCMB_TIPO_BUSQUEDA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresarFechaDesde( GstrTXT_FECHA_DESDE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA DESDE ", GstrTXT_FECHA_DESDE ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA DESDE ", GstrTXT_FECHA_DESDE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresarFechaHasta( GstrTXT_FECHA_HASTA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA HASTA ", GstrTXT_FECHA_HASTA ,"");
					TipoLog="1";					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA HASTA ", GstrTXT_FECHA_HASTA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR))
			{       
		          
		          LStr_HoraInicio = System.currentTimeMillis();    
		          if (objFinanciamientoDocumentosEleConsultasAdeVenBE.buscar())		          { 
		        	  objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Buscar ");
		        	  objFinanciamientoDocumentosEleConsultasAdeVenBE.verificarTablaResultado();
		        	  TipoLog="1";
		          }else{
		        	  TipoLog="0";
		        	  bandera = false;
		        	  objFuncionesGenerales.callPasosErrado(1, "", "" ,"Buscar");			        
		          }
		          LStr_HoraFin = System.currentTimeMillis();  
		          Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
		          CapturarPantalla.scrollCapturaPantalla();
		          objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrVERIFICAR_NUM_INTERNO))
			{       
		          
		          LStr_HoraInicio = System.currentTimeMillis();    
		          if (objFinanciamientoDocumentosEleConsultasAdeVenBE.buscarNumeroInterno())		          { 
		        	  objFuncionesGenerales.callPasosAcierto(6, "la Columna: Nro. Interno", "" ,"");
		        	  objFinanciamientoDocumentosEleConsultasAdeVenBE.verificarTablaResultado();
		        	  TipoLog="1";
		          }else{
		        	  TipoLog="0";
		        	  bandera = false;
		        	  objFuncionesGenerales.callPasosErrado(6, "la Columna: Nro. Interno", "" ,"");
		          }
		          
		          String Cadena=objFinanciamientoDocumentosEleConsultasAdeVenBE.buscarNullNumeroInterno();
		          if (Cadena.isEmpty()){ 
		        	  objFuncionesGenerales.callPasosAcierto(8, "El valor en el Nro. de Documento es conforme", "" ,"");
		        	  objFinanciamientoDocumentosEleConsultasAdeVenBE.verificarTablaResultado();
		        	  TipoLog="1";
		          }else{
		        	  TipoLog="0";
		        	  bandera = false;
		        	  objFuncionesGenerales.callPasosErrado(8, "Existen campos vacios en los siguientes Nro. de Documentos: "+Cadena, "" ,"");
		          }
		          
		          LStr_HoraFin = System.currentTimeMillis();  
		          Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
		          CapturarPantalla.scrollCapturaPantalla();
		          objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresoLinkEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar por e-mail");
					TipoLog="1";
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
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresarCorreo( GstrTXT_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO, "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO, "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  	
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO))
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
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
					objFinanciamientoDocumentosEleConsultasAdeVenBE.verificarPopUpEnvioCorreo();
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresoBotonAceptar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresoLinkExportarExcel()){	
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
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresoLinkExportarPDF()){	
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
				if (objFinanciamientoDocumentosEleConsultasAdeVenBE.ingresoLinkImprimir()){	
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
