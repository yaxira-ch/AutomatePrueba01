package proxim.bl;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.PagosRecibosAutorizarBE;
import proxim.be.PagosRecibosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosRecibosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean bandera=false;
	String strResultadoEsperado="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[1]/span";
	String strCadena=".//tr";
	String strTabla="//table[@class='cellTableWidget']";
	
	public boolean verificarPestania(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[1]/div");
	}
	
	public boolean verificarPagoResivos(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean verificarDetallePagosRecibos(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/span[3]");
	}
	
	public boolean verificarContrasenaPagosRecibos(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[9]/div[2]/input");
	}
	
	public boolean seleccionarSubMenu1(String strProducto){	
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorTabs']/li["+i+"]//a")).getText();
			if(strProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
				break;
			}
		}
		return var;			
	}
	
	public boolean seleccionarEmpresa(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean seleccionarEmpresaAutorizar(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean seleccionarEmpresaProcesado(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",strProducto);
	}														              
	
	public boolean seleccionarEmpresaBloqueado(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[1]/table/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean seleccionarCuenta(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/select",strProducto);
	}
		
	public boolean seleccionarTipoBusquedaProcesado(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean seleccionarCuentaCargoBloqueado(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[1]/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean ingresarNombreSolicitud(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/input", strDescripcion);
	}	
	
	public boolean ingresarFechaSolicitudDesdeAutorizar(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarFechaSolicitudHastaAutorizar(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input", strDescripcion);
	}
	
	public boolean ingresarNombreSolicitudProcesado(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr[1]/td/input", strDescripcion);
	}
	
	public boolean ingresarFechaSolicitudDesdeProcesado(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[5]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarFechaSolicitudDesdeBloqueado(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[2]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarFechaSolicitudHastaProcesado(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[5]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input", strDescripcion);
	}
	
	public boolean ingresarFechaSolicitudHastaBloqueado(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[2]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input", strDescripcion);
	}
	
	public boolean seleccionarTipoPago(String strProducto){		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoPagoCombo",strProducto);
	}

	public boolean compararError(String strProducto){	
		boolean blnResultadoEsperado=false;
		 String strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[2]/div[4]/div[1]/div[1]/span")).getText(); 
		 if(strProducto.equals(strMensaje))  {
			 blnResultadoEsperado= true;
		}	
		return blnResultadoEsperado;
	}
	
	public boolean ingresoBotonAceptar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/a");		
	}														           
	
    public boolean verificarPagoRecurrente() 
    {
    	boolean bandera1=true;
		try {
			Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/span[1]"));												
		} catch (Exception e) {
			bandera1 = false;
		}
		return bandera1;
	}
    
	public boolean ingresoBotonBuscar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/a");		
		                                                                
	}
	
	public boolean ingresoBotonBuscarAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
		                                                                
	}
	
	public boolean ingresoLinkEnviarEmailAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[1]/a");		
	}

	public boolean ingresarCorreoAutorizar(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarMensajeCorreoAutorizar(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", strDescripcion);
	}
	
	public boolean ingresoBotonEnviarAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	}

	public boolean ingresoBotonAceptarCorreoAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");	
	}

	public boolean verificarMensajeCorreoAutorizar() { 
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
	}

	 public boolean ingresoLinkExportarExcelAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[6]/a");		
	 }
 
	public boolean verificarTablaAutorizar(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div/div[5]/div/div/table");
	}
	
	public boolean seleccionarLoteAutorizacion(){		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
		List<WebElement> num=tabla.findElements(By.xpath(strCadena));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if(colss.get(2).getText().equals(PagosRecibosBE.GstrLBL_FECHA_OPERACION)&&//fecha 
					(colss.get(4).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)||colss.get(3).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD))){//Nombre de la solicitud
				colss.get(0).click();
				bandera=true;
				break;
			}	
		}
		return bandera;
	}

	public boolean seleccionarVerDetalleAutorizacion(){		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
		List<WebElement> num=tabla.findElements(By.xpath(strCadena));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if(colss.get(2).getText().equals(PagosRecibosBE.GstrLBL_FECHA_OPERACION)&&//fecha 
				(colss.get(4).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)||colss.get(3).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD))){//Nombre de la solicitud
				colss.get(2).click();
				bandera=true;
				break;
			}
		}
		return bandera;
	}
	
	public boolean ingresoLinkEnviarEmailAutorizarDetalle(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[4]/div/div[1]/a");		
	}
	
	public boolean ingresoLinkExportarExcelAutorizarDetalle(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[4]/div/div[4]/a");		
	}
	 
	public boolean ingresoLinkExportarPDFAutorizarDetalle(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[4]/div/div[5]/a");		
	}
	 
	public boolean ingresoLinkImprimirAutorizarDetalle(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[4]/div/div[6]/a");		
	}
 
	public boolean verificarDetalleAutorizar(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/span[1]");
	}
	
	public boolean ingresoLinkRegresarAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/a");                                         
	}
	
	public boolean ingresoBotonAutorizarAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a[1]/div/img");		
	}
	
	public boolean ingresoBotonBloquearAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a[2]/div/img");		
	}
	
	public boolean verificarContrasenaAutorizar(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[4]/div[2]/input");
	}
	
	public boolean verificarResultadoFinalAutorizar(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[1]");
	}
	
	public boolean ingresarClaveDinamicaAutorizar(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[6]/input", strDescripcion);
	}
	
	public boolean ingresoBotonConfirmarAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[7]/a[1]");		
	}
	
	public boolean verificarResultadoFinal(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[1]");
	}
	
	public boolean ingresoBotonCancelarOperacionAutorizar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[7]/a[2]");		
	}
	
	 public boolean compararResultadoEsperadoAutorizar(String strTxtMensajeError){	
		 String strMensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[1]" );  
		   
		   if(strMensaje.equals(strTxtMensajeError))
		   {
				return true;
		   }else{
			   return false;
		   }	
	   }
	 
	 
	 public boolean ingresoLinkEnviarEmailAutorizarResultadoEsperado(){		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/a");		
	 }

	 public boolean ingresoLinkExportarExcelAutorizarResultadoEsperado(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizarResultadoEsperado(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizarResultadoEsperado(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[6]/a");		
	 }
	//------------------------------------------PROCESADO
	public boolean ingresoBotonBuscarProcesado(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean verificarTablaProcesados(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[5]/div/div/table");
	}
	
	
	public int verificarPagoProcesado(){		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
		List<WebElement> num=tabla.findElements(By.xpath(strCadena));
		int intNum=0;
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (colss.get(1).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)||colss.get(2).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)){//Fecha Solicitud
				bandera=true;
				intNum=j;
				break;
			}
		}
		return intNum;                                                           
	}

	public boolean verificarPagoDetalleProcesado(int intNum){		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
		List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intNum+"]/td")));
		colss.get(0).click();
		return true;                                                            
	}
	
	public boolean ingresoBotonBuscarBloqueado(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/a/img");		
	}
	
	public boolean verificarTablasBloqueados(){
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[2]/div/div[5]/div/div/table");
	}
	
	 public boolean ingresoLinkEnviarEmailBloqueados(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[1]/a");		
	 }

	 public boolean ingresoLinkExportarExcelBloqueados(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFBloqueados(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[5]/a");		
	 }
	 	
	 public boolean ingresoLinkImprimirBloqueados(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[3]/div/div[6]/a");		
	 }	
	 
	 public boolean ingresoLinkEnviarEmailBloqueadosDetalle(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div/div[1]/a");		
	 }

	 public boolean ingresoLinkExportarExcelBloqueadosDetalle(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFBloqueadosDetalle(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div/div[5]/a");		
	 }
	 	
	 public boolean ingresoLinkImprimirBloqueadosDetalle(){		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div/div[6]/a");		
	 }	
	 
	public boolean seleccionarVerDetalleBloqueado(int intResultadoEsperado){		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
		List<WebElement> num=tabla.findElements(By.xpath(strCadena));
		
		//for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intResultadoEsperado+"]/td")));
			
			//if (colss.get(1).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)||colss.get(2).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)){//Fecha Solicitud
				colss.get(0).click();
				bandera=true;
			//	break;
			//}
		//}
		return bandera;
	}
	
	
	public int  verificarExistePago(){		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
		List<WebElement> num=tabla.findElements(By.xpath(strCadena));
		int intResultadoEsperado=0;
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if(colss.get(0).getText().equals(PagosRecibosBE.GstrLBL_FECHA_OPERACION)&&//Fecha de la operacion
			//	colss.get(1).getText().equals(PagosRecibosBE.GstrCMB_EMPRESA)&&//Empresa   
				(colss.get(2).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD)||colss.get(1).getText().equals(PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD))&&//Nombre de la solicitud
				(colss.get(3).getText().equals(PagosRecibosBE.GstrCMB_CUENTA_CARGO)||colss.get(2).getText().equals(PagosRecibosBE.GstrCMB_CUENTA_CARGO))){//Cuenta Cargo
				intResultadoEsperado=j;
				break;
			}
		}
		return intResultadoEsperado;
	}
	
	public boolean ingresoLinkVerDetalleBloqueado(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/a/img");		
	}
	
	public boolean clickCheckTodos(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/div/div/li/table/thead/tr/th[1]/input");		
	}
	
	public boolean clickCheckTodos1(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/div[3]/div/div[8]/div/div[3]/table/thead/tr/th[1]/div/input");
	}

	public boolean clickCheckTodos2(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table/thead/tr/th[1]/div/input");
	}
	
	public boolean ingresoBotonEnviar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a/img");		
	}
	
	public boolean ingresoBotonContinuar(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[10]/a");		
	}
	
	public boolean ingresarClaveDinamica(String strDescripcion) throws InterruptedException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[11]/input", strDescripcion);
	}
	
	public boolean ingresoBotonConfirmar1(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[12]/a[1]");		
	}
	
	
	public boolean ingresoBotonCancelarOperacion(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[12]/a[2]");		
	}
	
	public boolean verificarResultadoEsperado() {
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strResultadoEsperado);
	}
	
   public boolean compararResultadoEsperado(String strTxtMensajeError){	
	   String strMensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,strResultadoEsperado );  
	   boolean blnResultadoEsperado=false;
	   if(strMensaje.equals(strTxtMensajeError)) {
		   blnResultadoEsperado= true;
	   }	
	   return blnResultadoEsperado;
   }
   
	public boolean guardarDatosOperacionAutorizar() throws SQLException {	
		String strHoraOperacion;
		
		PagosRecibosBE.GstrLBL_FECHA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[2]/span[2]" );
		strHoraOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[3]/span[2]" );
		PagosRecibosBE.GstrLBL_MONTO_SOLES=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[6]/span[2]" );
		PagosRecibosBE.GstrLBL_MONTO_DOLARES=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[7]/span[2]" );

		Mdl_Variables.GstrTotalPagar=PagosRecibosBE.GstrLBL_MONTO_SOLES.substring(3)+"-"+PagosRecibosBE.GstrLBL_MONTO_DOLARES.substring(4);
		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[2]/div/div[3]/table"));
		List<WebElement> num=tabla.findElements(By.xpath(strCadena));
		int numero=num.size();
		numero = numero -2;
		String valor="";
		int inicioCadena;
		int i=0;
		Mdl_Variables.Garr_montosBuscar=new String[numero];
		for (int j = 1;j<=numero;j++)
		{ 
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String valorInicial=colss.get(6).getText().substring(0, 2);
			if(valorInicial.contains("/")){
				valor="S/-";
				inicioCadena=3;
			}else{
				valor="US$-";
				inicioCadena=4;
			}
			String cadenaGuardar=valor+colss.get(6).getText().substring(inicioCadena,colss.get(6).getText().length());
			Mdl_Variables.Garr_montosBuscar[i] = cadenaGuardar;
			i=i+1;
		}
			
		bandera= objConexionSqlServer.updateTablaQuery("update APP_PAGOS_RECIBOS_D set LBL_FECHA_OPERACION='"+PagosRecibosBE.GstrLBL_FECHA_OPERACION+"',LBL_HORA_OPERACION='"+strHoraOperacion+"',LBL_MONTO_DOLARES='"+PagosRecibosBE.GstrLBL_MONTO_DOLARES+"',LBL_MONTO_SOLES='"+PagosRecibosBE.GstrLBL_MONTO_SOLES+"' where ID_CASO="+PagosRecibosBE.Gstr_ID_CASO);
		return bandera;
	
	}
	
	public String buscarCadenaTabla(String strCadena, String seccionGrilla){		
		int intColumna=0;
		String strPathPagina = "";
		boolean caso=true;
		WebElement tabla=null;
		List<WebElement> num=null;
		
		switch (seccionGrilla) {
			case "MontoPagarTablaCuotas":
				intColumna=7;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[8]/div/div[3]/table"));
				break;
				
			case "MontoPagarTablaConfirmacion":
				intColumna=6;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[7]/div/div[3]/table"));
				break;
			
			case "MontoPagarTablaResultadoEsperado":
				intColumna=6;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[2]/div/div[3]/table"));
				break;
				
			case "MontoDetalleBloqueado":
				intColumna=3;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div/div[5]/div/div/table"));
				break;
			
			case "MontoPagoDetalleBloqueado":
				intColumna=6;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div/div[5]/div/div/table"));
				break;
			
			case "MontoSolesBloqueado":
				if (PagosRecibosBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
					intColumna=3;
				}else{
					intColumna=4;
				}
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[2]/div/div[5]/div/div/table"));
				break;
			
			case "MontoSolesAutorizar":
				if (PagosRecibosAutorizarBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
					intColumna=5;
				}else{
					intColumna=6;
				}
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div/div[5]/div/div/table"));
				break;
				
			case "MontoPagadoDetalleAutorizar":
				intColumna=6;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[5]/div/div/table"));
				break;
				
			case "MontoSolesAutorizarConfirmar":
				if (PagosRecibosAutorizarBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
					intColumna=3;
				}else{
					intColumna=4;
				}
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[3]/div[2]/div/div[5]/div/div/table"));
				break;
				
			case "MontoSolesAutorizarResultadoEsperado":
				if (PagosRecibosAutorizarBE.GstrCMB_EMPRESA.equals(Mdl_Variables.Gstr_Ignore)){
					intColumna=3;
				}else{
					intColumna=4;
				}
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/div[2]/div[1]/div/div[5]/div/div/table"));
				break;
				
			default:
				
				break;
		}
		String strTexto;
		String nuevaCadena="";
		
		boolean booleanLink=false;
		int j=2;	
		while(caso){
			
			
			num=tabla.findElements(By.xpath(strCadena));
			int numero=num.size()-2;
			for (int k = 1;k<=numero;k++)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+k+"]/td")));
				strTexto = colss.get(intColumna).getText();
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
				{	
					nuevaCadena+="- "+strTexto;
				}
				
			}	
			
			if (seccionGrilla.equals("DetalleMovimientosMonto") || seccionGrilla.equals("DetalleMovimientosSaldoContable") ){
			
				booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
					if (j==2){
						j=+2;
					}
			}else if (seccionGrilla.equals("SaldoDisponibleCuenta")){
				booleanLink=false;
			}else{
				booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
				j=+1;
			}
						
			if(booleanLink){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
			}else{
				caso=false;
				
			}
		}
		
		return nuevaCadena;		
	}
	
	public boolean ingresoLinkEnviarEmailResultadoEsperadoEnvio(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[5]/div[2]/div/div[1]/a");		
 }

 public boolean ingresoLinkExportarExcelResultadoEsperadoEnvio(){		
	return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[5]/div[2]/div/div[4]/a");		
 }
 
 public boolean ingresoLinkExportarPDFResultadoEsperadoEnvio(){		
	return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[5]/div[2]/div/div[5]/a");		
 }
 
 public boolean ingresoLinkImprimirResultadoEsperadoEnvio(){		
	return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[5]/div[2]/div/div[6]/a");		
 }
	 public String[] guardarMonto() {
		 String[] montos =null;
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> num=tabla.findElements(By.xpath(strCadena));
			int numero=num.size();
			numero = numero -2;
			for (int j = 0;j<=numero-1;j++)
			{ 
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				montos[j]=colss.get(6).getText().replace("US$", "").replace("S/", "").trim();
			}
			return montos;
			
		}	


}
