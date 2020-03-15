package proxim.ui;

import java.net.InetAddress;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import proxim.be.AutorizacionesPendientesBE;
import proxim.be.ComercioExtCartaFianzaGeneralBE;
import proxim.be.ComercioExtCartaFianzaRenovacionBE;
import proxim.be.ConsultaDietariosBE;
import proxim.be.ConsultaDocumentoElectronicoBE;
import proxim.be.ConsultaDocumentosRelacionPagaresBE;
import proxim.be.ConsultaLeasingBE;
import proxim.be.ConsultaPedidosBE;
import proxim.be.ConsultaRecaudacionBE;
import proxim.be.ConsultaSaldosMovimientosBE;
import proxim.be.ContratosDigitalesBE;
import proxim.be.FinanciamientoDescuentosCobCarteraDocumentosBE;
import proxim.be.FinanciamientoDescuentosCobConsultaDocumentosBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasGeneralBE;
import proxim.be.FinanciamientoDescuentosCobNotifiVencimientoBE;
import proxim.be.FinanciamientoDesembolsoLineaBE;
import proxim.be.FinanciamientoDocumentosEleConProAfiBE;
import proxim.be.FinanciamientoDocumentosEleConsultasAdeVenBE;
import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasBE;
import proxim.be.FinanciamientoDocumentosEleReportesBE;
import proxim.be.MonitoreoTransaccionesGeneralBE;
import proxim.be.PagosDocumentosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosPreliquidacionBE;
import proxim.be.PagosRecibosBE;
import proxim.be.ParametrosBE;
import proxim.be.PortabilidadConsultaSaldosBE;
import proxim.be.TransfATercerosPortabilidadBE;
import proxim.be.TransfEntreCuentasPortabilidadBE;
import proxim.be.TransferenciaAutorizarBE;
import proxim.be.TransferenciaBE;
import proxim.be.TransferenciaCuentaPaypalBE;
import proxim.be.TransferenciasExteriorBE;
import proxim.be.TransfOtrosBancosCCEPortabilidadBE;
import proxim.bl.*;
import proxim.dao.*;

public class Proxim{
	CapturarPantalla objEvidencia = new CapturarPantalla();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	
	PagosMasivosAdministracionAfiliadosBE objPagosMasivosBL = new PagosMasivosAdministracionAfiliadosBE();
	PagosMasivosAdministracionPagosBL objPagoMasivoAdministracionPagoBL=new PagosMasivosAdministracionPagosBL();
	
	FinanciamientoDesembolsoLineaBE objFinanDesembolsoLineaBL = new FinanciamientoDesembolsoLineaBE();
	FinanciamientoDesembolsoLineaBL objFinanciamientoDesembolsoLineaBL=new FinanciamientoDesembolsoLineaBL();
	ComercioExtCartaFianzaGeneralBE objComerExtCartaFianzaSolicitudBL=new ComercioExtCartaFianzaGeneralBE();
	ComercioExtCartaFianzaSolicitudBL objComercioExtCartaFianzaSolicitudBL=new ComercioExtCartaFianzaSolicitudBL();
	TransferenciaBE objTransferenciaBL = new TransferenciaBE();
	TransferenciaOtrosBancosBCRBL objTransferenciaOtrosBancosBCRBL=new TransferenciaOtrosBancosBCRBL();
	TransferenciaOtrosBancosCCEBL objTransferenciaOtrosBancosCCEBL=new TransferenciaOtrosBancosCCEBL();
	TransferenciaEntreCuentasBL objTransferenciaEntreCuentasBL=new TransferenciaEntreCuentasBL();
	TransferenciaTercerosBL objTransferenciaTerceros=new TransferenciaTercerosBL();
	ConsultaSaldosMovimientosBE objSaldoMovimientoBL = new ConsultaSaldosMovimientosBE();
	ConsultaSaldosMovimientosBL objConsultaSaldoMovimientoBL=new ConsultaSaldosMovimientosBL();
	PagosRecibosBE objRecibosBL = new PagosRecibosBE();
	PagosRecibosBL objPagoRecibosBL=new PagosRecibosBL();
	
