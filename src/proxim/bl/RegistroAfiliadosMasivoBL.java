package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.RegistroAfiliadosPagosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class RegistroAfiliadosMasivoBL {

	RegistroAfiliadosPagosBE objRegistroAfiliadosBL = new RegistroAfiliadosPagosBE();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosMasivosAdministracionAfiliadosMapeo objTransferenciaGeneralBE = new PagosMasivosAdministracionAfiliadosMapeo();
	ConexionBL objConexionBL = new ConexionBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();

	public boolean administracionAfiliados() throws SQLException, IOException{
		boolean blnResultadoEsperado = objRegistroAfiliadosBL.Afiliados(Mdl_Variables.Grst_TablaLogin, 1);
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;
		String TipoLog = null;
		
		try {
		
			if(blnResultadoEsperado){
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO)){		
					LStr_HoraInicio = System.currentTimeMillis();	  
					
					if (objTransferenciaGeneralBE.ingresarCodigoBeneficiario(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Código del Trabajador ", RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Código del Trabajador ", RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.seleccionarTipoPersona(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarNombreRazonSocial(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Nombre / Razón Social ", RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Nombre / Razón Social ", RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.seleccionarDocumentoIdentidad(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarDocumentoIdentidad(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Documento de Identidad ", RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Documento de Identidad ", RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarDireccion(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Dirección ", RegistroAfiliadosPagosBE.GstrTXT_DIRECCION,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Dirección ", RegistroAfiliadosPagosBE.GstrTXT_DIRECCION,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_EMAIL)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarEmail(RegistroAfiliadosPagosBE.GstrTXT_EMAIL))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " E-Mail ", RegistroAfiliadosPagosBE.GstrTXT_EMAIL,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " E-Mail ", RegistroAfiliadosPagosBE.GstrTXT_EMAIL,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.seleccionarTipoAbonoSoles(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarMontoLimiteSoles(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Monto Límite Soles ", RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Monto Límite Soles ", RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.seleccionarTipoCuentaSoles(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarNumeroCuentaSoles(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Número de Cuenta Soles ", RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Número de Cuenta Soles ", RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLARES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.seleccionarTipoAbonoDolares(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLARES))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLARES , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLARES , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLARES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarMontoLimiteDolares(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLARES))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Monto Límite Dólares ", RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLARES,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Monto Límite Dólares ", RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLARES,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.seleccionarTipoCuentaDolares(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES))
					{	
						objFuncionesGenerales.callPasosAcierto(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)){		
					LStr_HoraInicio = System.currentTimeMillis();	
					
					if (objTransferenciaGeneralBE.ingresarNumeroCuentaDolares(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES))
					{	
						objFuncionesGenerales.callPasosAcierto(3, " Número de Cuenta Dólares ", RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES,"");
						TipoLog="1";
					}else{
						TipoLog="0";	
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, " Número de Cuenta Dólares ", RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES,"");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_GUARDAR)){		
					LStr_HoraInicio = System.currentTimeMillis();	
							
					if (objTransferenciaGeneralBE.ingresoBotonGuardar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GUARDAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GUARDAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_AGREGAR_NUEVO_PROVEEDOR)){		
					LStr_HoraInicio = System.currentTimeMillis();	
								
					if (objTransferenciaGeneralBE.ingresoBotonAgregarNuevoProveedor()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR NUEVO TRABAJADOR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR NUEVO TRABAJADOR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_CONTINUARNEW)){		
					LStr_HoraInicio = System.currentTimeMillis();	
								
					if (objTransferenciaGeneralBE.ingresoBotonContinuarNuevo()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						blnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

			}
		} catch (Exception e) {
			blnResultadoEsperado = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "ACIERTO_ERROR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));	          
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "\\1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado;
	}
}
