package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.ObjetosGenerales;
import proxim.be.TransfOtrosBancosCCEPortabilidadBE;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;


public class PortabilidadTransfOtrosBancosCCEBL extends TransfOtrosBancosCCEPortabilidadBE{
	
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PortabilidadTransfOtrosBancosCCEMapeo objTransfOtrosBancosCCEPortabilidadMapeo=new PortabilidadTransfOtrosBancosCCEMapeo();
	PortabilidadConsultaSaldosBL objPortabilidadConsultaSaldosBL=new PortabilidadConsultaSaldosBL();
	LoginPortabilidadBL objLoginPortabilidadBL=new LoginPortabilidadBL();
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FirmarBL objTransferenciaFirmanteBL =new FirmarBL();
	PortabilidadMapeo objPortabilidadAutorizacionesPendientesBE = new PortabilidadMapeo();
	
	boolean blnResultadoEsperado=true;
	long LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	String TipoLog ;
	long LStr_HoraInicio;
	boolean consultar1=false;
	boolean consultar2=false;
	boolean consultar3=false;
	String strURLPortabilidad="https://130.30.25.24/bpi-empresas/";
	int pasos=0;
	
	public boolean realizaEnvio() throws SQLException, IOException{
		blnResultadoEsperado=true;
		
		try {
		
			objLoginPortabilidadBL.loginPortabilidad(GstrTIE, GstrCLAVE, GstrTXT_CAPCHA, GstrBTN_SIGUIENTE, GstrBTN_SIGUIENTE1);	
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_TRANSFERENCIAS)){
				Thread.sleep(2000);
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.Transferencias()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Transferencia");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Transferencia");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				Thread.sleep(500);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_A_OTROS_BANCOS_CCE)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.TransferenciaAOtrosBancosCCE()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Transferencia");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Transferencia");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				Thread.sleep(500);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN)&&GstrIND_EMPRESA.equals("NO"))  {		          
				LStr_HoraInicio = System.currentTimeMillis();  		
				if (objTransfOtrosBancosCCEPortabilidadMapeo.listarEmpresas()){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
					TipoLog="1";
					Thread.sleep(1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
		    }
			
				objTransfOtrosBancosCCEPortabilidadMapeo.clickVacio();
		
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN)&&GstrIND_EMPRESA.equals("NO"))  {		          
				LStr_HoraInicio = System.currentTimeMillis();  		
				if (objTransfOtrosBancosCCEPortabilidadMapeo.seleccionarEmpresa( GstrCMB_EMPRESA_CUENTA_ORIGEN)){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN))  {		          
				LStr_HoraInicio = System.currentTimeMillis();  		
				if (objTransfOtrosBancosCCEPortabilidadMapeo.listarCuentas()){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_CUENTA_ORIGEN, "" ,"");
					TipoLog="1";
					Thread.sleep(1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_CUENTA_ORIGEN, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
		    }
			
			objTransfOtrosBancosCCEPortabilidadMapeo.clickVacio();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN)){		          
				LStr_HoraInicio = System.currentTimeMillis(); 
				String strNewCuentaOrigen=  objFuncionesGenerales.newCuenta(GstrCMB_CUENTA_ORIGEN);
				if (objTransfOtrosBancosCCEPortabilidadMapeo.seleccionarCuentaOrigen( strNewCuentaOrigen)){ 
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE ORIGEN, "+strNewCuentaOrigen, "" ,"");
					TipoLog="1";
					Thread.sleep(800);
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DE ORIGEN, "+strNewCuentaOrigen, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_CUENTA_DESTINO)){       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarNumeroCuentaDestino( GstrTXT_NUMERO_CUENTA_DESTINO)){ 
					objFuncionesGenerales.callPasosAcierto(3,"CORREO DE CONTACTO", GstrTXT_NUMERO_CUENTA_DESTINO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "CORREO DE CONTACTO", GstrTXT_NUMERO_CUENTA_DESTINO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_EMPRESA_PROPIETARIA)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objTransfOtrosBancosCCEPortabilidadMapeo.checkEmpresaPropietaria()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"En la empresa es propietaria de la cuenta.");
					TipoLog="1";
					Thread.sleep(2000);
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"En la empresa es propietaria de la cuenta.");
				}
				LStr_HoraFin =  System.currentTimeMillis();   
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_EMPRESA)){       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarNombreEmpresa( GstrTXT_NOMBRE_EMPRESA)){ 
					objFuncionesGenerales.callPasosAcierto(3,"NOMBRE DE LA EMPRESA", GstrTXT_NOMBRE_EMPRESA ,"");
					TipoLog="1";
					CapturarPantalla.pageDown("600");
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "NOMBRE DE LA EMPRESA", GstrTXT_NOMBRE_EMPRESA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			/*if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DOCUMENTO_IDENTIDAD))  {		          
				LStr_HoraInicio = System.currentTimeMillis();  		
				if (objTransfOtrosBancosCCEPortabilidadMapeo.listarTipoDocumentos()){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_TIPO_DOCUMENTO_IDENTIDAD, "" ,"");
					TipoLog="1";
					Thread.sleep(1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_TIPO_DOCUMENTO_IDENTIDAD, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
		    }*/
			
			//objTransfOtrosBancosCCEPortabilidadMapeo.clickVacio();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DOCUMENTO_IDENTIDAD)){		          
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objTransfOtrosBancosCCEPortabilidadMapeo.seleccionarTipoDocumentoIdentidad( GstrCMB_TIPO_DOCUMENTO_IDENTIDAD)){ 
					objFuncionesGenerales.callPasosAcierto(2, "de TIPO DE DOCUMENTO, "+GstrCMB_TIPO_DOCUMENTO_IDENTIDAD, "" ,"");
					TipoLog="1";
					CapturarPantalla.pageDown("600");
					Thread.sleep(800);
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de TIPO DE DOCUMENTO, "+GstrCMB_TIPO_DOCUMENTO_IDENTIDAD, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_IDENTIDAD)){       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarDocumentoIdentidad(GstrTXT_NUMERO_IDENTIDAD)){ 
					objFuncionesGenerales.callPasosAcierto(3,"NUMERO DE DOCUMENTO", GstrTXT_NUMERO_IDENTIDAD ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE DOCUMENTO", GstrTXT_NUMERO_IDENTIDAD ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			/*if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))  {		          
				LStr_HoraInicio = System.currentTimeMillis();  		
				CapturarPantalla.pageDown("600");
				if (objTransfOtrosBancosCCEPortabilidadMapeo.listarTipoMoneda()){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
					TipoLog="1";
					Thread.sleep(1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
		    } */
			
			//objTransfOtrosBancosCCEPortabilidadMapeo.clickVacio();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA)){		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransfOtrosBancosCCEPortabilidadMapeo.seleccionarMoneda( GstrCMB_MONEDA)){ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_MONEDA, "" ,"");
					TipoLog="1";
					CapturarPantalla.pageDown("600");
					
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_MONEDA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO)){       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarMonto( GstrTXT_MONTO)){ 
					objFuncionesGenerales.callPasosAcierto(3,"CORREO DE CONTACTO", GstrTXT_MONTO ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "CORREO DE CONTACTO", GstrTXT_MONTO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DESCRIPCION_TRANSFERENCIA)){       
				LStr_HoraInicio = System.currentTimeMillis();
				CapturarPantalla.pageDown("400");
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarDescripcionTransferencia( GstrTXT_DESCRIPCION_TRANSFERENCIA)){ 
					objFuncionesGenerales.callPasosAcierto(3,"CORREO DE CONTACTO", GstrTXT_DESCRIPCION_TRANSFERENCIA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "CORREO DE CONTACTO", GstrTXT_DESCRIPCION_TRANSFERENCIA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR)){
				Thread.sleep(2000);
				LStr_HoraInicio = System.currentTimeMillis();   
				if (objTransfOtrosBancosCCEPortabilidadMapeo.continuar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en FIRMAR Y GUARDAR");
					TipoLog="1";
					Thread.sleep(2000);
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en FIRMAR Y GUARDAR");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));						
			}

			if (!objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN)&&GstrIND_EMPRESA.equals("NO") || !objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN)){
			CapturarPantalla.pageDown("-400");
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_DETALLE)){
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.verDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Ver Detalle");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Ver Detalle");
				}
				Thread.sleep(2000);
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR)){	
				Thread.sleep(2000);
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.regresar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Ver Detalle");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Ver Detalle");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE)){
				Thread.sleep(2000);
				CapturarPantalla.pageDown("400");
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresoClave(GstrTXT_CLAVE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA, ", GstrTXT_CLAVE,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA, ", GstrTXT_CLAVE,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				CapturarPantalla.pageDown("400");
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresoClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA, ", GstrTXT_CLAVE_DINAMICA,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA, ", GstrTXT_CLAVE_DINAMICA,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){
				CapturarPantalla.pageDown("600");
				LStr_HoraInicio = System.currentTimeMillis();   
				if (objTransfOtrosBancosCCEPortabilidadMapeo.confirmar()){
					objTransfOtrosBancosCCEPortabilidadMapeo.guardarIdTabla();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en FIRMAR Y GUARDAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en FIRMAR Y GUARDAR");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.pageDown("500");
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));						
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				CapturarPantalla.pageDown("400");
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.compararMensajeError(GstrTXT_MENSAJE_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"se compara mensaje de ERROR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"se compara mensaje de ERROR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_EMAIL)){
				Thread.sleep(2000);
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.enviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL");
				}
		
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarCorreo(GstrTXT_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El correo ", GstrTXT_CORREO,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El correo ", GstrTXT_CORREO,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_CORREO)){	
					objFuncionesGenerales.callPasosAcierto(3, "El mensaje del coreo ", GstrTXT_MENSAJE_CORREO,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El mensaje del coreo ", GstrTXT_MENSAJE_CORREO,"");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.enviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL");
				}
		
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_CORREO)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfOtrosBancosCCEPortabilidadMapeo.cerrarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL");
				}
		
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			////Si_hay_firmantes
			
			if (TransfOtrosBancosCCEPortabilidadBE.GstrFIRMAR.equals("SI")){
				
				objLoginPortabilidadBL.logOffPortabilidad(GstrLNK_CERRAR_SESION) ;
				
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
				
				String strTablaAutorizarTransferencias="APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D";
				String strTablaAutorizarPortabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
				String strTablaAutorizarPendientes="APP_AND_AUTORIZACIONES_PENDIENTES_D";
				TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA= "A otros Bancos CCE";
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))
				{
					if (GstrFIRMANTE1.equals("PA")){
						Mdl_Variables.Gstr_Url=strURLPortabilidad;
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F1",consultar1);
					}else if (GstrFIRMANTE1.equals("PORT") ){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F1' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos CCE",consultar1,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_TIPO_CUENTA);
					}else if (GstrFIRMANTE1.equals("AP")){
						Mdl_Variables.Gstr_Url=strURLPortabilidad;
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F1","A otros Bancos CCE",consultar1);
					}
					
				}
				
				if (blnResultadoEsperado){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
						if (GstrFIRMANTE2.equals("PA")){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F2",consultar2);
						}else if (GstrFIRMANTE2.equals("PORT")){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F2' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos CCE",consultar2,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_TIPO_CUENTA);
						}else if (GstrFIRMANTE2.equals("AP")){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F2","A otros Bancos CCE",consultar2);
						}
					}
					
					if (blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
							if (GstrFIRMANTE3.equals("PA")){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F3",consultar3);
							}else if (GstrFIRMANTE3.equals("PORT")){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F3' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a otros Bancos CCE",consultar3,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_TIPO_CUENTA);
							}else if (GstrFIRMANTE3.equals("AP")){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F3","A otros Bancos CCE",consultar3);
							}
						}
						
						if(blnResultadoEsperado&& objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
							Mdl_Variables.Gstr_Url="https://130.30.25.24/bpi-empresas/";
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",GstrID_CASO+"-P","OP",true);
						}
						
					}
				}
				
				
				
			}
			else
			/////si no hay firmantes
			{
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONSULTA_HISTORICA)){//Consulta historica
				if (objFuncionesGenerales.verificarIgnore("CLICK")){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonHome()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón HOME");
						TipoLog="1";
						Thread.sleep(1800);
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón HOME");
					}
					LStr_HoraFin = System.currentTimeMillis();	  	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					Thread.sleep(1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore("CLICK")){	
					LStr_HoraInicio = System.currentTimeMillis();	  
					if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonHistorial()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón HISTORIAL");
						TipoLog="1";
						Thread.sleep(1800);
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón HISTORIAL");
					}
					LStr_HoraFin = System.currentTimeMillis();	  	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				String strXpathBoton = "";
				if (objFuncionesGenerales.verificarIgnore("CLICK")){
					LStr_HoraInicio = System.currentTimeMillis();	
					strXpathBoton=objPortabilidadAutorizacionesPendientesBE.buscarAutorizacion("Transferencias",GstrTXT_DESCRIPCION_TRANSFERENCIA,GstrESTADO,GstrTXT_MONTO,1);
					if (!strXpathBoton.equals("")){	
						objFuncionesGenerales.callPasosAcierto(6, "Existe la Operación en el listado", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "Existe la Operación en el listado", "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (!strXpathBoton.equals("")){	
					
						LStr_HoraInicio = System.currentTimeMillis();	 
						if (objPortabilidadAutorizacionesPendientesBE.ingresarDetalleHistorico(strXpathBoton,1)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"ver Detalle Transferencia");
							TipoLog="1";
							Thread.sleep(500);
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"ver Detalle Transferencia");
						}  
						LStr_HoraFin = System.currentTimeMillis();	  	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						CapturarPantalla.pageDown("600");
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));	
				}
			
				}
				
			/*	if(objFuncionesGenerales.verificarIgnore(GstrBTN_CONSULTA_SALDOS)) { //Consulta de saldos
					
					if (objFuncionesGenerales.verificarIgnore("CLICK")){	
						LStr_HoraInicio = System.currentTimeMillis();	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonHome()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón HOME");
							TipoLog="1";
							Thread.sleep(1800);
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón HOME");
						}
						LStr_HoraFin = System.currentTimeMillis();	  	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
					
					if (objFuncionesGenerales.verificarIgnore("CLICK")){	
						LStr_HoraInicio = System.currentTimeMillis();	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoConsultaSaldos()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONSULTA DE SALDOS");
							TipoLog="1";
							Thread.sleep(1800);
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONSULTA DE SALDOS");
						}
						LStr_HoraFin = System.currentTimeMillis();	  	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN)&&GstrIND_EMPRESA.equals("NO"))  {		          
						LStr_HoraInicio = System.currentTimeMillis();  		
						if (objTransfOtrosBancosCCEPortabilidadMapeo.seleccionarEmpresaConsultaSaldo( GstrCMB_EMPRESA_CUENTA_ORIGEN)){ 
							objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
							TipoLog="1";
							Thread.sleep(600);
						}else{
							TipoLog="0";
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA_CUENTA_ORIGEN, "" ,"");
						}
						LStr_HoraFin = System.currentTimeMillis(); 
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
				    }
					
					String strXpathBoton = "";
					if (objFuncionesGenerales.verificarIgnore("CLICK")){
						LStr_HoraInicio = System.currentTimeMillis();	
						strXpathBoton=objPortabilidadAutorizacionesPendientesBE.buscarCuenta(GstrCMB_CUENTA_ORIGEN, GstrCMB_EMPRESA_CUENTA_ORIGEN);
						if (!strXpathBoton.equals("")){	
							objFuncionesGenerales.callPasosAcierto(6, "Existe la Operación en el listado", "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(6, "Existe la Operación en el listado", "" ,"");
						}
						LStr_HoraFin = System.currentTimeMillis();	  	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
					
					if (!strXpathBoton.equals("")){	
						
						LStr_HoraInicio = System.currentTimeMillis();	 
						if (objPortabilidadAutorizacionesPendientesBE.ingresarConsultaSaldosCuenta(strXpathBoton)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"ver Detalle Transferencia de saldo");
							TipoLog="1";
							Thread.sleep(500);
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"ver Detalle Transferencia de saldo");
						}  
						LStr_HoraFin = System.currentTimeMillis();	  	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						CapturarPantalla.pageDown("600");
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));	
				}
					
					
					
					
				} */
				
				objLoginPortabilidadBL.logOffPortabilidad(GstrLNK_CERRAR_SESION) ;
		}
			
		

		}
		catch(Exception e){
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
		
		
		
		
		return blnResultadoEsperado;	
	}

}
