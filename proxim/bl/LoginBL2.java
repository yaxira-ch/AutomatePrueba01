package proxim.bl;

import java.awt.Robot;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.*;


public class LoginBL2 {
	static FuncionesGenerales objFuncionesGenerales= new FuncionesGenerales();
	static CapturarPantalla objCapturaPantalla = new CapturarPantalla();
	ConexionSqlServer objSQL = new ConexionSqlServer();
	ConexionBL objConexionBL= new ConexionBL();
	LoginBE2 objLoginBE = new LoginBE2();
	HeaderBL objHeader = new HeaderBL();
	ConexionDriver objConexion = new ConexionDriver();
	boolean Lbln_bandera;
	public static String Gstr_TxtNumTarjeta = "";
	boolean blnResultadoEsperado = true;
	String TipoLog = null;
	String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
	String LStr_HoraFin;
	long Lng_TiempoEjeCaso;
		
	public boolean ingresoLogin(String strOpcion, ResultSet Rst_Funcionalidad) throws Exception{
		
		
		 
		String strTxtMensajeError= Mdl_Variables.Gstr_Ignore ;
		String strTxtColumnaError= Mdl_Variables.Gstr_Ignore ;
		String strLnkMenu= Mdl_Variables.Gstr_Ignore;
		String strChkDesactivaMovimientoTeclado= Mdl_Variables.Gstr_Ignore;
		String Lstr_CHK_HACER_TARJETA_FRECUENTE= Mdl_Variables.Gstr_Ignore;
		String strIntentosPrevios = Mdl_Variables.Gstr_Ignore;
		String strCambiarCapcha = Mdl_Variables.Gstr_Ignore;
		String strCerrarPopupClave = Mdl_Variables.Gstr_Ignore;
	
		try {
			String strTxtNumTarjeta = Rst_Funcionalidad.getObject("TXT_NUM_TARJETA") != null ? Rst_Funcionalidad.getString("TXT_NUM_TARJETA") : Mdl_Variables.Gstr_Ignore;
			String strTxtCapcha = Rst_Funcionalidad.getObject("TXT_CAPCHA") != null ? Rst_Funcionalidad.getString("TXT_CAPCHA") : Mdl_Variables.Gstr_Ignore;
			String strBtnContinuar = Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
			Mdl_Variables.Gstr_Clave  = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			String strBtnEntrar = Rst_Funcionalidad.getObject("BTN_ENTRAR") != null ? Rst_Funcionalidad.getString("BTN_ENTRAR") : Mdl_Variables.Gstr_Ignore;
			String strBtnToolTipAlerta=Rst_Funcionalidad.getObject("BTN_TOOLTIP_ALERTA") != null ? Rst_Funcionalidad.getString("BTN_TOOLTIP_ALERTA") : Mdl_Variables.Gstr_Ignore;
			String LNK_CERRAR_SESION=Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			Lstr_CHK_HACER_TARJETA_FRECUENTE = Rst_Funcionalidad.getObject("CHK_HACER_TARJETA_FRECUENTE") != null ? Rst_Funcionalidad.getString("CHK_HACER_TARJETA_FRECUENTE") : Mdl_Variables.Gstr_Ignore;
			
			Gstr_TxtNumTarjeta = strTxtNumTarjeta;
					
			if (strOpcion.compareTo("1")== 0){
				String strBtnBorrar = Rst_Funcionalidad.getObject("BTN_BORRAR") != null ? Rst_Funcionalidad.getString("BTN_BORRAR") : Mdl_Variables.Gstr_Ignore;
				String strBtnBorrarTodo = Rst_Funcionalidad.getObject("BTN_BORRAR_TODO") != null ? Rst_Funcionalidad.getString("BTN_BORRAR_TODO") : Mdl_Variables.Gstr_Ignore;
				strTxtMensajeError = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				strTxtColumnaError= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				strLnkMenu = Rst_Funcionalidad.getObject("LNK_MENU") != null ? Rst_Funcionalidad.getString("LNK_MENU") : Mdl_Variables.Gstr_Ignore;
				strChkDesactivaMovimientoTeclado = Rst_Funcionalidad.getObject("CHK_DESACTIVA_MOVIMIENTO_TECLADO") != null ? Rst_Funcionalidad.getString("CHK_DESACTIVA_MOVIMIENTO_TECLADO") : Mdl_Variables.Gstr_Ignore;
				Lstr_CHK_HACER_TARJETA_FRECUENTE = Rst_Funcionalidad.getObject("CHK_HACER_TARJETA_FRECUENTE") != null ? Rst_Funcionalidad.getString("CHK_HACER_TARJETA_FRECUENTE") : Mdl_Variables.Gstr_Ignore;
				strIntentosPrevios = Rst_Funcionalidad.getObject("INTENTOS_PREVIOS_CAPCHA") != null ? Rst_Funcionalidad.getString("INTENTOS_PREVIOS_CAPCHA") : Mdl_Variables.Gstr_Ignore;
				strCambiarCapcha = Rst_Funcionalidad.getObject("BTN_CAMBIAR_CAPCHA") != null ? Rst_Funcionalidad.getString("BTN_CAMBIAR_CAPCHA") : Mdl_Variables.Gstr_Ignore;
				strCerrarPopupClave = Rst_Funcionalidad.getObject("BTN_CERRAR_POPUP_CLAVE") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POPUP_CLAVE") : Mdl_Variables.Gstr_Ignore;
			}
			
			objConexion.conexion();

			ingresoLogin( strOpcion,strTxtNumTarjeta,Lstr_CHK_HACER_TARJETA_FRECUENTE,strIntentosPrevios,strBtnContinuar,strCerrarPopupClave,strTxtCapcha,strTxtColumnaError,strCambiarCapcha,strTxtMensajeError,strBtnToolTipAlerta,strLnkMenu);
			
			if (objFuncionesGenerales.verificarIgnore(LNK_CERRAR_SESION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				objHeader.cerrarSesion(LNK_CERRAR_SESION,LNK_CERRAR_SESION);
			}
		} catch (InterruptedException e) {
			blnResultadoEsperado=false;
			e.printStackTrace();
		}
		return blnResultadoEsperado;
	}
	
	public boolean ingresoLogin(String strOpcion,String strTxtNumTarjeta,String strChkHacerTarjetaFrecuente,String strIntentosPrevios,String strBtnContinuar,String strCerrarPopupClave,String strTxtCapcha,String strTxtColumnaError,String strCambiarCapcha,String strTxtMensajeError,String strBtnToolTipAlerta,String strLnkMenu) throws IOException{
    	try {
    		//--------------------------OTRAS VALIDACIONES DE LOGIN---------------------
    		if (strOpcion.compareTo("1")== 0) {
    			if(objLoginBE.verificarLogoInterbank())
    			{
    				objFuncionesGenerales.callPasosAcierto(6, "El LOGO INTERBANK" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "El LOGO INTERBANK" , "" ,  "");
    			}
    			
    			if (objLoginBE.existeElemento("BarraProgreso"))
    			{
    				objFuncionesGenerales.callPasosAcierto(6, "La IMAGEN DE PROGRESO" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "La IMAGEN DE PROGRESO" , "" ,  "");
    			}
    			
    			String strTexto = "";
    			if ((strTexto = objLoginBE.obtieneTexto("TituloInicioSesion")).equals("Iniciar Sesión"))
    			{
    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION:"+"Iniciar Sesión" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION:"+"Iniciar Sesión" ,  "");
    			}
    			
    			strTexto = "";
    			if ((strTexto = objLoginBE.obtieneTexto("LabelTIE").trim().substring(0,31)).equals(("Tarjeta Interactiva Empresarial ").trim()))
    			{
    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION:"+"Tarjeta Interactiva Empresarial" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION:"+"Tarjeta Interactiva Empresarial" ,  "");
    			}
    			
    			if (objLoginBE.existeElemento("InputTIE"))
    			{
    				objFuncionesGenerales.callPasosAcierto(6, "El cuadro de texto para ingresar la TIE" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "El cuadro de texto para ingresar la TIE" , "" ,  "");
    			}
    			
    			if (objLoginBE.existeElemento("CheckRecordar"))
    			{
    				objFuncionesGenerales.callPasosAcierto(6, "El CHECK RECORDAR" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "El CHECK RECORDAR" , "" ,  "");
    			}
    			
    			strTexto = "";
    			if ((strTexto = objLoginBE.obtieneTexto("LabelClaveWeb").trim()).equals(("Ingresa tu clave web ").trim()))
    			{
    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION:"+"Ingresa tu clave web" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION:"+"Ingresa tu clave web" ,  "");
    			}
    			
    			if (objLoginBE.existeElemento("ClaveWeb"))
    			{
    				objFuncionesGenerales.callPasosAcierto(6, "El cuadro de texto para ingresar la CLAVE WEB" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "El cuadro de texto para ingresar la CLAVE WEB" , "" ,  "");
    			}
    			
    			if (objLoginBE.existeElemento("BotonIngresar"))
    			{
    				objFuncionesGenerales.callPasosAcierto(6, "El BOTON INGRESAR" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "El BOTON INGRESAR" , "" ,  "");
    			}
    			
    			strTexto = "";
    			if ((strTexto = objLoginBE.obtieneTexto("LabelPasos").trim()).equals(("Paso 1 de 2").trim()))
    			{
    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION:"+"Paso 1 de 2" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION:"+"Paso 1 de 2" ,  "");
    			}

    		}
    		//---------------------------------------------------------------------------
    		
    		if (objFuncionesGenerales.verificarIgnore(strTxtNumTarjeta)){	   			
    			objLoginBE.verificarLogoInterbank();
    			LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	    
    			if (objLoginBE.ingresoTarjeta(strTxtNumTarjeta))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "el número de TARJETA" , strTxtNumTarjeta ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "el número de TARJETA" , strTxtNumTarjeta ,  "");
				}
    			LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			} 

			if (objFuncionesGenerales.verificarIgnore(strChkHacerTarjetaFrecuente)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());		
				if (objLoginBE.seleccionarTarjetaFrecuente())
				{	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Recordar");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"Recordar");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//-************** FLUJO ALTERNO PARA PROBAR CAPCHA **************
			
			if (objFuncionesGenerales.verificarIgnore(strIntentosPrevios)){
				int nInt = 0;
				nInt = Integer.parseInt(strIntentosPrevios);
				for(int i = 1;i<= nInt;i++){
					
					if (objFuncionesGenerales.verificarIgnore("CLICK"))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objLoginBE.seleccionarClave())
						{	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ," Ingresa tu clave web para INGRESAR TU CLAVE");
							TipoLog="1";
						}else{
							TipoLog="0";	
							objFuncionesGenerales.callPasosErrado(1, "", "" ," Ingresa tu clave web para INGRESAR TU CLAVE");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore("1111")){	
						objLoginBE.verificarTeclado();
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objLoginBE.ingresoClave("1111"))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "La contraseña", "1111","");
							TipoLog="1";
						}else{
							TipoLog="0";	
							objFuncionesGenerales.callPasosErrado(3, "La contraseña: ","1111","");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(strBtnContinuar)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
						Thread.sleep(3000);
						
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						if(objFuncionesGenerales.verificarIgnore(strCerrarPopupClave)){
							if (objLoginBE.ingresoCerrarPopup()){	
								CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR DEL POPUP");
								TipoLog="1";
							}else{
								TipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR DEL POPUP");
							}
						}else{
							if (objLoginBE.ingresoBotonIngresarPopup()){	
								CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón INGRESAR DEL POPUP");
								TipoLog="1";
							}else{
								TipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón INGRESAR DEL POPUP");
							}
						}

						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if(objFuncionesGenerales.verificarIgnore(strCerrarPopupClave))
					{
						if (objFuncionesGenerales.verificarIgnore(strBtnContinuar))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							if (objLoginBE.ingresoBotonIngresar())
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón INGRESAR DEL LOGIN");
								TipoLog="1";
							}else{
								TipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón INGRESAR DEL LOGIN");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
					}
							
					if (objFuncionesGenerales.verificarIgnore("El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar."))
					{
						String strMsjeFront = objLoginBE.obtenerMensajeTie("TXT_CLAVE");
						if (strMsjeFront.equals("El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar."))
						{
							objFuncionesGenerales.callPasosAcierto(5, "FRONT: " + strMsjeFront, "DATA: El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar.","");
							TipoLog="1";
						}
						else
						{
							objFuncionesGenerales.callPasosErrado(5, "FRONT: " + strMsjeFront, "DATA: El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar.","");
							TipoLog="1";
						}
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					}
					
				}
			}
			
			//********************************************************************
			
			
			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objLoginBE.seleccionarClave())
				{	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ," el texto para INGRESAR TU CLAVE");
					TipoLog="1";
				}else{
					TipoLog="0";	
					objFuncionesGenerales.callPasosErrado(1, "", "" ," el texto para INGRESAR TU CLAVE");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			//------OTRAS VALIDACIONES-------------
			if (strOpcion.compareTo("1")== 0) 
    		{
				if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave))
				{
					objLoginBE.verificarTeclado();
					if (objLoginBE.existeElemento("TecladoVirtual"))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(6, "elementos del TECLADO VIRTUAL" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "elementos del TECLADO VIRTUAL" , "" ,  "");
	    			}
	    			
	    			String strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelTituloTecladoVirtual").trim()).equals(("Teclado Virtual").trim()))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION: "+"Teclado Virtual" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION: "+"Teclado Virtual" ,  "");
	    			}
	    			
	    			String strNros = objLoginBE.existeNumerosTeclado();
	    			if (strNros.equals("SI"))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(6, "Los NUMEROS 123456789 en el TECLADO VIRTUAL" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "Los NUMEROS "+strNros+" en el TECLADO VIRTUAL" , "" ,  "");
	    			}
	    			
	    			strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelMensajeTecladoVirtual").trim()).equals(("*Utiliza el teclado en pantalla").trim()))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION: "+"*Utiliza el teclado en pantalla" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION: "+"*Utiliza el teclado en pantalla" ,  "");
	    			}
	    			
	    			strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelTituloClaveVirtual").trim()).equals(("Ingresa tu clave web").trim()))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION: "+"Ingresa tu clave web" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION: "+"Ingresa tu clave web" ,  "");
	    			}
	    			if (objLoginBE.existeElemento("BotonIngresarVirtual"))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(6, "El BOTON INGRESAR en el teclado virtual" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "El BOTON INGRESAR en el teclado virtual" , "" ,  "");
	    			}
	    			if (objLoginBE.existeElemento("BotonCerrarVirtual"))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(6, "El BOTON CERRAR en el teclado virtual" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "El BOTON CERRAR en el teclado virtualL" , "" ,  "");
	    			}
				}
    		}			
			//-----------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
				objLoginBE.verificarTeclado();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objLoginBE.ingresoClave(Mdl_Variables.Gstr_Clave))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La contraseña", Mdl_Variables.Gstr_Clave,"");
					TipoLog="1";
				}else{
					TipoLog="0";	
					objFuncionesGenerales.callPasosErrado(3, "La contraseña: ", Mdl_Variables.Gstr_Clave,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave) && objFuncionesGenerales.verificarIgnore(strBtnContinuar))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				Thread.sleep(3000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				if(objFuncionesGenerales.verificarIgnore(strCerrarPopupClave)){
					if (objLoginBE.ingresoCerrarPopup()){	
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR DEL POPUP");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR DEL POPUP");
					}
				}else{
					if (objLoginBE.ingresoBotonIngresarPopup()){	
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón INGRESAR DEL POPUP");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón INGRESAR DEL POPUP");
					}
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//----VALIDACIONES DEL CAPCHA ------

			if (objFuncionesGenerales.verificarIgnore(strTxtCapcha) || strTxtColumnaError.equals("TXT_CAPCHA") )
			{
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				if (objLoginBE.existeElemento("imagenCapcha"))	{
    				objFuncionesGenerales.callPasosAcierto(6, "imagen CAPCHA" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "imagen CAPCHA" , "" ,  "");
    			}
				
				String strTexto = "";
    			if ((strTexto = objLoginBE.obtieneTexto("LabelTituloCapcha").trim().substring(0, 29)).equals(("Ingresa el texto de la imagen").trim()))
    			{
    				objFuncionesGenerales.callPasosAcierto(5, "FRONT:"+strTexto , "DEFINICION: "+"Ingresa el texto de la imagen" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "FRONT:"+strTexto , "DEFINICION: "+"Ingresa el texto de la imagen" ,  "");
    			}
				
				if (objLoginBE.existeElemento("linkCapcha")){
    				objFuncionesGenerales.callPasosAcierto(6, "link MOSTRAR IMAGEN" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "link MOSTRAR IMAGEN" , "" ,  "");
    			}
				
				if (objLoginBE.existeElemento("inputCapcha")){
    				objFuncionesGenerales.callPasosAcierto(6, "input CAPCHA" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "input CAPCHA" , "" ,  "");
    			}
		
			}
			
			//----------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(strCambiarCapcha))	{
    			LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	    
    			if (objLoginBE.ingresoCambiarCapcha())	{
					objFuncionesGenerales.callPasosAcierto(1, "" , "" , "MOSTRAR OTRA IMAGEN");
					TipoLog="1";
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "" , "" , "MOSTRAR OTRA IMAGEN");
				}
    			LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtCapcha)){
    			LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	    
    			if (objLoginBE.ingresarCapcha(strTxtCapcha)){
					objFuncionesGenerales.callPasosAcierto(3, "el texto del CAPCHA" , strTxtCapcha ,  "");
					TipoLog="1";
					if (strTxtCapcha.equals("*")) {
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    					Thread.sleep(20000);
    					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    				}
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "el texto del CAPCHA" , strTxtCapcha ,  "");
				}
    			LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTxtCapcha) || objFuncionesGenerales.verificarIgnore(strCerrarPopupClave) )
			{
				if (objFuncionesGenerales.verificarIgnore(strBtnContinuar)){	
					Thread.sleep(3000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objLoginBE.ingresoBotonIngresar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón INGRESAR DEL LOGIN");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón INGRESAR DEL LOGIN");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}

			boolean bCasoError = false;		
			
			if (objFuncionesGenerales.verificarIgnore(strTxtMensajeError)){
				if (objFuncionesGenerales.verificarIgnore(strTxtColumnaError)){
					String strMsjeFront = objLoginBE.obtenerMensajeTie(strTxtColumnaError);
					if (strMsjeFront.equals(strTxtMensajeError)){
						bCasoError = true;
						objFuncionesGenerales.callPasosAcierto(5, "FRONT: " + strMsjeFront, "DATA:" +  strTxtMensajeError,"");
						TipoLog="1";
					}else{
						objFuncionesGenerales.callPasosErrado(5, "FRONT: " + strMsjeFront, "DATA:" +  strTxtMensajeError,"");
						TipoLog="1";
					}
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				}else {
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "en la DATA la COLUMNA ERROR a la que pertenece el mensaje", "" ,"");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				}
			}
		
			if(!bCasoError){
				if (strOpcion.compareTo("1")== 0){ //VERIFICACIONES PARTE 2
					objLoginBE.verificarSelloSeguridad();
					if (objLoginBE.existeElemento("LogoInterbank")){
	    				objFuncionesGenerales.callPasosAcierto(6, "El LOGO INTERBANK" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "El LOGO INTERBANK" , "" ,  "");
	    			}

					if (objLoginBE.existeElemento("BarraProgreso2")){
	    				objFuncionesGenerales.callPasosAcierto(6, "La BARRA DE PROGRESO 2" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "La BARRA DE PROGRESO 2" , "" ,  "");
	    			}
					
					String strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelSaludoSello").trim().substring(0,4)).equals(("Hola").trim())){
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT: Empieza con "+strTexto , "DEFINICION: Empieza con "+"Hola" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT: Empieza con "+strTexto , "DEFINICION: Empieza con "+"Hola" ,  "");
	    			}
	    			
	    			strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelMensajeSello").trim()).equals((" Confirma tu sello de seguridad").trim()))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT: "+strTexto , "DEFINICION:  Confirma tu sello de seguridad " ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT: "+strTexto , "DEFINICION:  Confirma tu sello de seguridad" ,  "");
	    			}

	    			if (objLoginBE.existeElemento("SelloSeguridad"))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(6, "El SELLO DE SEGURIDAD" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "El SELLO DE SEGURIDAD" , "" ,  "");
	    			}
	    			
	    			if (objLoginBE.existeElemento("ConfirmarSelloSeguridad")){
	    				objFuncionesGenerales.callPasosAcierto(6, "El boton SI ES MI SELLO" , "" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "El boton SI ES MI SELLO" , "" ,  "");
	    			}
	    			
	    			strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelComunicadoSello").trim()).equals(("En caso no sea tu sello de seguridad, comunícate con la Banca Telefónica Comercial al 311-9001 (Lima) o al 0-801-00801 (Provincias).").trim()))
	    			{
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT: "+strTexto.substring(0,30) + "..." , "DEFINICION: En caso no sea tu sello de seg..." ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT: "+strTexto.substring(0,30) + "..." , "DEFINICION: En caso no sea tu sello de seg..."  ,  "");
	    			}
	    			
	    			strTexto = "";
	    			if ((strTexto = objLoginBE.obtieneTexto("LabelPasos2").trim()).equals(("Paso 2 de 2").trim())){
	    				objFuncionesGenerales.callPasosAcierto(5, "FRONT: "+strTexto, "DEFINICION: Paso 2 de 2" ,  "");
						TipoLog="1";
	    			}else{
	    				TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(5, "FRONT: "+strTexto, "DEFINICION: Paso 2 de 2" ,  "");
	    			}
	    		}
				
				
				if (objFuncionesGenerales.verificarIgnore(strBtnContinuar)){
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
					if(objLoginBE.verificarSelloSeguridad()){
						objFuncionesGenerales.callPasosAcierto(4, "Se muestra el SELLO DE SEGURIDAD", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(4, "No se muestra en SELLO DE SEGURIDAD", "" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(strBtnContinuar)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objLoginBE.seleccionarAceptarSello()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI, ES MI SELLO");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI, ES MI SELLO");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
			}
			
			/*if (objFuncionesGenerales.verificarIgnore(strBtnToolTipAlerta)){	
				objLoginBE.verificarPopPrincipal();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if (objLoginBE.cerrarPU()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en X para cerrar POPUP");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en X para cerrar POPUP");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			*/

			
			if(Mdl_Variables.Gstr_Aplicativo.toLowerCase().equals("chrome")){
				Robot robot=new Robot();
				robot.keyPress(java.awt.event.KeyEvent.VK_ESCAPE);
			}
			
			if(!bCasoError&&strOpcion.compareTo("1")== 0){ //VERIFICACIONES PARTE 3
				if (objLoginBE.existeElemento("LogoInterbankPrincipal")){
    				objFuncionesGenerales.callPasosAcierto(6, "La pantalla principal de inicio con LOGO INTERBANK" , "" ,  "");
					TipoLog="1";
    			}else{
    				TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(6, "La pantalla principal de inicio con El LOGO INTERBANK" , "" ,  "");
    			}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strLnkMenu)){	
				objHeader.menuPrincipal( Mdl_Variables.Gstr_Ignore,"AUTORIZACIONES",  Mdl_Variables.Gstr_Ignore);
			}
			
		} catch (Exception e) {	
			blnResultadoEsperado=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
            CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes");
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
    	return blnResultadoEsperado;
	}
	
}
