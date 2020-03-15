package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionDriver;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadAutorizacionBL extends PortabilidadAutorizacionBE {
	boolean blnResultadoEsperado = true;
	String LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	PortabilidadMapeo objPortabilidadAutorizacionesPendientesBE = new PortabilidadMapeo();
	LoginPortabilidadBL objLoginPortabilidadBL=new LoginPortabilidadBL();
	PortabilidadConsultaSaldosBL objPortabilidadConsultaSaldosBL= new PortabilidadConsultaSaldosBL();
	
	public boolean autorizacionesPendientes(int opcion,boolean consultar,String consultarSaldos) throws SQLException, IOException{

		try {
			Mdl_Variables.Gstr_Url=Mdl_Variables.Gstr_UrlPorta;
			ConexionDriver.conexion();
			
			//-************** FLUJO ALTERNO PARA PROBAR CAPCHA **************
			
			if (objFuncionesGenerales.verificarIgnore(GstrINTENTOS_PREVIOS_CAPCHA)){
				int nInt = 0;
				nInt = Integer.parseInt(GstrINTENTOS_PREVIOS_CAPCHA);
				for(int i = 1;i<= nInt;i++){
					if (objFuncionesGenerales.verificarIgnore(GstrTIE)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.IngresarTIE(GstrTIE)){	
							objFuncionesGenerales.callPasosAcierto(3, "La TIE ", GstrTIE,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "La TIE ", GstrTIE,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore("1111")){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresarClave("1111")){	
							objFuncionesGenerales.callPasosAcierto(3, "La clave ", "1111","");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "La clave ", "1111","");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
		    			Thread.sleep(2000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						Thread.sleep(2000);
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if(i >= 3){
						if (objFuncionesGenerales.verificarIgnore(GstrTXT_CAPCHA)){
			    			LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	    
			    			if (objPortabilidadAutorizacionesPendientesBE.ingresarCapcha(GstrTXT_CAPCHA)){
								objFuncionesGenerales.callPasosAcierto(3, "el texto del CAPCHA" , GstrTXT_CAPCHA ,  "");
								TipoLog="1";
								if (GstrTXT_CAPCHA.equals("*")) {
									CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    					Thread.sleep(20000);
			    					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    				}
							}else{
								TipoLog="0";
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(3, "el texto del CAPCHA" , GstrTXT_CAPCHA ,  "");
							}
			    			LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
					}
					
					if (objFuncionesGenerales.verificarIgnore("SIGUIENTE")){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonSiguiente()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SIGUIENTE");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SIGUIENTE");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			    		Thread.sleep(1800);
					}
					
					if (objFuncionesGenerales.verificarIgnore("El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar.")){
						Thread.sleep(5000);
						String strMsjeFront = objPortabilidadAutorizacionesPendientesBE.obtenerMensajeTie(i);
						if (strMsjeFront.equals("El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar.")){
							objFuncionesGenerales.callPasosAcierto(5, "FRONT: " + strMsjeFront, "DEFINICION : El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar.","");
							TipoLog="1";
						}else{
							objFuncionesGenerales.callPasosErrado(5, "FRONT: " + strMsjeFront, "DEFINICION : El número de tu tarjeta o clave está errado. Por favor, verifica y vuelve a intentar.","");
							TipoLog="1";
						}
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					}
					
				}
			}

			//********************************************************************
			
	
			if (objFuncionesGenerales.verificarIgnore(GstrTIE)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPortabilidadAutorizacionesPendientesBE.IngresarTIE(GstrTIE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La TIE ", GstrTIE,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La TIE ", GstrTIE,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(GstrCLAVE)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPortabilidadAutorizacionesPendientesBE.ingresarClave(GstrCLAVE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave ", GstrCLAVE,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave ", GstrCLAVE,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CAPCHA)){
    			LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	    
    			if (objPortabilidadAutorizacionesPendientesBE.ingresarCapcha(GstrTXT_CAPCHA)){
					objFuncionesGenerales.callPasosAcierto(3, "el texto del CAPCHA" , GstrTXT_CAPCHA ,  "");
					TipoLog="1";
					if (GstrTXT_CAPCHA.equals("*")) {
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    					Thread.sleep(20000);
    					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    				}
				}else{
					TipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "el texto del CAPCHA" , GstrTXT_CAPCHA ,  "");
				}
    			LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_SIGUIENTE)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Thread.sleep(1000);
				if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonSiguiente()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SIGUIENTE");
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SIGUIENTE");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
	    		Thread.sleep(1800);
			}
			
			boolean bCasoError = false;			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){
				Thread.sleep(5000);
				
					int nOpc= 1;
					if (objFuncionesGenerales.verificarIgnore(GstrINTENTOS_PREVIOS_CAPCHA)&&Integer.parseInt(GstrINTENTOS_PREVIOS_CAPCHA) >= 1){
							nOpc = 2;
					}		
					
					String strMsjeFront = objPortabilidadAutorizacionesPendientesBE.obtenerMensajeTie(nOpc);
					if (strMsjeFront.equals(GstrTXT_MENSAJE_ERROR)){
						bCasoError = true;
						objFuncionesGenerales.callPasosAcierto(5, "FRONT: " + strMsjeFront, "DATA:" +  GstrTXT_MENSAJE_ERROR,"");
						TipoLog="1";
					}else{
						objFuncionesGenerales.callPasosErrado(5, "FRONT: " + strMsjeFront, "DATA:" +  GstrTXT_MENSAJE_ERROR,"");
						TipoLog="1";
					}
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			}
			
			if(!bCasoError){
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SIGUIENTE1)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonSiguiente()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SIGUIENTE");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SIGUIENTE");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					Thread.sleep(1800);
				}
				
				if(opcion==2){
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_AUTORIZACIONES_PENDIENTES)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoAutorizacionesPendientes()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Autorizaciones Pendientes");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Autorizaciones Pendientes");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						Thread.sleep(18000);//mas tiempo
					}
					
		//			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
		//			{	
		//				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		//				if (objPortabilidadAutorizacionesPendientesBE.seleccionarEmpresa(GstrCMB_EMPRESA)){	
		//					objFuncionesGenerales.callPasosAcierto(2, " de la EMPRESA: "+GstrCMB_EMPRESA , "" ,  "");
		//					TipoLog="1";
		//				}else{
		//					TipoLog="0";									
		//					bandera = false;
		//					objFuncionesGenerales.callPasosErrado(2, " de la EMPRESA: "+GstrCMB_EMPRESA , "" ,  "");
		//				}
		//				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		//    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
		//			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		//	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		//	    		Thread.sleep(1800);
		//			}
					
					if (objFuncionesGenerales.verificarIgnore(GstrLBL_TIPO_OPERACION)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoOperacion(GstrLBL_TIPO_OPERACION)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Tipo de Operación");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Tipo de Operación");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						Thread.sleep(1800);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCHK_AUTORIZAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.seleccionarLote(GstrLBL_TIPO_OPERACION,gstrLblTipoProducto)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Lote a Enviar");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Lote a Enviar");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						Thread.sleep(1800);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_AUTORIZAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonAutorizar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton AUTORIZAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton AUTORIZAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						Thread.sleep(1800);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_BLOQUEAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonBloquear()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton BLOQUEAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton BLOQUEAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						Thread.sleep(1800);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCHK_ACEPTAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoCheckAceptar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el CHECK ACEPTAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el CHECK ACEPTAR");
						}
				
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (GstrTXT_CLAVE.equals("SI")){
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresarClaveAutorizacion(GstrCLAVE)){	
							objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", GstrCLAVE,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "La contraseña ", GstrCLAVE,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
							objFuncionesGenerales.callPasosAcierto(3, "La clave dinámica ", GstrTXT_CLAVE_DINAMICA,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "La clave dinámica ", AutorizacionesPendientesBE.GstrTXT_CLAVE_DINAMICA,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonConfirmar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
						}
				
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				
					}	
					
					//----
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_EMAIL)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonEnviarEmail()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL");
						}
				
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresarCorreo(GstrTXT_CORREO)){	
							objFuncionesGenerales.callPasosAcierto(3, "El correo ", GstrTXT_CORREO,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "El correo ", GstrTXT_CORREO,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresarMensajeCorreo(GstrTXT_MENSAJE_CORREO)){	
							objFuncionesGenerales.callPasosAcierto(3, "El mensaje del coreo ", GstrTXT_MENSAJE_CORREO,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "El mensaje del coreo ", GstrTXT_MENSAJE_CORREO,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
								
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonEnviar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
						}
				
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonCerrarCorreo()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR CORREO");
							TipoLog="1";
						}else{
							TipoLog="0";									
							blnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR CORREO");
						}
				
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				}
				
				if (consultar &&blnResultadoEsperado){
						
						if (objFuncionesGenerales.verificarIgnore("CLICK")){	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonHome()){	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón HISTORIAL");
								TipoLog="1";
								Thread.sleep(1800);
							}else{
								TipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón HISTORIAL");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
							objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore(GstrBTN_HISTORIAL)){	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							if (objPortabilidadAutorizacionesPendientesBE.ingresoBotonHistorial()){	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón HISTORIAL");
								TipoLog="1";
								Thread.sleep(1800);
							}else{
								TipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón HISTORIAL");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
							objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						String strXpathBoton = "";
						if (objFuncionesGenerales.verificarIgnore("CLICK")){
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							strXpathBoton=objPortabilidadAutorizacionesPendientesBE.buscarAutorizacion(GstrLBL_TIPO_OPERACION,GstrLBL_DESCRIPCION,GstrLBL_ESTADO,GstrLBL_MONTO,opcion);
							if (!strXpathBoton.equals("")){	
								objFuncionesGenerales.callPasosAcierto(6, "Existe la Operación en el listado", "" ,"");
								TipoLog="1";
							}else{
								TipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(6, "Existe la Operación en el listado", "" ,"");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
							objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (!strXpathBoton.equals("")){	
							
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objPortabilidadAutorizacionesPendientesBE.ingresarDetalleHistorico(strXpathBoton,opcion)){	
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"ver Detalle Transferencia");
									TipoLog="1";
									Thread.sleep(500);
								}else{
									TipoLog="0";									
									blnResultadoEsperado = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"ver Detalle Transferencia");
								}  
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
								CapturarPantalla.scrollCapturaPantalla();
								objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							
							if (consultarSaldos!=Mdl_Variables.Gstr_Ignore){
								
								Mdl_Variables.map.put("GstrBTN_CONSULTA_SALDOS", "CLICK");
								Mdl_Variables.map.put("GstrCMB_EMPRESA", GstrCMB_EMPRESA);
								Mdl_Variables.map.put("GstrBTN_ENVIAR_EMAIL", GstrBTN_ENVIAR_EMAIL);
								Mdl_Variables.map.put("GstrTXT_CORREO", GstrTXT_CORREO);
								String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
								String GstrBTN_CERRAR_CORREO=Mdl_Variables.Gstr_Ignore;
								
								if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_EMAIL)){
									GstrTXT_MENSAJE_CORREO="Consulta de Saldos y movimientos"+GstrTXT_MENSAJE_CORREO;
									GstrBTN_ENVIAR_CORREO="CLICK";
									GstrBTN_CERRAR_CORREO="CLICK";
								}
								
								Mdl_Variables.map.put("GstrTXT_MENSAJE_CORREO", GstrTXT_MENSAJE_CORREO);
								Mdl_Variables.map.put("GstrBTN_ENVIAR_CORREO", GstrBTN_ENVIAR_CORREO);
								Mdl_Variables.map.put("GstrBTN_CERRAR_CORREO", GstrBTN_CERRAR_CORREO);
								Mdl_Variables.map.put("GstrBTN_SELECCIONAR_CUENTA", "CLICK");
								//Mdl_Variables.map.put("GstrLNK_NUMERO_CUENTA", GstrLNK_NUMERO_CUENTA);
								Mdl_Variables.map.put("GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS", GstrBTN_ENVIAR_EMAIL);
								Mdl_Variables.map.put("GstrTXT_CORREO_MOVIMIENTOS", GstrTXT_CORREO);
								Mdl_Variables.map.put("GstrTXT_MENSAJE_CORREO_MOVIMIENTOS", GstrTXT_MENSAJE_CORREO);
								Mdl_Variables.map.put("GstrBTN_ENVIAR_CORREO_MOVIMIENTOS", GstrBTN_ENVIAR_CORREO);
								Mdl_Variables.map.put("GstrBTN_CERRAR_CORREO_MOVIMIENTOS", GstrBTN_CERRAR_CORREO);
							
								objPortabilidadConsultaSaldosBL.ejecutarConsulta();	
//									Map<String,String> mapDatos= FuncionesGenerales.obtenerCampos_ConsultarSaldos();
//									objPortabilidadAutorizacionesPendientesBE.registrarDatosConsultar(mapDatos,GstrRUTA);
//									
//									PortabilidadConsultaSaldosBL objConsultaSaldosPortabilidadBL= new PortabilidadConsultaSaldosBL();
//									PortabilidadConsultaSaldosBE objConsultaSaldosPortabilidadBE=new PortabilidadConsultaSaldosBE();
//									boolean Lbln_Bandera = false;
//									
//									objSQL.listaTablaIdCaso("CONSULTA_SALDOS_PORTABILIDAD"," WHERE TABLA_CARGA='"+mapDatos.get("TABLA_CARGA")+
//											"' and ID_CASO_LOTE='"+mapDatos.get("ID_CASO_LOTE")+"' ",1);
//									while (Mdl_Variables.Grst_ListaCasosEjecutar.next()==true) {
//										Lbln_Bandera = objConsultaSaldosPortabilidadBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
//				    					if (Lbln_Bandera) 	{ 
//				    						if(PortabilidadConsultaSaldosBE.GstrTIPO_OPERACION.equals("Cargo")){
//				    							objConsultaSaldosPortabilidadBL.ejecutarConsulta();	
//				    						}else{
//				    							if(mapDatos.get("TABLA_CARGA").equals("APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D")){
//				    								objConsultaSaldosPortabilidadBL.ejecutarConsulta();	
//				    							}else{
//				    								objConsultaSaldosPortabilidadBL.consultarSaldo();
//				    							}
//				    						}
//				    						
//				    		    		}									
//									}
							}
						}					
				}else{
					if(!consultar&&GstrLBL_TIPO_OPERACION.equals("Comercio Exterior"))
						objPortabilidadAutorizacionesPendientesBE.verificarMensaje();
				}
			}

		//--------------------------------LOG OFF PORTABILIDAD---------------------------------------------
			objLoginPortabilidadBL.logOffPortabilidad(GstrLNK_CERRAR_SESION) ;
		//-----------------------------------------------------------------------------------------------

			
			Mdl_Variables.Gstr_Url=Mdl_Variables.Gstr_Url1;
			
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


