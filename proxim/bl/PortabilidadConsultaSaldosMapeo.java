package proxim.bl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class PortabilidadConsultaSaldosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	
	public boolean ingresoConsultaSaldos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/header/div/ul/li[2]/a");	
	}
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, "//*[@id='empresaCombo']",LstrProducto);
	}
	
	public boolean esEmpresa() throws InterruptedException, IOException{	

		if(objObjetosGenerales.existElement(ObjetosGenerales.xpath, "/html/body/div[1]/div[1]/div/div/h3"))
			return true;
		else
			return false;
	}
	
	public boolean ingresoBotonEnviarEmail() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/footer/div/div/a");		
	}
	
	public boolean ingresarCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//*[@id='destinatario']", Descripcion);
	}
	
	public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//*[@id='mensaje']", Descripcion);
	}
	
	public boolean ingresoBotonEnviarCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='enviar']");		
	}
	
	public boolean ingresoBotonCerrarCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div[2]/div/a");		
	}

	public boolean buscarCuenta(boolean ge,String gstrLBL_NUMERO_CUENTA) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebElement lista;
		if(ge)
			lista = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[1]/div[1]/div/div[2]/div/div/ul"));
		else
			lista = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[1]/div[1]/div/div/div[2]/ul"));
		
		List<WebElement> num=lista.findElements(By.xpath(".//li"));
		
		for (int j = 0;j<num.size();j++)
		{
			String cuentaPantalla=num.get(j).getText().split("\n")[1];
			if(cuentaPantalla.equals(gstrLBL_NUMERO_CUENTA)){
				num.get(j).click();
				return true;
			}
			if(j%3==0&&j!=0){
				CapturarPantalla.pageDown("200");
			}
		}
		return false;
	}
	
	public boolean buscarMovimiento(String gstrLBL_GLOSA, String gstrLBL_ORDENANTE, String gstrLBL_FECHA, String GstrLBL_TIPO,
			String gstrLBL_MONTO, String gstrLBL_MONEDA)  throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		WebElement lista = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[1]/div[1]/div/div[2]/div/div/ul"));
		List<WebElement> num=lista.findElements(By.xpath(".//li"));
		
		for (int j = 0;j<num.size();j++)
		{
			/*if(num.get(j).getText().split("\n")[0].trim().equals(gstrLBL_GLOSA)){
				if(num.get(j).getText().split("\n")[1].trim().equals(gstrLBL_ORDENANTE)){
					if(num.get(j).getText().split("\n")[2].trim().equals(gstrLBL_FECHA)){
						if(num.get(j).getText().split("\n")[3].trim().equals(formatearMonto(GstrLBL_TIPO,gstrLBL_MONTO,gstrLBL_MONEDA))){
							return true;
						}
					}				
				}
			}*/
			if(num.get(j).getText().split("\n")[0].trim().equals(gstrLBL_GLOSA)){
				if(num.get(j).getText().split("\n")[1].trim().equals(gstrLBL_FECHA)){
					if(num.get(j).getText().split("\n")[2].trim().equals(formatearMonto(GstrLBL_TIPO,gstrLBL_MONTO,gstrLBL_MONEDA))){
						return true;
					}
				}				
			}
		}
		return false;
	}
	
	private String formatearMonto(String gstrLBL_TIPO, String gstrLBL_MONTO, String gstrLBL_MONEDA) {
		// TODO Auto-generated method stub
		String montoFormateado="";
		
		if(gstrLBL_MONEDA.equals("Soles"))
			montoFormateado="S/ ";
		else
			montoFormateado="$ ";
		
		if(gstrLBL_TIPO.equals("Débito"))
			montoFormateado=montoFormateado+"-";
		else
			montoFormateado=montoFormateado+"+";
		
		double prueba2=new Double(gstrLBL_MONTO);
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		simbolo.setGroupingSeparator(',');
		simbolo.setDecimalSeparator('.');
		DecimalFormat formatea=new DecimalFormat("###,###.##",simbolo);
		gstrLBL_MONTO=formatea.format(prueba2);
		if(gstrLBL_MONTO.indexOf(".")!=-1){
			int decimales=(gstrLBL_MONTO.substring(gstrLBL_MONTO.indexOf(".")+1,gstrLBL_MONTO.length())).length();
			if(decimales==1)
				gstrLBL_MONTO=gstrLBL_MONTO+"0";
		}else
			gstrLBL_MONTO=gstrLBL_MONTO+".00";
		
		montoFormateado=montoFormateado+gstrLBL_MONTO;
		
		return montoFormateado;
	}


	
	
}
