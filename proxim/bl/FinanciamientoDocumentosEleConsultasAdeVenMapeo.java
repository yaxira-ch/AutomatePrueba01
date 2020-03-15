package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleConsultasAdeVenMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	
	String xpathMenu="//html/body/div[2]/div[2]/div/ul/li[7]/a/span";
	String xpathSubMenu="//html/body/div[2]/div[2]/div/ul/li[7]/div/div/ul/li[1]/div/ul/li[3]/a/span";
	String xpathExitMenu="//html/body/div[2]/div[1]/div[2]/div[2]/ul/li";
	String xpathEmpresa="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select";
	String xpathProducto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select";
	String xpathSituacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/select";
	String xpathProveedor="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div/table/tbody/tr[1]/td/input";
	String xpathTipoBusqueda="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/select";
	String xpathFechaDesde="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[1]/input";
	String xpathFechaHasta="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[2]/input";
	//String xpathBuscar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a";
	String xpathBuscar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img";
	String xpathTablaResultado="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[5]/div/div/table";
	String xpathLinkEnviarCorreo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[1]/a";
	String xpathTxtCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input";
	String xpathTxtMensajeCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea";
	String xpathBtnEnviarCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img";
	String xpathPopUpCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]";
	String xpathBtnAceptarCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img";
	String xpathLinkExportarExcel="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[4]/a";
	String xpathLinkExportarPDF="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[5]/a";
	String xpathLinkImprimir="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[6]/a";
	
	
	public boolean salirMenu() throws InterruptedException, IOException{		
		return objObjetosGenerales.moveToElement(xpathExitMenu);
	}

	public boolean seleccionarEmpresa(String empresa) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, xpathEmpresa,empresa);
	}

	public boolean seleccionarProducto(String producto) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, xpathProducto,producto);
	}

	public boolean seleccionarSituacion(String situacion) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, xpathSituacion,situacion);
	}

	public boolean ingresarProveedor(String proveedor) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathProveedor , proveedor);
	}

	public boolean seleccionarTipoBusqueda(String tipoBusqueda) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, xpathTipoBusqueda,tipoBusqueda);
	}

	public boolean ingresarFechaDesde(String fechaDesde) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathFechaDesde , fechaDesde);
	}

	public boolean ingresarFechaHasta(String fechaHasta) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathFechaHasta , fechaHasta);
	}

	public boolean buscar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBuscar);
	}
	
	public boolean buscarNumeroInterno() throws InterruptedException, IOException{
		Boolean blnResultado;
		String strCadena="Nro. Interno";
		String strTexto=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[5]/div/div/table/thead/tr/th[9]");
		
		blnResultado=objFuncionesGenerales.buscarCadena(strCadena, strTexto);
		
		return blnResultado;

	}
	
	public String buscarNullNumeroInterno() throws InterruptedException, IOException{
		boolean caso=true;
		WebElement tabla=null;
		List<WebElement> num=null;
		
		
		//int intColumna=9;
		String strPathPagina = "";
		tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/div/div[5]/div/div/table"));


		String strTexto;
		String nuevaCadena="";
		String strCadena="";
		boolean booleanLink=false;
		int j=2;	
		while(caso){
			
			
			num=tabla.findElements(By.xpath(".//tr"));
			int numero=num.size()-2;
			for (int k = 1;k<=numero;k++)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+k+"]/td")));
				strTexto = colss.get(8).getText();
				if(objFuncionesGenerales.buscarCadena(strTexto,strCadena))
				{	
					nuevaCadena+="; Numero Interno:"+colss.get(8).getText();
				}
			}	
			
			booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
			if (j==2){
				j=+2;
			}
						
			if(booleanLink){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
			}else{
				caso=false;
				
			}
		}
		
		return nuevaCadena;		
	}
	
	
	public boolean verificarTablaResultado(){	
		boolean bandera=false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, xpathTablaResultado);
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLinkEnviarCorreo);		
	}
	 
	public boolean ingresarCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, xpathTxtCorreo, Descripcion);
	}
			
	public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, xpathTxtMensajeCorreo, Descripcion);
	}
			
	public boolean ingresoBotonEnviar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnEnviarCorreo);		
	}
	 
	public boolean ingresoBotonAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnAceptarCorreo);		
	}
		
	public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLinkExportarExcel);		
	}
	 
	public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLinkExportarPDF);		
	}
	 
	public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLinkImprimir);		
	}
	
	public boolean verificarPopUpEnvioCorreo(){	
		boolean bandera=false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, xpathPopUpCorreo);
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
}
