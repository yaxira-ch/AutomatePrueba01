package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import proxim.be.ComercioExtCartaFianzaRenovacionBE;
import proxim.be.ConsultaSaldosMovimientosBE;
import proxim.be.PagosDocumentosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosRecibosBE;
import proxim.be.TransferenciaBE;
import proxim.dao.Mdl_Variables;

public class ConsultaHistoricaBL {
	
	PagosMasivosProcesadosBL objPagosMasivosProcesadosBL=new PagosMasivosProcesadosBL();
	PagosMasivosBloqueadosBL objPagosMasivosBloqueadosBL=new PagosMasivosBloqueadosBL();
	FinanciamientoDesembolsoLineaProcesadasBL objFinanciamientoDesembolsoLineaProcesadasBL=new FinanciamientoDesembolsoLineaProcesadasBL();
	FinanciamientoDescuentosCobEnvioPlanillasProcesadasBL objFinanciamientoDescuentosCobEnvioPlanillasProcesadasBL=new FinanciamientoDescuentosCobEnvioPlanillasProcesadasBL();
	FinanciamientoDocumentosEleEnvioPlanillasProcesadasBL objFinanciamientoDocumentosEleEnvioPlanillasProcesadasBL=new FinanciamientoDocumentosEleEnvioPlanillasProcesadasBL();
	FinanciamientoDescuentosCobEnvioPlanillasBloqueadasBL objFinanciamientoDescuentosCobEnvioPlanillasBloqueadasBL=new FinanciamientoDescuentosCobEnvioPlanillasBloqueadasBL();
	FinanciamientoDocumentosEleEnvioPlanillasBloqueadasBL objFinanciamientoDocumentosEleEnvioPlanillasBloqueadasBL=new FinanciamientoDocumentosEleEnvioPlanillasBloqueadasBL();
	FinanciamientoDesembolsoLineaBloqueadasBL objFinanciamientoDesembolsoLineaBloqueadasBL=new FinanciamientoDesembolsoLineaBloqueadasBL();
	PagosRecibosBloqueadosBL objPagosRecibosBloqueadosBL=new PagosRecibosBloqueadosBL();
	TransferenciaConsultaHistoricaBL objTransferenciaConsultaHistoricaBL= new TransferenciaConsultaHistoricaBL();
	PagosRecibosProcesadosBL objPagosRecibosProcesadosBL=new PagosRecibosProcesadosBL();
	ComercioExtCartaFianzaSolicitudProcesadasBL objComercioExtCartaFianzaSolicitudProcesadaBL=new ComercioExtCartaFianzaSolicitudProcesadasBL();
	ComercioExtCartaFianzaSolicitudBloqueadasBL objComercioExtCartaFianzaSolicitudBloqueadasBL=new ComercioExtCartaFianzaSolicitudBloqueadasBL();
	ComercioExtCartaFianzaRenovacionProcesadasBL objComercioExtCartaFianzaRenovacionProcesadasBL=new ComercioExtCartaFianzaRenovacionProcesadasBL();
	ComercioExtCartaFianzaRenovacionBloqueadasBL objComercioExtCartaFianzaRenovacionBloqueadasBL=new ComercioExtCartaFianzaRenovacionBloqueadasBL();
	PagosDocumentosProcesadasBL objPagosDocumentosProcesadasBL=new PagosDocumentosProcesadasBL();
	PagosDocumentosBloqueadosBL objPagosDocumentosBloqueadosBL=new PagosDocumentosBloqueadosBL();
	PagosMasivosConsultaRealizadosBL  objPagosRealizadosBL = new PagosMasivosConsultaRealizadosBL();
	ConsultaRecaudacionBL objConsultaRecaudacionBL=new ConsultaRecaudacionBL();
	FuncionesGenerales objFuncionesGenerales=new FuncionesGenerales();
	GlosasConsultaSaldosMovimientosBL objGlosasConsultaSaldosMovimientosBL=new GlosasConsultaSaldosMovimientosBL();
	TransferenciaExteriorHistoricoBL objTransferenciaExteriorHistoricoBL=new TransferenciaExteriorHistoricoBL();
	ConsultaSaldosMovimientosBL objConsultaSaldoMovimientoBL=new ConsultaSaldosMovimientosBL();
	
