package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE;
import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleEnvioPlanillasMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean bandera=false;
	
	public boolean seleccionarSubMenu(String strSubMenuEntrante) throws InterruptedException, IOException{
		boolean blnResultado=false;
		String strRuta=null;
		for(int i=1;i<=4;i++){
			strRuta="//html/body/div[2]/div[2]/div/ul/li[7]/div/div/ul/li[1]/div/ul/li["+i+"]/a";
			
			String strSubMenu=objObjetosGenerales.getText(ObjetosGenerales.xpath, strRuta); 
			if(strSubMenuEntrante.equals(strSubMenu) ){
				blnResultado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strRuta);
				break;
			}
		}	
		return blnResultado;	
	}
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorTabs']/li["+i+"]//a")).getText();
			
			if(LstrProducto.equals(valor) ){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
				break;
			}
		}	
		return var;	
	}
	
	public boolean seleccionarTipoEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",LstrProducto);
	}
	
	public boolean seleccionarTipoCarga(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",LstrProducto);
	}
		
	public boolean ingresoBotonSiPopUp() throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/a/img");		
	}
	
	public boolean ingresoBotonNoPopUp() throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[2]/a/img");		
	}
	
	public boolean seleccionarProducto(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/select",LstrProducto);
	}
	
	public boolean ingresoRDBProveedor() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/table/tbody/tr/td[2]/span/input");		
	}
	
	public boolean ingresoRDBCliente() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/table/tbody/tr/td[3]/span/input");		
	}
	
	public boolean seleccionarMoneda(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[4]/select",LstrProducto);
	}
	
	public boolean seleccionarCuentaCargo(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[6]/select",LstrProducto);
	}
	
	public boolean ingresarNombrePlanilla(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[8]/input", Descripcion);
	}
	
	public boolean ingresoRDBConConfirmacion() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[8]/table/tbody/tr/td[1]/span/input");		
	}
	
	public boolean ingresoRDBSinConfirmacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[8]/table/tbody/tr/td[2]/span/input");		
	}
	
	public boolean ingresoBotonSeleccionarArchivo(String Descripcion) throws InterruptedException, IOException{		
		return objObjetosGenerales.setTextNew(ObjetosGenerales.name, "planilla",Descripcion);		
	}
	
	public boolean verificarTablaDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table");
	}
	
	public boolean verificarDesplegarCampos() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/span[3]");
	}
	
	public boolean ingresoBotonCrearPlanilla() throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[2]/a/img");		
	}
	
	public boolean ingresoCheckTodos() throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/thead/tr/th[1]/input");		
	}
	
	public boolean verificarTablaLotes() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table");
	}
	
	public boolean seleccionarLoteEnviar() throws InterruptedException, IOException{
		boolean bandera=false;
		String nombrePlantilla="";
		String nombreEmpresa="<IGNORE>";
		String nombreProducto="";
		String nombreCargoInteres="";
		String CuentaCorriente="";
		String nombreCargoInteresData="";
		String registrosErrados="";
		String Numero_Cuenta_Buscar=null;
		Map<String,String> map;
		
		try {
				WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
				List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
				
				if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO.equals("Descuento Electrónico")){
					nombreCargoInteresData="Proveedor";
				}else{
					if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrRDB_CLIENTE.equals("CLICK")){
						nombreCargoInteresData="Cliente";
					}else{
						if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrRDB_PROVEEDOR.equals("CLICK")){
							nombreCargoInteresData="Proveedor";
						}
					}
				}
				
				map=objFuncionesGenerales.obtenerDatosEmpresaVariante(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_CUENTA_CARGO);
				Numero_Cuenta_Buscar=map.get("strNumeroCuenta").substring(4,map.get("strNumeroCuenta").length());   
				
			for (int j = num.size()-2;j>=1;j--){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					nombreProducto=colss.get(4).getText();
					nombreCargoInteres=colss.get(5).getText();
					nombrePlantilla=colss.get(6).getText();
					//MontoTotal=colss.get(8).getText();
					CuentaCorriente=colss.get(9).getText();
					
				}else{
					nombreEmpresa=colss.get(4).getText();
					nombreProducto=colss.get(5).getText();
					nombreCargoInteres=colss.get(6).getText();
					nombrePlantilla=colss.get(7).getText();
					//MontoTotal=colss.get(9).getText();
					CuentaCorriente=colss.get(10).getText();
				}
				
