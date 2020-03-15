package proxim.bl;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.*;
////

public class CapturarPantalla {
	int intVar = 1;
    public static String strNombreEvidencia;  
    static boolean blnResultadoEsperado;
    static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
    
	public void ingresoDatosLog()
    {	
		try
		{      
			if ((Mdl_Variables.Gint_TipoLog == 0 || Mdl_Variables.Gint_Action == 0) && Mdl_Variables.Gint_TipoLog < 2)
	        {
	        		Mdl_Variables.Gint_TipoLog = 1;
	        		Mdl_Variables.Gint_Action = 1;
	        }
			
			Mdl_Variables.Gint_TiempoEntradaSistema = new Date().compareTo(Mdl_Variables.Gdt_EntradaSistema);
			
			Mdl_Variables.Gstr_SqlLogMaestro = "INSERT INTO TBL_LOG_MAESTRO (NOMBRE_TABLA, MODULO, VALIDADO, FECHA, MAQUINA) Values ('" + Mdl_Variables.Gstr_Tabla + "','" + Mdl_Variables.Gstr_Modulo +  "','True','" + new Date() +"','"+ Mdl_Variables.Gstr_Maquina +"')";    
			Mdl_Variables.Gcnn_Conexion.prepareCall(Mdl_Variables.Gstr_SqlLogMaestro).execute();
			Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Mdl_Variables.Grst_Log =  Mdl_Variables.Gcnn_Conexion.prepareCall("select MAX(ID_MAESTRO) AS ID_MAESTRO from TBL_LOG_MAESTRO where MAQUINA = '" + Mdl_Variables.Gstr_Maquina +"' and NOMBRE_TABLA = '" + Mdl_Variables.Gstr_Tabla + "';").executeQuery();
            
			while (Mdl_Variables.Grst_Log.next()){
				Mdl_Variables.GStr_IdMaestro = Mdl_Variables.Grst_Log.getString("ID_MAESTRO"); 
			}
			
			if(Mdl_Variables.Gstr_CadenaMaestro.equals("")){
				Mdl_Variables.Gstr_CadenaMaestro=Mdl_Variables.Gstr_CadenaMaestro+Mdl_Variables.GStr_IdMaestro;
			}else{
				Mdl_Variables.Gstr_CadenaMaestro=Mdl_Variables.Gstr_CadenaMaestro+","+Mdl_Variables.GStr_IdMaestro;
			}
			
		}catch(Exception ex){
			System.out.println("Ocurrió un error en Mdl_Evidenciamiento.Ingreso_Datos_Log: " + ex.getMessage());
		}
    }
	
	public static void pageDown(String strArea) throws InterruptedException{
		JavascriptExecutor jse=(JavascriptExecutor)Mdl_Variables.Gwed_Driver;
		jse.executeScript("window.scrollBy(0,"+strArea+")", "");
		Thread.sleep(3000);
	}
	
	public static boolean scrollCapturaPantalla() throws IOException   //  scrollCapturaPantallaVertical
    {
    	  
		boolean bandera =false;
		
		int intNumEntero;
		//----Capturar Dimension de la pantalla
		Dimension initial_size = Mdl_Variables.Gwed_Driver.manage().window().getSize();
	    int height = initial_size.getHeight();
	    //----Capturar Tamaño Total de la pagina con scroll
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    int intNumero=0;
	    double dobResultado=alto/height;
	    JavascriptExecutor jse = (JavascriptExecutor) Mdl_Variables.Gwed_Driver;
	    int intResTotal=0;
	    try {
	    intNumero= alto%height;
	    if(intNumero!=0){
	    	intNumEntero= (int)(dobResultado*2)+1;
	    }else{
	    	intNumEntero= (int)dobResultado*2;
	    }
	   
		for(int i=1;i<=intNumEntero;i++){
			if(i==1){
				jse.executeScript("window.scrollBy(0,-250)", "");
				Thread.sleep(1500);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			}else{
				intResTotal=intResTotal+height/2;
				jse.executeScript("scroll(0, "+intResTotal+");");	
				Thread.sleep(1500);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			}
			
		}
		pageDown("10000");
			
		} catch (InterruptedException e) {
			 bandera =false;
			e.printStackTrace();
		}
    	return bandera;
	}

