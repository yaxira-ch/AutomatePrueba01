package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaOtrosBancosCCEBL extends TransferenciaBE{

	
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	TransferenciaMapeo objTransferenciaGeneralBE = new TransferenciaMapeo();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objTransferenciaFirmanteBL =new FirmarBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	public boolean transferenciaOtrosBancosCCE() throws SQLException, IOException{
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		boolean bandera = true;
		String strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
		String strHoraFin;
		long lngTiempoEjeCaso;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		String strTipoLog = null;
		String strTextoImagen="1. Imagenes";
		
		try {
			
			
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal( "<IGNORE>",GstrTXT_MENU, "<IGNORE>");
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIO_TRANSFERENCIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarLinkTransferencia(GstrLNK_ENVIO_TRANSFERENCIA)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción "+GstrLNK_ENVIO_TRANSFERENCIA);
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción "+GstrLNK_ENVIO_TRANSFERENCIA);
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//------------------------------------------------------------------------------			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarEmpresaCuentaOrigen(GstrCMB_EMPRESA_CUENTA_ORIGEN)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DE ORIGEN "+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DE ORIGEN"+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarCuentaOrigen(GstrCMB_CUENTA_ORIGEN)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE ORIGEN "+GstrCMB_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DE ORIGEN"+GstrCMB_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CUENTA_DESTINO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNumeroCuenta(GstrTXT_CUENTA_DESTINO)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CUENTA DE DESTINO "+GstrTXT_CUENTA_DESTINO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La CUENTA DE DESTINO "+GstrTXT_CUENTA_DESTINO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_EMPRESA_PROPIETARIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarEmpresaPropietariaCuenta()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"En la empresa es propietaria de la cuenta.");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"En la empresa es propietaria de la cuenta.");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
						
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_EMPRESA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNombre(GstrTXT_NOMBRE_EMPRESA)){	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE "+GstrTXT_NOMBRE_EMPRESA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE "+GstrTXT_NOMBRE_EMPRESA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DOCUMENTO_IDENTIDAD)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarTipoDocumento(GstrCMB_TIPO_DOCUMENTO_IDENTIDAD)){	
					objFuncionesGenerales.callPasosAcierto(2, "del DOC. de IDENTIDAD "+GstrCMB_TIPO_DOCUMENTO_IDENTIDAD , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del DOC. de IDENTIDAD "+GstrCMB_TIPO_DOCUMENTO_IDENTIDAD , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_IDENTIDAD)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNumeroDocumento(GstrTXT_NUMERO_IDENTIDAD)){	
					objFuncionesGenerales.callPasosAcierto(3, "El NÚMERO DE DOC. "+GstrTXT_NUMERO_IDENTIDAD , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NÚMERO DE DOC. "+GstrTXT_NUMERO_IDENTIDAD , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarMonto(GstrTXT_MONTO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El MONTO "+GstrTXT_MONTO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MONTO "+GstrTXT_MONTO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarMoneda(GstrCMB_MONEDA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_TIPO_CAMBIO_ESPECIAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarTipoCambioEspecial()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"En la opción para utilizar tipo de cambio especial.");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"En la opción para utilizar tipo de cambio especial.");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TIPO_CAMBIO_ESPECIAL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarTipoCambioEspecial(GstrTXT_TIPO_CAMBIO_ESPECIAL)){	
					objFuncionesGenerales.callPasosAcierto(3, "Codigo tipo cambio especial "+GstrTXT_TIPO_CAMBIO_ESPECIAL , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "Codigo tipo cambio especial "+GstrTXT_TIPO_CAMBIO_ESPECIAL , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DESCRIPCION_TRANSFERENCIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarDescripcion(GstrTXT_DESCRIPCION_TRANSFERENCIA)){	
					Thread.sleep(500);
					objFuncionesGenerales.callPasosAcierto(3, "La descripcion "+GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La descripcion "+GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
					
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CORRE");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CORRE");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoCorreos(GstrTXT_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", GstrTXT_CORREO,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La contraseña ", GstrTXT_CORREO,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO)) {	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarMensaje(GstrTXT_MENSAJE_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "La Fecha de Inicio "+GstrTXT_MENSAJE_CORREO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La Fecha de Inicio "+GstrTXT_MENSAJE_CORREO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			boolean bCalcTipoCambio = false;
			if (objTransferenciaGeneralBE.visibleTipoCambioReferencial()){
				bCalcTipoCambio = true;
				
				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - REFERENCIAL -----
				Thread.sleep(3000);
				String strCadena = "S/.";
				String strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_TipCamRef_TipoCambio");
				String strMonto="";
				strMonto= objTransferenciaGeneralBE.obtenerMontoSeccion("ECTAS_TipCamRef_TipoCambio");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)||objTransferenciaGeneralBE.buscarComa(strMonto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Tipo de Cambio Especial", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Tipo cambio especial", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Tipo de Cambio Referencial", "" ,"");
				}
				strCadena = "S/.";
				strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_TipCamRef_MontoConvertido");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Tipo de Cambio Especial", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Tipo cambio Monto Convertido", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Tipo de Cambio Referencial", "" ,"");
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TIPO_CAMBIO_ESPECIAL)){	
				bCalcTipoCambio = true;
				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - ESPECIAL -----
				Thread.sleep(3000);
				String strCadena = "S/.";
				String strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_TipCamEsp_TipoCambio");
				String strMonto="";
				strMonto= objTransferenciaGeneralBE.obtenerMontoSeccion("ECTAS_TipCamEsp_TipoCambio");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)||objTransferenciaGeneralBE.buscarComa(strMonto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Tipo de Cambio Especial", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Tipo cambio especial", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Tipo de Cambio Especial", "" ,"");
				}
				strCadena = "S/.";
				strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_TipCamEsp_MontoConvertido");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Tipo de Cambio Especial", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Tipo cambio Monto Convertido", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Tipo de Cambio Especial", "" ,"");
				}
				//---------------------------------------------------------

			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					strTipoLog="1";
					objTransferenciaGeneralBE.verificarConfirmacionTransferenciaCCE();
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)&&(!GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE")&&!GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE_DINAMICA"))){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objTransferenciaGeneralBE.compararMensajeErrorCCE(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (TransferenciaBE.GstrTXT_CLAVE.equals("SI")){	
				objTransferenciaGeneralBE.verificarTecladoEntreCuentas();
				
				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - CONFIRMAR-----
				String strCadena = "S/.";
				String strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_MontoTotalTransferir");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto Total a Transferir", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Monto Total Transfereir", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto Total a Transferir", "" ,"");
				}
				
				strCadena = "S/.";
				strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_ComisionPorTransfer");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" de la comision por transferir", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Comision", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" de la comision por transferir", "" ,"");
				}
				
				strCadena = "S/.";
				strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_MontoTotalPagar");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del monto total a pagar", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Comision", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del monto total a pagar", "" ,"");
				}
				
				if(bCalcTipoCambio || objTransferenciaGeneralBE.hayCambioMoneda(TransferenciaBE.GstrCMB_CUENTA_ORIGEN,TransferenciaBE.GstrCMB_MONEDA) ){
					strCadena = "S/.";
					strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_TipoCambio");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)||objTransferenciaGeneralBE.buscarComa(strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del tipo de cambio", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Monto Convertido Transferido", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del tipo de cambio", "" ,"");
					}
				}

				//---------------------------------------------------------
			
				
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarClaveDinamica(TransferenciaBE.GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica", TransferenciaBE.GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica", TransferenciaBE.GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrBTN_CONFIRMAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonConfirmar1()){	
					objTransferenciaGeneralBE.guardarIdTabla();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					objTransferenciaGeneralBE.verificarResultadoEsperadoTransferenciaCCE();
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)&&GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE")||GstrTXT_COLUMNA_ERROR.equals("TXT_CLAVE_DINAMICA")){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objTransferenciaGeneralBE.compararMensajeErrorCCE1(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					bandera = false;
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
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrRESULTADO_ESPERADO)){	
				//strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
				objTransferenciaGeneralBE.guardarIdTabla(); 
				if (objTransferenciaGeneralBE.compararResultadoEsperado(TransferenciaBE.GstrRESULTADO_ESPERADO)){	
					objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado", "Resultado Obtenido" ,"");
					strTipoLog="1";
					
					String montoOperacion;
					
					montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]/span[2]" );
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
					
					if(bCalcTipoCambio || objTransferenciaGeneralBE.hayCambioMoneda(GstrCMB_CUENTA_ORIGEN,GstrCMB_MONEDA) ){
						strCadena = "S/.";
						strTexto = "";
						strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Enviado_TipoCambio");
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)||objTransferenciaGeneralBE.buscarComa(strTexto)){	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del tipo de cambio", "" ,"");
							toString();
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Confirmar - Monto Convertido Transferido", strCadena, strTexto);
						}else{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del tipo de cambio", "" ,"");
						}
					}

					//---------------------------------------------------------
				
					//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_CORREO)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoEnviarCorreo("SeccionEnvios")){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresarTituloCorreo(GstrTXT_CORREO_POPUP)){
							objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP)){
							objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoBotonEnviarCorreo()){
							Thread.sleep(3000);
							objTransferenciaGeneralBE.ingresoBotonEnviarCorreo2();
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoExportarExcel("SeccionEnvios")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoExportarPdf("SeccionEnvios")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoImprimir("SeccionEnvios")){
							Thread.sleep(3000);
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					//---------------------------------------------------------
					
					objTransferenciaGeneralBE.guardarDatosOperacionAutorizar();
					
					if (GstrFIRMAR.equals("NO") && !GstrESTADO.equals("<IGNORE>")){
						bandera=objConsultaHistoricaBL.consultaHistorico("Transferencias",GstrCMB_EMPRESA_CUENTA_ORIGEN,GstrCMB_CUENTA_ORIGEN,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,TransferenciaBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_OPERACION_FRECUENTE)){	
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
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Enviado - Monto Total Transfereir", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto de la Operaciones Frecuente", "" ,"");
					}
					//-------------------------------------------------------
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Link Agregar a mis operaciones frecuentes");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DESCRIPCION_OPERACION_FRECUENTE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarDescripcionOperacionFrecuente(GstrTXT_DESCRIPCION_OPERACION_FRECUENTE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La DESCRIPCION "+GstrTXT_DESCRIPCION_OPERACION_FRECUENTE , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La DESCRIPCION "+GstrTXT_DESCRIPCION_OPERACION_FRECUENTE , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR_OPERACION_FRECUENTE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonContinuarOperacionFrecuente()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR de la operacion Frecuente");
					strTipoLog="1";
					
					//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - OPER FRECUENTE ENVIADO-----
					String strCadena = "S/.";
					String strTexto = "";
					strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_OpeFrecuente_MontoRealizado");
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
					{	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto de la Operaciones Frecuente", "" ,"");
						toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia Bancos CCE, Enviado - Monto Total Transfereir", strCadena, strTexto);
					}else{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto de la Operaciones Frecuente", "" ,"");
					}
					//-------------------------------------------------------
					
				}else{
					strTipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR de la operacion Frecuente");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
		

			//------------------------------------------------------REALIZA FIRMA------------------------------------------------------
			
			if(bandera&&GstrFIRMAR.equals("SI")){
					
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
					
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				}
				
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1)){
						if (GstrFIRMANTE1.equals("PA")){
							bandera=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",Gstr_ID_CASO,"F1",consultar1);
						}else if (GstrFIRMANTE1.equals("PORT")){
							bandera=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos CCE",consultar1,Mdl_Variables.Gstr_Ignore,GstrCMB_CUENTA_ORIGEN,null);
						}else{
							bandera=objTransferenciaFirmanteBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F1",GstrLNK_ENVIO_TRANSFERENCIA,consultar1);
						}
					}
					
					if(bandera){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
							if (GstrFIRMANTE2.equals("PA")){
								bandera=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",Gstr_ID_CASO,"F2",consultar2);
							}else if (GstrFIRMANTE2.equals("PORT")  ){
								bandera=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos CCE",consultar2,Mdl_Variables.Gstr_Ignore,GstrCMB_CUENTA_ORIGEN,null);
							}else{
								bandera=objTransferenciaFirmanteBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F2",GstrLNK_ENVIO_TRANSFERENCIA,consultar2);
							}
						}
						
						if(bandera){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
								if (GstrFIRMANTE3.equals("PA")){
									bandera=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",Gstr_ID_CASO,"F3",consultar3);
								}else if (GstrFIRMANTE3.equals("PORT")  ){
									bandera=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos CCE",consultar3,Mdl_Variables.Gstr_Ignore,GstrCMB_CUENTA_ORIGEN,null);
								}else{
									bandera=objTransferenciaFirmanteBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F3",GstrLNK_ENVIO_TRANSFERENCIA,consultar3);
								}
							}
							
							if(bandera&&objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
								bandera=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",Gstr_ID_CASO,"OP",true);
							}
						}
					}
				
				
			}		
			//------------------------------------------------------------------------------------------------------------
			
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
}
