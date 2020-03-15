package proxim.be;

import java.io.IOException;
import org.openqa.selenium.By;

import proxim.bl.CapturarPantalla;
import proxim.dao.*;


public class LoginBE2 {
	boolean bandera;
	ConexionDriver objConexionDriver= new ConexionDriver();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static CapturarPantalla objEvidencia = new CapturarPantalla();
	
	public boolean ingresoTarjeta(String Lstr_Tarjeta) throws InterruptedException, IOException	{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div/form/div/p[1]/input",Lstr_Tarjeta);
	}
	
	public boolean seleccionarTarjetaFrecuente() throws InterruptedException, IOException{																
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/form/div/p[1]/span[2]/input");
	}
	
	public boolean seleccionarClave() throws InterruptedException, IOException{																
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/form/div/p[2]/input");	  
	}
	
	public boolean verificarTeclado() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div");
	}
	
	 public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException{	
		   String  strValorBoton = "";
		   String  strClave = Lstr_Clave;
		   String  strLetraValor = "";

		   for (int i = 1;i<=strClave.length();i++) {
			   strLetraValor = strClave.split("")[i - 1];
	        
			   for (int y = 1; y <= 4; y++){
				   if(y == 4){
					   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div/div[1]/div/div["+y+"]/button[1]")).getText();
				        
					   if (strValorBoton.equals(strLetraValor)){
						   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div/div[1]/div/div["+y+"]/button[1]")).click();
						   break;
					   }
				   }else {
					   for (int x = 1; x <= 3; x++) {
						   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div/div[1]/div/div["+y+"]/button["+x+"]")).getText();
			        
						   if (strValorBoton.equals(strLetraValor)) {
							   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div/div[1]/div/div["+y+"]/button["+x+"]")).click();
							   break;
						   }
					   }
				   }
			   }
	       }
		   return true;
	   }
	
	 public boolean ingresoCambiarCapcha() throws InterruptedException, IOException{	
				return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/form/div/div/form/div/span[1]/a");
		}
	 
	 public boolean ingresarCapcha(String Lstr_txtCapcha) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div/form/div/div/form/div/input",Lstr_txtCapcha);
	 }
 
	   public boolean ingresoBotonIngresarPopup() throws InterruptedException, IOException {		
		   return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/div/div[2]/center/button");		
	   }
	   
	   public boolean ingresoCerrarPopup() throws InterruptedException, IOException{		
		   return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/table/tbody/tr[1]/td[2]/div/a");		
	   }
	      
	   public boolean ingresoBotonIngresar() throws InterruptedException, IOException{		
		   return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/form/div/center/button");		
	   }
	 
	   public boolean verificarLogoInterbank() throws InterruptedException, IOException{		
		   return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div/center/img");
	   }
	   
	   public boolean verificarSelloSeguridad() throws InterruptedException, IOException{		
		   return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//div/div/form/center/div/img");
	   }
	
	   public boolean seleccionarAceptarSello() throws InterruptedException, IOException{																
		   return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/div/form/center/input");	  
	   }
	
	public String obtenerMensajeTie(String strColumna) throws InterruptedException, IOException{	
			String strMensaje ="";
			switch(strColumna){
				case "TXT_NUM_TARJETA":
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/form/div/p[1]/span[1]");
					break;
				case "TXT_CLAVE":
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/form/div/p[2]/span");
					break;
				case "TXT_CAPCHA":
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/form/div/div/form/div/span[2]");
					break;
			}
			return strMensaje;
		}
		
		public boolean verificarPopPrincipal() throws InterruptedException, IOException{		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div");
		}
		
		public boolean cerrarPU() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
		}
		
		public boolean tooltipAceptar() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.id, "gwt-debug-aceptar");
		}
		
		//OTRAS VALIDACIONES DE LOGIN
		
		public String obtieneTexto(String strIdentElement) throws InterruptedException, IOException{
			String strTexto = "";
			switch(strIdentElement){
				case "TituloInicioSesion":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/h4");
					break;
				case "LabelTIE":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/form/div/p[1]");
					break;
				case "LabelClaveWeb":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/form/div/p[2]");
					break;
				case "LabelPasos":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/div");
					break;
				//-----
				case "LabelTituloTecladoVirtual":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div/h3");
					break;				
				case "LabelMensajeTecladoVirtual":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div/div[1]/span");
					break;
				case "LabelTituloClaveVirtual":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div/div[2]/span");
					break;
					//---
				case "LabelSaludoSello":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div/form/span");
					break;
				case "LabelMensajeSello":
					//strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div/form/br[1]");
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div/form");
					int ind = -1;
					ind = strTexto.indexOf(",");
					if(ind !=-1){
						strTexto = strTexto.substring(ind+1,31+ind+1);
					}
					break;
				case "LabelComunicadoSello":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div/form/center/p");
					break;
				case "LabelPasos2":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div/form/div");
					break;
				//-------------------
				case "LabelTituloCapcha":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/form/div/div");
					break;
				case "LabelMensajeCapcha":
					strTexto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/form/div/div/form/div/span[2]");
					break;
			}
			return strTexto;
		}
		
		public boolean existeElemento(String strElemento) throws InterruptedException, IOException{	
			boolean bExiste = false;
			switch(strElemento){
				case "LogoInterbank":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//center/img");
					break;
				case "BarraProgreso":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/ul/li[1]");
					break;
				case "InputTIE":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/form/div/p[1]/input");
					break;
				case "CheckRecordar":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/form/div/p[1]/span[2]/input");
					break;
				case "ClaveWeb":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/form/div/p[2]/input");
					break;
				case "BotonIngresar":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div/div/form/div/center/button");
					break;	
				case "TecladoVirtual":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div");
					break;	
				case "BotonIngresarVirtual":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div/div[2]/center/button");
					break;	
				case "BotonCerrarVirtual":
					bExiste = objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//div/table/tbody/tr[1]/td[2]/div/a");
					break;	
				//--------------------
				case "BarraProgreso2":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div/div/ul/li[2]");
					break;
				case "SelloSeguridad":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div/div/div/form/center/div/img");
					break;
				case "ConfirmarSelloSeguridad":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div/div/div/form/center/input");
					break;
				case "LogoInterbankPrincipal":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[1]/div[2]/div[1]/a/img");
					break;	
				// -----CAPCHA---------
				case "imagenCapcha":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//div/form/div/div/form/div/img");
					break;
				case "linkCapcha":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//div/form/div/div/form/div/span[1]/a");
					break;	
				case "inputCapcha":
					bExiste =  objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//div/form/div/div/form/div/input");
					break;	
			}
			return bExiste;
		}
		
		public String existeNumerosTeclado() throws InterruptedException, IOException{	
			   String  strValorBoton = "";
			   String  strClave = "123456789";
			   String  strLetraValor = "";
			   boolean bEncontro = false;
			   //String strSiEncontro = "";
			   String strNoEncontro = "";

			   for (int i = 1;i<=strClave.length();i++){
				   bEncontro = false;
				   strLetraValor = strClave.split("")[i - 1];
		        
				   for (int y = 1; y <= 4; y++){
					   if(y == 4){
						   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div/div[1]/div/div["+y+"]/button[1]")).getText();
					        
						   if (strValorBoton.equals(strLetraValor)) {
							   bEncontro = true;
							   break;
						   }
					   }else {
						   for (int x = 1; x <= 3; x++) {
							   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div/div[1]/div/div["+y+"]/button["+x+"]")).getText();
				        
							   if (strValorBoton.equals(strLetraValor)){
								   bEncontro = true;
								   break;
							   }
						   }
					   }
				   }
				   if(!bEncontro){
					   strNoEncontro = strNoEncontro + strLetraValor;
				   }
		       }
			   if (strNoEncontro.equals(""))			   {
				   return "SI";
			   } else{
				   return strNoEncontro;
			   }
		 }
		
	   		
}
