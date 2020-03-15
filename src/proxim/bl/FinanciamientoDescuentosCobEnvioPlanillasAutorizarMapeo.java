package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasDetalleBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasGeneralBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean bandera=false;
	String strTabla         ="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[1]/div/div/div[5]/div/div/table";
	String strTablaResultado="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table";
	String strSoles= "Soles";
	String strMensajeCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]";
	String strTablaXpath="//table[@class='cellTableWidget']";
	String strNombreAceptante="//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[3]/span[2]";
	String strTr=".//tr";
	
	public boolean seleccionarSubMenu(String strProducto) {	
		boolean var=false;
		try {
			for(int i=1;i<=4;i++){
				String valor = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li[7]/div/div/ul/li[2]/div/ul/li["+i+"]/a");
				
				if(strProducto.equals(valor) ){
					var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li[7]/div/div/ul/li[2]/div/ul/li["+i+"]/a");
					break;
				}
			}
		} catch (Exception e) {
			var=false;
		}
		return var;	
	}
	
	public boolean seleccionarSubMenu1(String strProducto) {	
		boolean var=false;
			for(int i=1;i<=4;i++){
				String valor = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
				
				if(strProducto.equals(valor) ){
					var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
					break;
				}
			}
		return var;	
	}
	
	public boolean verificarEnvioCamposObligatorios() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/span");
	}
	
	public boolean seleccionarEmpresa(String strVarEntrada) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/select",strVarEntrada);
	}

	public boolean seleccionarTipoCarga(String strTipoCarga) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/select",strTipoCarga);
	}
	
	public boolean ingresoBotonPopupSI() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/a/img");
	}

	public boolean ingresoBotonPopupNO() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[2]/a/img");
	}
	
	public boolean ingresoBotonArchivo(String strRuta)  throws InterruptedException {			
		return objObjetosGenerales.setTextNew(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/form/input",strRuta);
	}

	public boolean ingresoDescargarMacro() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/a");
	}
	
	public boolean verificarCuandoDigitacion() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/select");
	}
	
	public boolean seleccionarProducto(String strProducto) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/select",strProducto);
	}
	
	public boolean ingresoChkProtestar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div/div[1]/span[1]/input");
	}
	
	public boolean ingresoChkCobrarInteres() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div/div[2]/span[1]/input");
	}
	
	public boolean seleccionarMoneda(String strValorEntrada) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[4]/select",strValorEntrada);
	}
	
	public boolean seleccionarCuentaCargo(String strValorEntrada) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[6]/select",strValorEntrada);
	}																	
	
	public boolean ingresarNombrePlanilla(String strNombrePlanilla)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[8]/input", strNombrePlanilla);
	}
	
	public boolean ingresoBotonAgregar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/a/img");
	}
	
	//------------------ Cabecera Aceptante ------------
	
	public boolean seleccionarTipoDocumentoAceptante(String strTipoDocumento) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/select",strTipoDocumento);
	}
	
	public boolean ingresarNroDocumentoAceptante(String strNroDocumento)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/input",strNroDocumento);
	}
	
	public boolean ingresarNombreAceptante(String strNombre)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[4]/div[1]/input",strNombre);
	}
	
	public boolean ingresarApePatAceptante(String strApePat)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[4]/div[2]/input",strApePat);
	}
	
	public boolean ingresarApeMatAceptante(String strApeMat)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[4]/div[3]/input",strApeMat);
	}
	
	public boolean ingresarDireccionAceptante(String strDireccion)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[6]/div[1]/input",strDireccion);
	}
	
	public boolean seleccionarUbigeo(String strUbigeo)  throws InterruptedException {			
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[6]/div[2]/div/input",strUbigeo);
	}
	
	public boolean ingresarNumeroDocumentos(String strNumero)  throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[8]/input",strNumero);
	}
	
	public boolean ingresoBotonAgregarAceptante() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/a/img");
	}
	
	//----------------------------------------------------
	
	//------------------ Detalle Tabla ------------
	
	public String obtenerNroDocumentoAceptanteTabla(int indice) {		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[4]/div");
	}
	
	public boolean ingresarNroDocumento(String strNroDocumento,String indice) throws InterruptedException {	
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		int totalRegistros=num.size()-2;
		if(totalRegistros==1){
			bandera= objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr/td[5]/div/div/input",strNroDocumento);
			
		}else{
			bandera= objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[5]/div/div/input",strNroDocumento);
		}

		return bandera;
	}
	
	public boolean ingresarMonto(String strMonto,String indice) throws InterruptedException {	
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		int totalRegistros=num.size()-2;
		if(totalRegistros==1){
			bandera= objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr/td[6]/div/div/input",strMonto);
			
		}else{
			bandera=objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[6]/div/div/input",strMonto);
		}
		return bandera;
	}
	
	public boolean ingresarFechaVencimiento(String strFecha,String indice) throws InterruptedException {	
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		int totalRegistros=num.size()-2;
		if(totalRegistros==1){
			bandera= objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr/td[7]/div/div/input",strFecha);
			
		}else{
			bandera=objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[7]/div/div/input",strFecha);
		}
		return bandera;
	}
	
	public Boolean ingresoEliminarDetalle(String indice) {	
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		int totalRegistros=num.size()-2;
		if(totalRegistros==1){
			bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr/td[1]/div/div/a/img");
			
		}else{
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[1]/div/div/a/img");
		}
		return bandera;
	}
	
	
	public String obtenerObservacion(int indice) {		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table/tbody[1]/tr["+indice+"]/td[8]/div");
	}
	
	public Boolean ingresoCrearPlanilla() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[2]/a/img");
	}
	
	//-----------------------------------------------
	
	public boolean ingresoBotonEditar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/a/img");
	}
	
	public boolean ingresoBotonEliminar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[3]/div/div/a/img");
	}
	
	public boolean ingresoBotonVer() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div/div/a");
	}
	
	public boolean verificarLapizEdicion(String ruta) {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, ruta);
	}

	public int seleccionarPlanillaColumna(String strNombrePlanilla, int nColumBusq1,int nColumSelec1) throws SQLException, IOException, InterruptedException {	
		boolean bandera=false;
		String nombrePlanillaTabla=null;
		String registrosErradosTabla=null;
		String producto=null;
		String strCuentaCorriente=null;
		String strEmpresa=null;
		String strNumeroCuentaBuscar=null;
		Map<String,String> map;
		int intNumeroFila=0;
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
			
			List<WebElement> num=tabla.findElements(By.xpath(strTr));
			map=objFuncionesGenerales.obtenerDatosEmpresaVariante(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_CUENTA_CORRIENTE);
			strNumeroCuentaBuscar=map.get("strNumeroCuenta") ;
			
			
			for (int j = num.size()-2;j>=1;j--){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){//empresa
					producto=colss.get(4).getText();
					nombrePlanillaTabla=colss.get(5).getText();
					strCuentaCorriente=colss.get(8).getText();
				}else{
					strEmpresa=colss.get(4).getText();
					producto=colss.get(5).getText();
					nombrePlanillaTabla=colss.get(6).getText();
					strCuentaCorriente=colss.get(9).getText();
				}
				
				if(producto.equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_PRODUCTO)&& 
						nombrePlanillaTabla.equals(strNombrePlanilla) &&
						strCuentaCorriente.equals(strNumeroCuentaBuscar)){
								
						if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(strEmpresa)||
							FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
							bandera=true;
							intNumeroFila=j;
						}else{
							bandera=false;
						}
							
						if(bandera){
							Thread.sleep(400);
							if(num.size()-2==1){
								bandera =objObjetosGenerales.waitClickableBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/input");
								
							}else{
								bandera =objObjetosGenerales.waitClickableBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[1]/div/div/input");
							}
						
							if(bandera){
								tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
								colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
								
								if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){//empresa
									registrosErradosTabla=colss.get(10).getText();
								}else{
									registrosErradosTabla=colss.get(11).getText();
								}
								
								if (registrosErradosTabla.equals("0")){//Compara QUE NO HAYA REGISTROS ERRADOS
									if(num.size()-2==1){
										bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/input");
									}else{
										bandera = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[1]/div/div/input");
									}
									break;
								}
							}
						}
					}
			}
			
		return intNumeroFila;
	}
	
	public boolean seleccionarPlanillaVer(String strNombrePlanilla, int nColumBusq,int nColumSelec,int intNumeroRegistro) {	
		boolean bandera=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
		
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		
		if(num.size()-2==1){
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div/div/a");
		}else{
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr["+intNumeroRegistro+"]/td[4]/div/div/a");
		}
		return bandera;
	}
	
	public boolean verificarConfirmacionEnvio() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[3]");
	}
	
	public boolean verificarTablaVerificacion() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table");
	}
	
	public boolean verificarLinkRegresar() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[1]/a");
	}
	
	public boolean verificarTablaDetalleEmpresaPlanilla() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div/li/div/div/div[5]/div/div/table");
	}
	
	public boolean ingresoCrearPlantilla() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[2]/a/img");
	}
	
	public boolean ingresoEnviar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/a/img");
	}
	
	public boolean ingresoLinkVerDetalle() {
		boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[3]/div/div/div/div[5]/div/div/table"));
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (colss.get(2).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasDetalleBE.GstrCMB_TIPO_DOCUMENTO_ACEPTANTE+" "+FinanciamientoDescuentosCobEnvioPlanillasDetalleBE.GstrTXT_NRO_DOCUMENTO_ACEPTANTE)){//Num Planilla
				if (colss.get(3).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasDetalleBE.GstrTXT_DIRECCION_ACEPTANTE)){//Num Planilla
					colss.get(0).click();
					var=true;
					break;
				}
			}
		}
		return var;
	}
	
	public boolean ingresoLinkRegresar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[1]/a");
	}

	public boolean ingresoBotonCerrar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
	}
	
	public boolean ingresoChkAcepto() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/span[1]/input");
	}
	
	public boolean ingresoClave(String strClave)  {	
		
			String  strValorBoton = "";
			   String  strLetraValor = "";

			   for (int i = 1;i<=strClave.length();i++) {
				   strLetraValor = strClave.split("")[i - 1];
		        
				   for (int j = 1; j <= 10; j++) {
					   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/div[1]/div[2]/div[1]/button["+j+"]")).getText();
		        
					   if (strValorBoton.equals(strLetraValor))
					   {
						   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/div[1]/div[2]/div[1]/button["+j+"]")).click();
						   break;
					   }
				   }
		       }
			   return true;
	   }
	
	public boolean ingresoClaveAutorizar(String strClave)   {	
		
			String  strValorBoton = "";
			   String  strLetraValor = "";

			   for (int i = 1;i<=strClave.length();i++){
				   strLetraValor = strClave.split("")[i - 1];
		        
				   for (int j = 1; j <= 10; j++)   {
					                                           
					   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/button["+j+"]")).getText();
		        
					   if (strValorBoton.equals(strLetraValor)) {
						   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/button["+j+"]")).click();
						   break;
					   }
				   }
		       }

		   
		   return true;
	   }
	
	public boolean ingresarClaveDinamica(String strClaveDinamica) throws InterruptedException {	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/input",strClaveDinamica);
	}
	
	public boolean ingresoBotonConfirmar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/a[1]");
	}
	
	public boolean ingresoBotonCancelarOperacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/a[2]");
	}
	
	public String obtenerResultadoEsperado() {		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]");
	}

	public boolean compararResultadoEsperadoPositivo() {	
	   String strMensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]" );  
	   
	   if(strMensaje.equals("Tu operación ha sido realizada con éxito")) {
			return true;
	   }else{
		   return false;
	   }	
   }
	
	public boolean buscarMensaje() {
		return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean buscarMensaje1(){
		return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/span");
	}
	
	 public boolean guardarDatosOperacion() throws SQLException {	
		 FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[1]/div" );
		 FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/span[2]" );
		 FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/span[4]" );

		 String montoOperacion;
			
		 if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
			 montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[6]/div" );
		 }else{
			 montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[7]/div" );
		 }
		
		 Mdl_Variables.Garr_montosBuscar=new String[1];
		 String valorMoneda=montoOperacion.substring(0, 3);
		 String nuevoValorMoneda;
		 int numeroInicio;
		 
		 if(valorMoneda.equals("S/")){
			 nuevoValorMoneda="S/-";
			 numeroInicio=4;
		 }else{
			 nuevoValorMoneda="US$-";
			 numeroInicio=5;
		 }
			 
		 Mdl_Variables.Garr_montosBuscar[0] =nuevoValorMoneda +montoOperacion.substring(numeroInicio, montoOperacion.length());
			 
			 
		 int totalCadena=montoOperacion.length();
		 if(montoOperacion.contains("/")){
				Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
			}else{
				Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
			}


		 FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL=montoOperacion;
			
		 if(buscarMensaje()){
			 FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[2]" );
		 }else{
			 FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_NUMERO_PLANILLA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/li/table/tbody[1]/tr/td[2]/div" ); 
		}
		 
		 bandera= objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D set LBN_OPERACION='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_RESULTADO_FINAL+"', LBN_NUMERO_PLANILLA='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_NUMERO_PLANILLA+"' where ID_CASO="+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.Gstr_ID_CASO);
		 return bandera;
	 }
	 
	 public boolean ingresoLinkRealizarOtraOperacion() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/a");		
	 }
	 
	 public boolean ingresoLinkEnviarEmail() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreo( String strValor)  throws InterruptedException {		
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", strValor);
	 }
			
	 public boolean ingresarMensajeCorreo( String strValor)  throws InterruptedException {		
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", strValor);
	 }
			
	 public boolean ingresoBotonEnviar() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
		
	 public boolean ingresoBotonAceptarCorreo() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
		
	 public boolean verificarMensajeCorreo() {
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strMensajeCorreo);
	 }
	 
	 public boolean ingresoLinkExportarExcel() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div/div[4]/a");		
	 }			
	 
	 public boolean ingresoLinkExportarPDF() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimir() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div/div[6]/a");		
	 }
	 
	public String obtenerMensajeFront(String strColumna,int nSeccion) {	
		
		String texto ="";
		
		if(nSeccion == 1) { //seccion mensaje datos de prouesto
		 	switch (strColumna){
				case "CMB_EMPRESA":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[2]/span[2]");
					break;
				case "CMB_TIPO_CARGA":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[4]/span[2]");
					break;
				case "BTN_SELECCIONAR_ARCHIVO":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/span[2]");
					break;
				case "CMB_PRODUCTO":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[1]/span[2]");
					break;
				case "CMB_MONEDA":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[3]/span[2]");
					break;
				case "CMB_CUENTA_CARGO":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[5]/span[2]");
					break;
				case "TXT_NOMBRE_PLANILLA":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[7]/span[2]");
					break;
			}
		
		}
		if(nSeccion == 2) {//seccion mensaje datos del aceptante
			switch (strColumna){
				case "CMB_TIPO_DOCUMENTO_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[1]/span[2]");
					break;
				case "TXT_NRO_DOCUMENTO_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[1]/span[2]");
					break;
				case "TXT_NOMBRE_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, strNombreAceptante);
					break;
				case "TXT_APEPAT_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, strNombreAceptante);
					break;
				case "TXT_APEMAT_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, strNombreAceptante);
					break;
				case "TXT_DIRECCION_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[5]/span[2]");
					break;
				case "CMB_UBIGEO_ACEPTANTE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[5]/span[2]");
					break;
				case "TXT_NUMERO_DOCUMENTOS":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[7]/span[2]");
					break;
			}
		}
		if(nSeccion == 3 &&strColumna.equals("CHK_SELECCIONAR")) { //seccion vlidacion de tabla detalle
			texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/span");
		}
		
		if(nSeccion == 4) { //seccion confirmaciÃ³n
			switch (strColumna){
				case "CHK_ACEPTO_TERMINO":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[2]");
					break;
				case "TXT_CLAVE":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/span");
					break;
				case "TXT_CLAVE_DINAMICA":
					texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/span[2]");
					break;
			}
		}
		return texto;
	}
	
	public boolean verificarCabecera() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/select");
	}
	
	//------------------------------------AUTORIZACION
	
	public boolean seleccionarEmpresaAutorizacion(String strVarEntrada) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/select",strVarEntrada);
	}
	
	public boolean seleccionarProductoAutorizacion(String strProducto) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/select",strProducto);
	}
	
	public boolean ingresarFechaInicioAutorizacion(String strValor)  throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[1]/input", strValor);
	}
	
	public boolean ingresarFechaFinAutorizacion(String strValor)  throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[2]/input", strValor);
	}
	
	public boolean ingresoBotonBuscarAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/button");
	}
	
	public boolean ingresoLinkVerLotesExpiradosAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/a");
	}
	
	public boolean ingresoChkTodosAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[1]/div/div/div[5]/div/div/table/thead/tr/th[1]/input");
	}
	
	public boolean verificarTablaAutorizacion() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strTabla);
	}
	
	public boolean ingresoBotonAutorizarAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/a[1]/div/img");
	}
	
	public boolean ingresoBotonBloquearAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/a[2]/div/img");
	}
	
	public boolean ingresoLinkVerOperacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
	}
	
