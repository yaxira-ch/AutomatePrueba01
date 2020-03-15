package proxim.be;

import java.io.IOException;

import org.openqa.selenium.By;

import proxim.dao.Mdl_Variables;


public class HeaderBE {
	boolean blnResultadoOperacion;
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	   
   public boolean cerrarSesionMenu() throws InterruptedException, IOException
   {		     
	   return objObjetosGenerales.moveToElement("//html/body/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li/a/div");
   }
   
   public boolean cerrarSesionSubMenu() throws InterruptedException, IOException
   {		     
	   return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li/ul/li[3]/a");
   }
   
   public boolean verificarCerrar() throws InterruptedException, IOException{
	   return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li/ul/li[3]/a");
	}
   
   
   //----------Menu
   
	public boolean seleccionarMenu(String LstrProducto) throws InterruptedException, IOException{		
		boolean blnResultado=false;
		for(int i=2;i<=8;i++){
			String strMenu= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/ul/li["+i+"]/a//span")).getText();
			if(LstrProducto.toLowerCase().equals(strMenu.toLowerCase()) ){
				if(strMenu.toLowerCase().equals("transferencias")){
					blnResultado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li["+i+"]/a//span");
					Thread.sleep(1000);
				}else{
					blnResultado= objObjetosGenerales.moveToElement("//html/body/div[2]/div[2]/div/ul/li["+i+"]/a//span");
				}
				Thread.sleep(2500);
				break;
			}	
		}	
		return blnResultado;	
	}
	
    public boolean verificarTutoriales() throws InterruptedException, IOException{
    	return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[1]/div[2]/div[1]/div[2]/a");
	}
    
	public boolean seleccionarLinkOferta() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.linkText, "Aprovéchala.");
	}
	
	public boolean seleccionarSubMenu(String LstrProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.linkText, LstrProducto);
	}
	
	public boolean clicMenu() throws InterruptedException, IOException{			
		return objObjetosGenerales.moveToElement("//html/body/div[2]/div[1]/div[2]/div[1]/div[2]/a");
	}
}
