package proxim.bl;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciaCuentaPaypalBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaCuentaPaypalBL extends TransferenciaCuentaPaypalBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	HeaderBL objHeader = new HeaderBL();
	TransferenciaCuentaPaypalMapeo objTransferenciaCuentaPaypal=new TransferenciaCuentaPaypalMapeo();
	TransferenciaMapeo objTransferenciaGeneralBE = new TransferenciaMapeo();
	ConexionBL objConexionBL = new ConexionBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	private static String strTipoLog = null;
	TransferenciaCuentaPaypalMapeo objTransferenciaCuentaPaypalBE= new TransferenciaCuentaPaypalMapeo();
	long lngHoraFinEjecucion;
	long lngTiempoEjecucion;
	long lngHoraInicioEjecucion;
	boolean bandera = true;
	String strCuenta,strEmpresa,strNumeroCuenta;  
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	
	public boolean TransferenciaConsultaHistorica() throws SQLException, IOException{
		
		 
		try {
		//---------------------------------------MENU---------------------------------------
		

			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, "<IGNORE>");

			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objTransferenciaGeneralBE.seleccionarSubMenu1(GstrTXT_SUBMENU)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la PESTAÑA, "+GstrTXT_SUBMENU);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la PESTAÑA, "+GstrTXT_SUBMENU);
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
				lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_MENSAJE)){
				Thread.sleep(500);	
				if (objTransferenciaCuentaPaypal.verificarPopUpMensajeAdministrador()){	
					lngHoraInicioEjecucion = System.currentTimeMillis();
					String strValidarPaginaDos=objTransferenciaCuentaPaypal.verificarMensajePopUpNoAdministrador();
					if (strValidarPaginaDos.equals("")){
						objFuncionesGenerales.callPasosAcierto(8, "Mensaje mostrado correctamente.", "" ,"");
						strTipoLog="1";
						;
					}else{
						strTipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(8, strValidarPaginaDos, "" ,"");
					}
					lngHoraFinEjecucion = System.currentTimeMillis();	  
					lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));			
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_MENSAJE)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objTransferenciaCuentaPaypal.clicBotonAceptarNoAdministrador()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el boton ACEPTAR");
					strTipoLog="1";
					objTransferenciaCuentaPaypal.verificarPaginaPrincipalPaypal();
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el boton ACEPTAR");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
				lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_SUBMENU)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objTransferenciaCuentaPaypal.seleccionarLinkSubMenu(GstrLNK_SUBMENU)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK, "+GstrLNK_SUBMENU);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK, "+GstrLNK_SUBMENU);
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
				lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			//----------------------------------------------------------------------
			if(GstrLNK_SUBMENU.equals("Afiliación")){
				
				pasos();
				if(bandera){
//					pasosTeclado();
//					pasos();
//					if(bandera){
						Thread.sleep(9000);
						ArrayList<String> arrList=FuncionesGenerales.focoPantallaEmergente();
							    
						if (objFuncionesGenerales.verificarIgnore(GstrTXT_CONTRASENA)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  	
							if (objTransferenciaCuentaPaypal.ingresarContrasena(GstrTXT_CONTRASENA)){	
								objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA "+GstrTXT_CONTRASENA , "" ,  "");
								strTipoLog="1";
								Thread.sleep(1000);	
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA "+GstrTXT_CONTRASENA , "" ,  "");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
						
						if (objFuncionesGenerales.verificarIgnore(GstrBTN_AUTORIZAR)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							if (objTransferenciaCuentaPaypal.clicBotonAutorizar()){
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el BOTON AUTORIZAR");
								strTipoLog="1";
								//objTransferenciaCuentaPaypal.verificarConfirmacionPaypal();
								Mdl_Variables.Gwed_Driver.switchTo().window(arrList.get(0));
								Thread.sleep(8500);	
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el BOTON AUTORIZAR");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
						
						if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							if (objTransferenciaCuentaPaypal.clicBotonCancelar()){
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el BOTON CANCELAR");
								strTipoLog="1";
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el BOTON CANCELAR");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
											    
					    if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
					    	objTransferenciaCuentaPaypal.verificarResultadoFinal();
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							String strValidarPaginaDos=objTransferenciaCuentaPaypal.verificarCamposResultadoEsperadoAfilicion(GstrRESULTADO_ESPERADO,GstrTXT_USUARIO_PAYPAL,GstrCMB_EMPRESA,GstrCMB_CUENTA);
							if (strValidarPaginaDos.equals("")){
								objFuncionesGenerales.callPasosAcierto(8, strValidarPaginaDos, "" ,"");
								strTipoLog="1";
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(8, strValidarPaginaDos, "" ,"");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
//					}
				}
			}else{
				//------------------------------------------------------RETIRO DE FONDOS------------------------------------------------------//
				
			if(objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_NO_AFILIADO)){
								
				if (objTransferenciaCuentaPaypal.verificarPopUpNoAfiliados()){	
					String strResultado=objTransferenciaCuentaPaypal.verificarCamposPopUpNoAfiliado();
					if (strResultado.equals("")){
						objFuncionesGenerales.callPasosAcierto(7, "de todas las validdaciones." , "" ,  "");
						strTipoLog="1";
					}else{
						strTipoLog="0";		
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, strResultado , "" ,  "");
					}
					lngHoraFinEjecucion = System.currentTimeMillis();	  
					lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
				   	objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_NO_AFILIADO)){	
					lngHoraInicioEjecucion = System.currentTimeMillis();	  
					if (objTransferenciaCuentaPaypal.clicBotonAceptarNoAfiliados()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el boton 'ACEPTAR'");
						strTipoLog="1";
						objTransferenciaCuentaPaypal.verificarAfiliaCamposObligatorios();
					}else{
						strTipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"el boton 'ACETAR'");
					}
					lngHoraFinEjecucion = System.currentTimeMillis();	  
	    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
				   	CapturarPantalla.scrollCapturaPantalla();
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
				}
			}else{
					objTransferenciaCuentaPaypal.verificarRetiroFondos();
					
					if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){		
						lngHoraInicioEjecucion = System.currentTimeMillis();	 
						if (objTransferenciaCuentaPaypal.seleccionarEmpresaRetiro(GstrCMB_EMPRESA)){	
							objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA, "+GstrCMB_EMPRESA , "" ,  "");
							strTipoLog="1";
							objTransferenciaCuentaPaypal.verificarRetiroFondos();//objTransferenciaCuentaPaypal.verificarValorCuentaPaypal();
						}else{
							strTipoLog="0";		
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA, "+GstrCMB_EMPRESA , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
						lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					if (GstrTXT_COLUMNA_ERROR.equals("TXT_EMPRESA_NO_AFILIADA")){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	
						String strResultado=objTransferenciaCuentaPaypal.verificarMensajeError(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR,"");
						if (strResultado==""){
							objFuncionesGenerales.callPasosAcierto(5, GstrTXT_MENSAJE_ERROR, " El mensaje esperado." ,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(5, GstrTXT_MENSAJE_ERROR, strResultado ,"");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.scrollCapturaPantalla();
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_RETIRAR)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	  	
						if (objTransferenciaCuentaPaypal.ingresarMontoRetiro(GstrTXT_MONTO_RETIRAR)){	
							objFuncionesGenerales.callPasosAcierto(3, "Ingresar el MONTO a retirar "+GstrTXT_MONTO_RETIRAR , "" ,  "");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "Ingresar el MONTO a retirar "+GstrTXT_MONTO_RETIRAR , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					if(GstrBTN_ACEPTAR_MENSAJE.equals("<IGNORE>") &&!GstrTXT_COLUMNA_ERROR.equals("TXT_EMPRESA")   &&!GstrTXT_COLUMNA_ERROR.equals("TXT_EMPRESA_NO_AFILIADA")){
						if (objTransferenciaCuentaPaypal.verificarRetiroFondos()){	
							String strResultado=objTransferenciaCuentaPaypal.verificarCamposRetiros();
							if (strResultado.equals("")){
								objFuncionesGenerales.callPasosAcierto(7, "de todas las validdaciones." , "" ,  "");
								strTipoLog="1";
								strCuenta=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/span[2]");
								
								if(GstrCMB_EMPRESA.equals("<IGNORE>")){
									strEmpresa=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/span[2]");
									
								}else{
									strEmpresa=GstrCMB_EMPRESA;
								}
							}else{
								strTipoLog="0";		
								bandera = false;
								objFuncionesGenerales.callPasosErrado(7, strResultado , "" ,  "");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
							lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_RETIRAR_FONDOS)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	  
						if (objTransferenciaCuentaPaypal.clicBotonRetirarFondos()){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el boton 'RETIRAR FONDOS'");
							strTipoLog="1";
							if(GstrTXT_COLUMNA_ERROR.equals("TXT_MONTOS")||GstrTXT_COLUMNA_ERROR.equals("TXT_EMPRESA")){
								objTransferenciaCuentaPaypal.verificarRetiroFondos();
							}else{
								objTransferenciaCuentaPaypal.verificarConfirmacionRetiro();
							}
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"el boton 'RETIRAR FONDOS'");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.scrollCapturaPantalla();
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					if (GstrTXT_COLUMNA_ERROR.equals("TXT_MONTOS")||GstrTXT_COLUMNA_ERROR.equals("TXT_EMPRESA")){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	
						String strResultado=objTransferenciaCuentaPaypal.verificarMensajeError(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR,"");
						if (strResultado==""){
							objFuncionesGenerales.callPasosAcierto(5, GstrTXT_MENSAJE_ERROR, " El mensaje esperado." ,"");
							strTipoLog="1";
							
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(5, GstrTXT_MENSAJE_ERROR, strResultado ,"");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					//-------------------------------
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MINIMO)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	  	
						if (objTransferenciaCuentaPaypal.ingresarMontoRetiro(GstrTXT_MONTO_MINIMO)){	
							objFuncionesGenerales.callPasosAcierto(3, "Ingresar el MONTO minimo permitido "+GstrTXT_MONTO_MINIMO , "" ,  "");
							strTipoLog="1"; 
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "Ingresar el MONTO minimo permitido "+GstrTXT_MONTO_MINIMO , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					
						if (objFuncionesGenerales.verificarIgnore(GstrBTN_RETIRAR_FONDOS)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							if (objTransferenciaCuentaPaypal.clicBotonRetirarFondos()){
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el boton 'RETIRAR FONDOS'");
								strTipoLog="1";
								objTransferenciaCuentaPaypal.verificarRetiroFondos();
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"el boton 'RETIRAR FONDOS'");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
						
						if (GstrTXT_COLUMNA_ERROR.equals("TXT_MONTOS")){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	
							String strResultado=objTransferenciaCuentaPaypal.verificarMensajeError(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR,"");
							if (strResultado==""){
								objFuncionesGenerales.callPasosAcierto(5, GstrTXT_MENSAJE_ERROR, " El mensaje esperado." ,"");
								strTipoLog="1";
								
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(5, GstrTXT_MENSAJE_ERROR, strResultado ,"");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
					}
					
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	  	
						if (objTransferenciaCuentaPaypal.ingresarMontoRetiro(GstrTXT_MONTO_MAXIMO)){	
							objFuncionesGenerales.callPasosAcierto(3, "Ingresar el MONTO máximo permitido "+GstrTXT_MONTO_MAXIMO , "" ,  "");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "Ingresar el MONTO máximo permitido "+GstrTXT_MONTO_MAXIMO , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					
	
						if (objFuncionesGenerales.verificarIgnore(GstrBTN_RETIRAR_FONDOS)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							if (objTransferenciaCuentaPaypal.clicBotonRetirarFondos()){
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el boton 'RETIRAR FONDOS'");
								strTipoLog="1";
								objTransferenciaCuentaPaypal.verificarRetiroFondos();
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"el boton 'RETIRAR FONDOS'");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
						
						if (GstrTXT_COLUMNA_ERROR.equals("TXT_MONTOS")){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	
							String strResultado=objTransferenciaCuentaPaypal.verificarMensajeError(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR,"");
							if (strResultado==""){
								objFuncionesGenerales.callPasosAcierto(5, GstrTXT_MENSAJE_ERROR, " El mensaje esperado." ,"");
								strTipoLog="1";
								
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(5, GstrTXT_MENSAJE_ERROR, strResultado ,"");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
					}
					
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_SUPERA_LIMITE)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	  	
						if (objTransferenciaCuentaPaypal.ingresarMontoRetiro(GstrTXT_MONTO_SUPERA_LIMITE)){	
							objFuncionesGenerales.callPasosAcierto(3, "Ingresar el MONTO que supera saldo cuenta PayPal "+GstrTXT_MONTO_SUPERA_LIMITE , "" ,  "");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "Ingresar el MONTO que supera saldo cuenta PayPal "+GstrTXT_MONTO_SUPERA_LIMITE , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					
	
						if (objFuncionesGenerales.verificarIgnore(GstrBTN_RETIRAR_FONDOS)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							if (objTransferenciaCuentaPaypal.clicBotonRetirarFondos()){
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el boton 'RETIRAR FONDOS'");
								strTipoLog="1";
								objTransferenciaCuentaPaypal.verificarRetiroFondos();
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"el boton 'RETIRAR FONDOS'");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
						
						if (GstrTXT_COLUMNA_ERROR.equals("TXT_MONTOS")){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	
							String strResultado=objTransferenciaCuentaPaypal.verificarMensajeError(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR,"Monto_Supera_Limite");
							if (strResultado==""){
								objFuncionesGenerales.callPasosAcierto(5, GstrTXT_MENSAJE_ERROR, " El mensaje esperado." ,"");
								strTipoLog="1";
								
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(5, GstrTXT_MENSAJE_ERROR, strResultado ,"");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	  
			    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
					}
					
					//------------------------------
					if( GstrTXT_CLAVE.equals("SI")){
						if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
							lngHoraInicioEjecucion = System.currentTimeMillis();	  
							
							if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
								objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA ", Mdl_Variables.Gstr_Clave,"");
								strTipoLog="1";
							}else{
								strTipoLog="0";									
								bandera = false;
								objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA ", Mdl_Variables.Gstr_Clave,"");
							}
							lngHoraFinEjecucion = System.currentTimeMillis();	 	  
							lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
						}
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	
						
						if (objTransferenciaCuentaPaypal.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
							objFuncionesGenerales.callPasosAcierto(3, "La CLAVE DINAMICA", GstrTXT_CLAVE_DINAMICA,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "La CLAVE DINAMICA", GstrTXT_CLAVE_DINAMICA,"");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		    			CapturarPantalla.scrollCapturaPantalla();
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}	
							
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_RETIRAR_FONDOS)&&objTransferenciaCuentaPaypal.verificarConfirmacionRetiro()){//Validar campos de Confirmacion
						String strResultado=objTransferenciaCuentaPaypal.verificarCamposConfirmacion(strCuenta,strEmpresa,GstrTXT_MONTO_RETIRAR);
						if (strResultado.equals("")){
							objFuncionesGenerales.callPasosAcierto(7, "" , "" ,  "");
							strTipoLog="1";
						}else{
							strTipoLog="0";		
							bandera = false;
							objFuncionesGenerales.callPasosErrado(7, strResultado , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
						lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR_RETIRO)){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	  
						if (objTransferenciaCuentaPaypal.clicBotonConfirmarRetiro()){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el boton 'CONFIRMAR'");
							strTipoLog="1";
							if(GstrTXT_COLUMNA_ERROR.equals("TXT_MONTO_RETIRAR")){
								objTransferenciaCuentaPaypal.verificarConfirmacionRetiro();
							}else{
								objTransferenciaCuentaPaypal.verificarResultadoFinalRetiro();
								strNumeroCuenta=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[4]");
							}
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"el boton 'CONFIRMAR'");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
					
					if (GstrTXT_COLUMNA_ERROR.equals("TXT_MONTO_RETIRAR")){	
						lngHoraInicioEjecucion = System.currentTimeMillis();	
						String strResultado=objTransferenciaCuentaPaypal.verificarMensajeErrorMontoCuentaRestringida(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR);
						if (strResultado==""){
							objFuncionesGenerales.callPasosAcierto(5, GstrTXT_MENSAJE_ERROR, " El mensaje esperado." ,"");
							strTipoLog="1";
							
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(5, GstrTXT_MENSAJE_ERROR, strResultado ,"");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
		    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
							
					if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
						String strResultado=objTransferenciaCuentaPaypal.verificarCamposResultadoEsperado(strCuenta,strEmpresa,GstrTXT_MONTO_RETIRAR,strNumeroCuenta,GstrRESULTADO_ESPERADO);
						if (strResultado.equals("")){
							objFuncionesGenerales.callPasosAcierto(7, "" , "" ,  "");
							strTipoLog="1";
						}else{
							strTipoLog="0";		
							bandera = false;
							objFuncionesGenerales.callPasosErrado(7, strResultado , "" ,  "");
						}
						lngHoraFinEjecucion = System.currentTimeMillis();	  
						lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
					}
				}
			
			}

		    
		    if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
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
	
	public void pasos(){
		try {
			if (objTransferenciaCuentaPaypal.verificarPaginaPrincipalPaypal()){	
				lngHoraInicioEjecucion = System.currentTimeMillis();
				String strValidarPaginaDos=objTransferenciaCuentaPaypal.verificarPantallaPrincipal(GstrBTN_ACEPTAR_MENSAJE);
				if (strValidarPaginaDos.equals("")){
					objFuncionesGenerales.callPasosAcierto(8, strValidarPaginaDos, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(8, strValidarPaginaDos, "" ,"");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
				lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_AFILIAR_CUENTA)){	
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.clicBotonAfiliarCuentaPaypal()){
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el boton AFILIAR UNA CUENTA A PAYPAL");
				strTipoLog="1";
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR)){
					objTransferenciaCuentaPaypal.verificarPopUp();
				}else if( objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTARAFILIACION)) {
					objTransferenciaCuentaPaypal.verificarPopUpAfiliado();
				}else{
					objTransferenciaCuentaPaypal.verificarPopUpMensajeAdministrador();
				}
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el boton AFILIAR UNA CUENTA A PAYPAL");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		
		//-----------------------
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTARAFILIACION)&& objTransferenciaCuentaPaypal.verificarPopUpAfiliado()){	
			lngHoraInicioEjecucion = System.currentTimeMillis();
			String strValidarPaginaDos=objTransferenciaCuentaPaypal.verificarMensajePopUpAfiliado();
			if (strValidarPaginaDos.equals("")){
				objFuncionesGenerales.callPasosAcierto(8, strValidarPaginaDos, "" ,"");
				strTipoLog="1";
				;
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(8, strValidarPaginaDos, "" ,"");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTARAFILIACION)){	
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.clicBotonAceptarAfiliacion()){
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el boton ACEPTAR");
				strTipoLog="1";
				objTransferenciaCuentaPaypal.verificarPaginaPrincipalPaypal();
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el boton ACEPTAR");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.scrollCapturaPantalla();
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		

		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR)){	//aumentarrrrrr
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.clicBotonAceptar()){
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el boton ACEPTAR");
				strTipoLog="1";
				objTransferenciaCuentaPaypal.verificarAfiliaCamposObligatorios();
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el boton ACEPTAR");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.scrollCapturaPantalla();
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR)&& objTransferenciaCuentaPaypal.verificarAfiliaCamposObligatorios()){	
			lngHoraInicioEjecucion = System.currentTimeMillis();
			String strValidarPaginaDos=objTransferenciaCuentaPaypal.ValidarPaginaDos(GstrCMB_EMPRESA);
			if (strValidarPaginaDos.equals("")){
				objFuncionesGenerales.callPasosAcierto(8, strValidarPaginaDos, "" ,"");
				strTipoLog="1";
				
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(8, strValidarPaginaDos, "" ,"");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_USUARIO_PAYPAL)){	
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.ingresarUsuarioPaypal(GstrTXT_USUARIO_PAYPAL)){
				objFuncionesGenerales.callPasosAcierto(3, "El Usuario Paypal : " + GstrTXT_USUARIO_PAYPAL, "" ,"");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El Usuario Paypal : " + GstrTXT_USUARIO_PAYPAL, "" ,"");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){		
			lngHoraInicioEjecucion = System.currentTimeMillis();	 
			if (objTransferenciaCuentaPaypal.seleccionarEmpresa(GstrCMB_EMPRESA)){	
				objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA, "+GstrCMB_EMPRESA , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";		
				bandera = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA, "+GstrCMB_EMPRESA , "" ,  "");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA)){		
			lngHoraInicioEjecucion = System.currentTimeMillis();	 
			if (objTransferenciaCuentaPaypal.seleccionarCuentaPorAfiliar(GstrCMB_CUENTA)){	
				objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA POR AFILIAR, "+GstrCMB_CUENTA , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";		
				bandera = false;
				objFuncionesGenerales.callPasosErrado(2, "de la CUENTA POR AFILIAR, "+GstrCMB_CUENTA , "" ,  "");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_AFILIAR)){	
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.clicBotonAfiliar()){
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el BOTON AFILIAR");
				strTipoLog="1";
				objTransferenciaCuentaPaypal.verificarConfirmacionAfiliacion();
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el BOTON AFILIAR");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_AFILIAR)&& objTransferenciaCuentaPaypal.verificarConfirmacionAfiliacion()){	
			lngHoraInicioEjecucion = System.currentTimeMillis();
			String strValidarPaginaDos=objTransferenciaCuentaPaypal.verificarCamposConfirmacionAfilicion(GstrTXT_USUARIO_PAYPAL,GstrCMB_EMPRESA,GstrCMB_CUENTA);
			if (strValidarPaginaDos.equals("")){
				objFuncionesGenerales.callPasosAcierto(8, strValidarPaginaDos, "" ,"");
				strTipoLog="1";
				
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(8, strValidarPaginaDos, "" ,"");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCHK_TERMINOS_CONDICIONES)){	
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.clicCheckTerminosCondiciones()){
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el CHECK Acepto Términos y Condiciones");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el CHECK Acepto Términos y Condiciones");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
			lngHoraInicioEjecucion = System.currentTimeMillis();	  
			if (objTransferenciaCuentaPaypal.clicConfirmar()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton CONFIRMAR");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				bandera = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton CONFIRMAR");
			}
			lngHoraFinEjecucion = System.currentTimeMillis();	  
			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
		}
	
	}catch (Exception e) {
		objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
    	bandera = false;
	}
	
	}
	
	public void pasosTeclado(){
		try {
			Thread.sleep(15000);
			Robot robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB); 
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_UP);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			Thread.sleep(1500);
			robot.keyPress(java.awt.event.KeyEvent.VK_F5);
			Thread.sleep(1500);
		} catch (InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}