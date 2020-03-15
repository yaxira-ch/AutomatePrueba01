package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobNotifiVencimientoMapeo {
	
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();

	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strEmpresa);
	}

	public boolean seleccionarBusqueda(String strBusqueda) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strBusqueda);
	}

	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/select",strMoneda);
	}

	public boolean ingresarFechaDesde(String strFechaDesde) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[1]/input" , strFechaDesde);
	}

	public boolean ingresarFechaHasta(String strFechaHasta) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[2]/input" , strFechaHasta);
	}

	public boolean ingresarNumeroDocumento(String strNumeroDocumento) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/input" , strNumeroDocumento);
	}

	public boolean buscar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a");
	}

	public boolean ingresarEnvioCorreo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[1]/a");
	}

	public boolean ingresarTituloCorreo(String strCorreo) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input" , strCorreo);
	}

	public boolean ingresarMensajeCorreo(String strMensaje) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea" , strMensaje);
	}

	public boolean enviarCorreo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");
	}

	public void aceptarEnvio() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}

	public boolean exportarExcel() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[4]/a");
	}

	public boolean exportarPdf() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[5]/a");
	}

	public boolean imprimir() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[6]/a");
	}

	public boolean seleccionarDocumento(String strDoc, String strEmail) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String strNumDoc=colss.get(4).getText();
			if(strNumDoc.equals(strDoc)){
				objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[10]/div/div/input" , strEmail);
				colss.get(0).click();
				return true;
			}
		}
		return false;
	}

	public boolean enviar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/a");
	}

	public boolean regresar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[4]/a");
	}
}
