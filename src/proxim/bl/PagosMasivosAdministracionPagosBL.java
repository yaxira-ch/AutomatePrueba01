package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import proxim.be.EnvioPagosMasivosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;
public class PagosMasivosAdministracionPagosBL extends PagosMasivosAdministracionAfiliadosBE {
	
	
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	RegistroAfiliadosPagosBL objRegistroAfiliadosPagosBL = new RegistroAfiliadosPagosBL();
	pagosMasivosAdministracionTest objPagoMasivoAdministracionPagoBE = new pagosMasivosAdministracionTest();
	EnvioPagosMasivosBE objEnvioPagosMasivosBE = new EnvioPagosMasivosBE();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	FirmarBL objFirmarBL =new FirmarBL();
	HeaderBL objHeader = new HeaderBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	public boolean administracionPagosMasivos() throws SQLException, IOException{
		boolean blnResultadoEsperado = true;
		boolean banderaAfiliados=true;
		String strHoraFin;
		long lngTiempoEjeCaso;
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		String strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
		String strHoraFinPrueba1;
		long strTiempoRefresh;
		String strTextoImagen="1. Imagenes";
		String strTipoLog = null;
		
		try {
			
			//------------------------------------------------------------MENU-------------------------------------------------
			
			objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, PagosMasivosAdministracionAfiliadosBE.strTxtMenu, PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu);

			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarSubMenuPestana(PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1)){	
					objFuncionesGenerales.callPasosAcierto(2, "en la PESTAÑA, "+PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1 , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "en la PESTAÑA, "+PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1 , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//------------------------------------------------------------------------------

			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarEmpresa(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){	
					objFuncionesGenerales.callPasosAcierto(2, "De la EMPRESA, "+PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2,  "De la EMPRESA, "+PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarProducto(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){	
					objFuncionesGenerales.callPasosAcierto(2, "Del PRODUCTO, "+ PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2,  "Del PRODUCTO, "+PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarServicio(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){	
					objFuncionesGenerales.callPasosAcierto(2, "Del SERVICIO, "+PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "Del SERVICIO, "+PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarCuentaCargo(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO)){	
					objFuncionesGenerales.callPasosAcierto(2, "De lA CUENTA CARGO, "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "De lA CUENTA CARGO, "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)){// Nombre de la Solicitud*
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.ingresarDescripcion(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)){	
					objFuncionesGenerales.callPasosAcierto(3, "", "El NOMBRE DE LA SOLICITUD, "+PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "", "El NOMBRE DE LA SOLICITUD, "+PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarTipoProceso(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO)){	
					objFuncionesGenerales.callPasosAcierto(2, "El TIPO DE PROCESO, "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "El TIPO DE PROCESO, "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
				
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO)){// Nombre de la Solicitud*	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				
				Date fechaActual=new Date();
				DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal=Calendar.getInstance();
				cal.setTime(fechaActual);
				cal.add(Calendar.DATE, 1);
				Date nuevaFecha=cal.getTime();				
				String fecha= formatoFecha.format(nuevaFecha);
				PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO=fecha;
				objSQL.actualizarTabla("APP_AND_PAGO_MAS_ADMPAGOS_D", "TXT_FECHA_DIFERIDO", fecha, strIdCaso);
				
				if (objPagoMasivoAdministracionPagoBE.ingresarFechaDiferido(PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO)){	
					objFuncionesGenerales.callPasosAcierto(3, "", "La FECHA DE PROCESO, "+PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";	
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "", "La FECHA DE PROCESO, "+PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA)){		
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.seleccionarTipoCarga(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA)){	
					objFuncionesGenerales.callPasosAcierto(2, "El TIPO DE CARGA, "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "El TIPO DE CARGA, "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
				if (objPagoMasivoAdministracionPagoBE.ingresarRutaTxt(PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO)){	
					objFuncionesGenerales.callPasosAcierto(3, "La ruta del ARCHIVO, "+PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La ruta del ARCHIVO, "+PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO , "" ,  "");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
				
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_AGREGAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objPagoMasivoAdministracionPagoBE.ingresoBotoAgregar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR");
					strTipoLog="1";

					objEnvioPagosMasivosBE.verificarTablaCorrecto();
					CapturarPantalla.scrollCapturaPantalla();
					strTiempoRefresh = 0;
					if(objEnvioPagosMasivosBE.esperarTiempoCambioEstado()){
						String strHoraFinRefresh = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
						strTiempoRefresh = (new SimpleDateFormat(strFechaHora).parse(strHoraFinRefresh).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
		    			toString();
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Carga de Lotes Pagos Masivos", PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion, Long.toString(strTiempoRefresh));
		    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					}
					
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if(objPagoMasivoAdministracionPagoBE.verificarMensajeLoteDuplicado())
				if (objFuncionesGenerales.verificarIgnore("CLICK")){	
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonAceptar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR)){	
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonCancelar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
				}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CONTINUAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objPagoMasivoAdministracionPagoBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objEnvioPagosMasivosBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			


			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objEnvioPagosMasivosBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_AGREGAR_NUEVA)){	
				objPagoMasivoAdministracionPagoBE.detallePagoEnviar();//--
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objPagoMasivoAdministracionPagoBE.ingresoBotonAgregarNuevoTrabajador()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR NUEVO TRABAJADOR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR NUEVO TRABAJADOR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
        		
			}
			
			//----------------------------------------------AGREGA AFILIADOS--------------------------------------------------
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strNumAfiliados)){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				//objPagoMasivoAdministracionPagoBE.detallePagoEnviar();//--
				FuncionesGenerales.casosEjecutar(PagosMasivosAdministracionAfiliadosBE.strNumAfiliados,2);//captura todos los id a hacer prueba
				for(int i=0;i<=Mdl_Variables.Garr_CasoAfiliacion.length-1;i++){
					objSQL.listaTablaIdCaso("APP_AND_AFILIADO","where ID_CASO="+Mdl_Variables.Garr_CasoAfiliacion[i],2);
					
					while (Mdl_Variables.Grst_TablaLogin.next()){	
						if (banderaAfiliados){
							objPagoMasivoAdministracionPagoBE.informacionCorrespondienteProveedor();
							banderaAfiliados = objRegistroAfiliadosPagosBL.administracionPagos();
							blnResultadoEsperado=banderaAfiliados;
							if (blnResultadoEsperado){
								objFuncionesGenerales.callPasosAcierto(8, "Se agrego todos los proveedores satisfactoriamente", "" ,"");
								strTipoLog="1";
							}else{
								strTipoLog="0";									
								blnResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(8, "No se agrego todos los proveedores ", "" ,"");
							}
							
						}
					}
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
    			CapturarPantalla.scrollCapturaPantalla();
    			CapturarPantalla.scrollCapturaPantallaHorizontal("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/div[2]/div/div[5]");
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
        		
			}
			//-----------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_GUARDARFINAL)){	
				objPagoMasivoAdministracionPagoBE.verificarDetallePagoEnviar();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.ingresoBotonGuardarFinal()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GUARDAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GUARDAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CERRAR_LOTE)){	
				objPagoMasivoAdministracionPagoBE.verificarDetallePagoEnviar();
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
				
				//------------  VALIDANDO CAMBIO SIMBOLO MONEDA EN GRILLAS -----
				String strCadena = "Nuevos";
				String strTexto = objPagoMasivoAdministracionPagoBE.BuscarCadenaTabla(strCadena,"DetallePagoEnviarMonedaOperacion");
				if(!strTexto.equals("")){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla,String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Registro de Afiliados-Tabla, columna Moneda de la Operación", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: En la columna Moneda de la Operacion de la Tabla", "" ,"");
				}
				
				strCadena = "Nuevos";
				strTexto = "";
				strTexto = objPagoMasivoAdministracionPagoBE.BuscarCadenaTabla(strCadena,"DetallePagoEnviarMonedaCuenta");
				if(!strTexto.equals(""))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla,String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Registro de Afiliados-Tabla, columna Moneda de la Cuenta", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: En la columna Moneda de la Cuenta de la Tabla", "" ,"");
				}
				//--------------------------------

				if (objPagoMasivoAdministracionPagoBE.ingresoBotonCerrarLote()){//guardar en base de datos informacion	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR LOTE");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR LOTE");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
        		
			}
			//---------------ENVIO DE LOTES
			if(PagosMasivosAdministracionAfiliadosBE.GstrENVIO_LOTE.equals("SI")){
				objEnvioPagosMasivosBE.verificarTablaCorrecto();
				strTiempoRefresh = 0;
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());
				
				if(objEnvioPagosMasivosBE.esperarTiempoCambioEstado()){
					String strHoraFinRefresh = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					strTiempoRefresh = (new SimpleDateFormat(strFechaHora).parse(strHoraFinRefresh).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
	    			objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla,String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Carga de Lotes Pagos Masivos - Tiempo Refresh de carga", PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion, Long.toString(strTiempoRefresh));
	    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				}
				
				if(objEnvioPagosMasivosBE.seleccionarLoteEnviar(2)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LOTE a enviar en "+ Long.toString(strTiempoRefresh) + " segundos");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LOTE a enviar");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.scrollCapturaPantallaHorizontal("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[1]/div/div[5]");
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_ENVIAR_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoEnviarCorreoCab("SeccionEnvios")){
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
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresarTituloCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO)){
					objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_CORREO, "" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresarMensajeCorreo(PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Envio de Pagos")){
					objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Envio de Pagos", "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + PagosMasivosAdministracionAfiliadosBE.GstrTXT_MENSAJE+" Envio de Pagos", "" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR_CORREO)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoBotonEnviarCorreo()){
					Thread.sleep(3000);
					objEnvioPagosMasivosBE.ingresoBotonEnviarCorreo2();
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
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_EXCEL)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoExportarExcelCab("SeccionEnvios")){
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
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_EXPORTAR_PDF)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoExportarPdfCab("SeccionEnvios")){
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
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_IMPRIMIR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoImprimirCab("SeccionEnvios")){
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
			
			
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR)){	
				
				//--------- VALIDANDO CAMBIO DE SIMBOLO MONEDA EN GRILLAS ------------
				String strCadena = "Nuevos";
				String strTexto = objPagoMasivoAdministracionPagoBE.BuscarCadenaTabla(strCadena,"GeneralPagoEnviarMonedaCuentaCargo");
				if(!strTexto.equals("")){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Envio de Pagos-Tabla, columna Moneda de la CuentaCargo", strCadena, strTexto);
				}else{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: En la columna Moneda de la CuentaCargo de la Tabla", "" ,"");
				}
				//--------------------------------------------------------------------
				
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
				if (objPagoMasivoAdministracionPagoBE.ingresoBotonEnviarLote()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
					strTipoLog="1";
					if(objPagoMasivoAdministracionPagoBE.verificarConfirmacionEnvio()){
						strTiempoRefresh = 0;
						strHoraFinPrueba1= new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
						strTiempoRefresh=(new SimpleDateFormat(strFechaHora).parse(strHoraFinPrueba1).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla,String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Envio del lote", strTxtDescripcion, Long.toString(strTiempoRefresh));
					}
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)&&!GstrTXT_COLUMNA_ERROR.equals("BTN_ENVIAR")){
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objEnvioPagosMasivosBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE.equals("SI")&&objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
					strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
					if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						strTipoLog="1";
					}else{
						strTipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					}
					strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
	    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresarClaveDinamica(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica", PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La clave dinamica", PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA,"");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			    CapturarPantalla.scrollCapturaPantalla();
			    CapturarPantalla.scrollCapturaPantallaHorizontal("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[2]/div/div/div[5]");
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CONFIRMAR)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoBotonConfirmar()){//se guarda en base de datos	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					
					if(objPagoMasivoAdministracionPagoBE.verificarResusltado()){
						strTiempoRefresh = 0;
						strHoraFinPrueba1= new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
						strTiempoRefresh=(new SimpleDateFormat(strFechaHora).parse(strHoraFinPrueba1).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Confirmar Lote", strTxtDescripcion, Long.toString(strTiempoRefresh));
					}
					
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
    			CapturarPantalla.scrollCapturaPantalla();
			   	CapturarPantalla.scrollCapturaPantallaHorizontal("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]");
	    		
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
			//-----faltaaaaaa
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CANCELAR_OPERACION)){	
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
				if (objEnvioPagosMasivosBE.ingresoBotonCancelarOperacion()){	
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
				strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
				if (objEnvioPagosMasivosBE.compararMensajeResultante(GstrRESULTADO_ESPERADO)){	
					objEnvioPagosMasivosBE.guardarDatosOperacion();
					
					if(GstrFIRMAR.equals("NO") && PagosMasivosAdministracionAfiliadosBE.GstrESTADO.equals("Procesada")){
						blnResultadoEsperado=objConsultaHistoricaBL.consultaHistorico("Pagos Masivos",strCmbEmpresa,GstrCMB_CUENTA_CARGO,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,strIdCaso);
					}
					
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"se compara resultado esperado");
					strTipoLog="1";
				}else{
					strTipoLog="0";										
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"se compara resultado esperado");
				}
				strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
    			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
			   	objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
			}
		
		
			