	FinanciamientoDocumentosEleEnvioPlanillasBE objFinanciamientoDocEleEnvioPlanillasBL = new FinanciamientoDocumentosEleEnvioPlanillasBE();
	FinanciamientoDocumentosEleEnvioPlanillasBL objFinanciamientoEnvioPlanillasDocElectronicosBL=new FinanciamientoDocumentosEleEnvioPlanillasBL();
	
	ConsultaLeasingBE objConsultaLeasingGeneralBL= new ConsultaLeasingBE();
	ConsultaLeasingBL objConsultaLeasingBL= new ConsultaLeasingBL();
	
	ConsultaDietariosBE objConsultaDietariosGeneralBL= new ConsultaDietariosBE();
	ConsultaDietariosBL objConsultaDietariosBL= new ConsultaDietariosBL();
	
	TransferenciaAutorizarBE objTransferenciaAutorizacionBL = new TransferenciaAutorizarBE();
	TransferenciaAutorizarBL objFirmaTransferenciaBL =new TransferenciaAutorizarBL();
	
	AutorizacionesPendientesBE objAutorizacionesBL = new AutorizacionesPendientesBE();
	AutorizacionesPendientesBL objAutAutorizacionesPendientesBL =new AutorizacionesPendientesBL();
	
	FinanciamientoDescuentosCobEnvioPlanillasGeneralBE objFinanDescuentosCobEnvioPlanillasBL=new FinanciamientoDescuentosCobEnvioPlanillasGeneralBE();
	FinanciamientoDescuentosCobEnvioPlanillasBL objFinanciamientoDescuentosCobEnvioPlanillasBL=new FinanciamientoDescuentosCobEnvioPlanillasBL();
	
	PagosMasivosAdministracionAfiliadosBL objPagoMasivoAdministracionAfiliadosBL= new PagosMasivosAdministracionAfiliadosBL();
	MonitoreoTransaccionesBL objMonitoreoTransaccionesBL = new MonitoreoTransaccionesBL(); 
	
	ConsultaDocumentosRelacionPagaresBE objConsultaPagaresGeneralBL = new ConsultaDocumentosRelacionPagaresBE(); 
	ConsultaDocumentosRelacionPagaresBL objConsultaPagaresBL = new ConsultaDocumentosRelacionPagaresBL();
	
	ConsultaPedidosBE objConsuPedidosBL = new ConsultaPedidosBE();
	ConsultaPedidosBL objConsultasyPedidosBL = new ConsultaPedidosBL();
	
	TransferenciaExteriorBL objTransferenciasExteriorBL= new TransferenciaExteriorBL();
	TransferenciasExteriorBE objTransferenciasExteriorBE=new TransferenciasExteriorBE();
	
	FinanciamientoDocumentosEleReportesBL objFinanciamientoDocumentosEleReportesBL=new FinanciamientoDocumentosEleReportesBL();
	FinanciamientoDocumentosEleReportesBE objFinanDocumentosEleReportesBL=new FinanciamientoDocumentosEleReportesBE();
	
	TransferenciaCuentaPaypalBL objTransferenciaCuentaPaypalBL=new TransferenciaCuentaPaypalBL();
	TransferenciaCuentaPaypalBE objTranCuentaPaypalBL=new TransferenciaCuentaPaypalBE();
	
	FinanciamientoDocumentosElePreAfiProBL objFinanciamientoDocumentosElePreAfiProBL=new FinanciamientoDocumentosElePreAfiProBL();
	FinanciamientoDocumentosEleConProAfiBE objFinanDocumentosEleConProAfiBL=new FinanciamientoDocumentosEleConProAfiBE();
	
	PagosDocumentosBE objPagDocumentosBL=new PagosDocumentosBE();
	PagosDocumentosBL objPagosDocumentosBL=new PagosDocumentosBL();
	
	PagosPreliquidacionBE objPreliquidacionBL=new PagosPreliquidacionBE();
	PagosPreliquidacionBL objPagosPreliquidacionBL=new PagosPreliquidacionBL();
	
	FinanciamientoDescuentosCobCarteraDocumentosBE objFinanDescuentosCobCarteraDocumentosBL=new FinanciamientoDescuentosCobCarteraDocumentosBE();
	FinanciamientoDescuentosCobCarteraDocumentosBL objFinanciamientoDescuentosCobCarteraDocumentosBL=new FinanciamientoDescuentosCobCarteraDocumentosBL();
	
