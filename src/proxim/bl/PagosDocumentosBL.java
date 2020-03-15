package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosDocumentosBL extends PagosDocumentosBE {

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	PagosDocumentosMapeo objPagoDocumentosBE = new PagosDocumentosMapeo();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	FirmarBL objFirmarBL =new FirmarBL();
	HeaderBL objHeader = new HeaderBL();
	public boolean pagoDocumentos() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		try {
			
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "LBN_DOCUM_SELECCIONADOS", "", Integer.toString(Mdl_Variables.Gint_IdCaso));
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "LBN_DOCUM_NO_SELECCIONADOS", "", Integer.toString(Mdl_Variables.Gint_IdCaso));
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "LBN_ESTADO_LOTE_MENSAJE", "", Integer.toString(Mdl_Variables.Gint_IdCaso));
			
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			
			if(GstrVALIDAR_POP.equals("SI")){
				
				if (objFuncionesGenerales.verificarIgnore("CLICK"))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.verificarMensajeInformativo())
					{	
						objFuncionesGenerales.callPasosAcierto(6, " EL MENSAJE INFORMATIVO" , "" ,  "");
						TipoLog="1";
						Thread.sleep(15000);
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(6, " EL MENSAJE INFORMATIVO" , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(bandera){
					if (objFuncionesGenerales.verificarIgnore("CLICK"))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objPagoDocumentosBE.ingresoAceptar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
							TipoLog="1";
							objPagoDocumentosBE.verificarCamposObligatoriosDocumentos();
							
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				
					if (objFuncionesGenerales.verificarIgnore(GstrVALIDAR_TAP))
					{
						if (objFuncionesGenerales.verificarIgnore("Pagos por Autorizar"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pagos por Autorizar"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pagos por Autorizar");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosAutorizar();
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pagos por Autorizar");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("Pagos Procesados"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pagos Procesados"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pagos Procesados");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosProcesadas();
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pagos Procesados");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("Pagos Bloqueados"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pagos Bloqueados"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pagos Bloqueados");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosBloqueados();
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pagos Bloqueados");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("Pago de Documentos"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pago de Documentos"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pago de Documentos");
								TipoLog="1";
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pago de Documentos");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
					
				
						if (objFuncionesGenerales.verificarIgnore("CLICK"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							if (objPagoDocumentosBE.verificarMensajeInformativo())
							{	
								objFuncionesGenerales.callPasosAcierto(6, " EL MENSAJE INFORMATIVO" , "" ,  "");
								TipoLog="1";
								Thread.sleep(8000);
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(6, " EL MENSAJE INFORMATIVO" , "" ,  "");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if(bandera){
							if (objFuncionesGenerales.verificarIgnore("CLICK"))
							{	
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objPagoDocumentosBE.ingresoAceptar()){	
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
									TipoLog="1";
									objPagoDocumentosBE.verificarCamposObligatoriosDocumentos();
									
								}else{
									TipoLog="0";			
									bandera = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
								}
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							}
						}
					}
				}
			}else if (GstrVALIDAR_POP.equals("NO")){
				if (objFuncionesGenerales.verificarIgnore("CLICK"))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					Thread.sleep(1000);
					if (!objPagoDocumentosBE.verificarNoMensajeInformativo())
					{	
						objFuncionesGenerales.callPasosAcierto(8, " NO EXISTE EL MENSAJE INFORMATIVO" , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(8, " EXISTE EL MENSAJE INFORMATIVO" , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(bandera){
					if (objFuncionesGenerales.verificarIgnore(GstrVALIDAR_TAP))
					{
						if (objFuncionesGenerales.verificarIgnore("Pagos por Autorizar"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pagos por Autorizar"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pagos por Autorizar");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosAutorizar();
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pagos por Autorizar");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("Pagos Procesados"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pagos Procesados"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pagos Procesados");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosProcesadas();
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pagos Procesados");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("Pagos Bloqueados"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pagos Bloqueados"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pagos Bloqueados");
								TipoLog="1";
								objPagoDocumentosBE.verificarCamposObligatoriosBloqueados();
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pagos Bloqueados");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("Pago de Documentos"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
							if (objPagoDocumentosBE.seleccionarSubMenu1("Pago de Documentos"))
							{	
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+"Pago de Documentos");
								TipoLog="1";
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+"Pago de Documentos");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if (objFuncionesGenerales.verificarIgnore("CLICK"))
						{	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							Thread.sleep(1000);
							if (!objPagoDocumentosBE.verificarNoMensajeInformativo())
							{	
								objFuncionesGenerales.callPasosAcierto(8, " NO EXISTE EL MENSAJE INFORMATIVO" , "" ,  "");
								TipoLog="1";
							}else{
								TipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(8, " EXISTE EL MENSAJE INFORMATIVO" , "" ,  "");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						
						
						
					}
				}
				
				
	
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarEmpresa(GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strCMB_BUSQUEDA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarBusqueda(strCMB_BUSQUEDA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la BUSQUEDA "+strCMB_BUSQUEDA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la BUSQUEDA "+strCMB_BUSQUEDA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strCMB_SITUACION))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarSituacion(strCMB_SITUACION))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la SITUACION "+strCMB_SITUACION , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la SITUACION "+strCMB_SITUACION , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strCMB_MONEDA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarMoneda(strCMB_MONEDA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+strCMB_MONEDA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+strCMB_MONEDA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strTXT_NRO_DOCUMENTO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresarNroDocumento(strTXT_NRO_DOCUMENTO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "NUMERO DE DOCUMENTO: ", strTXT_NRO_DOCUMENTO ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE DOCUMENTO: ", strTXT_NRO_DOCUMENTO ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBTN_BUSCAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonBuscar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strNUMERO_DOCUMENTOS))
			{	
				objPagoDocumentosBE.verificarTabla();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				int pos = 0;
				int ant = 0;
				int indUltimo = strNUMERO_DOCUMENTOS.lastIndexOf("|");
				String strDoc = "";
				String strDocumSeleccionados = "";
				String strDocumNoSeleccionados = "";
				
				if(strNUMERO_DOCUMENTOS.lastIndexOf("|") == -1)
				{
					strDoc = strNUMERO_DOCUMENTOS.trim();
					if(strDoc != "")				    {
				    	if(objPagoDocumentosBE.seleccionarCheckDocumento(strDoc)){
				    		strDocumSeleccionados += strDocumSeleccionados+","+strDoc;
				    	}
				    	else				    	{
				    		strDocumNoSeleccionados += strDocumNoSeleccionados+","+strDoc;
				    	}
				    }
				}
				
				while ((pos = strNUMERO_DOCUMENTOS.indexOf("|", pos)) != -1) {
					//-------------OBTENIENDO CADA DOCUMENTO------------
					strDoc = strNUMERO_DOCUMENTOS.substring(ant,pos).trim() ;
					if(indUltimo == pos)
					{
						int nLargo = strNUMERO_DOCUMENTOS.length();
						if (nLargo > pos+1){
							strDoc = strNUMERO_DOCUMENTOS.substring(pos+1,nLargo);	
						}
						else {
							strDoc = "";
						}
					}
				    ant = pos + 1;
				    pos++;
				    
				    //------------SELECCIONANDO LOS DOCUMENTOS------------
				    if(strDoc != "")				    {
				    	if(objPagoDocumentosBE.seleccionarCheckDocumento(strDoc)){
				    		strDocumSeleccionados += strDocumSeleccionados+","+strDoc;
				    	}
				    	else				    	{
				    		strDocumNoSeleccionados += strDocumNoSeleccionados+","+strDoc;
				    	}
				    }
				}
				
				if (strDocumSeleccionados!= "")	{
					objFuncionesGenerales.callPasosAcierto(2, strDocumSeleccionados, "" ,  "");
					objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "LBN_DOCUM_SELECCIONADOS", strDocumSeleccionados, Integer.toString(Mdl_Variables.Gint_IdCaso));
					TipoLog="1";
				}
				if (strDocumNoSeleccionados!= ""){
					objFuncionesGenerales.callPasosErrado(2, strDocumNoSeleccionados, "" ,  "");
					objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "LBN_DOCUM_NO_SELECCIONADOS", strDocumNoSeleccionados, Integer.toString(Mdl_Variables.Gint_IdCaso));
					TipoLog="0";
					bandera = false;
				}
				
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBTN_CONTINUAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonContinuar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strTXT_COLUMNA_ERROR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.verificarMensajeFinal()){	
					objFuncionesGenerales.callPasosAcierto(5, " el Mensaje Informativo", "Mensaje esperado" ,"");
					TipoLog="1";
					Thread.sleep(15000);
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, " el Mensaje Informativo", "Mensaje esperado" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore("CLICK") && strTXT_COLUMNA_ERROR.equals("BTN_CONTINUAR"))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoDocumentosBE.ingresoMensajeAceptar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strCMB_CUENTA_CARGO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.seleccionarCuentaCargo(strCMB_CUENTA_CARGO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA CARGO "+strCMB_CUENTA_CARGO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA CARGO "+strCMB_CUENTA_CARGO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strTXT_CLAVE)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoClave(Mdl_Variables.Gstr_Clave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA, ", Mdl_Variables.Gstr_Clave,"");
					objPagoDocumentosBE.ingresarClaveDinamica("121212");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA, ", Mdl_Variables.Gstr_Clave,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strBTN_CONFIRMAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonConfirmar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if (objFuncionesGenerales.verificarIgnore(strBTN_CANCELAR_OPERACION))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objPagoDocumentosBE.ingresoBotonCancelarOperacion()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACION");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACION");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}	
			//CH
			if (objFuncionesGenerales.verificarIgnore(strRESULTADO_ESPERADO))
			{	
				
				CapturarPantalla.scrollCapturaPantallaArriba() ;//CHA
				CapturarPantalla.capturaPantalla(Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );//CHA
				objPagoDocumentosBE.verificarImagenPagoEnviado();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				String strResultadoObtenido = objPagoDocumentosBE.obtenerResultado();
				System.out.println(">>> strRESULTADO_ESPERADO >> strResultadoObtenido : " + strResultadoObtenido);
				if (strResultadoObtenido.equals(strRESULTADO_ESPERADO))
				{	System.out.println(">>> strRESULTADO_ESPERADO >> strResultadoObtenido OK");
					objFuncionesGenerales.callPasosAcierto(5, strRESULTADO_ESPERADO, strResultadoObtenido,"");
					TipoLog="1";
					String strResultadoLoteMensaje = objPagoDocumentosBE.obtenerEstadoLoteMensaje();
					
					objConexionBL.actualizarTabla(Mdl_Variables.Gstr_Tabla, "LBN_ESTADO_LOTE_MENSAJE", strResultadoLoteMensaje, Integer.toString(Mdl_Variables.Gint_IdCaso));
					
				}else{
					System.out.println(">>> strRESULTADO_ESPERADO >> strResultadoObtenido NOT");
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, strRESULTADO_ESPERADO, strResultadoObtenido ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
				
			
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(strRESULTADO_ESPERADO))
				{
					if (objPagoDocumentosBE.compararResultadoEsperadoPositivo()){	
						objPagoDocumentosBE.GuardarDatosOperacion();
						
						if(GstrFIRMAR.equals("NO") && !GstrESTADO.equals("<IGNORE>")){
							bandera=objConsultaHistoricaBL.consultaHistorico("Pago de Documentos",GstrCMB_EMPRESA,strCMB_CUENTA_CARGO,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
						}
					}
				}
			}
			
		
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
			
		if(bandera&& GstrFIRMAR.equals("SI")){
				
			if(GstrPOTERGACION.equals("<IGNORE>")){
				if (!GstrFIRMANTE3.equals("<IGNORE>")){
					consultar3=true;
				}else if (!GstrFIRMANTE2.equals("<IGNORE>")){
					consultar2=true;
				}else if (!GstrFIRMANTE1.equals("<IGNORE>")){
					consultar1=true;
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))
			{
				if (GstrFIRMANTE1.equals("PA") || GstrFIRMANTE1.equals("PA-B") ){
					bandera=objFirmarBL.firmaDocumentos("APP_PAGOS_DOCUMENTOS_AUTORIZAR_D",Gstr_ID_CASO,"F1",consultar1);
				}else if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
					bandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Pago de Documentos",consultar1,GstrCONSULTAR_SALDOS_MOVIMIENTOS,strCMB_CUENTA_CARGO,null);
				}else{
					bandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F1",GstrTXT_SUBMENU1,consultar1);
				}
			}
				
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2))
				{
					if (GstrFIRMANTE2.equals("PA") || GstrFIRMANTE2.equals("PA-B") ){
						bandera=objFirmarBL.firmaDocumentos("APP_PAGOS_DOCUMENTOS_AUTORIZAR_D",Gstr_ID_CASO,"F2",consultar2);
					}else if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
						bandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Pago de Documentos",consultar2,GstrCONSULTAR_SALDOS_MOVIMIENTOS,strCMB_CUENTA_CARGO,null);
					}else{
						bandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F2",GstrTXT_SUBMENU1,consultar2);
					}
				}
				
				if(bandera){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3))
					{
						if (GstrFIRMANTE3.equals("PA") || GstrFIRMANTE3.equals("PA-B") ){
							bandera=objFirmarBL.firmaDocumentos("APP_PAGOS_DOCUMENTOS_AUTORIZAR_D",Gstr_ID_CASO,"F3",consultar3);
						}else if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
							bandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Pago de Documentos",consultar3,GstrCONSULTAR_SALDOS_MOVIMIENTOS,strCMB_CUENTA_CARGO,null);
						}else{
							bandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",Gstr_ID_CASO,"F3",GstrTXT_SUBMENU1,consultar3);
						}
					}
					
					if(bandera){
						if(objFuncionesGenerales.verificarIgnore(GstrPOTERGACION)&&(GstrPOTERGACION.equals("PA")||GstrPOTERGACION.equals("PA-B"))){
							bandera=objFirmarBL.firmaDocumentos("APP_PAGOS_DOCUMENTOS_AUTORIZAR_D",Gstr_ID_CASO,"OP",true);
						}
					}
				}
			}
		}
		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
		
	}
	
}
