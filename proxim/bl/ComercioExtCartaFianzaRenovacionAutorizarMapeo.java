package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ComercioExtCartaFianzaGeneralBE;
import proxim.be.ComercioExtCartaFianzaRenovacionAutorizarBE;
import proxim.be.ComercioExtCartaFianzaRenovacionBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaRenovacionAutorizarMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera=false;

	public boolean seleccionarMenu(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.moveToElement("//ul[@class='mega-menu']/li[5]/a//span");
	}

	public boolean seleccionarSubMenu(String LstrProducto) throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[2]/div/ul/li[6]/div/div/ul/li[3]/div/ul/li[2]/a/span");	
	}

	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorTabs']/li["+i+"]//a")).getText();

			if(LstrProducto.equals(valor) ){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
				break;
			}
		}	
		return var;	
	}

	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException
	{	
		String  strValorBoton = "";
		String  strClave = Lstr_Clave;
		String  strLetraValor = "";
		Thread.sleep(500);
		for (int i = 1;i<=strClave.length();i++)
		{
			strLetraValor = strClave.split("")[i - 1];
			Thread.sleep(500);
			for (int j = 1; j <= 10; j++)
			{
				strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).getText();

				if (strValorBoton.equals(strLetraValor))
				{
					Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
					Thread.sleep(500);
					break;
				}
			}
		}
		return true;
	}	

	//---------------------------------------------------------AUTORIZAR------------------------------------------------------------------

	public boolean verificarEnvioCamposObligatoriosAutorizar() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}

	public boolean seleccionarEmpresaAutorizacion(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"/" ,LstrProducto);
	}

	public boolean ingresarFechaInicioAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/input", Descripcion);
	}

	public boolean ingresarFechaFinAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[2]/input", Descripcion);
	}

	public boolean seleccionarTipoOperacionAutorizacion(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",LstrProducto);
	}

	public boolean ingresoBotonBuscarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/img");
	}

	public boolean ingresoLinkVerSolicitudesExpiradosAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/a");
	}

	public boolean ingresoLinkRegresarSolicitudesExpiradosAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[3]/a");
	}

	public boolean ingresoLinkEnviarEmailAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[1]/a");		
	}

	public boolean verificarTablaCorreo() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div");
	}

	public boolean ingresarCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}

	public boolean ingresarMensajeCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}

	public boolean ingresoBotonEnviarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	}

	public boolean ingresoBotonAceptarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");	
	}

	public boolean ingresoLinkExportarExcelAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[4]/a");		
	}

	public boolean ingresoLinkExportarPDFAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[5]/a");		
	}

	public boolean ingresoLinkImprimirAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[6]/a");		
	}

	public boolean ingresoChkTodosAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/thead/tr/th[1]/input");
	}

	public boolean verificarTablaAutorizacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table");
	}

	public boolean verificarDetalleLoteEnviarAutorizacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]");
	}

	public boolean ingresoBotonAutorizarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/a[1]/div");
	}

	public boolean ingresoBotonBloquearAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/a[2]/div");
	}

	public boolean ingresoLinkVerOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
	}
	public boolean regresarVerOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div[1]/a");
	}


	public boolean seleccionarLoteFirmar() throws InterruptedException, IOException{	
		boolean var=false;
		try {

			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));

			String beneficiarioBD="";

			if(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.length()>25){
				beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.substring(0,24);
			}else{
				beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO;
			}

			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));

				if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					String beneficiarioTabla="";

					if(colss.get(4).getText().length()>25){
						beneficiarioTabla=colss.get(4).getText().substring(0,24);
					}else{
						beneficiarioTabla=colss.get(4).getText();
					}
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)&&
							beneficiarioTabla.equals(beneficiarioBD)&&
							colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&
							colss.get(6).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO)&&
							colss.get(7).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO)&&
							colss.get(8).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrCMB_TIPO_OPERACION)){
						var=true;												
					
						
					}
				}else{
					String beneficiarioTabla="";

					if(colss.get(3).getText().length()>25){
						beneficiarioTabla=colss.get(3).getText().substring(0,24);
					}else{
						beneficiarioTabla=colss.get(3).getText();
					}

					if (beneficiarioTabla.equals(beneficiarioBD)&&
							colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&
							colss.get(5).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO)&&
							colss.get(7).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrCMB_TIPO_OPERACION )){
						var=true;											
					}
				}
				if(var){
					colss.get(0).click();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			var=false;
		}
		return var;
	}

	public boolean verDetalleLoteFirmar() throws InterruptedException, IOException
	{	
		boolean var=false;
		try {

			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));

			String beneficiarioBD="";

			if(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.length()>25){
				beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.substring(0,24);
			}else{
				beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO;
			}

			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));

				if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					String beneficiarioTabla="";

					if(colss.get(4).getText().length()>25){
						beneficiarioTabla=colss.get(4).getText().substring(0,24);
					}else{
						beneficiarioTabla=colss.get(4).getText();
					}
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){//Empresa					
						if (colss.get(3).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_FECHA)){//Producto
							if ( beneficiarioTabla.equals(beneficiarioBD)){//Compara NOMBRE PLANILLA
								if (colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){//Compara MONTO TOTAL
									if (colss.get(6).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO)){//Producto
										if (colss.get(7).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO)){//Compara NOMBRE PLANILLA
											if (colss.get(8).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrCMB_TIPO_OPERACION)){//Compara MONTO TOTAL
												var=true;												
											}
										}
									}
								}
							}
						}
					}
				}else{
					String beneficiarioTabla="";

					if(colss.get(3).getText().length()>25){
						beneficiarioTabla=colss.get(3).getText().substring(0,24);
					}else{
						beneficiarioTabla=colss.get(3).getText();
					}

					if (colss.get(2).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_FECHA)&&//Producto
						beneficiarioTabla.equals(beneficiarioBD)&&//Compara NOMBRE PLANILLA
						colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
						colss.get(5).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO)&&//Producto
						colss.get(7).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrCMB_TIPO_OPERACION )){//Compara MONTO TOTAL
							var=true;											
					}
				}
				if(var){
					colss.get(1).click();
					break;
				}
			}
		} catch (Exception e) {
			var=false;
		}
		return var;
	}


	public boolean ingresoLinkRegresarDetalleAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/a");		
	}

	public boolean descargarArchivoDescargar() throws InterruptedException, IOException
	{	
		boolean var=false;
		try {

			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));

			String beneficiarioBD="";

			if(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.length()>26){
				beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.substring(0,25);
			}else{
				beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO;
			}

			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));

				if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){

					String beneficiarioTabla="";

					if(colss.get(4).getText().length()>26){
						beneficiarioTabla=colss.get(4).getText().substring(0,25);
					}else{
						beneficiarioTabla=colss.get(4).getText();
					}

					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)&&//Empresa					
						colss.get(3).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_FECHA)&&//Producto
						beneficiarioTabla.equals(beneficiarioBD)&&//Compara NOMBRE PLANILLA
						colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
						colss.get(6).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO)&&//Producto
						colss.get(7).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO)&&//Compara NOMBRE PLANILLA
						colss.get(8).getText().equals("Renovación")){//Compara MONTO TOTAL
						var=true;												
					}
				}else{

					String beneficiarioTabla="";

					if(colss.get(3).getText().length()>26){
						beneficiarioTabla=colss.get(3).getText().substring(0,25);
					}else{
						beneficiarioTabla=colss.get(3).getText();
					}
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_FECHA)&&//Producto
						beneficiarioTabla.equals(beneficiarioBD)&&//Compara NOMBRE PLANILLA
						colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
						colss.get(5).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO)&&//Producto
						colss.get(6).getText().equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO)&&//Compara NOMBRE PLANILLA
						colss.get(7).getText().equals("Renovación" )){//Compara MONTO TOTAL
							var=true;											
					}
				}
				if(var){
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){
						colss.get(9).click();
					}else{
						colss.get(8).click();
					}

					break;
				}
			}
		} catch (Exception e) {
			var=false;
		}
		return var;
	}

	public boolean verificarConfirmarOperacionAutorizacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[2]/span"); 
		} catch (Exception e) {

		}
		return bandera;
	}

	public boolean ingresarClaveDinamicaAutorizacion(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[7]/input",strClaveDinamica);
	}

	public boolean ingresoLinkQuieresSaberComoAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[6]/a");		
	}
	
	public boolean cerrarQuieresSaberComoAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/a");		
	}

	public boolean ingresoBotonConfirmarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[8]/a[1]");
	}

	public boolean ingresoBotonCancelarOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[8]/a[2]");
	}

	public boolean verificarmensajeFinalAutorizar(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/h1");
		} catch (Exception e) {

		}
		return bandera;
	}

	public boolean buscarMensaje(){
		try {
			bandera = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[6]/span");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}

	public boolean compararResultadoEsperadoPositivoAutorizar(String ResultadoEsperado) throws InterruptedException, IOException, SQLException{	
		String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[2]" );  

		if(str_Mensaje.equals(ResultadoEsperado)){
			ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[3]/span[2]" );
			ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[3]/span[4]" );
			ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[3]/span[6]" );

			if(ComercioExtCartaFianzaRenovacionAutorizarBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
				ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[4]/div/div/div[5]/div/div/table/tbody[1]/tr/td[3]/div" );
			}else{
				ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"/" );//cuando es autorizacion GE
			}

			if(buscarMensaje()){
				ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[6]/span" );
			}
			objConexionSqlServer.updateTablaQuery("update APP_COMERCIO_EXT_CARTA_FIANZA_AUTORIZAR_D set LBN_OPERACION='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+ComercioExtCartaFianzaRenovacionAutorizarBE.Gstr_ID_CASO);

			return true;
		}else{
			return false;
		}	
	}

	public boolean ingresoLinkEnviarEmailFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[1]/a");		
	}

	public boolean ingresarCorreoFinalAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}

	public boolean ingresarMensajeCorreoFinalAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}

	public boolean ingresoBotonEnviarFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	}
	
	public boolean ingresoLinkExportarExcelFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[4]/a");		
	}

	public boolean ingresoLinkExportarPDFFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[5]/a");		
	}

	public boolean ingresoLinkImprimirFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[6]/a");		
	}

	public boolean ingresoLinkRealizarOtraOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[3]/div/a");		
	}
	
}
