package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import proxim.be.ContratosDigitalesAutorizarBE;
import proxim.be.ContratosDigitalesBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ContratosDigitalesBL extends ContratosDigitalesBE {
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	ContratosDigitalesMapeo objContratosDigitalesMapeo = new ContratosDigitalesMapeo();
	ContratosDigitalesAutorizarBL objContratosDigitalesAutorizarBL = new ContratosDigitalesAutorizarBL();
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();

	
	boolean blnResultadoEsperado;
	long strHoraFin;
	long lngTiempoEjeCaso;
	long strHoraInicio;
	boolean consultar1=false;
	boolean consultar2=false;
	boolean consultar3=false;

	public boolean realizarEnvio() throws SQLException, IOException{
		String strTipoLog = null;
		Mdl_Variables.map= new HashMap<String,String>();
		blnResultadoEsperado = true;
		String codigoSolicitud = null;
		String strTextoImagen="1. Imagenes";
		try{	

			//==============================MENU======================================
		
			objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, "Solicitudes", "Contratos Digitales");
		
			if (objFuncionesGenerales.verificarIgnore(strBtnPagos)){	
				strHoraInicio = System.currentTimeMillis();	
				if (objContratosDigitalesMapeo.seleccionarOpcionPago(strBtnPagos)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción"+strBtnPagos);
					strTipoLog="1";
				}else{
					strTipoLog="0";	
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción"+strBtnPagos);
				}
				strHoraFin = System.currentTimeMillis();	 
			   	lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
			    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			 
			if (objFuncionesGenerales.verificarIgnore(strBtnPagos)){
				String strNewValor=objContratosDigitalesMapeo.ValidarTextoProducto(strBtnPagos);
				strHoraInicio = System.currentTimeMillis();	
				if (strNewValor.equals("")){	
					objFuncionesGenerales.callPasosAcierto(8, "Valores Correctos", "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(8, "Valores Incorrectos:"+strNewValor, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();	 
			   	lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
		    //BOTON SOLICITAR O MODIFICAR PRODUCTO
			if (objFuncionesGenerales.verificarIgnore(strBtnSolicitarModificar)){	
				CapturarPantalla.pageDown("400");
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.solicitarProducto(strBtnSolicitarModificar,strBtnPagos)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón: "+strBtnSolicitarModificar);
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón: "+strBtnSolicitarModificar);
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}

			//COMBO EMPRESA
			
			if (objFuncionesGenerales.verificarIgnore(GstrIND_EMPRESA)&&
					GstrIND_EMPRESA.equals("NO")&&
					objFuncionesGenerales.verificarIgnore(GstrCMB_NOMBRE_EMPRESA))  {		          
				strHoraInicio = System.currentTimeMillis();  		
				if (objContratosDigitalesMapeo.seleccionarEmpresa( GstrCMB_NOMBRE_EMPRESA,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_NOMBRE_EMPRESA, "" ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("CMB_NOMBRE_EMPRESA", GstrCMB_NOMBRE_EMPRESA);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_NOMBRE_EMPRESA, "" ,"");
				}
				Thread.sleep(1000);
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    }
			
			//LIMITES POR TRANSACCION (RBT NO)
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_LIMITE_MONTO_POR_TRANSACCION_NO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarsinlimite(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "DESEO ESTABLECER LIMITES DE MONTO POR TRANSACCION"+ GstrRBT_LIMITE_MONTO_POR_TRANSACCION_NO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "DESEO ESTABLECER LIMITES DE MONTO POR TRANSACCION"+ GstrRBT_LIMITE_MONTO_POR_TRANSACCION_NO, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR TRANSACCION (RBT SI)
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_LIMITE_MONTO_POR_TRANSACCION_SI)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarConlimite(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "DESEO ESTABLECER LIMITES DE MONTO POR TRANSACCION"+ GstrRBT_LIMITE_MONTO_POR_TRANSACCION_SI, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "DESEO ESTABLECER LIMITES DE MONTO POR TRANSACCION"+ GstrRBT_LIMITE_MONTO_POR_TRANSACCION_SI, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			/*===========================POR LOTE DE PAGO================================*/
			
			//LIMITES POR LOTE(RBT MONTO MÁXIMO) -SOLES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_MAXIMO_SOLES_POR_LOTE)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoMaximoSolesPorLote(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_MAXIMO_SOLES_POR_LOTE, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_MAXIMO_SOLES_POR_LOTE, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR LOTE(TXT MONTO MAXIMO)-SOLES
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarMontoMaximoSolesPorLote( GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(3,"MONTO MÁXIMO SOLES", GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_MONTO_MAXIMO_SOLES_POR_LOTE", GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "MONTO MÁXIMO SOLES", GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR LOTE(RBT SIN LIMITE)-SOLES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoSinLimiteSolesPorLote(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}	
			
			//LIMITES POR LOTE(RBT MONTO MÁXIMO) -DOLARES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_MAXIMO_DOLARES_POR_LOTE)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoMaximoDolaresPorLote(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO DÓLARES"+ GstrRBT_MONTO_MAXIMO_DOLARES_POR_LOTE, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO DÓLARES"+ GstrRBT_MONTO_MAXIMO_DOLARES_POR_LOTE, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
					
			//LIMITES POR LOTE(TXT MONTO MAXIMO)-DOLARES
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarMontoMaximoDolaresPorLote( GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(3,"MONTO MÁXIMO DOLARES", GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_MONTO_MAXIMO_DOLARES_POR_LOTE", GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "MONTO MÁXIMO DOLARES", GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR LOTE(RBT SIN LIMITE)-DOLARES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoSinLimiteDolaresPorLote(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO DOLARES"+ GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO DOLARES"+ GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}	
			
			/*===========================POR PAGO A CADA BENEFICIARIO================================*/
			
			//LIMITES POR PAGO(RBT MONTO MÁXIMO) -SOLES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_MAXIMO_SOLES_POR_PAGO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoMaximoSolesPorPago(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_MAXIMO_SOLES_POR_PAGO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_MAXIMO_SOLES_POR_PAGO, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR PAGO(TXT MONTO MAXIMO)-SOLES
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarMontoMaximoSolesPorPago( GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(3,"MONTO MÁXIMO SOLES", GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_MONTO_MAXIMO_SOLES_POR_PAGO", GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "MONTO MÁXIMO SOLES", GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR PAGO(RBT SIN LIMITE)-SOLES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoSinLimiteSolesPorPago(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO EN SOLES"+ GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}	
					
			
			//LIMITES POR PAGO(RBT MONTO MÁXIMO) -DOLARES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_MAXIMO_DOLARES_POR_PAGO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoMaximoDolaresPorPago(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO DÓLARES"+ GstrRBT_MONTO_MAXIMO_DOLARES_POR_PAGO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO DÓLARES"+ GstrRBT_MONTO_MAXIMO_DOLARES_POR_PAGO, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
							
			//LIMITES POR PAGO(TXT MONTO MAXIMO)-DOLARES
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarMontoMaximoDolaresPorPago( GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(3,"MONTO MÁXIMO DOLARES", GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_MONTO_MAXIMO_DOLARES_POR_PAGO", GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "MONTO MÁXIMO DOLARES", GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//LIMITES POR PAGO(RBT SIN LIMITE)-DOLARES
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarMontoSinLimiteDolaresPorPago(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "MONTO MÁXIMO DOLARES"+ GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "MONTO MÁXIMO DOLARES"+ GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}	
			
			//CAMPO USUARIO
			
			if (objFuncionesGenerales.verificarIgnore(strRbtConsolidarFactura)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.consolidarFacturas(strRbtConsolidarFactura)){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Deseo consolidar las Facturas,...("+strRbtConsolidarFactura+")");
					strTipoLog="1";	
					Mdl_Variables.map.put("RBT_CONSOLIDAR_FACTURA", strRbtConsolidarFactura);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Deseo consolidar las Facturas,...("+strRbtConsolidarFactura+")");			        
				}	
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(strRbtEnvioAutomatico)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.envioAutomatico(strRbtEnvioAutomatico)){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ," Deseo que se envíe automáticamente un mensaje...("+strRbtEnvioAutomatico+")");
					strTipoLog="1";	
					Mdl_Variables.map.put("RBT_ENVIO_AUTOMATICO", strRbtEnvioAutomatico);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ," Deseo que se envíe automáticamente un mensaje...("+strRbtEnvioAutomatico+")");			        
				}	
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//NUMERO MAXIMO DE DIAS PARA EL COBRO DE CHEQUES
			if (objFuncionesGenerales.verificarIgnore(strTxtNumMaxDiasCobro)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarNumeroMaximoDiasCobro( strTxtNumMaxDiasCobro)){ 
					objFuncionesGenerales.callPasosAcierto(3,"Numero máximo de días para el cobro de cheques y órdenes de pago ", strTxtNumMaxDiasCobro ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_NUM_MAX_DIAS_COBRO", strTxtNumMaxDiasCobro);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3,"Numero máximo de días para el cobro de cheques y órdenes de pago ", strTxtNumMaxDiasCobro ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//COMISIÓN ASUMIDA POR PROVEEDOR
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_COMISION_PROVEEDOR)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.comisionProveedor(GstrRBT_COMISION_PROVEEDOR)){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ," ("+GstrRBT_COMISION_PROVEEDOR+")");
					strTipoLog="1";	
					Mdl_Variables.map.put("RBT_COMISION_PROVEEDOR", GstrRBT_COMISION_PROVEEDOR);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ," ("+GstrRBT_COMISION_PROVEEDOR+")");			        
				}	
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				
				//COMISION SOLES
				if (objFuncionesGenerales.verificarIgnore(strComisionSoles)){	
					strHoraInicio = System.currentTimeMillis();	
					if (objContratosDigitalesMapeo.ingresarComisionSoles( strComisionSoles)){ 
						objFuncionesGenerales.callPasosAcierto(3,"Numero máximo de días para el cobro de cheques y órdenes de pago ", strTxtNumMaxDiasCobro ,"");
						strTipoLog="1";
						Mdl_Variables.map.put("TXT_COMISION_SOLES", strComisionSoles);
//						strComisionSolesProveedor=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//*[@id='listacuadro']/li[2]/div/input[1]");
			  		}else{
						strTipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+strComisionSoles);
					}
					strHoraFin = System.currentTimeMillis();	 
				   	lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				//COMISION DOLARSE
				if (objFuncionesGenerales.verificarIgnore(strTxtComisionDolares)){	
					strHoraInicio = System.currentTimeMillis();	
					if (objContratosDigitalesMapeo.ingresarComisionDolares(strTxtComisionDolares)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+strTxtComisionDolares);
						strTipoLog="1";
						CapturarPantalla.pageDown("300");
						Mdl_Variables.map.put("TXT_COMISION_DOLARES", strTxtComisionDolares);
						//strComisionDolaresProveedor=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//*[@id='listacuadro']/li[2]/div/input[2]");
					}else{
						strTipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+strTxtComisionDolares);
						}
					strHoraFin = System.currentTimeMillis();	 
				   	lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
			}
			
		
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CONFIGURAR_PERMISOS_USUARIOS)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.configurarPermisos(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Configurar Permisos de Usuarios");
					strTipoLog="1";	
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Configurar Permisos de Usuarios");			        
				}	
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				Thread.sleep(2000);
				CapturarPantalla.scrollCapturaPantallaVertical("/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div", Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR_ACCESOS)){
				Thread.sleep(3000);
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.confirmarAccesos()){ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"AGREGAR CUENTA CON OTRA MONEDA");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"AGREGAR CUENTA CON OTRA MONEDA");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_CONFIGURACION_PERMISOS_USUARIOS)){       
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.cerrarTerminosCondiciones2()){ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"AGREGAR CUENTA CON OTRA MONEDA");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"AGREGAR CUENTA CON OTRA MONEDA");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//COMBO CUENTA CARGO
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO)) {		          
				strHoraInicio = System.currentTimeMillis();     
				if (objContratosDigitalesMapeo.seleccionarCuentaCargo( GstrCMB_CUENTA_CARGO,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA A CARGO "+ GstrCMB_CUENTA_CARGO, "" ,"");
					strTipoLog="1";
					CapturarPantalla.pageDown("200");
					Mdl_Variables.map.put("CMB_CUENTA_CARGO", GstrCMB_CUENTA_CARGO);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA A CARGO "+ GstrCMB_CUENTA_CARGO, "" ,"");
				}
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    }
			
			//BTN AGREGAR CUENTA CON OTRA MONEDA
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_AGREGAR_CUENTA_OTRA_MONEDA)){       
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.agregarCuentaOtraMoneda(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"AGREGAR CUENTA CON OTRA MONEDA");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"AGREGAR CUENTA CON OTRA MONEDA");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//CMB AGREGAR CUENTA CON OTRA MONEDA
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_OTRA_MONEDA)){		          
				strHoraInicio = System.currentTimeMillis();     
				if (objContratosDigitalesMapeo.seleccionarCuentaOtraMoneda( GstrCMB_CUENTA_OTRA_MONEDA,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_CUENTA_OTRA_MONEDA, "" ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("CMB_CUENTA_OTRA_MONEDA", GstrCMB_CUENTA_OTRA_MONEDA);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_CUENTA_OTRA_MONEDA, "" ,"");
				}
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    }
			
			//BTN QUITAR CUENTA AGREGADA CON OTRA MONEDA
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_QUITAR_CUENTA_OTRA_MONEDA)){       
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.quitarCuentaOtraMoneda(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"QUITAR CUENTA CON OTRA MONEDA");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"QUITAR CUENTA CON OTRA MONEDA");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//TXT CORREO ELECTRONICO CONTACTO
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_CONTACTO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarCorreoElectronicoContacto( GstrTXT_CORREO_CONTACTO,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(3,"CORREO DE CONTACTO", GstrTXT_CORREO_CONTACTO ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_CORREO_CONTACTO", GstrTXT_CORREO_CONTACTO);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "CORREO DE CONTACTO", GstrTXT_CORREO_CONTACTO ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//TXT TELEFONO CONTACTO
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TELEFONO_CONTACTO)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.ingresarTelefonoContacto( GstrTXT_TELEFONO_CONTACTO,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(3,"TELEFONO DE CONTACTO", GstrTXT_TELEFONO_CONTACTO ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("TXT_TELEFONO_CONTACTO", GstrTXT_TELEFONO_CONTACTO);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "TELEFONO DE CONTACTO", GstrTXT_TELEFONO_CONTACTO ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			/*=================PODERES LEGALES====================*/
			
			//REPRESENTANTE LEGAL -SI
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_PODERES_LEGALES)){       
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarRepresentantePoderLegal(GstrRBT_PODERES_LEGALES,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "SOY REPRESENTANTE LEGAL CON PODERES"+ GstrRBT_PODERES_LEGALES, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "SOY REPRESENTANTE LEGAL CON PODERES"+ GstrRBT_PODERES_LEGALES, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//FIRMAR SIN NECESIDAD DE FIRMAS CONJUNTAS- SI
			if (objFuncionesGenerales.verificarIgnore(GstrRBT_SIN_FIRMAS_CONJUNTAS)){
				CapturarPantalla.pageDown("400");
				strHoraInicio = System.currentTimeMillis();        
				if (objContratosDigitalesMapeo.seleccionarFirmarSinFirmasConjuntas(GstrRBT_SIN_FIRMAS_CONJUNTAS,strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(2, "SOY REPRESENTANTE LEGAL CON PODERES"+ GstrRBT_SIN_FIRMAS_CONJUNTAS, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "SOY REPRESENTANTE LEGAL CON PODERES"+ GstrRBT_SIN_FIRMAS_CONJUNTAS, "" ,"");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//----------------OTRO-------------------------
			Thread.sleep(800);
			CapturarPantalla.scrollCapturaPantalla();
			//----------------OTRO-------------------------
			
			 //BOTON FIRMAR Y GUARDAR
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_FIRMAR_GUARDAR)){
				//CapturarPantalla.pageDown("600");
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.firmaryGuardar(strBtnPagos)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en FIRMAR Y GUARDAR");
					strTipoLog="1";
					objContratosDigitalesMapeo.verificarCargaPantallaConfirmacion(strBtnPagos);
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en FIRMAR Y GUARDAR");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.scrollCapturaPantalla();
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));						
			}
			
			//BOTON FIRMAR Y ENVIAR
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_FIRMAR_ENVIAR)){
				//CapturarPantalla.pageDown("600");
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.firmaryEnviar(strBtnPagos)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en FIRMAR Y ENVIAR");
					strTipoLog="1";
					objContratosDigitalesMapeo.verificarCargaPantallaConfirmacion(strBtnPagos);
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en FIRMAR Y GUARDAR");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.scrollCapturaPantalla();							
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));					
			}
			
			//BOTON GUARDAR
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_GUARDAR)){	
				//CapturarPantalla.pageDown("600");				
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.guardar(strBtnPagos)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en GUARDAR");
					strTipoLog="1";
					objContratosDigitalesMapeo.verificarCargaPantallaConfirmacion(strBtnPagos);
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en GUARDAR");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.scrollCapturaPantalla();
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO_1)){       
//				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );					
//				CapturarPantalla.pageDown("400");
//				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
//				CapturarPantalla.pageDown("600");
//				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				strHoraInicio = System.currentTimeMillis();    
				String valoresIncorrectos=objContratosDigitalesMapeo.verificarPantallaConfirmacion(strBtnPagos);
				if (valoresIncorrectos.equals("")){ 
					objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));					
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_TERMINOS_CONDICIONES)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.verTerminosYCondiciones()){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Términos y Condiciones");
					strTipoLog="1";	
					Thread.sleep(2000);
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Términos y Condiciones");			        
				}	
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_TERMINOS_CONDICIONES)){       
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.cerrarTerminosCondiciones2()){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"CerrarPopup");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"CerrarPopup");
				}
				Thread.sleep(2000);
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_QUIERES_SABER_COMO)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.verQuieresSaberComo()){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"¿Quieres saber como?");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"¿Quieres saber como?");			        
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_QUIERES_SABER_COMO)){       
				strHoraInicio = System.currentTimeMillis();		          
				if (objContratosDigitalesMapeo.cerrarTerminosCondiciones2()){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Cerrar ¿Quieres saber como?");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Cerrar ¿Quieres saber como?");			        
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_ACEPTO_TERMINOS_CONDICIONES)){       
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.aceptarTerminosCondiciones(strBtnPagos)){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Acepto Términos y condiciones");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Acepto Términos y condiciones");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE)){				
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.ingresarClave(GstrTXT_CLAVE)){	
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
			}else{		
				strHoraInicio = System.currentTimeMillis();   
				if(!objFuncionesGenerales.verificarIgnore(strTxtColumnaError)){
					if (objContratosDigitalesMapeo.ingresarClave(Mdl_Variables.Gstr_Clave)){	
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
			}
			
			CapturarPantalla.pageDown("400");
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA,strBtnPagos)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica ", GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica ", GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
	
			//----------------OTRO-------------------------
			Thread.sleep(800);
			CapturarPantalla.scrollCapturaPantalla();
			//----------------OTRO-------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.confirmar(strBtnPagos)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					objContratosDigitalesMapeo.verificarPantallaResultadoEsperado(strBtnPagos);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.scrollCapturaPantalla();
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.cancelarOperacion(strBtnPagos)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACION");
					strTipoLog="1";
					Thread.sleep(600);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACION");
				}
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.scrollCapturaPantalla();
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if(objFuncionesGenerales.verificarIgnore(strTxtColumnaError)){
				String strTexto = objContratosDigitalesMapeo.obtenerMensajeError(strTxtColumnaError);
				if(objFuncionesGenerales.buscarCadena(strTxtMensajeError, strTexto)){	
					objFuncionesGenerales.callPasosAcierto(7, "BPI:  "+strTexto +" Esperado:"+strTxtMensajeError, "" ,"");						
				}else{
					objFuncionesGenerales.callPasosErrado(7, "BPI:  "+strTexto +" Esperado:"+strTxtMensajeError, "" ,"");	
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strResultadoEsperado2)){     
//				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );					
//				CapturarPantalla.pageDown("400");
//				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
//				CapturarPantalla.pageDown("600");
//				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				strHoraInicio = System.currentTimeMillis();    
				String valoresIncorrectos=objContratosDigitalesMapeo.verificarPantallaResultado(strBtnPagos);
				if (valoresIncorrectos.equals("")){ 
					objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
					codigoSolicitud = objContratosDigitalesMapeo.obtenerNumeroDeSolicitud(strBtnPagos);
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
				}
				
				
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			
			
		
			if(blnResultadoEsperado){
				if(strFIRMAR.equals("SI")){					
					
					objHeader.cerrarSesion(Mdl_Variables.Gstr_Click,Mdl_Variables.Gstr_Click);
					
					if (!strFIRMANTE3.equals(Mdl_Variables.Gstr_Ignore)){
						consultar3=true;
					}else if (!strFIRMANTE2.equals(Mdl_Variables.Gstr_Ignore)){
						consultar2=true;
					}else if(!strFIRMANTE1.equals(Mdl_Variables.Gstr_Ignore)){
						consultar1=true;
					}
				
	
					if (objFuncionesGenerales.verificarIgnore(strFIRMANTE1)){
						blnResultadoEsperado=objFirmarBL.firmaContratosDigitales("APP_SOLICITUDES_CONTRATOS_DIGITALES_AUTORIZACION",GstrID_CASO,"F1",consultar1,codigoSolicitud);
					}
	
					if(blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(strFIRMANTE2)){
							blnResultadoEsperado=objFirmarBL.firmaContratosDigitales("APP_SOLICITUDES_CONTRATOS_DIGITALES_AUTORIZACION",GstrID_CASO,"F2",consultar2,codigoSolicitud);
						}
	
						if(blnResultadoEsperado&& objFuncionesGenerales.verificarIgnore(strFIRMANTE3)){
								blnResultadoEsperado=objFirmarBL.firmaContratosDigitales("APP_SOLICITUDES_CONTRATOS_DIGITALES_AUTORIZACION",GstrID_CASO,"F3",consultar3,codigoSolicitud);
						}
					}
				}else{
					ContratosDigitalesAutorizarBE.GstrTXT_SUBMENU1="Pendientes y Enviadas";
					ContratosDigitalesAutorizarBE.GstrIND_EMPRESA=GstrIND_EMPRESA;
					ContratosDigitalesAutorizarBE.GstrCMB_EMPRESA=GstrCMB_NOMBRE_EMPRESA;
					ContratosDigitalesAutorizarBE.GstrLNK_VER_DETALLE=Mdl_Variables.Gstr_Click;
					ContratosDigitalesAutorizarBE.GstrLNK_VER_USUARIOS_CON_ACCESO=Mdl_Variables.Gstr_Ignore;
					ContratosDigitalesAutorizarBE.GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
					ContratosDigitalesAutorizarBE.GstrLNK_VER_USUARIOS2=Mdl_Variables.Gstr_Ignore;
					ContratosDigitalesAutorizarBE.GstrBTN_CERRAR_POPUP_USUARIOS_CON_ACCESOS=Mdl_Variables.Gstr_Ignore;
					ContratosDigitalesAutorizarBE.GstrBTN_CERRAR_DETALLE=Mdl_Variables.Gstr_Click;
					objContratosDigitalesAutorizarBL.ConsultaSolicitud(codigoSolicitud);
					objHeader.cerrarSesion(Mdl_Variables.Gstr_Click,Mdl_Variables.Gstr_Click);
				 }
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
	
	return blnResultadoEsperado;
	}
}