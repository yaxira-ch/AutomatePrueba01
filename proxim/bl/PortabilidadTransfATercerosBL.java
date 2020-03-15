package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ObjetosGenerales;
import proxim.be.TransfATercerosPortabilidadBE;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadTransfATercerosBL extends TransfATercerosPortabilidadBE{
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PortabilidadTransfATercerosMapeo objTransfATercerosPortabilidadMapeo=new PortabilidadTransfATercerosMapeo();
	PortabilidadConsultaSaldosBL objPortabilidadConsultaSaldosBL=new PortabilidadConsultaSaldosBL();
	LoginPortabilidadBL objLoginPortabilidadBL=new LoginPortabilidadBL();
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FirmarBL objTransferenciaFirmanteBL =new FirmarBL();

	
	boolean blnResultadoEsperado=true;
	long LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	String TipoLog ;
	long LStr_HoraInicio;
	boolean consultar1=false;
	boolean consultar2=false;
	boolean consultar3=false;

	String strURLPortabilidad="https://130.30.25.24/bpi-empresas/";
	//String strURLPortabilidad="https://130.30.24.181:9443/bpi-empresas/";
	//String strURLPortabilidad="https://130.30.25.23:9444/bpi-empresas-v3/login";
	
	public boolean realizaEnvio() throws SQLException, IOException{
	blnResultadoEsperado = true;
		try {
			
			objLoginPortabilidadBL.loginPortabilidad(GstrTIE, GstrCLAVE, GstrTXT_CAPCHA, GstrBTN_SIGUIENTE, GstrBTN_SIGUIENTE1);			
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_TRANSFERENCIAS)){
				Thread.sleep(2000);
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfATercerosPortabilidadMapeo.Transferencias()){	
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
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_A_TERCEROS)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfATercerosPortabilidadMapeo.TransferenciaATerceros()){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)&&GstrIND_EMPRESA.equals("NO"))  {		          
				LStr_HoraInicio = System.currentTimeMillis();  		
				if (objTransfATercerosPortabilidadMapeo.seleccionarEmpresa( GstrCMB_EMPRESA)){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));			
		    }
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN)){		          
				LStr_HoraInicio = System.currentTimeMillis(); 
				String strNewCuentaOrigen=  objFuncionesGenerales.newCuenta(GstrCMB_CUENTA_ORIGEN);
				if (objTransfATercerosPortabilidadMapeo.seleccionarCuentaOrigen( strNewCuentaOrigen)){ 
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CUENTA)){		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransfATercerosPortabilidadMapeo.seleccionarTipoCuenta( GstrCMB_TIPO_CUENTA)){ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_TIPO_CUENTA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_TIPO_CUENTA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_CUENTA_DESTINO)){       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransfATercerosPortabilidadMapeo.ingresarNumeroCuentaDestino( GstrTXT_NUMERO_CUENTA_DESTINO)){ 
					objFuncionesGenerales.callPasosAcierto(3,"CORREO DE CONTACTO", GstrTXT_NUMERO_CUENTA_DESTINO ,"");
					TipoLog="1";
					CapturarPantalla.pageDown("400");
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA)){		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransfATercerosPortabilidadMapeo.seleccionarMoneda( GstrCMB_MONEDA)){ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA CON OTRA MONEDA "+ GstrCMB_MONEDA, "" ,"");
					TipoLog="1";
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
				if (objTransfATercerosPortabilidadMapeo.ingresarMonto( GstrTXT_MONTO)){ 
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
				if (objTransfATercerosPortabilidadMapeo.ingresarDescripcionTransferencia( GstrTXT_DESCRIPCION_TRANSFERENCIA)){ 
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
				CapturarPantalla.pageDown("600");
				LStr_HoraInicio = System.currentTimeMillis();   
				if (objTransfATercerosPortabilidadMapeo.continuar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en FIRMAR Y GUARDAR");
					TipoLog="1";
					objTransfATercerosPortabilidadMapeo.validarConfirmacionTransferencia();
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_DETALLE)){
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransfATercerosPortabilidadMapeo.verDetalle()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Ver Detalle");
					TipoLog="1";
					objTransfATercerosPortabilidadMapeo.validarDetalleTransferencia();
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
				if (objTransfATercerosPortabilidadMapeo.regresar()){	
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
				if (objTransfATercerosPortabilidadMapeo.ingresoClave(GstrTXT_CLAVE)){	
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
				if (objTransfATercerosPortabilidadMapeo.ingresoClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
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
				if (objTransfATercerosPortabilidadMapeo.confirmar()){
					objTransfATercerosPortabilidadMapeo.guardarIdTabla();
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
				if (objTransfATercerosPortabilidadMapeo.compararMensajeError(GstrTXT_MENSAJE_ERROR)){	
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
				if (objTransfATercerosPortabilidadMapeo.enviarEmail()){	
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
				if (objTransfATercerosPortabilidadMapeo.ingresarCorreo(GstrTXT_CORREO)){	
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
				if (objTransfATercerosPortabilidadMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_CORREO)){	
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
				if (objTransfATercerosPortabilidadMapeo.enviar()){	
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
				if (objTransfATercerosPortabilidadMapeo.cerrarCorreo()){	
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
			
			objLoginPortabilidadBL.logOffPortabilidad(GstrLNK_CERRAR_SESION) ;
			
			
			if (TransfATercerosPortabilidadBE.GstrFIRMAR.equals("SI")){
				
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
				TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA= "A Terceros";
					
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1)){
						if (GstrFIRMANTE1.equals("PA")){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F1",consultar1);
						}else if (GstrFIRMANTE1.equals("PORT") ){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F1' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a terceros",consultar1,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_TIPO_CUENTA);
						}else if (GstrFIRMANTE1.equals("AP")){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F1","A terceros",consultar1);
						}
					}
										
					if (blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
							if (GstrFIRMANTE2.equals("PA")){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F2",consultar2);
							}else if (GstrFIRMANTE2.equals("PORT")){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F2' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a terceros",consultar2,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_TIPO_CUENTA);
							}else if (GstrFIRMANTE2.equals("AP")){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F2","A terceros",consultar2);
							}
						}
						
						if (blnResultadoEsperado){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
								if (GstrFIRMANTE3.equals("PA")){
									Mdl_Variables.Gstr_Url=strURLPortabilidad;
									blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F3",consultar3);
								}else if (GstrFIRMANTE3.equals("PORT")){
									blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F3' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia a terceros",consultar3,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_TIPO_CUENTA);
								}else if (GstrFIRMANTE3.equals("AP")){
									Mdl_Variables.Gstr_Url=strURLPortabilidad;
									blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F3","A terceros",consultar3);
								}
							}
							
							if(blnResultadoEsperado&& objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia("APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D",GstrID_CASO+"-P","OP",true);
							}
							
						}
					}
					
					
					
					
					
				
			}
		
			
		} catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}		
		return blnResultadoEsperado;	
	}
	
}
