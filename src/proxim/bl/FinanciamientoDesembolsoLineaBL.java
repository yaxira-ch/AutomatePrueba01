package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDesembolsoLineaBL extends FinanciamientoDesembolsoLineaBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDesembolsoLineaGeneralMapeo objFinanciamientoDesembolsoLineaBE = new FinanciamientoDesembolsoLineaGeneralMapeo();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	public boolean desembolsoLinea() throws SQLException, IOException{
		boolean blnBandera = true;
		String strHoraFin;
		long Lng_TiempoEjeCaso;
		String strHoraInicio;
		String strTipoLog = null;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		String strTextoImagen="1. Imagenes";
		
		try {
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			//------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR)){	
				if(objFinanciamientoDesembolsoLineaBE.verificarMensaje()){
					strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					String LstrRESULTADO_ESPERADO="Te recordamos que tu línea de crédito no se encuentra vigente, para poder realizar desembolsos debes contactarte con tu ejecutivo de negocios";
					if (objFinanciamientoDesembolsoLineaBE.compararMensajePopUp( LstrRESULTADO_ESPERADO)){	
						objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado: "+LstrRESULTADO_ESPERADO, "Resultado Obtenido." ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";										
						blnBandera = false;
						objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado: "+LstrRESULTADO_ESPERADO, "Resultado Obtenido." ,"");
					}
					strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
				}
				
				if(blnBandera){
					strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					if (objFinanciamientoDesembolsoLineaBE.ingresoBotonAceptar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnBandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
					}
					strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_SI) ||objFuncionesGenerales.verificarIgnore( GstrBTN_NO)){	
				if(objFinanciamientoDesembolsoLineaBE.verificarMensaje()){
					strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					String LstrRESULTADO_ESPERADO=" PARA REALIZAR ESTA OPERACIÓN, NECESITAS ";//COMPARA MENSAJESSSSSSSSSS
					if (objFinanciamientoDesembolsoLineaBE.compararMensajePopUp( LstrRESULTADO_ESPERADO)){	
						objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado: "+LstrRESULTADO_ESPERADO, "Resultado Obtenido." ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";										
						blnBandera = false;
						objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado: "+LstrRESULTADO_ESPERADO, "Resultado Obtenido." ,"");
					}
					strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
				}
				
				if(blnBandera){
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_SI)){	
						strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						
						if (objFinanciamientoDesembolsoLineaBE.ingresoBotonSI()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI");
							strTipoLog="1";
						}else{
							strTipoLog="0";									
							blnBandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI");
						}
						strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_NO)){	
						strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						
						if (objFinanciamientoDesembolsoLineaBE.ingresoBotonNO()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO");
							strTipoLog="1";
						}else{
							strTipoLog="0";									
							blnBandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO");
						}
						strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
					}
				}
			}
			
			objFinanciamientoDesembolsoLineaBE.verificarEnvioSolicitud();
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDesembolsoLineaBE.seleccionarEmpresa( GstrCMB_EMPRESA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					strTipoLog="1";
					Thread.sleep(8600);
					
				}else{
					strTipoLog="0";	
				blnBandera = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			objFinanciamientoDesembolsoLineaBE.verificarMonto();
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MONTO)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDesembolsoLineaBE.ingresarMonto( GstrTXT_MONTO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MONTO "+GstrTXT_MONTO , "" ,  "");
					strTipoLog="1";
					if(objFinanciamientoDesembolsoLineaBE.verificarLineaVigente()){
						objFinanciamientoDesembolsoLineaBE.GuardarCamposDesembolsoLinea();
					}
				}else{
					strTipoLog="0";	
				blnBandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El MONTO "+GstrTXT_MONTO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore( GstrCMB_MONEDA)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDesembolsoLineaBE.seleccionarMoneda( GstrCMB_MONEDA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_NUMERO_CUOTAS)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objFinanciamientoDesembolsoLineaBE.seleccionarNumeroCuotas( GstrCMB_NUMERO_CUOTAS)){	
					objFuncionesGenerales.callPasosAcierto(2, "del NÚMERO DE CUOTAS "+GstrCMB_NUMERO_CUOTAS, "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del NÚMERO DE CUOTAS "+GstrCMB_NUMERO_CUOTAS, "" ,  "");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if(blnBandera && !GstrCMB_NUMERO_CUOTAS.equals("1")){
				if (objFuncionesGenerales.verificarIgnore( GstrCMB_FRECUENCIA)){	
					strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDesembolsoLineaBE.seleccionarFrecuencia( GstrCMB_FRECUENCIA)){	
						objFuncionesGenerales.callPasosAcierto(2, "de la FRECUENCIA "+GstrCMB_FRECUENCIA , "" ,  "");
						strTipoLog="1";
					}else{
						strTipoLog="0";			
						blnBandera = false;
						objFuncionesGenerales.callPasosErrado(2, "de la FRECUENCIA "+GstrCMB_FRECUENCIA , "" ,  "");
					}
					strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPO_CRONOGRAMA)){	
					strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDesembolsoLineaBE.seleccionarTipoCronograma( GstrCMB_TIPO_CRONOGRAMA)){	
						objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE CRONOGRAMA "+GstrCMB_TIPO_CRONOGRAMA , "" ,  "");
						strTipoLog="1";
					}else{
						strTipoLog="0";			
						blnBandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del TIPO DE CRONOGRAMA "+GstrCMB_TIPO_CRONOGRAMA , "" ,  "");
					}
					strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_FECHA_PRIMERA_CUOTA)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDesembolsoLineaBE.ingresarFechaPrimeraCuota( GstrTXT_FECHA_PRIMERA_CUOTA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE LA PRIMERA CUOTA "+GstrTXT_FECHA_PRIMERA_CUOTA,"","");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE LA PRIMERA CUOTA "+GstrTXT_FECHA_PRIMERA_CUOTA,"","");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONTINUAR)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objFinanciamientoDesembolsoLineaBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if(objFinanciamientoDesembolsoLineaBE.verificarTablaDetalle()){
				objFinanciamientoDesembolsoLineaBE.GuardarCamposInteresToralPagar();
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_CUENTA)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				
				if (objFinanciamientoDesembolsoLineaBE.seleccionarCuenta( GstrCMB_CUENTA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA "+GstrCMB_CUENTA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA "+GstrCMB_CUENTA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONTINUAR_REG)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objFinanciamientoDesembolsoLineaBE.ingresoBotonContinuarNew()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if(objFinanciamientoDesembolsoLineaBE.verificarConfirmaOperacion()){
				objFinanciamientoDesembolsoLineaBE.GuardarCamposTEA();
			}
			
			if( GstrTXT_CLAVE.equals("SI")&&objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
					strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnBandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					}
					strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDesembolsoLineaBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CLAVE DINAMICA ", GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La CLAVE DINAMICA ", GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONFIRMAR)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDesembolsoLineaBE.ingresoBotonConfirmar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CANCELAR_OPERACION)){	
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDesembolsoLineaBE.ingresoBotonCancelarOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrRESULTADO_ESPERADO))
			{		
				objFinanciamientoDesembolsoLineaBE.verificarResultadoFinal();
				String str_Mensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[1]" );
				
				strHoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
				if (objFinanciamientoDesembolsoLineaBE.compararMensajeResultanteAfiliado( GstrRESULTADO_ESPERADO)){	
					objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado: "+GstrRESULTADO_ESPERADO, "Resultado Obtenido: "+str_Mensaje ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado: "+GstrRESULTADO_ESPERADO, "Resultado Obtenido: "+str_Mensaje ,"");
				}
				strHoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),strHoraInicio);
			}
			
			if(blnBandera&&objFinanciamientoDesembolsoLineaBE.compararResultadoEsperadoPositivo()){	
				objFinanciamientoDesembolsoLineaBE.GuardarDatosOperacion(1);
				
				if(GstrFIRMAR.equals("NO") && GstrESTADO.equals("Procesada")){
					blnBandera=objConsultaHistoricaBL.consultaHistorico("Desembolso en Línea",GstrCMB_EMPRESA,FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA,1,FinanciamientoDesembolsoLineaBE.GstrESTADO,FinanciamientoDesembolsoLineaBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS,FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO);
					
//						bandera=objFinanciamientoDesembolsoLineaProcesadasBL.FinanciamientoDesembolsoLineaProcesadas(1);
					
//						if (bandera&& objFuncionesGenerales.verificarIgnore(StrCONSULTAR_SALDOS_MOVIMIENTOS)){
//							String strmontoPagar1=Mdl_Variables.StrTotal_Pagar.replace(" ", "");
//							bandera=objConsultaSaldoMovimientoConsolidadoBL.ConsultaSaldoMovimientos(GstrCMB_EMPRESA,GstrCMB_CUENTA);
//						}
					
				}
				
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_CERRAR_SESION)){	
				objHeader.cerrarSesion( GstrLNK_CERRAR_SESION, GstrLNK_CERRAR_SESION);
			}
			
