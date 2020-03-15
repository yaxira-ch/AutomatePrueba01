package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.PagosRecibosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosRecibosProcesadosBL extends PagosRecibosBE{

	
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosRecibosMapeo objPagoRecibosBE = new PagosRecibosMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean pagosRecibosProcesados(int valor) throws SQLException, IOException{
		boolean bandera = true;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio;	
		String strTipoLog = null;
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String strTextoImagen="1. Imagenes";
		int intNum=0;
		try {
			//-------------------------------------------------------MENU----------------------------------------------------------------
			if(valor==2){	
				objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, GstrTXT_MENU, GstrTXT_SUBMENU);
			}
			
			String subMenu="Pagos Procesados";
			if (objFuncionesGenerales.verificarIgnore(subMenu)){	
				objPagoRecibosBE.verificarPestania();
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarSubMenu1(subMenu)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+subMenu);
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+subMenu);
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			//---------------------------------------------------------------------------------------------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){	
				objPagoRecibosBE.verificarPagoResivos();
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarEmpresaProcesado(GstrCMB_EMPRESA)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
					
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO)){		
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarCuenta(GstrCMB_CUENTA_CARGO)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore("Por lote pagado")){		
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.seleccionarTipoBusquedaProcesado("Por lote pagado")){	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE BUSQUEDA "+"Por lote pagado" , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE BUSQUEDA "+"Por lote pagado" , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_SOLICITUD)){	
				strHoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarNombreSolicitudProcesado(GstrTXT_NOMBRE_SOLICITUD)){	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DE LA SOLICITUD: "+GstrTXT_NOMBRE_SOLICITUD , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DE LA SOLICITUD: "+GstrTXT_NOMBRE_SOLICITUD , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda)){	
				strHoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarFechaSolicitudDesdeProcesado(fechaBusqueda)){	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA PAGO DESDE: "+fechaBusqueda , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA PAGO DESDE: "+fechaBusqueda , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda)){	
				strHoraInicio = System.currentTimeMillis();	  	
				if (objPagoRecibosBE.ingresarFechaSolicitudHastaProcesado(fechaBusqueda)){	
					objFuncionesGenerales.callPasosAcierto(3, "LA FECHA PAGO HASTA: "+fechaBusqueda , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "LA FECHA PAGO HASTA: "+fechaBusqueda , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
				
			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.ingresoBotonBuscarProcesado()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){	
				strHoraInicio = System.currentTimeMillis();	  
				objPagoRecibosBE.verificarTablaProcesados();
				intNum=objPagoRecibosBE.verificarPagoProcesado();
				if (intNum!=0){	//Falta validar datos del registro buscado
					objFuncionesGenerales.callPasosAcierto(6, "La operación realizada", "" ,"");
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(6, "La operación realizada", "" ,"");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (intNum!=0){
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagoRecibosBE.verificarPagoDetalleProcesado(intNum)){	//Falta validar datos del registro buscado
					objFuncionesGenerales.callPasosAcierto(3, "en el Detalle del Pago", "" ,"");
					Thread.sleep(900); 
				}else{									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "en el Detalle del Pago", "" ,"");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
    			CapturarPantalla.scrollCapturaPantalla();
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
	