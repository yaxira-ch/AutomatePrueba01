package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaEntreCuentasBL extends TransferenciaBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	TransferenciaMapeo objTransferenciaMapeo = new TransferenciaMapeo();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FirmarBL objFirmarBL =new FirmarBL();
	HeaderBL objHeader = new HeaderBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	SteptsEveris objSteptsEveris= new SteptsEveris();
	
	public boolean transferenciaEntreCuentas() throws SQLException, IOException{
		String strTipoLog = null;
		boolean blnResultadoEsperado = true;
		String strHoraFin;
		long lngTiempoEjeCaso;
		String strHoraInicio ;	 
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		String strTextoImagen="1. Imagenes";
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		Mdl_Variables.GstrSIS_GRUPOEJECUCION = Gstr_ID_CASO + "-"+ new SimpleDateFormat("yyyyMMddHHmm").format(Calendar.getInstance().getTime());
		String strCktTipoCambio="//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/span/span";
		String strTxtTipoCambioEspecial = "//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/span/div/input";
		String strLinkEnviarCorreo="//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[1]/a";
		String strTxtTituloCorreo="//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input";
		String strTxtContenidoCorreo="//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea";
		String strBtnEnviarCorreo="//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a";
		String strBtnAceptarEnvioCorreo="//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a";
		String strLnkExportarExcel="//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[4]/a";
		String strLnkExportarPdf="//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[5]/a";
		String strLnkImprimir="//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[6]/a";
		String strLnkOperacionfrecuente="//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[5]/a";
		String strBtnContinuarOperacionfrecuente="//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div[2]/a";
		try {
			
			//---------------------------------------MENU---------------------------------------
			//objHeader.menuPrincipal( GstrLNK_TIPO_CAMBIO_ESPECIAL,GstrTXT_MENU, Mdl_Variables.Gstr_Ignore);
			String txtMenu="/html/body/div[2]/div[2]/div/ul/li[5]/a";
			String txtSubMenu="<IGNORE>";
			String txtTabMenu ="AMisCuentas";
			FuncionesGenerales.MenuGeneralNew(txtMenu,"<IGNORE>");
			Thread.sleep(2000);
			objObjetosGenerales.clickBoton(ObjetosGenerales.id, txtTabMenu);
			Thread.sleep(1000);
			
			
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
				
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaMapeo.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINKSUB MENU, "+GstrTXT_SUBMENU1);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el SUB MENU, "+GstrTXT_SUBMENU1);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			objTransferenciaMapeo.verificarVentanaEntreCuentas();
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIO_TRANSFERENCIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaMapeo.seleccionarLinkTransferencia(GstrLNK_ENVIO_TRANSFERENCIA)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la PESTAÑA, "+GstrLNK_ENVIO_TRANSFERENCIA);
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la PESTAÑA, "+GstrLNK_ENVIO_TRANSFERENCIA);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//------------------------------------------------------------------------------			
			
			objSteptsEveris.selecionarObjetoValor("name", "empresaOrigenCombo", "EMPRESA CUENTA DE ORIGEN - ", GstrCMB_EMPRESA_CUENTA_ORIGEN);
			objSteptsEveris.selecionarObjetoValor("name", "productoOrigenCombo", "CUENTA DE ORIGEN - ", GstrCMB_CUENTA_ORIGEN);		
			objSteptsEveris.selecionarObjetoValor("name", "empresaDestinoCombo", "EMPRESA CUENTA DESTINO - ", GstrCMB_EMPRESA_CUENTA_DESTINO);
			objSteptsEveris.selecionarObjetoValor("name", "productoDestinoCombo", "CUENTA DESTINO - ", GstrCMB_CUENTA_DESTINO);
			objSteptsEveris.ingresarValorObjeto("cssSelector", "input.tamanioTextoMonto", "MONTO - ", GstrTXT_MONTO);
			objSteptsEveris.selecionarObjetoValor("name", "monedaCombo", "MONEDA - ", GstrCMB_MONEDA);
			objSteptsEveris.clicValorObjeto("xpath", strCktTipoCambio, "En la opción para utilizar tipo de cambio especial.", GstrCHK_TIPO_CAMBIO_ESPECIAL);
			objSteptsEveris.ingresarValorObjeto("xpath", strTxtTipoCambioEspecial, "NUMERO DE TICKET DEL TIPO DE CAMBIO ESPECIAL - ", GstrTXT_TIPO_CAMBIO_ESPECIAL);
			objSteptsEveris.ingresarValorObjeto("cssSelector", "input.anchoCajaTexto", "DESCRIPCIÓN - ", GstrTXT_DESCRIPCION_TRANSFERENCIA);
			CapturarPantalla.pageDown("600");
			objSteptsEveris.clicValorObjeto("name", "continuar", "el Botón CONTINUAR", GstrBTN_CONTINUAR);
	
			if (GstrTXT_CLAVE.toLowerCase().equalsIgnoreCase("SI")){
				objTransferenciaMapeo.verificarTecladoEntreCuentas1();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA, ", Mdl_Variables.Gstr_Clave,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA, ", Mdl_Variables.Gstr_Clave,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_CONFIRMAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaMapeo.ingresoBotonConfirmar1()){	
					objTransferenciaMapeo.guardarIdTabla();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					objTransferenciaMapeo.verificarResultadoFinal();
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
			
			objSteptsEveris.clicValorObjeto("cssSelector","a.botonCancelarOperacion","en el Botón CANCELAR OPERACIÓN", GstrBTN_CANCELAR_OPERACION);
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrRESULTADO_ESPERADO))	{	
				objTransferenciaMapeo.verificarImagenTransfEnviada();
				objTransferenciaMapeo.guardarIdTabla();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
				String strResultadoObtenido = objTransferenciaMapeo.obtenerResultado();
				if (strResultadoObtenido.equals(TransferenciaBE.GstrRESULTADO_ESPERADO))	{	
					objFuncionesGenerales.callPasosAcierto(5, TransferenciaBE.GstrRESULTADO_ESPERADO, strResultadoObtenido,"");
					String montoOperacion;
					
					montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/span[2]" );
					int totalCadena=montoOperacion.length();
					Mdl_Variables.Gstr_strNewMonto=montoOperacion;
					if(montoOperacion.contains("/")){
						Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
					}else{
						Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
					}
					
					GstrTOTAL_PAGAR=montoOperacion;
					strTipoLog="1";
				
					//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
					objSteptsEveris.clicValorObjeto("xpath", strLinkEnviarCorreo, "En el lINK enviar correo.", GstrLNK_ENVIAR_CORREO);
					objSteptsEveris.ingresarValorObjeto("xpath", strTxtTituloCorreo, "Titulo del Correo: " + GstrTXT_CORREO_POPUP, GstrTXT_CORREO_POPUP);
					objSteptsEveris.ingresarValorObjeto("xpath", strTxtContenidoCorreo, "Mensaje del Correo: " + GstrTXT_MENSAJE_POPUP, GstrTXT_MENSAJE_POPUP);
					objSteptsEveris.clicValorObjeto("xpath", strBtnEnviarCorreo, "En el BOTON ENVIAR CORREO", GstrBTN_ENVIAR_CORREO_POPUP);
					Thread.sleep(1000);
					objSteptsEveris.clicValorObjeto("xpath", strBtnAceptarEnvioCorreo, "En el BOTON ACEPTAR ENVÍO CORREO", GstrBTN_ENVIAR_CORREO_POPUP);
					Thread.sleep(1000);
					objSteptsEveris.clicValorObjeto("xpath", strLnkExportarExcel, "En el LINK EXPORTAR EXCEL", GstrLNK_EXPORTAR_EXCEL);
					Thread.sleep(1000);
					objSteptsEveris.clicValorObjeto("xpath", strLnkExportarPdf, "En el LINK EXPORTAR PDF", GstrLNK_EXPORTAR_PDF);
					Thread.sleep(1000);
					objSteptsEveris.clicValorObjeto("xpath", strLnkImprimir, "En el LINK IMPRIMIR", GstrLNK_IMPRIMIR);

					
					//---------------------------------------------------------
					
					objTransferenciaMapeo.guardarDatosOperacionAutorizar();
					
					//if (GstrFIRMAR.equals("NO") && !GstrESTADO.equals(Mdl_Variables.Gstr_Ignore)){
						//blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico("Transferencias",GstrCMB_EMPRESA_CUENTA_ORIGEN,GstrCMB_CUENTA_ORIGEN,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,TransferenciaBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					//}
				}
 			}
			
			objSteptsEveris.clicValorObjeto("xpath", strLnkOperacionfrecuente, "en Link Agregar a mis operaciones frecuentes", GstrLNK_OPERACION_FRECUENTE);
			objSteptsEveris.ingresarValorObjeto("cssSelector", "input.inputCuentaDestino", "La DESCRIPCION "+GstrTXT_DESCRIPCION_OPERACION_FRECUENTE, GstrTXT_DESCRIPCION_OPERACION_FRECUENTE);
			objSteptsEveris.clicValorObjeto("xpath", strBtnContinuarOperacionfrecuente, "en el Botón CONTINUAR de la operacion Frecuente", GstrBTN_CONTINUAR_OPERACION_FRECUENTE);
			//------------------------------------------------------REALIZA FIRMA------------------------------------------------------
				
			if (blnResultadoEsperado && GstrFIRMAR.equals("SI")){
					
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				}
				
				if(GstrOPERADOR.equals(Mdl_Variables.Gstr_Ignore)){
					if (!GstrFIRMANTE3.equals(Mdl_Variables.Gstr_Ignore)){
						consultar3=true;
					}else if (!GstrFIRMANTE2.equals(Mdl_Variables.Gstr_Ignore)){
						consultar2=true;
					}else{
						if (!GstrFIRMANTE1.equals(Mdl_Variables.Gstr_Ignore)){
							consultar1=true;
						}
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1)){
					blnResultadoEsperado=objFirmarBL.firmarOperacion(GstrFIRMANTE1,Gstr_ID_CASO,"F1",consultar1,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO,GstrLNK_ENVIO_TRANSFERENCIA);
				}
				
				if (blnResultadoEsperado){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
						blnResultadoEsperado=objFirmarBL.firmarOperacion(GstrFIRMANTE2,Gstr_ID_CASO,"F2",consultar2,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO,GstrLNK_ENVIO_TRANSFERENCIA);
					}
					if (blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
							blnResultadoEsperado=objFirmarBL.firmarOperacion(GstrFIRMANTE3,Gstr_ID_CASO,"F3",consultar3,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO,GstrLNK_ENVIO_TRANSFERENCIA);
						}
						
						if(blnResultadoEsperado && objFuncionesGenerales.verificarIgnore(GstrOPERADOR)  ){
							blnResultadoEsperado=objFirmarBL.firmarOperacion(GstrOPERADOR,Gstr_ID_CASO,"OP",true,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO,GstrLNK_ENVIO_TRANSFERENCIA);
						}
					}
				}
			}	
			//------------------------------------------------------------------------------------------------------------
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
}