			//------------------------------------------------------REALIZA EL PAGO------------------------------------------------------
			if (blnResultadoEsperado&& GstrFIRMAR.equals("SI")){
				blnResultadoEsperado=firmasAdministracionPagosMasivos();
			}
		
			if (objFuncionesGenerales.verificarIgnore("CLICK")){	
				objHeader.cerrarSesion("CLICK","CLICK");
			}
		} catch (Exception e) {
 			blnResultadoEsperado=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado;
	}

	public boolean firmasAdministracionPagosMasivos()  {
		boolean blnResultadoEsperadoFirmas=true;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		String strTextoImagen="1. Imagenes";
		
		try {
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
			
			if (PagosMasivosAdministracionAfiliadosBE.strSoloFirma.equals("NO")){
				objHeader.cerrarSesion(PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION,PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))	{
				if (GstrFIRMANTE1.equals("PA")  ){
					blnResultadoEsperadoFirmas=objFirmarBL.firmaPagos("APP_AND_PAGOS_MASIVOS_AUTORIZAR_D",strIdCaso,"F1",consultar1);
				}else if (GstrFIRMANTE1.equals("PORT")  ){
					blnResultadoEsperadoFirmas=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",strIdCaso,"F1' AND LBL_TIPO_OPERACION='Pagos Masivos",consultar1,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_CARGO,null);
				}else{
					blnResultadoEsperadoFirmas=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",strIdCaso,"F1",PagosMasivosAdministracionAfiliadosBE.strCmbProducto,consultar1);
				}
			}
			
			if(blnResultadoEsperadoFirmas){
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
					if (GstrFIRMANTE2.equals("PA") ){
						blnResultadoEsperadoFirmas=objFirmarBL.firmaPagos("APP_AND_PAGOS_MASIVOS_AUTORIZAR_D",strIdCaso,"F2",consultar2);
					}else if (GstrFIRMANTE2.equals("PORT") ){
						blnResultadoEsperadoFirmas=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",strIdCaso,"F2' AND LBL_TIPO_OPERACION='Pagos Masivos",consultar2,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_CARGO,null);
					}else{
						blnResultadoEsperadoFirmas=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",strIdCaso,"F2",PagosMasivosAdministracionAfiliadosBE.strCmbProducto,consultar2);
					}
				}
				
				if(blnResultadoEsperadoFirmas){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
						if (GstrFIRMANTE3.equals("PA")){
							blnResultadoEsperadoFirmas=objFirmarBL.firmaPagos("APP_AND_PAGOS_MASIVOS_AUTORIZAR_D",strIdCaso,"F3",consultar3);
						}else if (GstrFIRMANTE3.equals("PORT")){
							blnResultadoEsperadoFirmas=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",strIdCaso,"F3' AND LBL_TIPO_OPERACION='Pagos Masivos",consultar3,GstrCONSULTAR_SALDOS_MOVIMIENTOS,GstrCMB_CUENTA_CARGO,null);
						}else{
							blnResultadoEsperadoFirmas=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",strIdCaso,"F3",PagosMasivosAdministracionAfiliadosBE.strCmbProducto,consultar3);
						}
					}
					
					if(blnResultadoEsperadoFirmas&& objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
						blnResultadoEsperadoFirmas=objFirmarBL.firmaPagos("APP_AND_PAGOS_MASIVOS_AUTORIZAR_D",strIdCaso,"OP",true);
					}
				}
			}
		} catch (Exception e) {
			blnResultadoEsperadoFirmas=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperadoFirmas;
	}

}
