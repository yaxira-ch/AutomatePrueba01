package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ContratosDigitalesAutorizarBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ContratosDigitalesAutorizarBL extends ContratosDigitalesAutorizarBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ContratosDigitalesMapeo objContratosDigitalesMapeo = new ContratosDigitalesMapeo();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();//validar más adelante si se hará uso
	boolean blnResultadoEsperado;
	HeaderBL objHeader = new HeaderBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	String strTexto;
	String strTipoLog = null;
	long strHoraFin;
	long strHoraInicio;	
	long lngTiempoEjeCaso;
	String strTextoImagen="1. Imagenes";
	boolean bandera = true;
	
	//MODIFICAR
	public boolean contratosDigitalesAutorizar(Boolean consultar,String codigoSolicitud) throws SQLException, IOException{
		try {
			bandera=ConsultaSolicitud(codigoSolicitud);
			if(bandera){
			
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_SELECCIONAR_REGISTRO)){	
					CapturarPantalla.pageDown("600");
					strHoraInicio = System.currentTimeMillis();	  
					if (objContratosDigitalesMapeo.seleccionarSolicitud(codigoSolicitud)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Registro");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Registro");
					}
					strHoraFin = System.currentTimeMillis();	  
	    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRBT_AGREGAR_FIRMA_SOLICITUD_SI)){
					Thread.sleep(1000);
					strHoraInicio = System.currentTimeMillis();        
					if (objContratosDigitalesMapeo.agregarFirmaSolicitudSi()){ 
						objFuncionesGenerales.callPasosAcierto(2, "DESEO AGREGAR MI FIRMA A LA SOLICITUD"+ GstrRBT_AGREGAR_FIRMA_SOLICITUD_SI, "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "DESEO AGREGAR MI FIRMA A LA SOLICITUD"+ GstrRBT_AGREGAR_FIRMA_SOLICITUD_SI, "" ,"");
					}
					strHoraFin = System.currentTimeMillis();      
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI)){ 
					Thread.sleep(1000);
					strHoraInicio = System.currentTimeMillis();        
					if (objContratosDigitalesMapeo.seleccionarSolicitudTieneFirmasNecesariasSi()){ 
						objFuncionesGenerales.callPasosAcierto(2, "LA SOLICITUD TIENE FIRMAS NECESARIAS"+ GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI, "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "LA SOLICITUD TIENE FIRMAS NECESARIAS"+ GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_SI, "" ,"");
					}
					strHoraFin = System.currentTimeMillis();      
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO)){       
					strHoraInicio = System.currentTimeMillis();        
					if (objContratosDigitalesMapeo.seleccionarSolicitudTieneFirmasNecesariasNo()){ 
						objFuncionesGenerales.callPasosAcierto(2, "LA SOLICITUD TIENE FIRMAS NECESARIAS"+ GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO, "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "LA SOLICITUD TIENE FIRMAS NECESARIAS"+ GstrRBT_SOLICITUD_TIENE_FIRMAS_NECESARIAS_NO, "" ,"");
					}
					strHoraFin = System.currentTimeMillis();      
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRBT_AGREGAR_FIRMA_SOLICITUD_NO)){       
					strHoraInicio = System.currentTimeMillis();        
					if (objContratosDigitalesMapeo.agregarFirmaSolicitudNo()){ 
						objFuncionesGenerales.callPasosAcierto(2, "DESEO AGREGAR MI FIRMA A LA SOLICITUD"+ GstrRBT_AGREGAR_FIRMA_SOLICITUD_NO, "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "DESEO AGREGAR MI FIRMA A LA SOLICITUD"+ GstrRBT_AGREGAR_FIRMA_SOLICITUD_NO, "" ,"");
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
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_FIRMAR_Y_ENVIAR)){       
					strHoraInicio = System.currentTimeMillis();  
					if (objContratosDigitalesMapeo.firmarEnviar()){ 
						objFuncionesGenerales.callPasosAcierto(1,"", "" ,"FIRMAR Y ENVIAR");
						strTipoLog="1";
						objContratosDigitalesMapeo.verificarPantallaConfirmacionAutorizacion();
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"FIRMAR Y ENVIAR");
					}
					strHoraFin = System.currentTimeMillis();      
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.scrollCapturaPantalla();
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_FIRMAR_Y_GUARDAR)){       
					strHoraInicio = System.currentTimeMillis();  
					if (objContratosDigitalesMapeo.firmarGuardar()){ 
						objFuncionesGenerales.callPasosAcierto(1,"", "" ,"FIRMAR Y GUARDAR");
						strTipoLog="1";
						objContratosDigitalesMapeo.verificarPantallaConfirmacionAutorizacion();
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"FIRMAR Y GUARDAR");
					}
					strHoraFin = System.currentTimeMillis();      
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.scrollCapturaPantalla();
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR)){       
					strHoraInicio = System.currentTimeMillis();  
					if (objContratosDigitalesMapeo.enviar()){ 
						objFuncionesGenerales.callPasosAcierto(1,"", "" ,"ENVIAR");
						strTipoLog="1";
						objContratosDigitalesMapeo.verificarPantallaConfirmacionAutorizacion();
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"ENVIAR");
					}
					strHoraFin = System.currentTimeMillis();      
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.scrollCapturaPantalla();
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO1)){       
//					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );					
//					CapturarPantalla.pageDown("400");
//					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
//					CapturarPantalla.pageDown("600");
//					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					strHoraInicio = System.currentTimeMillis();    
					String valoresIncorrectos=objContratosDigitalesMapeo.verificarPantallaConfirmacion(strBtnPago);
					if (valoresIncorrectos.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
					}
					strHoraFin = System.currentTimeMillis();  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.scrollCapturaPantalla();
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));					
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_TERMINOS_CONDICIONES)){       
					strHoraInicio = System.currentTimeMillis();    
					if (objContratosDigitalesMapeo.verTerminosCondiciones2()){ 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Términos y Condiciones");
						strTipoLog="1";	
					}else{
						strTipoLog="0";
						bandera = false;
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
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"CerrarPopup");
					}
					Thread.sleep(2000);
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
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"Cerrar ¿Quieres saber como?");			        
					}
					strHoraFin = System.currentTimeMillis();  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_ACEPTO_TERMINOS_CONDICIONES)){       
					strHoraInicio = System.currentTimeMillis();   
					if (objContratosDigitalesMapeo.aceptarTerminosCondiciones2(strBtnPago)){ 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Acepto Términos y condiciones");
						strTipoLog="1";
					}else{
						strTipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"Acepto Términos y condiciones");
					}
					strHoraFin = System.currentTimeMillis();  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE)){				
					strHoraInicio = System.currentTimeMillis();   
					if (objContratosDigitalesMapeo.ingresarClave2(GstrTXT_CLAVE)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					}
					strHoraFin = System.currentTimeMillis();  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}else{		
					strHoraInicio = System.currentTimeMillis();   
					if(!objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR)){
						if (objContratosDigitalesMapeo.ingresarClave2(Mdl_Variables.Gstr_Clave)){	
							objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
							strTipoLog="1";
						}else{
							strTipoLog="0";									
							bandera = false;
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
					if (objContratosDigitalesMapeo.ingresarClaveDinamica2(GstrTXT_CLAVE_DINAMICA,strBtnPago)){	
						objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica ", GstrTXT_CLAVE_DINAMICA,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						bandera = false;
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
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR_OPERACION)){	
					strHoraInicio = System.currentTimeMillis();  
					if (objContratosDigitalesMapeo.confirmar2(strBtnPago)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
					}
					strHoraFin = System.currentTimeMillis();  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.scrollCapturaPantalla();
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
					strHoraInicio = System.currentTimeMillis();  
					if (objContratosDigitalesMapeo.cancelarOperacion2()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACION");
						strTipoLog="1";
						Thread.sleep(600);
					}else{
						strTipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACION");
					}
					strHoraFin = System.currentTimeMillis();  
					lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
					CapturarPantalla.scrollCapturaPantalla();
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
				}
				
				if(objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR)){
					String strTexto = objContratosDigitalesMapeo.obtenerMensajeError(GstrTXT_COLUMNA_ERROR);
					if(objFuncionesGenerales.buscarCadena(GstrTXT_MENSAJE_ERROR, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "BPI:  "+strTexto +" Esperado:"+GstrTXT_MENSAJE_ERROR, "" ,"");						
					}else{
						objFuncionesGenerales.callPasosErrado(7, "BPI:  "+strTexto +" Esperado:"+GstrTXT_MENSAJE_ERROR, "" ,"");	
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO2)){     
//					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );					
//					CapturarPantalla.pageDown("400");
//					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
//					CapturarPantalla.pageDown("600");
//					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					strHoraInicio = System.currentTimeMillis();    
					String valoresIncorrectos=objContratosDigitalesMapeo.verificarPantallaResultado(strBtnPago);
					if (valoresIncorrectos.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						codigoSolicitud = objContratosDigitalesMapeo.obtenerNumeroDeSolicitud(strBtnPago);
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
			
				if(consultar){
					ConsultaSolicitud(codigoSolicitud);
				}
			}
			objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);

		}catch (Exception e) {
			bandera = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
	
	public boolean ConsultaSolicitud(String codigoSolicitud){
		try {
			
			objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, "Solicitudes", "Contratos Digitales");
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
				objContratosDigitalesMapeo.verificarPestania();
				strHoraInicio = System.currentTimeMillis();	  
				if (objContratosDigitalesMapeo.seleccionarSubMenu2(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					strTipoLog="1";
					objContratosDigitalesMapeo.verificarPestania();
				}else{
					strTipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
				}
				strHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			//---------------------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrIND_EMPRESA)&&
					GstrIND_EMPRESA.equals("NO")&&
					objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){ 		          
				strHoraInicio = System.currentTimeMillis();     
				if (objContratosDigitalesMapeo.seleccionarEmpresa2( GstrCMB_EMPRESA)){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
					strTipoLog="1";
					Mdl_Variables.map.put("CMB_NOMBRE_EMPRESA", GstrCMB_EMPRESA);
				}else{
					strTipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
				}
				Thread.sleep(1000);
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}	
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_DETALLE)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objContratosDigitalesMapeo.seleccionarVerDetalle(codigoSolicitud)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la solicitud para ver el Detalle");
					objContratosDigitalesMapeo.verificarPopUpAutorizacion();
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la solicitud para ver el Detalle");
				}
				strHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_USUARIOS_CON_ACCESO)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objContratosDigitalesMapeo.verUsuariosConAcceso()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la solicitud para ver el Detalle");
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la solicitud para ver el Detalle");
				}
				strHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objContratosDigitalesMapeo.regresar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la solicitud para ver el Detalle");
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la solicitud para ver el Detalle");
				}
				strHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore("CLICK")){   //Validar detalle  
				strHoraInicio = System.currentTimeMillis();    
				String valoresIncorrectos="";
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
				CapturarPantalla.scrollCapturaPantallaVertical("/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]", Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_USUARIOS2)){       
				strHoraInicio = System.currentTimeMillis();    
				if (objContratosDigitalesMapeo.verUsuariosNew()){ 
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Términos y Condiciones");
					strTipoLog="1";	
					objContratosDigitalesMapeo.verificarUsuariosPopUp();
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Términos y Condiciones");			        
				}	
				strHoraFin = System.currentTimeMillis();  
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.scrollCapturaPantallaVertical("/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div", Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_USUARIOS2)){       
				strHoraInicio = System.currentTimeMillis();   
				if (objContratosDigitalesMapeo.cerrarTerminosCondicionesNew()){ 
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_POPUP_USUARIOS_CON_ACCESOS)){
				Thread.sleep(2000);
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.cerrarTerminosCondiciones2()){ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"FIRMAR Y ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"FIRMAR Y ENVIAR");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_DETALLE)){
				Thread.sleep(2000);
				strHoraInicio = System.currentTimeMillis();  
				if (objContratosDigitalesMapeo.cerrarTerminosCondiciones2()){ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"FIRMAR Y ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"FIRMAR Y ENVIAR");
				}
				strHoraFin = System.currentTimeMillis();      
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
		}catch (Exception e) {
			bandera = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
			
	}
}