//------------------------------------------------------REALIZA EL PAGO------------------------------------------------------
			if(blnBandera && GstrFIRMAR.equals("SI")){
					
				if(GstrOPERADOR.equals("<IGNORE>")){
					if (!GstrFIRMANTE3.equals("<IGNORE>")){
						consultar3=true;
					}else if (!GstrFIRMANTE2.equals("<IGNORE>")){
						consultar2=true;
					}else{
						if (!GstrFIRMANTE1.equals("<IGNORE>")){
							consultar1=true;
						}
					}
				}
				
					
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1)){
					if (GstrFIRMANTE1.equals("PA") ){
						blnBandera=objFirmarBL.firmaFinanciamiento("APP_FINANCIAMIENTO_DESLINEA_AUTORIZAR_D",Gstr_ID_CASO,"F1",consultar1);
					}else if (GstrFIRMANTE1.equals("PORT") ){
						blnBandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Desembolso en Línea",consultar1,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA,null);
					}else{
						blnBandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F1",GstrTXT_SUBMENU,consultar1);
					}
				}
				
				if(blnBandera){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
						if (GstrFIRMANTE2.equals("PA") ){
							blnBandera=objFirmarBL.firmaFinanciamiento("APP_FINANCIAMIENTO_DESLINEA_AUTORIZAR_D",Gstr_ID_CASO,"F2",consultar2);
						}else if (GstrFIRMANTE2.equals("PORT") ){
							blnBandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Desembolso en Línea",consultar2,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA,null);
						}else{
							blnBandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F2",GstrTXT_SUBMENU,consultar2);
						}
					}
					
					if(blnBandera){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
							if (GstrFIRMANTE3.equals("PA")  ){
								blnBandera=objFirmarBL.firmaFinanciamiento("APP_FINANCIAMIENTO_DESLINEA_AUTORIZAR_D",Gstr_ID_CASO,"F3",consultar3);
							}else if (GstrFIRMANTE3.equals("PORT")   ){
								blnBandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Desembolso en Línea",consultar3,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA,null);
							}else{
								blnBandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F3",GstrTXT_SUBMENU,consultar3);
							}
						}
						
						if(blnBandera&&objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
							blnBandera=objFirmarBL.firmaFinanciamiento("APP_FINANCIAMIENTO_DESLINEA_AUTORIZAR_D",Gstr_ID_CASO,"OP",true);
						}
					}
				}
			}
		} catch (Exception e) {
			blnBandera=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnBandera;
	}
}