	public boolean consultaHistorico(String strTipoProducto, String strEmpresa,String strCuentaCargo, int num,String strEstadoOperacion,String strConsultaSaldoMovimiento,String strIdCaso) throws InterruptedException, IOException{		
		boolean lbnResultadoEsperado=true;
		int horaInicio=8;
		int horaFin=20;
		Map<String,String> map;
		HeaderBL objHeader = new HeaderBL();
		String strAbono="Abono";
		String strCargo="Cargo";
		
		try {
			
			if(strEstadoOperacion.equals("Procesada")){
				switch (strTipoProducto) {
    				case "Pagos Masivos": 
    					
    					lbnResultadoEsperado = objPagosMasivosProcesadosBL.administracionPagosProcesados(num);
    					if(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO.equals("En Línea")&&lbnResultadoEsperado){
	    					
    						if(!PagosMasivosAdministracionAfiliadosBE.GstrCONSULTA_PAGOS_REALIZADOS.equals(Mdl_Variables.Gstr_Ignore)){
								lbnResultadoEsperado = objPagosRealizadosBL.administracionPagosRealizados();
							}
							
							if (lbnResultadoEsperado){
								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
		    						
								if (strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
									//consulta saldos y movimientos por el mismo ambiente
									if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){
										objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
									}
									//consulta saldos movimeintos por el otro ambiente
								}else{
									objHeader.cerrarSesion( PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION, PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION);
									objFuncionesGenerales.insertSaldosMovimientos(map,"");
			    					lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_PAGO_MAS_ADMPAGOS_D","");
									if(lbnResultadoEsperado){
										lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_AND_PAGO_MAS_ADMPAGOS_D","");
									}
								}
							}
    					}
    		    		break;
    		    		
    				case "Desembolso en Línea": 
    					lbnResultadoEsperado=objFinanciamientoDesembolsoLineaProcesadasBL.FinanciamientoDesembolsoLineaProcesadas(num);
    		    		break;
    		    		
    				case "Pago de Recibos": 
//    					map=objFuncionesGenerales.obtenerCampos_ConsultarSaldos();
//    					objFuncionesGenerales.insertSaldosMovimientos(strTipoProducto,map);
    					
    					lbnResultadoEsperado=objPagosRecibosProcesadosBL.pagosRecibosProcesados(num);
						objHeader.cerrarSesion( PagosRecibosBL.GstrLNK_CERRAR_SESION, PagosRecibosBL.GstrLNK_CERRAR_SESION);
    					
    					if(lbnResultadoEsperado&& !PagosRecibosBE.GstrCONSULTA_RECUDACION.equals(Mdl_Variables.Gstr_Ignore)){
    						lbnResultadoEsperado=objConsultaRecaudacionBL.consultaRecaudacion(2);
    					}
					
    					if (lbnResultadoEsperado&& !strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
    						map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
	    					objFuncionesGenerales.insertSaldosMovimientos(map,"");
    						lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_PAGOS_RECIBOS_D","");
							/*if(lbnResultadoEsperado){
								lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_PAGOS_RECIBOS_D");
							}*/
						}
						
    		    		break;
    		    		
    				case "Transferencias": 
    					
    					lbnResultadoEsperado= objTransferenciaConsultaHistoricaBL.transferenciaConsultaHistorica(num);
    					
    					if (objFuncionesGenerales.verificarIgnore(strConsultaSaldoMovimiento)){	
    						ConsultaSaldosMovimientosBE.GstrTXT_MENU="CONSULTAS";
        					ConsultaSaldosMovimientosBE.GstrTXT_SUBMENU="Saldos y Movimientos";
        					ConsultaSaldosMovimientosBE.GstrTXT_SUBMENU1="Saldos y Movimientos";
        					ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA=TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN;
        					Mdl_Variables.map=objFuncionesGenerales.obtenerDatosEmpresaVariante(TransferenciaBE.GstrCMB_CUENTA_ORIGEN);
        					ConsultaSaldosMovimientosBE.GstrCMB_TIPO_PRODUCTO=Mdl_Variables.map.get("strTipoProducto");
        					ConsultaSaldosMovimientosBE.GstrCMB_MONEDA=Mdl_Variables.map.get("strTipoMoneda");
        					ConsultaSaldosMovimientosBE.GstrTXT_NUMERO_CUENTA=Mdl_Variables.map.get("strNumeroCuenta");
        					
        					ConsultaSaldosMovimientosBE.GstrTXT_ALIAS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_ENVIAR_TEXTO=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_NUMERO_CUENTA=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrBTN_SALDO_DISPONIBLE=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrBTN_DEPOSITOS_CHEQUES=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrVALIDAR_SALDOS_CICS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_EXPORTAR_EXCEL_SALDOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_EXPORTAR_PDF_SALDOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_IMPRIMIR_SALDOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_REGRESAR_SALDOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_SALDO_DISPONIBLE=Mdl_Variables.Gstr_Click;
        					ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA_MOVIMIENTO=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrCMB_TIPO_CUENTA=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrCMB_CUENTA_MOVIMIENTO=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrRBT_FECHA_OPERACION=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrRBT_FECHA_PROCESO=Mdl_Variables.Gstr_Ignore;
        					String strNewFecha=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
        					ConsultaSaldosMovimientosBE.GstrTXT_FECHA_DESDE=strNewFecha;
        					ConsultaSaldosMovimientosBE.GstrTXT_FECHA_HASTA=strNewFecha;
        					ConsultaSaldosMovimientosBE.GstrBTN_BUSCAR=Mdl_Variables.Gstr_Click;
        					ConsultaSaldosMovimientosBE.GstrLNK_ENVIAR_TEXTO_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_EXPORTAR_EXCEL_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_EXPORTAR_PDF_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_IMPRIMIR_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrCODIGO_UBICACION=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrVALIDAR_MOVIMIENTOS_CICS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_REGRESAR_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
        					ConsultaSaldosMovimientosBE.GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Click;
        					
    						switch (TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA) {
        						case "A Terceros": 
        							if (lbnResultadoEsperado){
        								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
        		    						
        								if (strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){//consulta saldos y movimientos por el mismo ambiente
        									objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
        								}else{//consulta saldos movimeintos por el otro ambiente
        									objHeader.cerrarSesion( TransferenciaBE.GstrLNK_CERRAR_SESION, TransferenciaBE.GstrLNK_CERRAR_SESION);
        									objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
        									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
               								if(lbnResultadoEsperado){
               									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
               								}
        								}
        							}
        							
//        							objConsultaSaldoMovimientoBL.consultasSaldosMovimientos();//cerrar cesion
       								//map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
       								//objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//       								lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//       								if(lbnResultadoEsperado){
//       									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//       								}
        							
        						break;
        						
        						case "Entre Cuentas": 
        							if (lbnResultadoEsperado){
        								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
        		    						
        								if (strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){//consulta saldos y movimientos por el mismo ambiente
        									if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){
        										objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
        									}
        								}else{//consulta saldos movimeintos por el otro ambiente
        									objHeader.cerrarSesion( TransferenciaBE.GstrLNK_CERRAR_SESION, TransferenciaBE.GstrLNK_CERRAR_SESION);
        									objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
        									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
               								if(lbnResultadoEsperado){
               									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
               								}
        								}
        							}
//        							ConsultaSaldosMovimientosBE.GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
//        							objConsultaSaldoMovimientoBL.consultasSaldosMovimientos();//cerrar cesion
//        							
//        							ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA=TransferenciaBE.GstrCMB_EMPRESA_CUENTA_DESTINO;
//                					Mdl_Variables.map=objFuncionesGenerales.obtenerDatosEmpresaVariante(TransferenciaBE.GstrCMB_CUENTA_DESTINO);
//                					ConsultaSaldosMovimientosBE.GstrCMB_TIPO_PRODUCTO=Mdl_Variables.map.get("strTipoProducto");
//                					ConsultaSaldosMovimientosBE.GstrCMB_MONEDA=Mdl_Variables.map.get("strTipoMoneda");
//                					ConsultaSaldosMovimientosBE.GstrTXT_NUMERO_CUENTA=Mdl_Variables.map.get("strNumeroCuenta");
//        							ConsultaSaldosMovimientosBE.GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Click;
//        							objConsultaSaldoMovimientoBL.consultasSaldosMovimientos();//cerrar cesion
//        							
//       								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
//        	    						objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//        	    						lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//        								if(lbnResultadoEsperado){
//        									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//        								}
        								break;
        						
        						case "A otros Bancos CCE": 
        							if (lbnResultadoEsperado){
        								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
        		    						
        								if (strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){//consulta saldos y movimientos por el mismo ambiente
        									if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){
        										objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
        									}
        								}else{//consulta saldos movimeintos por el otro ambiente
        									objHeader.cerrarSesion( TransferenciaBE.GstrLNK_CERRAR_SESION, TransferenciaBE.GstrLNK_CERRAR_SESION);
        									objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
        									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
        								}
        							}
        							
//        							objConsultaSaldoMovimientoBL.consultasSaldosMovimientos();//cerrar cesion
//       								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
//    	    						objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
//    	    						lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
    	    						break;
    	    						
        						default: 
        							if (lbnResultadoEsperado){
        								map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
        		    						
        								if (strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){//consulta saldos y movimientos por el mismo ambiente
        										objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
        								}else{//consulta saldos movimeintos por el otro ambiente
        									objHeader.cerrarSesion( TransferenciaBE.GstrLNK_CERRAR_SESION, TransferenciaBE.GstrLNK_CERRAR_SESION);
        									objFuncionesGenerales.insertSaldosMovimientos(map,TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
        									lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS",TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA);
        								}
        							}
        	    					break;
    						}
    						
    					}else{
    						objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
    					}
    					
    					
    					
    					
    					
//    					if(lbnResultadoEsperado&&!TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals("A otros Bancos BCR")&& !strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
//    						map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
//    						objFuncionesGenerales.insertSaldosMovimientos(strTipoProducto,map);
//    						lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_AND_TRANSFERENCIAS");
//							if(lbnResultadoEsperado){
//								lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_AND_TRANSFERENCIAS");
//							}
//						}
    					
    		    		break;
    		    		
    				case "Descuentos y Cobranza de Documentos"://"Descuentos y Cobranza de Documentos": 
    					lbnResultadoEsperado=objFinanciamientoDescuentosCobEnvioPlanillasProcesadasBL.financiamientoDescuentosCobEnvioPlanillasProcesadas(num);
//    					if (objFuncionesGenerales.verificarIgnore(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLNK_CERRAR_SESION)){	
//    						objHeader.cerrarSesion(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLNK_CERRAR_SESION,FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLNK_CERRAR_SESION);
//    					}
    //					
    					//Lbln_Bandera = objPagosMasivosProcesadosBL.administracionPagosProcesados(num);
    					
    					/*
    					if(Lbln_Bandera &&!FinanDescuentosCobEnvioPlanillasBL.GstrEJECUCION_AC_ERR.equals("0"))
    					{
    						//Lbln_Bandera = objFinanciamientoDescuentosCobEnvioPlanillasBloqueadasBL.
    					}*/
    					
    					/*
    					if(Lbln_Bandera &&!PagosMasivosBL.GstrCONSULTA_PAGOS_REALIZADOS.equals(Mdl_Variables.Gstr_Ignore)&& PagosMasivosBL.GstrCMB_TIPO_PROCESO.equals("En Línea"))
						{
							Lbln_Bandera = objPagosRealizadosBL.administracionPagosRealizados();
						}
						*/
/*
						if (lbnResultadoEsperado&& !strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
							//Lbln_Bandera=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D");
							if(lbnResultadoEsperado){
								lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D");
								String str1="ok";
							}
						}*/
						
   // 					
    					
    					
    					break;
    		    		
    				case "Documentos Electrónicos":
    					lbnResultadoEsperado=objFinanciamientoDocumentosEleEnvioPlanillasProcesadasBL.financiamientoDocumentosEleEnvioPlanillasProcesadas(num);
    					
//    					if (objFuncionesGenerales.verificarIgnore(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLNK_CERRAR_SESION))
//    					{	
//    						objHeader.cerrarSesion(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLNK_CERRAR_SESION,FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLNK_CERRAR_SESION);
//    					}
    					
    					/*if (lbnResultadoEsperado&& !strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
							lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS");
							if(lbnResultadoEsperado){
								lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS");
							}
						}*/
    					break;
    					
    				case "Pago de Documentos":
    					
    					Calendar calendario = new GregorianCalendar();
    					int  hora = calendario.get(Calendar.HOUR_OF_DAY);
    					int minutos = calendario.get(Calendar.MINUTE);
    									         
    					if(((hora>=horaInicio && hora<=horaFin)&&(minutos>=00 && minutos<=59)) ){
    						lbnResultadoEsperado=objPagosDocumentosProcesadasBL.pagosDocumentosProcesadas(num);
    						
    						if (objFuncionesGenerales.verificarIgnore(PagosDocumentosBE.GstrLNK_CERRAR_SESION))
        					{	
        						objHeader.cerrarSesion(PagosDocumentosBE.GstrLNK_CERRAR_SESION,PagosDocumentosBE.GstrLNK_CERRAR_SESION);
        					}    						
        					
        					if (lbnResultadoEsperado&& !strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
        						map=FuncionesGenerales.obtenerCampos_ConsultarSaldos();
            					objFuncionesGenerales.insertSaldosMovimientos(map,"");
        						lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_PAGOS_DOCUMENTOS_D","");
    							//if(Lbln_Bandera){
    								//Lbln_Bandera=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_PAGOS_DOCUMENTOS_D");
    							//}
    						}
        				}
    					break;
    				
    				case "Carta Fianza":
    					lbnResultadoEsperado=objComercioExtCartaFianzaSolicitudProcesadaBL.comercioExtCartaFianzaSolicitudProcesadas(num);
    					break;
    					
    				case "Renovacion Carta Fianza":
    					lbnResultadoEsperado=objComercioExtCartaFianzaRenovacionProcesadasBL.comercioExtCartaFianzaSolicitudProcesadas(num);
    					
    					if (objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaRenovacionBE.GstrLNK_CERRAR_SESION))
    					{	
    						objHeader.cerrarSesion(ComercioExtCartaFianzaRenovacionBE.GstrLNK_CERRAR_SESION,ComercioExtCartaFianzaRenovacionBE.GstrLNK_CERRAR_SESION);
    					}
    					
    					/*if (lbnResultadoEsperado&& !strConsultaSaldoMovimiento.equals(Mdl_Variables.Gstr_Ignore)){
							lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strCargo,"APP_COMERCIO_EXT_CARTA_FIANZA_RENOVACION_D");
							if(lbnResultadoEsperado){
								lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,strAbono,"APP_COMERCIO_EXT_CARTA_FIANZA_RENOVACION_D");
							}
						}*/
    					break;
    				
    				default: // default clause should be the last one
    					break;	
    			}
			}else{
				if(strEstadoOperacion.equals("Bloqueada")){
					switch (strTipoProducto) {
	    				case "Pagos Masivos": 
	    					lbnResultadoEsperado =objPagosMasivosBloqueadosBL.administracionPagosBloqueados(1,num);
	    					break; 
	    		    	
	    				case "Desembolso en Línea":  
	    					lbnResultadoEsperado =objFinanciamientoDesembolsoLineaBloqueadasBL.FinanciamientoDesembolsoLineaBloqueadas(num);
	    		    		break; 
	    		    	
	    				case "Pago de Recibos":  
	    					lbnResultadoEsperado =objPagosRecibosBloqueadosBL.PagosRecibosBloqueados(num);
	    					break; 
	    					
	    				case "Transferencias":  
	    					lbnResultadoEsperado= objTransferenciaConsultaHistoricaBL.transferenciaConsultaHistorica(num);
	    		    		break; 
	    		    	
	    				case "Descuentos y Cobranza de Documentos":
	    					lbnResultadoEsperado =objFinanciamientoDescuentosCobEnvioPlanillasBloqueadasBL.financiamientoDescuentosCobEnvioPlanillasBloqueadas(num);
	    					break;
	    					
	    				case "Documentos Electrónicos":
	    					lbnResultadoEsperado =objFinanciamientoDocumentosEleEnvioPlanillasBloqueadasBL.financiamientoDocumentosEleEnvioPlanillasBloqueadas(num);
	    					break;
	    					
	    				case "Pago de Documentos":
	    					lbnResultadoEsperado=objPagosDocumentosBloqueadosBL.PagosDocumentosBloqueados(num);
	    					break;
	    					
	    				case "Carta Fianza":
	    					lbnResultadoEsperado=objComercioExtCartaFianzaSolicitudBloqueadasBL.comercioExtCartaFianzaSolicitudBloqueadas(num);
	    					break;
	    				case "Renovacion Carta Fianza":
	    					lbnResultadoEsperado=objComercioExtCartaFianzaRenovacionBloqueadasBL.comercioExtCartaFianzaSolicitudBloqueadas(num);
	    					break;
	    				case "Comercio Exterior": 	    					
	    					lbnResultadoEsperado= objTransferenciaExteriorHistoricoBL.consultarHistorico("Operaciones no procesadas",strEstadoOperacion,true);							
	    		    		break;
	    				default: // default clause should be the last one
	    					break;
	    		    	
	    			}
					
					if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){
						objHeader.cerrarSesion(Mdl_Variables.Gstr_Click, Mdl_Variables.Gstr_Click);
					}
					
				}else if(strEstadoOperacion.equals(Mdl_Variables.Gstr_Parametros[12])){
					if (strTipoProducto.equals("Comercio Exterior")) {
		    			lbnResultadoEsperado= objTransferenciaExteriorHistoricoBL.consultarHistorico("Operaciones no procesadas",strEstadoOperacion,true);							
					}
				}
			}
			
		} catch (SQLException e) {
			lbnResultadoEsperado=false;
		}	
		return lbnResultadoEsperado;
	}
}