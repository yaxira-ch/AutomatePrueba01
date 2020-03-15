package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.FinanciamientoDocumentosEleConProAfiBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosElePreAfiProBL extends FinanciamientoDocumentosEleConProAfiBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDocumentosElePreAfiProMapeo objFinanciamientoDocumentosEleConProAfiBE = new FinanciamientoDocumentosElePreAfiProMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	FinanciamientoDocumentosEleConProAfiBL objFinanciamientoDocumentosEleConProAfiBL = new FinanciamientoDocumentosEleConProAfiBL();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean FinanciamientoDocumentosElePreAfiPro() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio;
		String TipoLog = null;
		try {
			
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
				objFinanciamientoDocumentosEleConProAfiBE.verificarCamposObligatoriosConsultaAfiliados();
				
				if(GstrTXT_PESTANA.equals("2")){
			
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_SUBMENU1)){	
				
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.seleccionarSubMenu1( GstrTXT_SUBMENU1))
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la pestaña "+GstrTXT_SUBMENU1);
						TipoLog="1";
					}else{
						TipoLog="0";		
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la pestaña "+GstrTXT_SUBMENU1);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				objFinanciamientoDocumentosEleConProAfiBE.verificarEnvioCamposObligatoriosPreAfiliacion();
				//------------------------------------------------------------------------------
							
				if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.seleccionarEmpresaPreAfiliacion( GstrCMB_EMPRESA))
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
				
				
				if (objFuncionesGenerales.verificarIgnore( GstrCMB_PRODUCTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.seleccionarProductoPreAfiliacion( GstrCMB_PRODUCTO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+GstrCMB_PRODUCTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPODOCUMENTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.seleccionarTipoDocumentoPreAfiliacion( GstrCMB_TIPODOCUMENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE DOCUMENTO "+GstrCMB_TIPODOCUMENTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del TIPO DE DOCUMENTO "+GstrCMB_TIPODOCUMENTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_NUMERODOCUMENTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarNumeroDocumentoPreAfiliacion(GstrTXT_NUMERODOCUMENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El NÚMERO DEL DOCUMENTO "+GstrTXT_NUMERODOCUMENTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El NÚMERO DEL DOCUMENTO "+GstrTXT_NUMERODOCUMENTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRERAZONSOCIAL)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarNombreRazonSocialPreAfiliacion(GstrTXT_NOMBRERAZONSOCIAL))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE/RAZÓN SOCIAL "+GstrTXT_NOMBRERAZONSOCIAL , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE/RAZÓN SOCIAL "+GstrTXT_NOMBRERAZONSOCIAL , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRECONTACTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarNombrePreAfiliacion(GstrTXT_NOMBRECONTACTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "EL NOMBRE DEL CONTACTO "+GstrTXT_NOMBRECONTACTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "EL NOMBRE DEL CONTACTO "+GstrTXT_NOMBRECONTACTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_TELEFONOCONTACTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarTelefonoPreAfiliacion(GstrTXT_TELEFONOCONTACTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "EL TELEFONO DEL CONTACTO "+GstrTXT_TELEFONOCONTACTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "EL TELEFONO DEL CONTACTO "+GstrTXT_TELEFONOCONTACTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
	
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_EMAILCONTACTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarEmailPreAfiliacion(GstrTXT_EMAILCONTACTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "EL EMAIL DE CONTACTO "+GstrTXT_EMAILCONTACTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "EL EMAIL DE CONTACTO "+GstrTXT_EMAILCONTACTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
	
				if (objFuncionesGenerales.verificarIgnore( GstrBTN_PREAFILIAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresoBotonPreafiliarPreAfiliacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón PREAFILIAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón PREAFILIAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
	    			
	    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(objFinanciamientoDocumentosEleConProAfiBE.verificarTablaPreAfiliacionProveedores()){
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					String fechaRegistro = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
					String estado="Pendiente";
					if (objFinanciamientoDocumentosEleConProAfiBE.verificarPreAfiliacionProveedores(GstrCMB_EMPRESA,GstrCMB_PRODUCTO,GstrTXT_NOMBRERAZONSOCIAL,GstrTXT_NUMERODOCUMENTO,GstrTXT_TELEFONOCONTACTO,GstrTXT_EMAILCONTACTO,fechaRegistro,estado)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"registro encontrado");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"registro encontrado");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresoLinkEnviarEmailPreAfiliacion()){	
						objFinanciamientoDocumentosEleConProAfiBE.verificarTablaCorreoPreAfiliacion();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Enviar Email");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Enviar Email");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarCorreoPreAfiliacion( GstrTXT_CORREO_PREAFILIACION))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO_PREAFILIACION , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO_PREAFILIACION , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresarMensajeCorreoPreAfiliacion( GstrTXT_MENSAJE_CORREO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresoBotonEnviarCorreoPreAfiliacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(objFinanciamientoDocumentosEleConProAfiBE.verificarTablaCorreoConfirmacionPreAfiliacion()){
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO_PREAFILIACION))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDocumentosEleConProAfiBE.ingresoBotonAceptarCorreoPreAfiliacion()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresoLinkExportarExcelPreAfiliacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar EXCEL");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresoLinkExportarPDFPreAfiliacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Exportar PDF");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Exportar PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR_PREAFILIACION))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleConProAfiBE.ingresoLinkImprimirPreAfiliacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Imprimir");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Imprimir");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
				
				objFinanciamientoDocumentosEleConProAfiBL.FinanciamientoDocumentosEleConProAfi();
		} catch (Exception e) {
			bandera=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	
		}
		return bandera;
	}
}
