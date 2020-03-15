package proxim.bl;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.FinanciamientoDocumentosEleConProAfiBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosElePreAfiProMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera=false;
	
	public boolean seleccionarSubMenu(String LstrProducto) throws InterruptedException, IOException{
		boolean resultado=false;
		for (int i=1; i<=4;i++){
			String str_SubMenu =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[2]/div/ul/li[7]/div/div/ul/li[1]/div/ul/li["+i+"]/a" );  
			if(LstrProducto.equals(str_SubMenu)){
				resultado=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li[7]/div/div/ul/li[1]/div/ul/li["+i+"]/a");
				break;
			}
		}
		return resultado;
	}
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		boolean resultado=false;
		for(int i=1;i<=3;i++){
			String str_SubMenu1 =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a" );  
			if(LstrProducto.equals(str_SubMenu1) ){
				resultado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a");
				break;
			}
		}	
		return resultado;	
	}
	
	//-------------------------------Consulta de Proveedores Afiliados
	
	public boolean verificarCamposObligatoriosConsultaAfiliados(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
			                                                               
		} catch (Exception e) {
		}
		return bandera;
	}
	
	public boolean seleccionarEmpresa(String LstrEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",LstrEmpresa);
	}
		
	public boolean seleccionarProducto(String LstrEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",LstrEmpresa);
	}
		
	public boolean seleccionarProveedor(String LstrEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/table/tbody/tr[1]/td/input",LstrEmpresa);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean verificarTablaConsulta(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean verificarConsulta(String lstrCMB_PRODUCTO, String lstrTXT_NOMBRERAZONSOCIAL,String lstrCMB_TIPODOCUMENTO, String lstrTXT_NUMERODOCUMENTO, String lstrFECHAAFILIACION)
	 {	
		 boolean bandera=false;
		 String producto="";
		 String nombreProveedor="";
		 String documentoProveedor="";
		 String fechaAfiliacion="";
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table"));
		 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		 for (int j = num.size()-2;j>=1;j--){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			 producto=colss.get(0).getText();
			 nombreProveedor=colss.get(1).getText();
			 documentoProveedor=colss.get(2).getText();
			 fechaAfiliacion=colss.get(7).getText();
						 
			 if (producto.equals(lstrCMB_PRODUCTO)
					 &&nombreProveedor.equals(lstrTXT_NOMBRERAZONSOCIAL)
					 &&documentoProveedor.equals(lstrCMB_TIPODOCUMENTO+" "+lstrTXT_NUMERODOCUMENTO)
					 &&fechaAfiliacion.equals(lstrFECHAAFILIACION))
			 {
				 bandera=true;
				 break;
			 }else{
				 bandera=false;
			 }
		 }
		 return bandera;
	 }

	 public String BuscarCadenaTabla(String strCadena, String seccionGrilla) throws InterruptedException, IOException{		
			int intColumna=0;
			WebElement tabla=null;
			List<WebElement> num=null;
			
			switch (seccionGrilla) {
				case "TasaDescuentoSoles":
					intColumna=4;
					break;
					
				case "TasaDescuentoDolares":
					intColumna=5;
					break;
				
				default:
					break;
			}

			tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table"));
			String strTexto;
			String nuevaCadena="";

			num=tabla.findElements(By.xpath(".//tr"));
			int numero=num.size()-2;
			for (int k = 1;k<=numero;k++){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+k+"]/td")));
				strTexto = colss.get(intColumna).getText();
				if(!objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
					nuevaCadena+=strTexto+", ";
				}
			}	

			return nuevaCadena;		
		}
	 
	 public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/a");		
	 }
	 
	public boolean verificarMensajeCorreo(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/span[2]");
			                                                               
		} catch (Exception e) {
		}
		return bandera;
	}
		
	 public boolean verificarTablaCorreo(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/span[2]");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean ingresarCorreo(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	 }
		
	 public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	 }
		
	 public boolean ingresoBotonEnviarCorreo() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
		
	 public boolean verificarTablaCorreoConfirmacion(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean ingresoBotonAceptarCorreo() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
	 
	 public boolean verificarTablaCorreoConsulta(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean ingresoBotonAceptarCorreoConsulta() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
	 
	 public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[6]/a");		
	 }
	 
	 
	 
	//-------------------------------Pre Afiliacion de Proveedores
	 
	 public boolean verificarEnvioCamposObligatoriosPreAfiliacion(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean seleccionarEmpresaPreAfiliacion(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[3]/select",LstrEmpresa);
	 }
			
	 public boolean seleccionarProductoPreAfiliacion(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[5]/select",LstrEmpresa);
	 }
	
	 public boolean seleccionarTipoDocumentoPreAfiliacion(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[7]/select",LstrEmpresa);
	 }
	
	 public boolean ingresarNumeroDocumentoPreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[7]/input", Descripcion);
	 }
			
	 public boolean ingresarNombreRazonSocialPreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[9]/input", Descripcion);
	 }
	
	 public boolean ingresarNombrePreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[11]/input[1]", Descripcion);
	 }
	 
	 public boolean ingresarTelefonoPreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[11]/input[2]", Descripcion);
	 }
	 
	 public boolean ingresarEmailPreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[11]/input[3]", Descripcion);
	 }
	 	
	 public boolean ingresoBotonPreafiliarPreAfiliacion() throws InterruptedException, IOException{			
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/a/img");		
	 }
	 
	 public boolean verificarTablaPreAfiliacionProveedores(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[5]/div/div/table");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean verificarPreAfiliacionProveedores(String lstrCMB_EMPRESA, String lstrCMB_PRODUCTO, String lstrTXT_NOMBRERAZONSOCIAL, String lstrTXT_NUMERODOCUMENTO, String lstrTXT_TELEFONOCONTACTO, String lstrTXT_EMAILCONTACTO, String lstrFECHAAFILIACION, String lstrESTADOAFILIACION)
	 {	
		 boolean bandera=false;
		 String empresa="";
		 String producto="";
		 String nombreProveedor="";
		 String documentoProveedor="";
		 String telefono="";
		 String email="";
		 String fechaPreAfiliacion="";
		 String estadoAfiliacion="";
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		 for (int j = num.size()-2;j>=1;j--){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			 if(FinanciamientoDocumentosEleConProAfiBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
				producto=colss.get(0).getText();
				 nombreProveedor=colss.get(1).getText();
				 documentoProveedor=colss.get(2).getText();
				 telefono=colss.get(3).getText();
				 email=colss.get(4).getText();
				 fechaPreAfiliacion=colss.get(5).getText();
				 estadoAfiliacion=colss.get(6).getText();
			 }else{
				 empresa=colss.get(0).getText();
				 producto=colss.get(1).getText();
				 nombreProveedor=colss.get(2).getText();
				 documentoProveedor=colss.get(3).getText();
				 telefono=colss.get(4).getText();
				 email=colss.get(5).getText();
				 fechaPreAfiliacion=colss.get(6).getText();
				 estadoAfiliacion=colss.get(7).getText();
			 }
			 
			 if (producto.equals(lstrCMB_PRODUCTO)
					 &&nombreProveedor.equals(lstrTXT_NOMBRERAZONSOCIAL)
					 &&documentoProveedor.equals(lstrTXT_NUMERODOCUMENTO)
					 &&telefono.equals(lstrTXT_TELEFONOCONTACTO)
					 &&email.equals(lstrTXT_EMAILCONTACTO)
					 &&fechaPreAfiliacion.equals(lstrFECHAAFILIACION)
					 &&estadoAfiliacion.equals(lstrESTADOAFILIACION))
			 {
				 if(FinanciamientoDocumentosEleConProAfiBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					 bandera=true;
					 break;
				 }else if (empresa.equals(lstrCMB_EMPRESA)){
					 bandera=true;
					 break;
				 }else{
					 bandera=false;
				 }
				
			 }else{
				 bandera=false;
			 }
		 }
		 return bandera;
	 }

				
	 public boolean ingresoLinkEnviarEmailPreAfiliacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[1]/a");		
	 }
	 
	 public boolean verificarTablaCorreoPreAfiliacion(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/span[2]");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean ingresarCorreoPreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	 }
		
	 public boolean ingresarMensajeCorreoPreAfiliacion(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	 }
		
	 public boolean ingresoBotonEnviarCorreoPreAfiliacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
		
	 public boolean verificarTablaCorreoConfirmacionPreAfiliacion(){
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		 } catch (Exception e) {
		 }
		 return bandera;
	 }
	 
	 public boolean ingresoBotonAceptarCorreoPreAfiliacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
	 
	 public boolean ingresoLinkExportarExcelPreAfiliacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFPreAfiliacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirPreAfiliacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[6]/a");		
	 }
	 
	 
	 //-------------------------------Consulta de Proveedores Preafiliados
	 
		 public boolean verificarEnvioCamposObligatoriosConPreafiliados(){
			 try {
				 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
			 } catch (Exception e) {
			 }
			 return bandera;
		 }
		 
		 public boolean seleccionarEmpresaConPreafiliados(String LstrEmpresa) throws InterruptedException, IOException{		
			 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",LstrEmpresa);
		 }
				
		 public boolean seleccionarProductoConPreafiliados(String LstrEmpresa) throws InterruptedException, IOException{		
			 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",LstrEmpresa);
		 }
		
		 public boolean seleccionarProveedorConPreafiliados(String LstrEmpresa) throws InterruptedException, IOException{		
			 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/table/tbody/tr[1]/td/input",LstrEmpresa);
		 }
		
		 public boolean ingresoBotonBuscarConPreafiliados() throws InterruptedException, IOException{			
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
		 }
		 
		 public boolean verificarTablaConPreafiliados(){
			 try {
				 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table");
			 } catch (Exception e) {
			 }
			 return bandera;
		 }
		 
		 public boolean verificarConPreafiliados(String lstrCMB_PRODUCTO, String lstrTXT_NOMBRERAZONSOCIAL, String lstrTXT_NUMERODOCUMENTO, String lstrTXT_TELEFONOCONTACTO, String lstrTXT_EMAILCONTACTO, String lstrFECHAAFILIACION, String lstrESTADOAFILIACION)
		 {	
			 boolean bandera=false;
			 String producto="";
			 String nombreProveedor="";
			 String documentoProveedor="";
			 String telefono="";
			 String email="";
			 String fechaAfiliacion="";
			 String estadoAfiliacion="";
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			
			 for (int j = num.size()-2;j>=1;j--){
				 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				 producto=colss.get(0).getText();
				 nombreProveedor=colss.get(1).getText();
				 documentoProveedor=colss.get(2).getText();
				 telefono=colss.get(3).getText();
				 email=colss.get(4).getText();
				 fechaAfiliacion=colss.get(5).getText();
				 estadoAfiliacion=colss.get(6).getText();
				 
				 if (producto.equals(lstrCMB_PRODUCTO)
						 &&nombreProveedor.equals(lstrTXT_NOMBRERAZONSOCIAL)
						 &&documentoProveedor.equals(lstrTXT_NUMERODOCUMENTO)
						 &&telefono.equals(lstrTXT_TELEFONOCONTACTO)
						 &&email.equals(lstrTXT_EMAILCONTACTO)
						 &&fechaAfiliacion.equals(lstrFECHAAFILIACION)
						 &&estadoAfiliacion.equals(lstrESTADOAFILIACION))
				 {
					 bandera=true;
					 break;
				 }else{
					 bandera=false;
				 }
			 }
			 return bandera;
		 }

					
		 public boolean ingresoLinkEnviarEmailConPreafiliados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/a");		
		 }
		 
		 public boolean verificarTablaCorreoConPreafiliados(){
			 try {
				 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/span[2]");
			 } catch (Exception e) {
			 }
			 return bandera;
		 }
		 
		 public boolean ingresarCorreoConPreafiliados(String Descripcion) throws InterruptedException, IOException{	
			 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
		 }
			
		 public boolean ingresarMensajeCorreoConPreafiliados(String Descripcion) throws InterruptedException, IOException{	
			 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
		 }
			
		 public boolean ingresoBotonEnviarCorreoConPreafiliados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
		 }
			
		 public boolean verificarTablaCorreoConfirmacionConPreafiliados(){
			 try {
				 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
			 } catch (Exception e) {
			 }
			 return bandera;
		 }
		 
		 public boolean ingresoBotonAceptarCorreoConPreafiliados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
		 }
		 
		 public boolean ingresoLinkExportarExcelConPreafiliados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[4]/a");		
		 }
		 
		 public boolean ingresoLinkExportarPDFConPreafiliados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[5]/a");		
		 }
		 
		 public boolean ingresoLinkImprimirConPreafiliados() throws InterruptedException, IOException{		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[6]/a");		
		 }
	
}
