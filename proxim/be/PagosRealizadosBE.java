package proxim.be;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.bl.CapturarPantalla;
import proxim.dao.Mdl_Variables;


public class PagosRealizadosBE {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	boolean bandera;
	
	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[3]/table/tbody/tr/td[2]/select",strEmpresa);
	}
	public boolean verificarProducto(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[1]/tbody/tr/td[2]/select");
		} catch (Exception e) {
			
		}
		return bandera; 
	}
	public boolean seleccionarProducto(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[1]/tbody/tr/td[2]/select",strProducto);
	}
	public boolean seleccionarServicio(String strServicio) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[2]/tbody/tr/td[2]/select",strServicio);
	}
	public boolean seleccionarEstadoPago(String strEstado) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[3]/tbody/tr/td[2]/select",strEstado);
	}
	public boolean ingresarFechaProcesoDesde(String strFecha) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[4]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input",strFecha);
	}
	public boolean ingresarFechaProcesoHasta(String strFecha) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[4]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input",strFecha);
	}
	
	public boolean comboVerificarCanal() throws InterruptedException, IOException { 
		boolean blnComboCanal=false;
		boolean blnNombreCanal=false;
		boolean blnResultadoFinal=false;
		blnComboCanal=objObjetosGenerales.visibleElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[5]/tbody/tr/td[2]/select");
		String lbnCanal=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='pasoCanal']/span[3]");
		if(lbnCanal.equals("Canal de Envío")){
			blnNombreCanal=true;
		}
		if(blnComboCanal==true&&blnNombreCanal==true){
			blnResultadoFinal=true;
		}
		return blnResultadoFinal;
	}
	
	public boolean seleccionarCanalEnvio(String strCanalEnvio) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[5]/tbody/tr/td[2]/select",strCanalEnvio);
	}
	
	public boolean ingresoBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/a/img");
	}
	
	public boolean ingresoBuscarDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/a/img");
	}
	
	public boolean verificarTablaRealizados(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[5]/div/div[5]/div/div/table");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean ingresoOpcionesAvanzadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[4]/a");
	}
	public boolean ingresoTipoBusqueda(String strOpcion) throws InterruptedException, IOException{	
		boolean bResp = false;
		switch(strOpcion)
		{
			case "Por Persona":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[1]/span/input");
				break;
			case "Por Documento":
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[2]/span/input");
				break;
			default:
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[1]/span/input");
				break;
		}
		return bResp;	
	}
	public boolean seleccionarTipoDocumentoIdentidad(String strTipoDoc) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[9]/tbody/tr/td[2]/table/tbody/tr/td[1]/select",strTipoDoc);
	}
	public boolean ingresarNumeroDocIdentidad(String strNumero) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[9]/tbody/tr/td[2]/table/tbody/tr/td[2]/input",strNumero);
	}
	public boolean ingresarFechaDocPago(String strFecha) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[7]/tbody/tr/td[2]/table/tbody/tr/td/div/div/input",strFecha);
	}
	public boolean seleccionarTipoDocumentoPago(String strTipoDoc) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[8]/tbody/tr/td[2]/select",strTipoDoc);
	}
	public boolean ingresarNumeroDocAfiliado(String strNumero) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/table[8]/tbody/tr/td[3]/input",strNumero);
	}
	public boolean verificarTablaResultados(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[5]/div/div[5]/div/div/table");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	public boolean obtenerRegistroBuscado(String strProducto, String strCodigo, String strTipoAbono, String strNumeroCuenta, 
			String strMonedaOper, String strMonto, String strFecha, String strEstado,String strtxtNumeroCuenta) throws InterruptedException, IOException
	{
		int reg = 0;
		boolean bEncontrado = false;
		String NumeroCuenta;
		//---------Numero de Columnas de Tabla------
		int nColCod = 1,nColTipAbon = 3;
		int nColNroCta = 5,nColMoneda = 6,nColFecha = 8,nColestado = 9;
		
		if(strProducto.equals("Pago de Remuneraciones")||strProducto.equals("Pago de CTS"))	{
			nColNroCta = 4;nColMoneda = 5;nColFecha = 7;nColestado = 8;
		}
		//-------------------------------------------------------
		if(strNumeroCuenta.equals("<IGNORE>")){
			NumeroCuenta= strtxtNumeroCuenta.subSequence(0, 3)+"-"+strtxtNumeroCuenta.subSequence(3, strtxtNumeroCuenta.length());
		}else{
			NumeroCuenta=strNumeroCuenta.subSequence(0, 3)+"-"+strNumeroCuenta.subSequence(3, strNumeroCuenta.length());
		}
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size();
		numero = numero -2;
		for (int j = 1;j<= numero;j++)
		{ 
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if(colss.get(nColCod).getText().equals(strCodigo)
					&& colss.get(nColTipAbon).getText().equals(strTipoAbono)
					&&colss.get(nColNroCta).getText().equals(NumeroCuenta)
					&&colss.get(nColMoneda).getText().equals(strMonedaOper)
					//&&colss.get(nColMonto).getText().equals(strMonto)
					&&colss.get(nColFecha).getText().equals(strFecha)
					&&colss.get(nColestado).getText().equals(strEstado)){
						bEncontrado = true;
						reg = j;
			}
			
			if(bEncontrado){
				//colss.get(reg).click();
				
				if(numero==1){
					 objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
						
				}else{
					 objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr["+reg+"]/td[1]/div/div/a");
				}
				verificarDetallePagoRealizado();
				CapturarPantalla.scrollCapturaPantalla();
				ingresoRegresar();
				break;
			}
		}
		
		
		return bEncontrado;
		
	}
	
	public boolean verificarDetallePagoRealizado(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/span[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	public boolean ingresoRegresar() {		
		boolean bRegresar = false;
		try {
			bRegresar =  objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div[4]/a");
		} catch (Exception e) {
	
		}
		return bRegresar;
	}

}
