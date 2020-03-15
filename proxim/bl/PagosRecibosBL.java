	package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.PagosRecibosBE;
import proxim.be.PagosRecibosDetalleBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosRecibosBL extends PagosRecibosBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosRecibosMapeo objPagoRecibosBE = new PagosRecibosMapeo();
	PagosRecibosDetalleBE objDetallePagoBL=new PagosRecibosDetalleBE();
	PagosRecibosDetalleBL objDetallePagoRegistroBL=new PagosRecibosDetalleBL();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
 
	public boolean pagoRecibos() throws SQLException, IOException{
		boolean blnResultadoEsperado = true;
		String strTipoLog = null;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio;	
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		String strTextoImagen="1. Imagenes";
		
		try {
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, GstrTXT_MENU, GstrTXT_SUBMENU);
			//---------------------------------------------------------------------------------------------------------------------------
			
			objPagoRecibosBE.verificarPagoResivos();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarEmpresa(GstrCMB_EMPRESA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if(objPagoRecibosBE.verificarPagoRecurrente()){//En caso de que encuentre la alerta de Pagos Recurrentes
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
				}else{									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO)){		
				strHoraInicio = System.currentTimeMillis();
				objPagoRecibosBE.verificarPagoResivos();
				if (objPagoRecibosBE.seleccionarCuenta(GstrCMB_CUENTA_CARGO)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_SOLICITUD)){	
				strHoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarNombreSolicitud(GstrTXT_NOMBRE_SOLICITUD)){	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DE LA SOLICITUD "+GstrTXT_NOMBRE_SOLICITUD , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DE LA SOLICITUD "+GstrTXT_NOMBRE_SOLICITUD , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
					
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_PAGO)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarTipoPago(GstrCMB_TIPO_PAGO)){	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE PAGO "+GstrCMB_TIPO_PAGO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE PAGO "+GstrCMB_TIPO_PAGO , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if(objPagoRecibosBE.verificarPagoRecurrente()){//En caso de que encuentre la alerta de Pagos Recurrentes
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
				}else{									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR)&&GstrTXT_COLUMNA_ERROR.equals("TXT_CONSULTA")){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.compararError(GstrTXT_MENSAJE_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE PAGO "+GstrCMB_TIPO_PAGO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE PAGO "+GstrCMB_TIPO_PAGO , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
				
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.clickCheckTodos()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el CHECK TODOS");
				}else{									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el CHECK TODOS");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}

			//----------------------------------------------AGREGA DETALLES--------------------------------------------------
			objSQL.listaTablaIdCaso("select ID_CASOPAGO,CHK_TODOS,IMG_EDITAR,IMG_ELIMINAR,IMG_GUARDAR,IMG_DESHACER,IMG_BUSCAR,TXT_EMPRESA_BUSCAR,LST_EMPRESA,BTN_ACEPTAR,CMB_SERVICIO,TXT_CODIGO_DEUDOR,BTN_NUEVO_REGISTRO,TXT_MENSAJE_ERROR,TXT_COLUMNA_ERROR from APP_PAGOS_RECIBOS_DETALLE_D where ID_CASOPAGO="+Mdl_Variables.Gint_IdCaso+" group by ID_CASOPAGO,CHK_TODOS,IMG_EDITAR,IMG_ELIMINAR,IMG_GUARDAR,IMG_DESHACER,IMG_BUSCAR,TXT_EMPRESA_BUSCAR,LST_EMPRESA,BTN_ACEPTAR,CMB_SERVICIO,TXT_CODIGO_DEUDOR,BTN_NUEVO_REGISTRO,TXT_MENSAJE_ERROR,TXT_COLUMNA_ERROR ORDER BY BTN_NUEVO_REGISTRO DESC","",5);//Captura todos los valores del detalle del caso
			
			int numeroDetalle=0;
			while (Mdl_Variables.Grst_NuevaTabla.next()) {
				numeroDetalle=numeroDetalle+1;
				blnResultadoEsperado = objDetallePagoBL.PagRecibosDetalle( Mdl_Variables.Grst_NuevaTabla,1);
    			if(blnResultadoEsperado){
					if(GstrCMB_TIPO_PAGO.equals("Pagos recurrentes")){
						blnResultadoEsperado = objDetallePagoRegistroBL.pagosRecibosDetalle(2,numeroDetalle,0);
					}else{
						blnResultadoEsperado = objDetallePagoRegistroBL.pagosRecibosDetalle(1,numeroDetalle,0);
					}
    			}
			}

			//-----------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR)){
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
					objPagoRecibosBE.verificarDetallePagosRecibos();
				}else{									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS1)){	
				strHoraInicio = System.currentTimeMillis();	
				if (objPagoRecibosBE.clickCheckTodos2()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el CHECK TODOS");
				}
				else{									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el CHECK TODOS");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			//------------Ingresar montos
			int  totalColumnas=0 ;
			if(blnResultadoEsperado){
			objSQL.listaTablaIdCaso("APP_PAGOS_RECIBOS_DETALLE_D","where ID_CASOPAGO="+Mdl_Variables.Gint_IdCaso,3);//Captura todos los valores del detalle del caso
			 numeroDetalle=0;

			 while (Mdl_Variables.Grst_NuevaTabla.next()) {
				 totalColumnas=totalColumnas+1;
				}
			 objSQL.listaTablaIdCaso("APP_PAGOS_RECIBOS_DETALLE_D","where ID_CASOPAGO="+Mdl_Variables.Gint_IdCaso+ "ORDER BY BTN_NUEVO_REGISTRO DESC",3);//Captura todos los valores del detalle del caso
				
			while (Mdl_Variables.Grst_NuevaTabla.next()) {
				
				numeroDetalle=numeroDetalle+1;
				blnResultadoEsperado = objDetallePagoBL.PagRecibosDetalle( Mdl_Variables.Grst_NuevaTabla,2);
				if(blnResultadoEsperado){
					blnResultadoEsperado = objDetallePagoRegistroBL.pagosRecibosDetalle(3,numeroDetalle,totalColumnas);
				}
			}
		}

			//------------------------------------------

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
				}else{									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if( objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)&&GstrTXT_CLAVE.equals("SI")){
				strHoraInicio = System.currentTimeMillis();	  
				objPagoRecibosBE.verificarContrasenaPagosRecibos();
				if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
				}
				strHoraFin = System.currentTimeMillis();	 	  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = System.currentTimeMillis();	
				objPagoRecibosBE.verificarContrasenaPagosRecibos();
				if (objPagoRecibosBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica", GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica", GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonConfirmar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
				strHoraInicio = System.currentTimeMillis();	 
				objPagoRecibosBE.verificarResultadoEsperado();
				if (objPagoRecibosBE.ingresoBotonCancelarOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
				strHoraInicio = System.currentTimeMillis();
				objPagoRecibosBE.verificarResultadoEsperado();
				if (objPagoRecibosBE.compararResultadoEsperado(GstrRESULTADO_ESPERADO)){	
					objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado", "Resultado Obtenido" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado", "Resultado Obtenido" ,"");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
    			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
    		}
						
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkEnviarEmailResultadoEsperadoEnvio()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 	
				if (objPagoRecibosBE.ingresarCorreoAutorizar( GstrTXT_CORREO_RESULTADO_FINAL)){	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_RESULTADO_FINAL , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_RESULTADO_FINAL , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 	
				if (objPagoRecibosBE.ingresarMensajeCorreoAutorizar( GstrTXT_MENSAJE_CORREO_RESULTADO_FINAL)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_RESULTADO_FINAL , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_RESULTADO_FINAL , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoBotonEnviarAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_RESULTADO_FINAL )){	
				strHoraInicio = System.currentTimeMillis(); 
				objPagoRecibosBE.verificarMensajeCorreoAutorizar();
				if (objPagoRecibosBE.ingresoBotonAceptarCorreoAutorizar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkExportarExcelResultadoEsperadoEnvio()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkExportarPDFResultadoEsperadoEnvio()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_RESULTADO_FINAL)){	
				strHoraInicio = System.currentTimeMillis(); 
				if (objPagoRecibosBE.ingresoLinkImprimirResultadoEsperadoEnvio()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
					
			if(blnResultadoEsperado){
				objPagoRecibosBE.guardarDatosOperacionAutorizar();
				if(GstrFIRMAR.equals("NO") && GstrESTADO.equals("Procesada")){
					blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico("Pago de Recibos",GstrCMB_EMPRESA,PagosRecibosBE.GstrCMB_CUENTA_CARGO,1,PagosRecibosBE.GstrESTADO,PagosRecibosBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS,PagosRecibosBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
				}
			}
						
			//------------------------------------------------------REALIZA EL PAGO------------------------------------------------------
			if(blnResultadoEsperado && GstrFIRMAR.equals("SI")){
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
				
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))
				{
					if (GstrFIRMANTE1.equals("PA") || GstrFIRMANTE1.equals("PA-B") ){
						blnResultadoEsperado=objFirmarBL.firmaRecibos("APP_PAGOS_RECIBOS_AUTORIZAR_D",Gstr_ID_CASO,"F1",consultar1);
					}else if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
						blnResultadoEsperado=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Pago de Recibos",consultar1,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_CARGO,null);
					}else{
						blnResultadoEsperado=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F1",GstrTXT_SUBMENU1,consultar1);
					}
				}
				
				if(blnResultadoEsperado){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2))
					{
						if (GstrFIRMANTE2.equals("PA") || GstrFIRMANTE2.equals("PA-B") ){
							blnResultadoEsperado=objFirmarBL.firmaRecibos("APP_PAGOS_RECIBOS_AUTORIZAR_D",Gstr_ID_CASO,"F2",consultar2);
						}else if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
							blnResultadoEsperado=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Pago de Recibos",consultar2,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_CARGO,null);
						}else{
							blnResultadoEsperado=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F2",GstrTXT_SUBMENU1,consultar2);
						}
					}
					
					if(blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3))
						{
							if (GstrFIRMANTE3.equals("PA") || GstrFIRMANTE3.equals("PA-B") ){
								blnResultadoEsperado=objFirmarBL.firmaRecibos("APP_PAGOS_RECIBOS_AUTORIZAR_D",Gstr_ID_CASO,"F3",consultar3);
							}else if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
								blnResultadoEsperado=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Pago de Recibos",consultar3,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_CARGO,null);
							}else{
								blnResultadoEsperado=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F3",GstrTXT_SUBMENU1,consultar3);
							}
						}
						
						if(blnResultadoEsperado && objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
							blnResultadoEsperado=objFirmarBL.firmaRecibos("APP_PAGOS_RECIBOS_AUTORIZAR_D",Gstr_ID_CASO,"OP",true);
						}
					}
				}
			}
		}catch (Exception e) {
			blnResultadoEsperado = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado;
	}
}
	