	ComercioExtCartaFianzaRenovacionBL objComercioExtCartaFianzaRenovacionBL=new ComercioExtCartaFianzaRenovacionBL();
	ComercioExtCartaFianzaRenovacionBE objComercioExtCartaFianzaRenovacionBE=new ComercioExtCartaFianzaRenovacionBE();
	
	PortabilidadConsultaSaldosBE objConsultaSaldosPortabilidadBE=new PortabilidadConsultaSaldosBE();
	PortabilidadConsultaSaldosBL objConsultaSaldosPortabilidadBL=new PortabilidadConsultaSaldosBL();
	
	ConsultaRecaudacionBE objConsulRecaudacionBE=new ConsultaRecaudacionBE();
	ConsultaRecaudacionBL onbConsultaRecaudacionBL=new ConsultaRecaudacionBL();
	
	FinanciamientoDocumentosEleConsultasAdeVenBL objFinanConsultasAdelantosVencimientosBL=new FinanciamientoDocumentosEleConsultasAdeVenBL();
	FinanciamientoDocumentosEleConsultasAdeVenBE objFinanConsultasAdelantosVencimientosBE=new FinanciamientoDocumentosEleConsultasAdeVenBE();
	
	FinanciamientoDescuentosCobConsultaDocumentosBL objFinanciamientoDescuentosCobConsultaDocumentosBL=new FinanciamientoDescuentosCobConsultaDocumentosBL();
	FinanciamientoDescuentosCobConsultaDocumentosBE objFinanciamientoDescuentosCobConsultaDocumentosBE=new FinanciamientoDescuentosCobConsultaDocumentosBE();
	
	FinanciamientoDescuentosCobNotifiVencimientoBL objFinanciamientoDescuentosCobNotifiVencimientoBL=new FinanciamientoDescuentosCobNotifiVencimientoBL();
	FinanciamientoDescuentosCobNotifiVencimientoBE objFinanciamientoDescuentosCobNotifiVencimientoBE=new FinanciamientoDescuentosCobNotifiVencimientoBE();
	
	ConsultaDocumentoElectronicoBL objConsultaDocumentoElectronicoBL=new ConsultaDocumentoElectronicoBL();
	ConsultaDocumentoElectronicoBE objConsultaDocumentoElectronicoBE=new ConsultaDocumentoElectronicoBE();
	
	ContratosDigitalesBL objContratosDigitalesBL = new ContratosDigitalesBL();
	ContratosDigitalesBE objContratosDigitalesBE = new ContratosDigitalesBE();
	
	//LLAMAR BL//
	LoginBL2 objLogin = new LoginBL2();
	HeaderBL objHeader = new HeaderBL();
	PortabilidadAutorizacionBL objAutorizacionPorPortabilidadBL = new PortabilidadAutorizacionBL();
	TransfEntreCuentasPortabilidadBE objTransfEntreCuentasPortabilidadBE= new TransfEntreCuentasPortabilidadBE();
	PortabilidadTransfEntreCuentasBL objTransfEntreCuentasPortabilidadBL=new PortabilidadTransfEntreCuentasBL();
	
	TransfATercerosPortabilidadBE objTransfATercerosPortabilidadBE= new TransfATercerosPortabilidadBE();
	PortabilidadTransfATercerosBL objTransfATercerosPortabilidadBL=new PortabilidadTransfATercerosBL();
	
	TransfOtrosBancosCCEPortabilidadBE objTransfOtrosBancosCCEPortabilidadBE = new TransfOtrosBancosCCEPortabilidadBE();
	PortabilidadTransfOtrosBancosCCEBL objTransfOtrosBancosCCEPortabilidadBL = new PortabilidadTransfOtrosBancosCCEBL();
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	boolean blnEjecutar = false;
	boolean lbnResultadoEsperado = false;
	String strModulo ;
	String strCasosExec;
	String strNombreVersion;
	String strCiclo;
	String strNombreMaquina;
	String strExecutado;
	long lngTiempoEjecucionCaso;
	
	ParametrosBE objParametrosBE=new ParametrosBE();
	
