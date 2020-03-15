	package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;
//----
public class AutorizacionesPendientesBL extends AutorizacionesPendientesBE { 
	private static String strTipoLog = null;
	static FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static ConexionSqlServer objSQL = new  ConexionSqlServer();
	static ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	static AutorizacionesPendientesMapeo objAutorizacionesPendientesBE = new AutorizacionesPendientesMapeo();
	static String strHoraInicio;
	static boolean blnResultadoEsperado = true;
	static String strHoraFin;
	static long lngTiempoEjeCaso;
	Calendar calendario = new GregorianCalendar();
	int hora, minutos;
	static String strTextoImagen="1. Imagenes";	
	static String strFechaHora="dd/MM/yyyy HH:mm:ss";
	String strFechaEjecucionCaso=new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	
	public boolean autorizacionesPendientes(int opcion,boolean consultar) throws SQLException, IOException{
		String tabla=null;
		int horaInicio=8;
		int horaFin=20;
		
		try {
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal( Mdl_Variables.Gstr_Ignore,GstrTXT_MENU, GstrTXT_SUBMENU);
			
			//------------------------------------------------------------------------------			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objAutorizacionesPendientesBE.seleccionarEmpresa(GstrCMB_EMPRESA)){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_OPERACION)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
				objAutorizacionesPendientesBE.verificarTipoOperacion();
				if (objAutorizacionesPendientesBE.seleccionarTipoOperacion(GstrCMB_TIPO_OPERACION)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la TIPO DE OPERACIÓN "+GstrCMB_TIPO_OPERACION , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la TIPO DE OPERACIÓN "+GstrCMB_TIPO_OPERACION , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonBuscar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					strTipoLog="1";
					Thread.sleep(1800);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
	    	}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar por e-mail");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar por e-mail");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objAutorizacionesPendientesBE.ingresarCorreo( GstrTXT_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO, "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO, "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objAutorizacionesPendientesBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonEnviar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkExportarExcel()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			CapturarPantalla.pageDown("1000");
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkExportarPDF()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkImprimir()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK  Imprimir");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK  Imprimir");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//---------------------------------------SELECCIONAR LOTE A AUTORIZAR---------------------------------------
			if(opcion==1){
				objAutorizacionesPendientesBE.verificarTablaPendientes();
				FuncionesGenerales.casosEjecutar(AutorizacionesPendientesBE.GstrID_CASO_LOTE,2);//guarda EL ID de los casos a ejecutar en un array
    			int valor=Mdl_Variables.Garr_CasoAfiliacion.length-1;
				for (int i=0;i<=valor;i++){
    				switch (AutorizacionesPendientesBE.GstrTIPO_PRODUCTO) {
	    				case "Entre cuentas":
	    					tabla="APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D";
	    					break;
	    				case "A Terceros":
	    					tabla="APP_AND_TRANSFERENCIAS_A_TERCEROS_D";
	    					break;
	    				case "A otros Bancos CCE":
	    					tabla="APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D";
	    					break;
	    					
	    				case "A otros Bancos BCR":
	    					tabla="APP_AND_TRANSFERENCIAS_OTROS_BANCOS_BCR_D";
	    					break;
    				}
    				objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO="+Mdl_Variables.Garr_CasoAfiliacion[i]+" ","",4);
    				while(Mdl_Variables.Grst_Firmante.next()){
    					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
    					if (objAutorizacionesPendientesBE.seleccionarCheckFirmar(Mdl_Variables.Grst_Firmante.getString("NUMERO_SOLICITUD"))){	
    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Registro a AUTORIZAR");
    						strTipoLog="1";
    					}else{
    						strTipoLog="0";									
    						blnResultadoEsperado = false;
    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Registro a AUTORIZAR");
    					}
    					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
    				
    				}
				}
				
			}else{//Solo para el caso en que se quiere firmar el lote que se envio
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_AUTORIZAR)){	
					objAutorizacionesPendientesBE.verificarTablaPendientes();
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
					if (objAutorizacionesPendientesBE.seleccionarLoteFirmar(strFechaEjecucionCaso)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LOTE a Firmar");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LOTE a Firmar");
					}					
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				}
			}
			//------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_AUTORIZAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AUTORIZAR");					
					strTipoLog="1";
					CapturarPantalla.pageDown("-1000");
					objAutorizacionesPendientesBE.verificarConfiracion();
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AUTORIZAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if(AutorizacionesPendientesBE.GstrTIPO_PRODUCTO.equals("A otros Bancos BCR")&& !TransferenciaBE.GstrESTADO.equals(Mdl_Variables.Gstr_Ignore)){	
				//Validamos que la hora sea mayor o igual que la 1
		         hora = calendario.get(Calendar.HOUR_OF_DAY);
		         minutos = calendario.get(Calendar.MINUTE);
		         
		         if(((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59))){
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objAutorizacionesPendientesBE.ingresoBotonSiPopUp()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del POPUP");
							strTipoLog="1";
						}else{
							strTipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del POPUP");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objAutorizacionesPendientesBE.ingresoBotonNoPopUp()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del POPUP");
							strTipoLog="1";
						}else{
							strTipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del POPUP");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
		         }
			}
		
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BLOQUEAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonBloquear()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BLOQUEAR");
					strTipoLog="1";
					objAutorizacionesPendientesBE.verificarConfiracion();
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BLOQUEAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			
			if(GstrTIPO_PRODUCTO.contains("Carta Fianza") && objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaGeneralBE.GstrCHK_ACEPTAR_TERMINOS)){
				objAutorizacionesPendientesBE.verificarDetalleCartaFianza();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoChkAceptarTerminosAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "","en el CHK Aceptar Terminos");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "","en el CHK Aceptar Terminos");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (GstrTXT_CLAVE.equals("SI")){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresarClaveDinamica(AutorizacionesPendientesBE.GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinámica ", AutorizacionesPendientesBE.GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinámica ", AutorizacionesPendientesBE.GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonConfirmar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					CapturarPantalla.pageDown("-1000");
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}				
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			//Validamos que la hora sea mayor o igual que la 1
			 hora = calendario.get(Calendar.HOUR_OF_DAY);
	         minutos = calendario.get(Calendar.MINUTE);
	         
			if(GstrTIPO_PRODUCTO.equals("A otros Bancos BCR")&&	((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59))){
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP1)){	
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objAutorizacionesPendientesBE.ingresoBotonSiPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del POPUP");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del POPUP");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP1)){	
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objAutorizacionesPendientesBE.ingresoBotonNoPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del POPUP");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del POPUP");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonCancelarOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	//esperar resultado esperado
				Thread.sleep(1800);
				objAutorizacionesPendientesBE.verificarImagenPendieEnviada();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				String strMensaje = objAutorizacionesPendientesBE.obtenerResultado();
				if (strMensaje.equals(GstrRESULTADO_ESPERADO))
				{	
					objAutorizacionesPendientesBE.guardarCampos();
					objFuncionesGenerales.callPasosAcierto(5, strMensaje, GstrRESULTADO_ESPERADO ,"");
					strTipoLog="1";
					if(GstrCMB_TIPO_OPERACION.equals("Pago de Documentos")){
						//Validamos que la hora sea mayor o igual que la 1
				         hora = calendario.get(Calendar.HOUR_OF_DAY);
				         minutos = calendario.get(Calendar.MINUTE);
				         
				         if((hora<=horaInicio && hora>=horaFin)&&(minutos>=00 && minutos<=59)&&(consultar)){
							strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
							if (objAutorizacionesPendientesBE.verificarMensajeInformativo()){	
								objFuncionesGenerales.callPasosAcierto(6, " EL MENSAJE INFORMATIVO Y ESTADO OPERACIÓN RECHAZADO" , "" ,  "");
								strTipoLog="1";
							}else{
								strTipoLog="0";			
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(6, " EL MENSAJE INFORMATIVO Y ESTADO OPERACIÓN RECHAZADO" , "" ,  "");
							}
							strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
			    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
						}
					}else if(GstrCMB_TIPO_OPERACION.equals("Comercio Exterior")){
						if(!(consultar && TransferenciasExteriorBE.GstrESTADO.equals(Mdl_Variables.Gstr_Parametros[16]))){
							String valoresIncorrectos=TransferenciaExteriorMapeo.verificarMensajeConfirmacion(consultar);						
							if (valoresIncorrectos.equals("")){ 
								objFuncionesGenerales.callPasosAcierto(7, " Todos los mensajes son correctos", "" ,"");
								strTipoLog="1";
							}else{
								strTipoLog="0";
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(7, "Pantalla de confirmación - autorizaciones pendientes :\n"+valoresIncorrectos, "" ,"");			        
							}
						}
					}
					
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, strMensaje, GstrRESULTADO_ESPERADO ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_FINAL))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkEnviarEmailFinal()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objAutorizacionesPendientesBE.ingresarCorreo( GstrTXT_CORREO_FINAL)){	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_FINAL , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_FINAL , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objAutorizacionesPendientesBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO_FINAL)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_FINAL , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_FINAL , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonEnviar()){	
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

			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkExportarExcelFinal()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkExportarPDFFinal()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_FINAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkImprimirFinal()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_REALIZAR_OTRA_OPERACION)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkRealizarOtraOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Realizar otra operación");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Realizar otra operación");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (consultar){
				String cuentaCargo="";
				String estado="";
				String consultaSaldosMovimientos="";
				String strIdCaso="";
				
				switch (GstrCMB_TIPO_OPERACION) {
    				case "Pagos Masivos": 
    					cuentaCargo= PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO;
    					estado=PagosMasivosAdministracionAfiliadosBE.GstrESTADO;
    					consultaSaldosMovimientos=PagosMasivosAdministracionAfiliadosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
    					strIdCaso=PagosMasivosAdministracionAfiliadosBE.strIdCaso;
    		    		break;
    		    		
    				case "Desembolso en Línea": 
    					cuentaCargo=FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA;
    					estado=FinanciamientoDesembolsoLineaBE.GstrESTADO;
    					consultaSaldosMovimientos=FinanciamientoDesembolsoLineaBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
    					strIdCaso=FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO;
    		    		break;
    		    		
    				case "Pago de Recibos": 
    					cuentaCargo=PagosRecibosBE.GstrCMB_CUENTA_CARGO;
    					estado=PagosRecibosBE.GstrESTADO;
    					consultaSaldosMovimientos=PagosRecibosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
    					strIdCaso=PagosRecibosBE.Gstr_ID_CASO;
    		    		break;
    		    		
    				case "Transferencias": 
    					if(Mdl_Variables.Gstr_Tabla.equals("TBL_TRANSFERENCIA_A_TERCEROS_PORTABILIDAD")) {
    						cuentaCargo=TransfATercerosPortabilidadBE.GstrCMB_CUENTA_ORIGEN;
        					estado=TransfATercerosPortabilidadBE.GstrESTADO;
        					consultaSaldosMovimientos=TransfATercerosPortabilidadBE.GstrBTN_CONSULTA_SALDOS;
        					strIdCaso=TransfATercerosPortabilidadBE.GstrID_CASO;
        				}else if(Mdl_Variables.Gstr_Tabla.equals("TBL_TRANSFERENCIA_ENTRE_CUENTA_PORTABILIDAD")) {
    						cuentaCargo=TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN;
        					estado=TransfEntreCuentasPortabilidadBE.GstrESTADO;
        					consultaSaldosMovimientos=TransfEntreCuentasPortabilidadBE.GstrBTN_CONSULTA_SALDOS;
        					strIdCaso=TransfEntreCuentasPortabilidadBE.GstrID_CASO;
    					}else if(Mdl_Variables.Gstr_Tabla.equals("TBL_TRANSFERENCIA_A_OTROS_BANCOS_CEE_PORTABILIDAD")) {
    						cuentaCargo=TransfOtrosBancosCCEPortabilidadBE.GstrCMB_CUENTA_ORIGEN;
        					estado=TransfOtrosBancosCCEPortabilidadBE.GstrESTADO;
        					consultaSaldosMovimientos=TransfOtrosBancosCCEPortabilidadBE.GstrBTN_CONSULTA_SALDOS;
        					strIdCaso=TransfOtrosBancosCCEPortabilidadBE.GstrID_CASO;
    					}else{
    						cuentaCargo=TransferenciaBE.GstrCMB_CUENTA_ORIGEN;
        					estado=TransferenciaBE.GstrESTADO;
        					consultaSaldosMovimientos=TransferenciaBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
        					strIdCaso=TransferenciaBE.Gstr_ID_CASO;
    					}
    					
    					break;
    		    	
    				case "Descuentos y Cobranza de Documentos": 
    					cuentaCargo=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_CUENTA_CORRIENTE;
    					estado=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrESTADO;
    					consultaSaldosMovimientos=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
    					strIdCaso=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.Gstr_ID_CASO;
    					break;
    				
    				case "Documentos Electrónicos": 
    					cuentaCargo=FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_CUENTA_CARGO;
    					estado=FinanciamientoDocumentosEleEnvioPlanillasBE.GstrESTADO;
    					consultaSaldosMovimientos=FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
    					strIdCaso=FinanciamientoDocumentosEleEnvioPlanillasBE.Gstr_ID_CASO;
    					break;
    				
    				case "Pago de Documentos": 
    					cuentaCargo=PagosDocumentosBE.strCMB_CUENTA_CARGO;
    					estado=PagosDocumentosBE.GstrESTADO;
    					consultaSaldosMovimientos=PagosDocumentosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS;
    					strIdCaso=PagosDocumentosBE.Gstr_ID_CASO;
    					break;

    		    	case "Carta Fianza": 
    					estado=ComercioExtCartaFianzaSolicitudBL.GstrESTADO;
    					consultaSaldosMovimientos="";
    					strIdCaso=ComercioExtCartaFianzaSolicitudBL.Gstr_ID_CASO;
    					break;
    					
    		    	case "Comercio Exterior": 
    					estado=TransferenciasExteriorBE.GstrESTADO;
    					consultaSaldosMovimientos="";
    					strIdCaso=TransferenciasExteriorBE.GstrID_CASO;
    					break;
    			}

				blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico(GstrCMB_TIPO_OPERACION,GstrCMB_EMPRESA,cuentaCargo,2,estado,consultaSaldosMovimientos,strIdCaso);
				
//				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION) &&!GstrCMB_TIPO_OPERACION.equals("Pagos Masivos")){	
//					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
//				}
				
			}else{
//				if((GstrCMB_TIPO_OPERACION.equals("Pagos Masivos")||GstrCMB_TIPO_OPERACION.contains("Documentos Electrónicos")||GstrCMB_TIPO_OPERACION.contains("Descuentos y Cobranza de Documentos")||GstrCMB_TIPO_OPERACION.contains("Carta Fianza")||GstrCMB_TIPO_OPERACION.contains("Transferencias"))&&objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)  )
//					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				if(objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)  )
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	    	blnResultadoEsperado = false;
	    	System.out.println("ERROR>>> "+e.getMessage());
		}
		return blnResultadoEsperado;
	}
	
	public static boolean generarExprotableDetalle() {
		try {
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkEnviarEmailDetalle()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objAutorizacionesPendientesBE.ingresarCorreo( GstrTXT_CORREO_DETALLE)){	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objAutorizacionesPendientesBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO_DETALLE)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonEnviar()){	
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
	
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkExportarExcelDetalle()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkExportarPDFDetalle()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_DETALLE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objAutorizacionesPendientesBE.ingresoLinkImprimirDetalle()){	
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
		
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	blnResultadoEsperado = false;
	    	System.out.println("ERROR>>> "+e.getMessage());
		}
		return blnResultadoEsperado;
	}
}



