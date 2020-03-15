package proxim.be;


import java.util.List;
import java.util.Locale;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import proxim.dao.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ObjetosGenerales {
	public static String id = "id";
	public static String name = "name";
	public static String classname = "classname";
	public static String cssSelector ="cssSelector";
	public static String xpath ="xpath";
	public static String xpath2 ="xpath2";
	public static String xpath3 ="xpath3";
	public static String xpath4="xpath4";
	public static String linkText ="linkText";
	
	
	public boolean selectByText(String strTipo,String strName, String strID) {
		
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
		switch (Keyword.getValue(strTipo.toUpperCase())){
		case ID:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strName)));
			new Select(Mdl_Variables.Gwed_Driver.findElement(By.id(strName))).selectByVisibleText(strID); 
			break;
		case NAME:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strName)));
			new Select(Mdl_Variables.Gwed_Driver.findElement(By.name(strName))).selectByVisibleText(strID); 
			break;
		case CLASSNAME:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strName)));
			new Select(Mdl_Variables.Gwed_Driver.findElement(By.className(strName))).selectByVisibleText(strID); 
			break;
			
		case CSSSELECTOR:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strName)));
			new Select(Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName))).selectByVisibleText(strID); 
			break;
		
		case XPATH:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strName)));
			new Select(Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName))).selectByVisibleText(strID); 
			break;
		default:
			break;
		} 
		return true;
	}
	
	public List<WebElement> selectAllElementCombo(String strTipo,String strName){
		Select select = null ;
		List<WebElement> allOptions;
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
		switch (Keyword.getValue(strTipo.toUpperCase())){
		case ID:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strName)));
			select =new Select(Mdl_Variables.Gwed_Driver.findElement(By.id(strName))); 
			break;
		case NAME:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strName)));
			select =new Select(Mdl_Variables.Gwed_Driver.findElement(By.name(strName))); 
			break;
		case CLASSNAME:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strName)));
			select =new Select(Mdl_Variables.Gwed_Driver.findElement(By.className(strName))); 
			break;
			
		case CSSSELECTOR:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strName)));
			select =new Select(Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName))); 
			break;
		
		case XPATH:	  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strName)));
			select =new Select(Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName))); 
			break;
		default:
			break;
		} 
		allOptions = select.getOptions();
		return allOptions;
	}
	
	public boolean moveToElement(String strTipo) throws InterruptedException{
		WebElement weHomeLink = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipo));
		Actions myMouse = new Actions(Mdl_Variables.Gwed_Driver);
		myMouse.moveToElement(weHomeLink).build().perform();   //home link
		Thread.sleep(2000);
        return true;
	}
	
	public static String nuevoNumero(String strMonto,String strMoneda,String strCambio) {
		double resultado;
		String strNuevaMoneda=strMonto.replaceAll(",","");
		
		if(strMoneda.equals("Soles")){
			resultado= Double.valueOf( strNuevaMoneda)*Double.valueOf(strCambio);
		}else{
			resultado= Double.valueOf(strNuevaMoneda)/Double.valueOf(strCambio);
		}
		
		return formatearNumero(resultado);	
	}
	
	public String strNuevaMoneda(String strCadena){
		if(strCadena.contains("S/"))
			strCadena=strCadena.substring(3).replace(",", "");
		else
			strCadena=strCadena.substring(2).replace(",", "");
		return strCadena;
	}
	
	public static String nuevoCuenta(String strCuenta) {
		String cadenaw=strCuenta.substring(strCuenta.length()-11, strCuenta.length()-10);
		return strCuenta.replace(cadenaw, "");
	}
	
	public static String formatearNumero(double dblNumeroFormatear ) {
		int strCadena;
		String intTotalCadena;
		int intDecimales;
		int intValorFinal;
		String strNuevoResultado;
		String nuevoformato;
		
		strCadena=Double.toString(dblNumeroFormatear).indexOf( '.' )  ;
		intTotalCadena= String.valueOf(dblNumeroFormatear);
		intDecimales=intTotalCadena.length()-(strCadena);
		intValorFinal=0;
		
		if(intDecimales==2){
			intValorFinal=intDecimales;
		}else{
			intValorFinal=3;
		}
		
		strNuevoResultado= Double.toString(dblNumeroFormatear).substring(0, strCadena+intValorFinal);
		nuevoformato=String.format(Locale.UK, "%1$,.2f", Double.valueOf(strNuevoResultado));
		return nuevoformato;
	}
	
	public static String remplaceText(String strCadena){
		return strCadena.replace(",", "");	
	}
	
	public boolean setText(String strTipo, String strID, String strText) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
		WebElement weOperacion = null;
		boolean blnResultadoEsperado=true;
		try {
			switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.id(strID));
					break;
				case NAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.name(strID));
					break;
				case CLASSNAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.className(strID));
					break;
				case CSSSELECTOR:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strID));
					break;
				case XPATH:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID));
					break;
			default:
				break;
			} 
			
			weOperacion.clear();
			weOperacion.click();
			weOperacion.sendKeys(strText);
			Thread.sleep(800);
		} catch (Exception e) {	
			blnResultadoEsperado=false;
		    System.out.println("No se pudo ingresar el TEXTO:'"+strText+"' en el cuadro de texto:'"+strID+"'.");
		}
		return blnResultadoEsperado;
	}
	
	public boolean clicPortaCmb(String strTipo, String strID, String strText) {
		boolean blnResultadoEsperado=false;
		String opcion="";
		WebElement combo = null;
		
		try {
			switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					combo = Mdl_Variables.Gwed_Driver.findElement(By.id(strID));
					break;
				case NAME:	  
					combo = Mdl_Variables.Gwed_Driver.findElement(By.name(strID));
					break;
				case CLASSNAME:	  
					combo = Mdl_Variables.Gwed_Driver.findElement(By.className(strID));
					break;
				case CSSSELECTOR:	  
					combo = Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strID));
					break;
				case XPATH:	  
					combo = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID));
					break;
			default:
				break;
			} 
			
			List<WebElement> num=combo.findElements(By.xpath(".//option"));
			for(int j = 1;j<num.size();j++){
				
				opcion=num.get(j).getText();
				if(opcion.contains(strText)){
					num.get(j).click();
					blnResultadoEsperado=true;
					break;
				}
			}
		} catch (Exception e) {				
			blnResultadoEsperado=false;
			 System.out.println("No se pudo ingresar el TEXTO:'"+strText+"' en el cuadro de texto:'"+strID+"'.");
		}

		return blnResultadoEsperado;
	}


	public boolean setTextNew(String strTipo, String strID, String strText) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
		WebElement weOperacion = null;
		boolean blnResultadoEsperado=true;
		try {
			switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.id(strID));
					break;
				case NAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.name(strID));
					break;
				case CLASSNAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.className(strID));
					break;
				case CSSSELECTOR:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strID));
					break;
				case XPATH:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
					weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID));
					break;
			default:
				break;
			} 
			weOperacion.sendKeys(strText);
			Thread.sleep(1000);
		} catch (Exception e) {				
			blnResultadoEsperado=false;
		    System.out.println("No se pudo Ingresar la ruta en el OBJETO de tipo:'"+strTipo+"', con valor:'"+strText+"'.");
		}
		return blnResultadoEsperado;
	}
	
	public boolean clickBoton(String strTipo,String strName) {
		boolean blnResultadoEsperado=true;
		try{
			WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
			WebElement weOperacion = null;
			switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strName)));
					weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.id(strName)); 
					break;
				case NAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strName)));
					weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.name(strName)); 
					break;
				case CLASSNAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strName)));
					weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.className(strName)); 
					break;
				case CSSSELECTOR:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strName)));
					weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName)); 
					break;
				case XPATH:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strName)));
					weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName)); 
					break;		
				 
				case LINKTEXT:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(strName)));
					weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.linkText(strName)); 
					break;
			default:
				break;		
			}
			weOperacion.click();
		} catch (Exception e) {	
			blnResultadoEsperado=false;
		    System.out.println("No se pudo hacer clic en el OBJETO de tipo:'"+strTipo+"', con valor:'"+strName+"'.");
		}
		return blnResultadoEsperado;
	}
	
	public String getColor(String strTipo,String strName) {
		String color = null;
		switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	 
				color=Mdl_Variables.Gwed_Driver.findElement(By.id(strName)).getCssValue("color");
				break;
			case NAME:	  
				color=Mdl_Variables.Gwed_Driver.findElement(By.name(strName)).getCssValue("color");
				break;
			case CLASSNAME:	  
				color=Mdl_Variables.Gwed_Driver.findElement(By.className(strName)).getCssValue("color");
				break;
			case CSSSELECTOR:	  
				color=Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName)).getCssValue("color");
				break;
			case XPATH:	  
				color=Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName)).getCssValue("color");
				break;		
			case LINKTEXT:	  
				color=Mdl_Variables.Gwed_Driver.findElement(By.linkText(strName)).getCssValue("color");
				break;
		default:
			break;		
		}
		String hex1=Color.fromString(color).asRgb();
		return hex1;
	}
	
	public int positionElement(String strXpathBoton) {
		WebElement weOperacion = null;
		weOperacion= Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpathBoton)); 
		org.openqa.selenium.Point location=weOperacion.getLocation();
		return location.getY();
	}
	
	public boolean waitBy(String strTipo, String strID) {
		   WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
				switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
				  break;
				case NAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
				  break;
				case CLASSNAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
				  break;
				case CSSSELECTOR:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
				  break;
				case XPATH:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
				  break;
				case LINKTEXT:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(strID)));					
				  break;
				default:
					break;
				} 
			return true;
	}
	
	public enum Keyword{
		ID,NAME,CLASSNAME,CSSSELECTOR,XPATH,LINKTEXT,XPATH2, XPATH3, XPATH4,NOVALUE;
		public static Keyword getValue(String str){
	        try {
	            return valueOf(str);
	        }
	        catch (IllegalArgumentException ex) {
	            return NOVALUE;
	        }
	    }
	}
	
	

	public boolean waitElementBy(String strTipo, String strID) {
		boolean blnResultado=false;
		try {
			WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
			switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
					blnResultado=true;
				  break;
				case NAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
					blnResultado=true;
				  break;
				case CLASSNAME:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
					blnResultado=true;
				  break;
				case CSSSELECTOR:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
					blnResultado=true;
				  break;
				case XPATH:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
					blnResultado=true;
				  break;
				case LINKTEXT:	  
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(strID)));		
					blnResultado=true;
				  break;
				default:
					break;
			} 			
		} catch (Exception e) {
			blnResultado=false;
		}
		return blnResultado;
	}
	
	public boolean waitByMoreSec(String strTipo, String strID) {
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, 70);
		switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
			  break;
			case NAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
			  break;
			case CLASSNAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
			  break;
			case CSSSELECTOR:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
			  break;
			case XPATH:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
			  break;
			case LINKTEXT:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(strID)));					
			  break;
		default:
			break;
			} 
			return true;
	}
	
	public boolean waitClickableBy(String strTipo, String strID){
	
		   WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, 1800);
				switch (Keyword.getValue(strTipo.toUpperCase())){
				case ID:	  
					wait.until(ExpectedConditions.elementToBeClickable(By.id(strID)));
				  break;
				case NAME:	  
					wait.until(ExpectedConditions.elementToBeClickable(By.name(strID)));
				  break;
				case CLASSNAME:	  
					wait.until(ExpectedConditions.elementToBeClickable(By.className(strID)));
				  break;
				case CSSSELECTOR:	  
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(strID)));
				  break;
				case XPATH:	  
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strID)));
				  break;
				case LINKTEXT:	  
					wait.until(ExpectedConditions.elementToBeClickable(By.linkText(strID)));
				  break;
				default:
					break;
				} 
				//element.click();
			return true;
	}
	
	public String getText(String strTipo, String strID) {
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
		WebElement weOperacion = null;
		String text = "";
		
		switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.id(strID));
				break;
			case NAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.name(strID));
				break;
			case CLASSNAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.className(strID));
				break;
			case CSSSELECTOR:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strID));
				break;
			case XPATH:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID));
				break;
			case XPATH2:	  
				weOperacion = Mdl_Variables.Gwed_Driver.switchTo().frame(4).findElement(By.xpath(strID));
				break;
			case XPATH3	:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID));
				return weOperacion.getAttribute("value");
			case XPATH4:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
				Select select= new Select(Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID)));
				weOperacion=select.getFirstSelectedOption();
				break;
		default:
			break;
		} 
		text= weOperacion.getText();
		return text;
		
	}
	
	public String getTooltipText(String strTipo, String strID){
		WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, Mdl_Variables.Gint_TiempoEspera);
		WebElement weOperacion = null;
		String text = "";
		
		switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.id(strID));
				break;
			case NAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.name(strID));
				break;
			case CLASSNAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.className(strID));
				break;
			case CSSSELECTOR:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strID));
				break;
			case XPATH:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strID)));
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strID));
				break;
		default:
			break;
		} 
		text= weOperacion.getAttribute("title");
		return text; 
	}
	
	
	public boolean getElementVisibility(String strTipo,String strName) {
		boolean blnResultado=false;
		try {
			WebDriverWait wait = new WebDriverWait(Mdl_Variables.Gwed_Driver, 1);
			switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strName)));
				Mdl_Variables.Gwed_Driver.findElement(By.id(strName)); 
				blnResultado=true;
				break;
			case NAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strName)));
				Mdl_Variables.Gwed_Driver.findElement(By.name(strName)); 
				blnResultado=true;
				break;
			case CLASSNAME:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(strName)));
				Mdl_Variables.Gwed_Driver.findElement(By.className(strName)); 
				blnResultado=true;
				break;
			case CSSSELECTOR:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strName)));
				Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName)); 
				blnResultado=true;
				break;
			case XPATH:	  
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strName)));
				Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName)); 
				blnResultado=true;
				break;
			default:
				break;		
			} 
			
		} catch (Exception e) {
			blnResultado=false;
		}
		return blnResultado;
	}

	public boolean existElement(String strTipo, String strName)  {
		boolean present = false;
		try {
			switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	  
				Mdl_Variables.Gwed_Driver.findElement(By.id(strName)); 
				present = true;
				break;
			case NAME:	  
				Mdl_Variables.Gwed_Driver.findElement(By.name(strName));
				present = true;
				break;
			case CLASSNAME:	  
				Mdl_Variables.Gwed_Driver.findElement(By.className(strName)); 
				present = true;
				break;
			case CSSSELECTOR:	  
				Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName));
				present = true;
				break;
			case XPATH:	  
				Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName));
				present = true;
				break;
			default:
				break;		
			} 
			
		}catch (NoSuchElementException e){
			present = false;
		}
		return present;
	}

	public boolean visibleElement(String strTipo, String strName)  {
		WebElement weOperacion = null;
		boolean present = false;
		try {
			switch (Keyword.getValue(strTipo.toUpperCase())){
			case ID:	  
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.id(strName)); 
				present = true;
				break;
			case NAME:	  
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.name(strName));
				present = true;
				break;
			case CLASSNAME:	  
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.className(strName)); 
				present = true;
				break;
			case CSSSELECTOR:	  
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.cssSelector(strName));
				present = true;
				break;
			case XPATH:	  
				weOperacion = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strName));
				present = true;
				break;
			default:
				break;		
			} 
			present = weOperacion.isDisplayed();
			
		}catch (NoSuchElementException e){
			present = false;
		}
		return present;
	}
	
	public String formatearMonto(String tipoweOperacion,String cadenaMonto){
		int indice;
		String soles;
		String dolares;
		switch (tipoweOperacion) {
			case "Pagos Masivos": 
				indice=cadenaMonto.indexOf("|");
				soles=cadenaMonto.substring(3,indice-1);
				dolares=cadenaMonto.substring(indice+4);
				cadenaMonto=soles+"-"+dolares;
				break;
	    		
			case "Desembolso en Línea": 
				if(cadenaMonto.contains("/")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else{
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());//pendiente confirmar
				}
				break;
	    		
			case "Pago de Recibos": 
				indice=cadenaMonto.indexOf("|");
				soles=cadenaMonto.substring(3,indice-1);
				dolares=cadenaMonto.substring(indice+4);
				cadenaMonto=soles+"-"+dolares;
	    		break;
	    		
			case "Transferencias": 
				if(cadenaMonto.contains("/")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else{
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());//pendiente confirmar
				}
				break;
	    	
			case "Descuentos y Cobranza de Documentos": 
				if(cadenaMonto.contains("/")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else{
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());//pendiente confirmar
				}
				break;
			
			case "Documentos Electrónicos": 
				if(cadenaMonto.contains("/")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else{
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());//pendiente confirmar
				}
				break;
				
			case "Carta Fianza": 
				if(cadenaMonto.contains("/")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else{
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());//pendiente confirmar
				}
				break;
				
			case "Pago de Documentos":
				if(cadenaMonto.contains("/")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else{
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());//pendiente confirmar
				}
				break;
			case "Comercio Exterior":
				if(cadenaMonto.contains("€")||cadenaMonto.contains("£")||cadenaMonto.contains("¥")){
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());
				}else if(cadenaMonto.contains("C$")){
					cadenaMonto=cadenaMonto.substring(3, cadenaMonto.length());
				}else if(cadenaMonto.contains("Fr.")){
					cadenaMonto=cadenaMonto.substring(4, cadenaMonto.length());
				}else {//cadenaMonto.contains("$")||
					cadenaMonto=cadenaMonto.substring(2, cadenaMonto.length());
				}				
				break;
	    		
		}
		return cadenaMonto;
		
	}
}
