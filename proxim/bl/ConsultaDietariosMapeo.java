package proxim.bl;

import java.io.IOException;

import org.openqa.selenium.By;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class ConsultaDietariosMapeo {
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
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li[2]/div/div[1]/ul/li[1]/div/ul/li[3]/a/span");
	}
	
	public boolean seleccionarEmpresa(String LstrEmpresa) throws InterruptedException, IOException{	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",LstrEmpresa);
	}
	
	public boolean seleccionarFechaDesde(String LstrFechaDesde) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[1]/input", LstrFechaDesde);
	}
	
	public boolean seleccionarFechaHasta(String LstrFechaHasta) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[2]/input", LstrFechaHasta);
	}
	
	public boolean seleccionarCuentaCargo(String LstrCuentaCargo) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/select",LstrCuentaCargo);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");
	}
	
	public boolean clicMenu() throws InterruptedException, IOException{
		return objObjetosGenerales.moveToElement("//html/body/div[2]/div[1]/div[2]/div[1]/div[2]/a");
	}
	
	public boolean ingresoExportarCsv() throws InterruptedException, IOException{		
		CapturarPantalla.pageDown("1000");
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[3]/a");
	}
	
	public boolean ingresoExportarExcel() throws InterruptedException, IOException{		
		CapturarPantalla.pageDown("1000");
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[4]/a");
	}
	
	public boolean ingresoExportarPdf() throws InterruptedException, IOException{		
		CapturarPantalla.pageDown("1000");
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div[5]/a");
	}
	
	public boolean compararMensajeError(String Lstr_TxtMensajeError,String Lstr_TxtColumnaError ) throws InterruptedException, IOException{	
		String str_Mensaje="";
		boolean blnResultado=false;
		switch (Lstr_TxtColumnaError){
			case "CMB_EMPRESA" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='pasoEmpresa']/span[2]")).getText();
				break;
			case "TXT_FECHA_DESDE" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='pasoFechasProceso']/span[2]")).getText();
				break;
			case "TXT_FECHA_HASTA" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='pasoFechasProceso']/span[2]")).getText();
				break;
			case "TXT_CUENTA_CARGO" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='pasoCuentaCargo']/span[2]")).getText();
				break;
			default:
				break;
		}
		
		if(objFuncionesGenerales.compararTextosIguales(Lstr_TxtMensajeError, str_Mensaje)){
			blnResultado= true;
		}
		return blnResultado;
	}

}
