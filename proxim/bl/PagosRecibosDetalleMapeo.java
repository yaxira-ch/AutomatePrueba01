package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.PagosRecibosDetalleBE;
import proxim.dao.Mdl_Variables;

public class PagosRecibosDetalleMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();

	public boolean ingresoBotonBuscarEmpresa(int indice) throws InterruptedException, IOException{	
		
		if(indice==1){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[3]/div/div/span[2]/div/a");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li["+indice+"]/table/tbody[1]/tr["+indice+"]/td[3]/div/div/span[2]/div/a");
		}
	}
	
	public boolean ingresarEmpresaBusca(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/input", Descripcion);
	}
	
	public boolean seleccionarEmpresaBusca(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[2]/select",LstrProducto);
	}
	
	public boolean ingresoBotonAceptar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/a");		//--
	}
	
	public boolean seleccionarServicio(String LstrProducto,int indice) throws InterruptedException, IOException{
		
		if(indice==1){
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[4]/div/select",LstrProducto);
		}else{
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li["+indice+"]/table/tbody[1]/tr["+indice+"]/td[4]/div/select",LstrProducto);
		}
		//	table.findElement(By.xpath(".//tr["+numero+"]/td[4]/div/div/span[2]/div/a")).click();
		//return objObjetosGenerales.(ObjetosGenerales.cssSelector, "select.comboServicios",LstrProducto);
	}
	
	public boolean ingresarCodigoDeudor(String Descripcion,int indice) throws InterruptedException, IOException{	
		
		if(indice==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[5]/div/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li["+indice+"]/table/tbody[1]/tr["+indice+"]/td[5]/div/div/input", Descripcion);
		}
		//return objObjetosGenerales.setText(ObjetosGenerales.name, "nombreSolicitudText", Descripcion);
	}
	
	public boolean ingresarMontoPagar(String Descripcion,int indice, int totalregistros) throws InterruptedException, IOException{	
	
		if(totalregistros==1){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/tbody[1]/tr/td[8]/div/div/span/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/tbody[1]/tr["+indice+"]/td[8]/div/div/span/input", Descripcion);
		}
		//return objObjetosGenerales.setText(ObjetosGenerales.name, "nombreSolicitudText", Descripcion);
	}
	
	public boolean seleccionarModoPago(String Descripcion,int indice, int totalregistros) throws InterruptedException, IOException{
		if(totalregistros==1){
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/tbody[1]/tr/td[7]/div/select", Descripcion);
		}else{
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/tbody[1]/tr["+indice+"]/td[7]/div/select", Descripcion);
		}
		//	table.findElement(By.xpath(".//tr["+numero+"]/td[4]/div/div/span[2]/div/a")).click();
		//return objObjetosGenerales.(ObjetosGenerales.cssSelector, "select.comboServicios",LstrProducto);
	}

	public boolean checkEnviar(int indice, int totalregistros) throws InterruptedException, IOException{	
	
		if(totalregistros==1){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/tbody[1]/tr/td[1]/div/input");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/tbody[1]/tr["+indice+"]/td[1]/div/input");
		}
	}
	
	
	

	public boolean ingresoBotonGuardar(int indice) throws InterruptedException, IOException{		
		
		if(indice==1){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[2]/div/div/span[1]/div/a");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li[2]/table/tbody[1]/tr["+indice+"]/td[2]/div/div/span[1]/div/a");
		}
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonAceptarPagoRecibo");		
	}
	
	public boolean ingresoBotonEliminar(int indice) throws InterruptedException, IOException{		
		int valIndice=indice+1;
		if(indice==0){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[2]/div/div/span[2]/div/a");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li[2]/table/tbody[1]/tr["+valIndice+"]/td[2]/div/div/span[2]/div/a");
		}
	}
	
	public boolean ingresoBotonEditar(int indice) throws InterruptedException, IOException{		
		int valIndice=indice+1;
		if(indice==0){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[2]/div/div/span[1]/div/a");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li[2]/table/tbody[1]/tr["+valIndice+"]/td[2]/div/div/span[1]/div/a");
		}
	}
	
	public boolean compararMensajeError(String LstrProducto) throws InterruptedException, IOException{		
		 String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[2]/div[4]/div[1]/div[1]/span")).getText(); //faltaaaa
		 if(LstrProducto.equals(str_Mensaje))  {
			 return true;
		 }else{
			 return false;
		 }
	}
	
	public boolean ingresoTodos(int opcion,int indice) throws InterruptedException, IOException{		
		boolean bandera=true;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
			
		if(opcion==1){
			
			if(indice==1){
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/tbody[1]/tr/td[1]/div/div/input");
			}else{
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li["+indice+"]/table/tbody[1]/tr["+indice+"]/td[1]/div/div/input");
			}	
		}else{
			for (int j = 1;j<=numero;j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if ((colss.get(3).getText().equals(PagosRecibosDetalleBE.GstrTXT_EMPRESA_BUSCAR))&&
						(colss.get(4).getText().equals(PagosRecibosDetalleBE.GstrCMB_SERVICIO))&&
						(colss.get(5).getText().equals(PagosRecibosDetalleBE.GstrTXT_CODIGO_DEUDOR))){
					colss.get(0).click();
					bandera = true;
					break;
				}
			}
		}
		return bandera;
	}
	
	public boolean ingresoBotonNuevoRegistro() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[1]/div[2]/a");		
	}
	
}