	@BeforeTest
	public void configuracion() throws  Exception {
//		String strBaseDatos="BPI_EMPRESA"; 
//		String strServidor="S432VA3\\BDT" ;	
		String strBaseDatos="proxim_BD"; //Nombre de la base de datos
		String strServidor="XT7981T13AW7\\FHILARIO" ;//Nombre del servidor
		String strGestorBasedeDatos="SQL";
		String strUsuario="sa" ;//Usuario con el que se ingresa al servidor
		String strPassword ="sql2005";//Password del usuario
		
		
		InetAddress inAddFoSistema = InetAddress.getLocalHost();
		Mdl_Variables.Gstr_Maquina =inAddFoSistema.getHostName();
		Mdl_Variables.Gdt_EntradaSistema =new Date();
		Mdl_Variables.Gdt_TiempoTotalSistema =new Date();
		Mdl_Variables.Gstr_RutaEvidencia="\\\\D:\\PROXIM\\Evidencias";//Ruta en donde se generara las evidencias
		
		
	    //Captura registros de la tabla schedulle
		ConexionSqlServer.schedule(strBaseDatos,strGestorBasedeDatos, strUsuario,strPassword ,strServidor );
	    
		//Cierra pantallas para iniciar con un sistema limpio 
    	objConexionBL.ActualizarScheduleAntes(Mdl_Variables.Gstr_Tabla);
    }
	
	    
    private void obtenerParametros() throws SQLException {
    	objSQL.listaTablaIdCaso("SELECT * FROM TBL_PARAMETRO order by id"," ",5);
    	int i=1;
    	Mdl_Variables.Gstr_Parametros= new String[Mdl_Variables.Grst_NuevaTabla.getFetchSize()];
    	while (Mdl_Variables.Grst_NuevaTabla.next()) {
			objParametrosBE.obtenerCamposBD( Mdl_Variables.Grst_NuevaTabla);
			Mdl_Variables.Gstr_Parametros[i]=ParametrosBE.GstrDESCRIPCION;
			i++;
		}
	}


	@Test
    public void testCases() throws Exception{
    	if (Mdl_Variables.Gbln_Pendiente) {	    	 
    		long tiempoInicio=System.currentTimeMillis();
    		if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_CasosEjecutar)){
    			//objSQL.listaTablaIdCaso(Mdl_Variables.Gstr_Tabla,"",1 );//devuelve el listado de una tabla ordenado por el ID CASO: Mdl_Variables.Grst_ListaCasos
    			objEvidencia.ingresoDatosLog();//crea un reistro en la tabla Maestro
    			FuncionesGenerales.casosEjecutar(Mdl_Variables.Gstr_CasosEjecutar,1);//guarda EL ID de los casos a ejecutar en un array
    			for(int i=0;i<=Mdl_Variables.Garr_CasosEjecutar.length-1;i++){
    				objSQL.listaTablaIdCaso(Mdl_Variables.Gstr_Tabla," where ID_CASO="+Mdl_Variables.Garr_CasosEjecutar[i]+" ",1 );
    				
			    	while (Mdl_Variables.Grst_ListaCasosEjecutar.next()) {	

		    			Mdl_Variables.Gint_IdCaso=Mdl_Variables.Grst_ListaCasosEjecutar.getInt("ID_CASO");
		    			Mdl_Variables.Gstr_PasosEvidencia="";  
		    		
		    			FuncionesGenerales.crearRutaEvidencia();
		    			obtenerParametros();
		    			Mdl_Variables.Glng_HoraInicio =System.currentTimeMillis();							 
		    			switch (Mdl_Variables.Gstr_Tabla){
		    				case "APP_AND_LOGIN_D": //LOGIN
		    					lbnResultadoEsperado = objLogin.ingresoLogin("1", Mdl_Variables.Grst_ListaCasosEjecutar);
		    		    		break;
			    			
		    				case  "APP_PAGOS_RECIBOS_D"://PAGOS-De Recibos
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objRecibosBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					if (lbnResultadoEsperado){ 
		    						objConexionBL.DatosLogin(PagosRecibosBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objPagoRecibosBL.pagoRecibos();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    	
		    				case  "APP_PAGOS_PRELIQUIDACION_D":
		    					lbnResultadoEsperado = objPreliquidacionBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(PagosPreliquidacionBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objPagosPreliquidacionBL.pagoPreliquidacion();
			    						}
		    				    	}
		    					}
		    		    		break;	
		    		    		
		    				case  "APP_AND_PAGO_MAS_ADMAFILIADOS_D"://PAGOS-MASIVOS:Administración de Afiliados
		    					lbnResultadoEsperado = objPagosMasivosBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);//Capturar datos de los casos a ejecutarse de la tabla:APP_AND_PAGO_MAS_ADMAFILIADOS_D
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(PagosMasivosAdministracionAfiliadosBE.strIdCasoLogin);//Mdl_Variables.Grst_TablaLogin/Select a la tabla APP_AND_LOGIN_D con ID que se envia
		    						
			    					while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objPagoMasivoAdministracionAfiliadosBL.administracionAfiliados();
			    						}
		    				    	}
		    					}
		    		    		break; 
		    		    		
