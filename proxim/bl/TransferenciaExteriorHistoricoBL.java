package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaExteriorHistoricoBL extends TransferenciasExteriorBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean bandera = true;
	private static String TipoLog = null;
	long LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	long LStr_HoraInicio = System.currentTimeMillis();	
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	HeaderBL objHeader = new HeaderBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	TransferenciaExteriorHistoricoMapeo objTransferenciaExteriorHistoricoMapeo=new TransferenciaExteriorHistoricoMapeo(); 
	TransferenciaExteriorMapeo objTransferenciasExteriorMapeo=new TransferenciaExteriorMapeo();
	ConexionBL objConexionBL = new ConexionBL();
	public boolean consultarHistorico(String tipoConsulta,String estado,boolean indOtraOpcion) throws SQLException, IOException{		
				
		try{
			if(indOtraOpcion){
				objHeader.menuPrincipal("<IGNORE>", "Comercio Exterior", "Transferencias al Exterior");
			}
			
			if (objFuncionesGenerales.verificarIgnore("Consulta Historica")){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransferenciaExteriorHistoricoMapeo.seleccionarOpcion("Consulta Histórica")){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ," Consulta Historica");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ," Consulta Historica");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrIND_EMPRESA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (GstrIND_EMPRESA.equals("NO"))
				{ 
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_ORDENANTE))
				    {		          
						LStr_HoraInicio = System.currentTimeMillis();     
						if (objTransferenciaExteriorHistoricoMapeo.seleccionarEmpresa( GstrTXT_NOMBRE_ORDENANTE))
						{ 
							objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrTXT_NOMBRE_ORDENANTE, "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrTXT_NOMBRE_ORDENANTE, "" ,"");
						}
						LStr_HoraFin = System.currentTimeMillis(); 
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    }
				}
		    }
			
			if (objFuncionesGenerales.verificarIgnore(tipoConsulta))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciaExteriorHistoricoMapeo.seleccionarTipoConsulta( tipoConsulta))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "TIPO CONSULTA "+ tipoConsulta, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "TIPO CONSULTA "+ tipoConsulta, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(estado))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciaExteriorHistoricoMapeo.seleccionarEstado( estado))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "ESTADO "+ estado, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "ESTADO "+ estado, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			/*Date fechaActual=new Date();
			DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
			String fecha= formatoFecha.format(fechaActual);*/
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE_HISTORICA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciaExteriorHistoricoMapeo.ingresarFechaDesde( GstrTXT_FECHA_DESDE_HISTORICA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3, "FECHA DESDE ",GstrTXT_FECHA_DESDE_HISTORICA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA DESDE ",GstrTXT_FECHA_DESDE_HISTORICA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA_HISTORICA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciaExteriorHistoricoMapeo.ingresarFechaHasta( GstrTXT_FECHA_HASTA_HISTORICA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3, "FECHA HASTA ",GstrTXT_FECHA_HASTA_HISTORICA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA HASTA ",GstrTXT_FECHA_HASTA_HISTORICA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore("Buscar"))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciaExteriorHistoricoMapeo.buscar())
				{ 
					Thread.sleep(1000);
					objFuncionesGenerales.callPasosAcierto(1, "","" ," Buscar");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "","" ," Buscar");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }			
		
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();  
				if (objTransferenciaExteriorHistoricoMapeo.ingresarEnvioCorreo()){
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

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objTransferenciaExteriorHistoricoMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP_HISTORICA)){
					objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_HISTORICA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_HISTORICA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objTransferenciaExteriorHistoricoMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP_HISTORICA)){
					objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_HISTORICA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_HISTORICA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objTransferenciaExteriorHistoricoMapeo.enviarCorreo()){
					Thread.sleep(3000);
					objTransferenciaExteriorHistoricoMapeo.aceptarEnvio();
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

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();   
				if (objTransferenciaExteriorHistoricoMapeo.exportarExcel()){
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

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();  
				if (objTransferenciaExteriorHistoricoMapeo.exportarPdf()){
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
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR_HISTORICA)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objTransferenciaExteriorHistoricoMapeo.imprimir()){
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
			
			boolean seleccionSwift=false;
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_SWIFT))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if(objTransferenciaExteriorHistoricoMapeo.seleccionarSwift(GstrLBL_NRO_REFERENCIA,estado)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en link Ver Swift");
					TipoLog="1";
					seleccionSwift=true;
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en link Ver Swift");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if(seleccionSwift){
				
				Thread.sleep(100);	
				CapturarPantalla.pageDown("-1000");
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
				Thread.sleep(100);
				CapturarPantalla.pageDown("500");
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL_SWIFT)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciaExteriorHistoricoMapeo.ingresarEnvioCorreoSwift()){
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

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP_SWIFT)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP_SWIFT)){
						objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_SWIFT, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_SWIFT, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP_SWIFT)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP_SWIFT)){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_SWIFT, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_SWIFT, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP_SWIFT)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.enviarCorreo()){
						Thread.sleep(3000);
						objTransferenciaExteriorHistoricoMapeo.aceptarEnvio();
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

				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF_SWIFT)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciaExteriorHistoricoMapeo.exportarPdfSwift()){
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
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR_SWIFT)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.imprimirSwift()){
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
				if (objFuncionesGenerales.verificarIgnore("Regresar")){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.regresarSwift()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en link Regresar");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en link Regresar");
					}
					Thread.sleep(200);
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
			
			//
			boolean seleccionDebito=false;
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_SWIFT))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if(objTransferenciaExteriorHistoricoMapeo.seleccionarDebito(GstrLBL_NRO_REFERENCIA,estado)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en link Ver Nota de Débito");
					TipoLog="1";
					seleccionDebito=true;
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en link Ver Nota de Débito");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if(seleccionDebito){
				
				Thread.sleep(100);	
				CapturarPantalla.pageDown("-1000");
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
				Thread.sleep(100);
				CapturarPantalla.pageDown("500");
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL_DEBITO)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciaExteriorHistoricoMapeo.ingresarEnvioCorreoDebito()){
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

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP_DEBITO)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP_DEBITO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_DEBITO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_DEBITO, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP_DEBITO)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP_DEBITO)){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_DEBITO, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_DEBITO, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP_DEBITO)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.enviarCorreo()){
						Thread.sleep(3000);
						objTransferenciaExteriorHistoricoMapeo.aceptarEnvio();
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

				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF_DEBITO)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciaExteriorHistoricoMapeo.exportarPdfDebito()){
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
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR_DEBITO)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.imprimirDebito()){
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
				if (objFuncionesGenerales.verificarIgnore("Regresar")){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciaExteriorHistoricoMapeo.regresarDebito()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en link Regresar");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en link Regresar");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
			

			boolean seleccionNroRef=false;			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_DETALLE_HISTORICA)||objFuncionesGenerales.verificarIgnore(GstrVER_DETALLE_HISTORICA_ENVIO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if(objTransferenciaExteriorHistoricoMapeo.seleccionarNroReferencia(GstrLBL_NRO_REFERENCIA,estado)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en link Número de Referencia");
					TipoLog="1";
					seleccionNroRef=true;
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en link Número de Referencia");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (seleccionNroRef)
			{ 
			
				if(GstrESTADO.equals(Mdl_Variables.Gstr_Parametros[17])||estado.equals(Mdl_Variables.Gstr_Parametros[12])||estado.equals(Mdl_Variables.Gstr_Parametros[13])||estado.equals(Mdl_Variables.Gstr_Parametros[11])||estado.equals(Mdl_Variables.Gstr_Parametros[16])){
				      
					Thread.sleep(100);	
					CapturarPantalla.pageDown("-1000");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
					Thread.sleep(100);
					CapturarPantalla.pageDown("400");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					Thread.sleep(100);
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					

					LStr_HoraInicio = System.currentTimeMillis();    
					String valoresIncorrectos=objTransferenciaExteriorHistoricoMapeo.verificarDetalleConsultaHistorica(GstrLBL_NRO_REFERENCIA);
					if (valoresIncorrectos.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));						
				
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();  
						if (objTransferenciaExteriorHistoricoMapeo.ingresarEnvioCorreoDetalle()){
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
	
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciaExteriorHistoricoMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP_DETALLE_HISTORICA)){
							objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_DETALLE_HISTORICA, "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP_DETALLE_HISTORICA, "" ,"");
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
	
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciaExteriorHistoricoMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP_DETALLE_HISTORICA)){
							objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_DETALLE_HISTORICA, "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP_DETALLE_HISTORICA, "" ,"");
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
	
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciaExteriorHistoricoMapeo.enviarCorreo()){
							Thread.sleep(3000);
							objTransferenciaExteriorHistoricoMapeo.aceptarEnvio();
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
	
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();   
						if (objTransferenciaExteriorHistoricoMapeo.exportarExcelDetalle()){
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
	
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();  
						if (objTransferenciaExteriorHistoricoMapeo.exportarPdfDetalle()){
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
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR_DETALLE_HISTORICA)){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciaExteriorHistoricoMapeo.imprimirDetalle()){
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
					if (objFuncionesGenerales.verificarIgnore("Regresar")){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciaExteriorHistoricoMapeo.regresar()){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en link Regresar");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en link Regresar");
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
				}else if(estado.equals(Mdl_Variables.Gstr_Parametros[10])){
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					
					String valoresInc=objTransferenciasExteriorMapeo.verificarCamposLlenados(0);
					if (valoresInc.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresInc, "" ,"");			        
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);					
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					
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
