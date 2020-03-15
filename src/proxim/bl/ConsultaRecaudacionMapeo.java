package proxim.bl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class ConsultaRecaudacionMapeo {
	String strFecha="dd/MM/yyyy";
	String strTr=".//tr";
	String strTableGeneral="//table[@class='cellTableWidget']";
	
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	

	public boolean seleccionarServicioRecaudacion(String strServicio) {	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",strServicio);
	}

	public boolean seleccionarTipoConsulta(String strTipoConsulta)  {	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[2]/select",strTipoConsulta);
	}

	public boolean seleccionarFiltradoPor(String strFiltradoPor)   {	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[2]/select",strFiltradoPor);
	}
	
	public boolean ingresarCodigoDeudor(String strCodigo) throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[3]/input", strCodigo);
	}
	
	public boolean seleccionarDeudor(String strFiltradoPor)   {	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[5]/tbody/tr/td[2]/select",strFiltradoPor);
	}
	
	public boolean ingresarCodNomDeudor(String strCodigo) throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[5]/tbody/tr/td[3]/input", strCodigo);
	}
	
	public boolean ingresarFechaPagoDesde(String strCodigo) throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[6]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input", strCodigo);
	}
	
	public boolean ingresarFechaPagoHasta(String strCodigo) throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[6]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input", strCodigo);
	}
	
	public boolean ingresarBotonBuscar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a");		
	}
	
	public boolean verificarTablaResultado(){  
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[5]/div/div/table");
	}
	
	public boolean verificarGrilla(String strCodigoDeudor) {
		 boolean blnResultadoEsperado=false;
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTableGeneral));
		 List<WebElement> num=tabla.findElements(By.xpath(strTr));
		 String strHoraInicio = new SimpleDateFormat(strFecha).format(Calendar.getInstance().getTime());	
		 for (int j = 1;j<=num.size()-2;j++){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			 
			 if(strCodigoDeudor.equals(Mdl_Variables.Gstr_Click)) {
				 colss.get(0).click();
				 blnResultadoEsperado=true;
				 break;
			 }else{
				 if (colss.get(2).getText().equals(strCodigoDeudor)&&//--Código Deudor
						 colss.get(6).getText().equals(strHoraInicio)){//--Fecha de Pago
					 colss.get(0).click();
					 blnResultadoEsperado=true;
					 break;
				 }
			 }
		 }
		 return blnResultadoEsperado;
	}
	
	
	
	public boolean verificarDetalle(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "yyy");
	}
	
	public boolean ingresoLinkPaginacion(int i) {	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[2]/a["+i+"]");		
	}
	
	public boolean ingresoLinkEnviarEmailConsultaHistorica() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[1]/a");		
	}
 
	public int totalPaginacion() {		
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[2]"));
		 List<WebElement> num=tabla.findElements(By.xpath(".//a"));
		 return num.size();
	}
	
	public boolean ingresarCorreoConsultaHistorica(String strDescripcion) throws InterruptedException {		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresoBotonAceptarCorreoConsultaHistorica() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");	
	}
	
	 public boolean ingresoLinkExportarTextoConsultaHistorica() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[2]/a");		
	 }
	
	 public boolean ingresoLinkExportarExcelConsultaHistorica() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFConsultaHistorica() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]/a");		
	 }
	 
	 public boolean buscarDeudor(String strCodigoDeudor) {		
		 boolean blnResultadoEsperado=false;
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTableGeneral));
		 List<WebElement> num=tabla.findElements(By.xpath(strTr));
		 String strHoraInicio = new SimpleDateFormat(strFecha).format(Calendar.getInstance().getTime());	
		 for (int j = 1;j<=num.size()-2;j++){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			 
			 if(strCodigoDeudor.equals(Mdl_Variables.Gstr_Click)) {
				 blnResultadoEsperado = true;
				 break;
			 }else{
				 if (colss.get(2).getText().equals(strCodigoDeudor)&&//--Código Deudor
						 colss.get(6).getText().equals(strHoraInicio)){//--Fecha de Pago
					 blnResultadoEsperado = true;
					 break;
				 }
			 }
		 }
		 return blnResultadoEsperado;
	 }
	 
	 
	 public boolean ingresoLinkImprimirConsultaHistorica() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[6]/a");		
	 }
	 
	 	public boolean ingresoLinkEnviarEmailConsultaHistoricaDetalle() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[4]/div/div[1]/a");		
		}
	 
		 public boolean ingresoLinkExportarExcelConsultaHistoricaDetalle() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[4]/div/div[4]/a");		
		 }
		 
		 public boolean ingresoLinkExportarPDFConsultaHistoricaDetalle() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[4]/div/div[5]/a");		
		 }
		 
		 public boolean ingresoLinkImprimirConsultaHistoricaDetalle() {		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[4]/div/div[6]/a");		
		 }
	
		 public boolean ingresoLinkRegresar() {		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/a");		
		 }

		 public boolean verificarCamposObligatoriosCH(){
			 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		}
 
		 public boolean seleccionarTabConsultaRecaudacion(String strProducto) {		
			 boolean var=false;
			 for(int i=1;i<=2;i++){
				 String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a")).getText();
				 if(strProducto.toLowerCase().equals(valor.toLowerCase()) ){
					 var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a");
					 break;
				 }	
			 }	
			 return var;	
		 }

	//---------------------------------------------------------------------------------------------------------------------
	public boolean seleccionarEmpresaTotalDias(String strProducto)  {			
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/select",strProducto);
	}

	public boolean seleccionarServicioTotalDias(String strServicio)  {	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",strServicio);
	}
	
	public boolean ingresarBotonBuscarTotalDias() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean verificarTablaTotalDias(){  
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div[5]/div/div/table");
	}
	
	public boolean ingresoLinkEnviarEmailResumenTotalDias() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[1]/a");		
	}

	
	 public boolean ingresoLinkExportarExcelResumenTotalDias() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFResumenTotalDias() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[5]/a");		
	 }	
	 
	 public boolean ingresoLinkImprimirResumenTotalDias() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/div[6]/a");		
	 }	
	 
	 public boolean ingresoLinkRegresarResumenTotalDiasDetalle() {		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[3]/a");		
	 }
	 
	 public boolean ingresoLinkEnviarEmailResumenTotalDiasDetalle() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[4]/div/div[1]/a");		
		}
		
		public boolean verificarMensajeCorreoResumenTotalDiasDetalle(){  
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		}

		public boolean verificarResumenTotalDias(){  
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[1]/span[1]");
		}
		
		 public boolean ingresoLinkExportarExcelResumenTotalDiasDetalle() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[4]/div/div[4]/a");		
		 }
		 
		 public boolean ingresoLinkExportarPDFResumenTotalDiasDetalle() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[4]/div/div[5]/a");		
		 }
		 
		 public boolean ingresoLinkImprimirResumenTotalDiasDetalle() {		
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[4]/div/div[6]/a");		
		 }
	
		 public boolean buscarDeudorTotalDias(String strCodigoDeudor) {		
			 boolean bandera=false;
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[5]/div/div/table"));
			 List<WebElement> num=tabla.findElements(By.xpath(strTr));
			 int numero=num.size()-2;
			 String strHoraInicio = new SimpleDateFormat(strFecha).format(Calendar.getInstance().getTime());	
			 for (int j = 1;j<=numero;j++){
				 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				 if(strCodigoDeudor.equals(Mdl_Variables.Gstr_Click)) {
					 bandera = true;
					 break;
				 }else{
					 if (colss.get(2).getText().equals(strCodigoDeudor)&&//--Código Deudor
							colss.get(6).getText().equals(strHoraInicio)){//--Fecha de Pago
						 bandera = true;
						 break;
					 }
				 }
			 }
			 return bandera;
		 }
		 
		 public boolean verificarGrillaTotalesDia(String strNumeroCuenta){
			 boolean bandera=false;
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[5]/div/div/table"));
			 List<WebElement> num=tabla.findElements(By.xpath(strTr));
			 int numero=num.size()-2;
			 String strHoraInicio = new SimpleDateFormat(strFecha).format(Calendar.getInstance().getTime());	
			 for (int j = 1;j<=numero;j++){
				 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				 
				 if(strNumeroCuenta.equals(Mdl_Variables.Gstr_Click)) {
					 colss.get(0).click();
					 bandera = true;
					 break;
				 }else{
					 if (colss.get(2).getText().equals(strNumeroCuenta)&&//--Código Deudor
							colss.get(6).getText().equals(strHoraInicio)){//--Fecha de Pago
						colss.get(0).click();
						 bandera = true;
						 break;
					 }
				 }
			 }
			 return bandera;
		}
			
		 public boolean ingresoLinkRegresarTotalDiasDetalle() {		
			   return objObjetosGenerales.clickBoton(ObjetosGenerales.linkText, "Regresar");	
		}
		 
		 public boolean ingresoLinkEnviarEmailTotalDiasDetalle() {		
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/div/div[1]/a");	
			}
		 
			public boolean ingresarMensajeCorreoTotalDiasDetalle(String strDescripcion)throws InterruptedException {		
				return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", strDescripcion);
			}
				
			public boolean ingresoBotonEnviarTotalDiasDetalle() {		
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
			}
			
			 public boolean ingresoLinkExportarExcelTotalDiasDetalle() {		
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/div/div[4]/a");		
			 }
			 
			 public boolean ingresoLinkExportarPDFTotalDiasDetalle(){		
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/div/div[5]/a");		
			 }
			 
			 public boolean ingresoLinkImprimirTotalDiasDetalle() {		
				 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/div/div[6]/a");		
			 }
			 
		 public boolean ingresoLinkRegresarTotalDiasDetalle1() {		
			   return objObjetosGenerales.clickBoton(ObjetosGenerales.linkText, "Regresar");	
		}
		 
		 public boolean buscarDeudorResumenTotalDias(){		
			 boolean bandera=false;
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTableGeneral));
			 List<WebElement> num=tabla.findElements(By.xpath(strTr));
			 int numero=num.size()-2;
			 String strHoraInicio = new SimpleDateFormat(strFecha).format(Calendar.getInstance().getTime());	
			 for (int j = 1;j<=numero;j++){
				 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				 if (colss.get(0).getText().equals(strHoraInicio)){//--Fecha de Pago
					 bandera = true;
					 break;
				 }
			 }
			 return bandera;
		 }
		 
		 public boolean buscarDeudorGrillaResumenTotalDias() {
			 boolean bandera=false;
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTableGeneral));
			 List<WebElement> num=tabla.findElements(By.xpath(strTr));
			 int numero=num.size()-2;
			 String strHoraInicio = new SimpleDateFormat(strFecha).format(Calendar.getInstance().getTime());	
			 for (int j = 1;j<=numero;j++){
				 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
					
				 if (colss.get(0).getText().equals(strHoraInicio)){//--Fecha de Pago
					 colss.get(0).click();
					 bandera = true;
					 break;
				 }
			 }
			 return bandera;	
		 }
		 
			public boolean verificarDetalleResumenTotalDias(){  
				return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div[5]/div/div/table");
			}
}
