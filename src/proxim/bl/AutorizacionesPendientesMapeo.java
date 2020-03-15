package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.AutorizacionesPendientesBE;
import proxim.be.ComercioExtCartaFianzaGeneralBE;
import proxim.be.EnvioPagosMasivosBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasGeneralBE;
import proxim.be.FinanciamientoDesembolsoLineaBE;
import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasBE;
import proxim.be.ObjetosGenerales;
import proxim.be.PagosDocumentosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosRecibosBE;
import proxim.be.TransferenciaBE;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class AutorizacionesPendientesMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	EnvioPagosMasivosBE objEnvioPagosMasivosBE = new EnvioPagosMasivosBE();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();

	public boolean verificarTablaPendientes() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/div[5]/div/div/table");
	}
	
	public boolean seleccionarLoteFirmar(String strFechaEjecucionCaso) throws InterruptedException, IOException{
		boolean blnResultado = false;
		String Lstr_Nombre_Solicitud="";
		String Lstr_Cuenta_Cargo="";
		String Lstr_cuotas="";
		String Lstr_producto="";
		String Lstr_montoTotal="";
		String Lstr_CuentaOrigen="";
		String Lstr_Servicio="";
		String Lstr_montoTabla="";
		String strFechaOperacionTabla="";
		String Lstr_NombreAfianzado="";
		String Lstr_NombreBeneficiario="";
		String Lstr_TipoDocumento="";
		String Lstr_NroInternoDoc="";
		String Lstr_Moneda;
		String Lstr_NroReferencia="";
		
		try {
			
			String str_Mensaje=null; 
			int nPagina = 0;
			while (blnResultado == false){
				str_Mensaje=null;
				nPagina ++;
				
				if (nPagina > 1){
					objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/div[2]/a["+nPagina+"]");
				}
				
				WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
				List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
				String tipoOperacion="";
				
				if(AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION.equals("Desembolso en Línea")
						||AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION.equals("Pago de Recibos")
						||AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION.equals("Carta Fianza")){
					tipoOperacion=AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION;
				}else if (AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION.equals("Pago de Documentos")){
					if(PagosDocumentosBE.GstrCMB_TIPO_DOCUMENTO.equals("Letra")){
						tipoOperacion=AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION+" / Letra";
					}else{
						tipoOperacion=AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION+" / Factura";
					}
				}else{
					tipoOperacion=AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION+" / "+AutorizacionesPendientesBE.GstrTIPO_PRODUCTO;
				}
				
				for (int j =num.size()-2 ;j>=1;j--){	
					List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
					strFechaOperacionTabla=colss.get(1).getText();
					if (strFechaOperacionTabla.equals(strFechaEjecucionCaso) && 
							((colss.get(2).getText()).toUpperCase().equals(tipoOperacion.toUpperCase()))
							||((colss.get(3).getText()).toUpperCase().equals(tipoOperacion.toUpperCase()))){

							verificarTablaPendientes();
							if((colss.get(2).getText()).toUpperCase().equals(tipoOperacion.toUpperCase())){
								Lstr_montoTabla=colss.get(3).getText();
								colss.get(5).click();
							}else{
								Lstr_montoTabla=colss.get(4).getText();
								colss.get(6).click(); Thread.sleep(1000);
							}
							//esperar a que entre a esta pantalla
							switch (AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION){
				    			case "Transferencias": //--
			    					objEnvioPagosMasivosBE.verificarDetalleProducto();
			    					//Lstr_Empresa=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[2]/span[2]" );
									Lstr_producto=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[3]/span[2]");
									str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[4]/div[1]/div[4]/span[2]")).getText();
									//Lstr_Fecha_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[5]/span[2]");
									Lstr_Nombre_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[9]/span[2]");
									Lstr_montoTotal=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[10]/span[2]");
									Lstr_CuentaOrigen=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[7]/span[2]");
									Lstr_Cuenta_Cargo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[8]/span[2]");
									if (str_Mensaje.equals(TransferenciaBE.GstrNUMERO_SOLICITUD)){//Numero Solicitado
										AutorizacionesPendientesBL.generarExprotableDetalle();
										CapturarPantalla.scrollCapturaPantalla();
										objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/a");	
										verificarTablaPendientes();
										colss.get(0).click();
										blnResultado = true;
									}
									break;	
								
				    			case "Pago de Recibos": //falta validar campos
			    					objEnvioPagosMasivosBE.verificarDetallePagosRecibos();
									//Lstr_Empresa=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/span[2]" );
									Lstr_Nombre_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/span[2]" );
									//Lstr_Fecha_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/span[2]" );
									Lstr_Cuenta_Cargo=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[3]/span[2]" );
									Lstr_montoTotal=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/span[2]" );
									//Lstr_montoDolares=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[5]/span[2]" );
									
									//if(Lstr_Empresa.equals( PagRecibosBL.GstrCMB_EMPRESA)){
										if(Lstr_Nombre_Solicitud.equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)&&
											//if(Lstr_Fecha_Solicitud.equals(fechaBusqueda)){
												Lstr_Cuenta_Cargo.equals(PagosRecibosBE.GstrCMB_CUENTA_CARGO)){
												CapturarPantalla.scrollCapturaPantalla();
												objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/a");
												verificarTablaPendientes();
												colss.get(0).click();
												blnResultado = true;
											}
											//}
										
									//}
										
									break;
									
				    			case "Pagos Masivos": 
			    					objEnvioPagosMasivosBE.verificarDetalleProducto();
			    					//Lstr_Empresa=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[1]/div/span[2]" );
			    					Lstr_producto=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[2]/span[2]" );
			    					Lstr_Servicio=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[3]/div/span[2]" );
			    					Lstr_Nombre_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[4]/div/span[2]" );
			    					//Lstr_TipoProceso=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[5]/span[2]" );
			    					//Lstr_Fecha_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[6]/span[2]" );
			    					Lstr_Cuenta_Cargo=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[7]/span[2]" );
			    					Lstr_montoTotal=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[8]/div[1]/span[2]" );
			    					//Lstr_montoDolares=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[8]/div[2]/span[2]" );
			    					
			    					if (Lstr_Nombre_Solicitud.equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)){//Numero Solicitado
			    						CapturarPantalla.scrollCapturaPantalla();
			    						objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[6]/a");
			    						verificarTablaPendientes();
										colss.get(0).click();
										blnResultado = true;
									}else{
										objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[6]/a");
			    						verificarTablaPendientes();
									}
			    					
			    					break;
								
				    			case "Documentos Electrónicos": 
				    				Lstr_Servicio=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[11]/div[1]/div[3]/div/div/span[2]" );
				    				
				    				if(Lstr_Servicio.equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO)&&
				    						Lstr_montoTabla.equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL)){
			    							CapturarPantalla.scrollCapturaPantalla();
			    							objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[11]/a");
			    							verificarTablaPendientes();
											colss.get(0).click();
											blnResultado = true;
										}
			    					
				    				
				    				break;
									
				    			case "Descuentos y Cobranza de Documentos": 
			    					objEnvioPagosMasivosBE.verificarDetalleProducto();
			    					//Lstr_Empresa=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div/div/div[2]/div[1]/div/span[2]" );
			    					Lstr_producto=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[11]/div[1]/div[2]/div/div/span[2]" );
			    					
			    					if(Lstr_producto.equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_PRODUCTO)&&
										//if(Lstr_Empresa.equals(FinanDescuentosCobEnvioPlanillasAutorizarBL.GstrCMB_EMPRESA)){//Empresa 
										Lstr_montoTabla.equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL)){//monto total
											CapturarPantalla.scrollCapturaPantalla();
											objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[11]/a");	
											verificarTablaPendientes();
											colss.get(0).click();
											blnResultado = true;
										}
											
										//}
			    					break;
			    					
			    				case "Desembolso en Línea": 
			    					objEnvioPagosMasivosBE.verificarDetalleProducto();
			    					//Lstr_Empresa=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[2]/span[2]" );
									Lstr_Cuenta_Cargo=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[3]/span[2]" );
									Lstr_montoTotal=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[4]/span[2]" );
									Lstr_cuotas=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[5]/span[2]" );
									//Lstr_Frecuencia=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[6]/div/span[2]" );
									//Lstr_TipoCronograma=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[7]/div/span[2]" );
									
									if(strFechaOperacionTabla.equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&
										//if(!FinanDesembolsoLineaBL.GstrCMB_EMPRESA.equals("<IGNORE>")&&   Lstr_Empresa.equals(FinanDesembolsoLineaBL.GstrCMB_EMPRESA)){
											Lstr_cuotas.equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)){
												//if(Lstr_Frecuencia.equals(FinanDesembolsoLineaBL.GstrCMB_FRECUENCIA)){
													//if(Lstr_TipoCronograma.equals(FinanDesembolsoLineaBL.GstrCMB_TIPO_CRONOGRAMA)){
												CapturarPantalla.scrollCapturaPantalla();
												objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[4]/div[1]/a");	
												verificarTablaPendientes();
												colss.get(0).click();
												blnResultado = true;
												//	}
													
												//}
												
											}
									
									break;
								
			    				case "Carta Fianza": 
			    					objEnvioPagosMasivosBE.verificarDetalleProducto();
			    					
			    					Lstr_NombreAfianzado=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[5]/span[2]" );
			    					//Lstr_DireccionAfianzado=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[6]/span[2]" );
			    					Lstr_NombreBeneficiario=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[7]/div/span[2]" );
			    					//Lstr_DireccionBeneficiario=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[8]/div/span[2]" );
			    					Lstr_montoTotal=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[11]/span[2]" );
			    					//Lstr_Fecha_Solicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[10]/span[2]" );
			    					
			    					String nombreAfianzadoBD="";
			    					if(objFuncionesGenerales.verificarIgnore( ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO))
			    						nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO;
			    					else
			    						nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO;
			    					
			    					if(Lstr_NombreAfianzado.equals(nombreAfianzadoBD)&&
										//if(Lstr_DireccionAfianzado.equals(ComerExtCartaFianzaSolicitudBL.)){
			    						Lstr_NombreBeneficiario.equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)&&
											//	if(Lstr_DireccionBeneficiario.equals(ComerExtCartaFianzaSolicitudBL.)){
										Lstr_montoTotal.equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
												//		if(Lstr_Fecha_Solicitud.equals(ComerExtCartaFianzaSolicitudBL.)){
											CapturarPantalla.scrollCapturaPantalla();
											 AutorizacionesPendientesBL.generarExprotableDetalle();
											objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/a");	
											//objEnvioPagosMasivosBE.verificarTablaTransferencia();
											verificarTablaPendientes();
											colss.get(0).click();
											blnResultado = true;
										}
												//	}
											//	}
											//}
			    					break;
			    				
			    				case "Pago de Documentos": 
			    					objEnvioPagosMasivosBE.verificarDetalleProducto();
			    					
			    					Lstr_TipoDocumento=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[1]/div[3]/span[2]" );
			    					Lstr_NroInternoDoc=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[1]/div[4]/span[2]" );
			    					Lstr_Moneda=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[1]/div[5]/span[2]" );
			    					Lstr_montoTotal=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[1]/div[6]/span[2]" );
			    					Lstr_CuentaOrigen=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[1]/div[7]/span[2]" );
			    					
			    					String Nueva_Moneda=null;
			    					String Nuevo_cuenta_cargo=null;
			    					
			    					String Texto_validar= PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(0, 16);
			    					
			    					if(Texto_validar.equals("Cuenta Corriente")){
			    						Nueva_Moneda=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(17, 22);
			    						if(Nueva_Moneda.equals("Soles")){
			    							Nuevo_cuenta_cargo=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(23, 37);
			    						}else{
			    							Nueva_Moneda=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(17, 24);
			    							Nuevo_cuenta_cargo=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(25, 39);
			    						}
			    					}else{
			    						Texto_validar= PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(0, 17);
			    						Nueva_Moneda=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(18, 23);
			    						if(Nueva_Moneda.equals("Soles")){
			    							Nuevo_cuenta_cargo=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(24, 38);
			    						}else{
			    							Nueva_Moneda=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(19, 25);
			    							Nuevo_cuenta_cargo=PagosDocumentosBE.strCMB_CUENTA_CARGO.substring(27, 40);
			    						}
			    					}
			    					String montoPagar;
			    					int totalCadena=Lstr_montoTotal.length();
			    					if(Lstr_montoTotal.contains("/")){
			    						montoPagar=Lstr_montoTotal.substring(3, totalCadena);
			    					}else{
			    						montoPagar=Lstr_montoTotal.substring(4, totalCadena);
			    					}

			    					if(Lstr_TipoDocumento.equals(PagosDocumentosBE.GstrCMB_TIPO_DOCUMENTO)
			    							&&Lstr_NroInternoDoc.equals(PagosDocumentosBE.strNUMERO_DOCUMENTOS)
			    							&& Lstr_Moneda.equals(PagosDocumentosBE.strCMB_MONEDA)
			    							&& montoPagar.equals(PagosDocumentosBE.GstrLBN_MONTO_TOTAL)
			    							&& Lstr_CuentaOrigen.equals(Nuevo_cuenta_cargo)){
														CapturarPantalla.scrollCapturaPantalla();
														objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[2]/a");	
														verificarTablaPendientes();
														colss.get(0).click();
														blnResultado = true;
									}else{
										objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/div[2]/a");	
										objEnvioPagosMasivosBE.verificarTablaTransferencia();
									}
										
			    					break;
			    				case "Comercio Exterior": 
				    				Lstr_NroReferencia=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[1]/div/div[3]/span[2]" );
				    				
				    				if(Lstr_NroReferencia.equals(TransferenciasExteriorBE.GstrLBL_NRO_REFERENCIA)){
				    					TransferenciaExteriorMapeo objTransferenciasExteriorMapeo=new TransferenciaExteriorMapeo();
				    					blnResultado =objTransferenciasExteriorMapeo.verificarDetalleAutorizarComex();	
				    					Thread.sleep(5000);
				    					objObjetosGenerales.clickBoton(ObjetosGenerales.linkText, "Regresar");
		    							//objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[8]/div/div/a");//regresar
		    							verificarTablaPendientes();
										colss.get(0).click();
										blnResultado = true;
			    					}else{
			    						objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[8]/div/div/a");//regresar
			    					}
				    				
				    				break;
								}
							}
						if(blnResultado){
							break;
						}
					}
					
				}
							
		} catch (Exception e) {
			blnResultado=false;
		}
		return blnResultado;	
	}
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "comboEmpresas",LstrProducto);
	}
	
	public boolean seleccionarTipoOperacion(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "comboTiposOperacion",LstrProducto);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonBusqueda");		
	}
	
	 public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreo(String Descripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
		}
			
		public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
		}
			
		public boolean ingresoBotonEnviar() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
		 }
	 
		public boolean ingresoBotonAceptar() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
		 }
		
	 public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[6]/a");		
	 }
	 
	public boolean seleccionarCheckFirmar(String NumeroSolicitud) throws InterruptedException, IOException{		
		boolean blnResultado = false;
		int nPagina = 0;
		
		while (blnResultado == false){
			nPagina ++;
			
			if (nPagina > 1){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div/div[2]/a["+nPagina+"]");
			}
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			int numero=num.size();
			numero = numero -2;
			
			for (int j = numero;j>=1;j--){ 
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				String tipoOperacion=null;
				
				if(AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION.equals("Desembolso en Línea")){
					tipoOperacion=AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION;
				}else{
					tipoOperacion=AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION+" / "+AutorizacionesPendientesBE.GstrTIPO_PRODUCTO;
				}
				
				if (colss.get(2).getText().equals(tipoOperacion)){//ESTADO
					colss.get(5).click();
					String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[4]/div[1]/div[4]/span[2]")).getText(); 
					objObjetosGenerales.clickBoton(ObjetosGenerales.name, "regresarLink");	

					
					if (str_Mensaje.equals(NumeroSolicitud)){//Numero Solicitado
						colss.get(0).click();
						blnResultado = true;
						break;
					}
				}
			}
		}

		return blnResultado;		
	}
	
	public boolean ingresoBotonAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Autorizar\"]");	
	}
	
	public boolean ingresoBotonSiPopUp() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/a/img");	
	}
	
	public boolean ingresoBotonNoPopUp() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[2]/a/img");	
	}
	public boolean ingresoBotonBloquear() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[2]/a[2]/div/img");
	}  																   
	
	public boolean compararResultadoEsperado(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/span[1]");
		return objFuncionesGenerales.compararTextosIguales(Lstr_TxtMensajeError,str_Mensaje);	
	}
	
	public String obtenerResultado() throws InterruptedException, IOException{	
		String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/span[1]")).getText(); 
			    
		return str_Mensaje;
	}
	
	public boolean verificarMensajeInformativo() throws InterruptedException, IOException{	
		boolean blnResultado = false;
		String strMensajeErrorPantalla;
		String strCampoErrorPantalla;
		String strMensajeError="(***) Por favor, tener en cuenta que el horario de atención de estas operaciones es de Lunes a Viernes de 8:00 a.m. a 8:00 p.m, excepto días feriados.";
		String strCampoError="Rechazada (***)";
			
		blnResultado = objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[8]");
		strMensajeErrorPantalla=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[8]" );  
		strCampoErrorPantalla=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[5]/div/div" );  
			
			if(objFuncionesGenerales.compararTextosIguales(strMensajeErrorPantalla,strMensajeError)
					&&objFuncionesGenerales.compararTextosIguales(strCampoErrorPantalla,strCampoError))
				
					blnResultado= true;
			
		return blnResultado;
	}
	
	public boolean verificarNoMensajeInformativo() throws InterruptedException, IOException{	
		boolean blnResultado = false;

		boolean blnResultado1 = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[8]");
		boolean blnResultado2 = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[5]/div/div");
			
		if(blnResultado1==true && blnResultado2==true)
			blnResultado=true;

		return blnResultado;
	}
	
	public boolean verificarTipoOperacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/select");
	}
	
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.textoAlineadoTR", Descripcion);
	}
	
	public boolean verificarImagenPendieEnviada () throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/img");
	}
	
	public boolean verificarResultadoEsperado() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/span[1]");
	}
	
	public boolean verificarConfiracion() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[9]/div/div[1]/div/div[5]/div/div/table");
	}
	
	public boolean ingresoBotonConfirmar1() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonConfirmar");		
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonCancelarOperacion");		
	}
	
	public boolean buscarMensaje() throws InterruptedException, IOException{	
		return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[2]");																				 
	}
	
	public boolean buscarMensaje1() throws InterruptedException, IOException{	
		return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[5]");
	}
	
	public boolean guardarCampos() throws InterruptedException, IOException, SQLException
	{
		boolean blnResultado=true;
			if(objFuncionesGenerales.compararTextosIguales(AutorizacionesPendientesBE.GstrCMB_TIPO_OPERACION,"Descuentos y Cobranza de Documentos")){
				FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/span[3]" );
				FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/span[5]" );
				FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[1]/span[7]" );
				   
				if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[3]/div" );
				}else{
					FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div" );
				}
				   
				if(buscarMensaje1()){
					FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[5]" );
					//-estado opracion E---/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[5]/div
					//-estado opracion GE---/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[6]/div/div
				}
				objConexionSqlServer.updateTablaQuery("update APP_AND_AUTORIZACIONES_PENDIENTES_D set LBN_OPERACION='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+AutorizacionesPendientesBE.GstrID_CASO);
			}
		return blnResultado;
	}
	
	public boolean ingresoLinkEnviarEmailFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[3]/div/div[1]/a");		
	 }

	public boolean ingresoLinkExportarExcelFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[3]/div/div[6]/a");		
	 }
	 
	 public boolean ingresoLinkRealizarOtraOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[3]/div/a");		
	 }
	
	 public boolean verificarDetalleCartaFianza() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/span");
	 }
		
	 public boolean ingresoChkAceptarTerminosAutorizar() throws InterruptedException, IOException{
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[9]/div/div[3]/span[1]/input");
	 }

	 public boolean ingresoLinkEnviarEmailDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/a");
	 }

	 public boolean ingresoLinkExportarExcelDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[4]/a");
		
	 }
	 
	 public boolean ingresoLinkExportarPDFDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div/div[6]/a");		
	 }
	
//		private void descargarExportables() throws InterruptedException, IOException{
//			// TODO Auto-generated method stub
//			if(!AutorizacionesPendientesBE.GstrTXT_CORREO.equals("<IGNORE>")&&!AutorizacionesPendientesBE.GstrTXT_MENSAJE_CORREO.equals("<IGNORE>")){
//				Thread.sleep(100);
//				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/a");
//				ingresarCorreo( AutorizacionesPendientesBE.GstrTXT_CORREO);
//				ingresarMensajeCorreo( AutorizacionesPendientesBE.GstrTXT_MENSAJE_CORREO);
//				CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//				ingresoBotonEnviar();		
//				ingresoBotonAceptar();
//				Thread.sleep(100);
//				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[4]/a");
//				CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//				Thread.sleep(100);
//				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[5]/a");
//				CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//			}
//		}
}