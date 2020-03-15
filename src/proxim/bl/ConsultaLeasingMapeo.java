package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class ConsultaLeasingMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean bandera=false;

	public boolean seleccionarMenu(String LstrProducto) throws InterruptedException, IOException{		
		boolean var=false;
		for(int i=2;i<=7;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/ul/li["+i+"]/a//span")).getText();
			if(LstrProducto.toLowerCase().equals(valor.toLowerCase()) ){
				if(valor.toLowerCase().equals("consultas")){
					var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li["+i+"]/a//span");
				}else{
					var= objObjetosGenerales.moveToElement("//html/body/div[2]/div[2]/div/ul/li["+i+"]/a//span");
				}
				Thread.sleep(2500);
				break;
			}	
		}	
		return var;	
	}
	
	public boolean seleccionarEmpresa(String LstrEmpresa) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[3]/table/tbody/tr/td[2]/select",LstrEmpresa);
	}
	
	public boolean seleccionarMoneda(String LstrMoneda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[4]/table/tbody/tr/td[2]/select",LstrMoneda);
	}
	
	public boolean seleccionarSituacionCredito(String LstrSituacionCred) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[5]/table/tbody/tr/td[2]/select",LstrSituacionCred);
	}
	
	public boolean ingresoBotonConsultar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/a/img");
	}
	
	public boolean clicMenu() throws InterruptedException, IOException{
		return objObjetosGenerales.moveToElement("//html/body/div[2]/div[1]/div[2]/div[1]/div[2]/a");
	}
	
	public boolean seleccionarRegistroConsulta(String numeroSolicitud) throws InterruptedException, IOException{		
		boolean accionRealizada = false;

		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size();
		numero = numero -2;
		for (int j = numero;j>=1;j--)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (objFuncionesGenerales.compararTextosIguales(colss.get(0).getText(),numeroSolicitud)){
				colss.get(0).click();
				accionRealizada=true;
				break;
			}
		}
		return accionRealizada;				
	}
	
	public boolean LinkEnviarCorreo(String strSeccion) throws InterruptedException, IOException{		
		boolean bResp = false;
		CapturarPantalla.pageDown("1000");
		switch (strSeccion)
		{
			case "Seccion1":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[7]/div/div[1]/a");
				break;
			case "Seccion2":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[1]/a");
				break;
		}
		return bResp;
	}
	
	public boolean ingresarTituloCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
	public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
	public boolean ingresoBotonEnviarCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	}
	public boolean ingresoBotonEnviarCorreo2() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	} 
	
	public boolean ingresoExportarExcel(String strSeccion) throws InterruptedException, IOException{		
		boolean bResp = false;
		CapturarPantalla.pageDown("1000");
		switch (strSeccion)
		{
			case "Seccion1":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[7]/div/div[4]/a");
				break;
			case "Seccion2":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[4]/a");
				break;
		}
		return bResp;
	}
	
	public boolean ingresoExportarPdf(String strSeccion) throws InterruptedException, IOException{		
		boolean bResp = false;
		CapturarPantalla.pageDown("1000");
		switch (strSeccion)
		{
			case "Seccion1":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[7]/div/div[5]/a");
				break;
			case "Seccion2":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]/a");
				break;
		}
		return bResp;
	}
	
	public boolean ingresoImprimir(String strSeccion) throws InterruptedException, IOException{		
		boolean bResp = false;
		CapturarPantalla.pageDown("1000");
		switch (strSeccion){
			case "Seccion1":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[7]/div/div[6]/a");
				break;
			case "Seccion2":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[6]/a");
				break;
		}
		return bResp;
	}

}
