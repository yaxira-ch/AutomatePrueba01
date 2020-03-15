package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import proxim.be.PortabilidadConsultaSaldosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadConsultaSaldosBL extends PortabilidadConsultaSaldosBE{
	boolean blnResultadoEsperado = true;
	String strHoraFin;
	long lngTiempoEjeCaso;
	String strFechaHora="dd/MM/yyyy HH:mm:ss";
	String strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
	String strTipoLog = null;
	
	ConexionBL objConexionBL = new ConexionBL();
	PortabilidadConsultaSaldosMapeo objConsultaSaldosPortabilidadMapeo=new PortabilidadConsultaSaldosMapeo();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	LoginPortabilidadBL objLoginPortabilidadBL=new LoginPortabilidadBL();
	
	
	public boolean consultarSaldo() throws SQLException, IOException{	
		Mdl_Variables.map= new HashMap<String,String>();
		try{

			//--------------------------------LOGIN PORTABILIDAD---------------------------------------------
			objLoginPortabilidadBL.loginPortabilidad(GstrTIE, GstrCLAVE, GstrTXT_CAPCHA, GstrBTN_SIGUIENTE, GstrBTN_SIGUIENTE1);
			//-----------------------------------------------------------------------------------------------
			
			Mdl_Variables.map.put("GstrBTN_CONSULTA_SALDOS", GstrBTN_CONSULTA_SALDOS);
			Mdl_Variables.map.put("GstrCMB_EMPRESA", GstrCMB_EMPRESA);
			Mdl_Variables.map.put("GstrBTN_ENVIAR_EMAIL", GstrBTN_ENVIAR_EMAIL);
			Mdl_Variables.map.put("GstrTXT_CORREO", GstrTXT_CORREO);
			Mdl_Variables.map.put("GstrTXT_MENSAJE_CORREO", GstrTXT_MENSAJE_CORREO);
			Mdl_Variables.map.put("GstrBTN_ENVIAR_CORREO", GstrBTN_ENVIAR_CORREO);
			Mdl_Variables.map.put("GstrBTN_CERRAR_CORREO", GstrBTN_CERRAR_CORREO);
			Mdl_Variables.map.put("GstrBTN_SELECCIONAR_CUENTA", GstrBTN_SELECCIONAR_CUENTA);
			Mdl_Variables.map.put("GstrLNK_NUMERO_CUENTA", GstrLNK_NUMERO_CUENTA);
			Mdl_Variables.map.put("GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS", GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS);
			Mdl_Variables.map.put("GstrTXT_CORREO_MOVIMIENTOS", GstrTXT_CORREO_MOVIMIENTOS);
			Mdl_Variables.map.put("GstrTXT_MENSAJE_CORREO_MOVIMIENTOS", GstrTXT_MENSAJE_CORREO_MOVIMIENTOS);
			Mdl_Variables.map.put("GstrBTN_ENVIAR_CORREO_MOVIMIENTOS", GstrBTN_ENVIAR_CORREO_MOVIMIENTOS);
			Mdl_Variables.map.put("GstrBTN_CERRAR_CORREO_MOVIMIENTOS", GstrBTN_CERRAR_CORREO_MOVIMIENTOS);

			blnResultadoEsperado=ejecutarConsulta();
			
	    	//--------------------------------LOG OFF PORTABILIDAD---------------------------------------------
			objLoginPortabilidadBL.logOffPortabilidad(GstrBTN_CERRAR_SESION) ;
			//-----------------------------------------------------------------------------------------------
		}
		catch (Exception e) {
			Mdl_Variables.Gstr_Url=Mdl_Variables.Gstr_Url1;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	    	blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
	


	
	
	
	public boolean ejecutarConsulta() throws IOException{
		try{
			String strBtnConsultaSaldos=Mdl_Variables.map.get("GstrBTN_CONSULTA_SALDOS");
			String strCmbEmpresa=Mdl_Variables.map.get("GstrCMB_EMPRESA");
			String strBtnEnviarEmail= Mdl_Variables.map.get("GstrBTN_ENVIAR_EMAIL");
			String strTxtCorreo= Mdl_Variables.map.get("GstrTXT_CORREO");
			String strTxtMensajeCorreo= Mdl_Variables.map.get("GstrTXT_MENSAJE_CORREO");
			String strBtnEnviarCorreo= Mdl_Variables.map.get("GstrBTN_ENVIAR_CORREO");
			String strBtnCerrarCorreo= Mdl_Variables.map.get("GstrBTN_CERRAR_CORREO");
			String strBtnSeleccionarCuenta= Mdl_Variables.map.get("GstrBTN_SELECCIONAR_CUENTA");
			String strLblNumeroCuenta=Mdl_Variables.map.get("GstrLNK_NUMERO_CUENTA");
			String strBtnEnviarEmailMovimientos=Mdl_Variables.map.get("GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS");
			String strTxtCorreoMovimientos=Mdl_Variables.map.get("GstrTXT_CORREO_MOVIMIENTOS");
			String strTxtMensajeCorreoMovimientos=Mdl_Variables.map.get("GstrTXT_MENSAJE_CORREO_MOVIMIENTOS");
			String strBtnEnviarCorreoMovimientos=Mdl_Variables.map.get("GstrBTN_ENVIAR_CORREO_MOVIMIENTOS");
			String strBtnCerrarCorreoMovimientos=Mdl_Variables.map.get("GstrBTN_CERRAR_CORREO_MOVIMIENTOS");
			
			
			if (objFuncionesGenerales.verificarIgnore(strBtnConsultaSaldos))
			{	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoConsultaSaldos()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Consulta de Saldos");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Consulta de Saldos");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				Thread.sleep(1800);
			}
			boolean ge=false;
			if (objFuncionesGenerales.verificarIgnore(strCmbEmpresa))
			{	
				if(!objConsultaSaldosPortabilidadMapeo.esEmpresa()){
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldosPortabilidadMapeo.seleccionarEmpresa(strCmbEmpresa)){	
						objFuncionesGenerales.callPasosAcierto(2, " de la EMPRESA: "+strCmbEmpresa , "" ,  "");
						strTipoLog="1";
						ge=true;
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, " de la EMPRESA: "+strCmbEmpresa , "" ,  "");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
					Thread.sleep(1800);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnEnviarEmail)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoBotonEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL");
				}
		
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtCorreo)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresarCorreo(strTxtCorreo)){	
					objFuncionesGenerales.callPasosAcierto(3, "El correo ", strTxtCorreo,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El correo ", strTxtCorreo,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtMensajeCorreo)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresarMensajeCorreo(strTxtMensajeCorreo)){	
					objFuncionesGenerales.callPasosAcierto(3, "El mensaje del correo ", strTxtMensajeCorreo,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El mensaje del correo ", strTxtMensajeCorreo,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
						
			if (objFuncionesGenerales.verificarIgnore(strBtnEnviarCorreo)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoBotonEnviarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
				}
		
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnCerrarCorreo)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoBotonCerrarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR CORREO");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR CORREO");
				}
		
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnSeleccionarCuenta)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.buscarCuenta(ge,strLblNumeroCuenta)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Buscar cuenta");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Buscar cuenta");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(5000);
				CapturarPantalla.scrollCapturaPantalla2(  );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnEnviarEmailMovimientos)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoBotonEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL MOVIMIENTOS");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL MOVIMIENTOS");
				}
		
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtCorreoMovimientos)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresarCorreo(strTxtCorreoMovimientos)){	
					objFuncionesGenerales.callPasosAcierto(3, "El correo ", strTxtCorreoMovimientos,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El correo ", strTxtCorreoMovimientos,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtMensajeCorreoMovimientos)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresarMensajeCorreo(strTxtMensajeCorreoMovimientos)){	
					objFuncionesGenerales.callPasosAcierto(3, "El mensaje del correo ", strTxtMensajeCorreoMovimientos,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El mensaje del correo ", strTxtMensajeCorreoMovimientos,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
						
			if (objFuncionesGenerales.verificarIgnore(strBtnEnviarCorreoMovimientos)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoBotonEnviarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR MOVIMIENTOS");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR MOVIMIENTOS");
				}
		
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBtnCerrarCorreoMovimientos)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldosPortabilidadMapeo.ingresoBotonCerrarCorreo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR CORREO MOVIMIENTOS");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR CORREO MOVIMIENTOS");
				}
		
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				Thread.sleep(1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

		}
		catch (Exception e) {
			Mdl_Variables.Gstr_Url=Mdl_Variables.Gstr_Url1;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	    	blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
	


	
	
}
