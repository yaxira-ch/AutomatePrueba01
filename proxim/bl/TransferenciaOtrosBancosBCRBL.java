package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaOtrosBancosBCRBL extends TransferenciaBE {

	private static String strTipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	TransferenciaMapeo objTransferenciaGeneralBE = new TransferenciaMapeo();
	FirmarBL objTransferenciaFirmanteBL =new FirmarBL();
	HeaderBL objHeader = new HeaderBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	public boolean transferenciaOtrosBancosBCR() throws SQLException, IOException{
		boolean blnResultadoEsperado = true;
		String strHoraFin;
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		long lngTiempoEjeCaso;
		String strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		Calendar calendario = new GregorianCalendar();
		 int hora, minutos;
		 String strTextoImagen="1. Imagenes";
		try {

		
			//---------------------------------------MENU---------------------------------------
					objHeader.menuPrincipal(  Mdl_Variables.Gstr_Ignore,GstrTXT_MENU,  Mdl_Variables.Gstr_Ignore);
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_SUBMENU1)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarSubMenu1(TransferenciaBE.GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+TransferenciaBE.GstrTXT_SUBMENU1);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+TransferenciaBE.GstrTXT_SUBMENU1);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA)){
				objTransferenciaGeneralBE.verificarPestaniaTransferencias();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarLinkTransferencia(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción "+TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción "+TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//------------------------------------------------------------------------------			
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_ACEPTAR_POP_UP)){	
				objTransferenciaGeneralBE.verificarPopUp();
				
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonAceptar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_VER_OPERACION_FRECUENTE)){	
				objTransferenciaGeneralBE.verificarTransferenciasBCR();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarVerOperacionesFrecuentes()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK VER OPERACIÓN FRECUENTE");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,  "en el LINK VER OPERACIÓN FRECUENTE");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN)){	
				objTransferenciaGeneralBE.verificarTransferenciasBCR();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarEmpresaCuentaOrigen(TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DE ORIGEN "+TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DE ORIGEN"+TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrCMB_CUENTA_ORIGEN)){	
				objTransferenciaGeneralBE.verificarTransferenciasBCR();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
				if (objTransferenciaGeneralBE.seleccionarCuentaOrigen(TransferenciaBE.GstrCMB_CUENTA_ORIGEN)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE ORIGEN "+TransferenciaBE.GstrCMB_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DE ORIGEN"+TransferenciaBE.GstrCMB_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_CUENTA_DESTINO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNumeroCuenta(TransferenciaBE.GstrTXT_CUENTA_DESTINO)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CUENTA DE DESTINO "+TransferenciaBE.GstrTXT_CUENTA_DESTINO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CUENTA DE DESTINO "+TransferenciaBE.GstrTXT_CUENTA_DESTINO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrCHK_EMPRESA_PROPIETARIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarEmpresaPropietariaCuenta()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"En la empresa es propietaria de la cuenta.");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"En la empresa es propietaria de la cuenta.");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_NOMBRE_EMPRESA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNombre(TransferenciaBE.GstrTXT_NOMBRE_EMPRESA)){	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE "+TransferenciaBE.GstrTXT_NOMBRE_EMPRESA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE "+TransferenciaBE.GstrTXT_NOMBRE_EMPRESA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrCMB_TIPO_DOCUMENTO_IDENTIDAD)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarTipoDocumento(TransferenciaBE.GstrCMB_TIPO_DOCUMENTO_IDENTIDAD)){	
					objFuncionesGenerales.callPasosAcierto(2, "del DOC. de IDENTIDAD "+TransferenciaBE.GstrCMB_TIPO_DOCUMENTO_IDENTIDAD , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del DOC. de IDENTIDAD "+TransferenciaBE.GstrCMB_TIPO_DOCUMENTO_IDENTIDAD , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_NUMERO_IDENTIDAD)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNumeroDocumento(TransferenciaBE.GstrTXT_NUMERO_IDENTIDAD)){	
					objFuncionesGenerales.callPasosAcierto(3, "El NÚMERO DE DOC. "+TransferenciaBE.GstrTXT_NUMERO_IDENTIDAD , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El NÚMERO DE DOC. "+TransferenciaBE.GstrTXT_NUMERO_IDENTIDAD , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_MONTO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarMonto(TransferenciaBE.GstrTXT_MONTO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MONTO "+TransferenciaBE.GstrTXT_MONTO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MONTO "+TransferenciaBE.GstrTXT_MONTO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrCMB_MONEDA)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarMoneda(TransferenciaBE.GstrCMB_MONEDA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+TransferenciaBE.GstrCMB_MONEDA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+TransferenciaBE.GstrCMB_MONEDA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_PROGRAMA_OPERACION)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				Date fechaActual=new Date();
				DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal=Calendar.getInstance();
				cal.setTime(fechaActual);
				cal.add(Calendar.DATE, 7);
				Date nuevaFecha=cal.getTime();
				
				String fecha= formatoFecha.format(nuevaFecha);
				GstrTXT_PROGRAMA_OPERACION=fecha;
				objSQL.actualizarTabla("APP_AND_TRANSFERENCIAS_OTROS_BANCOS_BCR_D", "TXT_PROGRAMA_OPERACION", fecha, Gstr_ID_CASO);
				if (objTransferenciaGeneralBE.ingresarFechaProgramaOperacion(GstrTXT_PROGRAMA_OPERACION)){	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA para realizar operacion otro dia "+GstrTXT_PROGRAMA_OPERACION , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA para realizar operacion otro dia "+GstrTXT_PROGRAMA_OPERACION , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarDescripcion(TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La descripcion "+TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La descripcion "+TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_CONTINUAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					strTipoLog="1";
					Thread.sleep(200);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			//Validamos que la hora sea mayor o igual que la 1
			hora = calendario.get(Calendar.HOUR_OF_DAY);
	         minutos = calendario.get(Calendar.MINUTE);
	         
	         if(((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59))&&TransferenciaBE.GstrTXT_PROGRAMA_OPERACION.equals(Mdl_Variables.Gstr_Ignore)){
				if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_SI_POP_UP)){	
					objTransferenciaGeneralBE.verificarPopUpConfirmacion();
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonSiPopUp()){	
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
				
				if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_NO_POP_UP)){	
					objTransferenciaGeneralBE.verificarPopUpConfirmacion();
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonNoPopUp()){	
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
	         
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)&&(!GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE")&&!GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE_DINAMICA"))){
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
					String strNuevoMensaje=objTransferenciaGeneralBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR);
					if (strNuevoMensaje.equals(""))
					{	
						objFuncionesGenerales.callPasosAcierto(7, "Entre el mensaje mostrado y esperado", "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";										
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(7, strNuevoMensaje, "" ,"");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				}
				

				
			if (TransferenciaBE.GstrTXT_CLAVE.equals("SI")){
				objTransferenciaGeneralBE.verificarVentanaConfirmacion();
				
//				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - CONFIRMAR-----
//				String strCadena = "S/.";
//				String strTexto = "";
//				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_MontoTotalTransferir");
//				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
//				{	
//					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto Total a Transferir", "" ,"");
//					toString();
//					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Monto Total Transfereir", strCadena, strTexto);
//				}else{
//					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto Total a Transferir", "" ,"");
//				}
//				
//				strCadena = "S/.";
//				strTexto = "";
//				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_ComisionPorTransfer");
//				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
//				{	
//					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" de la comision por transferir", "" ,"");
//					toString();
//					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Comision", strCadena, strTexto);
//				}else{
//					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" de la comision por transferir", "" ,"");
//				}
//				
//				strCadena = "S/.";
//				strTexto = "";
//				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_MontoTotalPagar");
//				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
//				{	
//					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del monto total a pagar", "" ,"");
//					toString();
//					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Comision", strCadena, strTexto);
//				}else{
//					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del monto total a pagar", "" ,"");
//				}
//
//				//---------------------------------------------------------
			
				
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
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_CLAVE_DINAMICA)){	
				objTransferenciaGeneralBE.verificarVentanaConfirmacion();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarClaveDinamica(TransferenciaBE.GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica ", TransferenciaBE.GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica ", TransferenciaBE.GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_CONFIRMAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonConfirmar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					objTransferenciaGeneralBE.verificarResultadoFinalBCR();
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)&&(GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE")||GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE_DINAMICA"))){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objTransferenciaGeneralBE.compararMensajeError1(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				
			}

			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_CANCELAR_OPERACION)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonCancelarOperacion()){	
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
			
			//Validamos que la hora sea mayor o igual que la 1
	         hora = calendario.get(Calendar.HOUR_OF_DAY);
	         minutos = calendario.get(Calendar.MINUTE);
	         
	         if(((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59))&&TransferenciaBE.GstrTXT_PROGRAMA_OPERACION.equals(Mdl_Variables.Gstr_Ignore)){
				if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_SI_POP_UP1)){	
					objTransferenciaGeneralBE.verificarPopUpConfirmacion();
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonSiPopUp()){	
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
		    		Thread.sleep(800);
				}
				
				if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_NO_POP_UP1)){	
					objTransferenciaGeneralBE.verificarPopUpConfirmacion();
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objTransferenciaGeneralBE.ingresoBotonNoPopUp()){	
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
	         
			if(!objTransferenciaGeneralBE.verificarResultadoEsperado()&& objTransferenciaGeneralBE.compararMensajeRepetido()){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objTransferenciaGeneralBE.botonSiCopia()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
				
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrRESULTADO_ESPERADO)){	
				objTransferenciaGeneralBE.verificarResultadoEsperado();
				objTransferenciaGeneralBE.guardarIdTabla();  
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.compararResultadoEsperado(TransferenciaBE.GstrRESULTADO_ESPERADO)){	
					objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado ", " Resultado Obtenido" ,"");
					strTipoLog="1";
					
					String montoOperacion;
					
					montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[2]/div[6]/span[2]" );
					int totalCadena=montoOperacion.length();
					
					if(montoOperacion.contains("/")){
						Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
					}else{
						Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
					}
					GstrTOTAL_PAGAR=montoOperacion;
					

					//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - ENVIADO-----
					String strCadena = "S/.";
					String strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Enviado_MontoTotalTransferir");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto Total a Transferir", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Monto Total Transfereir", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto Total a Transferir", "" ,"");
					}
					
					strCadena = "S/.";
					strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Enviado_Comision");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" de la comision por transferir", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Comision", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" de la comision por transferir", "" ,"");
					}
					
					strCadena = "S/.";
					strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Enviado_MontoTotalPagar");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del monto total a pagar", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Comision", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del monto total a pagar", "" ,"");
					}

					//---------------------------------------------------------
				
				
					//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_ENVIAR_CORREO)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoEnviarCorreo("SeccionEnvios")){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_CORREO_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresarTituloCorreo(TransferenciaBE.GstrTXT_CORREO_POPUP)){
							objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + TransferenciaBE.GstrTXT_CORREO_POPUP, "" ,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + TransferenciaBE.GstrTXT_CORREO_POPUP, "" ,"");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_MENSAJE_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresarMensajeCorreo(TransferenciaBE.GstrTXT_MENSAJE_POPUP)){
							objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + TransferenciaBE.GstrTXT_MENSAJE_POPUP, "" ,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + TransferenciaBE.GstrTXT_MENSAJE_POPUP, "" ,"");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_ENVIAR_CORREO_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoBotonEnviarCorreo()){
							Thread.sleep(3000);
							objTransferenciaGeneralBE.ingresoBotonEnviarCorreo2();
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_EXPORTAR_EXCEL)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoExportarExcel("SeccionEnvios")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_EXPORTAR_PDF)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoExportarPdf("SeccionEnvios")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_IMPRIMIR)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoImprimir("SeccionEnvios")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					//---------------------------------------------------------
					
					objTransferenciaGeneralBE.guardarDatosOperacionAutorizar();
					
					if (GstrFIRMAR.equals("NO") && GstrESTADO.equals("Procesada")){
						blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico("Transferencias",GstrCMB_EMPRESA_CUENTA_ORIGEN,GstrCMB_CUENTA_ORIGEN,1,GstrESTADO,"",TransferenciaBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrLNK_OPERACION_FRECUENTE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoAgregarOperacionesFrecuentes()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Link Agregar a mis operaciones frecuentes");
					strTipoLog="1";
					
					//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - OPER FRECUENTE-----
					String strCadena = "S/.";
					String strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_OpeFrecuente_Monto");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto de la Operaciones Frecuente", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos BCR, Enviado - Monto Total Transfereir", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto de la Operaciones Frecuente", "" ,"");
					}
					//-------------------------------------------------------				
					
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Link Agregar a mis operaciones frecuentes");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_DESCRIPCION_OPERACION_FRECUENTE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarDescripcionOperacionFrecuente(TransferenciaBE.GstrTXT_DESCRIPCION_OPERACION_FRECUENTE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La DESCRIPCION "+TransferenciaBE.GstrTXT_DESCRIPCION_OPERACION_FRECUENTE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La DESCRIPCION "+TransferenciaBE.GstrTXT_DESCRIPCION_OPERACION_FRECUENTE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_CONTINUAR_OPERACION_FRECUENTE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonContinuarOperacionFrecuente()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR de la operacion Frecuente");
					strTipoLog="1";

					//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - OPER FRECUENTE ENVIADO-----
					String strCadena = "S/.";
					String strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_OpeFrecuente_MontoRealizado");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto de la Operaciones Frecuente", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos BCR, Enviado - Monto Total Transfereir", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto de la Operaciones Frecuente", "" ,"");
					}
					//-------------------------------------------------------

				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR de la operacion Frecuente");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			

			//------------------------------------------------------REALIZA FIRMA------------------------------------------------------
				
			if(blnResultadoEsperado&&TransferenciaBE.GstrFIRMAR.equals("SI")){

				if(GstrOPERADOR.equals( Mdl_Variables.Gstr_Ignore)){
					if (!GstrFIRMANTE3.equals( Mdl_Variables.Gstr_Ignore)){
						consultar3=true;
					}else if (!GstrFIRMANTE2.equals( Mdl_Variables.Gstr_Ignore)){
						consultar2=true;
					}else{
						if (!GstrFIRMANTE1.equals( Mdl_Variables.Gstr_Ignore)){
							consultar1=true;
						}
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				}
					
				if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrFIRMANTE1)){
					if (TransferenciaBE.GstrFIRMANTE1.equals("PA")||TransferenciaBE.GstrFIRMANTE1.equals("PA-B")){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",TransferenciaBE.Gstr_ID_CASO,"F1",consultar1);
					}else if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos BCR",consultar1,null,null,null);
					}else{
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",TransferenciaBE.Gstr_ID_CASO,"F1",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA,consultar1);
					}
				}
					
				if(blnResultadoEsperado){
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrFIRMANTE2)){
						if (TransferenciaBE.GstrFIRMANTE2.equals("PA")||TransferenciaBE.GstrFIRMANTE2.equals("PA-B")){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",TransferenciaBE.Gstr_ID_CASO,"F2",consultar2);
						}else if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos BCR",consultar2,null,null,null);
						}else{
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",TransferenciaBE.Gstr_ID_CASO,"F2",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA,consultar2);
						}
					}
					
					if(blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrFIRMANTE3)){
							if (TransferenciaBE.GstrFIRMANTE3.equals("PA")||TransferenciaBE.GstrFIRMANTE3.equals("PA-B")){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",TransferenciaBE.Gstr_ID_CASO,"F3",consultar3);
							}else if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos BCR",consultar3,null,null,null);
							}else{
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",TransferenciaBE.Gstr_ID_CASO,"F3",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA,consultar3);
							}
						}
						
						if(blnResultadoEsperado&&objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",Gstr_ID_CASO,"OP",true);
						}
					}
				}
			}	
			//------------------------------------------------------------------------------------------------------------
			
		}
		
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	    	blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
}
