package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ConsultaRecaudacionBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaRecaudacionBL extends ConsultaRecaudacionBE {

	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConsultaRecaudacionMapeo objConsultaRecaudacionBE=new ConsultaRecaudacionMapeo();
	ConsultaRecaudacionBE objConsulRecaudacionBE=new ConsultaRecaudacionBE();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	
	String cadena;
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean consultaRecaudacion(int intVariable) throws SQLException, IOException{
		String strTipoLog = null;
		boolean bandera = true;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio;	
		strHoraInicio = System.currentTimeMillis(); 
		String strCodNomDeudor=null;
		String strTexto=null;
		boolean existeRegistro=false;
		boolean existeRegistro1=false;
		boolean blnExisteEmpresa=false;
		String strValorI="";
		int intValorNumero;
		int intValorNum = 0;
		
		if(intVariable==2){
			cadena="select ID_CASOPAGO,LST_EMPRESA,CMB_SERVICIO,TXT_CODIGO_DEUDOR,CMB_TIPO_CONSULTA,CMB_FILTRADO_POR,CMB_DEUDOR,"
					+ "TXT_NOMBRE_DEUDOR,TXT_FECHA_PAGO_DESDE,TXT_FECHA_PAGO_HASTA,LNK_ENVIAR_EMAIL_CON_HIS,TXT_CORREO_CON_HIS,TXT_MENSAJE_CORREO_CON_HIS,"
					+ "BTN_ENVIAR_CORREO_CON_HIS,BTN_ACEPTAR_CORREO_CON_HIS,LNK_ENVIAR_TEXTO_CON_HIS,LNK_EXPORTAR_EXCEL_CON_HIS,LNK_EXPORTAR_PDF_CON_HIS,"
					+ "LNK_IMPRIMIR_CON_HIS,LNK_ENVIAR_EMAIL_CH_DETALLE,TXT_CORREO_CH_DETALLE,TXT_MENSAJE_CORREO_CH_DETALLE,BTN_ENVIAR_CORREO_CH_DETALLE,"
					+ "BTN_ACEPTAR_CORREO_CH_DETALLE,LNK_EXPORTAR_EXCEL_CH_DETALLE,LNK_EXPORTAR_PDF_CH_DETALLE,LNK_IMPRIMIR_CH_DETALLE,BUSCAR_DEUDOR,"
					+ "LNK_REGRESAR,LNK_NUMERO_OPERACION,BTN_BUSCAR_CONSULTA,CMB_SERVICIO_RECAUDACION,TXT_MONTO_PAGAR,LNK_REGRESAR_DETALLE,"
					+ "LNK_ENVIAR_EMAIL_TOTAL_DIAS,TXT_CORREO_TOTAL_DIAS,TXT_MENSAJE_CORREO_TOTAL_DIAS,BTN_ENVIAR_CORREO_TOTAL_DIAS,"
					+ "BTN_ACEPTAR_CORREO_TOTAL_DIAS,LNK_EXPORTAR_EXCEL_TOTAL_DIAS,LNK_EXPORTAR_PDF_TOTAL_DIAS,LNK_IMPRIMIR_TOTAL_DIAS "
					+ "from APP_PAGOS_RECIBOS_DETALLE_D where ID_CASOPAGO= "+Mdl_Variables.Gint_IdCaso
					+ "group by ID_CASOPAGO,LST_EMPRESA,CMB_SERVICIO,TXT_CODIGO_DEUDOR,CMB_TIPO_CONSULTA,CMB_FILTRADO_POR,CMB_DEUDOR,TXT_NOMBRE_DEUDOR,"
					+ "TXT_FECHA_PAGO_DESDE,TXT_FECHA_PAGO_HASTA,LNK_ENVIAR_EMAIL_CON_HIS,TXT_CORREO_CON_HIS,TXT_MENSAJE_CORREO_CON_HIS,"
					+ "BTN_ENVIAR_CORREO_CON_HIS,BTN_ACEPTAR_CORREO_CON_HIS,LNK_ENVIAR_TEXTO_CON_HIS,LNK_EXPORTAR_EXCEL_CON_HIS,LNK_EXPORTAR_PDF_CON_HIS,"
					+ "LNK_IMPRIMIR_CON_HIS,LNK_ENVIAR_EMAIL_CH_DETALLE,TXT_CORREO_CH_DETALLE,TXT_MENSAJE_CORREO_CH_DETALLE,BTN_ENVIAR_CORREO_CH_DETALLE,"
					+ "BTN_ACEPTAR_CORREO_CH_DETALLE,LNK_EXPORTAR_EXCEL_CH_DETALLE,LNK_EXPORTAR_PDF_CH_DETALLE,LNK_IMPRIMIR_CH_DETALLE,BUSCAR_DEUDOR,"
					+ "LNK_REGRESAR,LNK_NUMERO_OPERACION,BTN_BUSCAR_CONSULTA,CMB_SERVICIO_RECAUDACION,TXT_MONTO_PAGAR,LNK_REGRESAR_DETALLE,"
					+ "LNK_ENVIAR_EMAIL_TOTAL_DIAS,TXT_CORREO_TOTAL_DIAS,TXT_MENSAJE_CORREO_TOTAL_DIAS,BTN_ENVIAR_CORREO_TOTAL_DIAS,"
					+ "BTN_ACEPTAR_CORREO_TOTAL_DIAS,LNK_EXPORTAR_EXCEL_TOTAL_DIAS,LNK_EXPORTAR_PDF_TOTAL_DIAS,LNK_IMPRIMIR_TOTAL_DIAS";
		}else if (intVariable==1){
			cadena="select * from  APP_CONSULTA_RECAUDACION_D where id_caso="+ConsultaRecaudacionBE.GstrID_CASO;
		}
		objSQL.listaTablaIdCaso(cadena,"",5);//Captura todos los valores del detalle del caso
		
		
		try{
		
			objHeader.menuPrincipal( "<IGNORE>",GstrTXT_MENU, GstrTXT_SUBMENU);
			
			objConsultaRecaudacionBE.verificarCamposObligatoriosCH();
			
			if(GstrTXT_SUBMENU1.equals("Consulta Histórica")){
				while (Mdl_Variables.Grst_NuevaTabla.next()) {
					
					bandera = objConsulRecaudacionBE.obtenerCamposBD( Mdl_Variables.Grst_NuevaTabla,intVariable);
	    			if(bandera){
	    				Thread.sleep(2000);
	    				if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA )){	
	    					
	    					strHoraInicio = System.currentTimeMillis();	  
	    					if (objConsultaRecaudacionBE.seleccionarEmpresaTotalDias(GstrCMB_EMPRESA )){	
	    						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
	    						strTipoLog="1";
	    						Thread.sleep(1000);
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA, "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_SERVICIO))	{		
	    					strHoraInicio = System.currentTimeMillis();
	    					if (objConsultaRecaudacionBE.seleccionarServicioRecaudacion(GstrCMB_TIPO_SERVICIO))	{	
	    						objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO "+GstrCMB_TIPO_SERVICIO , "" ,  "");
	    						strTipoLog="1";
	    						Thread.sleep(1000);
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(2, "del SERVICIO "+GstrCMB_TIPO_SERVICIO , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CONSULTA)){		
	    					strHoraInicio = System.currentTimeMillis();
	    					if (objConsultaRecaudacionBE.seleccionarTipoConsulta(GstrCMB_TIPO_CONSULTA)){	
	    						objFuncionesGenerales.callPasosAcierto(2, "del Tipo de Consulta "+GstrCMB_TIPO_CONSULTA , "" ,  "");
	    						strTipoLog="1";
	    						Thread.sleep(1000);
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(2, "del Tipo de Consulta "+GstrCMB_TIPO_CONSULTA, "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if(GstrCMB_TIPO_CONSULTA.equals("Pagos en línea")){
		    				if (objFuncionesGenerales.verificarIgnore(GstrCMB_FILTAR_POR)) 	{		
		    					strHoraInicio = System.currentTimeMillis();
		    					if (objConsultaRecaudacionBE.seleccionarFiltradoPor(GstrCMB_FILTAR_POR))		    					{	
		    						objFuncionesGenerales.callPasosAcierto(2, "del Filtrado Por "+GstrCMB_FILTAR_POR , "" ,  "");
		    						strTipoLog="1";
		    						Thread.sleep(1000);
		    					}else{
		    						strTipoLog="0";		
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(2, "del Filtrado Por "+GstrCMB_FILTAR_POR, "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if(GstrCMB_FILTAR_POR.equals("Código Deudor")){
			    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CODIGO_DEUDOR)){		
			    					strHoraInicio = System.currentTimeMillis();
			    					if (objConsultaRecaudacionBE.ingresarCodigoDeudor(GstrTXT_CODIGO_DEUDOR)){	
			    						objFuncionesGenerales.callPasosAcierto(2, "del Código deudor "+GstrTXT_CODIGO_DEUDOR , "" ,  "");
			    						strTipoLog="1";
			    					}else{
			    						strTipoLog="0";		
			    						bandera = false;
			    						objFuncionesGenerales.callPasosErrado(2, "del Código deudor "+GstrTXT_CODIGO_DEUDOR , "" ,  "");
			    					}
			    					strHoraFin = System.currentTimeMillis();	  
			    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			    				}
		    				}
	    				}else{
	    					
	    					if (objFuncionesGenerales.verificarIgnore(GstrCMB_DEUDOR )){		
		    					strHoraInicio = System.currentTimeMillis();
		    					if (objConsultaRecaudacionBE.seleccionarDeudor(GstrCMB_DEUDOR )){	
		    						objFuncionesGenerales.callPasosAcierto(2, "del Deudor "+GstrCMB_DEUDOR  , "" ,  "");
		    						strTipoLog="1";
		    						Thread.sleep(1000);
		    						if(GstrCMB_DEUDOR.equals("Código Deudor")){
		    							strCodNomDeudor=GstrTXT_CODIGO_DEUDOR;
			    						strTexto="del Código deudor ";
		    						}else if(GstrCMB_DEUDOR.equals("Nombre deudor")){
		    							strCodNomDeudor=GstrTXT_NOMBRE_DEUDOR;
			    						strTexto="del Nombre del deudor ";
		    						}
		    					}else{
		    						strTipoLog="0";		
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(2, "del Deudor "+GstrCMB_DEUDOR, "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
	    					
	    					if(objFuncionesGenerales.verificarIgnore(GstrCMB_DEUDOR )&& !GstrCMB_DEUDOR.equals("<IGNORE>")){
		    					if (objFuncionesGenerales.verificarIgnore(strCodNomDeudor)){		
			    					strHoraInicio = System.currentTimeMillis();
			    					if (objConsultaRecaudacionBE.ingresarCodNomDeudor(strCodNomDeudor)){	
			    						objFuncionesGenerales.callPasosAcierto(2, strTexto+strCodNomDeudor , "" ,  "");
			    						strTipoLog="1";
			    					}else{
			    						strTipoLog="0";		
			    						bandera = false;
			    						objFuncionesGenerales.callPasosErrado(2, strTexto+strCodNomDeudor , "" ,  "");
			    					}
			    					strHoraFin = System.currentTimeMillis();	  
			    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			    				}
	    					}
	    				
	    					if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_PAGO_DESDE)){		
		    					strHoraInicio = System.currentTimeMillis();
		    					if (objConsultaRecaudacionBE.ingresarFechaPagoDesde(GstrTXT_FECHA_PAGO_DESDE)){	
		    						objFuncionesGenerales.callPasosAcierto(2, "de la Fecha de Pago Desde "+GstrTXT_FECHA_PAGO_DESDE , "" ,  "");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";		
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(2, "de la Fecha de Pago Desde "+GstrTXT_FECHA_PAGO_DESDE , "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
	    					
	    					if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_PAGO_HASTA))		    				{		
		    					strHoraInicio = System.currentTimeMillis();
		    					if (objConsultaRecaudacionBE.ingresarFechaPagoHasta(GstrTXT_FECHA_PAGO_HASTA))
		    					{	
		    						objFuncionesGenerales.callPasosAcierto(2, "de la Fecha de Pago Hasta "+GstrTXT_FECHA_PAGO_HASTA , "" ,  "");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";		
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(2, "de la Fecha de Pago Hasta "+GstrTXT_FECHA_PAGO_HASTA , "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
	    				}
	    				long lngHoraInicio=0;
	    				long lngResultado=0;
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){		
	    					strHoraInicio = System.currentTimeMillis();
	    					if (objConsultaRecaudacionBE.ingresarBotonBuscar()){	
	    						lngHoraInicio = System.currentTimeMillis();
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
	    						strTipoLog="1";
	    						
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.scrollCapturaPantalla();
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				//Tiempo en que carga la grilla de resultado
	    				long llngTiempoTotal;
	    				if(lngHoraInicio!=0){
	    					llngTiempoTotal= objFuncionesGenerales.tiempoTotal(lngHoraInicio,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[5]/div/div/table");
	    					
	    					if (llngTiempoTotal<=60){	
	    						objFuncionesGenerales.callPasosAcierto(8, "Tiempo que toma en cargar la grilla es menor a 60"+Long.valueOf(lngResultado), "" ,"");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosAcierto(8, "Tiempo que toma en cargar la grilla es mayor a 60"+Long.valueOf(lngResultado), "" ,"");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.scrollCapturaPantalla();
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    			
	    				}
	    				
	    				
	    				int numero;
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrRECORRER_PAGINACION))	    				{	
	    					numero=objConsultaRecaudacionBE.totalPaginacion();
	    					}else{
	    					numero=0;
	    				}
	    				
	    				for(int i=2;i<=numero;i++){
	    		    		if(i>=23){
	    		    			intValorNumero=objConsultaRecaudacionBE.totalPaginacion();
	    		    		}else{
	    		    			intValorNumero=i;
	    		    		}
	    		    		
	    					if (objConsultaRecaudacionBE.ingresoLinkPaginacion(intValorNumero)){	
	    						lngHoraInicio = System.currentTimeMillis();
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la paginacion "+ i);
	    						llngTiempoTotal= objFuncionesGenerales.tiempoTotal(lngHoraInicio,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[5]/div/div/table");
		    					
		    					if (llngTiempoTotal<=60){	
		    						objFuncionesGenerales.callPasosAcierto(8, "Tiempo que toma en cargar la grilla es menor a 60"+Long.valueOf(lngResultado), "" ,"");
		    					}else{
		    						bandera = false;
		    						objFuncionesGenerales.callPasosAcierto(8, "Tiempo que toma en cargar la grilla es mayor a 60"+Long.valueOf(lngResultado), "" ,"");
		    					}
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la paginacion "+ i);
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.scrollCapturaPantalla();
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    		    		
	    		    		if(i>=10 && i<22){
	    		    			intValorNum=intValorNumero+1;
	    					}else if (i>=22) {
	    						intValorNum=objConsultaRecaudacionBE.totalPaginacion();
		    				}
	    		    		
	    		    		if(i>=10 ){
		    		    		strValorI=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[2]/a["+intValorNum+"]");
				    			
		    		    		if(strValorI.equals("Siguiente")){
		    		    			numero=numero+1;
			    				}else{
			    					numero=numero-1;
			    				}
	    		    		}		
	    				}
	    				//Exportables
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkEnviarEmailConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO))	{	
	    					strHoraInicio = System.currentTimeMillis(); 	
	    					if (objConsultaRecaudacionBE.ingresarCorreoConsultaHistorica( GstrTXT_CORREO))	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 	
	    					if (objConsultaRecaudacionBE.ingresarMensajeCorreoTotalDiasDetalle( GstrTXT_MENSAJE_CORREO))	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoBotonEnviarTotalDiasDetalle()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO ))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					objConsultaRecaudacionBE.verificarMensajeCorreoResumenTotalDiasDetalle();
	    					if (objConsultaRecaudacionBE.ingresoBotonAceptarCorreoConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_TEXTO ))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkExportarTextoConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar a Texto");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar a Texto");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkExportarExcelConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkExportarPDFConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkImprimirConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_NUMERO_OPERACION))	    				{	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					existeRegistro=objConsultaRecaudacionBE.buscarDeudor(GstrLNK_NUMERO_OPERACION);
	    					if (existeRegistro){	
	    						objFuncionesGenerales.callPasosAcierto(8, " buscar Deudor.", "" ,"");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(8, " buscar Deudor.", "" ,"");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if(existeRegistro){

	    					if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){	
		    					strHoraInicio = System.currentTimeMillis();
		    					if (objConsultaRecaudacionBE.verificarGrilla(GstrLNK_NUMERO_OPERACION)){	
		    						objFuncionesGenerales.callPasosAcierto(8, "Buscar Registro", "" ,"");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";		
		    						bandera = false;
		    						objFuncionesGenerales.callPasosAcierto(8, "Buscar Registro", "" ,"");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.scrollCapturaPantalla();
		    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	        				}
	    				
	    					if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_DETALLE)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkEnviarEmailConsultaHistoricaDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 	
		    					if (objConsultaRecaudacionBE.ingresarCorreoConsultaHistorica( GstrTXT_CORREO_DETALLE))
		    					{	
		    						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 	
		    					if (objConsultaRecaudacionBE.ingresarMensajeCorreoTotalDiasDetalle( GstrTXT_MENSAJE_CORREO_DETALLE))
		    					{	
		    						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoBotonEnviarTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_DETALLE ))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					objConsultaRecaudacionBE.verificarMensajeCorreoResumenTotalDiasDetalle();
		    					if (objConsultaRecaudacionBE.ingresoBotonAceptarCorreoConsultaHistorica()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkExportarExcelConsultaHistoricaDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkExportarPDFConsultaHistoricaDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkImprimirConsultaHistoricaDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_REGRESAR))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkRegresar()){	
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Regresar");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Regresar");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				//verificar codigo no necesesario
		    				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_DETALLE))		    				{	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkRegresarTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Regresar Detalle");
		    						strTipoLog="1";
		    						objConsultaRecaudacionBE.verificarDetalleResumenTotalDias();
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Regresar Detalle");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
	    				}
	    			}
				}
			}else{
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
					strHoraInicio = System.currentTimeMillis();	  
					if (objConsultaRecaudacionBE.seleccionarTabConsultaRecaudacion(GstrTXT_SUBMENU1)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
						strTipoLog="1";
					}else{
						strTipoLog="0";								
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					}
					strHoraFin = System.currentTimeMillis();	  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				while (Mdl_Variables.Grst_NuevaTabla.next()) {
					
					bandera = objConsulRecaudacionBE.obtenerCamposBD( Mdl_Variables.Grst_NuevaTabla,intVariable);
	    			if(bandera){

	    				if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){	
	    					
	    					strHoraInicio = System.currentTimeMillis();	  
	    					if (objConsultaRecaudacionBE.seleccionarEmpresaTotalDias(GstrCMB_EMPRESA)){	
	    						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA  , "" ,  "");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_SERVICIO)){		
	    					strHoraInicio = System.currentTimeMillis();
	    					if (objConsultaRecaudacionBE.seleccionarServicioTotalDias(GstrCMB_TIPO_SERVICIO)){	
	    						objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO "+GstrCMB_TIPO_SERVICIO , "" ,  "");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(2, "del SERVICIO "+GstrCMB_TIPO_SERVICIO , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){		
	    					strHoraInicio = System.currentTimeMillis();
	    					if (objConsultaRecaudacionBE.ingresarBotonBuscarTotalDias()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
	    						strTipoLog="1";
	    						objConsultaRecaudacionBE.verificarTablaTotalDias();
	    					}else{
	    						strTipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.scrollCapturaPantalla();
	    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkEnviarEmailResumenTotalDias()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO)){	
	    					strHoraInicio = System.currentTimeMillis(); 	
	    					if (objConsultaRecaudacionBE.ingresarCorreoConsultaHistorica( GstrTXT_CORREO)){	
	    						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO)){	
	    					strHoraInicio = System.currentTimeMillis(); 	
	    					if (objConsultaRecaudacionBE.ingresarMensajeCorreoTotalDiasDetalle( GstrTXT_MENSAJE_CORREO)){	
	    						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO)){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoBotonEnviarTotalDiasDetalle()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO )){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					objConsultaRecaudacionBE.verificarMensajeCorreoResumenTotalDiasDetalle();
	    					if (objConsultaRecaudacionBE.ingresoBotonAceptarCorreoConsultaHistorica()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF)){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkExportarExcelResumenTotalDias()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF)){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkExportarPDFResumenTotalDias()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				

	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR )){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					if (objConsultaRecaudacionBE.ingresoLinkImprimirResumenTotalDias()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    					    				
	    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_NUMERO_OPERACION)){	
	    					strHoraInicio = System.currentTimeMillis(); 
	    					existeRegistro1=objConsultaRecaudacionBE.buscarDeudorResumenTotalDias();
	    					if (existeRegistro1){	
	    						objFuncionesGenerales.callPasosAcierto(8, " buscar Deudor.", "" ,"");
	    						strTipoLog="1";
	    					}else{
	    						strTipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(8, " buscar Deudor.", "" ,"");
	    					}
	    					strHoraFin = System.currentTimeMillis();	  
	    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	    				}
	    				
	    				if(existeRegistro1){

	    					if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){	
		    					strHoraInicio = System.currentTimeMillis();
		    					if (objConsultaRecaudacionBE.buscarDeudorGrillaResumenTotalDias()){	
		    						objFuncionesGenerales.callPasosAcierto(8, "Click Fecha de Pago.", "" ,"");
		    						strTipoLog="1";
		    						blnExisteEmpresa=true;
		    						objConsultaRecaudacionBE.verificarDetalleResumenTotalDias();
		    					}else{
		    						strTipoLog="0";		
		    						bandera = false;
		    						objFuncionesGenerales.callPasosAcierto(8, "Click Fecha de Pago.", "" ,"");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.scrollCapturaPantalla();
		    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
	        				}
	    				
		    				if(blnExisteEmpresa){
		    					
		    					if (objFuncionesGenerales.verificarIgnore( Mdl_Variables.Gstr_Click)){	
			    					strHoraInicio = System.currentTimeMillis(); 
			    					existeRegistro=objConsultaRecaudacionBE.buscarDeudorTotalDias(GstrLNK_NUMERO_OPERACION);
			    					if (existeRegistro){	
			    						objFuncionesGenerales.callPasosAcierto(8, " Buscar Codigo Deudor "+GstrTXT_CODIGO_DEUDOR, "" ,"");
			    						strTipoLog="1";
			    					}else{
			    						strTipoLog="0";			
			    						bandera = false;
			    						objFuncionesGenerales.callPasosErrado(8, " Buscar Codigo Deudor "+GstrTXT_CODIGO_DEUDOR, "" ,"");
			    					}
			    					strHoraFin = System.currentTimeMillis();	  
			    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			    				}
			    				
			    				if(existeRegistro){
			    					if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){	
				    					strHoraInicio = System.currentTimeMillis();
				    					if (objConsultaRecaudacionBE.verificarGrillaTotalesDia(GstrLNK_NUMERO_OPERACION)){	
				    						objFuncionesGenerales.callPasosAcierto(8, "Click en Codigo Deudor "+GstrTXT_CODIGO_DEUDOR, "" ,"");
				    						strTipoLog="1";
				    						objConsultaRecaudacionBE.verificarResumenTotalDias();
				    					}else{
				    						strTipoLog="0";		
				    						bandera = false;
				    						objFuncionesGenerales.callPasosAcierto(8, "Click en Codigo Deudor "+GstrTXT_CODIGO_DEUDOR, "" ,"");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.scrollCapturaPantalla();
				    					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			        				}
			    							    					
			    		
		    				
			    					if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					if (objConsultaRecaudacionBE.ingresoLinkEnviarEmailResumenTotalDiasDetalle()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 	
				    					if (objConsultaRecaudacionBE.ingresarCorreoConsultaHistorica( GstrTXT_CORREO_DETALLE)){	
				    						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_DETALLE , "" ,  "");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 	
				    					if (objConsultaRecaudacionBE.ingresarMensajeCorreoTotalDiasDetalle( GstrTXT_MENSAJE_CORREO_DETALLE)){	
				    						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_DETALLE , "" ,  "");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					if (objConsultaRecaudacionBE.ingresoBotonEnviarTotalDiasDetalle()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_DETALLE )){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					objConsultaRecaudacionBE.verificarMensajeCorreoResumenTotalDiasDetalle();
				    					if (objConsultaRecaudacionBE.ingresoBotonAceptarCorreoConsultaHistorica()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					if (objConsultaRecaudacionBE.ingresoLinkExportarExcelResumenTotalDiasDetalle()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					if (objConsultaRecaudacionBE.ingresoLinkExportarPDFResumenTotalDiasDetalle()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					if (objConsultaRecaudacionBE.ingresoLinkImprimirResumenTotalDiasDetalle()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
				    						strTipoLog="1";
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
				    				
				    				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_DETALLE)){	
				    					strHoraInicio = System.currentTimeMillis(); 
				    					if (objConsultaRecaudacionBE.ingresoLinkRegresarTotalDiasDetalle()){	
				    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Regresar Detalle");
				    						strTipoLog="1";
				    						objConsultaRecaudacionBE.verificarDetalleResumenTotalDias();
				    					}else{
				    						strTipoLog="0";			
				    						bandera = false;
				    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Regresar Detalle");
				    					}
				    					strHoraFin = System.currentTimeMillis();	  
				    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				    				}
			    				}
		    					
		    					
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkEnviarEmailTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 	
		    					if (objConsultaRecaudacionBE.ingresarCorreoConsultaHistorica( GstrTXT_CORREO_TOTAL_DIAS)){	
		    						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_TOTAL_DIAS , "" ,  "");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_TOTAL_DIAS , "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 	
		    					if (objConsultaRecaudacionBE.ingresarMensajeCorreoTotalDiasDetalle( GstrTXT_MENSAJE_CORREO_TOTAL_DIAS)){	
		    						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_TOTAL_DIAS , "" ,  "");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO_TOTAL_DIAS , "" ,  "");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoBotonEnviarTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_TOTAL_DIAS )){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					objConsultaRecaudacionBE.verificarMensajeCorreoResumenTotalDiasDetalle();
		    					if (objConsultaRecaudacionBE.ingresoBotonAceptarCorreoConsultaHistorica()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkExportarExcelTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkExportarPDFTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_TOTAL_DIAS)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkImprimirTotalDiasDetalle()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
		    						strTipoLog="1";
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
		    				
		    				if (objFuncionesGenerales.verificarIgnore( GstrLNK_REGRESAR)){	
		    					strHoraInicio = System.currentTimeMillis(); 
		    					if (objConsultaRecaudacionBE.ingresoLinkRegresarTotalDiasDetalle1()){	
		    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Regresar Codigo Deudor");
		    						strTipoLog="1";
		    						objConsultaRecaudacionBE.verificarTablaTotalDias();
		    					}else{
		    						strTipoLog="0";			
		    						bandera = false;
		    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Regresar Codigo Deudor");	
		    					}
		    					strHoraFin = System.currentTimeMillis();	  
		    	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		    				}
	    				}
	    				
	    			}
				}

			}

		}catch (Exception e) {
			bandera = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
}