//				if (FinanDocumentosEleEnvioPlanillasBL.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
				CuentaCorriente=CuentaCorriente.substring(4,CuentaCorriente.length());
					
				if(nombreProducto.equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO)&&
					nombreCargoInteres.equals(nombreCargoInteresData)&&
					nombrePlantilla.equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA)&&
						//if(MontoTotal.equals(){
					CuentaCorriente.equals(Numero_Cuenta_Buscar)){
						bandera=true;
						if(!FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
							if(nombreEmpresa.equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA)){
								bandera=true;
							}else{
								bandera=false;
							}
						}
				}
					
			
				if(bandera){
					if(num.size()-2==1){
						bandera =objObjetosGenerales.waitClickableBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/input");
						
					}else{
						bandera =objObjetosGenerales.waitClickableBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[1]/div/div/input");
					}
					
					if(bandera){
						tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
						colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
						
						if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
							registrosErrados=colss.get(11).getText();
						}else{
							registrosErrados=colss.get(12).getText();
						}
						
						if(registrosErrados.equals("0")){
							Thread.sleep(300);
							if(num.size()-2==1){
								bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/input");
							}else{
								bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[1]/div/div/input");
							}
							if(bandera){
								break;
							}
						}else{
							bandera =false;
							if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
								if(num.size()-2==1){
									bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[12]/div/div/a");
								}else{
									bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[12]/div/div/a");
								}
							}else{
								if(num.size()-2==1){
									bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[13]/div/div/a");
								}else{
									bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[13]/div/div/a");
								}
							}
							Thread.sleep(500);
							CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
							objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
							break;
						}
					}
				}
			}
			
			} catch (Exception e) {
				bandera=false;
			}
			return bandera;
	}
	
	public boolean ingresoBotonEnviar() throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div[2]/div/a/img");		
	}
	
	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException
	   {	
		   String  strValorBoton = "";
		   String  strClave = Lstr_Clave;
		   String  strLetraValor = "";

		   for (int i = 1;i<=strClave.length();i++){
			   strLetraValor = strClave.split("")[i - 1];
	        
			   for (int j = 1; j <= 10; j++) {
				   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).getText();
	        
				   if (strValorBoton.equals(strLetraValor)) {
					   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
					   Thread.sleep(100);
					   break;
				   }
			   }
	       }
		   return true;
	   }
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/input", Descripcion);
	}
	
	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/a[1]");	
	}
	
	public boolean verificarConfirmarEnvio() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[3]");
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/a[2]");		
	}
	
	public boolean compararMensajeResultante(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]")).getText();
		
		if(str_Mensaje.compareTo(Lstr_TxtMensajeError) == 0){
			return true;
		}else{
			return false;
		}	
	}
	
	 public boolean compararResultadoEsperadoPositivo() throws InterruptedException, IOException{	
	   String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]" );  
	   
	   if(str_Mensaje.equals("Tu operación ha sido realizada con éxito")) {
			return true;
	   }else{
		   return false;
	   }	
   }
	 
	 public boolean buscarMensajeResultadoFinal() throws InterruptedException, IOException{
		 return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/div[2]/span");
	 }
	 
	 public boolean GuardarDatosOperacionAutorizar() throws InterruptedException, IOException, SQLException{	
			
		 FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/span[2]" );
		 FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/span[4]" );
		 FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/span[6]" );
		 //FinanDocumentosEleEnvioPlanillasBL.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[2]/div/table/tbody/tr[6]/td[2]" );
		 
		 String montoOperacion;
			
		 if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
			 montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[7]/div" );
		 }else{
			 montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[8]/div" );
		 }
		
		 int totalCadena=montoOperacion.length();
			
		 Mdl_Variables.Garr_montosBuscar=new String[1];
		 String nuevoValorMoneda;
		 if(montoOperacion.contains("/")){
				Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
				 nuevoValorMoneda="S/-";
			}else{
				Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
				 nuevoValorMoneda="US$-";
			}
		 

		 Mdl_Variables.Garr_montosBuscar[0] =nuevoValorMoneda +Mdl_Variables.GstrTotalPagar;
			 
			FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL=montoOperacion;
			
			if(buscarMensajeResultadoFinal()){
				FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/div[2]/span" );
			 }else{
				 FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_NUMERO_PLANILLA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[2]/div" ); 
			}
			
			bandera= objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS set LBN_OPERACION='"+FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+FinanciamientoDocumentosEleEnvioPlanillasBE.Gstr_ID_CASO);
			return bandera;
		}
	 
	public boolean verificarResultadoFinal() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]");
	}
	// -------------------------------------------------------detalle
	public boolean seleccionarProveedorAfiliado(String LstrProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div/table/tbody/tr[1]/td/input",LstrProducto);
	}
	
	public boolean seleccionarTipoDocumento(String LstrProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[2]/select",LstrProducto);
	}
	
	public boolean ingresarNumeroDocumentos(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[4]/input", Descripcion);
	}
	
	public boolean ingresoBotonAgregar() throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/a/img");		
	}
	
	public boolean verificarCabecera() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[1]/span[3]");
	}
	
	public boolean ingresoBotonEliminar(int indice) throws InterruptedException, IOException{	
		int valIndice=indice+1;
		if(indice==0){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr/td[1]/div/div/a/img");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr["+valIndice+"]/td[1]/div/div/a/img");
		}
	}
	
	public boolean ingresoBotonEliminarSI() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/a/img");
	}
	
	public boolean ingresoBotonEliminarNO() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[2]/a/img");
	}
	
	public boolean ingresarNumeroDocumento(String Descripcion,int indice) throws InterruptedException, IOException{	
		if(indice==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr/td[6]/div/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[6]/div/div/input", Descripcion);
		}
	}
	
	public boolean seleccionarMonto(String Descripcion,int indice) throws InterruptedException, IOException{	
		if(indice==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr/td[7]/div/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[7]/div/div/input", Descripcion);
		}
	}
	
	public boolean ingresarFechaVencimiento(String Descripcion,int indice) throws InterruptedException, IOException{	
		if(indice==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr/td[8]/div/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[8]/div/div/input", Descripcion);
		}
	}
	
	public boolean ingresarFechaCargo(String Descripcion,int indice) throws InterruptedException, IOException{	
		if(indice==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr/td[9]/div/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[9]/div/div/input", Descripcion);
		}
	}
	
	public boolean ingresarFechaAdelanto(String Descripcion,int indice) throws InterruptedException, IOException{	
		if(indice==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr/td[10]/div/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[10]/div/div/input", Descripcion);
		}
	}
	
	//---------------------------------------------------AUTORIZAR-----------------------------------------------

	
	public boolean verificarEnvioCamposObligatorios() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/span");
	}
	
	public boolean verificarEnvioCamposObligatoriosAutorizar() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean seleccionarEmpresaAutorizacion(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/select",LstrProducto);
	}
	
	public boolean seleccionarProductoAutorizacion(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/select",LstrProducto);
	}
	
	public boolean ingresarFechaInicioAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[1]/input", Descripcion);
	}
	
	public boolean ingresarFechaFinAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[2]/input", Descripcion);
	}
	
	public boolean ingresoBotonBuscarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/button");
	}
	
	public boolean ingresoLinkVerLotesExpiradosAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/a");
	}
	
	public boolean ingresoChkTodosAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[1]/div/div/div[5]/div/div/table/thead/tr/th[1]/input");
	}
	
	public boolean verificarTablaAutorizacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[1]/div/div/div[5]/div/div/table");
	}
	
	public boolean verificarDetalleLoteEnviar() throws InterruptedException, IOException{
		return objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[1]/span[1]");
	}
	
	public boolean ingresoLinkRegresar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/a");
	}
	
	public boolean ingresoBotonAutorizarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/a[1]/div/img");
	}
	
	public boolean ingresoBotonBloquearAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/a[2]/div/img");
	}
	
	public boolean ingresoLinkVerOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[3]/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
	}
	
	 public boolean ingresoLinkEnviarEmailAutorizacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[1]/a");		
	 }
	 
	 public boolean verificarTablaCorreo() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]");
	 }
	 
	 public boolean ingresarCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
	
	public void aceptarEnvio() throws InterruptedException, IOException{
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}
		
	 public boolean ingresoLinkExportarExcelAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[6]/a");		
	 }
	 
	 public boolean seleccionarLoteFirmar(String cuentaCargo) throws InterruptedException, IOException
		{	
		 boolean var=false;
		 String Tipo_Producto_Buscar;
		 String Moneda_Buscar=null;
		 String Numero_Cuenta_Buscar=null;
		 String CargoIneres=null;
			
		 try {
			 if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
				 Tipo_Producto_Buscar= cuentaCargo.substring(0, 16);
				if(Tipo_Producto_Buscar.equals("Cuenta Corriente")){
					Moneda_Buscar=cuentaCargo.substring(17, 22);
					if(Moneda_Buscar.equals("Soles")){
						Numero_Cuenta_Buscar=cuentaCargo.substring(27, 37);
					}else{
						Moneda_Buscar=cuentaCargo.substring(17, 24);
						Numero_Cuenta_Buscar=cuentaCargo.substring(29, 39);
					}
				}else{
					Tipo_Producto_Buscar= cuentaCargo.substring(0, 17);
					Moneda_Buscar=cuentaCargo.substring(18, 23);
					if(Moneda_Buscar.equals("Soles")){
						Numero_Cuenta_Buscar=cuentaCargo.substring(28, 38);
					}else{
						Moneda_Buscar=cuentaCargo.substring(18, 25);
						Numero_Cuenta_Buscar=cuentaCargo.substring(30, 40);
					}
				} 
				CargoIneres="Proveedor";
			}else{
				if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrRDB_PROVEEDOR.equals("CLICK")){
					CargoIneres="Proveedor";
				}else{
					if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrRDB_CLIENTE.equals("CLICK")){
						CargoIneres="Cliente";
					}
				}
			}
				
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if (colss.get(2).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO)|| colss.get(3).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO)){//Producto
					if (colss.get(4).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA)|| colss.get(5).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA)){//Compara NOMBRE PLANILLA
						if (colss.get(6).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL)|| colss.get(7).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL)){//Compara MONTO TOTAL
								
							if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
								String numCuenta,numCuentaNueva;
								if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
									numCuenta=colss.get(7).getText();
								}else{
									numCuenta=colss.get(8).getText();
								}
								numCuentaNueva=numCuenta.substring(4,numCuenta.length());
									
								if (numCuentaNueva.equals(Numero_Cuenta_Buscar)){//Compara TOTAL REGISTROS
									if (colss.get(3).getText().equals(CargoIneres)|| colss.get(4).getText().equals(CargoIneres)){//Cargo de intereses y comisiones
										var = true;
									}
								}
							}else{
								var = true;
							}
								
							if(var){
								colss.get(0).click();
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			 var=false;
		}
		 return var;
		}
	 
	 public boolean verDetalleLoteFirmar(String cuentaCargo) throws InterruptedException, IOException
		{	
		 boolean var=false;
		 String Tipo_Producto_Buscar;
		 String Moneda_Buscar=null;
		 String Numero_Cuenta_Buscar=null;
		 String CargoIneres=null;
			
		 try {
			 if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
				 Tipo_Producto_Buscar= cuentaCargo.substring(0, 16);
				if(Tipo_Producto_Buscar.equals("Cuenta Corriente")){
					Moneda_Buscar=cuentaCargo.substring(17, 22);
					if(Moneda_Buscar.equals("Soles")){
						Numero_Cuenta_Buscar=cuentaCargo.substring(27, 37);
					}else{
						Moneda_Buscar=cuentaCargo.substring(17, 24);
						Numero_Cuenta_Buscar=cuentaCargo.substring(29, 39);
					}
				}else{
					Tipo_Producto_Buscar= cuentaCargo.substring(0, 17);
					Moneda_Buscar=cuentaCargo.substring(18, 23);
					if(Moneda_Buscar.equals("Soles")){
						Numero_Cuenta_Buscar=cuentaCargo.substring(28, 38);
					}else{
						Moneda_Buscar=cuentaCargo.substring(18, 25);
						Numero_Cuenta_Buscar=cuentaCargo.substring(30, 40);
					}
				} 
				CargoIneres="Proveedor";

			}else{
				if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrRDB_PROVEEDOR.equals("CLICK")){
					CargoIneres="Proveedor";
				}else{
					if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrRDB_CLIENTE.equals("CLICK")){
						CargoIneres="Cliente";
					}
				}
			}
				
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if (colss.get(2).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO)|| colss.get(3).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_PRODUCTO)){//Producto
					if (colss.get(4).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA)|| colss.get(5).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA)){//Compara NOMBRE PLANILLA
						if (colss.get(6).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL)|| colss.get(7).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL)){//Compara MONTO TOTAL
								
							if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
								String numCuenta,numCuentaNueva;
								if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
									numCuenta=colss.get(7).getText();
								}else{
									numCuenta=colss.get(8).getText();
								}
								numCuentaNueva=numCuenta.substring(4,numCuenta.length());
									
								if (numCuentaNueva.equals(Numero_Cuenta_Buscar)){//Compara TOTAL REGISTROS
									if (colss.get(3).getText().equals(CargoIneres)|| colss.get(4).getText().equals(CargoIneres)){//Cargo de intereses y comisiones
										var = true;
									}
								}
							}else{
								var = true;
							}
								
							if(var){
								colss.get(1).click();
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			 var=false;
		}
		 return var;
		}
	 
	public boolean verificarConfirmarOperacionAutorizacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[3]");
	}
	
	public boolean ingresarClaveDinamicaAutorizacion(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/input",strClaveDinamica);
	}
	 
	 public boolean ingresoLinkQuieresSaberComoAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/a");		
	 }
	 
	 public boolean ingresoBotonConfirmarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/a[1]");
	}
	
	public boolean ingresoBotonCancelarOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/a[2]");
	}
	
	public boolean verificarmensajeFinal() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span");
	}
	
	public boolean buscarMensaje() throws InterruptedException, IOException{
		return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div[2]/span");
	}
	
	public boolean compararResultadoEsperadoPositivoAutorizar(String ResultadoEsperado) throws InterruptedException, IOException, SQLException{	
		String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span" );  
		   
		if(str_Mensaje.equals(ResultadoEsperado)){
			FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/span[2]" );
			FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/span[4]" );
			FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/span[6]" );
			   
			if(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
				FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[7]/div" );
			}else{
				FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[8]/div" );//cuando es autorizacion GE
			}
			   
			if(buscarMensaje()){
				FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div[2]/span" );
			}else{
				if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrESTADO.equals("Procesada")){
					FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_NUMERO_PLANILLA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[3]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[2]" ); 
					bandera= objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS set  LBN_NUMERO_PLANILLA='"+FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_NUMERO_PLANILLA+"' where ID_CASO="+FinanciamientoDocumentosEleEnvioPlanillasBE.Gstr_ID_CASO);
				}
			}
			objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DOCELE_ENVPLANILLAS_AUTORIZAR_D set LBN_OPERACION='"+FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.Gstr_ID_CASO);
				
			return true;
		}else{
			return false;
		}	
	}
	
	public boolean ingresoLinkEnviarEmailFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreoFinalAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoFinalAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
		
	 public boolean ingresoLinkExportarExcelFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[6]/a");		
	 }
	 
	 public boolean ingresoLinkRealizarOtraOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[4]/a");		
	 }
	 
	  //--------------------------------------PROCESADOS
		 
	 public boolean verificarCamposObligatoriosProcesados() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	 }
		 
	 public boolean seleccionarEmpresaProcesadas(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",LstrEmpresa);
	 }
		
	 public boolean seleccionarProductoProcesadas(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",LstrEmpresa);
	 }
		 
	 public boolean ingresarFechaOperacionDesdeProcesadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[1]/input", Descripcion);
	 }
			
	 public boolean ingresarFechaOperacionHastaProcesadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[2]/input", Descripcion);
	 }
			
	 public boolean ingresoBotonBuscarProcesadas() throws InterruptedException, IOException{		
		 Thread.sleep(5800);	
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	 }
		 
	 public boolean verificarTablaProcesados() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table");
	}
		 
		public int seleccionarSolicitudProcesada() throws InterruptedException, IOException{
			bandera=false;
			String montoTotal=Mdl_Variables.GstrTotalPagar;
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			int intNumeroRegistro=0;
			for (int j = num.size();j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
						
				if(colss.get(2).getText().equals(montoTotal)&&//Monto
				colss.get(3).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION_FECHA)){//Fecha Proceso
					bandera=true; 
					if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
						if(colss.get(1).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_MONEDA)){//Moneda
							bandera=true; 
						}else{
							bandera=false; 
						}
					}
					  
					if(bandera){
						intNumeroRegistro=j;
						break;
					}
						
				}
			}
			return intNumeroRegistro;
		}
		
		public boolean verDetalleProcesada(int intNumeroRegistro) throws InterruptedException, IOException{
			bandera =false;
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			if(num.size()-2==1){
				bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
			}else{
				bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]/tr["+intNumeroRegistro+"]/td[1]/div/div/a");
			}
			return bandera;
		}
		
		public boolean ingresoLinkEnviarEmailFinalProcesada() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/a");		
		 }
		 
		 public boolean ingresarCorreoFinalProcesada(String Descripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
		}
			
		public boolean ingresarMensajeCorreoFinalProcesada(String Descripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
		}
			
		public boolean ingresoBotonEnviarFinalProcesada() throws InterruptedException, IOException{		
			objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
			 objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");	
		}
			
		 public boolean ingresoLinkExportarExcelFinalProcesada() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[4]/a");		
		 }
		 
		 public boolean ingresoLinkExportarPDFFinalProcesada() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[5]/a");		
		 }
		 
		 public boolean ingresoLinkImprimirFinalProcesada() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[6]/a");		
		 }
		 //--------------------------------------BLOQUEADOS
		 public boolean verificarCamposObligatoriosBloqueados() throws InterruptedException, IOException{
			 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		}
				 
		 public boolean seleccionarEmpresaBloqueados(String LstrEmpresa) throws InterruptedException, IOException{		
			 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",LstrEmpresa);
		 }
				
		 public boolean seleccionarProductoBloqueados(String LstrEmpresa) throws InterruptedException, IOException{		
			 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",LstrEmpresa);
		 }
				 
		 public boolean ingresarFechaOperacionDesdeBloqueados(String Descripcion) throws InterruptedException, IOException{	
			 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[1]/input", Descripcion);
		 }
					
		 public boolean ingresarFechaOperacionHastaBloqueados(String Descripcion) throws InterruptedException, IOException{	
			 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[2]/input", Descripcion);
		 }
					
		 public boolean ingresoBotonBuscarBloqueados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
		 }
				 
		 public boolean verificarTablaBloqueados() throws InterruptedException, IOException{
			 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table");
		}
			
		 public boolean verificarDetalleBloqueados()throws InterruptedException, IOException{
			 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/h1[1]");
		}
		 
		 public int seleccionarSolicitudBloqueadas() throws InterruptedException, IOException{		
			 String montoTotal=FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL.substring(4,FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_MONTO_TOTAL.length());
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			 int intNewValor=0;
			 
			 for (int j = 1;j<=num.size()-2;j++){
				 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				 if (colss.get(0).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA)&&//Num Planilla
						 colss.get(2).getText().equals(montoTotal)&&//Monto
						 colss.get(3).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrLBN_OPERACION_FECHA)){//Fecha Proceso
					 bandera=true; 
							
					 if (FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
						 if(colss.get(1).getText().equals(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrCMB_MONEDA)){//Moneda
							 bandera=true; 
						 }else{
							 bandera=false; 
						 }
					 }
					 intNewValor=j;
					 break; 
				}
			}
			 return intNewValor;
		 }
				
		 
		 public boolean verSolicitudBloqueadas(int intNewValor) throws IOException{		
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			 
			 if(num.size()-2==1)
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
			 else
				 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]/tr["+intNewValor+"]/td[1]/div/div/a");
			 
		 }
		 
		 public boolean ingresoLinkEnviarEmailFinalBloqueadas() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/a");		
		 }
		 
		 public boolean ingresarCorreoFinalBloqueadas(String Descripcion) throws InterruptedException, IOException{	
			 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
		 }
			
		 public boolean ingresarMensajeCorreoFinalBloqueadas(String Descripcion) throws InterruptedException, IOException{	
			 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
		 }
			
		 public boolean ingresoBotonEnviarFinalBloqueadas() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 	}
			
		 public boolean ingresoLinkExportarExcelFinalBloqueadas() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[4]/a");		
		 }
		 
		 public boolean ingresoLinkExportarPDFFinalBloqueadas() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[5]/a");		
		 }
		 	
		 public boolean ingresoLinkImprimirFinalBloqueadas() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[6]/a");		
		 }	
}