	public static boolean scrollCapturaPantallaHorizontal(String strXpath) {
		boolean bandera =false;
    	try {  
    		JavascriptExecutor js = (JavascriptExecutor) Mdl_Variables.Gwed_Driver;
			Thread.sleep(700);
			js.executeScript("arguments[0].scrollLeft = arguments[1];",Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpath)), 15000);
			Thread.sleep(700);
			js.executeScript("arguments[0].scrollRight = arguments[0];",Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpath)),15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return bandera;
	}
	
	public static boolean scrollMoveIzquierda(String strXpath) {
		boolean bandera =false;
    	JavascriptExecutor js = (JavascriptExecutor) Mdl_Variables.Gwed_Driver;
		js.executeScript("arguments[0].scrollLeft = arguments[1];",Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpath)), 15000);
		//js.executeScript("arguments[0].scrollRight = arguments[0];",Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpath)),15000);
    	return bandera;
	}
	
	public static boolean scrollCapturaPantallaVertical(String strXpath,String strRuta) {
		String strImagen;
		String strTiempo;
		BufferedImage bimImage;	
		try{
			strImagen= Mdl_Variables.Gstr_NombreVersion + "_" + Mdl_Variables.Gstr_Corrida + "-"  +  new Date().toString().replace("/","_").replace(" ","_").replace(":","_").replace("#","");
			Mdl_Variables.Gstr_NombreImagen="CasoPrueba_" + Mdl_Variables.Gint_IdCaso + "\\Version_" +  Mdl_Variables.Gstr_NombreVersion  + "\\Ciclo_" +  Mdl_Variables.Gstr_Corrida + "\\1. Imagenes\\"+strImagen+ ".png";
			
			Robot robot = new Robot();  
		    bimImage = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
		    strTiempo=strRuta + "\\" +  strImagen + ".png";
		    ImageIO.write(bimImage, "png", new File(strTiempo)); 
		    
		    Thread.sleep(1500);
		    strImagen= Mdl_Variables.Gstr_NombreVersion + "_" + Mdl_Variables.Gstr_Corrida + "-"  +  new Date().toString().replace("/","_").replace(" ","_").replace(":","_").replace("#","");
			Mdl_Variables.Gstr_NombreImagen="CasoPrueba_" + Mdl_Variables.Gint_IdCaso + "\\Version_" +  Mdl_Variables.Gstr_NombreVersion  + "\\Ciclo_" +  Mdl_Variables.Gstr_Corrida + "\\1. Imagenes\\"+strImagen+ ".png";
			JavascriptExecutor js = (JavascriptExecutor) Mdl_Variables.Gwed_Driver;
			js.executeScript("arguments[0].scrollTop = arguments[1];",Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpath)), 15000);
			 Thread.sleep(1500);
			bimImage = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
		    strTiempo=strRuta + "\\" +  strImagen + "_1.png";
		    ImageIO.write(bimImage, "png", new File(strTiempo)); 
		    return true;
		} catch (Exception e) {
			System.out.println("Error tomando la captura de la pantalla Evidencia.CapturaPantalla en Lstr_Ruta: " + strRuta + e.getMessage());
			CapturarPantalla.EvidenciaLog(false, "");
			Mdl_Variables.Gint_Action = 0;
			return false;
		}
	}
	
	public static void esc() throws AWTException, InterruptedException{

		Robot robot;
		try {
			 Thread.sleep(15000);
			robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace(); 
		}
		
	}
	
    public static boolean scrollCapturaPantallaArriba() 
    {
    	try {
		JavascriptExecutor jse = (JavascriptExecutor) Mdl_Variables.Gwed_Driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		
			Thread.sleep(500);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			
		} catch (InterruptedException e) {
			 blnResultadoEsperado =false;
			e.printStackTrace();
		}
    	return blnResultadoEsperado;
	}
	
	public static void capturaPantalla(String strRuta) {
		 String strImagen= Mdl_Variables.Gstr_NombreVersion + "_" + Mdl_Variables.Gstr_Corrida + "-"  +  new Date().toString().replace("/","_").replace(" ","_").replace(":","_").replace("#","");
		 String strTiempo1;
		 Mdl_Variables.Gstr_NombreImagen="CasoPrueba_" + Mdl_Variables.Gint_IdCaso + "\\Version_" +  Mdl_Variables.Gstr_NombreVersion  + "\\Ciclo_" +  Mdl_Variables.Gstr_Corrida + "\\1. Imagenes\\"+strImagen+ ".png";
			
		try {
		    Robot robot = new Robot();  
		    BufferedImage bimgImage = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
		    strTiempo1=strRuta + "\\" +  strImagen + ".png";
		    ImageIO.write(bimgImage, "png", new File(strTiempo1));  
		} catch (Exception e) {
			System.out.println("Error tomando la captura de la pantalla Evidencia.CapturaPantalla en Lstr_Ruta: " + strRuta + e.getMessage());
			CapturarPantalla.EvidenciaLog(false, "");
			Mdl_Variables.Gint_Action = 0;
		}
	}
		
		public static void EvidenciaLog(boolean blnResultado, String strDescripcionAdicional ){
			try{
				
				if (blnResultado){
					Mdl_Variables.Gstr_DescripcionAciertoError = (Mdl_Variables.Gstr_DescAccAnt != null && !Mdl_Variables.Gstr_DescAccAnt.equals("")) ? Mdl_Variables.Gstr_DescAccAnt : Mdl_Variables.Grst_Tabla.getString("DESCRIPCION_ACIERTO");
					Mdl_Variables.Gcnn_Conexion.prepareCall("Update " + (Mdl_Variables.Gstr_TablaAnterior != null && !Mdl_Variables.Gstr_TablaAnterior.equals("") ? Mdl_Variables.Gstr_TablaAnterior : Mdl_Variables.Gstr_Tabla) + "_D set EJECUCION_AC_ERR = 0 where [INDEX] = " + ((Mdl_Variables.Gstr_IdEvidencia != null && !Mdl_Variables.Gstr_IdEvidencia.equals("")) ? Mdl_Variables.Gstr_IdEvidencia : Mdl_Variables.Gint_Indice)).execute();
					Mdl_Variables.Gint_TipoLog = Mdl_Variables.Gint_MsgValido;
					Mdl_Variables.Gint_Action = 1;
					Mdl_Variables.Gint_TipoLog = 1;
				}else{
					Mdl_Variables.Gstr_DescripcionAciertoError = ((Mdl_Variables.Gstr_DescErrAnt != null && !Mdl_Variables.Gstr_DescErrAnt.equals("")) ? Mdl_Variables.Gstr_DescErrAnt : Mdl_Variables.Grst_Tabla.getString("DESCRIPCION_ERROR")) + (strDescripcionAdicional.contentEquals("") ? "" : "-" + strDescripcionAdicional)+" -> "+Mdl_Variables.Gstr_ComplementoDescripcion;
					Mdl_Variables.Gcnn_Conexion.prepareCall("Update " + (Mdl_Variables.Gstr_TablaAnterior != null && !Mdl_Variables.Gstr_TablaAnterior.equals("") ? Mdl_Variables.Gstr_TablaAnterior : Mdl_Variables.Gstr_Tabla) + "_D set 	 = -1 where [INDEX] = " + ((Mdl_Variables.Gstr_IdEvidencia != null && !Mdl_Variables.Gstr_IdEvidencia.equals("")) ? Mdl_Variables.Gstr_IdEvidencia : Mdl_Variables.Gint_Indice)).execute();
					Mdl_Variables.Gint_TipoLog = Mdl_Variables.Gint_MsgError;
					Mdl_Variables.Gint_Action = 0;
					Mdl_Variables.Gint_TipoLog = 2;
				}
			}catch(Exception ex){
				System.out.println("Ocurrió un error en CapturarPantalla: " + ex.getMessage());
			}
		}
		

		//CHA-20170418: Se agrega la funcion generar_html2, por estandarización de las evidencias en el cliente.
		public static void GenerarHTML2() throws SQLException{
			
			/***************************/
			//Variables de Evidencia.
			String strPasosHtml  = "";
			String arrValores[];
			int i;
			String strSeparador = "\\;\\;";
			int x = 0;
			int intTiempoExecCaso1 = 0;
			String strFechaExec = "";
			
			/***************************/
			
			
			
			int intVrbConteoErrores 	= 0; //intVrbConteoErrores
			int intVrbConteoAciertos 	= 0; //intVrbConteoAciertos
			int intVrbTotalCasos 		= 0; // intVrbTotalCasos
			int intContador 			= 0; //intContador
			int intIndice 				= 0; // intIndice
			int intPosicion 			= 0; // intPosicion
			int intTiempoTotalEscenario = 0; //intTiempoTotalEscenario
			
			String strVrbDtConteoErrores 	= ""; //strVrbDtConteoErrores
			String strVrbDtConteoAciertos 	= ""; //strVrbDtConteoAciertos
			String strVrbDtTotalCasos 		= ""; //strVrbDtTotalCasos
			String strVrbTotalTiempos 		= ""; //strVrbTotalTiempos
			
			String strFecha 				= ""; //strFecha
			String strFechaEvd 				= ""; //strFecha
			
			Date datFecha = new Date();
			SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			strFecha = sdfFecha.format(datFecha);
			strFechaEvd = strFecha.replace("/", "");
			strFechaEvd = strFechaEvd.replace(":", "");
			strFechaEvd = strFechaEvd.replace(" ", "");
			OutputStreamWriter osw;
			
			//Capturando variables Globales
			String strFuncionalidad = Mdl_Variables.Gstr_Tabla;
			String strVersion = Mdl_Variables.Gstr_NombreVersion;
			String strCiclo = Mdl_Variables.Gstr_Corrida;
			
			
			int intIndiceSched 	= Mdl_Variables.Gint_Indice;		

			//Nombre del HTML
			strNombreEvidencia = strFuncionalidad + "_" + strVersion + "_" + strCiclo  + "_" + strFechaEvd + ".html";			
							
			try {
				osw = new OutputStreamWriter(new FileOutputStream(Mdl_Variables.Gstr_RutaReportHTML + Mdl_Variables.Gstr_CarpetaReporteHTML+ "\\" + strNombreEvidencia), "UTF-8");
			}catch (IOException e) {
				System.out.println("Error generando el archivo " + Mdl_Variables.Gstr_RutaReportHTML + "\\" + strNombreEvidencia + " : " + e.getMessage());
				return;
			}
			
		    BufferedWriter bw = new BufferedWriter(osw);
		    PrintWriter prWrFileScreen = new PrintWriter(bw);
			
			try{				
			    prWrFileScreen.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		        prWrFileScreen.println("<html>");
		        prWrFileScreen.println("<title>EVIDENCIA DE PRUEBA AUTOMATIZADA</title>");
		        prWrFileScreen.println("<body><CENTER>");
		        
		        //Ejecutamos el primer query, para saber si tenemos casos de prueba en el log y es necesario armar evidencia, en el caso de que no enviar mensaje en el html y salir de la función
		        
		        strVrbDtTotalCasos = "SELECT COUNT(DISTINCT INDICE) AS TOTAL_CASOS FROM TBL_LOG_DETALLE DE INNER JOIN TBL_LOG_MAESTRO MA ON MA.ID_MAESTRO = DE.ID_MAESTRO WHERE  MA.NOMBRE_TABLA like '" + strFuncionalidad + "' AND DE.CICLO like '" + strCiclo + "' AND DE.VERSION ='" + strVersion + "' AND DE.INDICE_SCHEDULE = " + intIndiceSched + "";
		        
		        Statement stmtstrVrbDtTotalCasos = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        Mdl_Variables.Grst_Evidencia = stmtstrVrbDtTotalCasos.executeQuery(strVrbDtTotalCasos);  			        
		        intVrbTotalCasos = 0;
		        
		        if (Mdl_Variables.Grst_Evidencia.next()) {
		        	intVrbTotalCasos = Integer.parseInt(Mdl_Variables.Grst_Evidencia.getString("TOTAL_CASOS"));
		        }
		        
		        Mdl_Variables.Grst_Evidencia.close();
		        
		        
		        if (intVrbTotalCasos==0) {
		        	//No es necesario continuar con la generación de evidencias
		        	prWrFileScreen.println("<div align='center' width = '1024px'> ");
		        	prWrFileScreen.println("<center> No es posible generar evidencia, no se encontraron logs para las siguientes específicaciones: </center> <br><br>");
		        	prWrFileScreen.println("<p>Escenario Automatizado: " + strFuncionalidad + " </p><br>");
		        	prWrFileScreen.println("<p>Versión: " + strVersion  + " </p><br>");
		        	prWrFileScreen.println("<p>Corrida: " + strCiclo  + " </p><br>");
		        	prWrFileScreen.println("<p>Por favor revisar que se hayan grabado correctamente los log en la ejecución</p><br>");
		        	prWrFileScreen.println("</div>");
		        	prWrFileScreen.println("</body></html>");
		    		prWrFileScreen.close();
					
					return;
		        }
		        
		        
		        /*****************************************************/
		        //*****************************************************************************************
		        //* Script para agrandar y normalizar las imagenes con las lupas de + , -                 *
		        //*****************************************************************************************
			    
		        prWrFileScreen.println("<!-- CSS goes in the document HEAD or added to your external stylesheet -->");
	            prWrFileScreen.println("<style type=\"text/css\">");
	            prWrFileScreen.println("table.formatoTexto {");
	            prWrFileScreen.println(" font-family: verdana,arial,sans-serif;");
	            prWrFileScreen.println(" font-size:11px;");
	            prWrFileScreen.println(" color:#333333;");
	            prWrFileScreen.println(" border-width: 1px;");
	            prWrFileScreen.println(" border-color: #a9c6c9;");
	            prWrFileScreen.println(" border-collapse: collapse;");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println("table.altrowstable {");
	            prWrFileScreen.println(" font-family: verdana,arial,sans-serif;");
	            prWrFileScreen.println(" font-size:11px;");
	            prWrFileScreen.println(" color:#333333;");
	            prWrFileScreen.println(" border-width: 1px;");
	            prWrFileScreen.println(" border-color: #a9c6c9;");
	            prWrFileScreen.println(" border-collapse: collapse;");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println("table.altrowstable th {");
	            prWrFileScreen.println(" border-width: 1px;");
	            prWrFileScreen.println(" padding: 8px;");
	            prWrFileScreen.println(" border-style: solid;");
	            prWrFileScreen.println(" border-color: #a9c6c9;");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println("table.altrowstable td {");
	            prWrFileScreen.println(" border-width: 1px;");
	            prWrFileScreen.println(" padding: 8px;");
	            prWrFileScreen.println(" border-style: solid;");
	            prWrFileScreen.println(" border-color: #a9c6c9;");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println(".oddrowcolor{");
	            prWrFileScreen.println(" background-color:#d4e3e5;");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println(".evenrowcolor{");
	            prWrFileScreen.println(" background-color:#c3dde0;");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println("</style>");
	            prWrFileScreen.println(" <script language=\"JavaScript1.2\">");
	            prWrFileScreen.println("    var zoomfactor=0.5");
	            prWrFileScreen.println("    function zoomhelper(){");
	            prWrFileScreen.println("    whatcache.style.width=1300");
	            prWrFileScreen.println("whatcache.style.height=1100");
	            prWrFileScreen.println("    }");
	            prWrFileScreen.println("    function zoom(originalW, originalH, what, state)");
	            prWrFileScreen.println("   {");
	            prWrFileScreen.println("    if (!document.all&&document.getElementById)");
	            prWrFileScreen.println("    return");
	            prWrFileScreen.println("    whatcache=eval(\"document.images.\"+what)");
	            prWrFileScreen.println("    prefix=(state==\"in\")? 1 : -1");
	            prWrFileScreen.println("    if (whatcache.style.width==\"\"||state==\"restore\")");
	            prWrFileScreen.println("    {");
	            prWrFileScreen.println("    whatcache.style.width=originalW + 111");
	            prWrFileScreen.println("    whatcache.style.height=originalH + 100");
	            prWrFileScreen.println("    if (state==\"restore\")");
	            prWrFileScreen.println("    return");
	            prWrFileScreen.println("    }");
	            prWrFileScreen.println("    else");
	            prWrFileScreen.println("    {");
	            prWrFileScreen.println("    zoomhelper()");
	            prWrFileScreen.println("    }");
	            prWrFileScreen.println("    beginzoom=setInterval(\"zoomhelper()\",10)");
	            prWrFileScreen.println("    }");
	            prWrFileScreen.println("    function clearzoom(){");
	            prWrFileScreen.println("    if (window.beginzoom)");
	            prWrFileScreen.println("    clearInterval(beginzoom)");
	            prWrFileScreen.println("    }");

	            prWrFileScreen.println("</script>");
	            prWrFileScreen.println("<script type=\"text/javascript\">");
	            prWrFileScreen.println("function PrintThisDiv(id) {");
	            prWrFileScreen.println("var HTMLContent = document.getElementById(id);");
	            prWrFileScreen.println("var Popup = window.open('about:blank', id, 'width=500,height=500');");
	            prWrFileScreen.println("Popup.document.writeln('<html><head>');");
	            prWrFileScreen.println("Popup.document.writeln('<style type=\"text/css\">');");
	            prWrFileScreen.println("Popup.document.writeln('body{font-family: verdana,arial,sans-serif;font-size:11;color:#333333;border-width: 1px;border-color: #a9c6c9;border-collapse: collapse;}');");
	            prWrFileScreen.println("Popup.document.writeln('</style>');");
	            prWrFileScreen.println("Popup.document.writeln('</head><body>');");
	            prWrFileScreen.println("Popup.document.writeln('<a href=\"javascript:;\" onclick=\"window.print();\">Imprimir</a>');");
	            prWrFileScreen.println("Popup.document.writeln(HTMLContent.innerHTML);");
	            prWrFileScreen.println("Popup.document.writeln('</body></html>');");
	            prWrFileScreen.println("Popup.document.close();");
	            prWrFileScreen.println("Popup.focus();");
	            prWrFileScreen.println("}");
	            prWrFileScreen.println("</script>");

	            //'*****************************************************************************************
	            //'* Script Para Agrandar,ocultar,mostrar y dejarlas en estado normal todas las imagenes   *
	            //'*****************************************************************************************

	            prWrFileScreen.println("      <style> ");
	            prWrFileScreen.println("        .imagenNO {display:none;} ");
	            prWrFileScreen.println("        .imagen {display:table-cell;} ");
	            prWrFileScreen.println("      </style> ");
	            prWrFileScreen.println("      <script> ");
	            prWrFileScreen.println("      function mostrarImagenes(recolocar)  ");
	            prWrFileScreen.println("      { ");
	            prWrFileScreen.println("        for (x=1;x<document.images.length;x++) ");
	            prWrFileScreen.println("            { ");
	            prWrFileScreen.println("                document.images[x].className = \"imagen\"; ");
	            prWrFileScreen.println("            } ");
	            prWrFileScreen.println("        } ");
	            prWrFileScreen.println("      function ocultarImagenes(recolocar) ");
	            prWrFileScreen.println("       { ");
	            prWrFileScreen.println("        for (x=1;x<document.images.length;x++) ");
	            prWrFileScreen.println("            { ");
	            prWrFileScreen.println("                  document.images[x].className = \"imagenNO\"; ");
	            prWrFileScreen.println("            } ");
	            prWrFileScreen.println("        } ");
	            prWrFileScreen.println("        function MostrarTImagenes(recolocar) ");
	            prWrFileScreen.println("       { ");
	            prWrFileScreen.println("        for (x=1;x<document.images.length;x=x+1) ");
	            prWrFileScreen.println("            { ");
	            prWrFileScreen.println("                  document.images[x].height=\"700\" ");
	            prWrFileScreen.println("                  document.images[x].width=\"1000\" ");
	            prWrFileScreen.println("            } ");
	            prWrFileScreen.println("        } ");
	            prWrFileScreen.println("        function ImagenesP(recolocar) ");
	            prWrFileScreen.println("       { ");
	            prWrFileScreen.println("        for (x=1;x<document.images.length;x=x+1) ");
	            prWrFileScreen.println("            { ");
	            prWrFileScreen.println("                  document.images[x].height=\"211\" ");
	            prWrFileScreen.println("                  document.images[x].width=\"250\" ");
	            prWrFileScreen.println("            } ");
	            prWrFileScreen.println("        } ");
	            prWrFileScreen.println("      </script> ");
		        
	          
		        //'*****************************************
		        //'*         Tabla de encabezado           *
		        //'*****************************************
		        prWrFileScreen.println("<TABLE border='1' class='altrowstable' cellpadding='5' cellspacing='0'>");
		        
		        File f = new File(Mdl_Variables.Gstr_Logo);
		        if(f.exists()) { 
		        	prWrFileScreen.println("<TR ALIGN=CENTER><TD COLSPAN=2><a href='http://www.choucairtesting.com/' title='Visita Choucair Software Testing'><IMG SRC='" + Mdl_Variables.Gstr_Logo + "'></a></TD></TR>");
		        }
		        
		        prWrFileScreen.println("<TR><TD><b>Nombre de script:</b> </TD><TD>" + strFuncionalidad+ "</TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>Escenario:</b> </TD><TD>" + strFuncionalidad + "</TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>Versión:</b></TD><TD>" + strVersion + "</TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>Corrida:</b></TD><TD>" + strCiclo + "</TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>Automatizador:</b> </TD><TD>" + Mdl_Variables.Gstr_TesterResponsable + "</TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>Fecha y hora de la ejecucion: </b> </strVersion><TD> " + strFecha +  " </TD></TR>");

		        //MyFile_Screen.println("<TR><TD><b>Tipo de aplicación: </b> </TD><TD> " + Mdl_Variables.Gstr_TipoAplicativo + " </TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>Arquitecto de Automatización:</b> </TD><TD>" + Mdl_Variables.Gstr_Arquitecto + "</TD></TR>");
		        
		        /**********************************************/
		        
		        prWrFileScreen.println("<TR ALIGN=center><TD COLSPAN=2><b><a name='MENU'>RESUMEN EJECUCIÓN</a></b></TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>TOTAL CASOS EJECUTADOS:</b> </TD><TD>" + intVrbTotalCasos + "</TD></TR>");
		        
		        strVrbDtConteoAciertos = "SELECT  COUNT(DISTINCT(INDICE)) AS TOTAL_ACIERTOS FROM TBL_LOG_DETALLE " +
		        		" WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN " + 
		        		" (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" +  strFuncionalidad +
		        		"' AND CICLO like '" + strCiclo + "' AND VERSION = '" + strVersion + 
		        		"' AND INDICE NOT IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN " +
		        		" (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' )  " + 
		        		" AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + strCiclo  + "' AND DET.VERSION = '" + strVersion + "'))";
		        Statement stmtstrVrbDtConteoAciertos = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        Mdl_Variables.Grst_Evidencia = stmtstrVrbDtConteoAciertos.executeQuery(strVrbDtConteoAciertos);  
		        			        
		        if (Mdl_Variables.Grst_Evidencia.next())
		        {
		        	intVrbConteoAciertos = Integer.parseInt(Mdl_Variables.Grst_Evidencia.getString("TOTAL_ACIERTOS"));
		        }		        
		        
		        strVrbDtConteoAciertos = "SELECT  DISTINCT(INDICE) FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
			        strFuncionalidad+ "' AND CICLO like '" +  strCiclo + "' AND VERSION = '" + 
			        strVersion + "' AND INDICE NOT IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
			        strFuncionalidad+"' ) AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + 
			        strCiclo + "' AND DET.VERSION = '" + strVersion + "')) ORDER BY INDICE";
		        Statement stmtstrVrbDtDistinctAciertos =Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        Mdl_Variables.Grst_Evidencia = stmtstrVrbDtDistinctAciertos.executeQuery(strVrbDtConteoAciertos);  
		        
		        prWrFileScreen.println("<TR><TD><b>TOTAL <a href='#CASOS ACIERTOS'> CASOS ACIERTOS</a></TD><TD>" + intVrbConteoAciertos + "</b></TD></TR>");
		        prWrFileScreen.println("<TR><TD><b>DETALLE</b></TD><TD>");
		        
		        int m = 1;
		        intPosicion = 0;
		        
		        while (Mdl_Variables.Grst_Evidencia.next())
		        {
		        	if (intPosicion == intVrbConteoAciertos - 1)
		        	{
		        		prWrFileScreen.println("<a href='#CASOS " + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "'>" + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "</a>");
		        	}    
		            else
		            {
		            	prWrFileScreen.println("<a href='#CASOS " + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "'>" + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "</a> ,");
		                intPosicion = intPosicion + 1;
		            }
		                   
		            if (m % 20 == 0) 
		            {
		            	prWrFileScreen.println("<br>");
		            	m = m + 1;  
		            }	            
		        }
		                
		        prWrFileScreen.println("</TD></TR>");
		        Mdl_Variables.Grst_Evidencia.close();
		        
		        
		        strVrbDtConteoErrores = "SELECT  COUNT(DISTINCT(INDICE)) AS TOTAL_FALLIDOS FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" +
		        		strFuncionalidad+ "' AND CICLO like '" + strCiclo + "' AND VERSION = '" + strVersion +
				        "' AND INDICE IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE DET.INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
				        strFuncionalidad+ "' ) AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + strCiclo + 
				        "' AND DET.VERSION = '" + strVersion + "'))";
	 	       
	            Statement stmtstrVrbDtConteoErrores = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            Mdl_Variables.Grst_Evidencia = stmtstrVrbDtConteoErrores.executeQuery(strVrbDtConteoErrores); 
	            
	        	if ( Mdl_Variables.Grst_Evidencia.next())
		        {
	        		intVrbConteoErrores =  Mdl_Variables.Grst_Evidencia.getInt("TOTAL_FALLIDOS");
		        }
		        
	            strVrbDtConteoErrores =  "SELECT  DISTINCT(INDICE) FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
	            		 strFuncionalidad + "' AND CICLO like '" + strCiclo  + "' AND VERSION = '" + strVersion + 
	            		 "' AND INDICE IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE DET.INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
	            		 strFuncionalidad + "' ) AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + strCiclo  + 
	            		 "' AND DET.VERSION = '" + strVersion + "')) ORDER BY INDICE";
		 	       
	            Statement stmtstrVrbDtDistinctConteoErrores = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            Mdl_Variables.Grst_Evidencia = stmtstrVrbDtDistinctConteoErrores.executeQuery(strVrbDtConteoErrores); 
		        
	          	prWrFileScreen.println("<TR><TD><b>TOTAL <a href='#CASOS ERRADOS'> CASOS ERRADOS</a></TD><TD>" + intVrbConteoErrores + "</b></TD></TR>");
	        	prWrFileScreen.println("<TR><TD><b>DETALLE</b></TD><TD>");
	        	        
	        	intPosicion = 0;
	        	m = 1;
		        
		        while (Mdl_Variables.Grst_Evidencia.next())
		        {
		        	if (intPosicion == intVrbConteoErrores - 1)
		        	{
		        		prWrFileScreen.println("<a href='#CASOS " + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "'>" + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "</a>");
		        	}   
		            else
		            {
		            	prWrFileScreen.println("<a href='#CASOS " + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "'>" + Mdl_Variables.Grst_Evidencia.getString("INDICE") + "</a> ,");
		                intPosicion = intPosicion + 1;
		            }
		                   
		        	if (m % 20 == 0) 
		            {
		            	prWrFileScreen.println("<br>");
		            	m = m + 1;  
		            }              
		        }
		        
		        Mdl_Variables.Grst_Evidencia.close();
		        
		        
		        strVrbTotalTiempos = "SELECT DISTINCT(INDICE) FROM TBL_LOG_DETALLE  WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
		        		strFuncionalidad+ "') AND VERSION ='" + strVersion + "'  AND CICLO like '" +
		        		strCiclo + "' ORDER BY INDICE";
	            Statement stmtstrVrbTotalTiempos = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            Mdl_Variables.Grst_LogDetalleIndice = stmtstrVrbTotalTiempos.executeQuery(strVrbTotalTiempos); 
		        
		        
		        while (Mdl_Variables.Grst_LogDetalleIndice.next())
		        {
		        	intIndice = Integer.parseInt(Mdl_Variables.Grst_LogDetalleIndice.getString("INDICE"));
		        	
		        	strVrbTotalTiempos = "SELECT MAX(TIEMPO_EJECUCION_CASO) AS TIEMPO_CASO FROM TBL_LOG_DETALLE  WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + 
		        			strFuncionalidad+ "') AND VERSION ='" + strVersion + "' AND CICLO like '" + 
		        			strCiclo  + "' AND INDICE = " + intIndice + "";			        	
		            Statement stmtstrVrbTotalTiempos1 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		            Mdl_Variables.Grst_Evidencia = stmtstrVrbTotalTiempos1.executeQuery(strVrbTotalTiempos); 
		        	
		        	if (Mdl_Variables.Grst_Evidencia.next())
			        {
		        		intTiempoTotalEscenario = intTiempoTotalEscenario + Integer.parseInt(Mdl_Variables.Grst_Evidencia.getString("TIEMPO_CASO"));
			        }
		        	Mdl_Variables.Grst_Evidencia.close();
		                   
		        }
	        	        
		        Mdl_Variables.Grst_LogDetalleIndice.close();
		        
		        if (intTiempoTotalEscenario == 0)
		        {
		        	prWrFileScreen.println("<TR><TD><b>TOTAL TIEMPO EJECUCIÓN:</b></TD><TD> 0h 0m 0s </TD></TR>");
		        }    
		        else
		        {
		        	prWrFileScreen.println("<TR><TD><b>TOTAL TIEMPO EJECUCIÓN:</b></TD><TD>" + String.valueOf((intTiempoTotalEscenario / 3600)) + "h" + String.valueOf((intTiempoTotalEscenario % 3600) / 60) + "m" + String.valueOf((intTiempoTotalEscenario % 3600) % 60) + "s" + "</TD></TR>");
		        }
		                
		        if (strFuncionalidad.toUpperCase() != "MIGRACION") 
		        {
		        	prWrFileScreen.println("<TR ALIGN=CENTER><TD COLSPAN=2><b>");
		            prWrFileScreen.println("<TABLE border='1'>");
		            prWrFileScreen.println("<TD><a href='#' onClick=\"mostrarImagenes(true);\">Mostrar Imagenes</a><TD> ");
		            prWrFileScreen.println("<TD><a href='#' onClick=\"ocultarImagenes(true);\">Ocultar Imagenes</a><TD> ");
		            prWrFileScreen.println("<TD><a href='#' onClick=\"MostrarTImagenes(true);\">Agrandar Imagenes</a><TD> ");
		            prWrFileScreen.println("<TD><a href='#' onClick=\"ImagenesP(true);\">Imagenes Normales</a><TD> ");
		            prWrFileScreen.println("</TABLE></b></TD></TR>");
		            prWrFileScreen.println("<br><br>");
		        }
		        
		        //'****************************************************************
		        //'*      Script para ingresar los mensajes de Acierto            *
		        //'****************************************************************

		        
		        strVrbDtConteoAciertos = "SELECT  DISTINCT(INDICE), MAX(TIEMPO_EJECUCION_CASO) AS TIEMPO_CASO  FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' AND CICLO like '" + strCiclo + "' AND VERSION = '" + strVersion + "'AND INDICE NOT IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE DET.INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' ) AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + strCiclo + "' AND DET.VERSION = '" + strVersion + "')) GROUP BY INDICE ORDER BY INDICE ";
	        	Statement stmtstrVrbDtConteoAciertos2 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            Mdl_Variables.Grst_LogDetalleIndice = stmtstrVrbDtConteoAciertos2.executeQuery(strVrbDtConteoAciertos); 
	        	
	        	if (intVrbConteoAciertos != 0)
	        	{		        		
	        		prWrFileScreen.println("<TABLE  WIDTH='1024px'><TR WIDTH='1024px' > <TD WIDTH='100%' VALIGN='CENTER' ALIGN='CENTER' BGCOLOR='#00CC00'><H3><FONT FACE='verdana' ><a name='CASOS ACIERTOS'>CASOS ACIERTOS</a></FONT></H3></TD></TR></TABLE>");
	        	}
		        
		        //--
	        	while (Mdl_Variables.Grst_LogDetalleIndice.next())
		        {
		        	intIndice = Integer.parseInt(Mdl_Variables.Grst_LogDetalleIndice.getString("INDICE"));
		        	prWrFileScreen.println("<TABLE  WIDTH='1024px'><TR WIDTH='1024px' > <TD WIDTH='100%' VALIGN='CENTER' ALIGN='CENTER' BGCOLOR='#C6E0B4'><H4><FONT FACE='verdana' ><a name='CASOS " + intIndice + "'> Caso de Prueba N° " + Integer.toString(intIndice) +  "</a></FONT></H4></TD></TR></TABLE>");
		        	
		        	strVrbDtConteoAciertos = "SELECT INDICE, MENSAJE_LOG, IMAGEN, FECHA, RESULTADO FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND INDICE = " + intIndice + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' AND CICLO like '" + strCiclo + "' AND VERSION = '" + strVersion + "'AND INDICE NOT IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE DET.INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' ) AND DET.RESULTADO IN(-1)AND DET.CICLO like '" + strCiclo + "'AND DET.VERSION = '" + strVersion + "')) ORDER BY FECHA ";
	        	    Statement stmtstrVrbDtConteoAciertos3 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		            Mdl_Variables.Grst_Evidencia = stmtstrVrbDtConteoAciertos3.executeQuery(strVrbDtConteoAciertos); 
		        			   			        	
		        	prWrFileScreen.println("<TABLE WIDTH='1024px border='0' class='formatoTexto'  cellpadding='5' cellspacing='0'>");
		            while ( Mdl_Variables.Grst_Evidencia.next())
		            {	
		            	intIndice = Integer.parseInt( Mdl_Variables.Grst_Evidencia.getString("INDICE"));
						if (x == 0){
							strFechaExec =  Mdl_Variables.Grst_Evidencia.getString("FECHA");
						}
						
						prWrFileScreen.println("<TR><TD><p align='center'>");
						
						
						arrValores =  Mdl_Variables.Grst_Evidencia.getString("MENSAJE_LOG").split(strSeparador);
					    for (i = 0; i <= arrValores.length - 1; i++)  {
					    	if (x == 0) {
					    		strPasosHtml = String.valueOf(x + 1) + ". " + arrValores[0] + "<br>";
					    		
					    	} else{
					    		strPasosHtml = String.valueOf(x + 1) + ". " + arrValores[i] + "<br>";
					    	}
					    	prWrFileScreen.println(strPasosHtml); 						    	
					    	x++;
					    }
					    strPasosHtml = "";
					    prWrFileScreen.println("</p>");
	                    prWrFileScreen.println("</TD></TR>");
						
	                    String strImagen1 =".." + "\\CasoPrueba_" + Mdl_Variables.Grst_Evidencia.getString("INDICE") +  Mdl_Variables.Grst_Evidencia.getString("IMAGEN").substring( Mdl_Variables.Grst_Evidencia.getString("IMAGEN").lastIndexOf("1. Imagenes")-1,Mdl_Variables.Grst_Evidencia.getString("IMAGEN").length());
	                    
	                    if (Mdl_Variables.Grst_Evidencia.getInt("RESULTADO") == -1)
						{
							//Marcar Log de Error
	                    	prWrFileScreen.println("<TR><TD><p align='center'> <img name='a" + intContador + "' src='" + strImagen1 + "' align='center' border='1' style='border-color:red' hspace='0' vspace='0' width='250' height='200'>");
						} 
						else
						{
							 prWrFileScreen.println("<TR><TD><p align='center'> <img name='a" + intContador + "' src='" + strImagen1 + "' align='center' border='1' hspace='0' vspace='0' width='250' height='200'>");
						}
						
	                    prWrFileScreen.println("<br>");
	                    prWrFileScreen.println("</TD></TR>");
	                    intContador = intContador + 1;		
					}
	                    
	                prWrFileScreen.println("</p>");
	                prWrFileScreen.println("<br>");
	                prWrFileScreen.println("<TR>");
	                prWrFileScreen.println("<TR><td><br></td></TR>");
	                prWrFileScreen.println("<TD><b><div align=center>INFORMACIÓN CASO DE PRUEBA</b></div>");

	                
		            Statement stmtstrVrbDtConteoAciertos4 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		            String strVrbDescripcionCaso = "SELECT [DESCRIPTION], CASE WHEN ACIERTO_ERROR = '-1' THEN 'POSITIVO' ELSE 'NEGATIVO' END AS TIPO_CASO FROM " + strFuncionalidad + " WHERE ID_CASO = '" + intIndice + "'";
		            Mdl_Variables.Grst_DescripcionEvidencia = stmtstrVrbDtConteoAciertos4.executeQuery(strVrbDescripcionCaso);
		 	        if ( Mdl_Variables.Grst_DescripcionEvidencia.next())
		 	        {
		 	        	prWrFileScreen.println("<b>DESCRIPCIÓN: </b>" +  Mdl_Variables.Grst_DescripcionEvidencia.getString("DESCRIPTION"));
		 	        	prWrFileScreen.println("<br>");
	                	prWrFileScreen.println("<b>CASO DE PRUEBA: </b>" +  Mdl_Variables.Grst_DescripcionEvidencia.getString("TIPO_CASO"));
		               
		                prWrFileScreen.println("<br>");
		               
		                prWrFileScreen.println("<b>HORA INICIO EJECUCIÓN: </b>" + strFechaExec);
		                prWrFileScreen.println("<br>");
		                intTiempoExecCaso1 = Integer.parseInt(Mdl_Variables.Grst_LogDetalleIndice.getString("TIEMPO_CASO"));
			            prWrFileScreen.println("<b>TIEMPO EJECUCION CASO: </b>" + String.valueOf(intTiempoExecCaso1 / 3600) + "h" + String.valueOf((intTiempoExecCaso1 % 3600) / 60)  + "m" + String.valueOf((intTiempoExecCaso1 % 3600) % 60) + "s");
			            prWrFileScreen.println("<br>");
			            prWrFileScreen.println("<b>RESULTADO: </b><font color='blue'>Exitoso</font>");
		 	        }
		 	        Mdl_Variables.Grst_DescripcionEvidencia.close();
		 	        prWrFileScreen.println("<TR><td><br><br></td></TR>");
		 	        prWrFileScreen.println("</td>");
		            prWrFileScreen.println("</tr>");
		            prWrFileScreen.println("</table>");
		            prWrFileScreen.println("</div>");
		            Mdl_Variables.Grst_Evidencia.close();
		            x = 0;
		           
		        }

		        prWrFileScreen.println("<br>");
		        prWrFileScreen.println("<br>");
		        prWrFileScreen.println("<br>");
		        
		        
		        //'****************************************************************
		        //'*      Script para ingresar los mensajes de Error              *
		        //'****************************************************************
		        
		        strVrbDtConteoErrores = "SELECT  DISTINCT(INDICE), MAX(TIEMPO_EJECUCION_CASO) AS TIEMPO_CASO FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' AND CICLO like '" + strCiclo + "' AND VERSION = '" + strVersion + "'AND INDICE IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE DET.INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' ) AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + strCiclo + "' AND DET.VERSION = '" + strVersion + "')) GROUP BY INDICE ORDER BY INDICE ";
		        Statement stmtstrVrbDtConteoErrores2 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        Mdl_Variables.Grst_LogDetalleIndice = stmtstrVrbDtConteoErrores2.executeQuery(strVrbDtConteoErrores);
	        	
		        if (intVrbConteoErrores != 0)
	        	{
		        	prWrFileScreen.println("<TABLE  WIDTH='1024px'><TR WIDTH='1024px' > <TD WIDTH='100%' VALIGN='CENTER' ALIGN='CENTER' BGCOLOR=red><H3><FONT FACE='verdana' ><a name='CASOS ERRADOS'>CASOS ERRADOS</a></FONT></H3></TD></TR></TABLE>");
	        	}
		        
		        while (Mdl_Variables.Grst_LogDetalleIndice .next())
		        {
		        	 intIndice = Integer.parseInt(Mdl_Variables.Grst_LogDetalleIndice .getString("INDICE"));
		        	 prWrFileScreen.println("<TABLE  WIDTH='1024px'><TR WIDTH='1024px' > <TD WIDTH='100%' VALIGN='CENTER' ALIGN='CENTER' BGCOLOR='#F8CBAD'><H4><FONT FACE='verdana' ><a name='CASOS " + intIndice + "'> Caso de Prueba N° " + Integer.toString(intIndice) +  "</a></FONT></H4></TD></TR></TABLE>");
		        	 
		        	 strVrbDtConteoErrores = "SELECT INDICE, MENSAJE_LOG, IMAGEN, FECHA, RESULTADO FROM TBL_LOG_DETALLE WHERE INDICE_SCHEDULE = " + intIndiceSched + " AND INDICE = " + intIndice + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' AND CICLO like '" + strCiclo + "' AND VERSION = '" + strVersion + "'AND INDICE IN (SELECT INDICE FROM TBL_LOG_DETALLE DET WHERE DET.INDICE_SCHEDULE = " + intIndiceSched + " AND ID_MAESTRO IN (SELECT ID_MAESTRO FROM TBL_LOG_MAESTRO WHERE NOMBRE_TABLA like '" + strFuncionalidad + "' )AND DET.RESULTADO IN(-1) AND DET.CICLO like '" + strCiclo + "'AND DET.VERSION = '" + strVersion + "')) ORDER BY FECHA ";
			         Statement stmtstrVrbDtConteoErrores3 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        	 Mdl_Variables.Grst_Evidencia = stmtstrVrbDtConteoErrores3.executeQuery(strVrbDtConteoErrores);
		 	        
					 prWrFileScreen.println("<TABLE WIDTH='1024px border='0' class='formatoTexto'  cellpadding='5' cellspacing='0'>");
					 while (Mdl_Variables.Grst_Evidencia.next()) {
						intIndice = Integer.parseInt(Mdl_Variables.Grst_Evidencia.getString("INDICE"));
						if (x == 0){
							strFechaExec = Mdl_Variables.Grst_Evidencia.getString("FECHA");
						}
						
						prWrFileScreen.println("<TR><TD><p align='center'>");
						arrValores = Mdl_Variables.Grst_Evidencia.getString("MENSAJE_LOG").split(strSeparador);
					    for (i = 0; i <= arrValores.length - 1; i++){
					    	if (x == 0) {
					    		strPasosHtml = String.valueOf(x + 1) + ". " + arrValores[0] + "<br>";
					    	} else{
					    		strPasosHtml = String.valueOf(x + 1) + ". " + arrValores[i] + "<br>";
					    	}
					    	prWrFileScreen.println(strPasosHtml);
					    	x++;
					    }
					    strPasosHtml = "";
					    prWrFileScreen.println("</p>");

	                    prWrFileScreen.println("</TD></TR>");
	                    
	                    String strImagen =".." +  "\\CasoPrueba_" + Mdl_Variables.Grst_Evidencia.getString("INDICE") +  Mdl_Variables.Grst_Evidencia.getString("IMAGEN").substring( Mdl_Variables.Grst_Evidencia.getString("IMAGEN").lastIndexOf("1. Imagenes")-1,Mdl_Variables.Grst_Evidencia.getString("IMAGEN").length());
	                    
	                    if (Mdl_Variables.Grst_Evidencia.getInt("RESULTADO") == -1){
							//Marcar Log de Error
	                    	 prWrFileScreen.println("<TR><TD><p align='center'> <img name='a" + intContador + "' src='" + strImagen + "' align='center' border='1' style='border-color:red' hspace='0' vspace='0' width='250' height='200'>"); 
						}else{
							prWrFileScreen.println("<TR><TD><p align='center'> <img name='a" + intContador + "' src='" + strImagen + "' align='center' border='1' hspace='0' vspace='0' width='250' height='200'>");
						}
	                    prWrFileScreen.println("<br>");
	                    prWrFileScreen.println("</TD></TR>");
	                    intContador = intContador + 1;
					 }
	                    
	                prWrFileScreen.println("</p>");
	                prWrFileScreen.println("<br>");
	                prWrFileScreen.println("<TR>");
	                prWrFileScreen.println("<TR><td><br></td></TR>");
	                prWrFileScreen.println("<TD><b><div align=center>INFORMACIÓN CASO DE PRUEBA</b></div>");
	                
	                Statement stmtstrVrbDtConteoErrores4 = Mdl_Variables.Gcnn_Conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        //*************WMN*-******* Se modifica querie
		            String strVrbDescripcionCaso2 = "SELECT [DESCRIPTION], CASE WHEN ACIERTO_ERROR = '-1' THEN 'POSITIVO' ELSE 'NEGATIVO' END AS TIPO_CASO FROM " + strFuncionalidad + " WHERE ID_CASO = '" + intIndice + "'";
		            
		            Mdl_Variables.Grst_DescripcionEvidencia = stmtstrVrbDtConteoErrores4.executeQuery(strVrbDescripcionCaso2);
		 	        if (Mdl_Variables.Grst_DescripcionEvidencia.next())
		 	        {
		 	        	prWrFileScreen.println("<b>DESCRIPCIÓN: </b>" + Mdl_Variables.Grst_DescripcionEvidencia.getString("DESCRIPTION"));
		 	        	prWrFileScreen.println("<br>");
	                	prWrFileScreen.println("<b>CASO DE PRUEBA: </b>" + Mdl_Variables.Grst_DescripcionEvidencia.getString("TIPO_CASO"));
		               
		                prWrFileScreen.println("<br>");
		                
		               
		                prWrFileScreen.println("<b>HORA INICIO EJECUCIÓN: </b>" + strFechaExec);
		                prWrFileScreen.println("<br>");
		                intTiempoExecCaso1 = Integer.parseInt(Mdl_Variables.Grst_LogDetalleIndice.getString("TIEMPO_CASO"));
			            prWrFileScreen.println("<b>TIEMPO EJECUCION CASO: </b>" + String.valueOf(intTiempoExecCaso1 / 3600) + "h" + String.valueOf((intTiempoExecCaso1 % 3600) / 60)  + "m" + String.valueOf((intTiempoExecCaso1 % 3600) % 60) + "s");
			            prWrFileScreen.println("<br>");
			            prWrFileScreen.println("<b>RESULTADO: </b><font color='red'>Fallido</font>");
		           }
		 	        Mdl_Variables.Grst_DescripcionEvidencia.close();
		 	       
		 	       	prWrFileScreen.println("<TR><td><br><br></td></TR>");
		 	       	prWrFileScreen.println("</td>");
	                prWrFileScreen.println("</tr>");
	                prWrFileScreen.println("</table>");
	                prWrFileScreen.println("</div>");
	                Mdl_Variables.Grst_Evidencia.close();
	                x = 0;
		        }     
		        
		        prWrFileScreen.println("</body></html>");
	    		prWrFileScreen.close();
			}catch (Exception e){
	        	prWrFileScreen.println(e.getMessage());
	        }
			
			prWrFileScreen.println("</body></html>");
			prWrFileScreen.close();
		}

		
		
			public static String evidenciaPasosEvd2(String strCadenaPasos2) {
				
				String strPasos  = "";
				String arrValores[];
				int i;
		   
				try{
				    if (strCadenaPasos2 == "") {
				    	return "";
				    } else {
				    	
					   String temp = "\\|\\>\\.\\<\\|";
					    
					    arrValores = strCadenaPasos2.split(temp);
					    for (i = 0; i <= arrValores.length - 1; i++) {
					    	if (i == 0) {
					    		strPasos = "<TR><TD>" + String.valueOf(i + 1) + ". " + arrValores[0] + "</TD></TR>";
					    	}else{
					    		strPasos = strPasos + "<TR><TD>" + String.valueOf(i + 1) + ". " + arrValores[i] + "</TD></TR>";
					    	}
					    }
				    }
				    
				}
				catch (Exception e) 
				{
					System.out.println(e.getMessage());
					
				}
				return strPasos;
			      
			    
			    
			}
		


	public void reset()
	{
		intVar = 1;
	}

	public static boolean scrollCapturaPantalla2() {
		boolean bandera =false;
		
		int intNumEntero;
		//----Capturar Dimension de la pantalla
		Dimension initialSize = Mdl_Variables.Gwed_Driver.manage().window().getSize();
	    int height = initialSize.getHeight();
	    //----Capturar Tamaño Total de la pagina con scroll
	    WebElement element = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[1]/div[1]"));
	    
	    Long alto1 = (Long) ((JavascriptExecutor) Mdl_Variables.Gwed_Driver).executeScript("return arguments[0].scrollHeight;", element);
	    int alto  =alto1.intValue();
	    int intNumero=0;
	    double dobResultado=alto/height;
	    JavascriptExecutor jse = (JavascriptExecutor) Mdl_Variables.Gwed_Driver;
	    int intResTotal=0;
	    try {
	    intNumero= alto%height;
	    if(intNumero!=0){
	    	intNumEntero= (int)(dobResultado*2)+1;
	    }else{
	    	intNumEntero= (int)dobResultado*2;
	    }
	   
		for(int i=1;i<=intNumEntero;i++){
			if(i==1){
				jse.executeScript("window.scrollBy(0,-250)", "");
				Thread.sleep(1500);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			}else{
				intResTotal=intResTotal+height/2;
				jse.executeScript("scroll(0, "+intResTotal+");");	
				Thread.sleep(1500);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			}
			
		}

			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return bandera;
	}
			
}
