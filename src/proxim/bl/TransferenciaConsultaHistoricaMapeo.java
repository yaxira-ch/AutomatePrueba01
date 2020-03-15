package proxim.bl;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciaBE;
import proxim.dao.Mdl_Variables;

public class TransferenciaConsultaHistoricaMapeo {
	boolean bandera=false;
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	String strTipoCambio="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[9]/span[2]";
	
	public boolean seleccionarEmpresaCuentaOrigen(String strProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//*[@id='Empresa']/div/div[2]/select", strProducto);
	}

	public boolean seleccionarEstado(String strProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//*[@id='EstadoPago']/div/div[2]/select", strProducto);
	}
	
	public boolean seleccionarTipoTransferencia(String strProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div/div[2]/div/select", strProducto);
	}

	public boolean seleccionarCuentaOrigen(String strProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/div/div/div[2]/select", strProducto);
	}
	
	public boolean seleccionarFechaOperacionDesde(String strProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[7]/div/div/div[2]/div/div[1]/input", strProducto);
	}

	public boolean seleccionarFechaOperacionHasta(String strProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[7]/div/div/div[2]/div/div[2]/input", strProducto);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException{
		Thread.sleep(15000);
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/a/img");	
	}
	
	public boolean verificarBCR() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]" );
	}
	
	public boolean verificarTipoCambio(String tipo) throws InterruptedException, IOException{	
		if(tipo.equals("procesado"))
			bandera = objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strTipoCambio);
		else
			bandera = objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div[2]/div[9]/div[1]/span[2]");
		return bandera;
	}
	
	public boolean verificarDetalle() throws InterruptedException, IOException{
		String strTexto="";
		
		switch (TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA){
			
			case "A otros Bancos BCR": 
				strTexto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div/span";
				break;
			
			case "A otros Bancos CCE": 
				strTexto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/span";
				break;
			
			default: 
				strTexto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/span";
				break;
		}
		bandera = objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath,strTexto);
		return bandera;
	}
	
	public boolean verificarDetalleBloqueado() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div[2]/h1");
	}
	public boolean verificarTablaDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table");
	}
	
