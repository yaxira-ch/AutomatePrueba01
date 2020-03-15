package proxim.dao;


import java.awt.Robot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.Console;
import proxim.be.ObjetosGenerales;
import proxim.bl.*;
import proxim.dao.ConexionSqlServer;

public class ConexionDriver {
	
	static FuncionesGenerales objGeneral= new FuncionesGenerales();
	static ConexionBL objConexionBL= new ConexionBL();
	static ConexionSqlServer objSQL = new ConexionSqlServer();
	static WebDriver wedDriver;
	
	public enum Keyword{
		CHECK,	CONTEXT,	FW_CLIENTE,	FW_CH, FW_TUYA, FW_BNET,
		LAUNCHAPP,	LOOP,	MSGBOX,	NAVIGATE,	PERFORM, SAFARI, IE, CHROME, FIREFOX,
		PRESSKEYS,	PRESSKEYS_AS400,	TEXTEXIST,	WAIT, NOVALUE;
		public static Keyword getValue(String str){
	        try {
	            return valueOf(str);
	        }
	        catch (IllegalArgumentException ex) {
	            return NOVALUE;
	        }
	    }
	}
		
	@SuppressWarnings("deprecation")
	public static void conexion() throws Exception{
		String strFechaFinEjecicion;
		long lngTiempoEjeCaso;
		String strDriverChrome="C:\\Proyecto\\drivers\\chromedriver.exe";
		String strDriverMozilla="C:\\Proyecto\\drivers\\geckodriver.exe";
		String strDriverExplorer="C:\\Proyecto\\drivers\\IEDriverServer.exe";
		String strFechaHora="dd/MM/yyyy HH:mm:ss";
		String strFechaEjecicion = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
		try{
			//switch (Keyword.getValue(Mdl_Variables.Gstr_Aplicativo.toLowerCase())){
			switch (Keyword.getValue(Mdl_Variables.Gstr_Aplicativo.toUpperCase())){
				case SAFARI:
					Mdl_Variables.Gwed_Driver = new SafariDriver();			              
					Thread.sleep(3000);  // Let the user actually see something!
					break;
				
				case CHROME:
					// Optional, if not specified, WebDriver will search your path for chromedriver.
					System.setProperty("webdriver.chrome.driver", strDriverChrome);							  
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));	
					Thread.sleep(3000);  // Let the user actually see something!
					Mdl_Variables.Gwed_Driver = new ChromeDriver(capabilities);	
					Thread.sleep(4000);  // Let the user actually see something!
					Mdl_Variables.Gwed_Driver.manage().window().maximize();
					break;
					
				case FIREFOX:		               
					System.setProperty("webdriver.gecko.driver",strDriverMozilla);
					FirefoxOptions options = new FirefoxOptions();	
					options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
					Mdl_Variables.Gwed_Driver = new FirefoxDriver(options);
					break;
				default:
					//INTERNET EXPLORER
					//Para SO de 32 bits:
					File iedriver = new File(strDriverExplorer);
					
					//Para SO de 64 bits:
					System.setProperty("webdriver.ie.driver", iedriver.getAbsolutePath());
					DesiredCapabilities caps=DesiredCapabilities.internetExplorer();
					caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
					caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
					Mdl_Variables.Gwed_Driver = new InternetExplorerDriver(caps);
					Mdl_Variables.Gwed_Driver.manage().window().maximize();
					Thread.sleep(3000);  // Let the user actually see something!
					break;					
				
			}	
			
			//INGRESAR URL			
			Mdl_Variables.Gwed_Driver.get(Mdl_Variables.Gstr_Url);
			FuncionesGenerales.Click_Aceptar();
			/*
			//NUEVO NODO
			ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
			objObjetosGenerales.waitElementBy(ObjetosGenerales.id, "reload-button");
			Thread.sleep(15000);
			
			String urlnew = "https://130.30.25.23:9443"+Mdl_Variables.Gwed_Driver.getCurrentUrl().toString().substring(20, Mdl_Variables.Gwed_Driver.getCurrentUrl().toString().length());
			System.out.println("URL antigua: "+Mdl_Variables.Gwed_Driver.getCurrentUrl().toString());
			System.out.println(urlnew+"\n");
			Mdl_Variables.Gwed_Driver.get(urlnew);
			FuncionesGenerales.Click_Aceptar();
			System.out.println("Ambiente");
			

			/*
			//Mdl_Variables.Gwed_Driver.findElement(By.id("overridelink")).click();
			Mdl_Variables.Gwed_Driver.navigate().to("https://130.30.25.23:9443/bpi-empresas/login?");
			Mdl_Variables.Gwed_Driver.findElement(By.id("reload-button")).isDisplayed();
			//nueva
			String urlnew = "https://130.30.25.23:9443"+Mdl_Variables.Gwed_Driver.getCurrentUrl().toString().substring(20, Mdl_Variables.Gwed_Driver.getCurrentUrl().toString().length());
			System.out.println("URL antigua: "+Mdl_Variables.Gwed_Driver.getCurrentUrl().toString());
			System.out.println("URL nueva  : "+urlnew+"\n");
			//Thread.sleep(15000);
			Mdl_Variables.Gwed_Driver.navigate().to(urlnew);
			System.out.println("Ambiente");
			*/

			if(Mdl_Variables.Gstr_Aplicativo.toLowerCase().equalsIgnoreCase("chrome")){
				Robot robot=new Robot();
				robot.keyPress(java.awt.event.KeyEvent.VK_ESCAPE);
			}
			
			
			//LOG
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes");
			objGeneral.CallPasos("Se realiza el ingreso al URL: "+Mdl_Variables.Gstr_Url);
			strFechaFinEjecicion = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strFechaFinEjecicion).getTime() - new SimpleDateFormat(strFechaHora).parse(strFechaEjecicion).getTime()) / (1000);
			objSQL.logDetalle("1", "Ingresar a la URL: "+Mdl_Variables.Gstr_Url+".",Long.toString(lngTiempoEjeCaso) ,strFechaFinEjecicion);
			
			
		}catch(Exception e) {
			strFechaFinEjecicion = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	
			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strFechaFinEjecicion).getTime() - new SimpleDateFormat(strFechaHora).parse(strFechaEjecicion).getTime()) / (1000);
			System.out.println("Se presentó un error ConexionDriver.Conexion: " + e.getMessage());
			e.printStackTrace();
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
            CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes");
            objSQL.logDetalle("0", "No se pudo realizar el ingreso a la URL: "+Mdl_Variables.Gstr_Url+".",Long.toString(lngTiempoEjeCaso) ,strFechaFinEjecicion);
			Mdl_Variables.Gint_Action = 0;
		}
	}
}
