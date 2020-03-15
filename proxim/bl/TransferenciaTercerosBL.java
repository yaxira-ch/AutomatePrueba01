package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaTercerosBL extends TransferenciaBE  {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	TransferenciaMapeo objTransferenciaGeneralBE = new TransferenciaMapeo();
	FirmarBL objTransferenciaFirmanteBL =new FirmarBL();
	HeaderBL objHeader = new HeaderBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
		
	public boolean transferenciaTerceros() throws SQLException, IOException{
		String strTextoImagen="1. Imagenes";
		String strPantallaValidacion="SeccionEnvios";
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		String strTipoLog = null;
		String strHoraFin;
		String strHoraInicio ;
		boolean blnResultadoEsperado = true;
		long lngTiempoEjeCaso;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		
		Mdl_Variables.GstrSIS_GRUPOEJECUCION = Gstr_ID_CASO + "-"+ new SimpleDateFormat("yyyyMMddHHmm").format(Calendar.getInstance().getTime());
		try {			
			
			//---------------------------------------MENU---------------------------------------
			//objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, GstrTXT_MENU, Mdl_Variables.Gstr_Ignore);
			String txtMenu="/html/body/div[2]/div[2]/div/ul/li[5]/a";
			String txtSubMenu="<IGNORE>";
			String txtTabMenu ="ATerceros";
			FuncionesGenerales.MenuGeneralNew(txtMenu,"<IGNORE>");
			Thread.sleep(2000);
			objObjetosGenerales.clickBoton(ObjetosGenerales.id, txtTabMenu);
			Thread.sleep(1000);
			/*
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el SUB MENU, "+GstrTXT_SUBMENU1);
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

			if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIO_TRANSFERENCIA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarLinkTransferencia(GstrLNK_ENVIO_TRANSFERENCIA)){	
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
			*/
			//------------------------------------------------------------------------------			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN))
			{		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarEmpresaCuentaOrigen(GstrCMB_EMPRESA_CUENTA_ORIGEN))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DE ORIGEN, "+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DE ORIGEN, "+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN))
			{		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarCuentaOrigen(GstrCMB_CUENTA_ORIGEN))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE ORIGEN, "+GstrCMB_CUENTA_ORIGEN , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DE ORIGEN, "+GstrCMB_CUENTA_ORIGEN , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CUENTA))
			{		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarTipoCuenta(GstrCMB_TIPO_CUENTA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE CUENTA, "+GstrCMB_TIPO_CUENTA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE CUENTA, "+GstrCMB_TIPO_CUENTA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CUENTA_DESTINO))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarNumeroCuenta(GstrTXT_CUENTA_DESTINO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La CUENTA DE DESTINO, "+GstrTXT_CUENTA_DESTINO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CUENTA DE DESTINO, "+GstrTXT_CUENTA_DESTINO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
						
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarMonto(GstrTXT_MONTO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MONTO, "+GstrTXT_MONTO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MONTO, "+GstrTXT_MONTO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objTransferenciaGeneralBE.seleccionarMoneda(GstrCMB_MONEDA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA, "+GstrCMB_MONEDA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA, "+GstrCMB_MONEDA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_TIPO_CAMBIO_ESPECIAL))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.seleccionarTipoCambioEspecial()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"En la opción para utilizar tipo de cambio especial.");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"En la opción para utilizar tipo de cambio especial.");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TIPO_CAMBIO_ESPECIAL))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarTipoCambioEspecial(GstrTXT_TIPO_CAMBIO_ESPECIAL)){	
					objFuncionesGenerales.callPasosAcierto(3, "", "" ,"el numero de ticket del Tipo de Cambio Especial.");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "", "" ,"el numero de ticket del Tipo de Cambio Especial.");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
						
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DESCRIPCION_TRANSFERENCIA))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarDescripcion(GstrTXT_DESCRIPCION_TRANSFERENCIA))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La DESCRIPCIÓN, "+GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La DESCRIPCIÓN, "+GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
					
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CORREO))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CORREO");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CORREO");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoCorreos(GstrTXT_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El CORREO, ", GstrTXT_CORREO,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El CORREO, ", GstrTXT_CORREO,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objTransferenciaGeneralBE.ingresarMensaje(GstrTXT_MENSAJE_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MESANJE, "+GstrTXT_MENSAJE_CORREO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El MESANJE, "+GstrTXT_MENSAJE_CORREO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			

			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					strTipoLog="1";
					objTransferenciaGeneralBE.verificarConfirmacionTerceros();
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (GstrTXT_CLAVE.toLowerCase().equalsIgnoreCase("SI")){
				objTransferenciaGeneralBE.verificarTecladoEntreCuentas();
				
				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA - CONFIRMAR-----
				String strCadena = "S/.";
				String strTexto = "";
				strTexto = objTransferenciaGeneralBE.obtenerTextoSeccion("ECTAS_Confirmar_MontoTotalTransferir");
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto +" del Monto Total a Transferir", "" ,"");
					toString();
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Transferencia A Terceros, Confirmar - Monto Total Transfereir", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto+" del Monto Total a Transferir", "" ,"");
				}
				
				//---------------------------------------------------------
			
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
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CLAVE DINAMICA, ", GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CLAVE DINAMICA, ", GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				//07/03/2017(sconcha)update para capturar el nombre de la empresa y guardar en el campo CMB_EMPRESA_CUENTA_DESTINO
				objTransferenciaGeneralBE.insertNombreEmpresa();
				
				if (objTransferenciaGeneralBE.ingresoBotonConfirmar1()){	
					objTransferenciaGeneralBE.guardarIdTabla();
					objTransferenciaGeneralBE.verificarResultadoEsperadoTerceros();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
				objTransferenciaGeneralBE.verificarImagenTransfEnviada();
				objTransferenciaGeneralBE.guardarIdTabla();
				String strResultadoObtenido = objTransferenciaGeneralBE.obtenerResultado();
				if (strResultadoObtenido.equals(GstrRESULTADO_ESPERADO)){	
					String montoOperacion;
					System.out.println("enviada");
					montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/span[2]" );
					int totalCadena=montoOperacion.length();
					
					if(montoOperacion.contains("/")){
						Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
					}else{
						Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
					}
					GstrTOTAL_PAGAR=montoOperacion;
					objFuncionesGenerales.callPasosAcierto(5, GstrRESULTADO_ESPERADO, strResultadoObtenido,"");
					strTipoLog="1";
					//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_CORREO)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoEnviarCorreo(strPantallaValidacion)){
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
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresarTituloCorreo(GstrTXT_CORREO_POPUP)){
							objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";			
							blnResultadoEsperado = false;
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
							blnResultadoEsperado = false;
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
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
						}
						strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoExportarExcel(strPantallaValidacion)){
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
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoExportarPdf(strPantallaValidacion)){
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
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
						strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						if (objTransferenciaGeneralBE.ingresoImprimir(strPantallaValidacion)){
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
					
					if (GstrFIRMAR.equals("NO") ){
						blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico("Transferencias",GstrCMB_EMPRESA_CUENTA_ORIGEN,GstrCMB_CUENTA_ORIGEN,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,TransferenciaBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_OPERACION_FRECUENTE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objTransferenciaGeneralBE.ingresoAgregarOperacionesFrecuentes()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Link Agregar a mis operaciones frecuentes");
					strTipoLog="1";
										
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
				
			if (blnResultadoEsperado&& TransferenciaBE.GstrFIRMAR.equals("SI")){
					
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
				String strTablaAutorizarTransferencias="APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D";
				String strTablaAutorizarPortabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
				String strTablaAutorizarPendientes="APP_AND_AUTORIZACIONES_PENDIENTES_D";
				
				if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrFIRMANTE1)){
					if (TransferenciaBE.GstrFIRMANTE1.equals("PA")){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,TransferenciaBE.Gstr_ID_CASO,"F1",consultar1);
					}else if (GstrFIRMANTE1.equals("PORT")){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a Terceros",consultar1,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,null);
					}else if (GstrFIRMANTE1.equals("AP")  ){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,TransferenciaBE.Gstr_ID_CASO,"F1",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA,consultar1);
					}
				}
				
				if (blnResultadoEsperado){
					if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrFIRMANTE2)){
						if (TransferenciaBE.GstrFIRMANTE2.equals("PA")){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,Gstr_ID_CASO,"F2",consultar2);
						}else if (GstrFIRMANTE2.equals("PORT") ){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a Terceros",consultar2,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,null);
						}else if (GstrFIRMANTE2.equals("AP")){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,Gstr_ID_CASO,"F2",GstrLNK_ENVIO_TRANSFERENCIA,consultar2);
						}
					}
					
					if (blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(TransferenciaBE.GstrFIRMANTE3)){  
							if (TransferenciaBE.GstrFIRMANTE3.equals("PA")){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,Gstr_ID_CASO,"F3",consultar3);
							}else if (GstrFIRMANTE3.equals("PORT")){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a Terceros",consultar3,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_ORIGEN,null);
							}else if (GstrFIRMANTE3.equals("AP")){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,Gstr_ID_CASO,"F3",GstrLNK_ENVIO_TRANSFERENCIA,consultar3);
							}
						}
						
						if(blnResultadoEsperado && objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,Gstr_ID_CASO,"OP",true);
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