//	public boolean capturarDetalle(String fechaProOperacion,String cuentaOriOperacion,String tipoTraOperacion,String fechaRegOperacion,String descripcionOperacion,String empresaOperacion, String estadoOperacion) throws InterruptedException, IOException{
//		boolean buscarprocesado=false;
//		//boolean bandera = false;
//		String nombre="";
//		String monto="";
//		String estadoRegistro="";
//		String nuevoEstado="";
//		String tipoTransferencia="";
//		String fechaSolicitud="";
//		String fechaEnvio="";
//		String empresaTabla="";
//		String nuevaTransferencia="";
//		
//		while(buscarprocesado==false){
//			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
//			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
//			int numero=num.size()-2;
//
//			for (int j = numero;j>=1;j--){ 
//				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
//				
//				if (estadoOperacion.equals("Procesada")){
//					verificarBCR();
//					
//					//capturar dato de la tabla
//					if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
//						tipoTransferencia=colss.get(2).getText();
//						fechaSolicitud=colss.get(3).getText();
//						fechaEnvio=colss.get(4).getText();
//						monto=colss.get(7).getText();
//						estadoRegistro=colss.get(8).getText();
//						
//					}else{
//						empresaTabla=colss.get(2).getText();
//						tipoTransferencia=colss.get(3).getText();
//						fechaSolicitud=colss.get(4).getText();
//						fechaEnvio=colss.get(5).getText();
//						monto=colss.get(8).getText();
//						estadoRegistro=colss.get(9).getText();
//					}
//	
//					
//					//verificar estado de la data
//					if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals("A otros Bancos BCR")){
//						Calendar calendario = new GregorianCalendar();
//						int hora, minutos;
//				        hora = calendario.get(Calendar.HOUR_OF_DAY);
//				        minutos = calendario.get(Calendar.MINUTE);
//				         
//				        if((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59)){
//				        	nuevoEstado="Por Enviar al BCR";
//				        }else{
//				        	if (TransferenciaBE.GstrTXT_PROGRAMA_OPERACION.equals(Mdl_Variables.Gstr_Ignore)){
//				        		nuevoEstado=estadoOperacion;
//				        	}else{
//				        		nuevoEstado="Por Enviar al BCR";
//				        	}
//				        }
//					}else{
//						nuevoEstado=estadoOperacion;
//					}
//					 
//					switch (tipoTraOperacion) {
//					case "A otros Bancos CCE":
//						nuevaTransferencia="CCE";
//						break;
//						
//					case "A otros Bancos BCR":	
//						nuevaTransferencia="BCR";
//						break;
//					
//					case "Entre cuentas":
//						nuevaTransferencia="Entre Cuentas";
//						break;
//					default://A Terceros
//						nuevaTransferencia="A Terceros";
//						break;
//						
//					}
//					
//					if(tipoTransferencia.equals(nuevaTransferencia)&&fechaSolicitud.equals(fechaRegOperacion)&&TransferenciaBE.GstrTOTAL_PAGAR.equals(monto)){
//
//						if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
//							bandera=true;
//						}else{
//							if(empresaTabla.equals(empresaOperacion)){
//								if(nuevaTransferencia.equals("BCR")){
//									if(fechaEnvio.equals(fechaProOperacion)){
//										bandera=true;
//									}else{
//										bandera=false;
//									}
//								}else{
//									if(fechaProOperacion.equals(Mdl_Variables.Gstr_Ignore)){
//										if(fechaEnvio.equals("-")){
//											bandera=true;
//										}else{
//											bandera=false;
//										}
//									}
//								}
//							}
//						}
//								
//						if(bandera){	
//							if(nuevoEstado.equals(estadoRegistro)){//Procesado
//								colss.get(1).click();//SI ESTA EN LA PANTALLA PRINCIPAL 
//								verificarDetalle();
//								
//								if (nuevaTransferencia.equals("BCR")){
//									//nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div/div/div[1]/table/tbody/tr[4]/td[2]")).getText();////HACER CUANDO ESTE EN ESTA PANTALLA
//									nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div/div/div[1]/table/tbody/tr[6]/td[2]")).getText();
//																		
//								}else{
//									nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/span[2]")).getText();////HACER CUANDO ESTE EN ESTA PANTALLA
//								}
//					
//								if (nombre.equals(descripcionOperacion)){
//									bandera = true;
//									buscarprocesado=true;									
////									if(verificarTipoCambio("procesado")){
////										 String tipoCambio= Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambio)).getText();
////										 if(tipoCambio.contains(","))
////											 objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Validar punto decimal", ".", nombre);
////									 }									
//									break;
//								}else{
//									objObjetosGenerales.clickBoton(ObjetosGenerales.classname, "regresarLink");
//								}
//							}else if(estadoRegistro.equals("Rechazada")){
//								
//								if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
//									 colss.get(8).click();
//									 Thread.sleep(500);
//									 nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/span[2]")).getText();
//								}else{
//									 colss.get(9).click();//fala capturar el nombre
//								}
//					
//								if (nombre.equals(descripcionOperacion)){//Numero Solicitado
//									buscarprocesado=true;
//									bandera=false;
//									if(verificarTipoCambio("procesado")){
//										 String tipoCambio= Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambio)).getText();
//										 if(tipoCambio.contains(","))
//											 objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Validar punto decimal", ".", nombre);
//									 }
//									break;
//								}else{
//									objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/a");//Bloqueado
//								}
//							}else if(estadoRegistro.equals("En Proceso")){
//								objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/a/img");	
//								verificarTablaDetalle();
//								break;
//							}
//						}
//					}
//				}
//			}
//		}	
//		return bandera;	
//	}
	
	
	
	
	public boolean capturarDetalle(String fechaProOperacion,String cuentaOriOperacion,String tipoTraOperacion,String fechaRegOperacion,String descripcionOperacion,String empresaOperacion, String estadoOperacion) throws InterruptedException, IOException{
		boolean buscarprocesado=false;
		String nombre="";
		String monto="";
		String estadoRegistro="";
		String nuevoEstado="";
		String tipoTransferencia="";
		String fechaSolicitud="";
		String fechaEnvio="";
		String empresaTabla="";
		String nuevaTransferencia="";
		
		while(buscarprocesado==false){
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			int numero=num.size()-2;

			for (int j = numero;j>=1;j--){ 
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if (estadoOperacion.equals("Procesada")){
					verificarBCR();
					
					//capturar dato de la tabla
					if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
						tipoTransferencia=colss.get(2).getText();
						fechaSolicitud=colss.get(3).getText();
						fechaEnvio=colss.get(4).getText();
						monto=colss.get(7).getText();
						estadoRegistro=colss.get(8).getText();
						
					}else{
						empresaTabla=colss.get(2).getText();
						tipoTransferencia=colss.get(3).getText();
						fechaSolicitud=colss.get(4).getText();
						fechaEnvio=colss.get(5).getText();
						monto=colss.get(8).getText();
						estadoRegistro=colss.get(9).getText();
					}
	
					
					//verificar estado de la data
					if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals("A otros Bancos BCR")){
						Calendar calendario = new GregorianCalendar();
						int hora, minutos;
				        hora = calendario.get(Calendar.HOUR_OF_DAY);
				        minutos = calendario.get(Calendar.MINUTE);
				         
				        if(((hora>=13 && hora<=23)&&(minutos>=00 && minutos<=59))||(!TransferenciaBE.GstrTXT_PROGRAMA_OPERACION.equals(Mdl_Variables.Gstr_Ignore))){
				        	nuevoEstado="Por Enviar al BCR";
				        }else{
				        	nuevoEstado=estadoOperacion;
				        	
				        }
					}else{
						nuevoEstado=estadoOperacion;
					}
					 
					switch (tipoTraOperacion) {
					case "A otros Bancos CCE":
						nuevaTransferencia="CCE";
						break;
						
					case "A otros Bancos BCR":	
						nuevaTransferencia="BCR";
						break;
					
					case "Entre cuentas":
						nuevaTransferencia="Entre Cuentas";
						break;
					default://A Terceros
						nuevaTransferencia="A Terceros";
						break;
						
					}
					
					if(tipoTransferencia.equals(nuevaTransferencia)&&fechaSolicitud.equals(fechaRegOperacion)&&TransferenciaBE.GstrTOTAL_PAGAR.equals(monto)){

						if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
							bandera=true;
						}else{
							if(empresaTabla.equals(empresaOperacion)){
								if(nuevaTransferencia.equals("BCR")){
									if(fechaEnvio.equals(fechaProOperacion)){
										bandera=true;
									}else{
										bandera=false;
									}
								}else{
									if(fechaProOperacion.equals(Mdl_Variables.Gstr_Ignore)){
										if(fechaEnvio.equals("-")){
											bandera=true;
										}else{
											bandera=false;
										}
									}
								}
							}
						}
								
						if(bandera){	
							if(nuevoEstado.equals(estadoRegistro)){//Procesado
								colss.get(1).click();//SI ESTA EN LA PANTALLA PRINCIPAL 
								verificarDetalle();
								
								if (nuevaTransferencia.equals("BCR")){
									//nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div/div/div[1]/table/tbody/tr[4]/td[2]")).getText();////HACER CUANDO ESTE EN ESTA PANTALLA
									nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div/div/div[1]/table/tbody/tr[6]/td[2]")).getText();
																		
								}else{
									nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/span[2]")).getText();////HACER CUANDO ESTE EN ESTA PANTALLA
								}
					
								if (nombre.equals(descripcionOperacion)){
									bandera = true;
									buscarprocesado=true;									
//									if(verificarTipoCambio("procesado")){
//										 String tipoCambio= Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambio)).getText();
//										 if(tipoCambio.contains(","))
//											 objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Validar punto decimal", ".", nombre);
//									 }									
									break;
								}else{
									objObjetosGenerales.clickBoton(ObjetosGenerales.classname, "regresarLink");
								}
							}else if(estadoRegistro.equals("Rechazada")){
								
								if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
									 colss.get(8).click();
									 Thread.sleep(500);
									 nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/span[2]")).getText();
								}else{
									 colss.get(9).click();//fala capturar el nombre
								}
					
								if (nombre.equals(descripcionOperacion)){//Numero Solicitado
									buscarprocesado=true;
									bandera=false;
									if(verificarTipoCambio("procesado")){
										 String tipoCambio= Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambio)).getText();
										 if(tipoCambio.contains(","))
											 objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Validar punto decimal", ".", nombre);
									 }
									break;
								}else{
									objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/a");//Bloqueado
								}
							}else if(estadoRegistro.equals("En Proceso")){
								objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/a/img");	
								verificarTablaDetalle();
								break;
							}
						}
					}
				}else{//Bloqueada
					verificarBCR();
					if(numero==1){
					    if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
							monto= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[6]/div")).getText();//OBTIENE LA SITUACION DE LOS QUE EST� SELECCIONANDO
						}else{
					    	monto= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[7]/div")).getText();//OBTIENE LA SITUACION DE LOS QUE EST� SELECCIONANDO
						}
					}else{
						if(empresaOperacion.equals(Mdl_Variables.Gstr_Ignore)){
							monto= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[6]/div")).getText();//OBTIENE LA SITUACION DE LOS QUE EST� SELECCIONANDO
						}else{
							monto= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[7]/div")).getText();//OBTIENE LA SITUACION DE LOS QUE EST� SELECCIONANDO
						}
					}
					if (numero==1){
						objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
					}else{
						objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[8]/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[1]/div/div/a");
					}

					verificarDetalleBloqueado();
					nombre= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div[2]/div[5]/span[2]")).getText();
				
					if (nombre.equals(descripcionOperacion)){//Numero Solicitado
						bandera = true;
//						if(verificarTipoCambio("bloqueada")){
//							 String tipoCambio= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div[2]/div[9]/div[1]/span[2]")).getText();
//							 if(tipoCambio.contains(","))
//								 objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Validar punto decimal", ".", nombre);
//						 }
						
					}else{
						objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[7]/div[3]/div[1]/a");//Bloqueado
					}
					
					if(bandera){
						buscarprocesado=true;
						break;
					}
				}
			}
		}	
		return bandera;	
	}
	public boolean ingresoEnviarCorreo(String strSeccion) {		
		boolean bResp = false;
		if(strSeccion.equals("SeccionCabecera")){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[9]/div/div[1]/a");
		}else if ( strSeccion.equals("SeccionDetalle")){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div/div[1]/a");
		}
		return bResp;
	}
	
	public boolean ingresarTituloCorreo(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarMensajeCorreo(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", strDescripcion);
	}
	
	public boolean ingresoBotonEnviarCorreo() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	}
	
	public boolean ingresoBotonEnviarCorreo2() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");		
	} 
	
	public boolean ingresoExportarExcel(String strSeccion) {		
		
		boolean bResp = false;
		switch (strSeccion){
			case "SeccionCabecera":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[9]/div/div[4]/a");
																	  
				break;
			case "SeccionDetalle":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div/div[4]/a");
				break;
			default: // default clause should be the last one
			    break;
		}
		return bResp;
	}
	
	public boolean ingresoExportarPdf(String strSeccion){		
		boolean bResp = false;
		
		if (strSeccion.equals("SeccionCabecera")){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[9]/div/div[5]/a");
		}else if (strSeccion.equals("SeccionDetalle")){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div/div[5]/a");
		}
		return bResp; 		
	}
	
	public boolean ingresoImprimir(String strSeccion) {		
		boolean bResp = false;
		switch (strSeccion){
			case "SeccionCabecera":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[9]/div/div[6]/a");
				break;
				
			case "SeccionDetalle":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div/div[6]/a");
				break;
			default: // default clause should be the last one
			    break;
		}
		return bResp; 		
	}
}
