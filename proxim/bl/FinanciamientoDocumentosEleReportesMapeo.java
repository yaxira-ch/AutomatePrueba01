package proxim.bl;

import java.io.IOException;

import proxim.be.ObjetosGenerales;


public class FinanciamientoDocumentosEleReportesMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	boolean blnResultado;
	
	public boolean verificarCamposObligatorios(){
		blnResultado=false; 
		
		try {
			blnResultado = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]");
		} catch (Exception e) {
			
		}
		return blnResultado;
	}
	
	public boolean verificarTablaResultado(){	
		boolean bandera=false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[11]/div/div[5]/div/div/table");
			                                                               
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarMensajeCorreo(){	
		boolean bandera=false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
			                                                               
		} catch (Exception e) {
			
		}
		return bandera;
	}
	

	public boolean seleccionarTipoEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/select",LstrProducto);
	}
	
	public boolean seleccionarTipoServicio(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/select",LstrProducto);
	}
	
	public boolean seleccionarTipoReporte(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/select",LstrProducto);
	}
	
	public boolean ingresarFechaReporteDesde(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div/div[1]/input", Descripcion);
	}
	
	public boolean ingresarFechaReporteHasta(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div/div[2]/input", Descripcion);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/a/img");		
	}
	
	
	
	
	
	
	 public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[13]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreo(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	 }
		
	 public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	 }
		
	 public boolean ingresoBotonEnviar() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
 	}
	
	 public boolean ingresoBotonAceptarCorreo() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		

	}
	
	 public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[13]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[13]/div/div[5]/a");		
	 }
	 	
	 public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[13]/div/div[6]/a");		
	 }
}