//-----------------
	public boolean ingresoLinkEnviarEmailAutorizacionExpirados() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[3]/div/div[1]/a");		
	}
	 
	 public boolean ingresoLinkExportarExcelAutorizacionExpirados() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizacionExpirados() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizacionExpirados() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[3]/div/div[6]/a");		
	 }
	 
	 public boolean ingresoLinkRegresarExpirados() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[2]/a");		
	 }
//-----------------
	 public boolean ingresoLinkEnviarEmailAutorizacion() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[1]/a");		
	 }
	 
	 public boolean ingresoLinkExportarExcelAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div[2]/div/div/div[6]/a");		
	 }
	 
	 public boolean seleccionarLoteFirmar(String cuentaCargo) {	
		 String strTipoProductoBuscar= cuentaCargo.substring(0, 16);
			String strMonedaBuscar=null;
			String strNumeroCuentaBuscar1=null;
			
			if(strTipoProductoBuscar.equals("Cuenta Corriente")){
				strMonedaBuscar=cuentaCargo.substring(17, 22);
				if(strMonedaBuscar.equals(strSoles)){
					strNumeroCuentaBuscar1=cuentaCargo.substring(27, 37);
				}else{
					strMonedaBuscar=cuentaCargo.substring(17, 24);
					strNumeroCuentaBuscar1=cuentaCargo.substring(29, 39);
				}
			}else{
				strTipoProductoBuscar= cuentaCargo.substring(0, 17);
				strMonedaBuscar=cuentaCargo.substring(18, 23);
				if(strMonedaBuscar.equals(strSoles)){
					strNumeroCuentaBuscar1=cuentaCargo.substring(28, 38);
				}else{
					strMonedaBuscar=cuentaCargo.substring(18, 25);
					strNumeroCuentaBuscar1=cuentaCargo.substring(30, 40);
				}
			}
			
			boolean var=false;
				WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
				
				List<WebElement> num=tabla.findElements(By.xpath(strTr));
				for (int j = num.size()-2;j>=1;j--){
					List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
					if ((colss.get(3).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrCMD_PRODUCTO)|| colss.get(2).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrCMD_PRODUCTO))&&//Compara PRODUCTO
					 (colss.get(4).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrTXT_NOMBRE_PLANILLA)|| colss.get(3).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrTXT_NOMBRE_PLANILLA))&&//Compara NOMBRE PLANILLA
					 (colss.get(6).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL)|| colss.get(5).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL))){//Compara MONTO TOTAL
									String numCuenta,numCuentaNueva;
									if(!FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
										numCuenta=colss.get(7).getText();
									}else{
										numCuenta=colss.get(6).getText();
									}
									
									numCuentaNueva=numCuenta.substring(4,numCuenta.length());
									
									if (numCuentaNueva.equals(strNumeroCuentaBuscar1)){//Compara TOTAL REGISTROS
										var = true;
										if(!FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
											if(colss.get(2).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA)){
												var = true;
											}else{
												var = false;
											}
										}
									}
								
							}
						
					if(var){
						colss.get(0).click();
						break;
					}
					
				}
			return var;
		}
	 
	public boolean verificarConfirmarOperacionAutorizacion() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//*[@id='pasoOperacionConfirmacion']/span[3]");
	}
	
	public boolean ingresarClaveDinamicaAutorizacion(String strClaveDinamica)  throws InterruptedException {	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/input",strClaveDinamica);
	}
	 
	 public boolean ingresoLinkQuieresSaberComoAutorizacion() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='pasoClaveDinamica']/a");		
	 }
	 
	 public boolean ingresoBotonConfirmarAutorizacion() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/a[1]");
	 }
	
	public boolean ingresoBotonCancelarOperacionAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/a[2]");
	}
	
	public boolean verificarmensajeFinal() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span");
	}

	public boolean compararResultadoEsperadoPositivoAutorizar(String strResultadoEsperado) throws SQLException {	
		String strMensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span" );  
		   
		if(strMensaje.equals(strResultadoEsperado)){
			FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div" );
			FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/span[2]" );
			FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/span[4]" );
			   
			if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
				FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[6]/div" );
			}else{
				FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[7]/div" );
			}
			   
			if(buscarMensaje1()){
				FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/span" );
			}else{
				FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_NUMERO_PLANILLA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[2]/div" ); 
				bandera= objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D set  LBN_NUMERO_PLANILLA='"+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_NUMERO_PLANILLA+"' where ID_CASO="+FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.Gstr_ID_CASO);
			}
			objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_AUTORIZAR_D set LBN_OPERACION='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.Gstr_ID_CASO);
				
			return true;
		}else{
			return false;
		}	
	}
	
	public boolean compararMensajeRechazado() {	
		boolean var=false;
		try {
			String strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[1]/div/a")).getText();
			if(strMensaje.equals("Ver detalle de operaciones rechazadas")){
				var= true;
			}
		} catch (Exception e) {
			var= false;
		}
		return var;
	}
	
	public boolean ingresoLinkVerOperacionRechazadas() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[1]/div/a");
	}
	 
	public boolean ingresoBotonCerrarPopUp() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
	}
	 
	public boolean ingresoLinkEnviarEmailFinalAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/a");		
	}
	 
	 public boolean ingresoLinkExportarExcelFinalAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinalAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinalAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[6]/a");		
	 }
	 
	 public boolean ingresoLinkRealizarOtraOperacionAutorizacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[4]/a");		
	 }
	 
	 //--------------------------------------PROCESADOS
	 
	 public boolean seleccionarEmpresaProcesadas(String strVarEntrada) {		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strVarEntrada);
	 }
	
	 public boolean seleccionarProductoProcesadas(String strVarEntrada) {		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strVarEntrada);
	 }
	 
	 public boolean ingresarFechaOperacionDesdeProcesadas(String strValor)  throws InterruptedException {		
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[1]/input", strValor);
	 }
		
	 public boolean ingresarFechaOperacionHastaProcesadas(String strValor)  throws InterruptedException {		
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[2]/input", strValor);
	 }
		
	 public boolean ingresoBotonBuscarProcesadas()  throws InterruptedException {		
		 Thread.sleep(5800);	
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	 }
	 
	 public boolean verificarTablaProcesados() {
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strTablaResultado);
	 }
	 
	public boolean verificarDetalleProcesados() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/h1[1]");
	}
	 
	public int seleccionarSolicitudProcesada() {
		String montoTotal=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL.substring(3,FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL.length()).trim();
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]"));
		List<WebElement> num=tabla.findElements(By.xpath(strTr));
		int intNumeroRegistro=0;
		for (int j = num.size();j>=1;j--){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				if(colss.get(1).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_MONEDA)&&//Moneda
				colss.get(2).getText().equals(montoTotal)&&//Monto
				colss.get(3).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_OPERACION_FECHA)){//Fecha Proceso
					intNumeroRegistro=j;
					break; 
				}
		}
		return intNumeroRegistro;
	}
	
	public boolean verDetalleProcesada(int intNumeroRegistro) {
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaXpath));
		List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intNumeroRegistro+"]/td")));
		colss.get(0).click();
		return true;
	}
	
	public boolean ingresoLinkEnviarEmailFinalProcesada() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/a");
	}
	 
	 public boolean ingresoLinkExportarExcelFinalProcesada() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinalProcesada() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinalProcesada() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[6]/a");		
	 }
 //--------------------------------------BLOQUEADOS
	 public boolean verificarCamposObligatoriosGeneral() {
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	 }
		
	 public boolean ingresarFechaOperacionDesdeBloqueados(String strValor)  throws InterruptedException {		
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[1]/input", strValor);
	 }
			
	 public boolean ingresarFechaOperacionHastaBloqueados(String strValor) throws InterruptedException {	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[2]/input", strValor);
	 }
				
	 public int seleccionarSolicitudBloqueadas() {
		 int intNewNumero=0;
		 String strFechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		 String montoTotal;
		 
		 if(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_MONEDA.equals(strSoles)){
			 montoTotal=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL.substring(3,FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL.length());
				
		 }else{
			 montoTotal=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL.substring(4,FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrLBN_MONTO_TOTAL.length());
		 }
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaResultado));
			
		 List<WebElement> num=tabla.findElements(By.xpath(strTr));
			
		 for (int j = 1;j<=num.size()-2;j++){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			 if (colss.get(0).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrTXT_NOMBRE_PLANILLA)&&
				colss.get(1).getText().equals(FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_MONEDA)&&
				colss.get(2).getText().equals(montoTotal)&&
				colss.get(3).getText().equals(strFechaBusqueda)){//Fecha Proces
				intNewNumero=j;   
				break;
			}	
		}
		return intNewNumero;
	 }
				 
	public boolean seleccionarDetalleSolicitudBloqueadas(int intNewNumero) {
		 boolean blnResultadoEsperado=true;
		 try {
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTablaResultado));
			 List<WebElement> num=tabla.findElements(By.xpath(strTr));
			 if(num.size()-2==1){
				 blnResultadoEsperado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");	
			 }else{
				 blnResultadoEsperado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div/div[5]/div/div/table/tbody[1]/tr["+intNewNumero+"]/td[1]/div/div/a");	
			 }
		 } catch (Exception e) {
			blnResultadoEsperado=false;
		}
		 return blnResultadoEsperado;
	 }
		 
				 
	public boolean ingresoLinkEnviarEmailFinalBloqueadas() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/a");		
	 }
	 
	 public boolean ingresoLinkExportarExcelFinalBloqueadas() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinalBloqueadas() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinalBloqueadas() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[6]/a");		
	 }	
	 
		public String buscarCadenaTabla(String strCadena, String seccionGrilla) {		
			int intColumna=0;
			String strPathPagina = "";
			boolean caso=true;
			WebElement tabla=null;
			List<WebElement> num=null;
			
			switch (seccionGrilla) {
				case "MontoPlanilla":
					intColumna=5;
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div[1]/div/div/li/table"));
					break;
					
				case "MontoTotalGrillaEnvio":
					intColumna=7;
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[1]/div/div[5]/div/div/table"));
					break;
				
				case "MontoDetallePlanilla":
					intColumna=8;
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div/div/div/div/div[3]/div/div/div/div[5]/div/div/table"));
					break;
					
				case "MontoDetalleEmpresaPlanilla":
					intColumna=3;
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div/li/div/div/div[5]/div/div/table"));
					break;
					
				case "MontoTotalDetalleBusqueda":
					if (!FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
						intColumna=6;
					}else{
						intColumna=5;
					}
							
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
					break;
				
				case "MontoTotalConfirmacion":
					intColumna=5;
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div/div/div/div[1]/div/div[5]/div/div/table"));
					break;
					
				case "MontoTotalResultadoEsperado":
					intColumna=5;
					strPathPagina = "";
					tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/li/table"));
					break;
					
				default:
					
					break;
			}
			String strTexto;
			String nuevaCadena="";
			
			boolean booleanLink=false;
			int j=2;	
			while(caso){
				num=tabla.findElements(By.xpath(strTr));
				int numero=num.size()-2;
				for (int k = 1;k<=numero;k++){
					List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+k+"]/td")));
					strTexto = colss.get(intColumna).getText();
					if(objFuncionesGenerales.buscarCadena(strCadena, strTexto)){	
						nuevaCadena+="- "+strTexto;
					}
					
				}	
				
				if (seccionGrilla.equals("DetalleMovimientosMonto") || seccionGrilla.equals("DetalleMovimientosSaldoContable") ){
				
					booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
						if (j==2){
							j=+2;
						}
				}else if (seccionGrilla.equals("SaldoDisponibleCuenta")){
					booleanLink=false;
				}else{
					booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
					j=+1;
				}
							
				if(booleanLink){
					objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
				}else{
					caso=false;
					
				}
			}
			
			return nuevaCadena;		
		}
//-----------------------------------Notificación de Vencimiento-----------------------------------
	public boolean seleccionarMonedaNotificacionVencimiento(String strVarEntrada) {		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/select",strVarEntrada);
	}
	 
	public boolean ingresarNumeroDocumentoNotificacionVencimiento(String strValor) throws InterruptedException {	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/input", strValor);
	}
	
	public boolean ingresarFechaDesdeOperacionNotificacionVencimiento(String strValor) throws InterruptedException {	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[1]/input", strValor);
	}
	
	public boolean ingresarFechaHastaOperacionNotificacionVencimiento(String strValor) throws InterruptedException {	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[2]/input", strValor);
	}
}