			    			case  "APP_AND_PAGO_MAS_ADMPAGOS_D"://PAGOS-MASIVOS:Administración de Pagos-Envío de Pagos 
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objPagosMasivosBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 2);
		    					if (lbnResultadoEsperado){ 
		    						if(PagosMasivosAdministracionAfiliadosBE.strSoloFirma.equals("NO")){
				    					//Busqueda de los casos del login 
				    					objConexionBL.DatosLogin(PagosMasivosAdministracionAfiliadosBE.strIdCasoLogin);//Mdl_Variables.Grst_TablaLogin
			    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
			    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
					    		    		
				    						if (lbnResultadoEsperado){ 
				    							lbnResultadoEsperado = objPagoMasivoAdministracionPagoBL.administracionPagosMasivos();
				    						}
			    				    	}
		    						}else {
		    							lbnResultadoEsperado=objPagoMasivoAdministracionPagoBL.firmasAdministracionPagosMasivos();
		    						}
		    					}
		    		    		break;

			    				case  "APP_CONSULTA_LEASING_D":
			    					//capturar datos de los casos a ejecutarD
			    					lbnResultadoEsperado = objConsultaLeasingGeneralBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 2);
			    					
			    					if (lbnResultadoEsperado){ 
			    					//Busqueda de los casos del login 
			    					objConexionBL.DatosLogin(ConsultaLeasingBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
			    						while (Mdl_Variables.Grst_TablaLogin.next()){	
			    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
					    		    		
				    						if (lbnResultadoEsperado){ 
				    							lbnResultadoEsperado = objConsultaLeasingBL.ConsultaLeasing();
				    						}
			    				    	}
			    					}
			    		    		break;
			    		    		
			    				case  "APP_CONSULTA_DIETARIOS_D":
			    					//capturar datos de los casos a ejecutar
			    					lbnResultadoEsperado = objConsultaDietariosGeneralBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 2);
			    					
			    					if (lbnResultadoEsperado){ 
			    					//Busqueda de los casos del login 
			    					objConexionBL.DatosLogin(ConsultaDietariosBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
			    						while (Mdl_Variables.Grst_TablaLogin.next()){	
			    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
					    		    		
				    						if (lbnResultadoEsperado){ 
				    							lbnResultadoEsperado = objConsultaDietariosBL.ConsultaDietarios();
				    						}
			    				    	}
			    					}
			    		    		break;
		    		    	
		    				case  "APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D"://TRANSFERENCIAS-Envío transferencia: Entre Cuentas
		    					lbnResultadoEsperado = objTransferenciaBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objTransferenciaEntreCuentasBL.transferenciaEntreCuentas();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_AND_TRANSFERENCIAS_A_TERCEROS_D"://TRANSFERENCIAS-Envío transferencia: a Terceros
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objTransferenciaBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 2);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    					objConexionBL.DatosLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objTransferenciaTerceros.transferenciaTerceros();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D"://TRANSFERENCIAS-Envío transferencia: a otros bancos CCE
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objTransferenciaBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 3);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objTransferenciaOtrosBancosCCEBL.transferenciaOtrosBancosCCE();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_AND_TRANSFERENCIAS_OTROS_BANCOS_BCR_D"://TRANSFERENCIAS-Envío transferencia: a otros bancos BCR
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objTransferenciaBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 4);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
				    							lbnResultadoEsperado = objTransferenciaOtrosBancosBCRBL.transferenciaOtrosBancosBCR();
			    						}
		    				    	}
		    					}
		    		    		break;	
		    		    	
		    				case  "APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D"://TRANSFERENCIAS-Transerencias por Autorizar
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado =objTransferenciaAutorizacionBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(TransferenciaAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFirmaTransferenciaBL.transferenciaAutorizarGeneral(1,true);
			    						}
		    				    	}
		    					}
		    		    		break;	
		    		    		
		    				case  "APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D"://CONSULTAS-Saldos y Movimientos
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objSaldoMovimientoBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
		    						//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(ConsultaSaldosMovimientosBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objConsultaSaldoMovimientoBL.consultasSaldosMovimientos();
			    						}
		    				    	}
		    					}
		    		    		break;	
		    		    		
		    				case  "APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS"://FINANCIAMIENTO-Documentos Electrónicos:Documentos Electrónicos
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objFinanciamientoDocEleEnvioPlanillasBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(FinanciamientoDocumentosEleEnvioPlanillasBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    						lbnResultadoEsperado = objFinanciamientoEnvioPlanillasDocElectronicosBL.financiamientoDocElecEnvioPlanillas();
			    						}
		    				    	}
		    					
		    		    		}
		    		    		break;
		    		    		
		    				case  "APP_AND_AUTORIZACIONES_PENDIENTES_D"://AUTORIZACIONES-Autorizaciones Pendientes
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado =objAutorizacionesBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(AutorizacionesPendientesBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()){	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objAutAutorizacionesPendientesBL.autorizacionesPendientes(1,true);
			    						}
		    				    	}
		    					}
		    		    		break;
		    				case  "APP_AND_ARCHIVOTEXTO_D":
		    					lbnResultadoEsperado = objMonitoreoTransaccionesBL.Referencias(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(MonitoreoTransaccionesGeneralBE.strID_CASO);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objMonitoreoTransaccionesBL.monitoreoTransacciones();
			    						}
		    				    	}
		    					
		    		    		}
		    					break;
		    				case  "APP_AND_CONSULTA_PAGARES_D"://CONSULTA Relacion de Pagares
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objConsultaPagaresGeneralBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar, 1);
		    					
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login 
		    						objConexionBL.DatosLogin(ConsultaDocumentosRelacionPagaresBE.strID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objConsultaPagaresBL.ConsultaPagares(1);
			    						}
		    				    	}
		    					
		    		    		}
		    		    		break;
		    		    		
		    				case  "APP_FINANCIAMIENTO_DESLINEA_D"://PAGOS-MASIVOS:Administración de Pagos-Envío de Pagos 
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objFinanDesembolsoLineaBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) { 
		    					//Busqueda de los casos del login ---
		    					objConexionBL.DatosLogin(FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){  
			    							lbnResultadoEsperado = objFinanciamientoDesembolsoLineaBL.desembolsoLinea();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_COMERCIO_EXT_CARTA_FIANZA_D"://PAGOS-MASIVOS:Administración de Pagos-Envío de Pagos 
		    					//capturar datos de los casos a ejecutar
		    					lbnResultadoEsperado = objComerExtCartaFianzaSolicitudBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado){ 
		    					//Busqueda de los casos del login ---
		    					objConexionBL.DatosLogin(ComercioExtCartaFianzaGeneralBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){  
			    							lbnResultadoEsperado = objComercioExtCartaFianzaSolicitudBL.comercioExteriorCartaFianzaSolicitud();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case "APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D":
		    					lbnResultadoEsperado = objFinanDescuentosCobEnvioPlanillasBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) 	{ 
		    					//Busqueda de los casos del login ---
		    					objConexionBL.DatosLogin(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){  
			    							lbnResultadoEsperado = objFinanciamientoDescuentosCobEnvioPlanillasBL.financiamientoDescuentosCobEnvioPlanillas();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_CONSULTAS_Y_PEDIDOS_D":
		    					lbnResultadoEsperado = objConsuPedidosBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(ConsultaPedidosBL.strIdCasoLOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objConsultasyPedidosBL.consultasyPedidos();
			    						}
		    				    	}
		    					}
		    		    		break;	
		    				case  "APP_PAGOS_DOCUMENTOS_D":
		    					lbnResultadoEsperado = objPagDocumentosBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(PagosDocumentosBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objPagosDocumentosBL.pagoDocumentos();
			    						}
		    				    	}
		    					}
		    		    		break;	
		    		    		
		    				case  "APP_FINANCIAMIENTO_DOCELC_CONPREAFI_CONAFILIADOS":
		    					lbnResultadoEsperado = objFinanDocumentosEleConProAfiBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(FinanciamientoDocumentosEleConProAfiBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFinanciamientoDocumentosElePreAfiProBL.FinanciamientoDocumentosElePreAfiPro();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_TRANSFERENCIAS_EXTERIOR":
		    					lbnResultadoEsperado = objTransferenciasExteriorBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
		    						objConexionBL.DatosLogin(TransferenciasExteriorBE.GstrID_CASO_LOGIN);
		    						
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							if(objFuncionesGenerales.verificarIgnore(TransferenciasExteriorBE.GstrIND_SOLO_HISTORICA))
			    								lbnResultadoEsperado = objTransferenciasExteriorBL.consultarHistorico();
			    							else if(objFuncionesGenerales.verificarIgnore(TransferenciasExteriorBE.GstrIND_SOLO_OF))
			    								lbnResultadoEsperado = objTransferenciasExteriorBL.consultarOF();
			    							else
			    								lbnResultadoEsperado = objTransferenciasExteriorBL.realizarEnvio();
			    						}
		    				    	}		    						
		    							
		    					}
		    		    		break;

		    				case  "APP_FINANCIAMIENTO_DOCELC_CONADEVENCIMIENTO":
		    					lbnResultadoEsperado = objFinanConsultasAdelantosVencimientosBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(FinanciamientoDocumentosEleConsultasAdeVenBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFinanConsultasAdelantosVencimientosBL.consultarAdelVenc();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_COMERCIO_EXT_CARTA_FIANZA_RENOVACION_D":
		    					lbnResultadoEsperado = objComercioExtCartaFianzaRenovacionBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(ComercioExtCartaFianzaRenovacionBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objComercioExtCartaFianzaRenovacionBL.realizarEnvio();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    	
		    				case  "APP_FINANCIAMIENTO_DOCELC_REPORTES":
		    					lbnResultadoEsperado = objFinanDocumentosEleReportesBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(FinanciamientoDocumentosEleReportesBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFinanciamientoDocumentosEleReportesBL.financiamientoDocumentosEleReportes();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case "APP_CONSULTA_RECAUDACION_D":
		    					lbnResultadoEsperado = objConsulRecaudacionBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar,1);
		    					if (lbnResultadoEsperado) { 
		    						objConexionBL.DatosLogin(ConsultaRecaudacionBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = onbConsultaRecaudacionBL.consultaRecaudacion(1);
			    						}
		    				    	}
		    						objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
		    					}
		    		    		break;
		    		    				    		    	
		    				case  "APP_TRANSFERENCIAS_CUENTA_PAYPAL_D":
		    					lbnResultadoEsperado = objTranCuentaPaypalBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    						    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(TransferenciaCuentaPaypalBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objTransferenciaCuentaPaypalBL.TransferenciaConsultaHistorica();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_FINANCIAMIENTO_DESCOB_CARDOCUMENTOS_D":
		    					lbnResultadoEsperado = objFinanDescuentosCobCarteraDocumentosBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(FinanciamientoDescuentosCobCarteraDocumentosBE.Gstr_ID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFinanciamientoDescuentosCobCarteraDocumentosBL.financiamientoDescuentosCobCarteraDocumentos();
			    						}
		    				    	}
		    					}
		    		    		break;	
		    		    		
		    				case  "APP_FINANCIAMIENTO_CONSULTA_DOCUMENTO":
		    					lbnResultadoEsperado = objFinanciamientoDescuentosCobConsultaDocumentosBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(FinanciamientoDescuentosCobConsultaDocumentosBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFinanciamientoDescuentosCobConsultaDocumentosBL.realizarConsulta();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_FINANCIAMIENTO_NOTIFIVENCIMIENTO":
		    					lbnResultadoEsperado = objFinanciamientoDescuentosCobNotifiVencimientoBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(FinanciamientoDescuentosCobNotifiVencimientoBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objFinanciamientoDescuentosCobNotifiVencimientoBL.realizarConsulta();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		    		
		    				case  "APP_CONSULTA_DOC_ELECTRONICO":
		    					lbnResultadoEsperado = objConsultaDocumentoElectronicoBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					
		    					if (lbnResultadoEsperado){ 
			    					objConexionBL.DatosLogin(ConsultaDocumentoElectronicoBE.GstrID_CASO_LOGIN);
		    						while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    							lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
				    		    		
			    						if (lbnResultadoEsperado){ 
			    							lbnResultadoEsperado = objConsultaDocumentoElectronicoBL.realizarConsulta();
			    						}
		    				    	}
		    					}
		    		    		break;
		    		   		
		    				case "CONSULTA_SALDOS_PORTABILIDAD":
		    					lbnResultadoEsperado = objConsultaSaldosPortabilidadBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) { 
		    						lbnResultadoEsperado = objConsultaSaldosPortabilidadBL.consultarSaldo();
		    		    		}
		    		    		break;
		    		    		
		    				case "APP_AUTORIZACIONES_PORTABILIDAD_D": //LOGIN
		    					lbnResultadoEsperado = objAutorizacionPorPortabilidadBL.Portabilidad(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) { 
		    						lbnResultadoEsperado = objAutorizacionPorPortabilidadBL.autorizacionesPendientes(1, true,null);
		    		    		}
		    		    		break;
		    		    	
		    				case "TBL_TRANSFERENCIA_ENTRE_CUENTA_PORTABILIDAD":
		    					lbnResultadoEsperado = objTransfEntreCuentasPortabilidadBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) { 
		    						lbnResultadoEsperado = objTransfEntreCuentasPortabilidadBL.realizarEnvio();
		    		    		}
		    		    		break;
		    		    		
		    				case  "APP_SOLICITUDES_CONTRATOS_DIGITALES":  //MODULO SOLICITUDES - CONTRATOS DIGITALES
		    				   	lbnResultadoEsperado = objContratosDigitalesBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    				   	
		    				   	if (lbnResultadoEsperado){ 
		    				   		objConexionBL.DatosLogin(ContratosDigitalesBE.GstrID_CASO_LOGIN);
		    				   		while (Mdl_Variables.Grst_TablaLogin.next()) {	
		    				   			lbnResultadoEsperado = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
		    				   	   	   	if (lbnResultadoEsperado){ 
				    				   		lbnResultadoEsperado = objContratosDigitalesBL.realizarEnvio();
				    				   	}
		    				   	   	}
		    				   	}
		    				   	   	break;
		    				case "TBL_TRANSFERENCIA_A_TERCEROS_PORTABILIDAD":
		    					lbnResultadoEsperado = objTransfATercerosPortabilidadBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) { 
		    						lbnResultadoEsperado = objTransfATercerosPortabilidadBL.realizaEnvio();
		    		    		}
		    		    		break;
		    		    		
		    				case "TBL_TRANSFERENCIA_A_OTROS_BANCOS_CEE_PORTABILIDAD":
		    					lbnResultadoEsperado = objTransfOtrosBancosCCEPortabilidadBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosEjecutar);
		    					if (lbnResultadoEsperado) { 
		    						lbnResultadoEsperado = objTransfOtrosBancosCCEPortabilidadBL.realizaEnvio();
		    		    		}
		    		    		break;
		    			}
		    			String horaFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
		    			Mdl_Variables.Glng_HoraFin = System.currentTimeMillis();	 
		    			lngTiempoEjecucionCaso = (Mdl_Variables.Glng_HoraFin- Mdl_Variables.Glng_HoraInicio)/ (1000);
		    			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "UTILIZADO", "-1",  Integer.toString(Mdl_Variables.Gint_IdCaso));
	    			    objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "TIEMPO_EJECUCION_CASO", Long.toString(lngTiempoEjecucionCaso),  Integer.toString(Mdl_Variables.Gint_IdCaso));
	    			    objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "HORA", horaFin, Integer.toString(Mdl_Variables.Gint_IdCaso));
    					if(lbnResultadoEsperado){
    						objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "-1", Integer.toString(Mdl_Variables.Gint_IdCaso));
    				    }
			    	}
    			}
		    	Mdl_Variables.Grst_ListaCasosEjecutar.close();
    		}else{
    			System.out.println("No se ingreso casos a ejecutar.");
    		}
    		objConexionBL.ActualizarScheduleDespues(Mdl_Variables.Gstr_Tabla,tiempoInicio);
    	}else{
    		System.out.println("No existen registros para realizar pruebas.");
    	}  
    
    	CapturarPantalla.GenerarHTML2();	
    }
}
