package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaAutorizarBL  extends TransferenciaAutorizarBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	TransferenciaAutorizarMapeo objTransferenciaAutorizacionBE = new  TransferenciaAutorizarMapeo();
	TransferenciaMapeo objTransferenciaGeneralBE = new TransferenciaMapeo();
	ConexionBL objConexionBL= new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	MonitoreoTransaccionesBL objMonitoreoTransaccionesBL = new MonitoreoTransaccionesBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	int intNumeroRegistro;

	public boolean transferenciaAutorizarGeneral(int opcion,boolean consultar) throws SQLException, IOException{
		boolean blnResultadoEsperado = true;
		String strTextoImagen="1. Imagenes";
		String strTipoLog = null;
		String strHoraFin;
		long lngTiempoEjeCaso;
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		Calendar calendario = new GregorianCalendar();
		int hora, minutos;
		String LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
		
		try {
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU,"<IGNORE>");
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			//---------------------------------------------------------------------------------------------------------------------------				
			
			objTransferenciaAutorizacionBE.verificarCamposObligatorios();
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN))
			{		
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaAutorizacionBE.seleccionarEmpresaCuentaOrigen(GstrCMB_EMPRESA_CUENTA_ORIGEN))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DE ORIGEN "+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DE ORIGEN"+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_TRANSFERENCIA))
			{		
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaAutorizacionBE.seleccionarTipoTransfereniaCombo(GstrCMB_TIPO_TRANSFERENCIA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE TRANSFERENCIA "+GstrCMB_TIPO_TRANSFERENCIA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE TRANSFERENCIA "+GstrCMB_TIPO_TRANSFERENCIA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN))
			{		
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaAutorizacionBE.seleccionarCuentaOrigen(GstrCMB_CUENTA_ORIGEN))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE ORIGEN "+GstrCMB_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DE ORIGEN"+GstrCMB_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_DESTINO))
			{		
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaAutorizacionBE.seleccionarCuentaDestino(GstrCMB_CUENTA_DESTINO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DESTINO "+GstrCMB_CUENTA_DESTINO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DESTINO "+GstrCMB_CUENTA_DESTINO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_SOLICITUD_DESDE))
			{	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaAutorizacionBE.ingresarFechaSolicitudDesde(GstrTXT_FECHA_SOLICITUD_DESDE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE SOLICITUD DESDE "+GstrTXT_FECHA_SOLICITUD_DESDE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE SOLICITUD DESDE "+GstrTXT_FECHA_SOLICITUD_DESDE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_SOLICITUD_HASTA))
			{	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaAutorizacionBE.ingresarFechaSolicitudHasta(GstrTXT_FECHA_SOLICITUD_HASTA))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE SOLICITUD HASTA "+GstrTXT_FECHA_SOLICITUD_HASTA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE SOLICITUD HASTA "+GstrTXT_FECHA_SOLICITUD_HASTA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoBotonBuscar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    			
    			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			//---------------------------------------SELECCIONAR EL PUNTO A AUTORIZAR---------------------------------------
			if ( opcion==1){
//				FuncionesGenerales.casosEjecutar(GstrID_CASO_LOTE,2);//guarda EL ID de los casos a ejecutar en un array
//    			int valor=Mdl_Variables.Garr_CasoAfiliacion.length-1;
//				for (int i=0;i<=valor;i++){
//    				switch (GstrCMB_TIPO_TRANSFERENCIA) {
//	    				case "Entre cuentas":
//	    					tabla="APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D";
//	    					break;
//	    				case "A Terceros":
//	    					tabla="APP_AND_TRANSFERENCIAS_A_TERCEROS_D";
//	    					break;
//	    				case "A otros Bancos CCE":
//	    					tabla="APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D";
//	    					break;
//	    					
//	    				case "A otros Bancos BCR":
//	    					tabla="APP_AND_TRANSFERENCIAS_OTROS_BANCOS_BCR_D";
//	    					break;
//    				}
//    				objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO="+Mdl_Variables.Garr_CasoAfiliacion[i]+" ","",4);
//    				while(Mdl_Variables.Grst_Firmante.next()==true){
//    					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
//    					objTransferenciaGeneralBE.verificarTablaTransferencias();
//    					if (objTransferenciaAutorizacionBE.seleccionarCheckFirmar(Mdl_Variables.Grst_Firmante.getString("NUMERO_SOLICITUD"))){	
//    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Registro a AUTORIZAR");
//    						TipoLog="1";
//    					}else{
//    						TipoLog="0";									
//    						bandera = false;
//    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Registro a AUTORIZAR");
//    					}
//    					LStr_HoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
//    	    			Lng_TiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(LStr_HoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
//    				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
//    		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//    				
//    				}
//				}    			
			}else{
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_AUTORIZAR)){	
					objTransferenciaGeneralBE.verificarTablaTransferencias();
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
					intNumeroRegistro=objTransferenciaAutorizacionBE.buscarLoteFirmar(TransferenciaBE.GstrNUMERO_SOLICITUD);
					if (intNumeroRegistro!=0){	
						objFuncionesGenerales.callPasosAcierto(8, "Se encontro el registro: "+TransferenciaBE.GstrNUMERO_SOLICITUD, "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(8, "No se encontro el registro: "+TransferenciaBE.GstrNUMERO_SOLICITUD, "" ,"");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
	    			CapturarPantalla.scrollCapturaPantalla();
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (intNumeroRegistro!=0){	
					objTransferenciaGeneralBE.verificarTablaTransferencias();
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
					if (objTransferenciaAutorizacionBE.seleccionarCheckFirmar(intNumeroRegistro)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check para AUTORIZAR");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check para AUTORIZAR");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
			}
			//------------------------------------------------------------------------------------------------------------------
			
			//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoEnviarCorreo("SeccionAutorizar")){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
					strTipoLog="1";
					CapturarPantalla.pageDown("200");
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarTituloCorreo(GstrTXT_CORREO)){
					objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO, "" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarMensajeCorreo(GstrTXT_MENSAJE_CORREO)){
					objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_CORREO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " +GstrTXT_MENSAJE_CORREO, "" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonEnviarCorreo()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_CORREO)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonEnviarCorreo2()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ACEPTAR CORREO");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ACEPTAR CORREO");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoExportarExcel("SeccionAutorizar")){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoExportarPdf("SeccionAutorizar")){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoImprimir("SeccionAutorizar")){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			//---------------------------------------------------------
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_NUMERO_SOLICITUD)){	
				objTransferenciaGeneralBE.verificarTablaTransferencias();
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objTransferenciaAutorizacionBE.seleccionarLinkNumeroSolicitudDetalle(intNumeroRegistro)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link a ver el Detalle");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link a ver el Detalle");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			

			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoLinkEnviarEmailDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaAutorizacionBE.ingresarCorreo( GstrTXT_CORREO_DETALLE)){	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaAutorizacionBE.ingresarMensajeCorreo( GstrTXT_MENSAJE_CORREO_DETALLE)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoBotonEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
	
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoLinkExportarExcelDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoLinkExportarPDFDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_DETALLE)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoLinkImprimirDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_DETALLE)){	
				objTransferenciaGeneralBE.verificarTablaTransferencias();
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objTransferenciaAutorizacionBE.ingresoLinkRegresar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Regresar");
					strTipoLog="1";
					objTransferenciaAutorizacionBE.verificarCamposObligatorios();
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Regresar");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   //	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_AUTORIZAR)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoBotonAutorizar()){	
					objTransferenciaAutorizacionBE.verificarConfirmacion();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AUTORIZAR");
					strTipoLog="1";
					Thread.sleep(500);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AUTORIZAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BLOQUEAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaAutorizacionBE.ingresoBotonBloquear()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BLOQUEAR");
					strTipoLog="1";
					Thread.sleep(500);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BLOQUEAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			//Validamos que la hora sea mayor o igual que la 1
			
	         hora = calendario.get(Calendar.HOUR_OF_DAY);
	         minutos = calendario.get(Calendar.MINUTE);
	         
	         if((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59) && GstrCMB_TIPO_TRANSFERENCIA.equals("A otros Bancos BCR")&& TransferenciaBE.GstrESTADO.equals("Procesada") ){
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP)){	
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonSiPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del POPUP");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del POPUP");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP)){	
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonNoPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del POPUP");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del POPUP");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
	         }
		
			
			
			
			if (GstrTXT_CLAVE.equals("SI")){
				if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
			}

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica", GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica", GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonConfirmar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
		
			//Validamos que la hora sea mayor o igual que la 1
	         hora = calendario.get(Calendar.HOUR_OF_DAY);
	         minutos = calendario.get(Calendar.MINUTE);
	         
	         if((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59)&& GstrCMB_TIPO_TRANSFERENCIA.equals("A otros Bancos BCR")){
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP1)){	
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonSiPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del POPUP");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del POPUP");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP1)){	
					LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonNoPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del POPUP");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del POPUP");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
				}
	         }
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonCancelarOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
				objTransferenciaGeneralBE.verificarImagenOpeEnviada();
				LStr_HoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				String strResultadoObtenido = objTransferenciaAutorizacionBE.obtenerMensajeResultado();
				if (strResultadoObtenido.equals(GstrRESULTADO_ESPERADO)){	
					objMonitoreoTransaccionesBL.LogInsertarTransaccion(GstrTXT_SUBMENU1, Integer.toString(Mdl_Variables.Gint_IdCaso), Mdl_Variables.GstrSIS_GRUPOEJECUCION);
					objFuncionesGenerales.callPasosAcierto(5, strResultadoObtenido, GstrRESULTADO_ESPERADO ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, strResultadoObtenido, GstrRESULTADO_ESPERADO ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),LStr_HoraInicio);

			}
			
			if(blnResultadoEsperado){
				
				if (consultar){
					blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico("Transferencias",GstrCMB_EMPRESA_CUENTA_ORIGEN,TransferenciaBE.GstrCMB_CUENTA_ORIGEN,1,TransferenciaBE.GstrESTADO,TransferenciaBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS,TransferenciaBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
				}else{
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
						objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
					}
				}
			}

		} catch (Exception e) {		
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
            CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen);
            System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
            blnResultadoEsperado = false;
		}    	
    	
		return blnResultadoEsperado;
	}

}
