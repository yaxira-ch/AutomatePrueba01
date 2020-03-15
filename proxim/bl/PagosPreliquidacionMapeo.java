package proxim.bl;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class PagosPreliquidacionMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	boolean bandera;

	
	//----------------------------------------------PAGO PRELIQUIDACIÓN------------------------------
	
	public boolean verificarCamposObligatorios() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strEmpresa);
	}
	
	public boolean seleccionarBusqueda(String strBusqueda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strBusqueda);
	}
	
	public boolean seleccionarSituacion(String strSituacion) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/select",strSituacion);
	}
	
	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/select",strMoneda);
	}
	
	public boolean ingresarNroDocumento(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/input",strNroDocumento);
	}
	
	public boolean ingresarNuevaFechaVencimiento(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/div/div/input",strNroDocumento);
	}
	
	public boolean ingresarNuevoImporteDocumento(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/div/input",strNroDocumento);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a[1]/img");
	}
	
	public boolean verificarTabla(){
		boolean bandera=false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public int buscarSolicitudProcesada( String strTXT_NRO_DOCUMENTO) throws InterruptedException, IOException{		
		int intNumeroFila=0;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if (colss.get(1).getText().equals(strTXT_NRO_DOCUMENTO)){
				intNumeroFila=j;
				break;
			}
		}
		return intNumeroFila;
	}
	
	public boolean seleccionarSolicitudProcesada(int intNumeroFila) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		boolean bandera=false;
		
		if(num.size()-2==1){
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table/tbody[1]/tr/td[2]/div/div/a");		
		}else{
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table/tbody[1]/tr["+intNumeroFila+"]/td[2]/div/div/a");
		}
		return bandera;
	}
	
	public boolean verificarConsultaPreliquidacion(){	
		boolean bandera = false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/h1");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean ingresoLinkRegresar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[12]/a");
	}
	
	public boolean seleccionarCheckNroDocumento(int intNumeroFila) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		boolean bandera=false;
		
		if(num.size()-2==1){
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/input");		
		}else{
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table/tbody[1]/tr["+intNumeroFila+"]/td[1]/div/div/input");
																		
		}
		return bandera;
	}
	
	public boolean ingresoBotonPreliquidar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a[2]/img");
	}
	
	public boolean verificarCamposSeleccionarTipoLiquidacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/select");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean seleccionarTipoLiquidacion(String strMoneda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/select",strMoneda);
	}
	
	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[9]/a[1]/img");
	}
	
	public boolean verificarResultadoFinal() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[1]/span[1]");
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[9]/a[2]/img");
	}
	
	public boolean ingresoLmkRegresarFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/a");
	}
	
	public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[5]/div/div[1]/a");		
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
	
	public boolean verificarMensajeCorreo() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
	}
	
	public boolean ingresoBotonAceptarCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
		
	 public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[5]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[5]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[5]/div/div[6]/a");		
	 }	
		
}
