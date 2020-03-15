package proxim.bl;

import java.awt.Robot;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import proxim.be.ConsultaPedidosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaPedidosBL extends ConsultaPedidosBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	ConsultaPedidosMapeo objConsultasyPedidosBE = new ConsultaPedidosMapeo();
	ConsultaPedidosConsulHistoricaBL objConsultasyPedidosConsulHistoricaBL=new ConsultaPedidosConsulHistoricaBL();
	String  strLogUno="1"; 
	String  strLogCero="0"; 
	String strTextoImagen="1. Imagenes";
	
	public boolean consultasyPedidos() throws SQLException, IOException{
		String strTipoLog = null;
		boolean blnResultadoEsperado  = true;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio;	
		Mdl_Variables.map= new HashMap<String,String>();
		String  strCuentas="Cuentas"; 	
		String strAsesoria="Asesoría";
		String  strCadena="\\";
		String  strCadenaPunto="."; 
			
		try {
			
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, "Solicitudes", "Consultas y Pedidos");
			//------------------------------------------------------------------------------		
					
		     if (objFuncionesGenerales.verificarIgnore(strCmbEMPRESA)){       
		    	 strHoraInicio = System.currentTimeMillis();     
		    	 if (objConsultasyPedidosBE.seleccionarEmpresa( strCmbEMPRESA)){ 
		    		 objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ strCmbEMPRESA, "" ,"");
		    		 strTipoLog=strLogUno;
		    		 Mdl_Variables.map.put("GstrCMB_EMPRESA", strCmbEMPRESA);
		    	 }else{
		    		 strTipoLog=strLogCero;
		    		 blnResultadoEsperado  = false;
		    		 objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ strCmbEMPRESA, "" ,"");
		    	 }
		    	 strHoraFin = System.currentTimeMillis(); 
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
		     
		     if (objFuncionesGenerales.verificarIgnore(strCmbPRODUCTO)){       
		    	 objConsultasyPedidosBE.verificarProducto();
		    	 strHoraInicio = System.currentTimeMillis();     
		    	 if (objConsultasyPedidosBE.seleccionarProducto( strCmbPRODUCTO)){ 
		    		 objFuncionesGenerales.callPasosAcierto(2, "PRODUCTO "+ strCmbPRODUCTO, "" ,"");
		    		 strTipoLog=strLogUno;
		    		 Mdl_Variables.map.put("GstrCMB_PRODUCTO", strCmbPRODUCTO);
		    	 }else{
		    		 strTipoLog=strLogCero;
		    		 blnResultadoEsperado  = false;
		    		 objFuncionesGenerales.callPasosErrado(2, "PRODUCTO "+ strCmbPRODUCTO, "" ,"");
		    	 }
		    	 strHoraFin = System.currentTimeMillis(); 
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
		      
		     if (objFuncionesGenerales.verificarIgnore(strCmbPRODUCTO)&& objConsultasyPedidosBE.evaluarInicioPopup("CMB_PRODUCTO",strCmbPRODUCTO))	{
		    	 blnResultadoEsperado  = iniciarPopup("CMB_PRODUCTO");
		      }

		     if (objFuncionesGenerales.verificarIgnore(strCmbTIPO)){       
		    	 strHoraInicio = System.currentTimeMillis();     
		    	 if (objConsultasyPedidosBE.seleccionarTipo( strCmbTIPO)){ 
		    		 objFuncionesGenerales.callPasosAcierto(2, "TIPO "+ strCmbTIPO, "" ,"");
		    		 strTipoLog=strLogUno;
		    		 Mdl_Variables.map.put("GstrCMB_TIPO", strCmbTIPO);
		    	 }else{
		    		 strTipoLog=strLogCero;
		    		 blnResultadoEsperado  = false;
		    		 objFuncionesGenerales.callPasosErrado(2, "TIPO "+ strCmbTIPO, "" ,"");
		    	 }
		    	 strHoraFin = System.currentTimeMillis(); 
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
		      
		     if(!strCmbPRODUCTO.equals(strAsesoria)){
			     if (objFuncionesGenerales.verificarIgnore(strCmbCOMBO)){       
			    	 strHoraInicio = System.currentTimeMillis();    
			    	 if (objConsultasyPedidosBE.comboConData(strCmbCOMBO)){ 
			    		 objFuncionesGenerales.callPasosAcierto(8, strCmbCOMBO+" muestra opciones.", "" ,"");
			    		 strTipoLog=strLogUno;
			    		 Mdl_Variables.map.put("GstrCMB_COMBO", strCmbCOMBO);
			    	 }else{
			    		 strTipoLog=strLogCero;
			    		 blnResultadoEsperado  = false;
			    		 objFuncionesGenerales.callPasosErrado(8, "Error en el combo TIPO", "" ,"");
			    	 }
			    	 strHoraFin = System.currentTimeMillis();  
			    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			     }else{
			    	 strHoraInicio = System.currentTimeMillis();    
			    	 String strMensaje="";
			    	
			    	 if (objConsultasyPedidosBE.comboVerificar(strCmbPRODUCTO)){ 
			    		if(strCmbPRODUCTO.isEmpty()||strCmbPRODUCTO.equals("Elige el tipo de producto")||strCmbPRODUCTO.equals(strCuentas)){
			    			 strMensaje="Se muestra el Combo";
			    		 }else if (strCmbPRODUCTO.equals("Tarifario")||strCmbPRODUCTO.equals("Otros")){
			    			 strMensaje="No se muestra el Combo";
			    		 }
			        	  
			    		 objFuncionesGenerales.callPasosAcierto(8, strMensaje, "" ,"");
			    		 strTipoLog=strLogUno;
			    	 }else{
			    		 if(strCmbPRODUCTO.isEmpty()||strCmbPRODUCTO.equals("Elige el tipo de producto")||strCmbPRODUCTO.equals(strCuentas)){
					     	 strMensaje= "No se muestra el Combo";
			    		 }else if (strCmbPRODUCTO.equals("Tarifario")||strCmbPRODUCTO.equals("Otros")){
			    			 strMensaje="Se muestra el Combo";
			    		 }	   
			    		 strTipoLog=strLogCero;
			    		 blnResultadoEsperado  = false;
			    		 objFuncionesGenerales.callPasosErrado(8, strMensaje, "" ,"");
			    	 }
			    	 strHoraFin = System.currentTimeMillis();  
			    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			     }	
		     }
		     if (objFuncionesGenerales.verificarIgnore(strLnkAQUI)){       
		    	 strHoraInicio = System.currentTimeMillis();    
		    	 if (objConsultasyPedidosBE.ingresoAqui()){ 
		    		 objFuncionesGenerales.callPasosAcierto(1, "", "" ,"AQUI");
		    		 strTipoLog=strLogUno;
		    		 Thread.sleep(25000);
		    	 }else{
		    		 strTipoLog=strLogCero;
		    		 blnResultadoEsperado  = false;
		    		 objFuncionesGenerales.callPasosErrado(1, "", "" ,"AQUI");
		    	 }
		    	 strHoraFin = System.currentTimeMillis();  
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    
		    	 if (Mdl_Variables.Gstr_Aplicativo.toLowerCase().equalsIgnoreCase("chrome")){
		    		 objFuncionesGenerales.irPestanaUno();
		    	 }else{
		    		 objFuncionesGenerales.retornarPestanaPrincipal();
		    	 } 
		    }
		      
		     if (objFuncionesGenerales.verificarIgnore(strCmbTIPO)&& objConsultasyPedidosBE.evaluarInicioPopup("CMB_TIPO",strCmbTIPO))	{
		    	 blnResultadoEsperado  = iniciarPopup("CMB_TIPO");
		     }
		      
		     if (objFuncionesGenerales.verificarIgnore(strLbnCAMPO)&&(strLbnCAMPO.equals("LNB_CONTACTO")||strLbnCAMPO.equals("LBN_LINK"))){  //sprint10      
		    	 strHoraInicio = System.currentTimeMillis();     
		     	if (objConsultasyPedidosBE.comparaMensaje( strLbnMensajeCAMPO,strLbnCAMPO)){ 
		     		objFuncionesGenerales.callPasosAcierto(5, "Valor que se muestra en pantalla ", " el esperado "+strLbnMensajeCAMPO ,"");
		     		strTipoLog=strLogUno;
		     	}else{
		     		strTipoLog=strLogCero;
		     		blnResultadoEsperado  = false;
			        objFuncionesGenerales.callPasosErrado(5, "Valor que se muestra en pantalla ", " el esperado "+strLbnMensajeCAMPO ,"");
		     	}
		     	strHoraFin = System.currentTimeMillis(); 
		     	lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		     	CapturarPantalla.scrollCapturaPantalla();
		     	objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
			     
		      if (objFuncionesGenerales.verificarIgnore(strCmbDOCUMENTO)){       
		    	  strHoraInicio = System.currentTimeMillis();     
		          if (objConsultasyPedidosBE.seleccionarDocumento( strCmbDOCUMENTO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(2, "DOCUMENTO "+ strCmbDOCUMENTO, "" ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrCMB_DOCUMENTO", strCmbDOCUMENTO);
		        	  objConsultasyPedidosBE.ingresoClicDocumento();
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(2, "DOCUMENTO "+ strCmbDOCUMENTO, "" ,"");
		          }
		          strHoraFin = System.currentTimeMillis(); 
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		      if (objFuncionesGenerales.verificarIgnore(strCmbCargoABONO)){       
		    	  strHoraInicio = System.currentTimeMillis();     
		          if (objConsultasyPedidosBE.seleccionarCargoAbono( strCmbCargoABONO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(2, "CARGOABONO "+ strCmbCargoABONO, "" ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrCMB_CARGO_ABONO", strCmbCargoABONO);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(2, "CARGOABONO "+ strCmbCargoABONO, "" ,"");
		          }
		          strHoraFin = System.currentTimeMillis(); 
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		      
		      if (objFuncionesGenerales.verificarIgnore(strCmbDeCUANDO)){       
		    	  strHoraInicio = System.currentTimeMillis();     
		          if (objConsultasyPedidosBE.seleccionarDeCuando( strCmbDeCUANDO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(2, "DE CUANDO "+ strCmbDeCUANDO, "" ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrCMB_DE_CUANDO", strCmbDeCUANDO);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(2, "DE CUANDO "+ strCmbDeCUANDO, "" ,"");
		          }
		          strHoraFin = System.currentTimeMillis(); 
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		      
		      if (objFuncionesGenerales.verificarIgnore(strCmbDeCUANDO)&&objConsultasyPedidosBE.evaluarInicioPopup("CMB_DE_CUANDO",strCmbDeCUANDO))	{
		    	  blnResultadoEsperado  = iniciarPopup("CMB_DE_CUANDO");
		      }

		      if (objFuncionesGenerales.verificarIgnore(strTxtFecha)&&strCmbPRODUCTO.equals(strCuentas)){       
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarFechaOperacion( strTxtFecha,strCmbTIPO,strCmbPRODUCTO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en el FECHA", strTxtFecha ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_FECHA", strTxtFecha);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en el FECHA", strTxtFecha,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		      if (objFuncionesGenerales.verificarIgnore(strTxtNuneroCHEQUE)){//sprint10
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarNumeroCheque( strTxtNuneroCHEQUE)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en el NUMERO DE CHEQUE", strTxtNuneroCHEQUE ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_NUMERO_CHEQUE", strTxtNuneroCHEQUE);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en el NUMERO DE CHEQUE", strTxtNuneroCHEQUE ,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		      if (objFuncionesGenerales.verificarIgnore(strTxtImporte)){//sprint10
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarImporte( strTxtImporte)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en el IMPORTE DE CHEQUE", strTxtImporte ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_IMPORTE", strTxtImporte);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en el IMPORTE DE CHEQUE", strTxtImporte ,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		      if (objFuncionesGenerales.verificarIgnore(strCmbMoneda)){//sprint10
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarMoneda( strCmbMoneda)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en la MONEDA DE CHEQUE", strCmbMoneda ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrCMB_MONEDA", strCmbMoneda);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en la MONEDA DE CHEQUE", strCmbMoneda ,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		     
		      if (objFuncionesGenerales.verificarIgnore(strCmbCUENTA)){       
		    	  strHoraInicio = System.currentTimeMillis();     
		          if (objConsultasyPedidosBE.seleccionarCuenta( strCmbCUENTA)){ 
		        	  objFuncionesGenerales.callPasosAcierto(2, "CUENTA "+ strCmbCUENTA, "" ,"");
		        	  strTipoLog=strLogUno;
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(2, "CUENTA "+ strCmbCUENTA, "" ,"");
		          }
		          strHoraFin = System.currentTimeMillis(); 
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		      
		      /*Inicio Sprint22*/
		      
		      if (objFuncionesGenerales.verificarIgnore(strTxtTieAFECTADA)){
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarTIEAfectada( strTxtTieAFECTADA)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en la TIE AFECTADA", strTxtTieAFECTADA ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_TIE_AFECTADA", strTxtTieAFECTADA);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en la TIE AFECTADA", strTxtTieAFECTADA ,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		      if (objFuncionesGenerales.verificarIgnore(strTxtFecha)&&strCmbPRODUCTO.equals(strAsesoria)){
		    	  strHoraInicio = System.currentTimeMillis();     
		    	  if (objConsultasyPedidosBE.ingresarFechaOperacion( strTxtFecha,"",strCmbPRODUCTO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"la fecha del hecho", strTxtFecha ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_FECHA", strTxtFecha);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "la fecha del hecho", strTxtFecha,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }
		      
		      if (objFuncionesGenerales.verificarIgnore(strCmbModuloWEB)){       
		    	  strHoraInicio = System.currentTimeMillis();     
		    	  if (objConsultasyPedidosBE.seleccionarModuloWeb( strCmbModuloWEB)){ 
		    		  objFuncionesGenerales.callPasosAcierto(2, "MODULO WEB "+ strCmbModuloWEB, "" ,"");
		    		  strTipoLog=strLogUno;
		    		  Mdl_Variables.map.put("GstrCMB_MODULO_WEB", strCmbModuloWEB);

		    	  }else{
		    		  strTipoLog=strLogCero;
		    		  blnResultadoEsperado  = false;
		    		  objFuncionesGenerales.callPasosErrado(2, "MODULO WEB "+ strCmbModuloWEB, "" ,"");
		    	  }
		    	  strHoraFin = System.currentTimeMillis(); 
		    	  lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	  CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	  objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		      
		      /*Fin Sprint22*/
		      CapturarPantalla.pageDown("4000");
		      if (objFuncionesGenerales.verificarIgnore(strTxtCOMENTARIO)){       
		    	  strHoraInicio = System.currentTimeMillis();        
		    	  if (objConsultasyPedidosBE.ingresarComentario( strTxtCOMENTARIO)){ 
		    		  objFuncionesGenerales.callPasosAcierto(3,"en el COMENTARIO", strTxtCOMENTARIO ,"");
		    		  strTipoLog=strLogUno;
		    		  Mdl_Variables.map.put("GstrTXT_COMENTARIO", strTxtCOMENTARIO);
		    	  }else{
		    		  strTipoLog=strLogCero;
		    		  blnResultadoEsperado  = false;
		    		  objFuncionesGenerales.callPasosErrado(3, "en el COMENTARIO", strTxtCOMENTARIO ,"");
		    	  }
		    	  strHoraFin = System.currentTimeMillis();      
		    	  lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	  CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	  objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		      
		     if (objFuncionesGenerales.verificarIgnore(strLnkADJUNTAR)){       
		    	 strHoraInicio = System.currentTimeMillis();     
		    	 if (objConsultasyPedidosBE.seleccionarAdjuntar( )){ 
		    		 objFuncionesGenerales.callPasosAcierto(2, "ADJUNTAR "+ strLnkADJUNTAR, "" ,"");
		    		 strTipoLog=strLogUno;
		    	 }else{
		    		 strTipoLog=strLogCero;
		    		 blnResultadoEsperado  = false;
		    		 objFuncionesGenerales.callPasosErrado(2, "ADJUNTAR "+ strLnkADJUNTAR, "" ,"");
		    	 }
		    	 strHoraFin = System.currentTimeMillis(); 
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
		      
		     if (objFuncionesGenerales.verificarIgnore(strRutaARCHIVO)){	
		    	 strHoraInicio = System.currentTimeMillis();  
		    	 CapturarPantalla.pageDown("4000");
		    	 if (objConsultasyPedidosBE.ingresarRutaTxt(strRutaARCHIVO,strCmbTIPO)){	
		    		 objFuncionesGenerales.callPasosAcierto(3, "La ruta del ARCHIVO, "+strRutaARCHIVO , "" ,  "");
		    		 strTipoLog=strLogUno;
		    		 Mdl_Variables.map.put("GstrRUTA_ARCHIVO", strRutaARCHIVO);
		    	 }else{
		    		 strTipoLog=strLogCero;			
		    		 blnResultadoEsperado  = false;
		    		 objFuncionesGenerales.callPasosErrado(3, "La ruta del ARCHIVO, "+strRutaARCHIVO , "" ,  "");
		    	 }
		    	 strHoraFin = System.currentTimeMillis();      
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     }
		      
		      if (objFuncionesGenerales.verificarIgnore(strTxtCORREO)){                
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarCorreo( strTxtCORREO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en el CORREO", strTxtCORREO ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_CORREO", strTxtCORREO);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en el CORREO", strTxtCORREO ,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		      
		      if (objFuncionesGenerales.verificarIgnore(strTxtTELEFONO)){       
		    	  strHoraInicio = System.currentTimeMillis();        
		          if (objConsultasyPedidosBE.ingresarTelefono( strTxtTELEFONO)){ 
		        	  objFuncionesGenerales.callPasosAcierto(3,"en el TELEFONO", strTxtTELEFONO ,"");
		        	  strTipoLog=strLogUno;
		        	  Mdl_Variables.map.put("GstrTXT_TELEFONO", strTxtTELEFONO);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(3, "en el TELEFONO", strTxtTELEFONO ,"");
		          }
		          strHoraFin = System.currentTimeMillis();      
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 
		    
	
		      //FLUJO ADICIONAL CMB EMPRESA, PRODUCTO Y TIPO
		      if(objFuncionesGenerales.verificarIgnore(strTxtColumnaERROR)){
		    	  
		    	  if (objFuncionesGenerales.verificarIgnore(strCmbEMPRESA)&&strTxtColumnaERROR.equals("CMB_EMPRESA")){		    		 
		    		  strHoraInicio = System.currentTimeMillis();     
			          if (objConsultasyPedidosBE.seleccionarEmpresa("Elige la empresa")){ 
			        	  objFuncionesGenerales.callPasosAcierto(2, "Elige la empresa ", "" ,"");
			        	  strTipoLog=strLogUno;
			          }else{
			        	  strTipoLog=strLogCero;
			        	  blnResultadoEsperado  = false;
			        	  objFuncionesGenerales.callPasosErrado(2, "Elige la empresa ", "" ,"");
			          }
			          strHoraFin = System.currentTimeMillis(); 
			          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    	  } 
		    	  
			      if (objFuncionesGenerales.verificarIgnore(strCmbPRODUCTO)&&strTxtColumnaERROR.equals("CMB_PRODUCTO")){       
			    	  objConsultasyPedidosBE.verificarProducto();
			          strHoraInicio = System.currentTimeMillis();     
			          if (objConsultasyPedidosBE.seleccionarProducto( "Elige el tipo de producto")){ 
			        	  objFuncionesGenerales.callPasosAcierto(2, "Elige el tipo de producto ", "" ,"");
			        	  strTipoLog=strLogUno;
			          }else{
			        	  strTipoLog=strLogCero;
			        	  blnResultadoEsperado  = false;
			        	  objFuncionesGenerales.callPasosErrado(2, "Elige el tipo de producto ", "" ,"");
			          }
			          strHoraFin = System.currentTimeMillis(); 
			          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			      } 
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbTIPO)&&strTxtColumnaERROR.equals("CMB_TIPO")){       
			          strHoraInicio = System.currentTimeMillis();     
			          if (objConsultasyPedidosBE.seleccionarTipo( "Elige el tipo de consulta")){ 
			        	  objFuncionesGenerales.callPasosAcierto(2, "Elige el tipo de consulta ", "" ,"");
			        	  strTipoLog=strLogUno;
			          }else{
			        	  strTipoLog=strLogCero;
			        	  blnResultadoEsperado  = false;
			        	  objFuncionesGenerales.callPasosErrado(2, "Elige el tipo de consulta ", "" ,"");
			          }
			          strHoraFin = System.currentTimeMillis(); 
			          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			      } 
		      }
		      
		      //FIN
		      
		      
		      if (objFuncionesGenerales.verificarIgnore(strBtnENVIAR)){       
		    	  strHoraInicio = System.currentTimeMillis();    
		          if (objConsultasyPedidosBE.ingresoEnviar()){ 
		        	  objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Enviar");
		        	  strTipoLog=strLogUno;
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(1, "", "" ,"Enviar");
		          }
		          strHoraFin = System.currentTimeMillis();  
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      } 	
		      
		      if(objFuncionesGenerales.verificarIgnore(strTxtColumnaERROR)){
		    	  String strTexto = objConsultasyPedidosBE.obtenerMensajeError(strTxtColumnaERROR);
		    	  if(objFuncionesGenerales.buscarCadena(strTxtMensajeERROR, strTexto)){	
		    		  objFuncionesGenerales.callPasosAcierto(7, "BPI:  "+strTexto +" Esperado:"+strTxtMensajeERROR, "" ,"");						
		    	  }else{
		    		  objFuncionesGenerales.callPasosErrado(7, "BPI:  "+strTexto +" Esperado:"+strTxtMensajeERROR, "" ,"");	
		    	  }
		      }		         
		      
		      boolean bResulEsperado = false;
		      if (objFuncionesGenerales.verificarIgnore(strTxtResultadoESPERADO)){       
		    	  strHoraInicio = System.currentTimeMillis();  
		    	  String strTexto = objConsultasyPedidosBE.obtenerResultadoEsperado();      
		          if (strTexto.equals(strTxtResultadoESPERADO)){ 
		        	  bResulEsperado = true;
		        	  objFuncionesGenerales.callPasosAcierto(5,"FRONT : " + strTexto, " DATA :" + strTxtResultadoESPERADO ,"");
		        	  strTipoLog=strLogUno;
		        	  Thread.sleep(2000);
		          }else{
		        	  strTipoLog=strLogCero;
		        	  blnResultadoEsperado  = false;
		        	  objFuncionesGenerales.callPasosErrado(5,"FRONT : " + strTexto, " DATA :" + strTxtResultadoESPERADO ,"");
		          }
		          strHoraFin = System.currentTimeMillis();  
		          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		          CapturarPantalla.scrollCapturaPantalla();
		          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		      }	
		      
		      //VerificarCamposResultado
		      
		      if(bResulEsperado){
		    	  
		    	  if (objFuncionesGenerales.verificarIgnore(strCmbEMPRESA)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_EMPRESA","","");
			    	  if(strTexto.equals(strCmbEMPRESA)){
					        objFuncionesGenerales.callPasosAcierto(7,"EMPRESA--> FRONT : " + strTexto +" Esperado :" + strCmbEMPRESA,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"EMPRESA--> FRONT : " + strTexto +" Esperado :" + strCmbEMPRESA,"","");
				       }
			      }
		    	  
			      if (objFuncionesGenerales.verificarIgnore(strCmbPRODUCTO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_PRODUCTO","","");
			    	  if(strTexto.equals(strCmbPRODUCTO)){
					        objFuncionesGenerales.callPasosAcierto(7,"PRODUCTO--> FRONT : " + strTexto+ " Esperado :" + strCmbPRODUCTO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"PRODUCTO--> FRONT : " + strTexto+" Esperado :" + strCmbPRODUCTO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtCOMENTARIO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_COMENTARIO","","");
			    	  strTexto= strTexto.replaceAll("\"", "");
			    	  if(strTexto.equals(strTxtCOMENTARIO)){
					        objFuncionesGenerales.callPasosAcierto(7,"COMENTARIO--> FRONT : " + strTexto+ " Esperado :" + strTxtCOMENTARIO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"COMENTARIO--> FRONT : " + strTexto+" Esperado :" + strTxtCOMENTARIO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strRutaARCHIVO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("RUTA_ARCHIVO",strCmbTIPO,"");
			    	  String strTextoBD = strRutaARCHIVO.substring(strRutaARCHIVO.lastIndexOf(strCadena)+1,strRutaARCHIVO.length());
			    	  if(strTexto.equals(strTextoBD)){//Pendiente sacar solo el nombre
					        objFuncionesGenerales.callPasosAcierto(7,"RUTA DEL ARCHIVO--> FRONT : " + strTexto+ " Esperado :" + strRutaARCHIVO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"RUTA DEL ARCHIVO--> FRONT : " + strTexto+" Esperado :" + strRutaARCHIVO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtCORREO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_CORREO","","");
			    	  if(strTexto.equals(strTxtCORREO)){
					        objFuncionesGenerales.callPasosAcierto(7,"CORREO--> FRONT : " + strTexto+ " Esperado :" + strTxtCORREO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"CORREO--> FRONT : " + strTexto+" Esperado :" + strTxtCORREO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtTELEFONO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_TELEFONO","","");
			    	  if(strTexto.equals(strTxtTELEFONO)){
					        objFuncionesGenerales.callPasosAcierto(7,"TELEFONO--> FRONT : " + strTexto+ " Esperado :" + strTxtTELEFONO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"TELEFONO--> FRONT : " + strTexto+" Esperado :" + strTxtTELEFONO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbTIPO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_TIPO","","");
			    	  if(strTexto.equals(strCmbTIPO)){
					        objFuncionesGenerales.callPasosAcierto(7,"TIPO--> FRONT : " + strTexto+ " Esperado :" + strCmbTIPO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"TIPO--> FRONT : " + strTexto+" Esperado :" + strCmbTIPO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbCargoABONO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_CARGO_ABONO","","");
			    	  if(strTexto.equals(strCmbCargoABONO)){
					        objFuncionesGenerales.callPasosAcierto(7,"CARGO ABONO--> FRONT : " + strTexto+ " Esperado :" + strCmbCargoABONO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"CARGO ABONO--> FRONT : " + strTexto+" Esperado :" + strCmbCargoABONO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbDOCUMENTO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_DOCUMENTO","","");
			    	  if(strTexto.equals(strCmbDOCUMENTO)){
					        objFuncionesGenerales.callPasosAcierto(7,"DOCUMENTO--> FRONT : " + strTexto+ " Esperado :" + strCmbDOCUMENTO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"DOCUMENTO--> FRONT : " + strTexto+" Esperado :" + strCmbDOCUMENTO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbDeCUANDO)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_DE_CUANDO","","");
			    	  if(strTexto.equals(strCmbDeCUANDO)){
					        objFuncionesGenerales.callPasosAcierto(7,"DE CUANDO--> FRONT : " + strTexto+ " Esperado :" + strCmbDeCUANDO,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"DE CUANDO--> FRONT : " + strTexto+" Esperado :" + strCmbDeCUANDO,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtNuneroCHEQUE)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_NUMERO_CHEQUE","","");
			    	  if(strTexto.equals(strTxtNuneroCHEQUE)){
					        objFuncionesGenerales.callPasosAcierto(7,"NUMERO DE CHEQUE--> FRONT : " + strTexto+ " Esperado :" + strTxtNuneroCHEQUE,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"NUMERO DE CHEQUE--> FRONT : " + strTexto+" Esperado :" + strTxtNuneroCHEQUE,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtImporte) ||objFuncionesGenerales.verificarIgnore(strCmbMoneda)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_IMPORTE","","");  
			    	  String moneda="";
			    	  String monto="";
			    	  
			    	  if(strTexto.contains("Soles")){
			    		  moneda="Soles";
			    		  monto=strTexto.substring(0, strTexto.indexOf("S")-1);
			    	  }else{
			    		  moneda="Dólares";
			    		  monto=strTexto.substring(0, strTexto.indexOf("D")-1);
			    	  }	

			    	  if (objFuncionesGenerales.verificarIgnore(strCmbMoneda)) {				    	  		    	  
			    		  if(moneda.equals(strCmbMoneda)){
			    			  objFuncionesGenerales.callPasosAcierto(7,"MONEDA DE CHEQUE--> FRONT : " + moneda+ " Esperado :" + strCmbMoneda,"","");
			    			  strTipoLog=strLogUno;
			    		  }else{
			    			  strTipoLog=strLogCero;
			    			  blnResultadoEsperado  = false;
			    			  objFuncionesGenerales.callPasosErrado(7,"MONEDA DE CHEQUE--> FRONT : " + moneda+" Esperado :" + strCmbMoneda,"","");
			    		  }
			    	  }
			    	  
			    	  if (objFuncionesGenerales.verificarIgnore(strTxtImporte)){
			    		  String montoBD=strTxtImporte;
			    		  if(montoBD.indexOf(strCadenaPunto)!=-1){
			    			  int decimales=(montoBD.substring(montoBD.indexOf(strCadenaPunto)+1,montoBD.length())).length();
			    			  if(decimales==1)
			    				  montoBD=montoBD+strLogCero;
			    		  		}else
			    		  		montoBD=montoBD+".00";
			    	  		if(monto.equals(montoBD)){
			    	  			objFuncionesGenerales.callPasosAcierto(7,"IMPORTE CHEQUE--> FRONT : " + monto+ " Esperado :" + montoBD,"","");
						        strTipoLog=strLogUno;
			    	  		}else{
			    	  			strTipoLog=strLogCero;
						        blnResultadoEsperado  = false;
						        objFuncionesGenerales.callPasosErrado(7,"IMPORTE CHEQUE--> FRONT : " + monto+" Esperado :" + montoBD,"","");
			    	  		}
			    	  	}
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbCUENTA)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_CUENTA","","");
			    	  if(strTexto.equals(strCmbCUENTA)){
			    		  objFuncionesGenerales.callPasosAcierto(7,"CUENTA--> FRONT : " + strTexto+ " Esperado :" + strCmbCUENTA,"","");
			    		  strTipoLog=strLogUno;
			    	  }else{
			    		  strTipoLog=strLogCero;
			    		  blnResultadoEsperado  = false;
			    		  objFuncionesGenerales.callPasosErrado(7,"CUENTA--> FRONT : " + strTexto+" Esperado :" + strCmbCUENTA,"","");
			    	  }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strCmbModuloWEB)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("CMB_MODULO_WEB","","");
			    	  if(strTexto.equals(strCmbModuloWEB)){
					        objFuncionesGenerales.callPasosAcierto(7,"MODULO WEB--> FRONT : " + strTexto+ " Esperado :" + strCmbModuloWEB,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"MODULO WEB--> FRONT : " + strTexto+" Esperado :" + strCmbModuloWEB,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtTieAFECTADA)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_TIE_AFECTADA","","");
			    	  String strNewTie=objConsultasyPedidosBE.obtenerCamposret(strTxtTieAFECTADA) ;
			    	  if(strTexto.equals(strNewTie)){
					        objFuncionesGenerales.callPasosAcierto(7,"TIE AFECTADA--> FRONT : " + strTexto+ " Esperado :" + strTxtTieAFECTADA,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"TIE AFECTADA--> FRONT : " + strTexto+" Esperado :" + strTxtTieAFECTADA,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strTxtFecha)){
			    	  String strTexto =objConsultasyPedidosBE.obtenerCamposDeResultado("TXT_FECHA",strCmbTIPO,strCmbPRODUCTO);
			    	  if(strTexto.equals(strTxtFecha)){
					        objFuncionesGenerales.callPasosAcierto(7,"FECHA --> FRONT : " + strTexto+ " Esperado :" + strTxtFecha,"","");
					        strTipoLog=strLogUno;
				       }else{
					        strTipoLog=strLogCero;
					        blnResultadoEsperado  = false;
					        objFuncionesGenerales.callPasosErrado(7,"FECHA --> FRONT : " + strTexto+" Esperado :" + strTxtFecha,"","");
				       }
			      }
			      
			      if (objFuncionesGenerales.verificarIgnore(strBtnNuevaCONSULTA)){                 
			    	  strHoraInicio = System.currentTimeMillis();    
			          if (objConsultasyPedidosBE.ingresoBotonNuevaConsulta()){ 
			        	  objFuncionesGenerales.callPasosAcierto(1, "", "" ,"BotonNuevaConsulta");
			        	  strTipoLog=strLogUno;
			          }else{
			        	  strTipoLog=strLogCero;
			        	  blnResultadoEsperado  = false;
			        	  objFuncionesGenerales.callPasosErrado(1, "", "" ,"BotonNuevaConsulta");
			          }
			          strHoraFin = System.currentTimeMillis();  
			          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			      } 
		      }

		      blnResultadoEsperado  = objConsultasyPedidosConsulHistoricaBL.consultasyPedidos();
		      objHeader.cerrarSesion(Mdl_Variables.Gstr_Click,Mdl_Variables.Gstr_Click);
		     
		}catch (Exception e) {
			blnResultadoEsperado  = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", strLogCero, Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado ;
	}


	//-------------------------------------FUNCION POPUP-------------------------------------------------------------

	private boolean iniciarPopup(String strObjeto) {
		boolean blnResultadoEsperado  = true;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio;	
		boolean ban=false;
		String strTipoLog = null;
		
		try {
			
	      if (objFuncionesGenerales.verificarIgnore(strTxtTituloPOPUP)){       
	    	  String strTexto = objConsultasyPedidosBE.obtenerTituloPopup();      
	          if (strTexto.equals(strTxtTituloPOPUP)){ 
	        	  objFuncionesGenerales.callPasosAcierto(5,"FRONT : " + strTexto, " DATA :" + strTxtTituloPOPUP ,"");
	        	  strTipoLog=strLogUno;
	          }else{
	        	  strTipoLog=strLogCero;
	        	  blnResultadoEsperado  = false;
	        	  objFuncionesGenerales.callPasosErrado(5,"FRONT : " + strTexto, " DATA :" + strTxtTituloPOPUP ,"");
	          }
	          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	      } 
	      
	      if (objFuncionesGenerales.verificarIgnore(strBtnCerrarPOPUP)){       
	    	  strHoraInicio = System.currentTimeMillis();   
	          Thread.sleep(5000);
	          if (objConsultasyPedidosBE.ingresoCerrarPopup()){ 
	        	  objFuncionesGenerales.callPasosAcierto(1, "", "" ,"CerrarPopup");
	        	  strTipoLog=strLogUno;
	          }else{
	        	  strTipoLog=strLogCero;
	        	  blnResultadoEsperado  = false;
	        	  objFuncionesGenerales.callPasosErrado(1, "", "" ,"CerrarPopup");
	          }
	          strHoraFin = System.currentTimeMillis();  
	          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	      } 
	      
	      if (objFuncionesGenerales.verificarIgnore(strLnkAquiPOPUP)){       
	    	  strHoraInicio = System.currentTimeMillis();    
	          if (objConsultasyPedidosBE.ingresoAquiPopup()){ 
	        	  Thread.sleep(5000);
	        	  objFuncionesGenerales.callPasosAcierto(1, "", "" ,"AquiPopup");
	        	  strTipoLog=strLogUno;
	          }else{
	        	  strTipoLog=strLogCero;
	        	  blnResultadoEsperado  = false;
	        	  objFuncionesGenerales.callPasosErrado(1, "", "" ,"AquiPopup");
	          }
	          strHoraFin = System.currentTimeMillis();  
	          lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	          objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	      }
	      
	      if (objFuncionesGenerales.verificarIgnore(strTxtTituloREDIRECCION)){       
	    	  String strTexto = objConsultasyPedidosBE.obtenerTituloRedireccion(strObjeto);      
	          if (strTexto.equals(strTxtTituloREDIRECCION)){ 
	        	  ban=true;
	        	  objFuncionesGenerales.callPasosAcierto(5,"FRONT : " + strTexto, " DATA :" + strTxtTituloREDIRECCION ,"");
	        	  strTipoLog=strLogUno;
	          }else{
	        	  strTipoLog=strLogCero;
	        	  blnResultadoEsperado  = false;
	        	  objFuncionesGenerales.callPasosErrado(5,"FRONT : " + strTexto, " DATA :" + strTxtTituloREDIRECCION ,"");
	          }
	          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	      }
	     
	      if(strObjeto.equals("CMB_PRODUCTO")&&ban){
	    	  Robot robot=new Robot();
	    	  robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL); 
	    	  robot.keyPress(java.awt.event.KeyEvent.VK_W);
	      }
	     
		}catch (Exception e) {
			blnResultadoEsperado  = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", strLogCero, Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado ;
	}
}
	
