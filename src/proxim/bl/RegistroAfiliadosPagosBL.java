package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import proxim.be.RegistroAfiliadosPagosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class RegistroAfiliadosPagosBL extends RegistroAfiliadosPagosBE{
	private static String TipoLog = null;
	RegistroAfiliadosPagosBE objRegistroAfiliadosBL = new RegistroAfiliadosPagosBE();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	pagosMasivosAdministracionTest objPagoMasivoAdministracionPagoBE = new pagosMasivosAdministracionTest();
	ConexionBL objConexionBL = new ConexionBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();

	public boolean administracionPagos() throws SQLException, IOException{
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		boolean bandera = objRegistroAfiliadosBL.Afiliados(Mdl_Variables.Grst_TablaLogin, 2);
		long LStr_HoraInicio;	 
		
		try {
		
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA))
				{	
					//objPagoMasivoAdministracionPagoBE.informacionCorrespondienteProveedor();//--
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarTipoPersona(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrLNK_VER_PROVEEDOR)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoLinkVerProveedor()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link VER PROVEEDOR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link VER PROVEEDOR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrRDB_NOMBRE)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoRdbNombre()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en NOMBRE");
					}	else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en NOMBRE");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrRDB_NUMERO_DOCUMENTO)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoRdbNumeroDocumento()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en NUMERO DOCUMENTO IDENTIDAD");
					}	else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en NUMERO DOCUMENTO IDENTIDAD");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarTipoDocumentoIdentidad(GstrCMB_DOCUMENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_BUSCAR))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarTextoBuscar(GstrTXT_BUSCAR,GstrCMB_DOCUMENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Texto a buscar", GstrTXT_BUSCAR,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Texto a buscar", GstrTXT_BUSCAR,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_BUSCAR)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonBuscar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el BOTON BUSCAR");
					}	else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el BOTON BUSCAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				 
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrRDB_SELECCIONAR_PROVEEDOR))//-----pendiente
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarTipoPersona(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				
			  if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_ACEPTAR)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonAceptar1()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el BOTON ACEPTAR");
					}	else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el BOTON ACEPTAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				  
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarNombreRazonSocial(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Nombre o Razón Social", RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Nombre o Razón Social", RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarCodigoBeneficiario(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Código del beneficiario", RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Código del beneficiario", RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarDocumentoIdentidad(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD))
				{			
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarDocumentoIdentidad(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Documento de Identidad", RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Documento de Identidad", RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarTipoAbono(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarTipoCuenta(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_MONEDA))
				{
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarMoneda(RegistroAfiliadosPagosBE.GstrCMB_MONEDA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_MONEDA , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_MONEDA , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_NUMERO_CUENTA))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarNumeroCuenta(RegistroAfiliadosPagosBE.GstrCMB_NUMERO_CUENTA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_NUMERO_CUENTA , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_NUMERO_CUENTA , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCHK_INGRESAR_NUEVA_CUENTA)){	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.checkIngresarNuevaCuenta()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarNumeroCuenta(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA,RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_PAGO))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarDocuementoPago(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_PAGO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_PAGO , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_PAGO , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_PAGO))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarDocuementoPago(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_PAGO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_PAGO,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_PAGO,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_FECHA_VENCIMIENTO))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	
					Date fechaActual=new Date();
					DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
					Calendar cal=Calendar.getInstance();
					cal.setTime(fechaActual);
					cal.add(Calendar.DATE, 1);
					Date nuevaFecha=cal.getTime();
					
					String fecha= formatoFecha.format(nuevaFecha);
					RegistroAfiliadosPagosBE.GstrTXT_FECHA_VENCIMIENTO=fecha;
					objSQL.actualizarTabla("APP_AND_AFILIADO", "TXT_FECHA_VENCIMIENTO", fecha, RegistroAfiliadosPagosBE.GstrID_CASO);
					if (objPagoMasivoAdministracionPagoBE.ingresarFechaVencimiento(RegistroAfiliadosPagosBE.GstrTXT_FECHA_VENCIMIENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_FECHA_VENCIMIENTO,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_FECHA_VENCIMIENTO,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_OPERACION))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarMonedaMontoOperacion(RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_OPERACION))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_OPERACION , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_OPERACION , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_OPERACION))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarMonedaMontoOperacion(RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_OPERACION))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_OPERACION,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_OPERACION,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_INTANGIBLE))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.seleccionarMonedaMontoIntangible(RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_INTANGIBLE))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_INTANGIBLE , "" ,  "");
					}else{			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_INTANGIBLE , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_INTANGIBLE))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresarMonedaMontoIntangible(RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_INTANGIBLE))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_INTANGIBLE,"");
					}else{	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Operaciones frecuentes", RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_INTANGIBLE,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCHK_PAGO_AFECTO_REENCION)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.checkPagoEfectoRetencion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check de PAGO AFECTO A RETENCIÓN");
						
						String strCadena = "S/.";
						String strTexto = objPagoMasivoAdministracionPagoBE.ObtenerMensajeMontoPagoRetencion();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO: en la cadena "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Registro de Afiliados-Check Monto de Retencion", strCadena, strTexto);
						}else{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO: en la cadena "+strTexto, "" ,"");
						}
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check de PAGO AFECTO A RETENCIÓN");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_GUARDAR)){		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonGuardar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GUARDAR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GUARDAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objPagoMasivoAdministracionPagoBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR))
					{	
						objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";										
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_AGREGAR_NUEVO_PROVEEDOR)){	
					objPagoMasivoAdministracionPagoBE.verificarPopUp();
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonAgregarNuevoTrabajador1()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR NUEVO PROVEEDOR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR NUEVO PROVEEDOR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	        		
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_CONTINUARNEW)){	
					objPagoMasivoAdministracionPagoBE.verificarPopUp();
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonContinuarNuevo()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	        		objPagoMasivoAdministracionPagoBE.verificarMovimientos_AND3();
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_AGREGAR_NUEVO_PROVEEDOR_FINAL)){	
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objPagoMasivoAdministracionPagoBE.ingresoBotonAgregarNuevoTrabajador()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					}
					else{									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
		} catch (Exception e) {
			bandera=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
}
