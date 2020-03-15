package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class TransferenciaAutorizarMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	
	public boolean verificarCamposObligatorios(){	
		boolean bandera = false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean seleccionarEmpresaCuentaOrigen(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "empresaCombo",LstrProducto);
	}
	
	public boolean seleccionarTipoTransfereniaCombo(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoTransferenciaCombo",LstrProducto);
	}
	
	public boolean seleccionarCuentaOrigen(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "cuentaOrigenCombo",LstrProducto);
	}
	
	public boolean seleccionarCuentaDestino(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "cuentaDestinoCombo",LstrProducto);
	}
	
	public boolean ingresarFechaSolicitudDesde(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "rangoFechaSolicitud_1", Descripcion);
	}
	
	public boolean ingresarFechaSolicitudHasta(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "rangoFechaSolicitud_2", Descripcion);
	}
	
	public boolean ingresoBotonContinuar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.name, "continuar");		
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonBusqueda > img");		
	}
	
	public int buscarLoteFirmar(String NumeroSolicitud) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		int intResultado=0;
		for (int j = numero;j>=1;j--){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (colss.get(1).getText().equals(NumeroSolicitud)){//ESTADO
				intResultado=j;
				break;
			}
		}
		return intResultado;		
	}
	
	public boolean seleccionarCheckFirmar(int NumeroSolicitud) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+NumeroSolicitud+"]/td")));
		colss.get(0).click();
		Thread.sleep(1800);
		return true;	
	}
	
	public boolean seleccionarLinkNumeroSolicitudDetalle(int NumeroSolicitud) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+NumeroSolicitud+"]/td")));
		colss.get(1).click();
		return true;	
	}
	
	 public boolean ingresoLinkEnviarEmailDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[1]/a");		
	 }

	 public boolean ingresoLinkExportarExcelDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[6]/a");		
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
		
	public boolean ingresoLinkRegresar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/a");		
	}
	public boolean verificarConfirmacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[1]/span");
	}
	
	public boolean ingresoBotonAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/a[1]/div/img");		
	}
	
	public boolean ingresoBotonBloquear() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/a[2]/div/img");		
	}
	
   public boolean compararMensajeResultador(String Lstr_TxtMensajeError) throws InterruptedException, IOException{
	   String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[5]/div[3]/div[1]/span[1]")).getText();    
	   if(Lstr_TxtMensajeError.equals(str_Mensaje))
	   {
			return true;
	   }else{
		   return false;
	   }	
   }
   
   public String  obtenerMensajeResultado() throws InterruptedException, IOException{
	   String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/span[1]")).getText();    
	   return str_Mensaje;
   }
		

}
